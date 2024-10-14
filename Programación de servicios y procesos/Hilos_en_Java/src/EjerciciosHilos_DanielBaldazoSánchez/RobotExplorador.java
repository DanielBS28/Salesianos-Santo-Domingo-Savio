package EjerciciosHilos_DanielBaldazoSánchez;

public class RobotExplorador extends Thread{
	
	private String nombre;
	private int tiempoExploracion;
	
	public RobotExplorador(String nombre, int tiempoExploracion) {
		super();
		this.nombre = nombre;
		this.tiempoExploracion = tiempoExploracion;
	}
	
	@Override
	public void run(){
		explorar();
	}

	private void explorar() {
		
		System.out.println("El robot " +nombre+" comenzado a explorar su area asignada");
		try {
			Thread.sleep(tiempoExploracion * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("El robot " +nombre+ " ha terminado de explorar su área");
	}
	
	

}
