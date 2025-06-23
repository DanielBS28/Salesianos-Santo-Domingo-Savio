package EjerciciosHilos_DanielBaldazoSánchez;

import java.util.ArrayList;

public class MainEjercicio2_2 {

	public static void main(String[] args) {

		ArrayList<RobotConstructor> ROBOTSCONSTRUCTORES = new ArrayList<>();

		RobotExploradorEJ3 re1 = new RobotExploradorEJ3("Adriel", 5);
		RobotExploradorEJ3 re2 = new RobotExploradorEJ3("Daniel", 7);
		RobotExploradorEJ3 re3 = new RobotExploradorEJ3("David", 2);
		RobotExploradorEJ3 re4 = new RobotExploradorEJ3("Germán", 3);

		RobotConstructor rc1 = new RobotConstructor("Alisón", 5);
		ROBOTSCONSTRUCTORES.add(rc1);
		RobotConstructor rc2 = new RobotConstructor("Sergio", 7);
		ROBOTSCONSTRUCTORES.add(rc2);
		RobotConstructor rc3 = new RobotConstructor("Maikel", 9);
		ROBOTSCONSTRUCTORES.add(rc3);

		new Thread(re1).start();
		new Thread(re2).start();
		new Thread(re3).start();
		new Thread(re4).start();

		new Thread(rc1).start();
		new Thread(rc2).start();
		new Thread(rc3).start();

		for (int i = 0; i < ROBOTSCONSTRUCTORES.size(); i++) {
				new Thread(ROBOTSCONSTRUCTORES.get(i)).start();
		}
		
		
		for (int i = 0; i < ROBOTSCONSTRUCTORES.size(); i++) 
			System.out.println("El Robot: " +  ROBOTSCONSTRUCTORES.get(i).getNombre() + "ha construido " + ROBOTSCONSTRUCTORES.get(i).estructurasRobot+ " estructuras.");


		System.out.println("Total de estructuras: " + RobotConstructor.estructuras);

	}

}
