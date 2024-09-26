package Fichero;

import java.io.*;

public class Principal {

	public static void cambiarPermisos(File fichero) {
		fichero.setReadable(false);
		fichero.setWritable(false);
		fichero.setExecutable(false);
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
		String nombreDirectorio = ".\\datos\\";
		File fichero = new File(nombreFichero);
		
		File directorio = new File(nombreDirectorio+nombreFichero);
		
		// if(!directorio.exists()) {
			
		// if(directorio.mkdir()) {
			
		try {
			// Crear fisicamente el fichero
			if (!fichero.exists()) {
				if (fichero.createNewFile())
					System.out.println("Fichero Creado");
				else
					System.out.println("Fichero no ha sido creado");
			} else
				System.out.println("El fichero ya existe");
			
			verPermisos(fichero);
			cambiarPermisos(fichero);
			verPermisos(fichero);
			
			fichero.delete();

		} catch (IOException e) {
			e.printStackTrace();
		}
		/*
		}//
		else
			
		} // Si el directorio no existe
		else 
		*/
			

	}

}
