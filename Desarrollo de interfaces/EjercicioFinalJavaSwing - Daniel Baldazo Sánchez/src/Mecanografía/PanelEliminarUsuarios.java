package Mecanografía;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class PanelEliminarUsuarios extends JPanel {
    
    private FrameMecanografía frameMecanografía;
    private Usuario user;
    private static String fondoPanelLogin = "src/Mecanografía/ImágenesAPP/FondoAzulado.jpg";

    private static ArrayList<Usuario> USUARIOS = DatosTXT.getUSUARIOS(); // Obtener lista de usuarios
    private DefaultListModel<String> listModel;
    private JList<String> list;

    public PanelEliminarUsuarios(FrameMecanografía frameMecanografía, Usuario user) {
        this.frameMecanografía = frameMecanografía;
        this.user = user;

        setLayout(null);
        setBounds(0, 0, 500, 700);

        JButton volverAtras = new JButton("Volver atrás");
        volverAtras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                PanelAdmin panelAdmin = new PanelAdmin(frameMecanografía, user);
                frameMecanografía.getContentPane().add(panelAdmin);
            }
        });
        volverAtras.setBackground(new Color(255, 153, 102));
        volverAtras.setForeground(new Color(255, 255, 255));
        volverAtras.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 15));
        volverAtras.setBounds(123, 469, 241, 27);
        add(volverAtras);

        JButton eliminarUsuario = new JButton("Eliminar usuario");
        eliminarUsuario.setBounds(108, 392, 276, 38);
        eliminarUsuario.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 15));
        eliminarUsuario.setForeground(Color.WHITE);
        eliminarUsuario.setBackground(new Color(187, 37, 30));
        add(eliminarUsuario);

        JLabel pregunta = new JLabel("¿Qué usuario desea eliminar?");
        pregunta.setHorizontalAlignment(SwingConstants.CENTER);
        pregunta.setForeground(new Color(255, 153, 102));
        pregunta.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 25));
        pregunta.setBounds(70, 60, 352, 65);
        add(pregunta);
        
        JLabel pregunta2 = new JLabel("Seleccione un usuario en la lista");
        pregunta2.setHorizontalAlignment(SwingConstants.CENTER);
        pregunta2.setForeground(Color.WHITE);
        pregunta2.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 20));
        pregunta2.setBounds(20, 125, 447, 68);
        add(pregunta2);
        
        JLabel pregunta2_1 = new JLabel("y pulse eliminar usuario");
        pregunta2_1.setHorizontalAlignment(SwingConstants.CENTER);
        pregunta2_1.setForeground(Color.WHITE);
        pregunta2_1.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 20));
        pregunta2_1.setBounds(22, 175, 447, 38);
        add(pregunta2_1);

        // Modelo para manejar los datos en JList
        listModel = new DefaultListModel<>();
        list = new JList<>(listModel);
        list.setBounds(32, 244, 433, 94);
        add(list);

        // Llenar la lista con los nombres de los usuarios
        cargarUsuariosEnLista();

        // Acción del botón eliminar
        eliminarUsuario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                eliminarUsuarioSeleccionado();
            }
        });

        add(Imágenes.ponerFondo(fondoPanelLogin, frameMecanografía));
           
    }

    // Método para llenar el JList con los usuarios
    private void cargarUsuariosEnLista() {
        listModel.clear(); // Limpiar la lista antes de cargar datos
        for (int i = 1; i < USUARIOS.size(); i++) {
            listModel.addElement("ID: " +USUARIOS.get(i).getAlias()+ " | " + "NOMBRE: " + USUARIOS.get(i).getNombre()+ 
            		" | " + "CORREO: "+ USUARIOS.get(i).getCorreo()); //  Suponiendo que Usuario tiene un método getNombre()
		}
        }

    // Método para eliminar el usuario seleccionado
    private void eliminarUsuarioSeleccionado() {
        int selectedIndex = list.getSelectedIndex();
        if (selectedIndex != -1) {
            String selectedValue = listModel.getElementAt(selectedIndex); // Obtener el texto seleccionado
            if(USUARIOS.size() >= 5) {
            // Extraer solo el ID (eliminar el prefijo "ID: ")
            String idUsuario = selectedValue.split(" \\| ")[0].replace("ID: ", "").trim();

            // Eliminar del ArrayList de usuarios por ID
            USUARIOS.removeIf(usuario -> usuario.getAlias().equals(idUsuario));

            // Eliminar del JList
            listModel.remove(selectedIndex);
            EscribirTXT.EscribirUsuarios(USUARIOS);
            JOptionPane.showMessageDialog(this, "El usuario se ha eliminado correctamente.", "Usuario eliminado", JOptionPane.NO_OPTION);

            }else
                JOptionPane.showMessageDialog(this, "La aplicación debe de teber como mínimo 3 usuarios.", "Error", JOptionPane.ERROR_MESSAGE);

        } else {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un usuario.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }
}
