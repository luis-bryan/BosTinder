package Vista;

import javax.swing.*;
import java.awt.*;

public class VentanaAdministrador extends JFrame {
  private PanelListaUsuarios plu;
  private JButton pdf;
  private JButton eliminar;
  private JButton cerrarsesion;
  private ImageIcon eliminarIcon;
  private ImageIcon pdfIcon;
  private ImageIcon cerrarsesionIcon;
  private ImageIcon fondo;
  private JLabel fondo_;

  public VentanaAdministrador() {
    setIconImage(new ImageIcon(getClass().getResource("/Imagenes/Logo.png")).getImage());
    setTitle("ADMINISTRADOR");
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setLayout(null);
    setResizable(false);
    getContentPane().setBackground(Color.white);
    setBounds(0, 0, 400, 680);
    setLocationRelativeTo(null);

    plu = new PanelListaUsuarios();
    plu.setOpaque(false);

    fondo = new ImageIcon(getClass().getResource("/Imagenes/fondobienvenida.png"));
    fondo_ = new JLabel(fondo);

    pdf = new JButton();
    pdf.setActionCommand("pdf");
    pdfIcon = new ImageIcon(getClass().getResource("/Imagenes/pdf.png"));
    ImageIcon newpdf = new ImageIcon(pdfIcon.getImage().getScaledInstance(100, 50, Image.SCALE_SMOOTH));
    pdf.setIcon(newpdf);
    pdf.setOpaque(false);
    pdf.setFocusPainted(false);
    pdf.setBorder(null);
    pdf.setContentAreaFilled(false);

    eliminar = new JButton();
    eliminar.setActionCommand("eliminar");
    eliminarIcon = new ImageIcon(getClass().getResource("/Imagenes/eliminar.png"));
    ImageIcon neweliminar = new ImageIcon(eliminarIcon.getImage().getScaledInstance(100, 50, Image.SCALE_SMOOTH));
    eliminar.setIcon(neweliminar);
    eliminar.setOpaque(false);
    eliminar.setFocusPainted(false);
    eliminar.setBorder(null);
    eliminar.setContentAreaFilled(false);

    cerrarsesion = new JButton();
    cerrarsesion.setActionCommand("cerrarsesion");
    cerrarsesionIcon = new ImageIcon(getClass().getResource("/Imagenes/cerrarsesion.png"));
    ImageIcon newcerrarsesion = new ImageIcon(
      cerrarsesionIcon.getImage().getScaledInstance(100, 50, Image.SCALE_SMOOTH));
    cerrarsesion.setIcon(newcerrarsesion);
    cerrarsesion.setOpaque(false);
    cerrarsesion.setFocusPainted(false);
    cerrarsesion.setBorder(null);
    cerrarsesion.setContentAreaFilled(false);

    add(plu).setBounds(15, 10, 370, 550);
    add(pdf).setBounds(30, 580, 100, 50);
    add(eliminar).setBounds(150, 580, 100, 50);
    add(cerrarsesion).setBounds(270, 580, 100, 50);
    add(fondo_).setBounds(0, 0, 750, 690);
    setVisible(false);

  }

  public PanelListaUsuarios getPlu() {
    return plu;
  }

  public void setPlu(PanelListaUsuarios plu) {
    this.plu = plu;
  }

  public JButton getPdf() {
    return pdf;
  }

  public void setPdf(JButton pdf) {
    this.pdf = pdf;
  }

  public JButton getEliminar() {
    return eliminar;
  }

  public void setEliminar(JButton eliminar) {
    this.eliminar = eliminar;
  }

  public JButton getCerrarsesion() {
    return cerrarsesion;
  }

  public void setCerrarsesion(JButton cerrarsesion) {
    this.cerrarsesion = cerrarsesion;
  }

  public ImageIcon getEliminarIcon() {
    return eliminarIcon;
  }

  public void setEliminarIcon(ImageIcon eliminarIcon) {
    this.eliminarIcon = eliminarIcon;
  }

  public ImageIcon getPdfIcon() {
    return pdfIcon;
  }

  public void setPdfIcon(ImageIcon pdfIcon) {
    this.pdfIcon = pdfIcon;
  }

  public ImageIcon getCerrarsesionIcon() {
    return cerrarsesionIcon;
  }

  public void setCerrarsesionIcon(ImageIcon cerrarsesionIcon) {
    this.cerrarsesionIcon = cerrarsesionIcon;
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
