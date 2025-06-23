package EjerciciosDíaExcursión16Octubre;

import java.time.LocalDate;

public class Habitación{
	
	private int numero;
	private boolean libre = true;
	private LocalDate fechaEntrada;
	private int diasReservados;
	private String Huesped;
	
	public Habitación(int numero) {
		
		this.numero = numero;
		
	}

	@Override
	public String toString() {
		return "Habitación [numero=" + numero + ", libre=" + libre + ", fechaEntrada=" + fechaEntrada
				+ ", diasReservados=" + diasReservados + ", Huesped=" + Huesped + "]";
	}
	
	
	
	

}
