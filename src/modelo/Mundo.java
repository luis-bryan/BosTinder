package modelo;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import controlador.ControlLectura;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

public class Mundo implements Serializable
{


	private static final long serialVersionUID = 1L;
	private ArrayList<Persona> usuarios;
	private int salto;

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
    System.out.println("ENVIADO");
	}

	public Persona buscarUsuario(String usuario)
	{
		Persona p = null;
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
			if (n.getContraseña().equals(contraseña))
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


	public boolean agregarHombre(String nombre, long id, String apellido1, String apellido2, char sexo, String usuario,
														String contraseña, String correo, Date fechaNacimiento, double pIngresos, double pEstatura) throws IOException
	{
		Persona nueva = buscarUsuario(usuario);
		String fecha = new SimpleDateFormat("dd/MM/yyyy").format(fechaNacimiento);

		if(nueva == null)
		{
			nueva = new Hombre(nombre, id, apellido1, apellido2, sexo, usuario, contraseña, correo, fecha, pIngresos, pEstatura);

			usuarios.add(nueva);

			ControlLectura.escritura(usuarios);

			return true;
		}
		return false;
	}

	public boolean agregarMujer(String nombre, long id, String apellido1, String apellido2, char sexo, String usuario,
													 String contraseña, String correo, Date fechaNacimiento, boolean pDivorcios) throws IOException
	{
		Persona nueva = buscarUsuario(usuario);
		String fecha = new SimpleDateFormat("dd/MM/yyyy").format(fechaNacimiento);

		if(nueva == null)
		{
			nueva = new Mujer(nombre, id, apellido1, apellido2, sexo, usuario, contraseña, correo, fecha, pDivorcios);
			usuarios.add(nueva);
			ControlLectura.escritura(usuarios);
			return true;
		}
		return false;
	}

  public boolean modificar(String nombre, String usuario, String apellido1, String apellido2, String contraseña) throws IOException
	{
		Persona modificar = buscarUsuario(usuario);
		if(modificar!=null)
		{
			modificar.setNombre(nombre);
			modificar.setApellido1(apellido1);
			modificar.setApellido2(apellido2);
			modificar.setContraseña(contraseña);
      ControlLectura.escritura(usuarios);
      return true;
		}
		return false;
	}

	public boolean eliminar(String usuario)
	{	
		int pos = -1;
		for(int i = 0 ; i< usuarios.size(); i++){
			if(usuarios.get(i).getNombre().equalsIgnoreCase(usuario)){
				pos = i;
			}
		}
		
		if(pos == -1){
			System.out.println("PERSONA NO ENCONTRADA");
			return false;
		}else{
			usuarios.remove(pos);
      System.out.println("USUARIO ELIMINADO");
			return true;
		}
	}

	public Persona siguientePersona(Persona p1)
	{
		Persona p2 = null;
		if(p1.getSexo()=='M') {
			p2 = usuarios.get((int) (Math.random()*usuarios.size()));
			while (p2.getSexo() != 'H' || p2.getEstado() == 'I') {
				p2 = usuarios.get((int) (Math.random()*usuarios.size()));
			}
		}else if(p1.getSexo()=='H') {
			p2 = usuarios.get((int) (Math.random()*usuarios.size()));
			while (p2.getSexo() != 'M' || p2.getEstado() == 'I') {
				p2 = usuarios.get((int) (Math.random()*usuarios.size()));
			}
		}
		return p2;
	}
	public void darLike(Persona usuario,Persona like) {
		Persona p3 =null;
		usuario.setLikesOtorgados(usuario.getLikesOtorgados()+1);
		like.setLikesRecibidos(like.getLikesRecibidos()+1);
		if(usuario.getSexo()=='M') {
			p3 = usuarios.get((int) (Math.random()*usuarios.size()));
			while(p3.getSexo()!='H') {
				p3 = usuarios.get((int) (Math.random()*usuarios.size()));
			}
		}else if(usuario.getSexo()=='H') {
			p3 = usuarios.get((int) (Math.random()*usuarios.size()));
			while(p3.getSexo()!='M') {
				p3 = usuarios.get((int) (Math.random()*usuarios.size()));
			}
		}
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
	public void generarGrafica() throws IOException {
		DefaultCategoryDataset data = new DefaultCategoryDataset();
		data.addValue(calcularMedia(), "Datos", "MEDIA");
		data.addValue(calcularMediana(), "Datos", "MEDIANA");
		data.addValue(calcularModa(), "Datos", "MODA");
		JFreeChart grafica = ChartFactory.createBarChart("Moda, Mediana y Moda de Edad",
				"", "Valor", data,
				PlotOrientation.VERTICAL, true, true, false);
		ChartUtilities.saveChartAsPNG(new File("Grafico1.png"), grafica, 500, 500);
	}
	public void generarPDF() throws DocumentException, MalformedURLException, IOException 
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
		generarGrafica();
		Image grafica  = Image.getInstance("Grafico1.png");
		grafica.scaleToFit(300,300);
		grafica.setAlignment(Chunk.ALIGN_LEFT);
		
		
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
	    //ordenarApellido();
		for (int i = 0; i < usuarios.size(); i++) {
			tabla3.addCell(Integer.toString(i+1));
			tabla3.addCell(usuarios.get(i).getApellido1());
		}
		tabla4.addCell("NUMERO");
		tabla4.addCell("NOMBRE");
	    //ordenarNombre();
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
	    //ordenarUsuario();
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
		doc.add(grafica);
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
	public Icon generarFoto(Persona usuario,Persona p2) {
		Icon foto =null;
		if(usuario.getSexo()=='H') {
			if(p2.getEdad()<30) {
				ImageIcon imagen = new ImageIcon(getClass().getResource("/Imagenes/mujer" + ((int) ((Math.random() * 3) + 1)) + ".png"));
				foto = new ImageIcon(imagen.getImage().getScaledInstance(375, 300, Image.AX));
		}else if(p2.getEdad()>30&&p2.getEdad()<50) {
				ImageIcon imagen = new ImageIcon(getClass().getResource("/Imagenes/mujer" + ((int) ((Math.random() * 3) + 1)) + ".png"));
			foto = new ImageIcon(imagen.getImage().getScaledInstance(375, 300, Image.AX));
		}else if(p2.getEdad()>50) {
				ImageIcon imagen = new ImageIcon(getClass().getResource("/Imagenes/mujer" + ((int) ((Math.random() * 3) + 1)) + ".png"));
			foto = new ImageIcon(imagen.getImage().getScaledInstance(375, 300, Image.AX));
		}
		}
			
		return foto;

	}

  public ArrayList<Persona> getUsuarios() {
    return usuarios;
  }

  public void setUsuarios(ArrayList<Persona> usuarios) {
    this.usuarios = usuarios;
  }
}
