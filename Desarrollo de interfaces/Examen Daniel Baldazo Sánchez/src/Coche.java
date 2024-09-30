
public class Coche extends Vehiculos{

	protected boolean electrico;
	private boolean antiguo;
	
	
	
	public Coche(String marca, String color, String numeroBastidor, int kilometros, double velocidadMax,
			boolean electrico, boolean antiguo) {
		super(marca, color, numeroBastidor, kilometros, velocidadMax);
		this.electrico = electrico;
		this.antiguo = antiguo;
	}

	public Coche(Coche coche) {
		super(coche.getMarca(), coche.getColor(), coche.NumeroBastidor, coche.getKilometros(),coche.getVelocidadMax());
		this.electrico = coche.isElectrico();
		this.antiguo = coche.isAntiguo();
	}

	public Coche() {
	}

	public boolean isElectrico() {
		return electrico;
	}

	public void setElectrico(boolean electrico) {
		this.electrico = electrico;
	}

	public boolean isAntiguo() {
		return antiguo;
	}

	public void setAntiguo(boolean antiguo) {
		this.antiguo = antiguo;
	}

	@Override
	public String toString() {
		return super.toString() +", electrico=" + electrico + ", antiguo=" + antiguo + "]";
	}


	
	
	
	
	
}
