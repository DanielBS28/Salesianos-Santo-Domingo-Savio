package ejercicio2;

import java.util.ArrayList;
import java.util.Random;

public class Minas {

	static Random r = new Random();

	private static String caracter = "m";
	private int x = -1;
	private int y = -1;

	public Minas(ArrayList<Pepita> Pepitas, ArrayList<Minas> Minas) {

		generarCoordenadas(Pepitas, Minas);
	}

	private void generarCoordenadas(ArrayList<Pepita> pepitas, ArrayList<Minas> minas) {

		int CoorX, CoorY = 0;

		do {
			CoorX = r.nextInt(0, 15);
			CoorY = r.nextInt(0, 15);

		} while (!comprobarCoordenadas(pepitas,minas, CoorX, CoorY));

		this.x = CoorX;
		this.y = CoorY;
	}

	private boolean comprobarCoordenadas(ArrayList<Pepita> pepitas, ArrayList<Minas> minas, int coorX, int coorY) {

		boolean repetidos = true;
		
		for(Pepita p: pepitas) {
			if(p.getX() == coorX && p.getY() == coorY)
				repetidos = false;
		}
		for(Minas m: minas) {
			if(m.getX() == coorX && m.getY() == coorY)
				repetidos = false;
		}
		
		return repetidos;
	}

	public static Random getR() {
		return r;
	}

	public static void setR(Random r) {
		Minas.r = r;
	}

	public static String getCaracter() {
		return caracter;
	}

	public static void setCaracter(String caracter) {
		Minas.caracter = caracter;
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
