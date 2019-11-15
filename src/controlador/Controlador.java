package controlador;

import java.io.IOException;

import modelo.Mundo;

public class Controlador {
	private Mundo m;
	public Controlador() throws ClassNotFoundException, IOException {
		m = new Mundo();
		m.enviarConGMail("dhidalgod@unbosque.edu.co", "sasdasdasdas");
		
	}

}
