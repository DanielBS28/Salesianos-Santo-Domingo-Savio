package ejercicio2;

public class Jugador {
	
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
