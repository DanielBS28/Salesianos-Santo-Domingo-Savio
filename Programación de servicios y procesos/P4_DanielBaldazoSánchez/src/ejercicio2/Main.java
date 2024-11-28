package ejercicio2;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

	// static ArrayList <Object> OBJETOS = new ArrayList<>();

	// static ArrayList <Pepita> PEPITAS = new ArrayList<>();
//	static ArrayList <Minas> MINAS = new ArrayList<>();

	public static void crear_insertarPepitas(int cantidad, HashMap<Coordenadas, Tipo> map) {

		for (int i = 0; i < cantidad; i++) {
			Coordenadas c = new Coordenadas();

			while (map.containsKey(c)) {
				c = new Coordenadas();
			}
			map.put(c, Tipo.PEPITA);
		}
	}

	private static void crear_Minas(int cantidad, HashMap<Coordenadas, Tipo> map) {
		for (int i = 0; i < cantidad; i++) {

			Coordenadas c = new Coordenadas();

			while (map.containsKey(c)) {
				c = new Coordenadas();
			}
			map.put(c, Tipo.MINA);
		}

	}

	public static void main(String[] args) {
	    
	    Tablero tableroPartida = new Tablero();

	    
	    crear_insertarPepitas(2, tableroPartida.tableroFijo);
	    crear_Minas(2, tableroPartida.tableroFijo);
	    Jugador.crear_Jugadores(4, Jugador.mapJugador);

	    // Crear el tablero y mostrar su estado inicial
	    tableroPartida.inicializarTablero(tableroPartida.tableroFijo, Jugador.mapJugador);
	    tableroPartida.imprimirTablero();

	    // Simular movimiento de jugadores
	    for (int turno = 0; turno < 50; turno++) { // Limitar a 100 turnos
	        System.out.println("\nTurno " + (turno + 1));

	        // Mover cada jugador
	        for (Coordenadas jugadorCoord : new HashMap<>(Jugador.mapJugador).keySet()) {
	            //  pasamos el mapa de jugadores correctamente
	            Jugador.MoverJugador(jugadorCoord, tableroPartida.tableroFijo, Jugador.mapJugador);
	        }

	        
	        tableroPartida.inicializarTablero(tableroPartida.tableroFijo, Jugador.mapJugador);
	        tableroPartida.imprimirTablero();
	        
	        try {
	            Thread.sleep(800); // Pausa 
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	        
	    }
	}

}
