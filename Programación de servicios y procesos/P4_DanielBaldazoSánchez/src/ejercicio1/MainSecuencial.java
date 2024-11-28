package ejercicio1;

import java.time.Duration;
import java.time.Instant;

public class MainSecuencial {

	public static void main(String[] args) {
		Instant ahora = Instant.now();

		DescifradorSecuecial.recursiva("", 5, "f9744197f797d034670a6c096410f6f5a4aba30e733430ba91becfd211816b7e");
		Instant fin = Instant.now();
		// Comprobamos cuanto ha tardado el programa en encontrar la palabra
		Duration duracion = Duration.between(ahora, fin);
		
		System.out.println("El programa ha encontrado la palabra en: " + duracion.toMillis() 
				+ " milisegundos");
	}

}
