package examen.repasandoPOO;

public class Coche extends Vehiculo{

	private int numeroPuertas;

	public Coche(String Marca, String modelo, int anio, int numeroPuertas) {
		super(Marca, modelo, anio);
		this.numeroPuertas = numeroPuertas;
	}
	
	public Coche(String Marca, String modelo, int anio, int numeroPuertas, Persona persona) {
		super(Marca, modelo, anio, persona);
		this.numeroPuertas = numeroPuertas;
	}
	
	
	
}
