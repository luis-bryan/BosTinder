package modelo;

import java.util.ArrayList;

public class Mundo
{

	private ArrayList<Persona> usuarios;
	private Persona per;
	private Hombre hom;
	private Mujer muj;
	private int numero;
	private int aux;
	
	public Mundo()
	{
		hom = new Hombre();
		per = new Persona();
		muj = new Mujer();
		usuarios = new ArrayList<Persona>();
	}
	
	public Persona buscarUsuario(String usuario)
	{
		if(!usuarios.isEmpty())
		{
			for (int i = 0; i < usuarios.size(); i++) 
			{
				if(usuarios.get(i).getUsuario().equals(usuario))
				{
					return usuarios.get(i);
				}
			}
		}
		return null;
	}
	
	public boolean buscarContraseña(String usuario, String contraseña)
	{
		Persona n = buscarUsuario(usuario);
		if(n!=null)
		{
			if(n.getContraseña().equals(contraseña))
			{
				return true;
			}
			else 
			{
				return false;
			}
		}
		return false;
	}
	
	public void agregarHombre(String nombre, int edad, int id, String apellido1, String apellido2, char sexo, String usuario,
			String contraseña, String correo, String fechaNacimiento, char estado, double pIngresos, double pEstatura)
	{
		Persona nueva = buscarUsuario(usuario);
		if(nueva == null)
		{
			nueva = new Hombre(nombre, edad, id, apellido1, apellido2, sexo, usuario, contraseña, correo, fechaNacimiento, estado, pIngresos, pEstatura);
			usuarios.add(nueva);
		}
	}
	
	public void agregarMujer(String nombre, int edad, int id, String apellido1, String apellido2, char sexo, String usuario,
			String contraseña, String correo, String fechaNacimiento, char estado, double pIngresos, double pEstatura, int pDivorcios)
	{
		Persona nueva = buscarUsuario(usuario);
		if(nueva == null)
		{
			nueva = new Mujer(nombre, edad, id, apellido1, apellido2, sexo, usuario, contraseña, correo, fechaNacimiento, estado, pDivorcios);
			usuarios.add(nueva);
		}
	}
	
	public void Modificar(String nombre, String usuario, String apellido1, String apellido2, String contraseña, char estado)
	{
		Persona modificar = buscarUsuario(usuario);
		if(modificar!=null)
		{
			modificar.setNombre(nombre);
			modificar.setApellido1(apellido1);
			modificar.setApellido2(apellido2);
			modificar.setContraseña(contraseña);
			modificar.setEstado(estado);
		}
	}
	
	public void Eliminar(String usuario)
	{
		Persona eliminar = buscarUsuario(usuario);
		if(eliminar!=null)
		{
			usuarios.remove(eliminar);
		}
	}
	
	public void Likes(Persona p1)
	{
		usuarios.get(numero).setLikesRecibidos(usuarios.get(numero).getLikesRecibidos()+1);
		p1.setLikesOtorgados(p1.getLikesOtorgados()+1);
	}
	
	public Persona usuarioAleatorio() 
	{
		numero = (int) (Math.random()*usuarios.size());
		return usuarios.get(numero);
	}
	
	public void ordenarBurbuja()
	{
		
	}
	
	public void ordenarSeleccion()
	{
		for(int i=0; i<usuarios.size();i++)
		{
			int apuntador = usuarios.get(i).getLikesRecibidos();
			for(int j=i+1; j<usuarios.size(); j++)
			{
				int a = usuarios.get(j).getLikesRecibidos();
				if(a<apuntador)
				{
					aux = a;
					a = apuntador;
					apuntador = aux;
				}
			}
		}
	}
}
