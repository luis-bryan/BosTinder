package modelo;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.*;
import javax.swing.Icon;

import controlador.ControlLectura;

public class Mundo implements Serializable
{

	
	private static final long serialVersionUID = 1L;
	private ArrayList<Persona> usuarios;
	private int numero;
	private Persona aux;
	private int salto;
	private int aux2;
	
	public Mundo() throws ClassNotFoundException, IOException
	{
		//ControlLectura.lecturaInicial();
		usuarios = ControlLectura.lectura();
	}
	
	public void enviarConGMail(String destinatario, String cuerpo)
	{    
	 
		String remitente = "tinderbos";  
	    Properties props = System.getProperties();
	    props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
	    props.put("mail.smtp.user", remitente);
	    props.put("mail.smtp.clave", "bostinder123");    
	    props.put("mail.smtp.auth", "true");    
	    props.put("mail.smtp.starttls.enable", "true"); 
	    props.put("mail.smtp.port", "587"); 
	    Session session = Session.getDefaultInstance(props);
	    MimeMessage message = new MimeMessage(session);

	    try 
	    {
	        message.setFrom(new InternetAddress(remitente));
	        message.addRecipients(Message.RecipientType.TO, destinatario);   
	        message.setSubject("Usuario registrado correctamente en BOSTINDER");
	        message.setText(cuerpo);
	        Transport transport = session.getTransport("smtp");
	        transport.connect("smtp.gmail.com", remitente, "bostinder123");
	        transport.sendMessage(message, message.getAllRecipients());
	        transport.close();
	    }
	    catch (MessagingException me)
	    {
	        me.printStackTrace();   
	    }
	    System.out.println("Enviado");
	}
	
	public Persona buscarUsuario(String usuario)
	{
		if(!usuarios.isEmpty())
		{
			for (int i = 0; i < usuarios.size(); i++) 
			{
				if(usuarios.get(i).getUsuario().equals(usuario))
				{
					return usuarios.get(i);
				}
			}
		}
		return null;
	}
	
	public boolean buscarContraseña(String usuario, String contraseña)
	{
		Persona n = buscarUsuario(usuario);
		if(n!=null)
		{
			if(n.getContraseña().equals(contraseña))
			{
				return true;
			}
			else 
			{
				return false;
			}
		}
		return false;
	}
	
	public void agregarHombre(String nombre, int id, String apellido1, String apellido2, char sexo, String usuario,
			String contraseña, String correo, String fechaNacimiento, double pIngresos, double pEstatura) throws IOException
	{
		Persona nueva = buscarUsuario(usuario);
		if(nueva == null)
		{
			nueva = new Hombre(nombre, id, apellido1, apellido2, sexo, usuario, contraseña, correo, fechaNacimiento, pIngresos, pEstatura);
			usuarios.add(nueva);
			ControlLectura.escritura(usuarios);
		}
	}
	
	public void agregarMujer(String nombre, int id, String apellido1, String apellido2, char sexo, String usuario,
			String contraseña, String correo, String fechaNacimiento, boolean pDivorcios) throws IOException
	{
		Persona nueva = buscarUsuario(usuario);
		if(nueva == null)
		{
			nueva = new Mujer(nombre, id, apellido1, apellido2, sexo, usuario, contraseña, correo, fechaNacimiento, pDivorcios);
			usuarios.add(nueva);
			ControlLectura.escritura(usuarios);
		}
	}
	
	public void Modificar(String nombre, String usuario, String apellido1, String apellido2, String contraseña, char estado)
	{
		Persona modificar = buscarUsuario(usuario);
		if(modificar!=null)
		{
			modificar.setNombre(nombre);
			modificar.setApellido1(apellido1);
			modificar.setApellido2(apellido2);
			modificar.setContraseña(contraseña);
			modificar.setEstado(estado);
		}
	}
	
	public void Eliminar(String usuario)
	{
		Persona eliminar = buscarUsuario(usuario);
		if(eliminar!=null)
		{
			usuarios.remove(eliminar);
		}
	}
	
