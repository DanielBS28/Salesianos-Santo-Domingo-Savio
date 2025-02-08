package Mecanografía;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class PanelTextos extends JPanel {
    
    private FrameMecanografía frameMecanografía;
    private Usuario user;
    private static String fondoPanelLogin = "src/Mecanografía/ImágenesAPP/FondoAzulado.jpg";
    private JTextArea JTPTextoFácil;
    private JTextArea JTPTextoDifícil;
    private boolean TextosArtificiales = false;
    
    static ArrayList<String> TEXTOS = DatosTXT.getTEXTOS();

    public PanelTextos(FrameMecanografía frameMecanografía, Usuario user) {
        this.frameMecanografía = frameMecanografía;
        this.user = user;
        
        setLayout(null);
        setBounds(0, 0, 500, 700);
        
        reajusteDeTextos();
        
        JLabel pregunta = new JLabel("Modifique los textos y guarde los cambios");
        pregunta.setHorizontalAlignment(SwingConstants.CENTER);
        pregunta.setForeground(new Color(255, 153, 102));
        pregunta.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 20));
        pregunta.setBounds(31, 2, 430, 65);
        add(pregunta);
        
        JLabel leccióndifícil = new JLabel("Texto de la lección difícil");
        leccióndifícil.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 15));
        leccióndifícil.setForeground(Color.WHITE);
        leccióndifícil.setBounds(20, 236, 222, 27);
        add(leccióndifícil);
        
        JLabel lecciónfácil = new JLabel("Texto de la lección fácil");
        lecciónfácil.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 15));
        lecciónfácil.setForeground(Color.WHITE);
        lecciónfácil.setBounds(20, 60, 205, 27);
        add(lecciónfácil);
        
        // Inicialización de los JTextArea
        JTPTextoFácil = new JTextArea(DatosTXT.getTEXTOS().get(0));
        JTPTextoFácil.setFont(new Font("Arial", Font.PLAIN, 13));
        JTPTextoFácil.setBackground(new Color(240, 240, 240));
        JTPTextoFácil.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        JTPTextoFácil.setLineWrap(true);  // Activa el ajuste de línea
        JTPTextoFácil.setWrapStyleWord(true); // Ajusta por palabras completas

        // JScrollPane para JTPTextoFácil
        JScrollPane scrollObjetivo = new JScrollPane(JTPTextoFácil);
        scrollObjetivo.setBounds(20, 95, 450, 130);
        scrollObjetivo.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        scrollObjetivo.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollObjetivo.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        add(scrollObjetivo);

        // Inicialización de los JTextArea
        JTPTextoDifícil = new JTextArea(DatosTXT.getTEXTOS().get(1));
        JTPTextoDifícil.setFont(new Font("Arial", Font.PLAIN, 13));
        JTPTextoDifícil.setBackground(new Color(240, 240, 240));
        JTPTextoDifícil.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        JTPTextoDifícil.setLineWrap(true);  // Activa el ajuste de línea
        JTPTextoDifícil.setWrapStyleWord(true); // Ajusta por palabras completas

        // JScrollPane para JTPTextoDifícil
        JScrollPane scrollObjetivo2 = new JScrollPane(JTPTextoDifícil);
        scrollObjetivo2.setBounds(20, 270, 450, 130);
        scrollObjetivo2.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        scrollObjetivo2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollObjetivo2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        add(scrollObjetivo2);
        
        // Botón para volver atrás
        JButton volverAtrás = new JButton("Volver atrás");
        volverAtrás.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                PanelAdmin panelAdmin = new PanelAdmin(frameMecanografía, user);
                frameMecanografía.getContentPane().add(panelAdmin);
            }
        });
        volverAtrás.setBackground(new Color(255, 153, 102));
        volverAtrás.setForeground(new Color(255, 255, 255));
        volverAtrás.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 15));
        volverAtrás.setBounds(123, 485, 241, 27);
        add(volverAtrás);
        
        // Botón para actualizar textos
        JButton actualizarTextos = new JButton("Actualizar textos");
        actualizarTextos.addActionListener(new eventoActualizarTextos(JTPTextoFácil, JTPTextoDifícil));
        actualizarTextos.setBounds(106, 429, 276, 38);
        actualizarTextos.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 15));
        actualizarTextos.setForeground(Color.WHITE);
        actualizarTextos.setBackground(new Color(235, 223, 5));
        add(actualizarTextos);
        
        add(Imágenes.ponerFondo(fondoPanelLogin, frameMecanografía));
        
        if (TextosArtificiales) 
            eventoActualizarTextos.eliminarDatosAntiguos(TEXTOS);
    }

    private void reajusteDeTextos() {

        if (TEXTOS.size() != 2) {
            TEXTOS.add("Introduzca aquí el texto para la lección fácil");
            TEXTOS.add("Introduzca aquí el texto para la lección difícil");
            TextosArtificiales = true;
        }
    }
}
