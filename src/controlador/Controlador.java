package controlador;

import Vista.*;
import com.itextpdf.text.DocumentException;
import modelo.Hombre;
import modelo.Mujer;
import modelo.Mundo;
import modelo.Persona;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Controlador implements ActionListener {
  private VentanaBienvenida vb;
  private Mundo m;
  private Persona p1;
  private Persona p2;

  /**
   * Construye un objeto de la clase Controlador, encargada de tener centralizados las acciones del programa
   *
   * @throws ClassNotFoundException En caso que no se encuentre una clase
   * @throws IOException            En caso que haya algun problema con el sistema de archivos
   */
  public Controlador() throws ClassNotFoundException, IOException {
    m = new Mundo();
    vb = new VentanaBienvenida(this);
  }

  /**
   * <b>pre:</b>
   * Todos los botones han agregado su actionListener a un objeto de esta clase
   * <b>post:</b>
   * Se ejecuta la accion especifica de cada boton.
   * Se encarga de controlar todas las interacciones del usuario con el programa, define que hace cada boton.
   *
   * @param e El ActionEvent que disparo la ejecucion del metodo
   */
  @Override
  public void actionPerformed(ActionEvent e) {

    if (e.getActionCommand().equals("iniciar")) {
      vb.getVl().setVisible(true);
      vb.setVisible(false);

    } else if (e.getActionCommand().equals("registrar")) {
      vb.setVisible(false);
      vb.getVeg().setVisible(true);
    } else if (e.getActionCommand().equals("tc")) {
      VentanaTerminos vt = new VentanaTerminos();

    } else if (e.getActionCommand().equals("hombre")) {
      vb.getVeg().setVisible(false);
      vb.getVrh().setVisible(true);

    } else if (e.getActionCommand().equals("mujer")) {
      vb.getVeg().setVisible(false);
      vb.getVrm().setVisible(true);

    } else if (e.getActionCommand().equals("cambiarfotoH")) {
      cambiarFotoHombre();
    } else if (e.getActionCommand().equals("cambiarfotoM")) {
      cambiarFotoMujer();
    } else if (e.getActionCommand().equals("siguienteH")) {
      vb.getVrh().setVisible(false);
      vb.getVrm().setVisible(false);
      vb.getVuc().setVisible(true);

    } else if (e.getActionCommand().equals("siguienteM")) {
      vb.getVrh().setVisible(false);
      vb.getVrm().setVisible(false);
      vb.getVuc().setVisible(true);
    } else if (e.getActionCommand().equals("iniciarsesion")) {
      iniciarSesion();
    } else if (e.getActionCommand().equals("listo")) {
      vb.getVcc().setVisible(false);
      vb.getVfr().setVisible(true);

    } else if (e.getActionCommand().equals("reenviar")) {

      if (vb.getVrm().getNombre_().getText().length() == 0 && vb.getVrh().getNombre_().getText().length() != 0) {
        m.enviarConGMail(vb.getVrh().getCorreo_().getText(), "Su nombre de usuario es: " + vb.getVuc().getUsuario_().getText() + "\n" + "Su contraseña es: " + vb.getVuc().getContraseña_().getText());

      } else {
        m.enviarConGMail(vb.getVrm().getCorreo_().getText(), "Su nombre de usuario es: " + vb.getVuc().getUsuario_().getText() + "\n" + "Su contraseña es: " + vb.getVuc().getContraseña_().getText());
      }
    } else if (e.getActionCommand().equals("guardar")) {
      guardarPersona();
    } else if (e.getActionCommand().equals("listofin")) {
      luegoDeCrear();
    } else if (e.getActionCommand().equals("premium")) {
      VentanaPremium p = new VentanaPremium();

    } else if (e.getActionCommand().equals("like")) {
      like();
    } else if (e.getActionCommand().equals("dislike")) {
      dislike();
    } else if (e.getActionCommand().equals("cerrarsesion")) {
      vb.getVi().setVisible(false);
      vb.setVisible(true);
      vb.getVa().setVisible(false);
    } else if (e.getActionCommand().equals("pdf")) {
      try {
        m.generarPDF();
      } catch (DocumentException | IOException e2) {
        JOptionPane.showMessageDialog(null, "Error al generar el PDF");
      }
    } else if (e.getActionCommand().equals("eliminar")) {
      eliminar();
    } else if (e.getActionCommand().equals("informacion")) {
      if (p2 instanceof Mujer) {
        new VentanaInfoMujer((Mujer) p2).setVisible(true);
      } else {
        new VentanaInfoHombre((Hombre) p2).setVisible(true);
      }
    }
  }

  public void cambiarFotoHombre() {
    JFileChooser f = new JFileChooser();
    f.showOpenDialog(f);
    File m = f.getSelectedFile();
    if (m != null) {
      ImageIcon a = new ImageIcon(m.toString());
      vb.getVrh().setFoto_(a);
    }
  }

  public void cambiarFotoMujer() {
    JFileChooser f = new JFileChooser();
    f.showOpenDialog(f);
    File m = f.getSelectedFile();
    if (m != null) {
      ImageIcon a = new ImageIcon(m.toString());
      vb.getVrm().setFoto_(a);
    }
  }

  public void iniciarSesion() {
    vb.getVl().setVisible(false);
    if (vb.getVl().getUsuario_().getText().equals("tinderbos") && vb.getVl().getContraseña_().getText().equals("bostinder123")) {
      vb.getVa().setVisible(true);
      vb.getVl().setVisible(false);
      DefaultListModel<String> modelo = new DefaultListModel<>();
      for (Persona p : m.getUsuarios()) {
        modelo.addElement(p.getUsuario());
      }
      vb.getVa().getPlu().setModeloLista(modelo);
      vb.getVa().getPlu().getlistaUsuarios().setModel(modelo);
    } else if (m.buscarContraseña(vb.getVl().getUsuario_().getText(), vb.getVl().getContraseña_().getText()) == true) {
      p1 = m.buscarUsuario(vb.getVl().getUsuario_().getText());
      p1.validarEdad();
      if (m.buscarUsuario(vb.getVl().getUsuario_().getText()).getEstado() == 'M') {
        JOptionPane.showMessageDialog(null, "USUARIO MENOR DE EDAD, VUELVE CUANDO TENGAS 18 AÑOS");
      } else {
        vb.getVi().setVisible(true);
        p2 = m.siguientePersona(p1);
        p2.setImagen(m.generarFoto(p2));
        vb.getVi().getFoto_().setIcon(p2.getImagen());
        vb.getVi().getNombre().setText(p2.getNombre());
        vb.getVi().getEdad().setText(Integer.toString(p2.getEdad()));
        vb.getVi().getApellido().setText(p2.getApellido1());
      }
    } else {
      JOptionPane.showMessageDialog(null, "USUARIO O CONTRASEÑA INVALIDOS");
      vb.getVl().setVisible(true);
    }
    vb.getVl().getUsuario_().setText("");
    vb.getVl().getContraseña_().setText("");
  }

  public void eliminar() {
    String toDelete = vb.getVa().getPlu().getlistaUsuarios().getSelectedValue();
    m.eliminar(toDelete);
    vb.getVa().getPlu().getModeloLista().removeElement(toDelete);
    vb.getVa().getPlu().getlistaUsuarios().setModel(vb.getVa().getPlu().getModeloLista());
  }

  public void guardarPersona() {
    boolean agrego = false;
    if (vb.getVrm().getNombre_().getText().length() == 0 && vb.getVrh().getNombre_().getText().length() != 0) {
      try {
        agrego = m.agregarHombre(vb.getVrh().getNombre_().getText(), Long.parseLong(vb.getVrh().getiden_().getText().replace(",", "")), vb.getVrh().getApellidos_().getText(), vb.getVrh().getApellidos_().getText(), 'H', vb.getVuc().getUsuario_().getText(), vb.getVuc().getContraseña_().getText(), vb.getVrh().getCorreo_().getText(), vb.getVrh().getFecha_().getDate(), Double.parseDouble(vb.getVrh().getIngresos_().getText().replace(",", "")), Double.parseDouble(vb.getVrh().getEstatura_().getText()));
        if (agrego) {
          vb.getVuc().setVisible(false);
          m.enviarConGMail(vb.getVrh().getCorreo_().getText(), "Su nombre de usuario es: " + vb.getVuc().getUsuario_().getText() + "\n" + "Su contraseña es: " + vb.getVuc().getContraseña_().getText());
          vb.getVcc().setVisible(true);
        } else {
          JOptionPane.showMessageDialog(null, "Error, ya existe alguien con este usuario");
        }
      } catch (NumberFormatException | IOException e1) {
        e1.printStackTrace();
      }
    } else {
      try {
        boolean divorcios;
        if (vb.getVrm().getDivorcios_si().isSelected()) {
          divorcios = true;
        } else {
          divorcios = false;
        }
        agrego = m.agregarMujer(vb.getVrh().getNombre_().getText(), Long.parseLong(vb.getVrm().getiden_().getText().replace(",", "")), vb.getVrh().getApellidos_().getText(), vb.getVrh().getApellidos_().getText(), 'M', vb.getVuc().getUsuario_().getText(), vb.getVuc().getContraseña_().getText(), vb.getVrh().getCorreo_().getText(), vb.getVrh().getFecha_().getDate(), divorcios);
        if (agrego) {
          vb.getVuc().setVisible(false);
          m.enviarConGMail(vb.getVrm().getCorreo_().getText(), "Su nombre de usuario es: " + vb.getVuc().getUsuario_().getText() + "\n" + "Su contraseña es: " + vb.getVuc().getContraseña_().getText());
          vb.getVcc().setVisible(true);
        } else {
          JOptionPane.showMessageDialog(null, "Error, ya existe alguien con este usuario");
        }
      } catch (NumberFormatException | IOException e1) {
        e1.printStackTrace();
      }
    }


  }

  public void like() {
    m.darLike(p1, p2);

    p2 = m.siguientePersona(p1);
    p2.setImagen(m.generarFoto(p2));
    vb.getVi().getFoto_().setIcon(p2.getImagen());
    vb.getVi().getNombre().setText(p2.getNombre());
    vb.getVi().getEdad().setText(Integer.toString(p2.getEdad()));
    vb.getVi().getApellido().setText(p2.getApellido1());
  }

  public void dislike() {
    p2 = m.siguientePersona(p1);
    p2.setImagen(m.generarFoto(p2));
    vb.getVi().getFoto_().setIcon(p2.getImagen());
    vb.getVi().getNombre().setText(p2.getNombre());
    vb.getVi().getEdad().setText(Integer.toString(p2.getEdad()));
    vb.getVi().getApellido().setText(p2.getApellido1());
  }

  public void luegoDeCrear() {
    vb.getVfr().setVisible(false);
    if (vb.getVuc().getUsuario_().getText().length() == 0) {
      p1 = m.buscarUsuario(vb.getVl().getUsuario_().getText());
    } else if (vb.getVl().getUsuario_().getText().length() == 0) {
      p1 = m.buscarUsuario(vb.getVuc().getUsuario_().getText());
    }
    p2 = m.siguientePersona(p1);
    vb.getVi().getNombre().setText(p2.getNombre());
    vb.getVi().getApellido().setText(p2.getApellido1());
    vb.getVi().getEdad().setText(Integer.toString(p2.getEdad()));
    vb.getVuc().getUsuario_().setText("");
    vb.getVuc().getContraseña_().setText("");
    vb.getVi().setVisible(true);
  }
}