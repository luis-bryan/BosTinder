package Vista;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class VentanaUsuarioContraseña extends JFrame {
	ImageIcon fondo;
	JLabel fondo_;
	JButton guardar;
	ImageIcon guardarIcon;
	JTextField usuario_;
	JTextField contraseña_;

	public VentanaUsuarioContraseña() {
		setIconImage(new ImageIcon(getClass().getResource("/Imagenes/Logo.png")).getImage());
		setTitle("INICIAR SESION");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(null);
		setResizable(false);
		getContentPane().setBackground(Color.white);
		setBounds(0, 0, 350, 350);
		setLocationRelativeTo(null);

		fondo = new ImageIcon(getClass().getResource("/Imagenes/creauc.png"));
		fondo_ = new JLabel(fondo);
		ImageIcon newFondo = new ImageIcon(fondo.getImage().getScaledInstance(350, 350, Image.SCALE_SMOOTH));
		fondo_ = new JLabel(newFondo);

		usuario_ = new JTextField();

		contraseña_ = new JTextField();

		guardar = new JButton();
		guardar.setActionCommand("guardar");
		guardarIcon = new ImageIcon(getClass().getResource("/Imagenes/guardar.png"));
		ImageIcon newguardar = new ImageIcon(guardarIcon.getImage().getScaledInstance(140, 50, Image.SCALE_SMOOTH));
		guardar.setIcon(newguardar);
		guardar.setOpaque(true);
		guardar.setFocusPainted(false);
		guardar.setBorder(null);
		guardar.setContentAreaFilled(false);

		add(guardar).setBounds(90, 260, 150, 50);
		add(usuario_).setBounds(160, 170, 160, 30);
		add(contraseña_).setBounds(180, 213, 140, 30);
		add(fondo_).setBounds(0, 0, 350, 350);

		setVisible(false);

	}

	public JTextField getUsuario_() {
		return usuario_;
	}

	public void setUsuario_(JTextField usuario_) {
		this.usuario_ = usuario_;
	}

	public JTextField getContraseña_() {
		return contraseña_;
	}

	public void setContraseña_(JTextField contraseña_) {
		this.contraseña_ = contraseña_;
	}

	public ImageIcon getFondo() {
		return fondo;
	}

	public void setFondo(ImageIcon fondo) {
		this.fondo = fondo;
	}

	public JLabel getFondo_() {
		return fondo_;
	}

	public void setFondo_(JLabel fondo_) {
		this.fondo_ = fondo_;
	}

	public JButton getGuardar() {
		return guardar;
	}

	public void setGuardar(JButton guardar) {
		this.guardar = guardar;
	}

	public ImageIcon getGuardarIcon() {
		return guardarIcon;
	}

	public void setGuardarIcon(ImageIcon guardarIcon) {
		this.guardarIcon = guardarIcon;
	}

}
