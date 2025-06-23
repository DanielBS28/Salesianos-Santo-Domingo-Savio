package ejercicio1;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class Descifrador {



	public static void main(String[] args) {

		Instant ahora = Instant.now();

		AtomicBoolean encontrado = new AtomicBoolean(false);
		
		//ExecutorService de 26 hilos
		ExecutorService Executor = Executors.newFixedThreadPool(26);
		String hash = "b221d9dbb083a7f33428d7c2a3c3198ae925614d70210e28716ccaa7cd4ddb79";
		
		//Generamos 26 hilos
		for (char letra = 'a'; letra <= 'z'; letra++) {
			DescifradorParalelo p = new DescifradorParalelo(String.valueOf(letra), 4, hash, encontrado, Executor);
			Executor.submit(p);
		}

	
		try {
			// Esperar hasta que todas las tareas finalicen o se agote el tiempo (timeout)
			if (!Executor.awaitTermination(60, TimeUnit.SECONDS)) { // El time unit no puede ser nulo
				Executor.shutdownNow(); // Si nos pasamos del tiempo, forzar el cierre.
			}
		} catch (InterruptedException e) {
			Executor.shutdownNow(); // Si ocurre una interrupción, forzar el cierre
			e.printStackTrace();
		}

		Instant fin = Instant.now();
		// Comprobamos cuanto ha tardado el programa en encontrar la palabra
		Duration duracion = Duration.between(ahora, fin);
		
		System.out.println("El programa ha encontrado la palabra en: " + duracion.toMillis() 
				+ " milisegundos");
	}

}
