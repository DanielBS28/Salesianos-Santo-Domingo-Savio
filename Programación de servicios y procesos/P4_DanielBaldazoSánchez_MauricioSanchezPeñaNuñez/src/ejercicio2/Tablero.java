package ejercicio2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Tablero {

	private String[][] tableroPartida = new String[15][15];

	public Tablero() {

		inicializarTablero();
	}

	public void inicializarTablero() {

		for (int i = 0; i < tableroPartida.length; i++) {
			for (int j = 0; j < tableroPartida[i].length; j++) {
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

	public void insertarDatosTableroPepitas(ArrayList<Pepita> Pepitas) {

		for (int i = 0; i < Pepitas.size(); i++) {

			int CoorX = Pepitas.get(i).getX();
			int CoorY = Pepitas.get(i).getY();

			tableroPartida[CoorX][CoorY] = Pepita.getSimbolo();

		}
	}

	public void insertarDatosTableroMinas(ArrayList<Minas> MINAS) {

		for (int i = 0; i < MINAS.size(); i++) {

			int CoorX = MINAS.get(i).getX();
			int CoorY = MINAS.get(i).getY();

			tableroPartida[CoorX][CoorY] = Minas.getCaracter();

		}
	}

}
