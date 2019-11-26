package modelo;

import java.io.Serializable;
import java.util.ArrayList;

public class Hombre extends Persona implements Serializable
{

	private static final long serialVersionUID = 1L;
	private double ingresos;
	private double estatura;
  private ArrayList<Persona> match;

	/**
	 * Construye un objeto de tipo Hombre a partir de la informacion suministrada por el usuario
	 *
	 * @param nombre          Nombre del Hombre
	 * @param id              Identificacion del Hombre
	 * @param apellido1       Apellido del Hombre
	 * @param apellido2       Apellido del Hombre
	 * @param sexo            Sexo del Hombre
	 * @param usuario         UserName del Hombre
	 * @param contraseña      Contraseña del Hombre
	 * @param correo          Correo del Hombre
	 * @param fechaNacimiento Fecha de Nacimiento del Hombre
	 * @param pIngresos       Ingresos del Hombre
	 * @param pEstatura       Estatura del Hombre
	 * @throws AssertionError En caso que alguna variable no cumpla con las condiciones dadas
	 */
	public Hombre(String nombre, long id, String apellido1, String apellido2, char sexo, String usuario,
								String contraseña, String correo, String fechaNacimiento, double pIngresos, double pEstatura) throws AssertionError {
		super(nombre, id, apellido1, apellido2, sexo, usuario, contraseña, correo, fechaNacimiento);
		this.ingresos = pIngresos;
		this.estatura = pEstatura;
		verificarInvariante();
    match = new ArrayList<Persona>();
	}

	/**
	 * Construye un objeto de tipo Hombre a partir de la informacion a partir del archivo csv
	 *
	 * @param nombre          Nombre del Hombre !=null
	 * @param edad            Edad del Hombre //Deprecado, siempre se calcula la edad >0
	 * @param id              Identificacion del Hombre !=0
	 * @param apellido1       Apellido del Hombre !=null
	 * @param apellido2       Apellido del Hombre !=null
	 * @param sexo            Sexo del Hombre //Deprecado, Un hombre siempre es un hombre... Uno de{'H','M'}
	 * @param usuario         UserName del Hombre !=null, unico
	 * @param contraseña      Contraseña del Hombre !=null
	 * @param correo          Correo del Hombre !=null, contiene un @
	 * @param fechaNacimiento Fecha de Nacimiento del Hombre !=null, cumple con el formato "dd/MM/yyyy"
	 * @param likesRecibidos  Cantidad de likes recibidos por el Hombre, >=0
	 * @param likesOtorgados  Cantidad de likes dados por el Hombre >=0
	 * @param matches         Cantidad de matches que ha hecho el Hombre >=0
	 * @param estado          Estado del Hombre, Uno de {'D' si esta disponible, 'I' si esta inactivo, 'M' si es menor de edad}
	 * @param pIngresos       Ingresos del Hombre >=0
	 * @param pEstatura       Estatura del Hombre en centimetros>=130, <=300
	 */
	public Hombre(String nombre, int edad, long id, String apellido1, String apellido2, char sexo, String usuario,
								String contraseña, String correo, String fechaNacimiento, int likesRecibidos, int likesOtorgados,
								int matches, char estado, double pIngresos, double pEstatura) {
		super(nombre, edad, id, apellido1, apellido2, sexo, usuario, contraseña, correo, fechaNacimiento, likesRecibidos, likesOtorgados, matches, estado);

		this.ingresos = pIngresos;
		this.estatura = pEstatura;
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

  public boolean buscarUsuario(String usuario) {
    boolean aux = false;
    Persona p = null;
    if (!match.isEmpty()) {
      for (int i = 0; i < match.size(); i++) {
        if (match.get(i).getUsuario().equals(usuario)) {
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
