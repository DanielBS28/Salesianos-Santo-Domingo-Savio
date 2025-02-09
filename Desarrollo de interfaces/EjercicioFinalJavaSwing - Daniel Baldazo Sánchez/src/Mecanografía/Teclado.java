package Mecanografía;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.Normalizer;
import java.util.HashMap;
import javax.swing.*;
import javax.swing.text.*;

public class Teclado extends JPanel {

    private FrameMecanografía frameMecanografía;
    private Usuario user;
    private HashMap<String, JButton> botonesMapa;
    private JTextPane textPaneEscribir;
    private JTextPane textPaneObjetivo;
    private String textoObjetivo; // Almacena el texto objetivo para comparación
    private int posicionActual; // Controla la posición actual del texto escrito
    private Timer Crono;

    private static int TiempoTotal = 0;
    private static int SegundosRestantes = 0;
    private static int ErroresMax = 0;
    private static int ErroresTeclas = 0;
    private static int AciertosTeclas = 0;
    private static int TeclasPulsadas = 0;
    private static int LetrasDelTexto = 0;
    private static int PPMinuto = 0;
    private static boolean PrimeraLetraPulsada = false;

    public Teclado(FrameMecanografía frameMecanografía, char dificultad, Usuario user) {
        setLayout(null);

        this.user = user;
        this.frameMecanografía = frameMecanografía;

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int panelWidth = (int) screenSize.getWidth();
        int panelHeight = (int) screenSize.getHeight();
        setBounds(0, 0, panelWidth, panelHeight);

        // Configurar el área de texto objetivo como JTextPane
        if (dificultad == PanelLeccion.FÁCIL) {
            textoObjetivo = DatosTXT.TEXTOS.get(0);
            TiempoTotal = 240;
            ErroresMax = 5;
            LetrasDelTexto = textoObjetivo.length() - 1;
        } else {
            textoObjetivo = DatosTXT.TEXTOS.get(1);
            TiempoTotal = 180;
            ErroresMax = 3;
            LetrasDelTexto = textoObjetivo.length() - 1;
        }

        SegundosRestantes = TiempoTotal;
        ErroresTeclas = 0;
        AciertosTeclas = 0;
        TeclasPulsadas = 0;
        PrimeraLetraPulsada = false;

        JLabel Aciertos = new JLabel("Aciertos");
        Aciertos.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 20));
        Aciertos.setForeground(new Color(0, 128, 64));
        Aciertos.setBounds(20, panelHeight - 120, 200, 40);
        add(Aciertos);

        JLabel AciertosValor = new JLabel("0");
        AciertosValor.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 20));
        AciertosValor.setForeground(new Color(0, 128, 64));
        AciertosValor.setBounds(140, panelHeight - 120, 200, 40);
        add(AciertosValor);

        JLabel Errores = new JLabel("Errores");
        Errores.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 20));
        Errores.setForeground(new Color(240, 0, 0));
        Errores.setBounds(220, panelHeight - 120, 200, 40);
        add(Errores);

        JLabel ErroresValor = new JLabel("0");
        ErroresValor.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 20));
        ErroresValor.setForeground(new Color(240, 0, 0));
        ErroresValor.setBounds(340, panelHeight - 120, 200, 40);
        add(ErroresValor);

        JLabel TiempoRestante = new JLabel("Tiempo restante");
        TiempoRestante.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 20));
        TiempoRestante.setForeground(new Color(0, 128, 255));
        TiempoRestante.setBounds(420, panelHeight - 120, 200, 40);
        add(TiempoRestante);

        JLabel TiempoRestanteValor = new JLabel(String.valueOf(TiempoTotal) + " s");
        TiempoRestanteValor.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 20));
        TiempoRestanteValor.setForeground(new Color(0, 128, 255));
        TiempoRestanteValor.setBounds(610, panelHeight - 120, 200, 40);
        add(TiempoRestanteValor);

        JLabel PPM = new JLabel("PPM");
        PPM.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 20));
        PPM.setForeground(new Color(255, 128, 0));
        PPM.setBounds(710, panelHeight - 120, 200, 40);
        add(PPM);

        JLabel PPMValor = new JLabel("0");
        PPMValor.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 20));
        PPMValor.setForeground(new Color(255, 128, 0));
        PPMValor.setBounds(810, panelHeight - 120, 200, 40);
        add(PPMValor);

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
        textPaneEscribir.setEditable(true); // Permitir edición para que el KeyListener funcione
        textPaneEscribir.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        // Crear JScrollPane para textPaneEscribir
        JScrollPane scrollEscribir = new JScrollPane(textPaneEscribir);
        scrollEscribir.setBounds(20, scrollObjetivo.getY() + scrollObjetivo.getHeight() + 20, panelWidth - 40,
                panelHeight / 4);
        scrollEscribir.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        add(scrollEscribir);

        botonesMapa = new HashMap<>();
        posicionActual = 0; // Inicializar posición

        // Crear las teclas virtuales
        String[] teclas = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "Q", "W", "E", "R", "T", "Y", "U", "I",
                "O", "P", "A", "S", "D", "F", "G", "H", "J", "K", "L", "Ñ", "Z", "X", "C", "V", "B", "N", "M", ",", ".",
                "Espacio" };

        int rows = 4;
        int buttonHeight = panelHeight / (rows + 10);
        int buttonWidth = panelWidth / 18;

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

        Crono = new Timer(1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                TiempoRestanteValor.setText(String.valueOf(--Teclado.SegundosRestantes + " s"));

                int tiempoTranscurrido = TiempoTotal - SegundosRestantes;
                if (tiempoTranscurrido > 0) {
                    PPMinuto = (TeclasPulsadas * 60) / tiempoTranscurrido;
                    PPMValor.setText(String.valueOf(PPMinuto)); // Suponiendo que tienes un JLabel para mostrarlo
                }

                if (SegundosRestantes == 0)
                    detenerJuego();

            }
        });

        // Añadir el KeyListener con el manejo del retroceso
        textPaneEscribir.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                // Consumir el evento para evitar que el carácter se inserte automáticamente
                e.consume();

                // Solo procesar si no es retroceso
                if (e.getKeyChar() != KeyEvent.VK_BACK_SPACE) {
                    char c = e.getKeyChar();
                    if (posicionActual < textoObjetivo.length()) {
                        manejarEntrada(c, ErroresValor, AciertosValor);
                        TeclasPulsadas++;
                        if (!PrimeraLetraPulsada) {
                            Crono.start();
                        }
                        PrimeraLetraPulsada = true;
                    }
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    e.consume(); // Bloquea la tecla de retroceso
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

    private void manejarEntrada(char c, JLabel JLErrores, JLabel JLAciertos) {
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

            // Normalizar caracteres para comparación (opcional, si no se desea distinguir tildes)
            char caracterObjetivo = textoObjetivo.charAt(posicionActual);
            char caracterIngresado = c;

            // Normalizar ambos caracteres (eliminar tildes)
            String textoObjetivoNormalizado = Normalizer.normalize(String.valueOf(caracterObjetivo), Normalizer.Form.NFD)
                    .replaceAll("\\p{M}", "");
            String textoIngresadoNormalizado = Normalizer.normalize(String.valueOf(caracterIngresado), Normalizer.Form.NFD)
                    .replaceAll("\\p{M}", "");

            // Comparar caracteres normalizados
            if (textoObjetivoNormalizado.equalsIgnoreCase(textoIngresadoNormalizado)) {
                docObjetivo.setCharacterAttributes(posicionActual, 1, estiloCorrecto, true);
                AciertosTeclas++;
                JLAciertos.setText(String.valueOf(AciertosTeclas));
            } else {
                docObjetivo.setCharacterAttributes(posicionActual, 1, estiloIncorrecto, true);
                ErroresTeclas++;
                JLErrores.setText(String.valueOf(ErroresTeclas));
            }

            // Actualizar el área de escritura con el carácter ingresado
            docEscribir.insertString(docEscribir.getLength(), String.valueOf(c), null);

            if (ErroresTeclas == ErroresMax || TeclasPulsadas == LetrasDelTexto)
                detenerJuego();
            posicionActual++; // Avanzar posición
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void detenerJuego() {
        Crono.stop();
        textPaneEscribir.setEditable(false);
        JOptionPane.showMessageDialog(null, "El juego ha terminado.", "Fin del juego", JOptionPane.INFORMATION_MESSAGE);

        frameMecanografía.dispose(); // Oculta el frame para poder modificarlo
        frameMecanografía.setUndecorated(false);
        frameMecanografía.setBounds(100, 100, 500, 570);
        frameMecanografía.setLocationRelativeTo(null);

        // Remueve el contenido actual antes de agregar el nuevo panel
        frameMecanografía.getContentPane().removeAll();

        // Agregar el nuevo panel
        PanelLeccion panelLeccion = new PanelLeccion(frameMecanografía, user);
        frameMecanografía.getContentPane().add(panelLeccion);

        // Forzar actualización de la interfaz
        frameMecanografía.revalidate();
        frameMecanografía.repaint();

        // Volver a hacer visible el frame
        frameMecanografía.setVisible(true);

    }

    private void actualizarColorBoton(int keyCode, boolean presionado) {
        String tecla = KeyEvent.getKeyText(keyCode).toUpperCase();

        // Manejar la tecla "Ñ"
        if (keyCode == KeyEvent.VK_DEAD_ACUTE) {
            tecla = "Ñ";
        }

        // Manejar la tecla de espacio
        if (keyCode == KeyEvent.VK_SPACE) {
            tecla = "ESPACIO";
        }

        // Manejar las teclas "," y "."
        if (keyCode == KeyEvent.VK_COMMA) {
            tecla = ",";
        }
        if (keyCode == KeyEvent.VK_PERIOD) {
            tecla = ".";
        }

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
