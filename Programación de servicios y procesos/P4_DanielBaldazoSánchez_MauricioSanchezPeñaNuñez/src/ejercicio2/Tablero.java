package ejercicio2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class Tablero {

	private String[][] tableroPartida = new String[15][15];
	public static HashMap<Coordenadas, Tipo> map = new HashMap<>();

	public Tablero() {

		inicializarTablero();
	}

	public void inicializarTablero() {

		for (int i = 0; i < tableroPartida.length; i++) {
			for (int j = 0; j < tableroPartida[i].length; j++) {
				//
				if (map.get(new Coordenadas(i,j)) == Tipo.MINA) {
					tableroPartida[i][j] = "M";
				} else if (map.get(new Coordenadas(i,j)) == Tipo.PEPITA) {
					tableroPartida[i][j] = "p";
				} else if (map.get(new Coordenadas(i,j)) == Tipo.JUGADOR) {
					tableroPartida[i][j] = "T";
				}else
					tableroPartida[i][j] = "*";
			}

		}
	}

	public void imprimirTablero() {

		for (String[] fila : tableroPartida) {
			for (String columna : fila) {
				System.out.print(columna + " ");
			}
			System.out.println();
		}
	}

	public String[][] getTablero() {
		return tableroPartida;
	}

	public void setTablero(String[][] tablero) {
		this.tableroPartida = tablero;
	}

}
