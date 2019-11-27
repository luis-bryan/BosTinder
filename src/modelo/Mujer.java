package modelo;

import java.io.Serializable;
import java.util.ArrayList;

public class Mujer extends Persona implements Serializable
{

	private static final long serialVersionUID = 1L;

	private boolean divorcios;
  private ArrayList<Persona> match;

  /**
   * Constructor para la creacion de una mujer
   *
   * @param nombre
   * @param id
   * @param apellido1
   * @param apellido2
   * @param sexo
   * @param usuario
   * @param contraseña
   * @param correo
   * @param fechaNacimiento
   * @param divorcios
   * @throws AssertionError
   */
  public Mujer(String nombre, long id, String apellido1, String apellido2, char sexo, String usuario,
               String contraseña, String correo, String fechaNacimiento, boolean divorcios) throws AssertionError {
    super(nombre, id, apellido1, apellido2, sexo, usuario, contraseña, correo, fechaNacimiento);
    this.divorcios = divorcios;
    verificarInvariante();
    match = new ArrayList<>();
  }

  /**
   * Constructor completo de la clase Mujer
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
   * @param divorcios
   */
  public Mujer(String nombre, int edad, long id, String apellido1, String apellido2, char sexo, String usuario,
               String contraseña, String correo, String fechaNacimiento, int likesRecibidos, int likesOtorgados,
               int matches, char estado, boolean divorcios) {
    super(nombre, edad, id, apellido1, apellido2, sexo, usuario, contraseña, correo, fechaNacimiento, likesRecibidos, likesOtorgados, matches, estado);
    this.divorcios = divorcios;
    match = new ArrayList<>();
  }

  /**
   * Obtiene los divorcios de la mujer
   *
   * @return divorcios
   */
  public boolean getDivorcios() {
    return divorcios;
  }

  /**
   * Modifica los divorcios de la mujer
   *
   * @param divorcios boolean por asignar
   */
  public void setDivorcios(boolean divorcios) {
    this.divorcios = divorcios;
  }

  /**
   * Obtiene la lista de personas a las que le dio like
   *
   * @return lista de matches
   */
  public ArrayList<Persona> getMatch() {
    return match;
  }

  /**
   * modifica la lista de personas a las que les dio like
   *
   * @param match lista por asignar
   */
  public void setMatch(ArrayList<Persona> match) {
    this.match = match;
  }

  /**
   * Metodo que verifica invariantes y evalua cada dato ingresado
   *
   * @throws AssertionError en caso que no se cumpla algun invariante
   */
  public void verificarInvariante() throws AssertionError {
    assert (nombre != null && !nombre.equals(" ")) : "El nombre no puede estar vacio";
    assert (!nombre.contains(";")) : "El nombre no puede contener caracteres especiales";
    assert (edad > 18) : "La edad debe ser mayor a 18";
    assert (apellido1 != null && !apellido1.equals(" ")) : "El apellido no puede estar vacio";
    assert (!apellido1.contains(";")) : "El apellido no puede contener caracteres especiales";
    assert (apellido2 != null && !apellido2.equals(" ")) : "El apellido no puede estar vacio";
    assert (!apellido2.contains(";")) : "El apellido no puede contener caracteres especiales";
    assert (sexo == 'H' || sexo == 'M') : "El sexo solo adimite el valor de H o M";
    assert (usuario != null && !usuario.equals(" ")) : "El usuario no es valido";
    assert (!usuario.contains(";")) : "El usuario no puede tener caracteres especiales";
    assert (contraseña != null && !contraseña.equals(" ")) : "La contrasela no es valida";
    assert (correo.contains("@") && !correo.contains(";")) : "El correo no es valido";
    //assert(fechaNacimiento.toString().contains("[0-9\\/]")):"La fecha de nacimiento no es valida";
    assert (estado == 'D' || estado == 'I' || estado == 'M') : "El estado solo admite valores de D, I o M";
  }

  /**
   * Busca a una persona dentro del arreglo
   * @param usuario UserName a buscar
   * @return true si existe, false si no
   */
  public boolean buscarUsuario(String usuario) {
    boolean aux = false;
    if (!match.isEmpty()) {
      for (int i = 0; i < match.size(); i++) {
        if (match.get(i).getUsuario().equals(usuario)) {
          aux = true;
        }
      }
    }
    return aux;
  }
}
