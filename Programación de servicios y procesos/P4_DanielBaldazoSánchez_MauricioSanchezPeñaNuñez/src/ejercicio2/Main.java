package ejercicio2;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	
	static ArrayList <Pepita> PEPITAS = new ArrayList<>();
	static ArrayList <Minas> MINAS = new ArrayList<>();
	static Tablero tableroPartida = new Tablero();

	
	public static void crear_insertarPepitas(int cantidad) {
		
		for(int i = 0; i < cantidad; i++) {
			PEPITAS.add(new Pepita(PEPITAS));
		}
		
		tableroPartida.insertarDatosTableroPepitas(PEPITAS);
	}
	
	private static void crear_Minas(int cantidad) {
		for(int i = 0; i < cantidad; i++) {
			MINAS.add(new Minas(PEPITAS, MINAS));
		}
		
		tableroPartida.insertarDatosTableroMinas(MINAS);
		
	}

	public static void main(String[] args) {
		// Tenemos 4 jugadores situados aleatorios
		// 2 minas situadas aleatorieamenter
		// 12 pepitas fijas en la matriz no se modifican
		// matriz de 15x15
		
		crear_insertarPepitas(12);
		crear_Minas(2);
		
		tableroPartida.imprimirTablero();
	}

	
	
	

}
