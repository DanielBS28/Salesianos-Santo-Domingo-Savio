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

    public Teclado(char dificultad) {
        setLayout(null);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int panelWidth = (int) screenSize.getWidth();
        int panelHeight = (int) screenSize.getHeight();
        setBounds(0, 0, panelWidth, panelHeight);

        // Configurar el área de texto objetivo
        if (dificultad == PanelLeccion.FÁCIL) {
            textAreaObjetivo = new JTextArea(DatosTXT.TEXTOS.get(0));
        } else {
            textAreaObjetivo = new JTextArea(DatosTXT.TEXTOS.get(1));
        }

        textAreaObjetivo.setFont(new Font("Arial", Font.PLAIN, 20));
        textAreaObjetivo.setLineWrap(true);
        textAreaObjetivo.setWrapStyleWord(true);
        textAreaObjetivo.setEditable(false);
        textAreaObjetivo.setBackground(new Color(240, 240, 240));
        textAreaObjetivo.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));

        // Crear JScrollPane para textAreaObjetivo
        JScrollPane scrollObjetivo = new JScrollPane(textAreaObjetivo);
        scrollObjetivo.setBounds(20, 20, panelWidth - 40, panelHeight / 4); // Altura ajustada
        scrollObjetivo.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        add(scrollObjetivo);

        // Configurar el área de texto para escribir
        textAreaEscribir = new JTextArea();
        textAreaEscribir.setFont(new Font("Arial", Font.PLAIN, 20));
        textAreaEscribir.setLineWrap(true);
        textAreaEscribir.setWrapStyleWord(true);
        textAreaEscribir.setEditable(true);
        textAreaEscribir.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        // Crear JScrollPane para textAreaEscribir
        JScrollPane scrollEscribir = new JScrollPane(textAreaEscribir);
        scrollEscribir.setBounds(
                20,
                scrollObjetivo.getY() + scrollObjetivo.getHeight() + 20,
                panelWidth - 40,
                panelHeight / 4 // Altura ajustada igual que textAreaObjetivo
        );
        scrollEscribir.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        add(scrollEscribir);

        botonesMapa = new HashMap<>();

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

        textAreaEscribir.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                e.consume(); // Evita el manejo automático
                char c = e.getKeyChar();
                if (c != '\b') { // Bloquea la tecla de retroceso
                    textAreaEscribir.append(String.valueOf(c));
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
                if (e.getKeyCode() != KeyEvent.VK_BACK_SPACE) { // Bloquea Backspace
                    actualizarColorBoton(e.getKeyCode(), false);
                }
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


