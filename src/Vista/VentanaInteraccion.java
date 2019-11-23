package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class VentanaInteraccion extends JFrame {
	ImageIcon fondo;
	JLabel fondo_;
	JLabel foto_;
	ImageIcon foto;
	JLabel nombre;
	JLabel edad;
	ImageIcon botones;
	JLabel botones_;
	JButton premium;
	JButton like;
	JButton dislike;
	JLabel apellido;

	public VentanaInteraccion() {
		setIconImage(new ImageIcon(getClass().getResource("/Imagenes/Logo.png")).getImage());
		setTitle("BOSTINDER");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(null);
		setResizable(false);
		getContentPane().setBackground(Color.white);
		setBounds(0, 0, 400, 680);
		setLocationRelativeTo(null);

		Font fuente = new Font("Tahoma", 1, 40);
		Font fuente2 = new Font("Tahoma", 1, 30);

		fondo = new ImageIcon(getClass().getResource("/Imagenes/fondo.png"));
		fondo_ = new JLabel(fondo);

		foto = new ImageIcon(getClass().getResource("/Imagenes/sara.png"));
		ImageIcon newImage = new ImageIcon(foto.getImage().getScaledInstance(375, 300, Image.SCALE_SMOOTH));
		foto_ = new JLabel(newImage);

		nombre = new JLabel("SARA");
		nombre.setFont(fuente);
		apellido = new JLabel("ORREGO");
		apellido.setFont(fuente2);

		edad = new JLabel("21");
		edad.setFont(fuente);

		like = new JButton("LIKE");
		like.setActionCommand("like");
		like.setOpaque(false);
		like.setFocusPainted(false);
		like.setBorder(null);
		like.setContentAreaFilled(false);


		dislike = new JButton("DISLIKE");
		dislike.setActionCommand("dislike");
		dislike.setOpaque(false);
		dislike.setFocusPainted(false);
		dislike.setBorder(null);
		dislike.setContentAreaFilled(false);

		premium = new JButton(":)");
		premium.setActionCommand("premium");
		premium.setOpaque(false);
		premium.setFocusPainted(false);
		premium.setBorder(null);
		premium.setContentAreaFilled(false);
		

		botones = new ImageIcon(getClass().getResource("/Imagenes/botonesinteraccion.png"));
		ImageIcon newBotones = new ImageIcon(botones.getImage().getScaledInstance(350, 170, Image.SCALE_SMOOTH));
		botones_ = new JLabel(newBotones);

		add(foto_).setBounds(10, 20, 375, 300);
		add(nombre).setBounds(50, 250, 400, 200);
		add(apellido).setBounds(75, 280, 400, 200);
		add(edad).setBounds(170, 340, 100, 150);
		add(botones_).setBounds(20, 450, 350, 170);
		add(premium).setBounds(50, 490, 50, 50);
		add(dislike).setBounds(135, 500, 85, 85);
		add(like).setBounds(260, 500, 85, 85);
		add(fondo_).setBounds(-10, 0, 750, 690);

	}

	public JLabel getFoto_() {
		return foto_;
	}

	public void setFoto_(JLabel foto_) {
		this.foto_ = foto_;
	}

	public ImageIcon getFoto() {
		return foto;
	}

	public void setFoto(ImageIcon foto) {
		this.foto = foto;
	}

	public JLabel getNombre() {
		return nombre;
	}

	public void setNombre(JLabel nombre) {
		this.nombre = nombre;
	}

	public JLabel getEdad() {
		return edad;
	}

	public void setEdad(JLabel edad) {
		this.edad = edad;
	}

	public ImageIcon getBotones() {
		return botones;
	}

	public void setBotones(ImageIcon botones) {
		this.botones = botones;
	}

	public JLabel getBotones_() {
		return botones_;
	}

	public void setBotones_(JLabel botones_) {
		this.botones_ = botones_;
	}

	public JButton getPremium() {
		return premium;
	}

	public void setPremium(JButton premium) {
		this.premium = premium;
	}

	public JButton getLike() {
		return like;
	}

	public void setLike(JButton like) {
		this.like = like;
	}

	public JButton getDislike() {
		return dislike;
	}

	public void setDislike(JButton dislike) {
		this.dislike = dislike;
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

	public JLabel getApellido() {
		return apellido;
	}

	public void setApellido(JLabel apellido) {
		this.apellido = apellido;
	}
	

}
