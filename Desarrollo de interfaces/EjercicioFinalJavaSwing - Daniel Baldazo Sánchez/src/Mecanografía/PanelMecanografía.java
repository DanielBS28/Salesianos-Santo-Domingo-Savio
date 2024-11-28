package Mecanografía;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class PanelMecanografía extends JPanel {

    private FrameMecanografía frameMecanografía;
    private PanelLeccion panelLeccion;
    private char dificultad;

    public PanelMecanografía(FrameMecanografía frameMecanografía, char dificultad, PanelLeccion panelLeccion) {
        this.dificultad = dificultad;
        this.frameMecanografía = frameMecanografía;
        this.panelLeccion = panelLeccion;

        // Destruir el frame anterior para poder modificarlo
        frameMecanografía.dispose();
        
        // Eliminar la decoración de la ventana y hacerla redimensionable
        frameMecanografía.setUndecorated(false);
        
        // Configurar el tamaño de la ventana
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frameMecanografía.setSize(screenSize.width, screenSize.height);
        frameMecanografía.setLocationRelativeTo(null);
        frameMecanografía.setVisible(true);
        
    }
    }


