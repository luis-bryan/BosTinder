package modelo;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mundo {
	private Mujer mu;
	private Hombre ho;
	public Mundo() {
		 mu = new Mujer();
		 ho = new Hombre();
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
	}

	
	public Mujer getMu() {
		return mu;
	}
	public void setMu(Mujer mu) {
		this.mu = mu;
	}
	public Hombre getHo() {
		return ho;
	}
	public void setHo(Hombre ho) {
		this.ho = ho;
	}
	

}
