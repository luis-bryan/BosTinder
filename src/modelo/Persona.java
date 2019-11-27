package modelo;

import javax.swing.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Persona implements Serializable
{
	protected String nombre;
	protected int edad;
	protected long id;
	protected String apellido1;
	protected String apellido2;
	protected char sexo;
	protected String usuario;
	protected String contraseña;
	protected String correo;
	protected LocalDate fechaNacimiento;
	protected int likesRecibidos;
	protected int likesOtorgados;
	protected int matches;
	protected char estado;
	protected Icon imagen;

	/**
	 * Constructor de la clase persona para la creacion de un objeto
	 *
	 * @param nombre          nombre != null y != ""
	 * @param id              id!=0 y id>0
	 * @param apellido1       apellido1!=null y !=""
	 * @param apellido2       apellido2!=null y !=""
	 * @param sexo            sexo='H' o 'M'
	 * @param usuario         usuario != null y != ""
	 * @param contraseña      contraseña != null y != ""
	 * @param correo          correo != null y != ""
	 * @param fechaNacimiento fechaNacimiento != "" y != null
	 */
	public Persona(String nombre, long id, String apellido1, String apellido2, char sexo, String usuario,
								 String contraseña, String correo, String fechaNacimiento) {
		this.nombre = nombre;
		this.id = id;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.sexo = sexo;
		this.usuario = usuario;
		this.contraseña = contraseña;
		this.correo = correo;
		this.fechaNacimiento = LocalDate.parse(fechaNacimiento, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		this.estado = 'D';
		this.edad = calcularEdad();
		if (this.edad >= 18) {
			this.estado = 'D';
		} else {
			this.estado = 'M';
		}
		this.matches = 0;
		this.likesRecibidos = 0;
		this.likesOtorgados = 0;

	}

	/**
	 * Constructor completo de la clase
	 *
	 * @param nombre
	 * @param edad
	 * @param id
	 * @param apellido1
	 * @param apellido2
	 * @param sexo
	 * @param usuario
	 * @param contraseña
	 * @param correo
	 * @param fechaNacimiento
	 * @param likesRecibidos
	 * @param likesOtorgados
	 * @param matches
	 * @param estado
	 */
	public Persona(String nombre, int edad, long id, String apellido1, String apellido2, char sexo, String usuario,
								 String contraseña, String correo, String fechaNacimiento, int likesRecibidos, int likesOtorgados,
								 int matches, char estado)
	{
		this.nombre = nombre;
		this.id = id;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.sexo = sexo;
		this.usuario = usuario;
		this.contraseña = contraseña;
		this.correo = correo;
		fechaNacimiento = fechaNacimiento.length() == 10 ? fechaNacimiento : "0" + fechaNacimiento;
		this.fechaNacimiento = LocalDate.parse(fechaNacimiento, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		this.edad = calcularEdad();
		this.estado = estado;
		this.likesRecibidos = likesRecibidos;
		this.likesOtorgados = likesOtorgados;
		this.matches = matches;
		if (this.edad < 18) {
			this.estado='M';
		}

		System.out.println(this.estado);
		System.out.println(this.edad);
	}

	/**
	 * Calcula la edad de el objeto a partir de la fecha de nacimiento
	 *
	 * @return la edad calculada
	 */
	public int calcularEdad(){
		String tiempoDesde = fechaNacimiento.until(LocalDate.now()).toString();
		return Integer.parseInt((tiempoDesde.charAt(1) + "" + tiempoDesde.charAt(2)));
	}

	/**
	 * Obtiene el nombre de una persona
	 *
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Modifica el nombre de una persona
	 *
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene la edad de la persona
	 *
	 * @return edad
	 */
	public int getEdad() {
		return edad;
	}

	/**
	 * Modifica la edad de una persona
	 *
	 * @param edad
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}

	/**
	 * Obtiene el id de la pesona
	 * @return id
   */
  public long getId() {
		return id;
	}

	/**
	 * Modifica el id de la persona
	 *
	 * @param id
	 */
  public void setId(long id) {
		this.id = id;
	}

	/**
	 * Obtiene el primer apellido de la persona
	 * @return apellido1
	 */
  public String getApellido1() {
		return apellido1;
	}

	/**
	 * modifica el primer apellido de la persona
	 *
	 * @param apellido1
	 */
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	/**
	 * Obtiene el segundo apellido de la persona
	 * @return apellido2
   */
  public String getApellido2() {
		return apellido2;
	}

	/**
	 * modifica el segundo apellido de la persona
	 *
	 * @param apellido2
	 */
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	/**
	 * Obtiene el sexo de la persona
	 * @return sexo
	 */
	public char getSexo() {
		return sexo;
	}

	/**
	 * Modifica el sexo de la persona
	 * @param sexo
   */
  public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	/**
	 * Obtiene el usuario de una persona
	 * @return usuario
   */
  public String getUsuario() {
		return usuario;
	}

	/**
	 * Modifica el usuario de una persona
	 * @param usuario
   */
  public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * Obtiene la contraseña de una persona
	 * @return contraseña
   */
  public String getContraseña() {
		return contraseña;
	}

	/**
	 * Modifica la contraseña de la persona
	 *
	 * @param contraseña
	 */
  public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	/**
	 * Obtiene el correo de la persona
	 * @return correo
	 */
	public String getCorreo() {
		return correo;
	}

	/**
	 * Modifica el correo de la persona
	 * @param correo
   */
  public void setCorreo(String correo) {
		this.correo = correo;
	}

	/**
	 * Obtiene la fecha actual
	 * @return fechaNacimiento
   */
  public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	/**
	 * Modifica la fecha
	 *
	 * @param fechaNacimiento
	 */
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	/**
	 * Obtiene los likes recibidos a una personas
	 * @return likesRecibidos
   */
  public int getLikesRecibidos() {
		return likesRecibidos;
	}

	/**
	 * Modifica los likes recibidos
	 * @param likesRecibidos
   */
  public void setLikesRecibidos(int likesRecibidos) {
		this.likesRecibidos = likesRecibidos;
	}

	/**
	 * Obtiene los likes otorgados
	 * @return likesOtorgados
   */
  public int getLikesOtorgados() {
		return likesOtorgados;
	}

	/**
	 * Modifica los likes Otorgados
	 * @param likesOtorgados
   */
  public void setLikesOtorgados(int likesOtorgados) {
		this.likesOtorgados = likesOtorgados;
	}

	/**
	 * Obtiene los match de una persona
   * @return matches
	 */
	public int getMatches() {
		return matches;
	}

	/**
	 * Modifica los match de una persona
	 * @param matches
   */
  public void setMatches(int matches) {
		this.matches = matches;
	}

	/**
	 * Obtiene el estado de una persona
   * @return estado
	 */
	public char getEstado() {
		return estado;
	}

	/**
	 * Modifica el estado de una persona
	 * @param estado
   */
  public void setEstado(char estado) {
		this.estado = estado;
	}

	/**
	 * toString de la clase Persona
   */
  @Override
  public String toString() {
		return "Persona [nombre=" + nombre + ", edad=" + edad + ", id=" + id + ", apellido1=" + apellido1
			+ ", apellido2=" + apellido2 + ", sexo=" + sexo + ", usuario=" + usuario + ", contraseña=" + contraseña
			+ ", correo=" + correo + ", fechaNacimiento=" + fechaNacimiento.getDayOfMonth() + "/" + fechaNacimiento.getMonth() + "/" + fechaNacimiento.getYear() + ", likesRecibidos=" + likesRecibidos
			+ ", likesOtorgados=" + likesOtorgados + ", matches=" + matches + ", estado=" + estado + "]\n";
	}

	/**
	 * Obtiene el icono de la persona
   *
   * @return imagen
	 */
	public Icon getImagen() {
		return imagen;
	}

	/**
	 * Modifica el icono de la persona
	 * @param imagen
   */
  public void setImagen(Icon imagen) {
		this.imagen = imagen;
	}

	/**
	 * Metodo que valida la edad con ayuda del metodo calcularEdad
   */
  public void validarEdad() {
		if (edad != calcularEdad()) {
			edad = calcularEdad();
		}
		if (edad > 18 && estado == 'M') {
			estado = 'D';
		}
	}
}
