package EjerciciosHilos_DanielBaldazoSánchez;

public class RobotExploradorEJ3 extends Robot implements Runnable{

	public RobotExploradorEJ3(String nombre, int tiempoOperacion) {
		super(nombre, tiempoOperacion);
	}

	@Override
	public void operar() {
		System.out.println("El robot " + nombre + " ha comenzado a explorar su área asignada");
		try {
			Thread.sleep(tiempoOperacion * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("El robot " + nombre + " ha terminado su área asignada");

	}

	@Override
	public void run() {
		operar();
		
	}

}