	public void Likes(Persona p1)
	{
		Persona p2;
		if(p1.getSexo()=='M') {
			p2 = usuarios.get((int) (Math.random()*usuarios.size()));
			if(p2.getSexo()!='H')
			while(p2.getSexo()=='H') {
				p2 = usuarios.get((int) (Math.random()*usuarios.size()));
			}
		}if(p1.getSexo()=='H') {
			p2 = usuarios.get((int) (Math.random()*usuarios.size()));
			if(p2.getSexo()!='M')
			while(p2.getSexo()=='M') {
				p2 = usuarios.get((int) (Math.random()*usuarios.size()));
			}
		}
	}
	
	public Persona usuarioAleatorio() 
	{
		numero = (int) (Math.random()*usuarios.size());
		
		return usuarios.get(numero);
	}
	
	public ArrayList<Persona> ordenarLikes()
	{
		boolean cambios;
		for(salto=usuarios.size()/2; salto!=0; salto/=2)
		{
			cambios = true;
			while(cambios)
			{
				cambios = false;
				for(int i=salto; i<usuarios.size();i++)
				{
					Persona a = usuarios.get(i);
					Persona b = usuarios.get(i-salto);
					if(b.getLikesRecibidos()>a.getLikesRecibidos())
					{
						aux=a;
						a=b;
						b=aux;
						cambios=true;
					}
				}
			}
		}
		return usuarios;
	}
	
	public boolean ordenarEdad()
	{
		boolean cambio = false;
		for(int i=0; i<usuarios.size();i++)
		{
			Persona apuntador = usuarios.get(i);
			for(int j=i+1; j<usuarios.size(); j++)
			{
				Persona a = usuarios.get(j);
				if(a.getEdad()<apuntador.getEdad())
				{
					aux = a;
					a = apuntador;
					apuntador = aux;
					cambio = true;
				}
				else
				{
				cambio=false;
				}
			}	 
		}	
		return cambio;
	}
	
	public ArrayList<Persona> ordenarNombre()
	{
		for(int i=0; i<usuarios.size(); i++)
		{
			Persona apuntador = usuarios.get(i);
			for(int j=i+1; j<usuarios.size();j++)
			{
				Persona a = usuarios.get(j);
				if(a.getNombre().charAt(0)>apuntador.getNombre().charAt(0))
				{
					aux = a;
					a = apuntador;
					apuntador = aux;
				}
			}
		}
		return usuarios;
	}
	
	public ArrayList<Persona> ordenarMatch()
	{
		boolean cambios;
		for(salto=usuarios.size()/2; salto!=0; salto/=2)
		{
			cambios = true;
			while(cambios)
			{
				cambios = false;
				for(int i=salto; i<usuarios.size();i++)
				{
					Persona a = usuarios.get(i);
					Persona b = usuarios.get(i-salto);
					if(b.getMatches()>a.getMatches())
					{
						aux=a;
						a=b;
						b=aux;
						cambios=true;
					}
				}
			}
		}
		return usuarios;
	}
	
	public ArrayList<Persona> ordenarApellido()
	{
		for(int i=0; i<usuarios.size(); i++)
		{
			Persona apuntador = usuarios.get(i);
			for(int j=i+1; j<usuarios.size();j++)
			{
				Persona a = usuarios.get(j);
				if(a.getApellido1().charAt(0)>apuntador.getApellido1().charAt(0))
				{
					aux = a;
					a = apuntador;
					apuntador = aux;
				}
			}
		}
		return usuarios;
	}
	
	public void ordenarUsuario()
	{
		for(int i=0; i<usuarios.size(); i++)
		{
			Persona apuntador = usuarios.get(i);
			for(int j=i+1; j<usuarios.size();j++)
			{
				Persona a = usuarios.get(j);
				if(a.getUsuario().charAt(0)>apuntador.getUsuario().charAt(0))
				{
					aux = a;
					a = apuntador;
					apuntador = aux;
				}
			}
		}
	}
	
	public static void main(String[] args) throws ClassNotFoundException, IOException
	{
		Mundo m = new Mundo();
		m.ordenarEdad();
	}
}
