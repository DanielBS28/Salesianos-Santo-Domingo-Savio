package Fichero;

import java.io.*;

public class ejercicio1 {

	public static void cambiarPermisos(File fichero) {
		fichero.setReadable(false);
		fichero.setWritable(false);
		fichero.setExecutable(false);
	}
	
	public static void comprobarDirectorio(File f) {
		
		if(f.isDirectory()) 
			listarFicheros(f);
		else if (f.isFile())
			System.out.println("Es un fichero no se puede recorrer");
		
	}
	
	public static void listarFicheros(File f) {
		File []ficheros = f.listFiles();
		
		for (File files : ficheros) {
			if(files.isFile())
				System.out.println(files.getName()+ " es un fichero");
			if(files.isDirectory()) 
				System.out.println(files.getName()+" es un directorio");
			
		}
	}
	
	/*public static void listarFicheros2(File f) {
		File []ficheros = f.listFiles();
		
		if(ficheros == null)
		else listarFicheros2(ficheros[0]);

	}
	 */
	public static void crearFichero(File fichero) {

		try {
			// Crear fisicamente el fichero
			if (!fichero.exists()) {
				if (fichero.createNewFile())
					System.out.println("Fichero Creado");
				else
					System.out.println("Fichero no ha sido creado");
			} else
				System.out.println("El fichero ya existe");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void verPermisos(File f) {

		String permisos = "";

		// if(f.canRead()) permisos+="r"; else permisos+="-";
		permisos += f.canRead() ? "r" : "-";

		// if(f.canWrite()) permisos+="w"; else permisos+="-";
		permisos += f.canWrite() ? "w" : "-";

		// if(f.canExecute()) permisos+="x"; else permisos+="-";
		permisos += f.canExecute() ? "x" : "-";

		// f.getName() Me da el nombre
		// f.getAbsolutePath() Me da la ruta absoluta
		System.out.println("Los permisos del archivo son: " + f.getName() + " son " + permisos);

	}

	public static void main(String[] args) {

		// Se escribe el nombre del fichero que se guarda fisicamente
		String nombreFichero = "ficheroNuevo.txt";
		String nombreDirectorio = ".\\Datos\\";
		File directorio = new File(nombreDirectorio);
		File fichero = new File(nombreDirectorio+nombreFichero);

	
		if(!directorio.exists()) {
			
			if(directorio.mkdirs()) {
				
				crearFichero(fichero);	
				/*verPermisos(fichero);
				cambiarPermisos(fichero);
				verPermisos(fichero);
				 fichero.delete();
				 */	
			}else
				System.out.println("No se ha podido crear el directorio");
		
		}else {
			
			System.out.println("El directorio existe");
			crearFichero(fichero);

		}
		
		comprobarDirectorio(directorio);
		// comprobarDirectorio(fichero);

}
}