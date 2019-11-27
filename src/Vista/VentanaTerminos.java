package Vista;

import javax.swing.*;

public class VentanaTerminos extends JFrame {

  public VentanaTerminos() {
    JTextArea area = new JTextArea();
    area.setText("\t\t\tTérminos y Condiciones\n" +
      "14 de noviembre del 2019\n" +
      "Bienvenido a Bostrinder, aplicación desarrollada por la empresa LBFSCorporation.\n" +
      "Al momento de usted suscribirse a la aplicación, le llegará un correo en donde \n" +
      "se le hará llegar el usuario y la contraseña para el ingreso a la plataforma. Al \n" +
      "usted ingresar a la plataforma se encontrará con muchos usuarios que desean una cita \n" +
      "con alguien especial. Si usted es un hombre, la plataforma está diseñada para que solo \n" +
      "aparezcan mujeres y viceversa.\n" +
      "También tiene la opción de eliminar su cuenta, pero debemos conocer el motivo de su salida,\n" +
      " para ello contáctese por el correo electrónico: tinderbos@gmail.com y nos cuenta cuál es su \n" +
      "motivo para eliminar la cuenta. \n" +
      "La comunidad debe tener restricciones al momento de suscribirse como, por ejemplo:\n" +
      "Imágenes obscenas\n" +
      "Nombres inadecuados\n" +
      "Debe ser mayor de 18 años\n" +
      "Manejar un lenguaje apto con los otros usuarios\n" +
      "Para más información, lea la política de privacidad\n" +
      "Cordial Saludo y disfruta BosTinder.\n");
    add(area);
    setSize(600, 400);
    setVisible(true);
  }

}
