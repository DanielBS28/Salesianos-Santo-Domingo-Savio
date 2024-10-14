package Hilos.Ejemplo1;

public class RatónParalelo extends Thread {

	/*
	 * Heredar de la clase thread imposibilita heredar de otras clases por que java
	 * no admite heredar de otras clases porque Java no admite herencia multiple. Lo
	 * que hay que son interfaces Runnable y Callable. Ver otros ejemplos.
	 * 
	 * Nota: otros lenguajes de programación si admiten herencia multiple C++, C#,
	 * Ruby...
	 */

	private String nombre;
	private int tiempoAlimentacion;

	public RatónParalelo(String nombre, int tiempoAlimentacion) {
		super();
		this.nombre = nombre;
		this.tiempoAlimentacion = tiempoAlimentacion;
	}

	public void comer() {

		System.out.printf("El ratón %s ha comenzado a alimentarse\n", nombre);
		try {
			Thread.sleep(tiempoAlimentacion * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.printf("El ratón %s ha terminado de alimentarse\n", nombre);

	}

	@Override // metodo clase thread
	public void run() {

		// Esto es lo que se va a paralelizar
		comer();

	}

	public static void main(String[] args) {

		RatónParalelo Arturo = new RatónParalelo("Arturo", 4);
		RatónParalelo Bob = new RatónParalelo("Bob", 5);
		RatónParalelo Carlos = new RatónParalelo("Carlos", 3);
		RatónParalelo David = new RatónParalelo("David", 7);

	
		 Arturo.start();//Empieza el hilo nuevo 
		 Bob.start(); 
		 Carlos.start();
		 David.start();
		

		/*
		 * Arturo.run(); No paraleliza si pusiera esto todo el rato secuencialmente
		 * Bob.run(); Carlos.run(); David.run();
		 */

	}

}