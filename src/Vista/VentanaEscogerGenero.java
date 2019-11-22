package Vista;

import java.awt.Color;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class VentanaEscogerGenero extends JFrame {
	JButton mujer;
	JButton hombre;
	ImageIcon mujerIcon;
	ImageIcon hombreIcon;
	ImageIcon fondoIcon;
	JLabel preguntaJLabel;

	public VentanaEscogerGenero() {
		setIconImage(new ImageIcon(getClass().getResource("/Imagenes/Logo.png")).getImage());
		setTitle("GENERO");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(null);
		setResizable(false);
		getContentPane().setBackground(Color.white);
		setBounds(0, 0, 400, 200);
		setLocationRelativeTo(null);

		fondoIcon = new ImageIcon(getClass().getResource("/Imagenes/genero.png"));
		ImageIcon newImage = new ImageIcon(fondoIcon.getImage().getScaledInstance(400, 200, Image.SCALE_SMOOTH));
		preguntaJLabel = new JLabel(newImage);

		hombre = new JButton();
		hombre.setActionCommand("hombre");
		hombreIcon = new ImageIcon(getClass().getResource("/Imagenes/hombre.png"));
		ImageIcon newHombre = new ImageIcon(hombreIcon.getImage().getScaledInstance(150, 50, Image.SCALE_SMOOTH));
		hombre.setIcon(newHombre);
		hombre.setOpaque(true);
		hombre.setFocusPainted(false);
		hombre.setBorder(null);
		hombre.setContentAreaFilled(false);

		mujer = new JButton();
		mujer.setActionCommand("mujer");
		mujerIcon = new ImageIcon(getClass().getResource("/Imagenes/mujer.png"));
		ImageIcon newmujer = new ImageIcon(mujerIcon.getImage().getScaledInstance(150, 50, Image.SCALE_SMOOTH));
		mujer.setIcon(newmujer);
		mujer.setOpaque(true);
		mujer.setFocusPainted(false);
		mujer.setBorder(null);
		mujer.setContentAreaFilled(false);

		add(mujer).setBounds(210, 100, 150, 50);
		add(hombre).setBounds(40, 100, 150, 50);
		add(preguntaJLabel).setBounds(0, 0, 400, 200);

	}

	public JButton getMujer() {
		return mujer;
	}

	public void setMujer(JButton mujer) {
		this.mujer = mujer;
	}

	public JButton getHombre() {
		return hombre;
	}

	public void setHombre(JButton hombre) {
		this.hombre = hombre;
	}

	public ImageIcon getMujerIcon() {
		return mujerIcon;
	}

	public void setMujerIcon(ImageIcon mujerIcon) {
		this.mujerIcon = mujerIcon;
	}

	public ImageIcon getHombreIcon() {
		return hombreIcon;
	}

	public void setHombreIcon(ImageIcon hombreIcon) {
		this.hombreIcon = hombreIcon;
	}

	public ImageIcon getFondoIcon() {
		return fondoIcon;
	}

	public void setFondoIcon(ImageIcon fondoIcon) {
		this.fondoIcon = fondoIcon;
	}

	public JLabel getPreguntaJLabel() {
		return preguntaJLabel;
	}

	public void setPreguntaJLabel(JLabel preguntaJLabel) {
		this.preguntaJLabel = preguntaJLabel;
	}

}
