package EjerciciosHilos_DanielBaldazoSánchez;

public class MainEjercicio1 {

	public static void main(String[] args) {
		
		RobotExploradorEJ2 Wall_E = new RobotExploradorEJ2("Wall-E", 6);
		RobotExploradorEJ2 Explorer = new RobotExploradorEJ2("Explorer", 5);
		RobotExploradorEJ2 Rober = new RobotExploradorEJ2("Rober", 7);
		RobotExploradorEJ2 Cheng_DU = new RobotExploradorEJ2("Cheng-DU", 10);
		
		new Thread(Wall_E).start();
		new Thread(Explorer).start();
		new Thread(Rober).start();
		new Thread(Cheng_DU).start();

	}

}
