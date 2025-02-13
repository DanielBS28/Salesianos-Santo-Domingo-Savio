package Paneles;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import javax.swing.*;
import javax.swing.text.*;
import Mecanografía_MAIN_y_FRAME.*;
import ClasesArchivos.*;
import Utilidades.Archivos;
import Utilidades.DatosTXT;

public class PanelTeclado extends JPanel {
	
	//Este panel es el "juego" es decir donde el usuario va a poder escribir el texto, visualizarlo,
	// ver como cambia en tiempo real los colores, los segundos etc...

    private FrameMecanografía frameMecanografía;
    private Usuario user;
    private HashMap<String, JButton> botonesMapa;
    private JTextPane textPaneEscribir;
    private JTextPane textPaneObjetivo;
    private String textoObjetivo; 
    private int posicionActual; 
    private Timer Crono;

    private char dificultad;
    private static int TiempoTotal = 0;
    private static int SegundosRestantes = 0;
    private static int ErroresMax = 0;
    private static int ErroresTeclas = 0;
    private static int AciertosTeclas = 0;
    private static int TeclasPulsadas = 0;
    private static int LetrasDelTexto = 0;
    private static int PPMinuto = 0;
    private static boolean PrimeraLetraPulsada = false;

    public PanelTeclado(FrameMecanografía frameMecanografía, char dificultad, Usuario user) {
        setLayout(null);

        this.user = user;
        this.frameMecanografía = frameMecanografía;
        this.dificultad = dificultad;

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int panelWidth = (int) screenSize.getWidth();
        int panelHeight = (int) screenSize.getHeight();
        setBounds(0, 0, panelWidth, panelHeight);
        
        // Si la bandera que le pasamos anteriormente es la de fácil el texto será
        // el de la lección fácil y tendrá tiempo, errores maximos y letras del texto
        // las de la lección fácil

        if (dificultad == PanelLeccion.FÁCIL) {
            textoObjetivo = DatosTXT.TEXTOS.get(0);
            TiempoTotal = 240;
            ErroresMax = 5;
            LetrasDelTexto = textoObjetivo.length() - 1;
            
            //Si la bandera es la del texto difícil tendrá estas características
        } else {
            textoObjetivo = DatosTXT.TEXTOS.get(1);
            TiempoTotal = 180;
            ErroresMax = 3;
            LetrasDelTexto = textoObjetivo.length() - 1;
        }

        //Esto cada vez que creo el panel teclado lo tengo que reiniciar ya que son variables
        // de la clase y si no las reinicio se quedan las de la partida anterior.
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

        //Este es el texto que el usuario debe escribir
        textPaneObjetivo = new JTextPane();
        textPaneObjetivo.setText(textoObjetivo);
        textPaneObjetivo.setFont(new Font("Arial", Font.PLAIN, 20));
        textPaneObjetivo.setEditable(false);
        textPaneObjetivo.setBackground(new Color(240, 240, 240));
        textPaneObjetivo.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));

        // JScrollPane para textPaneObjetivo
        JScrollPane scrollObjetivo = new JScrollPane(textPaneObjetivo);
        scrollObjetivo.setBounds(20, 30, panelWidth - 40, panelHeight / 4);
        scrollObjetivo.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        add(scrollObjetivo);

        // este es el área de texto para que el usuario escriba
        textPaneEscribir = new JTextPane();
        textPaneEscribir.setFont(new Font("Arial", Font.PLAIN, 20));
        textPaneEscribir.setEditable(true); // Permitir edición para que el KeyListener funcione
        textPaneEscribir.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        //JScrollPane para textPaneEscribir
        JScrollPane scrollEscribir = new JScrollPane(textPaneEscribir);
        scrollEscribir.setBounds(20, scrollObjetivo.getY() + scrollObjetivo.getHeight() + 20, panelWidth - 40,
                panelHeight / 4);
        scrollEscribir.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        add(scrollEscribir);
        
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBounds(0, 0, 108, 22);
        add(menuBar);

        // menú 
        JMenu mnMenu = new JMenu("Menu");
        menuBar.add(mnMenu);

        // ítem "Ayuda para el tutorial"
        JMenuItem Ayuda = new JMenuItem("Ayuda para el tutorial");
        mnMenu.add(Ayuda);

        // Creación del menú "Acerca de"
        JMenu AcercaDe = new JMenu("Acerca de");
        menuBar.add(AcercaDe);

        // Creación del ítem "Información de la APP"
        JMenuItem Información = new JMenuItem("Información de la APP");
        AcercaDe.add(Información);

        // esta es la acción que al hacer clic en "Ayuda para el tutorial" mostrará la imagen del teclado
        Ayuda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Crear un JLabel con una imagen
                ImageIcon icon = new ImageIcon("src/Mecanografía/ImágenesAPP/Ayuda_Teclado.jpg");
                JLabel label = new JLabel(icon);

                // JOptionPane para mostrar la imagen
                JOptionPane.showMessageDialog(null, label, "Ayuda para el tutorial", JOptionPane.PLAIN_MESSAGE);
            }
        });

        // Acción al hacer clic en "Información de la APP"
        Información.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mostrar un mensaje con el nombre y la versión de la aplicación
                JOptionPane.showMessageDialog(null, "Nombre del desarrollador: Daniel Baldazo Sánchez\nVersión: 2.0", "Información de la APP", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        setVisible(true);
    

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

        //Este es el action listener del crono
        Crono = new Timer(1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	//Cada segundo se va a ir actualizando el Jlabel de tiempor Restante con los segundos restantes
                TiempoRestanteValor.setText(String.valueOf(--PanelTeclado.SegundosRestantes + " s"));

                int tiempoTranscurrido = TiempoTotal - SegundosRestantes;
                //Si el tiempo transcurrido es mayor que cero voy a mostrar las PPM en su label
                if (tiempoTranscurrido > 0) {
                    PPMinuto = (TeclasPulsadas * 60) / tiempoTranscurrido;
                    PPMValor.setText(String.valueOf(PPMinuto)); 
                }
                //Si llego a 0 segundo el juego termina
                if (SegundosRestantes == 0)
                    detenerJuego();

            }
        });

        // Añado un KeyListener con la gestión de la tecla retroceso
        textPaneEscribir.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                // Consumir el evento para evitar que el carácter se inserte automáticamente
                e.consume();

                // Se va a ejecutar esto si no es la tecla de retroceso
                if (e.getKeyChar() != KeyEvent.VK_BACK_SPACE) {
                    char c = e.getKeyChar();
                    if (posicionActual < textoObjetivo.length()) {
                        manejarEntrada(c, ErroresValor, AciertosValor);
                        TeclasPulsadas++;
                        //La primera tecla que pulso es la que iniciará el crono
                        if (!PrimeraLetraPulsada) {
                            Crono.start();
                        }
                        // luego pongo esta variable a true
                        // para que no se meta más en en el if de "if (!PrimeraLetraPulsada)"
                        PrimeraLetraPulsada = true;
                    }
                }
            }

            //Este es el evento para actualizar el color de la letra del teclado virtual
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    e.consume(); // Bloquea la tecla de retroceso
                } else {
                    actualizarColorBoton(e.getKeyCode(), true);
                }
            }
            //Este es el evento para volver al color original de la letra del teclado virtual

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
    
    //Esta función es muy importante, con ella actulizaremos los errores, aciertos, colores de las letras...

    private void manejarEntrada(char c, JLabel JLErrores, JLabel JLAciertos) {
        StyledDocument docObjetivo = textPaneObjetivo.getStyledDocument();
        StyledDocument docEscribir = textPaneEscribir.getStyledDocument();

        // Crear estilos, este es para la opción correcto
        Style estiloCorrecto = textPaneObjetivo.addStyle("Correcto", null);
        StyleConstants.setForeground(estiloCorrecto, Color.GREEN);

       // este es para la opción de incorrecto
        Style estiloIncorrecto = textPaneObjetivo.addStyle("Incorrecto", null);
        StyleConstants.setForeground(estiloIncorrecto, Color.RED);

        // esta es la opción normal
        Style estiloNormal = textPaneObjetivo.addStyle("Normal", null);
        StyleConstants.setForeground(estiloNormal, Color.BLACK);

        try {
            // Restaurar el texto restante a negro en el área objetivo
            docObjetivo.setCharacterAttributes(posicionActual, textoObjetivo.length() - posicionActual, estiloNormal, true);

            // Obtener el carácter objetivo y el carácter ingresado
            char caracterObjetivo = textoObjetivo.charAt(posicionActual);
            char caracterIngresado = c;

            // Comparar caracteres directamente (respetando mayúsculas/minúsculas y tildes)
            
            //Si la tecla pulsada es la misma que la del texto se pone de color verde y actualizo aciertos
            if (caracterObjetivo == caracterIngresado) {
                docObjetivo.setCharacterAttributes(posicionActual, 1, estiloCorrecto, true);
                AciertosTeclas++;
                JLAciertos.setText(String.valueOf(AciertosTeclas));
            } else {
                //Si la tecla pulsada no es la misma que la del texto se pone de color rojo y actualizo errores

                docObjetivo.setCharacterAttributes(posicionActual, 1, estiloIncorrecto, true);
                ErroresTeclas++;
                JLErrores.setText(String.valueOf(ErroresTeclas));
            }

            // Actualizar el área de escritura con el carácter ingresado
            docEscribir.insertString(docEscribir.getLength(), String.valueOf(c), null);

            //Si los errores son iguales a los errores maximos permitidos de la lección o has terminado la lección
            // el juego se detiene
            if (ErroresTeclas == ErroresMax || TeclasPulsadas == LetrasDelTexto)
                detenerJuego();
            
            posicionActual++; // Avanzar posición si hemos llegado hasta aquí y pasar a la siguiente letra del texto
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Est es la función que finaliza el juego 
    private void detenerJuego() {
    	
    	//El crono para de contar
        Crono.stop();
        textPaneEscribir.setEditable(false);
        //Con esta función obtento la nota y además comprueba si se ha superado el récord.
        double Nota = Archivos.obtenerNota(SegundosRestantes, TeclasPulsadas, LetrasDelTexto,
        		PPMinuto, AciertosTeclas, ErroresTeclas, TiempoTotal,dificultad, user);
        
        //Esto es una ventana emergente que te muestra las estadísticas de la partida que has jugado
        JOptionPane.showMessageDialog(null, "ESTADÍSTICAS DE LA PARTIDA:\n\n"
        		+ "Aciertos: " + AciertosTeclas +"\nErrores: " +ErroresTeclas +"\nPPM: " +PPMinuto +"\nTiempo restante: "+ SegundosRestantes+" "
        				+ "segundos\nTiempo usado: " + (TiempoTotal-SegundosRestantes)
        		+" segundos\n\nNota: " + Nota, "Fin del juego", JOptionPane.INFORMATION_MESSAGE);
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

    //Esta función colorea de color azul las teclas del teclado virtual, y añado la tecla Ñ, el espacio, el punto
    // y la coma para poder ser coloreadas
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
