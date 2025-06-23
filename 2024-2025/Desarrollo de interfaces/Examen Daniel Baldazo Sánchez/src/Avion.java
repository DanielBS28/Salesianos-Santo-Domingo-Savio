
public class Avion extends Vehiculos{

	
	private byte motores;
	private boolean combate;
	
	

	public Avion(String marca, String color, String numeroBastidor, int kilometros, double velocidadMax, byte motores,
			boolean combate) {
		super(marca, color, numeroBastidor, kilometros, velocidadMax);
		this.motores = motores;
		this.combate = combate;
	}

	

	public Avion(String marca, String color, String numeroBastidor, int kilometros, double velocidadMax,
			boolean combate) {
		super(marca, color, numeroBastidor, kilometros, velocidadMax);
		this.combate = combate;
	}



	public Avion(Avion avion) {
		
		super(avion.getMarca(), avion.getColor(), avion.getNumeroBastidor(), avion.getKilometros(),avion.getVelocidadMax());
		this.motores = avion.getMotores();
		this.combate = avion.isCombate();
	}
	

	public Avion() {
		
	}



	public byte getMotores() {
		return motores;
	}

	public void setMotores(byte motores) {
		this.motores = motores;
	}


	public boolean isCombate() {
		return combate;
	}

	public void setCombate(boolean combate) {
		this.combate = combate;
	}


	@Override
	public String toString() {
		return super.toString()+", motores=" + motores + ", combate=" + combate + "]\n";
	}


	
	
	
	
	
	
	
	
}


