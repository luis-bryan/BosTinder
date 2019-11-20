package modelo;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.Icon;
import javax.swing.JOptionPane;

public class Persona implements Serializable
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
	protected Icon imagen;
	protected Date fecha;
	
	public Persona(String nombre, int edad, int id, String apellido1, String apellido2, char sexo, String usuario,
			String contraseña, String correo, String fechaNacimiento, char estado) 
	{
		this.nombre = nombre;
		this.edad = new Date().getYear()-fecha.getYear();
		this.id = id;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.sexo = sexo;
		this.usuario = usuario;
		this.contraseña = contraseña;
		this.correo = correo;
		this.fechaNacimiento = fechaNacimiento;
		try {
			this.fecha = new SimpleDateFormat("dd/MM/yyyy").parse(fechaNacimiento);
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Error en la fecha");
		}
		this.estado = estado;
	}
	
	public Persona(Icon icono)
	{
		// TODO Auto-generated constructor stub
		imagen = icono;
	}

	public Persona(int likesR, int likesO, int Matc) 
	{
		// TODO Auto-generated constructor stub
		likesRecibidos = likesR;
		likesOtorgados = likesO;
		matches = Matc;
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
				+ ", correo=" + correo + ", fechaNacimiento=" + fecha + ", likesRecibidos=" + likesRecibidos
				+ ", likesOtorgados=" + likesOtorgados + ", matches=" + matches + ", estado=" + estado + "]\n" ;
	}

	public Icon getImagen() {
		return imagen;
	}

	public void setImagen(Icon imagen) {
		this.imagen = imagen;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
}
