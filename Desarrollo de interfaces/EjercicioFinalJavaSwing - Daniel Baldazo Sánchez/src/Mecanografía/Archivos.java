package Mecanografía;

import java.io.File;

public class Archivos {
	
	final static String Usuarios = "src/Mecanografía/ArchivosIniciales/Usuarios.txt";
	final static String Estadísticas = "src/Mecanografía/ArchivosIniciales/Estadísticas.txt";
	final static String Textos = "src/Mecanografía/ArchivosIniciales/Textos.txt";


	public static boolean escanearArchivos() {
		
		File ArchivoUsuarios = new File(Usuarios);	
		File ArchivoEstadísticas = new File(Estadísticas);	
		File ArchivoTextos = new File(Textos);	
		
		if(ArchivoUsuarios.exists()&&ArchivoEstadísticas.exists()&&ArchivoTextos.exists())
			return true;
		else
			return false;
	} 

}
