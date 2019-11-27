package Vista;

import javax.swing.*;
import java.awt.*;

public class VentanaPremium extends JFrame {

  ImageIcon i = new ImageIcon(getClass().getResource("/Imagenes/premium.png"));
  Image im = i.getImage();
  Image newimg = im.getScaledInstance(400, 600, Image.SCALE_SMOOTH);
  ImageIcon image = new ImageIcon(newimg);

  JLabel j = new JLabel();

  public VentanaPremium() {
    super("Premium");
    setSize(400, 600);
    j.setIcon(image);
    add(j);
    setLocationRelativeTo(null);
    setVisible(true);

  }

}
