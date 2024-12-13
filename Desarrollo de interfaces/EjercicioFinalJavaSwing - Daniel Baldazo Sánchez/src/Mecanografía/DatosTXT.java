package Mecanografía;

import java.util.ArrayList;

public class DatosTXT {
	
	
	static ArrayList <Usuario> USUARIOS = new ArrayList<>();
	static ArrayList <String> TEXTOS = new ArrayList<>();
	static ArrayList <Estadísticas> ESTADÍSTICAS = new ArrayList<>();
	
	
	public static ArrayList<String> getTEXTOS() {
		return TEXTOS;
	}

	public static void setTEXTOS(ArrayList<String> tEXTOS) {
		TEXTOS = tEXTOS;
	}

	public static void cargarUsuarios() {
		USUARIOS = Archivos.leerUsuarios();
	}
	
	public static void cargarTextos() {
		TEXTOS = Archivos.leerTextos();
	}

	public static ArrayList<Usuario> getUSUARIOS() {
		return USUARIOS;
	}

	public static void setUSUARIOS(ArrayList<Usuario> uSUARIOS) {
		USUARIOS = uSUARIOS;
	}

	public static ArrayList<Estadísticas> getESTADÍSTICAS() {
		return ESTADÍSTICAS;
	}

	public static void setESTADÍSTICAS(ArrayList<Estadísticas> eSTADÍSTICAS) {
		ESTADÍSTICAS = eSTADÍSTICAS;
	}

}
