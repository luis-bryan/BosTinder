package Vista;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class PanelListaUsuarios extends JPanel {
  private JList<String> listaUsuarios;
  private DefaultListModel<String> modeloLista;
  private JScrollPane desplazamiento;

  public PanelListaUsuarios() {
    setLayout(null);
    setBorder(new CompoundBorder(new EmptyBorder(5, 5, 5, 5), new TitledBorder("LISTA USUARIOS:")));


    listaUsuarios = new JList<String>();
    modeloLista = new DefaultListModel<String>();
    listaUsuarios.setModel(modeloLista);
    listaUsuarios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    desplazamiento = new JScrollPane(listaUsuarios);
    desplazamiento.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    desplazamiento.setOpaque(false);
    add(desplazamiento).setBounds(20, 30, 330, 500);

  }

  public JList<String> getlistaUsuarios() {
    return listaUsuarios;
  }

  public void setlistaUsuarios(JList<String> listaUsuarios) {
    this.listaUsuarios = listaUsuarios;
  }

  public DefaultListModel<String> getModeloLista() {
    return modeloLista;
  }

  public void setModeloLista(DefaultListModel<String> modeloLista) {
    this.modeloLista = modeloLista;
  }

}
