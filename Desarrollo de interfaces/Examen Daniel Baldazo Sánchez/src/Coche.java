
public class Coche extends Vehiculos{

	protected boolean electrico;
	private boolean antiguo;
	
	public Coche(String marca, String color, String numeroBastidor, int kilometros, boolean electrico) {
		super(marca, color, numeroBastidor, kilometros);
		this.electrico = electrico;
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


	public void cochetoString() {
		
		System.out.print(VehiculotoString());
		System.out.println( " electrico=" + electrico + ", antiguo=" + antiguo + "]");
	}
	
	
	
	
}
