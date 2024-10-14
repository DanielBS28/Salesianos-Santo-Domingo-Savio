package Hilos.Ejemplo1;

public class RatónRunnable implements Runnable {

	private String nombre;
	private int tiempoAlimentacion;

	public RatónRunnable(String nombre, int tiempoAlimentacion) {
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

	/*
	 * @Override // metodo clase thread public void run() {
	 * 
	 * // Esto es lo que se va a paralelizar comer();
	 * 
	 * }
	 */
	public static void main(String[] args) {

		RatónRunnable Arturo = new RatónRunnable("Arturo", 4);
		RatónRunnable Bob = new RatónRunnable("Bob", 5);
		RatónRunnable Carlos = new RatónRunnable("Carlos", 3);
		RatónRunnable David = new RatónRunnable("David", 7);

		/*
		 * De alguna forma hay que utilizar thread que es la clase que crea hilos lo que
		 * podemos utilizar es el constructor de thread thread tiene un constructor que
		 * admite un argumento de tipo runnable
		 */

		Thread t1 = new Thread(Arturo);
		t1.start(); // Encola el hilo para su ejecución paralela.
		
		
		new Thread(Bob).start();
		new Thread(Carlos).start();
		new Thread(David).start();// lo mismo de arriba pero menos recomendable
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub por que
		comer();

	}

}
