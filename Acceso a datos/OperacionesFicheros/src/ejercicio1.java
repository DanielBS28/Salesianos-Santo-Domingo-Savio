import java.io.File;
import java.util.Scanner;

public class ejercicio1 {
	
	static Scanner teclado = new Scanner (System.in);
	
	
	public static void ejercicio1() {

		System.out.println("Dime el nombre del directorio que quieras (A partir de la ruta actual)");
		String directorioSolicitado = teclado.nextLine();
		File directorio = new File(".\\" + directorioSolicitado + "\\");
		comprobarDirectorio(directorio);

	}
	
	public static void comprobarDirectorio(File f) {
		if (f.isDirectory()) {
			System.out.println("El archivo que has pasado es un directorio y sus archivos son:");
			nombrarArchivos2(f);
		} else
			System.out.println("No es un directorio");
	}
	
	
	public static void nombrarArchivos(String []ficheros) {

		// File[] ficheros = directorio.listFiles();

		for (int i = 0; i < ficheros.length; i++)
			System.out.println("El nombre del archivo es: " + ficheros[i]);

	}
	
	public static void nombrarArchivos2(File directorio) {

		//File[] ficheros = directorio.list();
	if(directorio==null) {
		System.out.println("No hay nada");
	}	
	else {
		File[] ficheros = directorio.listFiles();
		for (int i = 0; i < ficheros.length; i++) {
			System.out.println("El nombre del archivo es: " + ficheros[i]);
			if(ficheros[i].isFile())
		 	{
		 		System.out.println("Es un fichero "+directorio.getName());
		 	}
			if(ficheros[i].isDirectory()) {
				System.out.println("Es un directorios "+directorio.getName());
		 		nombrarArchivos2(ficheros[i]);
		 		
		 	}
		}	 	
	
		}	 
	}

	public static void main(String[] args) {
		
		ejercicio1();

	}

}
