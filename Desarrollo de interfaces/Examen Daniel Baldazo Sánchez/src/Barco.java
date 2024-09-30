
public class Barco extends Vehiculos{

	private int eslora;
	private int calado;
	private String tipo;
	
	

	public Barco(String marca, String color, String numeroBastidor, int kilometros, double velocidadMax, int eslora,
			int calado, String tipo) {
		super(marca, color, numeroBastidor, kilometros, velocidadMax);
		this.eslora = eslora;
		this.calado = calado;
		this.tipo = tipo;
	}
	
	public Barco(Barco barco) {
		super(barco.getMarca(), barco.getColor(), barco.getNumeroBastidor(), barco.getKilometros(), barco.getVelocidadMax());
		this.eslora = barco.getEslora();
		this.calado = barco.getCalado();
		this.tipo = barco.getTipo();
	}

	public Barco() {
	}

	public int getEslora() {
		return eslora;
	}

	public void setEslora(int eslora) {
		this.eslora = eslora;
	}

	public int getCalado() {
		return calado;
	}

	public void setCalado(int calado) {
		this.calado = calado;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return  super.toString() + ", eslora=" + eslora + ", calado=" + calado + ", tipo=" + tipo + "]";
	}
	
	
	
	
}
