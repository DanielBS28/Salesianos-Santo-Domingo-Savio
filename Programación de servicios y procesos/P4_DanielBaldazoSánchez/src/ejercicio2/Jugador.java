package ejercicio2;

import java.util.HashMap;
import java.util.Random;

public class Jugador {
    
    static Random r = new Random();
    public static HashMap<Coordenadas, Jugador> mapJugador = new HashMap<>();
    private static String caracter = "T";
    
    private int x = -1;  // Coordenada X
    private int y = -1;  // Coordenada Y
    
    static int IDJugador = 1;
    private String nombre;
    private int puntos = 0;
    private int IdJugadorPartida = 0;
    
    
    // Constructor
    public Jugador(String nombre) {
        IdJugadorPartida = IDJugador++;
        this.nombre = nombre;
    }

    // Getters y Setters para las coordenadas
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
    
    // Otros getters y setters
    public static int getIDJugador() {
        return IDJugador;
    }

    public static void setIDJugador(int iDJugador) {
        IDJugador = iDJugador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public int getIdJugadorPartida() {
        return IdJugadorPartida;
    }

    public void setIdJugadorPartida(int idJugadorPartida) {
        IdJugadorPartida = idJugadorPartida;
    }

    // MOVIMIENTO

    public static void MoverJugador(Coordenadas jugadorCoord, HashMap<Coordenadas, Tipo> tableroFijo, HashMap<Coordenadas, Jugador> mapJugador) {
        Random random = new Random();

        // Verificar que el jugador existe en el mapa
        Jugador jugador = mapJugador.get(jugadorCoord);
        if (jugador == null) {
            System.out.println("Error: El jugador en la coordenada " + jugadorCoord + " no se encuentra en el mapa.");
            return; // Detener el movimiento si no se encuentra el jugador
        }

        // Generar nuevas coordenadas aleatorias dentro del tablero de 15x15
        int nuevaX = random.nextInt(4);
        int nuevaY = random.nextInt(4);

        // Crear una nueva coordenada para el jugador
        Coordenadas nuevaPos = new Coordenadas(nuevaX, nuevaY);

        // Verificar si la nueva posición está dentro del tablero
        if (nuevaPos.getX() >= 0 && nuevaPos.getX() < 4 && nuevaPos.getY() >= 0 && nuevaPos.getY() < 4) {

            // Verificar si la nueva posición está ocupada por una mina o pepita
            if (tableroFijo.containsKey(nuevaPos)) {
                Tipo tipo = tableroFijo.get(nuevaPos);
                if (tipo == Tipo.PEPITA) {
                    System.out.println("¡Jugador " + jugador.getNombre() + " encontró una pepita en " + nuevaPos + "!");
                    tableroFijo.remove(nuevaPos); // Eliminar la pepita del mapa
                    jugador.setPuntos(jugador.getPuntos() + 1); // Sumar un punto al jugador
                } else if (tipo == Tipo.MINA) {
                    System.out.println("¡Jugador " + jugador.getNombre() + " explotó en una mina en " + nuevaPos + "!");
                    tableroFijo.remove(nuevaPos); // Eliminar la mina del mapa
                    mapJugador.remove(jugadorCoord); // Eliminar al jugador
                    return; // Detener el movimiento si el jugador muere
                }
            }

            // Verificar si la nueva posición está libre (no ocupada por otro jugador)
            if (!mapJugador.containsKey(nuevaPos)) {
                // Primero, eliminamos al jugador de la vieja posición
                mapJugador.remove(jugadorCoord);

                // Actualizamos las coordenadas del jugador
                mapJugador.put(nuevaPos, jugador); // Añadir el jugador a la nueva posición

                // Actualizamos las coordenadas del jugador
                jugador.setX(nuevaPos.getX());
                jugador.setY(nuevaPos.getY());

                //System.out.println("Jugador " + jugador.getNombre() + " se mueve a la posición " + nuevaPos);
            } else {
                System.out.println("¡La nueva posición " + nuevaPos + " está ocupada por otro jugador!");
            }
        } else {
            System.out.println("¡Movimiento fuera de los límites del tablero!");
        }
    }




    // Método para crear jugadores (ya que es estático)
    public static void crear_Jugadores(int cantidad, HashMap<Coordenadas, Jugador> jugadores) {
        for (int i = 0; i < cantidad; i++) {

            Coordenadas c = new Coordenadas();

            // Asegurarse de que no haya jugadores en la misma posición
            while (jugadores.containsKey(c)) {
                c = new Coordenadas(); // Generar nuevas coordenadas si ya existe una
            }
            
            // Crear el jugador con un nombre único
            Jugador jugador = new Jugador("Jugador " + (i + 1));
            jugadores.put(c, jugador); // Añadir el jugador al mapa
        }
    }


}
