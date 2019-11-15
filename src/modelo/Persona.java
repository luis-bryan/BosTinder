package modelo;

public class Persona
{

	protected String nombre;
	protected int edad;
	protected int id;
	protected String apellido1;
	protected String apellido2;
	protected char sexo;
	protected String usuario;
	protected String contraseña;
	protected String correo;
	protected String fechaNacimiento;
	protected int likesRecibidos;
	protected int likesOtorgados;
	protected int matches;
	protected char estado;
	
	public Persona(String nombre, int edad, int id, String apellido1, String apellido2, char sexo, String usuario,
			String contraseña, String correo, String fechaNacimiento, char estado) 
	{
		this.nombre = nombre;
		this.edad = edad;
		this.id = id;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.sexo = sexo;
		this.usuario = usuario;
		this.contraseña = contraseña;
		this.correo = correo;
		this.fechaNacimiento = fechaNacimiento;
		this.estado = estado;
	}
	public Persona() {
		// TODO Auto-generated constructor stub
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public int getLikesRecibidos() {
		return likesRecibidos;
	}

	public void setLikesRecibidos(int likesRecibidos) {
		this.likesRecibidos = likesRecibidos;
	}

	public int getLikesOtorgados() {
		return likesOtorgados;
	}

	public void setLikesOtorgados(int likesOtorgados) {
		this.likesOtorgados = likesOtorgados;
	}

	public int getMatches() {
		return matches;
	}

	public void setMatches(int matches) {
		this.matches = matches;
	}

	public char getEstado() {
		return estado;
	}

	public void setEstado(char estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", edad=" + edad + ", id=" + id + ", apellido1=" + apellido1
				+ ", apellido2=" + apellido2 + ", sexo=" + sexo + ", usuario=" + usuario + ", contraseña=" + contraseña
				+ ", correo=" + correo + ", fechaNacimiento=" + fechaNacimiento + ", likesRecibidos=" + likesRecibidos
				+ ", likesOtorgados=" + likesOtorgados + ", matches=" + matches + ", estado=" + estado + "]";
	}
}
