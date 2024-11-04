package EjerciciosHilos_DanielBaldazoSánchez;

public abstract class Robot {

	protected String nombre;
	protected int tiempoOperacion;

	public Robot(String nombre, int tiempoOperacion) {
		super();
		this.nombre = nombre;
		this.tiempoOperacion = tiempoOperacion;
	}

	public abstract void operar();

}
