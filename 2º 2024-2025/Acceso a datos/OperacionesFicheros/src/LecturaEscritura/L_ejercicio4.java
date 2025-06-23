package LecturaEscritura;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class L_ejercicio4 {

	/*
	 * Escribe un programa que marque las veces que se repite cada palabra del
	 * fichero frutas.txt
	 */
	static void ejercicio4() {

		File archivo = new File("frutas.txt");
		leerFrutas(archivo);
	}

	static void leerFrutas(File archivo) {

		String linea;
		ArrayList<Fruta> FRUTAS = new ArrayList<>();
		boolean frutaencontrada = false;

		try {
			BufferedReader lector = new BufferedReader(new FileReader(archivo));
			while ((linea = lector.readLine()) != null) {
				frutaencontrada = false;

				for (int i = 0; i < FRUTAS.size(); i++) {
					if (FRUTAS.get(i).getNombre().equals(linea)) {
						FRUTAS.get(i).cantidad++;
						frutaencontrada = true;
					}

				}
				if (!frutaencontrada)
					FRUTAS.add(new Fruta(linea));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		for (int i = 0; i < FRUTAS.size(); i++) {
			System.out.println(FRUTAS.get(i).toString());
		}
	}

	public static void main(String[] args) {

		ejercicio4();

	}

}
