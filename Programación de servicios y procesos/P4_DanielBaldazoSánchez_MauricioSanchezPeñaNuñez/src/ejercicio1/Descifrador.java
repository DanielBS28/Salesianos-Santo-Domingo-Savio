package ejercicio1;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class Descifrador {

	/*
	 * public static void descifradorParalelo() {
	 * 
	 * DescifradorParalelo h1 = new DescifradorParalelo("a", 4,
	 * "b221d9dbb083a7f33428d7c2a3c3198ae925614d70210e28716ccaa7cd4ddb79");
	 * DescifradorParalelo h2 = new DescifradorParalelo("b", 4,
	 * "b221d9dbb083a7f33428d7c2a3c3198ae925614d70210e28716ccaa7cd4ddb79");
	 * DescifradorParalelo h3 = new DescifradorParalelo("c", 4,
	 * "b221d9dbb083a7f33428d7c2a3c3198ae925614d70210e28716ccaa7cd4ddb79");
	 * DescifradorParalelo h4 = new DescifradorParalelo("d", 4,
	 * "b221d9dbb083a7f33428d7c2a3c3198ae925614d70210e28716ccaa7cd4ddb79");
	 * DescifradorParalelo h5 = new DescifradorParalelo("d", 4,
	 * "b221d9dbb083a7f33428d7c2a3c3198ae925614d70210e28716ccaa7cd4ddb79");
	 * 
	 * Thread t1 = new Thread(h1); Thread t2 = new Thread(h2); Thread t3 = new
	 * Thread(h3); Thread t4 = new Thread(h4); Thread t5 = new Thread(h5);
	 * 
	 * 
	 * t1.start(); t2.start(); t3.start(); t4.start(); t5.start();
	 * 
	 * 
	 * try { t1.join(); t2.join(); t3.join(); t4.join(); t5.join(); } catch
	 * (InterruptedException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); }
	 * 
	 * }
	 */

	public static void poolHilos() {

	}

	public static void main(String[] args) {

		Instant ahora = Instant.now();

		AtomicBoolean encontrado = new AtomicBoolean(false);

		ExecutorService Executor = Executors.newFixedThreadPool(26);
		String hash = "b221d9dbb083a7f33428d7c2a3c3198ae925614d70210e28716ccaa7cd4ddb79";

		for (char letra = 'a'; letra <= 'z'; letra++) {
			DescifradorParalelo p = new DescifradorParalelo(String.valueOf(letra), 4, hash, encontrado, Executor);
			Executor.submit(p);
		}

	
		try {
			// Esperar hasta que todas las tareas finalicen o se agote el tiempo (timeout)
			if (!Executor.awaitTermination(60, TimeUnit.SECONDS)) { // Asegúrate de que TimeUnit no es null
				Executor.shutdownNow(); // Si excede el tiempo de espera, forzar el cierre
			}
		} catch (InterruptedException e) {
			Executor.shutdownNow(); // Si ocurre una interrupción, forzar el cierre
			e.printStackTrace();
		}

		Instant fin = Instant.now();
		
		Duration duracion = Duration.between(ahora, fin);
		
		System.out.println("El programa ha encontrado la palabra en: " + duracion.toMillis() 
				+ " milisegundos");
	}

}
