package EjerciciosHilos_DanielBaldazoSánchez;

public class MainEjercicio1 {

	public static void main(String[] args) {
		
		RobotExplorador Wall_E = new RobotExplorador("Wall-E", 6);
		RobotExplorador Explorer = new RobotExplorador("Explorer", 5);
		RobotExplorador Rober = new RobotExplorador("Rober", 7);
		RobotExplorador Cheng_DU = new RobotExplorador("Cheng-DU", 10);
		
		new Thread(Wall_E).start();
		new Thread(Explorer).start();
		new Thread(Rober).start();
		new Thread(Cheng_DU).start();

	}

}
