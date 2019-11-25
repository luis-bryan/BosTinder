package Vista;

import javax.swing.*;
import java.awt.*;

public class VentanaConfirmacionCorreo extends JFrame {
	private ImageIcon fondo;
	private JLabel fondo_;
	private JButton reenviar;
	private JButton listo;
	private ImageIcon reenviarIcon;
	private ImageIcon listoIcon;

	public VentanaConfirmacionCorreo() {
		setIconImage(new ImageIcon(getClass().getResource("/Imagenes/Logo.png")).getImage());
		setTitle("INICIAR SESION");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(null);
		setResizable(false);
		getContentPane().setBackground(Color.white);
		setBounds(0, 0, 350, 340);
		setLocationRelativeTo(null);

		fondo = new ImageIcon(getClass().getResource("/Imagenes/confirmacionCorreo.png"));
		fondo_ = new JLabel(fondo);
		ImageIcon newFondo = new ImageIcon(fondo.getImage().getScaledInstance(350, 340, Image.SCALE_SMOOTH));
		fondo_ = new JLabel(newFondo);

		reenviar = new JButton();
		reenviar.setActionCommand("reenviar");
		reenviarIcon = new ImageIcon(getClass().getResource("/Imagenes/reenvio.png"));
		ImageIcon newReenviar = new ImageIcon(reenviarIcon.getImage().getScaledInstance(120, 60, Image.SCALE_SMOOTH));
		reenviar.setIcon(newReenviar);
		reenviar.setOpaque(true);
		reenviar.setFocusPainted(false);
		reenviar.setBorder(null);
		reenviar.setContentAreaFilled(false);

		listo = new JButton();
		listo.setActionCommand("listo");
		listoIcon = new ImageIcon(getClass().getResource("/Imagenes/listo.png"));
		ImageIcon newlisto = new ImageIcon(listoIcon.getImage().getScaledInstance(120, 60, Image.SCALE_SMOOTH));
		listo.setIcon(newlisto);
		listo.setOpaque(true);
		listo.setFocusPainted(false);
		listo.setBorder(null);
		listo.setContentAreaFilled(false);

		add(reenviar).setBounds(45, 220, 120, 60);
		add(listo).setBounds(180, 220, 120, 60);
		add(fondo_).setBounds(0, 0, 350, 340);

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

	public JButton getReenviar() {
		return reenviar;
	}

	public void setReenviar(JButton reenviar) {
		this.reenviar = reenviar;
	}

	public JButton getListo() {
		return listo;
	}

	public void setListo(JButton listo) {
		this.listo = listo;
	}

	public ImageIcon getReenviarIcon() {
		return reenviarIcon;
	}

	public void setReenviarIcon(ImageIcon reenviarIcon) {
		this.reenviarIcon = reenviarIcon;
	}

	public ImageIcon getListoIcon() {
		return listoIcon;
	}

	public void setListoIcon(ImageIcon listoIcon) {
		this.listoIcon = listoIcon;
	}

}
