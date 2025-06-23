package ejercicio2;

import java.util.Random;

public class Jugador {
	
	static Random r = new Random();
	private static String caracter = "T";
	private int x = -1;
	private int y = -1;
	
	static int IDJugador = 1;
	private String nombre;
	private int puntos = 0;
	private int IdJugadorPartida = 0;
	
	public Jugador(String nombre) {
		
		IdJugadorPartida = IDJugador++;
		this.nombre = nombre;
	}

	public static int getIDJugador() {
		return IDJugador;
	}

	public static void setIDJugador(int iDJugador) {
		IDJugador = iDJugador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public int getIdJugadorPartida() {
		return IdJugadorPartida;
	}

	public void setIdJugadorPartida(int idJugadorPartida) {
		IdJugadorPartida = idJugadorPartida;
	}
	
	

}
