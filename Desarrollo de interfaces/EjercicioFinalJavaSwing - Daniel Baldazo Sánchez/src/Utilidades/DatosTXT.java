package Utilidades;

import java.util.ArrayList;

import ClasesArchivos.Estadísticas;
import ClasesArchivos.Usuario;

public class DatosTXT {
	
	/*
	 * Esta clase se encarga de los getters y los setters de cada ArrayList
	 * en cualquier parte del programa se utiliza esta clase para obtener los datos de
	 * los arrays. También actualiza los datos de los arraylist.
	 */

	public static ArrayList<Usuario> USUARIOS = new ArrayList<>();
	public static ArrayList<String> TEXTOS = new ArrayList<>();
	public static ArrayList<Estadísticas> ESTADÍSTICAS = new ArrayList<>();

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
		
		//Esta función se encarga de actualizar los datos de las estádisticas de un usuario en la lección
		//fácil si se ha superado su récord
		Estadísticas EstadísticaSeleccionada = obtenerEstadística(user);
		EstadísticaSeleccionada.setSegundosRestantesF(segundosRestantes);
		EstadísticaSeleccionada.setLetralDelTextoF(letrasDelTexto);
		EstadísticaSeleccionada.setPPMF(pPMinuto);
		EstadísticaSeleccionada.setAciertosTeclasF(aciertosTeclas);
		EstadísticaSeleccionada.setErroresTeclasF(erroresTeclas);
		EstadísticaSeleccionada.setTiempoTotalF(tiempoTotal);
		EstadísticaSeleccionada.setNotaFácil(nota);


	}

	public static Estadísticas obtenerEstadística(Usuario user) {

		/*
		 * Esta función se encarga de devolver la estadísticas del usuario
		 * que le hemos pasado por parámetro
		 */
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
		
		//Esta función se encarga de actualizar los datos de las estádisticas de un usuario en la lección
		//difícil si se ha superado su récord
		
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
