package controlador;

import Vista.VentanaBienvenida;

import java.io.IOException;

import com.itextpdf.text.DocumentException;

import modelo.Mundo;

public class Controlador 
{
	VentanaBienvenida vb;
	private Mundo m;
	
	public Controlador() throws ClassNotFoundException, IOException, DocumentException {
		m = new Mundo();
		m.enviarConGMail("dhidalgod@unbosque.edu.co", "sasdasdasdas");
		m.generarPDF();
		vb = new VentanaBienvenida();		

	}

}
