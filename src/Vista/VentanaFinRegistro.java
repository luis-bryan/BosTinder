package Vista;

import javax.swing.*;
import java.awt.*;

public class VentanaFinRegistro extends JFrame {
	private ImageIcon fondo;
	private JLabel fondo_;
	private JButton listo;
	private ImageIcon listoIcon;

	public VentanaFinRegistro() {
		setIconImage(new ImageIcon(getClass().getResource("/Imagenes/Logo.png")).getImage());
		setTitle("INICIAR SESION");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(null);
		setResizable(false);
		getContentPane().setBackground(Color.white);
		setBounds(0, 0, 350, 350);
		setLocationRelativeTo(null);

		fondo = new ImageIcon(getClass().getResource("/Imagenes/finregistro.png"));
		fondo_ = new JLabel(fondo);
		ImageIcon newFondo = new ImageIcon(fondo.getImage().getScaledInstance(350, 350, Image.SCALE_SMOOTH));
		fondo_ = new JLabel(newFondo);

		listo = new JButton();
		listo.setActionCommand("listofin");
		listoIcon = new ImageIcon(getClass().getResource("/Imagenes/listo.png"));
		ImageIcon newlisto = new ImageIcon(listoIcon.getImage().getScaledInstance(140, 50, Image.SCALE_SMOOTH));
		listo.setIcon(newlisto);
		listo.setOpaque(true);
		listo.setFocusPainted(false);
		listo.setBorder(null);
		listo.setContentAreaFilled(false);

		add(listo).setBounds(90, 260, 150, 50);
		add(fondo_).setBounds(0, 0, 350, 350);

		setVisible(false);

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

	public JButton getListo() {
		return listo;
	}

	public void setListo(JButton listo) {
		this.listo = listo;
	}

	public ImageIcon getListoIcon() {
		return listoIcon;
	}

	public void setListoIcon(ImageIcon listoIcon) {
		this.listoIcon = listoIcon;
	}

}
