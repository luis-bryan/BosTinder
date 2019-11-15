package modelo;

import java.io.Serializable;

public class Hombre extends Persona implements Serializable
{

	private static final long serialVersionUID = 1L;
	private double ingresos;
	private double estatura;
	
	// 	JFreeChart
	public Hombre(String nombre, int edad, int id, String apellido1, String apellido2, char sexo, String usuario,
			String contraseña, String correo, String fechaNacimiento, char estado, double pIngresos, double pEstatura) throws AssertionError
	{
		super(nombre, edad, id, apellido1, apellido2, sexo, usuario, contraseña, correo, fechaNacimiento, estado);
		ingresos = pIngresos;
		estatura = pEstatura;
		verificarInvariante();
		// TODO Auto-generated constructor stub
	}
	public Hombre() {
		// TODO Auto-generated constructor stub
	}

	public double getIngresos() {
		return ingresos;
	}

	public void setIngresos(double ingresos) {
		this.ingresos = ingresos;
	}
	
	public void verificarInvariante() throws AssertionError
	{
		assert(nombre!=null && !nombre.equals(" ")): "El nombre no puede estar vacio";
		assert(!nombre.contains(";")):"El nombre no puede contener caracteres especiales";
		assert(edad>18):"La edad debe ser mayor a 18";
		assert(apellido1!=null && !apellido1.equals(" ")): "El apellido no puede estar vacio";
		assert(!apellido1.contains(";")):"El apellido no puede contener caracteres especiales";
		assert(apellido2!=null && !apellido2.equals(" ")): "El apellido no puede estar vacio";
		assert(!apellido2.contains(";")):"El apellido no puede contener caracteres especiales";
		assert(sexo=='H'||sexo=='M'):"El sexo solo adimite el valor de H o M";
		assert(usuario!=null && !usuario.equals(" ")): "El usuario no es valido";
		assert(!usuario.contains(";")): "El usuario no puede tener caracteres especiales";
		assert(contraseña!=null && !contraseña.equals(" ")): "La contrasela no es valida";
		assert(correo.contains("@") && !correo.contains(";")): "El correo no es valido";
		assert(fechaNacimiento.contains("[0-9\\/]"));
		assert(estado=='D' || estado=='I'): "El estado solo admite valores de D o I";
	}
}
