package Vista;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class VentanaBienvenida extends JFrame implements ActionListener {
	JButton iniciar;
	JButton registrar;
	JButton tc;
	Icon iniciarIcon;
	Icon registrarIcon;
	Icon tcIcon;
	ImageIcon logoIcon;
	ImageIcon titulo;
	JLabel titu;
	JLabel logoJLabel;
	VentanaEscogerGenero veg;
	VentanaRegistroHombre vrh;
	VentanaRegistroMujer vrm;
	VentanaLogueo vl;
	VentanaUsuarioContraseña vuc;
	VentanaConfirmacionCorreo vcc;
	VentanaInteraccion vi;
	VentanaFinRegistro vfr;
	VentanaAdministrador va;

	public VentanaBienvenida() {
		setIconImage(new ImageIcon(getClass().getResource("/Imagenes/Logo.png")).getImage());
		setTitle("BOSTINDER");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setResizable(false);
		getContentPane().setBackground(Color.white);
		setBounds(0, 0, 400, 680);
		setLocationRelativeTo(null);

		titulo = new ImageIcon(getClass().getResource("/Imagenes/fondobienvenida.png"));
		titu = new JLabel(titulo);

		iniciar = new JButton();
		iniciar.setActionCommand("iniciar");
		iniciarIcon = new ImageIcon(getClass().getResource("/Imagenes/iniciarsesion.png"));
		iniciar.setIcon(iniciarIcon);
		iniciar.setOpaque(true);
		iniciar.setFocusPainted(false);
		iniciar.setBorder(null);
		iniciar.setContentAreaFilled(false);

		registrar = new JButton();
		registrar.setActionCommand("registrar");
		registrarIcon = new ImageIcon(getClass().getResource("/Imagenes/registrarse.png"));
		registrar.setIcon(registrarIcon);
		registrar.setOpaque(true);
		registrar.setFocusPainted(false);
		registrar.setBorder(null);
		registrar.setContentAreaFilled(false);

		tc = new JButton();
		tc.setActionCommand("tc");
		tcIcon = new ImageIcon(getClass().getResource("/Imagenes/tc.png"));
		tc.setIcon(tcIcon);
		tc.setOpaque(true);
		tc.setFocusPainted(false);
		tc.setBorder(null);
		tc.setContentAreaFilled(false);

		logoIcon = new ImageIcon(getClass().getResource("/Imagenes/imagenlogo.png"));
		ImageIcon newImage = new ImageIcon(logoIcon.getImage().getScaledInstance(210, 240, Image.SCALE_SMOOTH));
		logoJLabel = new JLabel(newImage);

		vrm = new VentanaRegistroMujer();
		vrh = new VentanaRegistroHombre();
		veg = new VentanaEscogerGenero();
		vl = new VentanaLogueo();
		vuc = new VentanaUsuarioContraseña();
		vcc = new VentanaConfirmacionCorreo();
		vi = new VentanaInteraccion();
		vfr = new VentanaFinRegistro();
		va = new VentanaAdministrador();

		add(logoJLabel).setBounds(90, 50, 220, 240);
		add(iniciar).setBounds(70, 300, 250, 100);
		add(registrar).setBounds(70, 420, 250, 100);
		add(tc).setBounds(100, 570, 200, 50);
		add(titu).setBounds(0, 0, 750, 690);

		iniciar.addActionListener(this);
		registrar.addActionListener(this);
		tc.addActionListener(this);
		veg.getHombre().addActionListener(this);
		veg.getMujer().addActionListener(this);
		vrh.siguiente.addActionListener(this);
		vrm.siguiente.addActionListener(this);
		vrh.getCambiarfoto().addActionListener(this);
		vrm.getCambiarfoto().addActionListener(this);
		vl.getIniciar().addActionListener(this);
		vcc.getListo().addActionListener(this);
		vcc.getReenviar().addActionListener(this);
		vuc.getGuardar().addActionListener(this);
		vfr.getListo().addActionListener(this);
		vi.getPremium().addActionListener(this);
		vi.getLike().addActionListener(this);
		vi.getDislike().addActionListener(this);
		vi.getCerrarsesion().addActionListener(this);
		vi.getInformacion().addActionListener(this);
		va.getPdf().addActionListener(this);
		va.getCerrarsesion().addActionListener(this);
		va.getEliminar().addActionListener(this);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ImageIcon Icono = new ImageIcon(getClass().getResource("/Imagenes/logo.png"));
		ImageIcon newIcono = new ImageIcon(logoIcon.getImage().getScaledInstance(70, 80, Image.SCALE_SMOOTH));

		if (e.getActionCommand().equals("iniciar")) {
			vl.setVisible(true);
			setVisible(false);
		} else if (e.getActionCommand().equals("registrar")) {
			setVisible(false);
			veg.setVisible(true);
		} else if (e.getActionCommand().equals("tc")) {
			System.out.println("TERMINOS Y CONDICIONES");
		} else if (e.getActionCommand().equals("hombre")) {
			veg.setVisible(false);
			vrh.setVisible(true);
		} else if (e.getActionCommand().equals("mujer")) {
			veg.setVisible(false);
			vrm.setVisible(true);
		} else if (e.getActionCommand().equals("cambiarfoto")) {
			System.out.println("CAMBIO FOTO");
		} else if (e.getActionCommand().equals("siguiente")) {
			vrh.setVisible(false);
			vrm.setVisible(false);
			vcc.setVisible(true);
		} else if (e.getActionCommand().equals("iniciarsesion")) {
			vl.setVisible(false);
			va.setVisible(true);
			vi.setVisible(true);
		} else if (e.getActionCommand().equals("listo")) {
			vcc.setVisible(false);
			vuc.setVisible(true);
		} else if (e.getActionCommand().equals("reenviar")) {
			System.out.println("REENVIO CORREO");
		} else if (e.getActionCommand().equals("guardar")) {
			vuc.setVisible(false);
			vfr.setVisible(true);
		} else if (e.getActionCommand().equals("listofin")) {
			vi.setVisible(true);
			vfr.setVisible(false);
		} else if (e.getActionCommand().equals("premium")) {
			System.out.println("PREMIUM");
		} else if (e.getActionCommand().equals("like")) {
			System.out.println("LIKE");
		} else if (e.getActionCommand().equals("dislike")) {
			System.out.println("DISLIKE");
		} else if (e.getActionCommand().equals("informacion")) {
			System.out.println("INFORMACION");
		} else if (e.getActionCommand().equals("cerrarsesion")) {
			System.out.println("CERRAR SESION");
			vi.setVisible(false);
			va.setVisible(false);
			this.setVisible(true);
		} else if (e.getActionCommand().equals("pdf")) {
			System.out.println("PDF");
		} else if (e.getActionCommand().equals("eliminar")) {
			System.out.println("ELIMINADO USUARIO");
		//} else if (e.getActionCommand().equals("cerrarsesion")) {
		//	System.out.println("CERRAR SESION");
		}

	}

}
