package modelo;

import java.io.Serializable;

public class Mujer extends Persona implements Serializable
{

	private static final long serialVersionUID = 1L;
	private int divorcios;
	
	public Mujer(String nombre, int edad, int id, String apellido1, String apellido2, char sexo, String usuario,
			String contraseña, String correo, String fechaNacimiento, char estado, int pDivorcios) 
	{
		super(nombre, edad, id, apellido1, apellido2, sexo, usuario, contraseña, correo, fechaNacimiento, estado);
		divorcios = pDivorcios;
		verificarInvariante();
		// TODO Auto-generated constructor stub
	}
	public Mujer() {
		// TODO Auto-generated constructor stub
	}

	public int getDivorcios() {
		return divorcios;
	}

	public void setDivorcios(int divorcios) {
		this.divorcios = divorcios;
	}
	
	public void verificarInvariante() throws AssertionError {
		assert(nombre!=null || nombre!=" "): "El nombre no puede estar vacio";
		assert(!nombre.contains(";")):"El nombre no puede contener caracteres especiales";
		assert(edad>18):"La edad debe ser mayor a 18";
		assert(apellido1!=null || apellido1!=" "): "El apellido no puede estar vacio";
		assert(!apellido1.contains(";")):"El apellido no puede contener caracteres especiales";
		assert(apellido2!=null || apellido2!=" "): "El apellido no puede estar vacio";
		assert(!apellido2.contains(";")):"El apellido no puede contener caracteres especiales";
		assert(sexo=='H'||sexo=='M'):"El sexo solo adimite el valor de H o M";
		assert(usuario!=null || usuario!=" "): "El usuario no es valido";
		assert(!usuario.contains(";")): "El usuario no puede tener caracteres especiales";
		assert(contraseña!=null || contraseña!=" "): "La contrasela no es valida";
		assert(correo.contains("@")): "El correo no es valido";
		assert(!correo.contains(";")): "El correo no es valido";
		assert(fechaNacimiento.contains("[0-9\\/]"));
		assert(estado=='D' || estado=='I'): "El estado solo admite valores de D o I";
	}
}
