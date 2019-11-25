package Vista;

import javax.swing.*;
import java.awt.*;

public class VentanaLogueo extends JFrame {
	private JButton iniciar;
	private ImageIcon iniciarIcon;
	private JLabel usuario;
	private JLabel contraseña;
	private JTextField usuario_;
	private JPasswordField contraseña_;
	private ImageIcon fondo;
	private JLabel fondo_;

	public VentanaLogueo() {

		setIconImage(new ImageIcon(getClass().getResource("/Imagenes/Logo.png")).getImage());
		setTitle("INICIAR SESION");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(null);
		setResizable(false);
		getContentPane().setBackground(Color.white);
		setBounds(0, 0, 380, 300);
		setLocationRelativeTo(null);

		Font fuente = new Font("Tahoma", 1, 15);

		fondo = new ImageIcon(getClass().getResource("/Imagenes/fondoLogueo.png"));
		fondo_ = new JLabel(fondo);
		ImageIcon newFondo = new ImageIcon(fondo.getImage().getScaledInstance(400, 300, Image.SCALE_SMOOTH));
		fondo_ = new JLabel(newFondo);

		iniciar = new JButton();
		iniciar.setActionCommand("iniciarsesion");
		iniciarIcon = new ImageIcon(getClass().getResource("/Imagenes/iniciarsesionlogueo.png"));
		ImageIcon newIniciar = new ImageIcon(iniciarIcon.getImage().getScaledInstance(200, 60, Image.SCALE_SMOOTH));
		iniciar.setIcon(newIniciar);
		iniciar.setOpaque(true);
		iniciar.setFocusPainted(false);
		iniciar.setBorder(null);
		iniciar.setContentAreaFilled(false);

		usuario = new JLabel("USUARIO:");
		usuario.setFont(fuente);
		usuario_ = new JTextField();

    contraseña = new JLabel("CONTRASEÑA:");
    contraseña.setFont(fuente);
    contraseña_ = new JPasswordField();

		add(usuario).setBounds(40, 90, 150, 30);
		add(usuario_).setBounds(150, 90, 200, 30);
    add(contraseña).setBounds(30, 130, 150, 30);
    add(contraseña_).setBounds(150, 130, 200, 30);
		add(iniciar).setBounds(90, 185, 200, 60);
		add(fondo_).setBounds(0, 0, 400, 300);

		setVisible(false);
	}

	public JButton getIniciar() {
		return iniciar;
	}

	public void setIniciar(JButton iniciar) {
		this.iniciar = iniciar;
	}

	public ImageIcon getIniciarIcon() {
		return iniciarIcon;
	}

	public void setIniciarIcon(ImageIcon iniciarIcon) {
		this.iniciarIcon = iniciarIcon;
	}

	public JLabel getUsuario() {
		return usuario;
	}

	public void setUsuario(JLabel usuario) {
		this.usuario = usuario;
	}

  public JLabel getContraseña() {
    return contraseña;
  }

  public void setContraseña(JLabel contraseña) {
    this.contraseña = contraseña;
	}

	public JTextField getUsuario_() {
		return usuario_;
	}

	public void setUsuario_(JTextField usuario_) {
		this.usuario_ = usuario_;
	}

  public JPasswordField getContraseña_() {
    return contraseña_;
  }

  public void setContraseña_(JPasswordField contraseña_) {
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
}
