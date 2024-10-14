package EjerciciosHilos_DanielBaldazoSánchez;

public class MainEjercicio0 {

	public static void main(String[] args) {
		
		CocheRunnable c1 = new CocheRunnable("Audi", 1000, 5);
		CocheRunnable c2 = new CocheRunnable("Suzuki", 100, 3);
		CocheRunnable c3 = new CocheRunnable("Renault", 2000, 6);
		CocheRunnable c4 = new CocheRunnable("Seat", 300, 8);
		
		new Thread(c1).start();
		new Thread(c2).start();
		new Thread(c3).start();
		new Thread(c4).start();



	}

}
