import java.util.ArrayList;
import java.util.Scanner;

public class Main {


	static Scanner teclado = new Scanner(System.in);

	// Voy a crear ArrayList para mis Vehiculos, un array list por cada tipo
	static ArrayList<Avion> AVIONES = new ArrayList<>();
	static ArrayList<Coche> COCHES = new ArrayList<>();
	static ArrayList<Barco> BARCOS = new ArrayList<>();

	static void mostrarMenu() {

		int opcion = 0;
		do {

			System.out.println("Selecciona la acción que deseas realizar");
			System.out.println("0- SALIR");
			System.out.println("1- Mostrar el avión con mayor velocidad");
			System.out.println("2- Mostrar los coches que son electricos");

			opcion = teclado.nextInt();

			if (opcion == 1)
				avionMaxVelocidad();
			else if (opcion == 2)
				mostrarCochesElectricos();
			else if (opcion == 0)
				System.out.println("Saliste");
			else
				System.out.println("Opción no valida, repite el proceso");

		} while (opcion != 0);

	}

	public static void mostrarCochesElectricos() {

		System.out.println("Se muestran los coches electricos: ");
		for (Coche c : COCHES)
			if (c.isElectrico())
				c.cochetoString();
	}

	public static void avionMaxVelocidad() {
		Avion AvionMaxVelocidad = new Avion();

		for (int i = 0; i < AVIONES.size() - 1; i++) {
			if (AVIONES.get(i).getVelocidadMax() > AVIONES.get(i + 1).getVelocidadMax())
				AvionMaxVelocidad = new Avion(AVIONES.get(i));
		}

		AvionMaxVelocidad.AviontoString();
	}

	public static void main(String[] args) {

		// Creación de 3 coches
		Coche Suzuki = new Coche("Suzuki", "Blanco", "1", 10000, false);
		COCHES.add(Suzuki);
		Coche Toyota = new Coche("Toyota", "Gris", "2", 0, true);
		COCHES.add(Toyota);
		Coche Tesla = new Coche("Tesla", "Negro", "3", 0, true);
		COCHES.add(Tesla);

		// Creacion de 3 Barcos
		Barco Lusitania = new Barco("Lusitania", "Blanco", "4", 5000, 20, 20, "Pasajeros");
		BARCOS.add(Lusitania);
		Barco Titanic = new Barco("Titanic", "Blanco", "5", 0, 100, 50, "Pasajeros");
		BARCOS.add(Titanic);
		Barco BalleneroInlés = new Barco("Lord", "Negro", "6", 6000, 50, 30, "Pesca");
		BARCOS.add(BalleneroInlés);

		// Creacion de 3 Aviones
		Avion ChengDu_J20 = new Avion("China", "Marrón", "7", 7000, (byte) 2, 300, true);
		AVIONES.add(ChengDu_J20);
		Avion SpitFire = new Avion("RollRoyse", "Verde", "8", 3000, (byte) 2, 150, true);
		AVIONES.add(SpitFire);
		Avion Su_57 = new Avion("Rusa", "Gris", "9", 2000, (byte) 2, 270, true);
		AVIONES.add(Su_57);

		mostrarMenu();

	}

}
