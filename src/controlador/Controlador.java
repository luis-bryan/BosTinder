package controlador;

import modelo.Mundo;

public class Controlador {
	private Mundo m;
	public Controlador() {
		m = new Mundo();
		m.enviarConGMail("storresar@unbosque.edu.co", "sasdasdasdas");
		
	}

}
