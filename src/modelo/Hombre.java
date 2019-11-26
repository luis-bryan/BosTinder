package modelo;

import javax.swing.*;
import java.io.Serializable;
import java.util.ArrayList;

public class Hombre extends Persona implements Serializable
{

	private static final long serialVersionUID = 1L;
	private double ingresos;
	private double estatura;
	private ArrayList<Persona>match;

	public Hombre(String nombre, long id, String apellido1, String apellido2, char sexo, String usuario,
								String contraseña, String correo, String fechaNacimiento, double pIngresos, double pEstatura) throws AssertionError {
		super(nombre, id, apellido1, apellido2, sexo, usuario, contraseña, correo, fechaNacimiento);
		this.ingresos = pIngresos;
		this.estatura = pEstatura;
		verificarInvariante();
		match = new ArrayList<Persona>();
	}

	public Hombre(String nombre, int edad, long id, String apellido1, String apellido2, char sexo, String usuario,
								String contraseña, String correo, String fechaNacimiento, int likesRecibidos, int likesOtorgados,
								int matches, char estado, double pIngresos, double pEstatura){
		super(nombre, edad, id, apellido1, apellido2, sexo, usuario, contraseña, correo, fechaNacimiento, likesRecibidos, likesOtorgados, matches, estado);
		this.ingresos = pIngresos;
		this.estatura = pEstatura;
	}

	public Hombre(Icon icono)
	{
		// TODO Auto-generated constructor stub
		super(icono);
	}
	
	public Hombre(int r, int o, int m)
	{
		// TODO Auto-generated constructor stub
		super(r,o,m);
	}
	
	public double getIngresos() {
		return ingresos;
	}

	public void setIngresos(double ingresos) {
		this.ingresos = ingresos;
	}
	
	
	public double getEstatura() {
		return estatura;
	}

	public void setEstatura(double estatura) {
		this.estatura = estatura;
	}
	public void setMatch(ArrayList<Persona> match) {
		this.match = match;
	}

	public ArrayList<Persona> getMatch() {
		return match;
	}
	
	public boolean buscarUsuario(String usuario)
	{
		boolean aux = false;
		Persona p = null;
		if(!match.isEmpty())
		{
			for (int i = 0; i < match.size(); i++) 
			{
				if(match.get(i).getUsuario().equals(usuario))
				{
					aux = true;
				}
			}
		}
		return aux;
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
		assert (contraseña != null && !contraseña.equals(" ")) : "La contrasela no es valida";
		assert(correo.contains("@") && !correo.contains(";")): "El correo no es valido";
		//assert(fechaNacimiento.toString().contains("[0-9\\/]")): "Fecha de nacimiento no valida";
		assert(estado=='D' || estado=='I'|| estado=='M'): "El estado solo admite valores de D, I o M";
	}
}
