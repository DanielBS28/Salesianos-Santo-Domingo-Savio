package ejercicio1;

import java.util.Date;

public class biblioteca3 {

	public static void main(String[] args) {
		
		// Crear nuevo usuario Registrandolo desde cero
	    Usuario usuarioDaniel = new Usuario();
	    Libro libroDaniel = new Libro("978-1-86197-876-9", "1984", "George Orwell", 1949);

	    
	    Date fechaPrestamoDaniel = new Date(); // Fecha actual
	    Préstamo prestamoDaniel = new Préstamo("p002", libroDaniel, usuarioDaniel, fechaPrestamoDaniel);
	    prestamoDaniel.realizarPrestamo();
	    
	    System.out.println("Libros prestados por el usuario antes de la devolución:");
	    for (Libro libro : usuarioDaniel.consultarPrestamos()) {
	        System.out.println(libro.informacion());
	    }
	    
	    System.out.println(usuarioDaniel.toString());
	    usuarioDaniel.actualizarInfo();
	    System.out.println(usuarioDaniel.toString());

	    


	}

}
