
public class Vehiculos {
	
	public String Marca;
	public String Color;
	public String NumeroBastidor;
	public int Kilometros;
	private double VelocidadMax;
	protected int añofabricacion;
	
	
	
	
	public Vehiculos(String marca, String color, String numeroBastidor, int kilometros, double velocidadMax) {
		Marca = marca;
		Color = color;
		NumeroBastidor = numeroBastidor;
		Kilometros = kilometros;
		VelocidadMax = velocidadMax;
	}
	
	public Vehiculos() {
		
	}


	public String getMarca() {
		return Marca;
	}


	public void setMarca(String marca) {
		Marca = marca;
	}


	public String getColor() {
		return Color;
	}


	public void setColor(String color) {
		Color = color;
	}


	public String getNumeroBastidor() {
		return NumeroBastidor;
	}


	public void setNumeroBastidor(String numeroBastidor) {
		NumeroBastidor = numeroBastidor;
	}


	public int getKilometros() {
		return Kilometros;
	}


	public void setKilometros(int kilometros) {
		Kilometros = kilometros;
	}


	public int getAñofabricacion() {
		return añofabricacion;
	}


	public void setAñofabricacion(int añofabricacion) {
		this.añofabricacion = añofabricacion;
		
		
	}
	

	public double getVelocidadMax() {
		return VelocidadMax;
	}


	public void setVelocidadMax(double velocidadMax) {
		VelocidadMax = velocidadMax;
	}


	@Override
	public String toString() {
		return "Vehiculo: [Marca=" + Marca + ", Color=" + Color + ", NumeroBastidor=" + NumeroBastidor + ", Kilometros="
				+ Kilometros + ", VelocidadMax=" + VelocidadMax;
	}


	
	
	
	
	
	
	
	
	
	
	

}
