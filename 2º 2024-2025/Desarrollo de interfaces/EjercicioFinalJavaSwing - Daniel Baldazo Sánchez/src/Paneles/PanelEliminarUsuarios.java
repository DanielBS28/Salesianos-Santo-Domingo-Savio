package Paneles;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import Mecanografía_MAIN_y_FRAME.*;
import ClasesArchivos.*;
import Utilidades.Archivos;
import Utilidades.DatosTXT;
import Utilidades.EscribirTXT;
import Utilidades.Imágenes;

public class PanelEliminarUsuarios extends JPanel {
	
	//Este panel es el que usa el administrador para borrar usuarios de la APP
    
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
        
        //Este botón sirve para volver al panel del administrador pero no cierra su sesión
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

        // ListModel para manejar los datos en la JList
        listModel = new DefaultListModel<>();
        list = new JList<>(listModel);
        list.setBounds(32, 244, 433, 94);
        add(list);

        // Llenar la Jlist con los nombres de los usuarios
        cargarUsuariosEnLista();

        // Esta es la acción del botón eliminar
        eliminarUsuario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                eliminarUsuarioSeleccionado();
            }
        });

        add(Imágenes.ponerFondo(fondoPanelLogin, frameMecanografía));
           
    }

    // Función para llenar la JList con los usuarios de la APP
    private void cargarUsuariosEnLista() {
        listModel.clear(); // Con esto limpio la lista antes de llenarla, con el for de abajo la lleno.
        for (int i = 1; i < USUARIOS.size(); i++) {
            listModel.addElement("ID: " +USUARIOS.get(i).getAlias()+ " | " + "NOMBRE: " + USUARIOS.get(i).getNombre()+ 
            		" | " + "CORREO: "+ USUARIOS.get(i).getCorreo());
		}
        }

    // Función para eliminar el usuario seleccionado
    private void eliminarUsuarioSeleccionado() {
        int selectedIndex = list.getSelectedIndex();
        if (selectedIndex != -1) {
            String selectedValue = listModel.getElementAt(selectedIndex); // Obtener el texto seleccionado de la listmodel
            
            // Compruebo si la cantidad de usuarios es mayor que 5 (1 de ellos es el administrador y no sale, por eso >= 5)
            if(USUARIOS.size() >= 5) {
            // Me quedo solo con el ID, también elimino el prefijo "ID: " con el replace, (lo sustituirá por "")
            String idUsuario = selectedValue.split(" \\| ")[0].replace("ID: ", "").trim();

            // Eliminar del ArrayList de usuarios por ID
            USUARIOS.removeIf(usuario -> usuario.getAlias().equals(idUsuario));

            // Eliminar de la JList
            listModel.remove(selectedIndex);
            
            //Escribo de nuevo el TXT con los cambios al eliminar el antiguo usuario, y también sus estadísticas, tanto borrarlas
            // del arraylist de estadísticas como del archivo TXT
            EscribirTXT.EscribirUsuarios(USUARIOS);
    		Archivos.eliminarDatosSinUsuarios(USUARIOS, DatosTXT.getESTADÍSTICAS());
    		EscribirTXT.EscribirEstadísticas(DatosTXT.getESTADÍSTICAS());
            JOptionPane.showMessageDialog(this, "El usuario se ha eliminado correctamente.", "Usuario eliminado", JOptionPane.NO_OPTION);

            }else// Si el arraylist tiene menos de 5 personas no puedo eliminar un usuario
                JOptionPane.showMessageDialog(this, "La aplicación debe de teber como mínimo 3 usuarios.", "Error", JOptionPane.ERROR_MESSAGE);

        } else {// Si no seleccionas nada te dará este aviso, no puedes borrar algo si no lo has seleccionado
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un usuario.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }
}
