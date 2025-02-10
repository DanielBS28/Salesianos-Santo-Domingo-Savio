package Mecanografía;

import java.util.ArrayList;

public class DatosTXT {

	static ArrayList<Usuario> USUARIOS = new ArrayList<>();
	static ArrayList<String> TEXTOS = new ArrayList<>();
	static ArrayList<Estadísticas> ESTADÍSTICAS = new ArrayList<>();

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

	public static void cargarEstadísticas() {
		ESTADÍSTICAS = Archivos.leerEstadísticas();
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

	public static void actualizarEstadísticasFácil(int segundosRestantes, int teclasPulsadas, int letrasDelTexto,
			int pPMinuto, int aciertosTeclas, int erroresTeclas, int tiempoTotal, char dificultad, Usuario user, double nota) {

		Estadísticas EstadísticaSeleccionada = obtenerEstadística(user);
		EstadísticaSeleccionada.setSegundosRestantesF(segundosRestantes);
		EstadísticaSeleccionada.setLetralDelTextoF(letrasDelTexto);
		EstadísticaSeleccionada.setPPMF(pPMinuto);
		EstadísticaSeleccionada.setAciertosTeclasF(aciertosTeclas);
		EstadísticaSeleccionada.setErroresTeclasF(erroresTeclas);
		EstadísticaSeleccionada.setTiempoTotalF(tiempoTotal);
		EstadísticaSeleccionada.setNotaFácil(nota);


	}

	private static Estadísticas obtenerEstadística(Usuario user) {

		Estadísticas EstadísticaSeleccionada = null;

		for (int i = 0; i < ESTADÍSTICAS.size(); i++) {
			if (user.getAlias().equals(ESTADÍSTICAS.get(i).getId())) 
				return ESTADÍSTICAS.get(i);

		}
		return EstadísticaSeleccionada;
	}

	public static void actualizarEstadísticasDifícil(int segundosRestantes, int teclasPulsadas, int letrasDelTexto,
			int pPMinuto, int aciertosTeclas, int erroresTeclas, int tiempoTotal, char dificultad, Usuario user,
			double nota) {
		
		Estadísticas EstadísticaSeleccionada = obtenerEstadística(user);
		EstadísticaSeleccionada.setSegundosRestantesD(segundosRestantes);
		EstadísticaSeleccionada.setLetralDelTextoD(letrasDelTexto);
		EstadísticaSeleccionada.setPPMD(pPMinuto);
		EstadísticaSeleccionada.setAciertosTeclasD(aciertosTeclas);
		EstadísticaSeleccionada.setErroresTeclasD(erroresTeclas);
		EstadísticaSeleccionada.setTiempoTotalD(tiempoTotal);
		EstadísticaSeleccionada.setNotaDifícil(nota);

		
	}

}
