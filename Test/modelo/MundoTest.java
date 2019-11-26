package modelo;

import junit.framework.TestCase;
import org.junit.Test;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class MundoTest extends TestCase {

  private Hombre a;
  private Hombre b;
  private Mujer c;
  private Mujer d;
  private Mundo m;
  private ArrayList<Persona> temp;
  private ArrayList<Persona> personas;

  public MundoTest(){

   try{
     setupScenario();
   } catch (Exception e){
     e.printStackTrace();
   }
  }

  public void setupScenario() throws Exception{
    super.setUp();
    a = new Hombre("Jairo",13215, "Perez","Penagos",'H',"japerezp", "1234","japerezp@unbosque.edu.co","02/02/2000",1000.23,1.73);
    b = new Hombre("Juan",16455, "Perez","Jaramillo",'H',"adperezj", "1234","jdperezj@unbosque.edu.co","29/06/1998",1000.23,1.73);
    c = new Mujer("Gladys",12151,"Jaramillo","Contreras",'M', "gjaramilloc", "1234", "gjaramilloc@unbosque.edu.co", "26/12/1996",true);
    d = new Mujer("Paola",1514,"Jara","Ruiz",'M', "paolaj", "1234", "paolaj@unbosque.edu.co", "21/05/1968",true);
    m = new Mundo();
    personas = new ArrayList<Persona>();
    personas.add(a);
    personas.add(c);
    temp = new ArrayList<Persona>();
  }

  public ArrayList ordenaredad()
  {
    temp.add(a);
    temp.add(b);
    temp.add(c);
    temp.add(d);
    return temp;
  }

  public ArrayList ordenarnombre()
  {
    temp.add(c);
    temp.add(b);
    temp.add(a);
    temp.add(d);
    return temp;
  }

  public ArrayList ordenarapellido()
  {
    temp.add(c);
    temp.add(d);
    temp.add(a);
    temp.add(b);
    return temp;
  }

  public ArrayList ordenarusuario()
  {
    temp.add(b);
    temp.add(c);
    temp.add(a);
    temp.add(d);
    return temp;
  }

  @Test
  public void testbuscarUsuario() {
    assertEquals(null,m.buscarUsuario(a.getUsuario()));
    assertEquals(null, m.buscarUsuario(c.getUsuario()));
  }

  @Test
  public void testbuscarContraseña() {
    assertEquals(false, m.buscarContraseña(a.getUsuario(),a.getContraseña()));
    assertEquals(false, m.buscarContraseña(c.getUsuario(),c.getContraseña()));
  }

  @Test
  public void testagregarHombre() {
    try {
    assertEquals(false, m.agregarHombre(b.getNombre(),b.getId(),b.getApellido1(),b.getApellido2(),b.getSexo(),b.getUsuario(),b.getContraseña(),b.getCorreo(), Date.from(b.getFechaNacimiento().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()),b.getIngresos(),b.getIngresos()));
  } catch (IOException e){
      e.printStackTrace();
    }
  }

  @Test
  public void testagregarMujer() {
    try {
      assertEquals(false,m.agregarMujer(d.getNombre(),d.getId(),d.getApellido1(),d.getApellido2(),d.getSexo(),d.getUsuario(),d.getContraseña(),d.getCorreo(),Date.from(d.getFechaNacimiento().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()), d.getDivorcios()));
    } catch (IOException e){
      e.printStackTrace();
    }
  }

  @Test
  public void testmodificar() {
    try {
      assertEquals(false, m.modificar("Jairo", a.getUsuario(), "Cruz", "Avila", "147"));
    }
    catch (IOException e){
      e.printStackTrace();
    }
  }

  @Test
  public void testeliminar() {
    assertEquals(false,m.eliminar(a.getUsuario()));
  }

  @Test
  public void testordenarEdad() {
    assertEquals(m.ordenarEdad(),m.ordenarEdad());
  }

  @Test
  public void testordenarNombre() {
    assertEquals(m.ordenarNombre(), m.ordenarNombre());
  }

  @Test
  public void testordenarApellido() {
    assertEquals(m.ordenarApellido(),m.ordenarApellido());
  }

  @Test
  public void testordenarUsuario() {
    assertEquals(m.ordenarUsuario(), m.ordenarUsuario());
  }
}