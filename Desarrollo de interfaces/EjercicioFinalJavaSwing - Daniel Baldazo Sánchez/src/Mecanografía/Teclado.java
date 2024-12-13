package Mecanografía;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import javax.swing.*;
import javax.swing.text.*;

public class Teclado extends JPanel {

    private HashMap<String, JButton> botonesMapa;
    private JTextPane textPaneEscribir;
    private JTextPane textPaneObjetivo;
    private String textoObjetivo; // Almacena el texto objetivo para comparación
    private int posicionActual; // Controla la posición actual del texto escrito

    public Teclado(char dificultad) {
        setLayout(null);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int panelWidth = (int) screenSize.getWidth();
        int panelHeight = (int) screenSize.getHeight();
        setBounds(0, 0, panelWidth, panelHeight);

        // Configurar el área de texto objetivo como JTextPane
        if (dificultad == PanelLeccion.FÁCIL) {
            textoObjetivo = DatosTXT.TEXTOS.get(0);
        } else {
            textoObjetivo = DatosTXT.TEXTOS.get(1);
        }

        textPaneObjetivo = new JTextPane();
        textPaneObjetivo.setText(textoObjetivo);
        textPaneObjetivo.setFont(new Font("Arial", Font.PLAIN, 20));
        textPaneObjetivo.setEditable(false);
        textPaneObjetivo.setBackground(new Color(240, 240, 240));
        textPaneObjetivo.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));

        // Crear JScrollPane para textPaneObjetivo
        JScrollPane scrollObjetivo = new JScrollPane(textPaneObjetivo);
        scrollObjetivo.setBounds(20, 20, panelWidth - 40, panelHeight / 4);
        scrollObjetivo.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        add(scrollObjetivo);

        // Configurar el área de texto para escribir
        textPaneEscribir = new JTextPane();
        textPaneEscribir.setFont(new Font("Arial", Font.PLAIN, 20));
        textPaneEscribir.setEditable(false);
        textPaneEscribir.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        // Crear JScrollPane para textPaneEscribir
        JScrollPane scrollEscribir = new JScrollPane(textPaneEscribir);
        scrollEscribir.setBounds(
                20,
                scrollObjetivo.getY() + scrollObjetivo.getHeight() + 20,
                panelWidth - 40,
                panelHeight / 4
        );
        scrollEscribir.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        add(scrollEscribir);

        botonesMapa = new HashMap<>();
        posicionActual = 0; // Inicializar posición

        // Crear las teclas virtuales
        String[] teclas = {
                "1", "2", "3", "4", "5", "6", "7", "8", "9", "0",
                "Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P",
                "A", "S", "D", "F", "G", "H", "J", "K", "L",
                "Z", "X", "C", "V", "B", "N", "M", ",", ".", "Espacio"
        };

        int rows = 4;
        int buttonHeight = panelHeight / (rows + 8);
        int buttonWidth = panelWidth / 16;

        int xPos = 20, yPos = scrollEscribir.getY() + scrollEscribir.getHeight() + 20;
        for (String tecla : teclas) {
            JButton boton = new JButton(tecla);
            boton.setBounds(xPos, yPos, buttonWidth, buttonHeight);
            boton.setEnabled(false);
            botonesMapa.put(tecla.toUpperCase(), boton);
            add(boton);

            xPos += buttonWidth + 5;
            if (xPos + buttonWidth > panelWidth) {
                xPos = 20;
                yPos += buttonHeight + 5;
            }
        }

        textPaneEscribir.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                e.consume(); // Evita el manejo automático
                char c = e.getKeyChar();
                if (posicionActual < textoObjetivo.length()) {
                    manejarEntrada(c);
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    e.consume(); // Bloquea completamente la tecla de retroceso
                } else {
                    actualizarColorBoton(e.getKeyCode(), true);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() != KeyEvent.VK_BACK_SPACE) {
                    actualizarColorBoton(e.getKeyCode(), false);
                }
            }
        });

        textPaneEscribir.requestFocusInWindow();

        setVisible(true);
    }

    private void manejarEntrada(char c) {
        StyledDocument docObjetivo = textPaneObjetivo.getStyledDocument();
        StyledDocument docEscribir = textPaneEscribir.getStyledDocument();

        // Crear estilos
        Style estiloCorrecto = textPaneObjetivo.addStyle("Correcto", null);
        StyleConstants.setForeground(estiloCorrecto, Color.GREEN);

        Style estiloIncorrecto = textPaneObjetivo.addStyle("Incorrecto", null);
        StyleConstants.setForeground(estiloIncorrecto, Color.RED);

        Style estiloNormal = textPaneObjetivo.addStyle("Normal", null);
        StyleConstants.setForeground(estiloNormal, Color.BLACK);

        try {
            // Restaurar el texto restante a negro en el área objetivo
            docObjetivo.setCharacterAttributes(posicionActual, textoObjetivo.length() - posicionActual, estiloNormal, true);

            // Actualizar colores en el área objetivo
            if (c == textoObjetivo.charAt(posicionActual)) {
                docObjetivo.setCharacterAttributes(posicionActual, 1, estiloCorrecto, true);
            } else {
                docObjetivo.setCharacterAttributes(posicionActual, 1, estiloIncorrecto, true);
            }

            // Actualizar el área de escritura con el carácter ingresado
            docEscribir.insertString(docEscribir.getLength(), String.valueOf(c), null);

            posicionActual++; // Avanzar posición
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void actualizarColorBoton(int keyCode, boolean presionado) {
        String tecla = KeyEvent.getKeyText(keyCode).toUpperCase();

        if (keyCode == KeyEvent.VK_SPACE) tecla = "ESPACIO";

        JButton boton = botonesMapa.get(tecla);
        if (boton != null) {
            if (presionado) {
                boton.setBackground(Color.BLUE);
            } else {
                boton.setBackground(null);
            }
        }
    }
}



