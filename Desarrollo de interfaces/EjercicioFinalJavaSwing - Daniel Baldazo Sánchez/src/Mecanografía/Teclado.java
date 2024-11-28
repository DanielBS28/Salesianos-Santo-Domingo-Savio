package Mecanografía;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class Teclado extends JPanel {

    public Teclado() {
        setLayout(null); 
        setBounds(0, 0, 500, 500); 

        JTextArea textArea = new JTextArea();
        textArea.setFont(new Font("Arial", Font.PLAIN, 20));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        textArea.setBounds(20, 20, 560, 200); 
        add(textArea);

        // Crear las teclas (Botones)
        String[] teclas = { "Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P", "A", "S", "D", "F", "G", "H", "J", "K",
                "L", "Z", "X", "C", "V", "B", "N", "M", "Espacio", "Enter", "Backspace" };

        int xPos = 20, yPos = 250; 
        int buttonWidth = 50, buttonHeight = 40;

        for (int i = 0; i < teclas.length; i++) {
            String tecla = teclas[i];
            JButton boton = new JButton(tecla);
            boton.setBounds(xPos, yPos, buttonWidth, buttonHeight);
            boton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String texto = textArea.getText();
                    if (tecla.equals("Espacio")) {
                        textArea.setText(texto + " ");
                    } else if (tecla.equals("Enter")) {
                        textArea.setText(texto + "\n");
                    } else if (tecla.equals("Backspace")) {
                        if (texto.length() > 0) {
                            textArea.setText(texto.substring(0, texto.length() - 1));
                        }
                    } else {
                        textArea.setText(texto + tecla);
                    }
                }
            });
            add(boton);

  
            xPos += buttonWidth + 5; 
            if ((i + 1) % 10 == 0) { 
                xPos = 20;
                yPos += buttonHeight + 5;
            }
        }

        setVisible(true);
    }
}