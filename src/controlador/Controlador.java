package controlador;

import Vista.VentanaAdministrador;
import Vista.VentanaBienvenida;
import com.itextpdf.text.DocumentException;
import modelo.Mundo;
import modelo.Persona;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Controlador implements ActionListener{
  private VentanaBienvenida vb;
	private Mundo m;
  private Persona p1;
  private VentanaAdministrador va;

	public Controlador() throws ClassNotFoundException, IOException, DocumentException {
		m = new Mundo();
		vb = new VentanaBienvenida(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ImageIcon Icono = new ImageIcon(getClass().getResource("/Imagenes/logo.png"));
		ImageIcon newIcono = new ImageIcon(vb.getLogoIcon().getImage().getScaledInstance(70, 80, Image.SCALE_SMOOTH));

		if (e.getActionCommand().equals("iniciar")) {
			vb.getVl().setVisible(true);
			vb.setVisible(false);

		} else if (e.getActionCommand().equals("registrar")) {
			vb.setVisible(false);
			vb.getVeg().setVisible(true);
		} else if (e.getActionCommand().equals("tc")) {
			System.out.println("TERMINOS Y CONDICIONES");

		} else if (e.getActionCommand().equals("hombre")) {
			vb.getVeg().setVisible(false);			
			vb.getVrh().setVisible(true);

		} else if (e.getActionCommand().equals("mujer")) {
			vb.getVeg().setVisible(false);
			vb.getVrm().setVisible(true);

		} else if (e.getActionCommand().equals("cambiarfotoH")) {
			JFileChooser f = new JFileChooser();
			f.showOpenDialog(f);
			File m = f.getSelectedFile();
			if(m!=null)
			{
				ImageIcon a = new ImageIcon(m.toString());
				Icon icono = new ImageIcon(a.getImage());
				vb.getVrh().getFoto().setIcon(icono);
			}

		} else if (e.getActionCommand().equals("cambiarfotoM")) {
			JFileChooser f = new JFileChooser();
			f.showOpenDialog(f);
			File m = f.getSelectedFile();
			if(m!=null)
			{
				ImageIcon a = new ImageIcon(m.toString());
				Icon icono = new ImageIcon(a.getImage());
				vb.getVrh().getFoto().setIcon(icono);
			}

		} else if (e.getActionCommand().equals("siguienteH")) {
			vb.getVrh().setVisible(false);
			vb.getVrm().setVisible(false);
			vb.getVuc().setVisible(true);

		} else if (e.getActionCommand().equals("siguienteM")) {
			vb.getVrh().setVisible(false);
			vb.getVrm().setVisible(false);
			vb.getVuc().setVisible(true);
		} else if (e.getActionCommand().equals("iniciarsesion")) {
			vb.getVl().setVisible(false);
      if (m.buscarContraseña(vb.getVl().getUsuario_().getText(), vb.getVl().getContraseña_().getText()) == true) {
        p1 = m.buscarUsuario(vb.getVl().getUsuario_().getText());
        p1.validarEdad();

        if (m.buscarUsuario(vb.getVl().getUsuario_().getText()).getEstado() == 'M') {
          JOptionPane.showMessageDialog(null, "USUARIO MENOR DE EDAD, VUELVE CUANDO TENGAS 18 AñOS");
        } else {
          vb.getVi().setVisible(true);
        }
			}else {
        JOptionPane.showMessageDialog(null, "USUARIO O CONTRASEñA INVALIDOS");
				vb.getVl().setVisible(true);
			}
      vb.getVl().getUsuario_().setText("");
      vb.getVl().getContraseña_().setText("");

		} else if (e.getActionCommand().equals("listo")) {
      vb.getVcc().setVisible(false);
			vb.getVfr().setVisible(true);

		} else if (e.getActionCommand().equals("reenviar")) {

			if(vb.getVrm().getNombre_().getText().length()==0&&vb.getVrh().getNombre_().getText().length()!=0) {
        m.enviarConGMail(vb.getVrh().getCorreo_().getText(), "Su nombre de usuario es: " + vb.getVuc().getUsuario_().getText() + "\n" + "Su contraseña es: " + vb.getVuc().getContraseña_().getText());

			}else {
        m.enviarConGMail(vb.getVrm().getCorreo_().getText(), "Su nombre de usuario es: " + vb.getVuc().getUsuario_().getText() + "\n" + "Su contraseña es: " + vb.getVuc().getContraseña_().getText());
			}

		} else if (e.getActionCommand().equals("guardar")) {
			boolean agrego = false;
			if(vb.getVrm().getNombre_().getText().length()==0&&vb.getVrh().getNombre_().getText().length()!=0) {
				try {
					agrego = m.agregarHombre(vb.getVrh().getNombre_().getText(), Long.parseLong(vb.getVrh().getiden_().getText().replace(",","")), vb.getVrh().getApellidos_().getText(), vb.getVrh().getApellidos_().getText(), 'H', vb.getVuc().getUsuario_().getText(), vb.getVuc().getContraseña_().getText(), vb.getVrh().getCorreo_().getText(), vb.getVrh().getFecha_().getDate(), Double.parseDouble(vb.getVrh().getIngresos_().getText().replace(",", "")), Double.parseDouble(vb.getVrh().getEstatura_().getText()));
          if (agrego){
						vb.getVuc().setVisible(false);
						m.enviarConGMail(vb.getVrh().getCorreo_().getText(), "Su nombre de usuario es: " + vb.getVuc().getUsuario_().getText() + "\n" + "Su contraseña es: " + vb.getVuc().getContraseña_().getText());
						vb.getVcc().setVisible(true);
          } else {
          	JOptionPane.showMessageDialog(null, "Error, ya existe alguien con este usuario");
					}
				} catch (NumberFormatException | IOException e1) {
					e1.printStackTrace();
				}
			}else {
				try {
					boolean divorcios;
					if(vb.getVrm().getDivorcios_si().isSelected())
					{
						divorcios = true;
					}
					else
					{
						divorcios = false;
					}
					agrego = m.agregarMujer(vb.getVrh().getNombre_().getText(), Long.parseLong(vb.getVrm().getiden_().getText().replace(",","")), vb.getVrh().getApellidos_().getText(), vb.getVrh().getApellidos_().getText(), 'M', vb.getVuc().getUsuario_().getText(), vb.getVuc().getContraseña_().getText(), vb.getVrh().getCorreo_().getText(), vb.getVrh().getFecha_().getDate(), divorcios);
					if (agrego){
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


		} else if (e.getActionCommand().equals("listofin")) {
			vb.getVfr().setVisible(false);
			if(vb.getVuc().getUsuario_().getText().length()==0) {
				p1 = m.buscarUsuario(vb.getVl().getUsuario_().getText());
			}else if(vb.getVl().getUsuario_().getText().length()==0) {
				p1 = m.buscarUsuario(vb.getVuc().getUsuario_().getText());
			}
				Persona p2 = m.siguientePersona(p1);
				vb.getVi().getNombre().setText(p2.getNombre());
      vb.getVi().getApellido().setText(p2.getApellido1());
				vb.getVi().getEdad().setText(Integer.toString(p2.getEdad()));
      vb.getVuc().getUsuario_().setText("");
      vb.getVuc().getContraseña_().setText("");
			vb.getVi().setVisible(true);

		} else if (e.getActionCommand().equals("premium")) {
			System.out.println("PREMIUM");

		} else if (e.getActionCommand().equals("like")) {
			Persona p2 =  m.siguientePersona(p1);
			m.darLike(p1, p2);
      vb.getVi().getFoto_().setIcon(m.generarFoto(p1, p2));
			vb.getVi().getNombre().setText(p2.getNombre());
			vb.getVi().getEdad().setText(Integer.toString(p2.getEdad()));
      vb.getVi().getApellido().setText(p2.getApellido1());

		} else if (e.getActionCommand().equals("dislike")) {
				Persona p2 = m.siguientePersona(p1);
				vb.getVi().getFoto_().setIcon(m.generarFoto(p1, p2));
				vb.getVi().getNombre().setText(p2.getNombre());
				vb.getVi().getEdad().setText(Integer.toString(p2.getEdad()));
				vb.getVi().getApellido().setText(p2.getApellido1());

    } else if (e.getActionCommand().equals("cerrarsesion")) {
      vb.getVi().setVisible(false);
      vb.setVisible(true);
    } else if (e.getActionCommand().equals("pdf")) {
      try {
        m.generarPDF();
      } catch (DocumentException | IOException e2) {
        JOptionPane.showMessageDialog(null, "Error al generar el PDF");
      }
    } else if (e.getActionCommand().equals("eliminar")) {
      m.eliminar(vb.getVa().getPlu().getlistaUsuarios().getSelectedValue());
    }
  }
}
