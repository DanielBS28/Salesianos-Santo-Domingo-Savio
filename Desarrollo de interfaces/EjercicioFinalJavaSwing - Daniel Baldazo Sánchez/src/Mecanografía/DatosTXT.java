package Mecanografía;

import java.util.ArrayList;

public class DatosTXT {
	
	
	static ArrayList <Usuario> USUARIOS = new ArrayList<>();
	static ArrayList <Estadísticas> ESTADÍSTICAS = new ArrayList<>();
	
	public static void cargarUsuarios() {
		USUARIOS = Archivos.leerUsuarios();
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
