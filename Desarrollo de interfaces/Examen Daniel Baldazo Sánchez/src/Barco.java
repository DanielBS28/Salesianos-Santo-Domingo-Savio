
public class Barco extends Vehiculos{

	private int eslora;
	private int calado;
	private String tipo;
	
	public Barco(String marca, String color, String numeroBastidor, int kilometros, int eslora, int calado, String tipo) {
		super(marca, color, numeroBastidor, kilometros);
		this.eslora = eslora;
		this.calado = calado;
		this.tipo = tipo;
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
		return "Barco [eslora=" + eslora + ", calado=" + calado + ", tipo=" + tipo + "]";
	}
	
	
	
	
}
