package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.text.NumberFormat;
import javax.swing.AbstractButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.NumberFormatter;

import org.omg.CORBA.PRIVATE_MEMBER;

public class VentanaRegistroHombre extends JFrame {
	JButton siguiente;
	ImageIcon siguienteIcon;
	JButton cambiarfoto;
	ImageIcon cambiarfoto_;
	ImageIcon fondo;
	JLabel fondoJLabel;
	JLabel fechaNacimineto;
	JComboBox<String> dia;
	JComboBox<String> mes;
	JComboBox<String> año;
	JLabel nombre;
	JTextField nombre_;
	JLabel apellidos;
	JTextField apellidos_;
	JLabel alias;
	JTextField alias_;
	JLabel correo;
	JTextField correo_;
	JLabel edad;
	JTextField edad_;
	JLabel estatura;
	JFormattedTextField estatura_;
	JLabel ingresos;
	JFormattedTextField ingresos_;
	JLabel foto;
	ImageIcon foto_;

	public VentanaRegistroHombre() {
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

		foto_ = new ImageIcon(getClass().getResource("/Imagenes/beckham.png"));
		ImageIcon newImage = new ImageIcon(foto_.getImage().getScaledInstance(210, 180, Image.SCALE_SMOOTH));
		foto = new JLabel(newImage);

		cambiarfoto = new JButton();
		cambiarfoto.setActionCommand("cambiarfoto");
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

		alias = new JLabel("ALIAS:");
		alias.setFont(fuente);
		alias_ = new JTextField();
		alias_.setHorizontalAlignment(SwingConstants.CENTER);

		fechaNacimineto = new JLabel("FECHA DE NACIMIENTO:");
		fechaNacimineto.setFont(fuente);
		dia = new JComboBox<String>();
		dia.addItem("1");
		dia.addItem("2");
		dia.addItem("3");
		dia.addItem("4");
		dia.addItem("5");
		dia.addItem("6");
		dia.addItem("7");
		dia.addItem("8");
		dia.addItem("9");
		dia.addItem("10");
		dia.addItem("11");
		dia.addItem("12");
		dia.addItem("13");
		dia.addItem("14");
		dia.addItem("15");
		dia.addItem("16");
		dia.addItem("17");
		dia.addItem("18");
		dia.addItem("19");
		dia.addItem("20");
		dia.addItem("21");
		dia.addItem("22");
		dia.addItem("23");
		dia.addItem("24");
		dia.addItem("25");
		dia.addItem("26");
		dia.addItem("27");
		dia.addItem("28");
		dia.addItem("29");
		dia.addItem("30");
		dia.addItem("31");
		((JLabel) dia.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);

		mes = new JComboBox<String>();
		mes.addItem("Enero");
		mes.addItem("Febrero");
		mes.addItem("Marzo");
		mes.addItem("Abril");
		mes.addItem("Mayo");
		mes.addItem("Junio");
		mes.addItem("Julio");
		mes.addItem("Agosto");
		mes.addItem("Septiembre");
		mes.addItem("Octubre");
		mes.addItem("Noviembre");
		mes.addItem("Diciembre");
		((JLabel) mes.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);

		año = new JComboBox<String>();
		año.addItem("2019");
		año.addItem("2018");
		año.addItem("2017");
		año.addItem("2016");
		año.addItem("2015");
		año.addItem("2014");
		año.addItem("2013");
		año.addItem("2012");
		año.addItem("2011");
		año.addItem("2019");
		año.addItem("2010");
		año.addItem("2009");
		año.addItem("2008");
		año.addItem("2007");
		año.addItem("2006");
		año.addItem("2005");
		año.addItem("2004");
		año.addItem("2003");
		año.addItem("2002");
		año.addItem("2001");
		año.addItem("2000");
		((JLabel) año.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);

		edad = new JLabel("EDAD:");
		edad.setFont(fuente);
		edad_ = new JTextField();
		edad_.setHorizontalAlignment(SwingConstants.CENTER);

		correo = new JLabel("CORREO ELCTRONICO:");
		correo.setFont(fuente);
		correo_ = new JTextField();
		correo_.setHorizontalAlignment(SwingConstants.CENTER);

		estatura = new JLabel("ESTATURA:");
		estatura.setFont(fuente);
		estatura_ = new JFormattedTextField(formatter);
		estatura_.setHorizontalAlignment(SwingConstants.CENTER);

		ingresos = new JLabel("INGRESOS:");
		ingresos.setFont(fuente);
		ingresos_ = new JFormattedTextField(formatter);
		ingresos_.setHorizontalAlignment(SwingConstants.CENTER);

		siguiente = new JButton();
		siguiente.setActionCommand("siguiente");
		siguienteIcon = new ImageIcon(getClass().getResource("/Imagenes/siguiente.png"));
		ImageIcon newSiguiente = new ImageIcon(siguienteIcon.getImage().getScaledInstance(200, 80, Image.SCALE_SMOOTH));
		siguiente.setIcon(newSiguiente);
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
		add(alias).setBounds(20, 320, 180, 50);
		add(alias_).setBounds(150, 330, 230, 30);
		add(fechaNacimineto).setBounds(10, 370, 300, 50);
		add(dia).setBounds(200, 380, 40, 30);
		add(mes).setBounds(240, 380, 90, 30);
		add(año).setBounds(330, 380, 80, 30);
		add(edad).setBounds(20, 420, 100, 50);
		add(edad_).setBounds(150, 430, 230, 30);
		add(correo).setBounds(10, 460, 200, 50);
		add(correo_).setBounds(200, 470, 180, 30);
		add(estatura).setBounds(20, 500, 150, 50);
		add(estatura_).setBounds(150, 510, 230, 30);
		add(ingresos).setBounds(20, 540, 150, 50);
		add(ingresos_).setBounds(150, 550, 230, 30);
		add(siguiente).setBounds(80, 580, 250, 100);
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

	public JComboBox<String> getDia() {
		return dia;
	}

	public void setDia(JComboBox<String> dia) {
		this.dia = dia;
	}

	public JComboBox<String> getMes() {
		return mes;
	}

	public void setMes(JComboBox<String> mes) {
		this.mes = mes;
	}

	public JComboBox<String> getAño() {
		return año;
	}

	public void setAño(JComboBox<String> año) {
		this.año = año;
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

	public JLabel getAlias() {
		return alias;
	}

	public void setAlias(JLabel alias) {
		this.alias = alias;
	}

	public JTextField getAlias_() {
		return alias_;
	}

	public void setAlias_(JTextField alias_) {
		this.alias_ = alias_;
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

	public JLabel getEstatura() {
		return estatura;
	}

	public void setEstatura(JLabel estatura) {
		this.estatura = estatura;
	}

	public JFormattedTextField getEstatura_() {
		return estatura_;
	}

	public void setEstatura_(JFormattedTextField estatura_) {
		this.estatura_ = estatura_;
	}

	public JLabel getIngresos() {
		return ingresos;
	}

	public void setIngresos(JLabel ingresos) {
		this.ingresos = ingresos;
	}

	public JFormattedTextField getIngresos_() {
		return ingresos_;
	}

	public void setIngresos_(JFormattedTextField ingresos_) {
		this.ingresos_ = ingresos_;
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
