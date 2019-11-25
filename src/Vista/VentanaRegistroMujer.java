package Vista;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class VentanaRegistroMujer extends JFrame {
	JButton siguiente;
	ImageIcon siguienteIcon;
	JButton cambiarfoto;
	ImageIcon cambiarfoto_;
	ImageIcon fondo;
	JLabel fondoJLabel;
	JDateChooser fecha_;
	JLabel fechaNacimineto;
	JLabel nombre;
	JTextField nombre_;
	JLabel apellidos;
	JTextField apellidos_;
	JLabel iden;
	JTextField iden_;
	JLabel correo;
	JTextField correo_;
	JLabel edad;
	JTextField edad_;
	JLabel divorcios;
	ButtonGroup e1;
	JRadioButton divorcios_si;
	JRadioButton divorcios_no;
	JLabel foto;
	ImageIcon foto_;

	public VentanaRegistroMujer() {
		setIconImage(new ImageIcon(getClass().getResource("/Imagenes/Logo.png")).getImage());
		setTitle("REGISTRO USUARIO");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(null);
		setResizable(false);
		getContentPane().setBackground(Color.white);
		setBounds(0, 0, 420, 700);
		setLocationRelativeTo(null);
		Font fuente = new Font("Tahoma", 1, 15);
		NumberFormat format = NumberFormat.getInstance();
		NumberFormatter formatter = new NumberFormatter(format);
		formatter.setValueClass(Integer.class);
		formatter.setMinimum(0);
		formatter.setMaximum(Integer.MAX_VALUE);
		formatter.setAllowsInvalid(false);
		formatter.setCommitsOnValidEdit(false);

		fondo = new ImageIcon(getClass().getResource("/Imagenes/fondo.png"));
		fondoJLabel = new JLabel(fondo);

		foto_ = new ImageIcon(getClass().getResource("/Imagenes/sara.png"));
		ImageIcon newImage = new ImageIcon(foto_.getImage().getScaledInstance(210, 180, Image.SCALE_SMOOTH));
		foto = new JLabel(newImage);

		cambiarfoto = new JButton();
		cambiarfoto.setActionCommand("cambiarfotoM");
		cambiarfoto_ = new ImageIcon(getClass().getResource("/Imagenes/cambiarfoto.png"));
		ImageIcon boton = new ImageIcon(cambiarfoto_.getImage().getScaledInstance(150, 50, Image.SCALE_SMOOTH));
		cambiarfoto.setIcon(boton);
		cambiarfoto.setOpaque(false);
		cambiarfoto.setFocusPainted(false);
		cambiarfoto.setBorder(null);
		cambiarfoto.setContentAreaFilled(false);

		nombre = new JLabel("NOMBRES:");
		nombre.setFont(fuente);
		nombre_ = new JTextField();
		nombre_.setHorizontalAlignment(SwingConstants.CENTER);

		apellidos = new JLabel("APELLIDOS:");
		apellidos.setFont(fuente);
		apellidos_ = new JTextField();
		apellidos_.setHorizontalAlignment(SwingConstants.CENTER);

		iden = new JLabel("IDENTIFICACION:");
		iden.setFont(fuente);
		iden_ = new JTextField();
		iden_.setHorizontalAlignment(SwingConstants.CENTER);

		fechaNacimineto = new JLabel("FECHA DE NACIMIENTO:");
		fechaNacimineto.setFont(fuente);

		fecha_ = new JDateChooser();
		fecha_.setMaxSelectableDate(Date.from(LocalDate.now().minusYears(18).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
		fecha_.setDateFormatString("dd/MM/yyyy");
		fecha_.setDate(Date.from(LocalDate.now().minusYears(18).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));


		edad = new JLabel("EDAD:");
		edad.setFont(fuente);
		edad_ = new JTextField();
		edad_.setHorizontalAlignment(SwingConstants.CENTER);

		correo = new JLabel("CORREO ELCTRONICO:");
		correo.setFont(fuente);
		correo_ = new JTextField();
		correo_.setHorizontalAlignment(SwingConstants.CENTER);

		divorcios = new JLabel("DIVORCIOS:");
		divorcios.setFont(fuente);

		ButtonGroup e1 = new ButtonGroup();
		divorcios_si = new JRadioButton("APLICA", false);
		divorcios_no = new JRadioButton("NO APLICA", false);
		e1.add(divorcios_si);
		e1.add(divorcios_no);
		divorcios_si.setOpaque(false);
		divorcios_no.setOpaque(false);

		siguiente = new JButton();
		siguiente.setActionCommand("siguienteM");
		siguienteIcon = new ImageIcon(getClass().getResource("/Imagenes/siguiente.png"));
		siguiente.setIcon(siguienteIcon);
		siguiente.setOpaque(false);
		siguiente.setFocusPainted(false);
		siguiente.setBorder(null);
		siguiente.setContentAreaFilled(false);

		add(foto).setBounds(30, 30, 210, 180);
		add(cambiarfoto).setBounds(255, 90, 150, 50);
		add(nombre).setBounds(20, 220, 120, 50);
		add(nombre_).setBounds(150, 230, 230, 30);
		add(apellidos).setBounds(20, 270, 130, 50);
		add(apellidos_).setBounds(150, 280, 230, 30);
		add(iden).setBounds(20, 320, 180, 50);
		add(iden_).setBounds(150, 330, 230, 30);
		add(fechaNacimineto).setBounds(10, 370, 300, 50);
		add(fecha_).setBounds(200, 380, 200, 30);
		add(edad).setBounds(20, 420, 100, 50);
		add(edad_).setBounds(150, 430, 230, 30);
		add(correo).setBounds(10, 470, 200, 50);
		add(correo_).setBounds(200, 480, 180, 30);
		add(divorcios).setBounds(20, 520, 150, 50);
		add(divorcios_si).setBounds(150, 510, 100, 70);
		add(divorcios_no).setBounds(240, 510, 100, 70);
		add(siguiente).setBounds(70, 550, 250, 100);
		add(fondoJLabel).setBounds(0, 0, 750, 690);

		setVisible(false);

	}

	public JButton getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(JButton siguiente) {
		this.siguiente = siguiente;
	}

	public ImageIcon getSiguienteIcon() {
		return siguienteIcon;
	}

	public void setSiguienteIcon(ImageIcon siguienteIcon) {
		this.siguienteIcon = siguienteIcon;
	}

	public JButton getCambiarfoto() {
		return cambiarfoto;
	}

	public void setCambiarfoto(JButton cambiarfoto) {
		this.cambiarfoto = cambiarfoto;
	}

	public ImageIcon getCambiarfoto_() {
		return cambiarfoto_;
	}

	public void setCambiarfoto_(ImageIcon cambiarfoto_) {
		this.cambiarfoto_ = cambiarfoto_;
	}

	public ImageIcon getFondo() {
		return fondo;
	}

	public void setFondo(ImageIcon fondo) {
		this.fondo = fondo;
	}

	public JLabel getFondoJLabel() {
		return fondoJLabel;
	}

	public void setFondoJLabel(JLabel fondoJLabel) {
		this.fondoJLabel = fondoJLabel;
	}

	public JLabel getFechaNacimineto() {
		return fechaNacimineto;
	}

	public void setFechaNacimineto(JLabel fechaNacimineto) {
		this.fechaNacimineto = fechaNacimineto;
	}

	public JDateChooser getFecha_() {
		return fecha_;
	}

	public void setFecha_(JDateChooser fecha_) {
		this.fecha_ = fecha_;
	}

	public JLabel getIden() {
		return iden;
	}

	public void setIden(JLabel iden) {
		this.iden = iden;
	}

	public JTextField getIden_() {
		return iden_;
	}

	public void setIden_(JTextField iden_) {
		this.iden_ = iden_;
	}

	public JLabel getNombre() {
		return nombre;
	}

	public void setNombre(JLabel nombre) {
		this.nombre = nombre;
	}

	public JTextField getNombre_() {
		return nombre_;
	}

	public void setNombre_(JTextField nombre_) {
		this.nombre_ = nombre_;
	}

	public JLabel getApellidos() {
		return apellidos;
	}

	public void setApellidos(JLabel apellidos) {
		this.apellidos = apellidos;
	}

	public JTextField getApellidos_() {
		return apellidos_;
	}

	public void setApellidos_(JTextField apellidos_) {
		this.apellidos_ = apellidos_;
	}

	public JLabel getiden() {
		return iden;
	}

	public void setiden(JLabel iden) {
		this.iden = iden;
	}

	public JTextField getiden_() {
		return iden_;
	}

	public void setiden_(JTextField iden_) {
		this.iden_ = iden_;
	}

	public JLabel getCorreo() {
		return correo;
	}

	public void setCorreo(JLabel correo) {
		this.correo = correo;
	}

	public JTextField getCorreo_() {
		return correo_;
	}

	public void setCorreo_(JTextField correo_) {
		this.correo_ = correo_;
	}

	public JLabel getEdad() {
		return edad;
	}

	public void setEdad(JLabel edad) {
		this.edad = edad;
	}

	public JTextField getEdad_() {
		return edad_;
	}

	public void setEdad_(JTextField edad_) {
		this.edad_ = edad_;
	}

	public JLabel getDivorcios() {
		return divorcios;
	}

	public void setDivorcios(JLabel divorcios) {
		this.divorcios = divorcios;
	}

	public ButtonGroup getE1() {
		return e1;
	}

	public void setE1(ButtonGroup e1) {
		this.e1 = e1;
	}

	public JRadioButton getDivorcios_si() {
		return divorcios_si;
	}

	public void setDivorcios_si(JRadioButton divorcios_si) {
		this.divorcios_si = divorcios_si;
	}

	public JRadioButton getDivorcios_no() {
		return divorcios_no;
	}

	public void setDivorcios_no(JRadioButton divorcios_no) {
		this.divorcios_no = divorcios_no;
	}

	public JLabel getFoto() {
		return foto;
	}

	public void setFoto(JLabel foto) {
		this.foto = foto;
	}

	public ImageIcon getFoto_() {
		return foto_;
	}

	public void setFoto_(ImageIcon foto_) {
		this.foto_ = foto_;
	}

}
