package Mecanografía;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import javax.swing.*;

public class Teclado extends JPanel {

    private HashMap<String, JButton> botonesMapa; 
    private JTextArea textAreaEscribir; 
    private JTextArea textAreaObjetivo; 

    public Teclado() {
        setLayout(null); 
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int panelWidth = (int) screenSize.getWidth();
        int panelHeight = (int) screenSize.getHeight();
        setBounds(0, 0, panelWidth, panelHeight);

        textAreaObjetivo = new JTextArea("Esto es un texto de prueba");
        textAreaObjetivo.setFont(new Font("Arial", Font.PLAIN, 20));
        textAreaObjetivo.setLineWrap(true);
        textAreaObjetivo.setWrapStyleWord(true);
        textAreaObjetivo.setEditable(false);
        textAreaObjetivo.setBounds(20, 20, panelWidth - 40, panelHeight / 12); // Ocupa la parte superior
        textAreaObjetivo.setBackground(new Color(240, 240, 240));
        textAreaObjetivo.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        add(textAreaObjetivo);

        textAreaEscribir = new JTextArea();
        textAreaEscribir.setFont(new Font("Arial", Font.PLAIN, 20));
        textAreaEscribir.setLineWrap(true);
        textAreaEscribir.setWrapStyleWord(true);
        textAreaEscribir.setEditable(false);
        textAreaEscribir.setBounds(20, panelHeight / 12 + 30, panelWidth - 40, panelHeight / 12); // Debajo del objetivo
        textAreaEscribir.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        add(textAreaEscribir);

        botonesMapa = new HashMap<>();

        // Crear las teclas virtuales
        String[] teclas = {
                "1", "2", "3", "4", "5", "6", "7", "8", "9", "0",
                "Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P",
                "A", "S", "D", "F", "G", "H", "J", "K", "L",
                "Z", "X", "C", "V", "B", "N", "M", ",", ".", "Espacio"
        };

        int rows = 4; 
        int buttonHeight = panelHeight / (rows + 4); 
        int buttonWidth = panelWidth / 12; 

        int xPos = 20, yPos = panelHeight / 4;
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

        textAreaEscribir.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (e.getKeyChar() != '\b') {
                    textAreaEscribir.append(String.valueOf(c));
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() != KeyEvent.VK_BACK_SPACE) {
                    actualizarColorBoton(e.getKeyCode(), true);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                actualizarColorBoton(e.getKeyCode(), false);
            }
        });

        textAreaEscribir.requestFocusInWindow();

        setVisible(true);
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