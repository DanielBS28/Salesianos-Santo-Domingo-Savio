package EjercicioBeaLibros.OperacionesFicheros.src.EjercicioDos;

import java.io.*;
import java.util.List;

public class Main {
	private static void EscribirFichero(String nombreFichero,Libreria libreria) {
		try(ObjectOutputStream oos= new ObjectOutputStream(new FileOutputStream(new File(nombreFichero)))){
			oos.writeObject(libreria);
			System.out.println("He escrito todos los libros");
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	private static Libreria LeerFichero(String nombreFichero) {
		Libreria l = null;
		try(ObjectInputStream ois= new ObjectInputStream(new FileInputStream(new File(nombreFichero)))){
			l=(Libreria)ois.readObject();
		}
		catch(ClassNotFoundException e) {
			System.out.println("No hemos podido recuperar el objecto");
			e.printStackTrace();
		}
		catch(IOException e) {
			System.out.println("Error en la lectura");
			e.printStackTrace();
		}
		
		return l;
	}
	public static void main(String[] args) {
		String nombreFichero = "Libros.bin";
		Libreria libreria = new Libreria();
		Libreria aux = new Libreria();
		
		libreria.insertarLibro("Harry Potter", "JK Rowling", 21.00);
		libreria.insertarLibro("El Quijote", "Miguel de Cervantes", 17.10);
		
		EscribirFichero(nombreFichero,libreria);
		aux= LeerFichero(nombreFichero);
		aux.ordenarLibrosPorPrecio();
		System.out.println("Listo los libros leidos ordenados del fichero");
		aux.listarLibros();
		List<Libro> p =aux.filtrarLibrosPorPrecio(17.00, 17.20);
		System.out.println("Listo los libros filtrados");
		for(Libro l:p) {
			System.out.println(l);
		}
		
	}

}
