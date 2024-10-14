package Hilos.Ejemplo1;

public class RatónSecuencial {
	
	private String nombre;
	private int tiempoAlimentacion;
	
	

	public RatónSecuencial(String nombre, int tiempoAlimentacion) {
		super();
		this.nombre = nombre;
		this.tiempoAlimentacion = tiempoAlimentacion;
	}
	
	public void comer() {
		
		System.out.printf("El ratón %s ha comenzado a alimentarse\n", nombre );
		try {
			Thread.sleep(tiempoAlimentacion*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.printf("El ratón %s ha terminado de alimentarse\n", nombre );

	}



	public static void main(String[] args) {

		RatónSecuencial Arturo = new RatónSecuencial("Arturo", 4);
		RatónSecuencial Bob = new RatónSecuencial("Bob", 5);
		RatónSecuencial Carlos = new RatónSecuencial("Carlos", 3);
		RatónSecuencial David = new RatónSecuencial("David", 7);
		
		Arturo.comer();
		Bob.comer();
		Carlos.comer();
		Arturo.comer();


		
	}

}
