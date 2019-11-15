package modelo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.*;

import controlador.ControlLectura;

public class Mundo
{

	private ArrayList<Persona> usuarios;
	private Persona per;
	private Hombre hom;
	private Mujer muj;
	private int numero;
	private int aux;
	
	public Mundo() throws ClassNotFoundException, IOException
	{
		usuarios = ControlLectura.lectura();
	}
	
	public void enviarConGMail(String destinatario, String cuerpo) {
	    
	    String remitente = "tinderbos";  
	    Properties props = System.getProperties();
	    props.put("mail.smtp.host", "smtp.gmail.com");  
	    props.put("mail.smtp.user", remitente);
	    props.put("mail.smtp.clave", "bostinder123");    
	    props.put("mail.smtp.auth", "true");    
	    props.put("mail.smtp.starttls.enable", "true"); 
	    props.put("mail.smtp.port", "587"); 
	    Session session = Session.getDefaultInstance(props);
	    MimeMessage message = new MimeMessage(session);

	    try {
	        message.setFrom(new InternetAddress(remitente));
	        message.addRecipients(Message.RecipientType.TO, destinatario);   
	        message.setSubject("Usuario registrado correctamente en BOSTINDER");
	        message.setText(cuerpo);
	        Transport transport = session.getTransport("smtp");
	        transport.connect("smtp.gmail.com", remitente, "bostinder123");
	        transport.sendMessage(message, message.getAllRecipients());
	        transport.close();
	    }
	    catch (MessagingException me) {
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
	
	public void agregarHombre(String nombre, int edad, int id, String apellido1, String apellido2, char sexo, String usuario,
			String contraseña, String correo, String fechaNacimiento, char estado, double pIngresos, double pEstatura)
	{
		Persona nueva = buscarUsuario(usuario);
		if(nueva == null)
		{
			nueva = new Hombre(nombre, edad, id, apellido1, apellido2, sexo, usuario, contraseña, correo, fechaNacimiento, estado, pIngresos, pEstatura);
			usuarios.add(nueva);
		}
	}
	
	public void agregarMujer(String nombre, int edad, int id, String apellido1, String apellido2, char sexo, String usuario,
			String contraseña, String correo, String fechaNacimiento, char estado, double pIngresos, double pEstatura, boolean pDivorcios)
	{
		Persona nueva = buscarUsuario(usuario);
		if(nueva == null)
		{
			nueva = new Mujer(nombre, edad, id, apellido1, apellido2, sexo, usuario, contraseña, correo, fechaNacimiento, estado, pDivorcios);
			usuarios.add(nueva);
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
		usuarios.get(numero).setLikesRecibidos(usuarios.get(numero).getLikesRecibidos()+1);
		p1.setLikesOtorgados(p1.getLikesOtorgados()+1);
	}
	
	public Persona usuarioAleatorio() 
	{
		numero = (int) (Math.random()*usuarios.size());
		return usuarios.get(numero);
	}
	
	public ArrayList ordenarQuickSort()
	{
		return usuarios;
	}
	
	public ArrayList ordenarQuickSort2()
	{
		return usuarios;
	}
	
	public void ordenarSeleccion()
	{
		for(int i=0; i<usuarios.size();i++)
		{
			int apuntador = usuarios.get(i).getLikesRecibidos();
			for(int j=i+1; j<usuarios.size(); j++)
			{
				int a = usuarios.get(j).getLikesRecibidos();
				if(a<apuntador)
				{
					aux = a;
					a = apuntador;
					apuntador = aux;
				}
			}
		}
	}
}
