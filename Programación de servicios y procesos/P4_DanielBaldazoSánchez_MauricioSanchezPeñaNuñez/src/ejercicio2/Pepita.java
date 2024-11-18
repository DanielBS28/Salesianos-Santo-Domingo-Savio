package ejercicio2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Pepita {

	static Random r = new Random();

	private static String caracter = "P";
	private int x = -1;
	private int y = -1;

	public Pepita(ArrayList<Pepita> PEPITAS) {
		
		generarCoordenadas(PEPITAS);
	}

	private void generarCoordenadas(ArrayList<Pepita> PEPITAS) {

		int CoorX, CoorY = 0;
		
		do {
			CoorX =  r.nextInt(0, 15);
			CoorY =  r.nextInt(0, 15);
			
		} while (!comprobarCoordenadas(PEPITAS, CoorX, CoorY));

		this.x =  CoorX;
		this.y =  CoorY;
		
	}

	private boolean comprobarCoordenadas(ArrayList<Pepita> Pepitas, int CoorX, int CoorY) {

		for (Pepita p : Pepitas) {

			if (p.getX() == CoorX && p.getY() == CoorY)
				return false;
		}
		return true;

	}

	public static String getSimbolo() {
		return caracter;
	}

	public void setSimbolo(String simbolo) {
		Pepita.caracter = simbolo;
	}



	public String getCaracter() {
		return caracter;
	}

	public static void setCaracter(String simbolo) {
		caracter = simbolo;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}
