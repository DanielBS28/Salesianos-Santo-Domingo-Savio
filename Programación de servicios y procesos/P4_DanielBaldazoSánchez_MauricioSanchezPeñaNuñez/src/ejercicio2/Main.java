package ejercicio2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main {

	// static ArrayList <Object> OBJETOS = new ArrayList<>();

	// static ArrayList <Pepita> PEPITAS = new ArrayList<>();
//	static ArrayList <Minas> MINAS = new ArrayList<>();
	

	public static  void crear_insertarPepitas(int cantidad, HashMap<Coordenadas, Tipo> map) {

		for (int i = 0; i < cantidad; i++) {
			Coordenadas c =new Coordenadas();
			
			while(map.containsKey(c)) {
				map.put(c, Tipo.PEPITA);
			}
			
		}
	}

	private static void crear_Minas(int cantidad, HashMap<Coordenadas, Tipo> map) {
		for (int i = 0; i < cantidad; i++) {
			
			Coordenadas c =new Coordenadas();

			while(map.containsKey(c)) {
				map.put(c, Tipo.MINA);
			}
		}

	}
	
	private static void crear_Jugadores(int cantidad, HashMap<Coordenadas, Tipo> map) {
		for (int i = 0; i < cantidad; i++) {
			
			Coordenadas c =new Coordenadas();

			while(map.containsKey(c)) {
				map.put(c, Tipo.JUGADOR);
			}
		}

	}

	public static void main(String[] args) {
		// Tenemos 4 jugadores situados aleatorios
		// 2 minas situadas aleatorieamenter
		// 12 pepitas fijas en la matriz no se modifican
		// matriz de 15x15
		Tablero tableroPartida = new Tablero();

		crear_insertarPepitas(12, tableroPartida.map);
		crear_Minas(2, tableroPartida.map);
		crear_Jugadores(4, tableroPartida.map);


		tableroPartida.imprimirTablero();
	}

}
