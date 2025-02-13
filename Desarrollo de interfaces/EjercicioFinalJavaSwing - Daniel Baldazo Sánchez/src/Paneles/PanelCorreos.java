package Paneles;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import Mecanografía_MAIN_y_FRAME.*;
import ClasesArchivos.*;
import Eventos.EventoEnviarCorreoPrueba;
import Utilidades.DatosTXT;
import Utilidades.Imágenes;

public class PanelCorreos extends JPanel {
	
	/*
	 * Este panel es donde el administrador puede enviar correos de prueba a los usuarios de la APP
	 */
    
    private FrameMecanografía frameMecanografía;
    private Usuario user;
    private static String fondoPanelLogin = "src/Mecanografía/ImágenesAPP/FondoAzulado.jpg";
    private JList<String> list;
    private DefaultListModel<String> listModel;

    static ArrayList<Usuario> USUARIOS = DatosTXT.getUSUARIOS();
    private JTextField Asunto;
    private JTextField CorreoDestino;

    public PanelCorreos(FrameMecanografía frameMecanografía, Usuario user) {
        this.frameMecanografía = frameMecanografía;
        this.user = user;

        setLayout(null);
        setBounds(0, 0, 500, 700);

        JButton EnviarCorreo = new JButton("Enviar correo de prueba");
        EnviarCorreo.setBounds(106, 419, 276, 38);
        EnviarCorreo.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 15));
        EnviarCorreo.setForeground(Color.WHITE);
        EnviarCorreo.setBackground(new Color(11, 181, 200));
        add(EnviarCorreo);

        //Este botón sirve para volver al panel del administrador pero no cierra su sesión
        JButton volverAtrás = new JButton("Volver atrás");
        volverAtrás.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                PanelAdmin panelAdmin = new PanelAdmin(frameMecanografía, user);
                frameMecanografía.getContentPane().add(panelAdmin);
            }
        });
        volverAtrás.setBackground(new Color(255, 153, 102));
        volverAtrás.setForeground(Color.WHITE);
        volverAtrás.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 15));
        volverAtrás.setBounds(123, 479, 241, 27);
        add(volverAtrás);

        // Configuración del JList
        listModel = new DefaultListModel<>();
        list = new JList<>(listModel);
        list.setBounds(25, 141, 433, 94);
        add(list);

        // Cargar usuarios en la lista
        cargarUsuariosEnLista();

        // Este listener se encarga de obtener el usuario que se a clickado encima y se pone
        // automáticamente el correo de ese usuario en el campo Correo destino para que se 
       // envie un correo a ese usuario y evitar que se ponga de manera manual el correo.
        list.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedIndex = list.getSelectedIndex();
                if (selectedIndex != -1) {
                	//De la String seleccionada filtro el correo, me quedo solo con el correo entero.
                    String selectedValue = listModel.getElementAt(selectedIndex);
                    String correo = selectedValue.split(" \\| ")[2].replace("CORREO: ", "").trim();
                    CorreoDestino.setText(correo);
                }
            }
        });

        JLabel pregunta = new JLabel("¿A qué usuario quiere enviar un correo?");
        pregunta.setHorizontalAlignment(SwingConstants.CENTER);
        pregunta.setForeground(new Color(255, 153, 102));
        pregunta.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 22));
        pregunta.setBounds(32, 11, 430, 65);
        add(pregunta);

        JLabel pregunta2 = new JLabel("Seleccione un usuario en la lista y");
        pregunta2.setHorizontalAlignment(SwingConstants.CENTER);
        pregunta2.setForeground(Color.WHITE);
        pregunta2.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 20));
        pregunta2.setBounds(13, 47, 447, 68);
        add(pregunta2);

        JLabel pregunta2_1 = new JLabel("añada el asunto y el mensaje");
        pregunta2_1.setHorizontalAlignment(SwingConstants.CENTER);
        pregunta2_1.setForeground(Color.WHITE);
        pregunta2_1.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 20));
        pregunta2_1.setBounds(15, 90, 447, 38);
        add(pregunta2_1);

        JTextArea Mensaje = new JTextArea();
        Mensaje.setBounds(25, 306, 433, 94);
        add(Mensaje);
        Mensaje.setLineWrap(true); // Esto ajusta el texto automáticamente al ancho
        Mensaje.setWrapStyleWord(true); // Esto evita cortar palabras a la mitad

        JScrollPane scrollPane = new JScrollPane(Mensaje);
        scrollPane.setBounds(25, 306, 433, 94);
        add(scrollPane);

        Asunto = new JTextField();
        Asunto.setBounds(86, 251, 148, 19);
        add(Asunto);
        Asunto.setColumns(10);

        JLabel correo = new JLabel("Asunto");
        correo.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 15));
        correo.setForeground(Color.WHITE);
        correo.setBounds(26, 247, 114, 27);
        add(correo);

        JLabel lblPara = new JLabel("Para");
        lblPara.setForeground(Color.WHITE);
        lblPara.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 15));
        lblPara.setBounds(245, 248, 114, 27);
        add(lblPara);

        JLabel lblMensaje = new JLabel("Mensaje");
        lblMensaje.setForeground(Color.WHITE);
        lblMensaje.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 15));
        lblMensaje.setBounds(26, 275, 114, 27);
        add(lblMensaje);

        CorreoDestino = new JTextField();
        CorreoDestino.setEditable(false);
        CorreoDestino.setColumns(10);
        CorreoDestino.setBounds(288, 251, 170, 19);
        add(CorreoDestino);
        
        // El botón enviar correo está siendo escuchado, cuando pulsamos se intentará enviar un correo
        // la explicación del EventoEnviarCorreoPrueba está en esa clase
        EnviarCorreo.addActionListener(new EventoEnviarCorreoPrueba(Asunto,CorreoDestino, Mensaje));


        add(Imágenes.ponerFondo(fondoPanelLogin, frameMecanografía));
    }
    
    //Está función permite cargar los usuarios en la listModel que se muestra en el panel
    private void cargarUsuariosEnLista() {
        listModel.clear();
        for (int i = 1; i < USUARIOS.size(); i++) {
            listModel.addElement("ID: " + USUARIOS.get(i).getAlias() + " | " +
                                 "NOMBRE: " + USUARIOS.get(i).getNombre() + " | " +
                                 "CORREO: " + USUARIOS.get(i).getCorreo());
        }
    }

}
