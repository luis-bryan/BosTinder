package Vista;

import javax.swing.*;

public class VentanaTerminos extends JFrame {

  public VentanaTerminos() {
    JTextArea area = new JTextArea();
    area.setText("\t\t\tT�rminos y Condiciones\n" +
      "14 de noviembre del 2019\n" +
      "Bienvenido a Bostrinder, aplicaci�n desarrollada por la empresa LBFSCorporation.\n" +
      "Al momento de usted suscribirse a la aplicaci�n, le llegar� un correo en donde \n" +
      "se le har� llegar el usuario y la contrase�a para el ingreso a la plataforma. Al \n" +
      "usted ingresar a la plataforma se encontrar� con muchos usuarios que desean una cita \n" +
      "con alguien especial. Si usted es un hombre, la plataforma est� dise�ada para que solo \n" +
      "aparezcan mujeres y viceversa.\n" +
      "Tambi�n tiene la opci�n de eliminar su cuenta, pero debemos conocer el motivo de su salida,\n" +
      " para ello cont�ctese por el correo electr�nico: tinderbos@gmail.com y nos cuenta cu�l es su \n" +
      "motivo para eliminar la cuenta. \n" +
      "La comunidad debe tener restricciones al momento de suscribirse como, por ejemplo:\n" +
      "Im�genes obscenas\n" +
      "Nombres inadecuados\n" +
      "Debe ser mayor de 18 a�os\n" +
      "Manejar un lenguaje apto con los otros usuarios\n" +
      "Para m�s informaci�n, lea la pol�tica de privacidad\n" +
      "Cordial Saludo y disfruta BosTinder.\n");
    add(area);
    setSize(600, 400);
    setVisible(true);
  }

}
