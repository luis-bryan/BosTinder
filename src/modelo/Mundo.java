package modelo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.*;
import javax.swing.Icon;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import controlador.ControlLectura;

public class Mundo implements Serializable
{


	private static final long serialVersionUID = 1L;
	private ArrayList<Persona> usuarios;
	private int numero;
	private Persona aux;
	private Persona aux3;
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
		boolean iniciar = false;
		if(n!=null)
		{
			if(n.getContraseña().equals(contraseña))
			{
				iniciar = true;
			}
			else 
			{
				iniciar = false;
			}
		}
		return iniciar;
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

	public void Modificar(String nombre, String usuario, String apellido1, String apellido2, String contraseña)
	{
		Persona modificar = buscarUsuario(usuario);
		if(modificar!=null)
		{
			modificar.setNombre(nombre);
			modificar.setApellido1(apellido1);
			modificar.setApellido2(apellido2);
			modificar.setContraseña(contraseña);
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

	public Persona siguientePersona(Persona p1)
	{
		Persona p2 = null;
		if(p1.getSexo()=='M') {
			p2 = usuarios.get((int) (Math.random()*usuarios.size()));
			while(p2.getSexo()!='H') {
				p2 = usuarios.get((int) (Math.random()*usuarios.size()));
			}
		}else if(p1.getSexo()=='H') {
			p2 = usuarios.get((int) (Math.random()*usuarios.size()));
			while(p2.getSexo()!='M') {
				p2 = usuarios.get((int) (Math.random()*usuarios.size()));
			}
		}
		return p2;
	}

	public Persona usuarioAleatorio() 
	{
		numero = (int) (Math.random()*usuarios.size());
		return usuarios.get(numero);
	}

	public ArrayList<Persona> ordenarLikes()
	{
		ArrayList<Persona> personas = new ArrayList<Persona>();
		boolean cambios;
		for(salto=usuarios.size()/2; salto!=0; salto/=2)
		{
			personas = usuarios;
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
						personas.set(i, b);
						personas.set(i-salto, a);
						cambios=true;
					}
				}
			}
		}
		return personas;
	}

	public ArrayList<Persona> ordenarEdad()
	{
		ArrayList<Persona> personas = new ArrayList<Persona>();
		boolean cambios;
		for(salto=usuarios.size()/2; salto!=0; salto/=2)
		{
			personas = usuarios;
			cambios = true;
			while(cambios)
			{
				cambios = false;
				for(int i=salto; i<usuarios.size();i++)
				{
					Persona a = usuarios.get(i);
					Persona b = usuarios.get(i-salto);
					if(b.getEdad()>a.getEdad())
					{
						personas.set(i, b);
						personas.set(i-salto, a);
						cambios=true;
					}
				}
			}
		}
		return personas;
	}

	public ArrayList<Persona> ordenarNombre()
	{
		ArrayList<Persona> personas = new ArrayList<Persona>();
		boolean cambios;
		for(salto=usuarios.size()/2; salto!=0; salto/=2)
		{
			personas = usuarios;
			cambios = true;
			while(cambios)
			{
				cambios = false;
				for(int i=salto; i<usuarios.size();i++)
				{
					Persona a = usuarios.get(i);
					Persona b = usuarios.get(i-salto);
					if(b.getNombre().charAt(0)>a.getNombre().charAt(0))
					{
						personas.set(i, b);
						personas.set(i-salto, a);
						cambios=true;
					}
				}
			}
		}
		return personas;
	}

	public ArrayList<Persona> ordenarMatch()
	{
		ArrayList<Persona> personas = new ArrayList<Persona>();
		boolean cambios;
		for(salto=usuarios.size()/2; salto!=0; salto/=2)
		{
			personas = usuarios;
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
						personas.set(i, b);
						personas.set(i-salto, a);
						cambios=true;
					}
				}
			}
		}
		return personas;
	}

	public ArrayList<Persona> ordenarApellido()
	{
		ArrayList<Persona> personas = new ArrayList<Persona>();
		boolean cambios;
		for(salto=usuarios.size()/2; salto!=0; salto/=2)
		{
			personas = usuarios;
			cambios = true;
			while(cambios)
			{
				cambios = false;
				for(int i=salto; i<usuarios.size();i++)
				{
					Persona a = usuarios.get(i);
					Persona b = usuarios.get(i-salto);
					if(b.getApellido1().charAt(0)>a.getApellido1().charAt(0))
					{
						personas.set(i, b);
						personas.set(i-salto, a);
						cambios=true;
					}
				}
			}
		}
		return personas;
	}

	public ArrayList<Persona> ordenarUsuario()
	{
		ArrayList<Persona> personas = new ArrayList<Persona>();
		boolean cambios;
		for(salto=usuarios.size()/2; salto!=0; salto/=2)
		{
			personas = usuarios;
			cambios = true;
			while(cambios)
			{
				cambios = false;
				for(int i=salto; i<usuarios.size();i++)
				{
					Persona a = usuarios.get(i);
					Persona b = usuarios.get(i-salto);
					if(b.getUsuario().charAt(0)>a.getUsuario().charAt(0))
					{
						personas.set(i, b);
						personas.set(i-salto, a);
						cambios=true;
					}
				}
			}
		}
		return personas;
	}

	public double calcularMediana() {
		double mediana;
        if(usuarios.size() % 2 == 0){
            int sumaMedios = usuarios.get(usuarios.size()/2).getEdad() +  usuarios.get(usuarios.size()/2-1).getEdad(); 
            mediana = (double)sumaMedios / 2; 
        } else {
            mediana = usuarios.get(usuarios.size()/2).getEdad();
        }
        return mediana;
	}
	public double calcularMedia() {
		int media = 0;
		for (int i=0; i < usuarios.size(); i++) {
			 media = media + usuarios.get(i).getEdad();
			}
        return (double)media/usuarios.size();

	}
	public double calcularModa() {
		int numMAXderepeticiones = 0;
		double moda = 0;
		for (int i = 0; i < usuarios.size(); i++) {
			int numerosderepeticiones =0;
			for (int j = 0; j < usuarios.size(); j++) {
				if(usuarios.get(i).getEdad()==usuarios.get(j).getEdad()) {
					numerosderepeticiones++;
				}
				if(numerosderepeticiones>numMAXderepeticiones) {
					moda = usuarios.get(i).getEdad();
					numMAXderepeticiones=numerosderepeticiones;
				}
			}
			
		}
		return moda;
	}
	public void generarPDF() throws FileNotFoundException, DocumentException 
	   {
		
		Document doc = new Document();
		Date objedate = new Date();
		
		String ruta ="Registro"+"_"+objedate.getYear()+"_"+objedate.getHours()+"_"+objedate.getMinutes()+"_"+objedate.getSeconds()+".pdf";
		FileOutputStream fichero = new FileOutputStream(ruta);
		PdfWriter.getInstance(doc, fichero).setInitialLeading(20);
		PdfPTable tabla = new PdfPTable(2);
		PdfPTable tabla2 = new PdfPTable(3);
		PdfPTable tabla3 = new PdfPTable(2);
		PdfPTable tabla4 = new PdfPTable(2);
		PdfPTable tabla5 = new PdfPTable(3);
		PdfPTable tabla6 = new PdfPTable(2);
		
		tabla.addCell("Mediana");
		tabla.addCell(Double.toString(calcularMediana()));
		tabla.addCell("Media");
		tabla.addCell(Double.toString(calcularMedia()));
		tabla.addCell("Moda");
		tabla.addCell(Double.toString(calcularModa()));
		
		tabla2.addCell("NUMERO");
		tabla2.addCell("USUARIO");
		tabla2.addCell("NUMERO DE LIKES");
	    ordenarLikes();
		for (int i = 0; i < usuarios.size(); i++) {
			tabla2.addCell(Integer.toString(i+1));
			tabla2.addCell(usuarios.get(i).getUsuario());
			tabla2.addCell(Integer.toString(usuarios.get(i).getLikesRecibidos()));
		}
		tabla3.addCell("NUMERO");
		tabla3.addCell("APELLIDO");
	 ordenarApellido();
		for (int i = 0; i < usuarios.size(); i++) {
			tabla3.addCell(Integer.toString(i+1));
			tabla3.addCell(usuarios.get(i).getApellido1());
		}
		tabla4.addCell("NUMERO");
		tabla4.addCell("NOMBRE");
	    ordenarNombre();
	    for (int i = 0; i < usuarios.size(); i++) {
			tabla4.addCell(Integer.toString(i+1));
			tabla4.addCell(usuarios.get(i).getNombre());
		}
	    tabla5.addCell("NUMERO");
	    tabla5.addCell("USUARIO");
	    tabla5.addCell("EDAD");
	    ordenarEdad();
	    for (int i = 0; i < usuarios.size(); i++) {
			tabla5.addCell(Integer.toString(i+1));
			tabla5.addCell(usuarios.get(i).getUsuario());
			tabla5.addCell(Integer.toString(usuarios.get(i).getEdad()));
		}
	    tabla6.addCell("NUMERO");
	    tabla6.addCell("USUARIO");
	    ordenarUsuario();
	    for (int i = 0; i <usuarios.size(); i++) {
	    	tabla6.addCell(Integer.toString(i+1));
	    	tabla6.addCell(usuarios.get(i).getUsuario());
			
		}
		
		doc.open();
		doc.add(new Paragraph(objedate.toString(),FontFactory.getFont("Arial",14,Font.ITALIC,BaseColor.BLACK)));
		doc.add(new Paragraph("\n"));
		doc.add(new Paragraph("Moda, Mediana y Media de la Edad"));
		doc.add(new Paragraph("\n"));
		doc.add(tabla);
		doc.add(new Paragraph("\n"));
		doc.add(new Paragraph("ORDEN ASCENDENTE POR NUMERO DE LIKES"));
		doc.add(new Paragraph("\n"));
		doc.add(tabla2);
		doc.add(new Paragraph("\n"));
		doc.add(new Paragraph("ORDEN ASCENDENTE POR APELLIDOS"));
		doc.add(new Paragraph("\n"));
		doc.add(tabla3);
		doc.add(new Paragraph("\n"));
		doc.add(new Paragraph("ORDEN ASCENDENTE POR NOMBRE"));
		doc.add(new Paragraph("\n"));
		doc.add(tabla4);
		doc.add(new Paragraph("\n"));
		doc.add(new Paragraph("ORDEN ASCENDENTE POR EDAD"));
		doc.add(new Paragraph("\n"));
		doc.add(tabla5);
		doc.add(new Paragraph("\n"));
		doc.add(new Paragraph("ORDEN ASCENDENTE POR NOMBRE DE USUARIO (ALIAS)"));
		doc.add(new Paragraph("\n"));
		doc.add(tabla6);
		
		doc.close(); 
		
	  }

	/*public static void main(String[] args) throws ClassNotFoundException, IOException, DocumentException
	{
		Mundo m = new Mundo();
		m.ordenarUsuario();
		System.out.println("jdsaoidj");
		//m.generarPDF();
	}*/
}
