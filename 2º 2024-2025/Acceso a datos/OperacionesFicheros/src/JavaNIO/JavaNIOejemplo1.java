package JavaNIO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class JavaNIOejemplo1 {
	
	public static void crearDirectorio(Path dir) {
		
		if(!Files.exists(dir)) {
			try {
				
				Files.createDirectory(dir);
				System.out.println("El directorio se ha creado en " + dir.toAbsolutePath()+ " mi padre es " + dir.getParent());
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else 
			System.out.println("El directorio estaba creada en: " + dir.getParent());
		
		
	}
	
	private static void escrituraArchivo(Path fichero, String texto) {
		
		//  StandardOpenOption.APPEND esto es para sobreescribir el fichero, se pone despues de texto con una , 
		try {
			Files.writeString(fichero, texto);
			System.out.println("Crea el archivo y escribe");
			
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	
	public static void leerArchivo(Path fichero) {
		
		try {
			
			String contenidoCompleto = Files.readString(fichero);
			
			System.out.println(contenidoCompleto);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void leerLineas(Path fichero) {
		
		System.out.println("Voy a leer lineas");
		String lineas = "";
		try {
			byte [] bytes = Files.readAllBytes(fichero);
			
			for(int i =0; i<bytes.length; i++) {
				if((char)bytes[i]== 'a' || (char)bytes[i]== '\n')
				lineas += Character.toString((char)bytes[i]);
			}
			System.out.println(lineas);
			
			
			// Imprimir bytes
			
			System.out.println(new String (bytes));
			
			ArrayList <String>  contenidoLeido = (ArrayList<String>) Files.readAllLines(fichero);
			
			for(String linea : contenidoLeido)
				System.out.println(linea);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void copiarArchivos(Path fichero, Path ficheroCopia) {
		
		try {
			Files.copy(fichero, ficheroCopia);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void moverArchivo(Path fichero, Path ficheroCopia) {
		
		try {
			
			Files.move(fichero, ficheroCopia);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void borrarArchivo(Path fichero) {
		
		try {
			Files.delete(fichero);
			System.out.println("Se ha borrado el fichero");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		
		Path directorio = Paths.get("src/JavaNIO/Carpeta");
		Path directorioCopia = Paths.get("src/JavaNIO/Carpeta2");

		Path fichero = directorio.resolve("FicheroJavaNIO.txt");
		
		// Esta copia el archivo
		Path ficheroCopia = directorio.resolve("FicheroJavaNIOCOPIA.txt");
		
		//copia el archivo a directorio copia2
		Path ficheroCopia2 = directorioCopia.resolve("FicheroJavaNIOCOPIA.txt");

				
		String texto = "Hola, me llamo Daniel\nHola -->\nHola2\n";
		
		crearDirectorio(directorio);
		escrituraArchivo(fichero, texto);
		
		leerArchivo(fichero);
		leerLineas(fichero);
		
		copiarArchivos(fichero, ficheroCopia);
		crearDirectorio(directorioCopia);
		
		//copia el archivo a directorio copia2

		moverArchivo(ficheroCopia, ficheroCopia2);
		
		/*
		try {
			
			//Crear directorio 
			
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		*/
	}

}
