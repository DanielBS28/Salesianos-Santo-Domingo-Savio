package ejercicio2;

import java.util.ArrayList;
import java.util.Random;

public class Coordenadas {

	static Random r = new Random();

	private int x;
	private int y;

	private void generarCoordenadas() {

		this.x = r.nextInt(0, 15);
		this.y = r.nextInt(0, 15);

	}

//GET Y SET
	public Coordenadas(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Coordenadas() {
		generarCoordenadas();
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
