package ejercicio2;

import java.util.Objects;
import java.util.Random;

public class Coordenadas {

	static Random r = new Random();

	private int x;
	private int y;

	// CORDENADAS
	private void generarCoordenadas() {

		this.x = r.nextInt(0, 4);
		this.y = r.nextInt(0, 4);

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
	
	@Override
	public boolean equals(Object o) {
		 
		if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;
	        Coordenadas that = (Coordenadas) o;
	        return x == that.x && y == that.y;
		
	}
	
	 @Override
	    public int hashCode() {
	        return Objects.hash(x, y);
	    }

	@Override
	public String toString() {
		return "Coordenadas [x=" + x + ", y=" + y + "]";
	}

}
