package EjerciciosHilos_DanielBaldazoSánchez;

public class CocheRunnable implements Runnable {

	private String nombre;
	private int velocidad;
	private int distanciaTotal;

	public CocheRunnable(String nombre, int velocidad, int distanciaTotal) {
		this.nombre = nombre;
		this.velocidad = velocidad;
		this.distanciaTotal = distanciaTotal;
	}

	@Override
	public void run() {

		int km = 0;
		try {
			while (km != distanciaTotal) {
				Thread.sleep(velocidad);
				km++;
				System.out.println("El " + nombre + " ha avanzado 1km y lleva " + km + "KM's");
			}
			System.out.println("El " + nombre + " ha terminado");

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}


