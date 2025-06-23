package Hilos.Ejemplo1_problemasConcurrencia;

public class RatónConProblemas implements Runnable {

	private String nombre;
	private int tiempoAlimentacion;
	private static int alimentoConsumido = 0;

	public RatónConProblemas(String nombre, int tiempoAlimentacion) {
		super();
		this.nombre = nombre;
		this.tiempoAlimentacion = tiempoAlimentacion;

	}

	public void comer() {

		System.out.printf("El ratón %s ha comenzado a alimentarse\n", nombre);
		try {
			
			Thread.sleep(tiempoAlimentacion * 1000);
			alimentoConsumido++;// Hay que conseguir sincronizar esto por que puede dar lugar a condiciones de carrera
			// condiciones de carrera.
	
			System.out.printf("El ratón %s ha terminado de alimentarse, alimento consumido %d \n", nombre,
					alimentoConsumido);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/*
	 * @Override // metodo clase thread public void run() {
	 * 
	 * // Esto es lo que se va a paralelizar comer();
	 * 
	 * }
	 */
	public static void main(String[] args) {

		RatónConProblemas Arturo = new RatónConProblemas("Arturo", 4);
		RatónConProblemas Bob = new RatónConProblemas("Bob", 5);
		RatónConProblemas Carlos = new RatónConProblemas("Carlos", 3);
		RatónConProblemas David = new RatónConProblemas("David", 7);

		for (int i = 0; i < 1000; i++)
			new Thread(Arturo).start();

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub por que
		comer();

	}

}