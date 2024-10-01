import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static Scanner teclado = new Scanner(System.in);

	// Voy a crear ArrayList para mis Vehiculos, un array list por cada tipo
	static ArrayList<Avion> AVIONES = new ArrayList<>();
	static ArrayList<Coche> COCHES = new ArrayList<>();
	static ArrayList<Barco> BARCOS = new ArrayList<>();
	static ArrayList<Vehiculos> VEHICULOS = new ArrayList<>();

	static Avion AvionMaxVelocidad = new Avion();
	static Coche CocheMaxVelocidad = new Coche();
	static Barco BarcoMaxVelocidad = new Barco();

	static void mostrarMenu() {

		int opcion = 0;
		do {
			System.out.println("**********************************************");
			System.out.println("Selecciona la acción que deseas realizar\n");
			System.out.println("0- SALIR");
			System.out.println("1- Mostrar el vehiculo con mayor velocidad");
			System.out.println("2- Mostrar el vehiculo con mayor velocidad VERSION PRO");
			System.out.println("3- Mostrar los coches que son electricos");
			System.out.println("4- Mostrar el avion con mayor velocidad");
			System.out.println("5- Mostrar el coche con mayor velocidad");
			System.out.println("6- Mostrar el barco con mayor velocidad");
			System.out.println("7- Registrar un avion");
			System.out.println("8- Registrar un coche");
			System.out.println("9- Registrar un barco");
			System.out.println("**********************************************");

			opcion = teclado.nextInt();
			teclado.nextLine();
			if (opcion == 0)
				System.out.println("Saliste");
			else if (opcion == 1)
				vehiculoMaxVelocidad();
			else if (opcion == 2)
				vehiculosMaxVelocidadv2();
			else if (opcion == 3) {
				mostrarCochesElectricos();
			} else if (opcion == 4) {
				AvionMaxVelocidad = avionMaxVelocidad();
				System.out.println(AvionMaxVelocidad.toString());
			} else if (opcion == 5) {
				CocheMaxVelocidad = cocheMaxVelocidad();
				System.out.println(CocheMaxVelocidad.toString());
			} else if (opcion == 6) {
				BarcoMaxVelocidad = BarcoMaxVelocidad();
				System.out.println(BarcoMaxVelocidad.toString());
			} else if (opcion == 7)
				registrarAvion();
			else if (opcion == 8)
				registrarCoche();
			else if (opcion == 9)
				registrarBarco();
			else
				System.out.println("Opción no valida, repite el proceso");

		} while (opcion != 0);

	}

	public static void registrarAvion() {

		boolean combate = false;

		System.out.println("Vamos a registrar un avion");
		System.out.println("Dime la marca (String)");
		String marca = teclado.nextLine();
		System.out.println("Dime el color del avión (String)");
		String color = teclado.nextLine();
		System.out.println("Dime el numero de bastidor (String)");
		String bastidor = teclado.nextLine();
		System.out.println("Dime el numero de kilometros recorridos (int)");
		int kilometros = teclado.nextInt();
		teclado.nextLine();
		System.out.println("Dime la velocidad máxima del vehículo (double)");
		double velocidadMax = teclado.nextDouble();
		teclado.nextLine();
		System.out.println("Dime la cantidad de motores (byte)");
		byte motores = teclado.nextByte();
		teclado.nextLine();
		System.out.println("Dime si el avion es de combate (String) introduce: si o no");
		String esCombate = teclado.nextLine();
		esCombate = esCombate.toLowerCase();
		if (esCombate.equals("si"))
			combate = true;

		Avion AvionNuevo = new Avion(marca, color, bastidor, kilometros, velocidadMax, motores, combate);
		AVIONES.add(AvionNuevo);
		VEHICULOS.add(AvionNuevo);

	}

	public static void registrarCoche() {

		boolean electrico = false;
		boolean antiguo = true;

		System.out.println("Vamos a registrar un Coche");
		System.out.println("Dime la marca (String)");
		String marca = teclado.nextLine();
		System.out.println("Dime el color (String)");
		String color = teclado.nextLine();
		System.out.println("Dime el numero de bastidor (String)");
		String bastidor = teclado.nextLine();
		System.out.println("Dime el numero de kilometros recorridos (int)");
		int kilometros = teclado.nextInt();
		teclado.nextLine();
		System.out.println("Dime la velocidad máxima del vehículo (double)");
		double velocidadMax = teclado.nextDouble();
		teclado.nextLine();
		System.out.println("Dime si el coche es electrico (String) introduce: si o no");
		String comparador = teclado.nextLine();
		comparador = comparador.toLowerCase();
		if (comparador.equals("si"))
			electrico = true;
		System.out.println("Dime si el avion el coche es antiguo (String) introduce: si o no");
		comparador = teclado.nextLine();
		comparador = comparador.toLowerCase();
		if (comparador.equals("si"))
			antiguo = false;

		Coche CocheNuevo = new Coche(marca, color, bastidor, kilometros, velocidadMax, electrico, antiguo);
		COCHES.add(CocheNuevo);
		VEHICULOS.add(CocheNuevo);

	}

	public static void registrarBarco() {

		
		System.out.println("Vamos a registrar un Barco");
		System.out.println("Dime la marca (String)");
		String marca = teclado.nextLine();
		System.out.println("Dime el color (String)");
		String color = teclado.nextLine();
		System.out.println("Dime el numero de bastidor (String)");
		String bastidor = teclado.nextLine();
		System.out.println("Dime el numero de kilometros recorridos (int)");
		int kilometros = teclado.nextInt();
		teclado.nextLine();
		System.out.println("Dime la velocidad máxima del vehículo (double)");
		double velocidadMax = teclado.nextDouble();
		teclado.nextLine();
		System.out.println("Dime la medida de la eslora(int)");
		int eslora = teclado.nextInt();
		System.out.println("Dime la medida del calado (int)");
		int calado = teclado.nextInt();
		teclado.nextLine();
		System.out.println("Dime el tipo de barco (String) pesca, pasajeros o vela");
		String tipo = teclado.nextLine();
		

		Barco BarcoNuevo = new Barco(marca, color, bastidor, kilometros, velocidadMax, eslora, calado, tipo);
		BARCOS.add(BarcoNuevo);
		VEHICULOS.add(BarcoNuevo);


	}

	private static void vehiculosMaxVelocidadv2() {

		VEHICULOS.sort(null);
		System.out.println(VEHICULOS);
		System.out.println("El vehichulo con mayor velocidad es: " + VEHICULOS.getLast());

	}

	public static void mostrarCochesElectricos() {

		System.out.println("Se muestran los coches electricos: ");
		for (Coche c : COCHES)
			if (c.isElectrico())
				c.toString();
	}

	public static Avion avionMaxVelocidad() {
		Avion AvionMaxVelocidad = new Avion(AVIONES.get(0));

		for (int i = 0; i < AVIONES.size(); i++) {
			if (AVIONES.get(i).getVelocidadMax() > AvionMaxVelocidad.getVelocidadMax())
				AvionMaxVelocidad = AVIONES.get(i);
		}

		return AvionMaxVelocidad;

	}

	public static Coche cocheMaxVelocidad() {

		Coche CocheMaxVelocidad = new Coche(COCHES.get(0));

		for (int i = 0; i < COCHES.size(); i++) {
			if (COCHES.get(i).getVelocidadMax() > CocheMaxVelocidad.getVelocidadMax())
				CocheMaxVelocidad = COCHES.get(i);
		}

		return CocheMaxVelocidad;

	}

	public static Barco BarcoMaxVelocidad() {

		Barco BarcoMaxVelocidad = new Barco(BARCOS.get(0));

		for (int i = 0; i < BARCOS.size(); i++) {
			if (BARCOS.get(i).getVelocidadMax() > BarcoMaxVelocidad.getVelocidadMax())
				BarcoMaxVelocidad = BARCOS.get(i);
		}

		return BarcoMaxVelocidad;

	}

	public static void vehiculoMaxVelocidad() {

		ArrayList<Vehiculos> VEHICULOS = new ArrayList<>();
		Avion AvionMaxVelocidad = avionMaxVelocidad();
		VEHICULOS.add(AvionMaxVelocidad);
		Coche CocheMaxVelocidad = cocheMaxVelocidad();
		VEHICULOS.add(CocheMaxVelocidad);
		Barco BarcoMaxVelocidad = BarcoMaxVelocidad();
		VEHICULOS.add(BarcoMaxVelocidad);

		Vehiculos VehiculoMax = VEHICULOS.get(0);

		for (int i = 0; i < VEHICULOS.size(); i++) {
			if (VEHICULOS.get(i).getVelocidadMax() > VehiculoMax.getVelocidadMax())
				VehiculoMax = VEHICULOS.get(i);
		}

		System.out.println(VehiculoMax.toString());
	}

	public static void main(String[] args) {

		// Creación de 3 coches
		Coche Suzuki = new Coche("Suzuki", "Blanco", "1", 10000, 180, false, false);
		COCHES.add(Suzuki);
		VEHICULOS.add(Suzuki);
		Coche Toyota = new Coche("Toyota", "Gris", "2", 0, 240, true, false);
		COCHES.add(Toyota);
		VEHICULOS.add(Toyota);
		Coche Tesla = new Coche("Tesla", "Negro", "3", 0, 270, true, false);
		COCHES.add(Tesla);
		VEHICULOS.add(Tesla);

		// Creacion de 3 Barcos
		Barco Lusitania = new Barco("Lusitania", "Blanco", "4", 5000, 100, 20, 20, "Pasajeros");
		BARCOS.add(Lusitania);
		VEHICULOS.add(Lusitania);
		Barco Titanic = new Barco("Titanic", "Blanco", "5", 0, 70, 100, 50, "Pasajeros");
		BARCOS.add(Titanic);
		VEHICULOS.add(Titanic);
		Barco BalleneroInglés = new Barco("Lord", "Negro", "6", 6000, 45, 50, 30, "Pesca");
		BARCOS.add(BalleneroInglés);
		VEHICULOS.add(BalleneroInglés);

		// Creacion de 3 Aviones
		Avion ChengDu_J20 = new Avion("China", "Marrón", "7", 7000, 300, (byte) 2, true);
		AVIONES.add(ChengDu_J20);
		VEHICULOS.add(ChengDu_J20);
		Avion SpitFire = new Avion("RollRoyse", "Verde", "8", 3000, 150, (byte) 2, true);
		AVIONES.add(SpitFire);
		VEHICULOS.add(SpitFire);
		Avion Su_57 = new Avion("Rusa", "Gris", "9", 2000, 270, (byte) 2, true);
		AVIONES.add(Su_57);
		VEHICULOS.add(Su_57);

		mostrarMenu();

	}

}
