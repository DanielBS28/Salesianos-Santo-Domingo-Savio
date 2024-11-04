package EjerciciosHilos_DanielBaldazoSánchez;

public class RobotConstructor extends Robot implements Runnable{

	static int estructuras = 0;
	int estructurasRobot = 0;

	public RobotConstructor(String nombre, int tiempoOperacion) {
		super(nombre, tiempoOperacion);
		// TODO Auto-generated constructor stub
	}


	@Override
	public synchronized void operar() {
		
		if (estructuras % 2 == 0) {
			for (int i = 0; i < 3; i++) {
				System.out.println("El robot " + nombre + " ha construido una estructura");
				construir();
				descansar();
				estructurasRobot++;
			}
		} else {
			System.out.println("El robot " + nombre + " ha destruido una estructura");

			destruir();
			descansar();
		}

	}

	public synchronized static void construir() {
		estructuras++;
	}

	public synchronized static void destruir() {
		estructuras--;
	}

	public static void descansar() {

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			return;
		}
	}

	@Override
	public void run() {

		operar();
	}
	
	public String getNombre() {
		
		return nombre;
	}

}
