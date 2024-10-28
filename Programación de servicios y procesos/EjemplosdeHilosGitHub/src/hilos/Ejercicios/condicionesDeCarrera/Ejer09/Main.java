package hilos.Ejercicios.condicionesDeCarrera.Ejer09;

public class Main {

	public static void main(String[] args) {
		
		CajeroAutomatico ca = new CajeroAutomatico();
		
		Thread hilo1 = new Thread(new UsuarioCajero(ca,300));
		Thread hilo2 = new Thread(new UsuarioCajero(ca,600));
		Thread hilo3 = new Thread(new UsuarioCajero(ca,300));


		hilo1.start();
		hilo2.start();
		hilo3.start();

		try {

			hilo1.join();
			hilo2.join();
			hilo3.join();

		} catch (InterruptedException e) {
			e.getStackTrace();
		}
	


	}

}
