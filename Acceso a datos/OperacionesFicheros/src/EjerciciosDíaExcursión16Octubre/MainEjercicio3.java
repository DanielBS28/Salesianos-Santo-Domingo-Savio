package EjerciciosDíaExcursión16Octubre;

import java.util.ArrayList;
import java.util.Scanner;

public class MainEjercicio3 {

	static ArrayList<Habitación> HABITACIONES = new ArrayList<>();
	static Scanner teclado = new Scanner(System.in);

	private static void rellenarHotel(Hotel hotel) {

		for (int i = 0; i < 70; i++)
			hotel.HABITACIONES.add(new Habitación(i + 1));

	}

	public static void mostrarMenu() {

		int opcion = 0;
				
		System.out.println("********************************************");
		System.out.println("Selecciona la acción que deseas realizar");
		System.out.println("0- Salir");
		System.out.println("1- Reservar habitación");
		System.out.println("2- Ver las habitaciones disponibles");
		System.out.println("3- Ver el nombre de los huéspedes");
		System.out.println("4- Desocupar una habitación");
		System.out.println("5- Mostrar el estado de todas las habitaciones");
		System.out.println("********************************************");

		opcion = teclado.nextInt();
		teclado.nextLine();
		
		
		do {
			
			

		} while (opcion != 0);
	}

	public static void main(String[] args) {

		Hotel HotelDaniel = new Hotel("Hotel Daniel");
		rellenarHotel(HotelDaniel);

	}

}
