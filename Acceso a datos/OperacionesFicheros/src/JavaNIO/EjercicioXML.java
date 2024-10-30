package JavaNIO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class EjercicioXML {

	public static void crearDirectorio(Path directorio) {

		if (!Files.exists(directorio)) {
			try {
				Files.createDirectory(directorio);
				System.out.println("Se ha creado el directorio");
			} catch (IOException e) {
				e.getStackTrace();
			}
		} else
			System.out.println("El directorio ya existe");

	}

	public static void leerArchivo() {
		
	}

	public static void main(String[] args) {

		Path directorio = Paths.get("src/JavaNIO/Clientes");
		Path fichero = Paths.get("src/JavaNIO/XML.txt");

		crearDirectorio(directorio);

	}

}
