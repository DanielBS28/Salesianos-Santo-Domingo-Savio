package FicherosAccesoAleatorio;

import java.io.*;

import EjerciciosBásicos.ListarFicherosRecursivo;

public class MainEstudiante {

	public static void EscribirFichero(RandomAccessFile raf, int id, String nombre, double nota) throws IOException {

		raf.writeInt(id);
		raf.writeUTF(nombre);
		raf.writeDouble(nota);

	}

	public static Estudiante LeerEstudiantesFicheroAleatorio(RandomAccessFile raf) throws IOException {

		Estudiante e = new Estudiante(raf.readInt(), raf.readUTF(), raf.readDouble());

		return e;
	}

	public static void anadirEstudiante(String nombreFichero, int id, String nombre, double nota) {

		try (RandomAccessFile raf = new RandomAccessFile(nombreFichero, "rw")) {

			raf.seek(raf.length());
			EscribirFichero(raf, id, nombre, nota);

		} catch (IOException e) {
			System.out.println("Error: al abrir fichero para escritura");
			e.printStackTrace();
		}
	}

	public static void ListarEstudiantes(String nombreFichero) {
		try (RandomAccessFile raf = new RandomAccessFile(nombreFichero, "r")) {

			while (raf.getFilePointer() < raf.length()) {
				Estudiante estudiante = LeerEstudiantesFicheroAleatorio(raf);
				System.out.println(estudiante);
			}

		} catch (IOException e) {
			System.out.println("Error: al abrir fichero para escritura");
			e.printStackTrace();
		}

	}

	public static Estudiante buscarEtudianteporID(String nombreFichero, int id) {
		try (RandomAccessFile raf = new RandomAccessFile(nombreFichero, "r")) {

			while (raf.getFilePointer() < raf.length()) {
				Estudiante estudiante = LeerEstudiantesFicheroAleatorio(raf);
				if (estudiante.getId() == id)
					return estudiante;
			}

		} catch (IOException e) {
			System.out.println("Error: al abrir fichero para escritura");
			e.printStackTrace();
		}
		return null;

	}

	public static void main(String[] args) {
		
		String nombreFichero = "Estudiante.dat";
		anadirEstudiante(nombreFichero, 1, "Dionisio", 10);
		anadirEstudiante(nombreFichero, 2, "Clotilde", 5);
		anadirEstudiante(nombreFichero, 3, "Teodora", 7);
		anadirEstudiante(nombreFichero, 4, "Eustaquio", 8);
		
		ListarEstudiantes(nombreFichero);
		
		Estudiante e = buscarEtudianteporID(nombreFichero, 2);
		
		System.out.println(e != null ? "Se ha encontrado el estudiante " + e : "No se ha encontrado el estudiante con ese ID");

	}

}
