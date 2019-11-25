package Vista;

import controlador.Controlador;

import javax.swing.*;
import java.awt.*;

public class VentanaBienvenida extends JFrame {
	private JButton iniciar;
	private JButton registrar;
	private JButton tc;
	private Icon iniciarIcon;
	private Icon registrarIcon;
	private Icon tcIcon;
	private ImageIcon logoIcon;
	private ImageIcon titulo;
	private JLabel titu;
	private JLabel logoJLabel;
	private VentanaEscogerGenero veg;
	private VentanaRegistroHombre vrh;
	private VentanaRegistroMujer vrm;
	private VentanaLogueo vl;
	private VentanaUsuarioContraseña vuc;
	private VentanaConfirmacionCorreo vcc;
	private VentanaInteraccion vi;
	private VentanaFinRegistro vfr;
	private VentanaAdministrador va;

	public VentanaBienvenida(Controlador c) {
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

		iniciar.addActionListener(c);
		registrar.addActionListener(c);
		tc.addActionListener(c);
		veg.getHombre().addActionListener(c);
		veg.getMujer().addActionListener(c);
		vrh.getSiguiente().addActionListener(c);
		vrm.getSiguiente().addActionListener(c);
		vrh.getCambiarfoto().addActionListener(c);
		vrm.getCambiarfoto().addActionListener(c);
		vl.getIniciar().addActionListener(c);
		vcc.getListo().addActionListener(c);
		vcc.getReenviar().addActionListener(c);
		vuc.getGuardar().addActionListener(c);
		vfr.getListo().addActionListener(c);
		vi.getPremium().addActionListener(c);
		vi.getLike().addActionListener(c);
		vi.getDislike().addActionListener(c);
		vi.getCerrarsesion().addActionListener(c);
		vi.getInformacion().addActionListener(c);
		va.getCerrarsesion().addActionListener(c);
		va.getEliminar().addActionListener(c);
		va.getPdf().addActionListener(c);
		setVisible(true);

	}


	public JButton getIniciar() {
		return iniciar;
	}

	public void setIniciar(JButton iniciar) {
		this.iniciar = iniciar;
	}

	public JButton getRegistrar() {
		return registrar;
	}

	public void setRegistrar(JButton registrar) {
		this.registrar = registrar;
	}

	public JButton getTc() {
		return tc;
	}

	public void setTc(JButton tc) {
		this.tc = tc;
	}

	public Icon getIniciarIcon() {
		return iniciarIcon;
	}

	public void setIniciarIcon(Icon iniciarIcon) {
		this.iniciarIcon = iniciarIcon;
	}

	public Icon getRegistrarIcon() {
		return registrarIcon;
	}

	public void setRegistrarIcon(Icon registrarIcon) {
		this.registrarIcon = registrarIcon;
	}

	public Icon getTcIcon() {
		return tcIcon;
	}

	public void setTcIcon(Icon tcIcon) {
		this.tcIcon = tcIcon;
	}

	public ImageIcon getLogoIcon() {
		return logoIcon;
	}

	public void setLogoIcon(ImageIcon logoIcon) {
		this.logoIcon = logoIcon;
	}

	public ImageIcon getTitulo() {
		return titulo;
	}

	public void setTitulo(ImageIcon titulo) {
		this.titulo = titulo;
	}

	public JLabel getTitu() {
		return titu;
	}

	public void setTitu(JLabel titu) {
		this.titu = titu;
	}

	public JLabel getLogoJLabel() {
		return logoJLabel;
	}

	public void setLogoJLabel(JLabel logoJLabel) {
		this.logoJLabel = logoJLabel;
	}

	public VentanaEscogerGenero getVeg() {
		return veg;
	}

	public void setVeg(VentanaEscogerGenero veg) {
		this.veg = veg;
	}

	public VentanaRegistroHombre getVrh() {
		return vrh;
	}

	public void setVrh(VentanaRegistroHombre vrh) {
		this.vrh = vrh;
	}

	public VentanaRegistroMujer getVrm() {
		return vrm;
	}

	public void setVrm(VentanaRegistroMujer vrm) {
		this.vrm = vrm;
	}

	public VentanaLogueo getVl() {
		return vl;
	}

	public void setVl(VentanaLogueo vl) {
		this.vl = vl;
	}

	public VentanaUsuarioContraseña getVuc() {
		return vuc;
	}

	public void setVuc(VentanaUsuarioContraseña vuc) {
		this.vuc = vuc;
	}

	public VentanaConfirmacionCorreo getVcc() {
		return vcc;
	}

	public void setVcc(VentanaConfirmacionCorreo vcc) {
		this.vcc = vcc;
	}

	public VentanaInteraccion getVi() {
		return vi;
	}

	public void setVi(VentanaInteraccion vi) {
		this.vi = vi;
	}

	public VentanaFinRegistro getVfr() {
		return vfr;
	}

	public void setVfr(VentanaFinRegistro vfr) {
		this.vfr = vfr;
	}

	public VentanaAdministrador getVa() {
		return va;
	}

	public void setVa(VentanaAdministrador va) {
		this.va = va;
	}
}
