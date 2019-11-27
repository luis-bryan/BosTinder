package Vista;

import java.awt.Color;
import java.awt.Image;

import javax.swing.*;

public class VentanaTerminos extends JFrame {
	JTextArea informacion;
	JButton aceptar;
	ImageIcon aceptarIcon;
	JLabel fondo;
	ImageIcon fondo_;

	public VentanaTerminos() {
		setIconImage(new ImageIcon(getClass().getResource("/Imagenes/Logo.png")).getImage());
		setTitle("TERMINOS Y CONDICIONES");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setResizable(false);
		getContentPane().setBackground(Color.white);
		setBounds(0, 0, 500, 680);
		setLocationRelativeTo(null);

		fondo_ = new ImageIcon(getClass().getResource("/Imagenes/fondobienvenida.png"));
		fondo = new JLabel(fondo_);

		aceptar = new JButton();
		aceptar.setActionCommand("aceptarterminos");
		aceptarIcon = new ImageIcon(getClass().getResource("/Imagenes/listo.png"));
		ImageIcon newAceptar = new ImageIcon(aceptarIcon.getImage().getScaledInstance(200, 70, Image.SCALE_SMOOTH));
		aceptar.setIcon(newAceptar);
		aceptar.setOpaque(true);
		aceptar.setFocusPainted(false);
		aceptar.setBorder(null);
		aceptar.setContentAreaFilled(false);

		informacion = new JTextArea();
		informacion.setOpaque(false);
		informacion.setEditable(false);
		informacion.setText("\t\tT�rminos y Condiciones\n" + "14 de noviembre del 2019\n"
				+ "Bienvenido a Bostrinder, aplicaci�n desarrollada por la empresa \n"
        + "LBFSCorporation. Al momento de usted suscribirse a la aplicaci�n,\n"
        + "le llegar� un correo en donde se le har� llegar el usuario y la \n"
        + "contrase�a para el ingreso a la plataforma. Al ingresar a la plataforma\n"
        + "se encontrar� con muchos usuarios que desean una cita con alguien especial.\n"
        + "Si usted es un hombre, la plataforma est� dise�ada para que solo \n"
				+ "aparezcan mujeres y viceversa.\n"
				+ "Tambi�n tiene la opci�n de eliminar su cuenta, pero debemos conocer el motivo\n"
        + "de su salida, para ello cont�ctese por el correo electr�nico: tinderbos@gmail.com\n"
        + "y nos cuenta cu�l es su motivo para eliminar la cuenta. \n"
				+ "La comunidad debe tener restricciones al momento de suscribirse como, por ejemplo:\n"
				+ "Im�genes obscenas\n" + "Nombres inadecuados\n" + "Debe ser mayor de 18 a�os\n"
				+ "Manejar un lenguaje apto con los otros usuarios\n"
				+ "Para m�s informaci�n, lea la pol�tica de privacidad\n" + "Cordial Saludo y disfruta BosTinder.\n");

		add(informacion).setBounds(10, 10, 500, 400);
		add(aceptar).setBounds(150, 550, 200, 70);
		add(fondo).setBounds(0, 0, 750, 690);
    setVisible(false);
	}

	public JTextArea getInformacion() {
		return informacion;
	}

	public void setInformacion(JTextArea informacion) {
		this.informacion = informacion;
	}

	public JButton getAceptar() {
		return aceptar;
	}

	public void setAceptar(JButton aceptar) {
		this.aceptar = aceptar;
	}

	public ImageIcon getAceptarIcon() {
		return aceptarIcon;
	}

	public void setAceptarIcon(ImageIcon aceptarIcon) {
		this.aceptarIcon = aceptarIcon;
	}

	public JLabel getFondo() {
		return fondo;
	}

	public void setFondo(JLabel fondo) {
		this.fondo = fondo;
	}

	public ImageIcon getFondo_() {
		return fondo_;
	}

	public void setFondo_(ImageIcon fondo_) {
		this.fondo_ = fondo_;
	}

}
