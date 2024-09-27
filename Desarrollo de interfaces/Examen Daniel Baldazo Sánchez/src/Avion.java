
public class Avion extends Vehiculos{

	
	private byte motores;
	private double velocidadMax;
	private boolean combate;
	
	public Avion(String marca, String color, String numeroBastidor, int kilometros, byte motores, double velocidadMax,
			boolean combate) {
		super(marca, color, numeroBastidor, kilometros);
		this.motores = motores;
		this.velocidadMax = velocidadMax;
		this.combate = combate;
	}

	public Avion(String marca, String color, String numeroBastidor, int kilometros, boolean combate) {
		super(marca, color, numeroBastidor, kilometros);
		this.combate = combate;
	}

	public Avion(Avion avion) {
		
		super(avion.getMarca(), avion.getColor(), avion.getNumeroBastidor(), avion.getKilometros());
		this.motores = avion.getMotores();
		this.velocidadMax = avion.getVelocidadMax();
		this.combate = avion.isCombate();
	}
	
	public Avion() {
		super();
	}

	public byte getMotores() {
		return motores;
	}

	public void setMotores(byte motores) {
		this.motores = motores;
	}

	public double getVelocidadMax() {
		return velocidadMax;
	}

	public void setVelocidadMax(double velocidadMax) {
		this.velocidadMax = velocidadMax;
	}

	public boolean isCombate() {
		return combate;
	}

	public void setCombate(boolean combate) {
		this.combate = combate;
	}


	public void AviontoString() {
		System.out.print(VehiculotoString());
		System.out.println("Avion [motores=" + motores + ", velocidadMax=" + velocidadMax + ", combate=" + combate + "]");
	}
	
	
	
	
	
	
	
}


