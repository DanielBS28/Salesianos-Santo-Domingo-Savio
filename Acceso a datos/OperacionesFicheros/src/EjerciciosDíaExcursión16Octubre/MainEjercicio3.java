package EjerciciosDíaExcursión16Octubre;

import java.util.ArrayList;

public class MainEjercicio3 {
	
	static ArrayList <Habitación> HABITACIONES = new ArrayList<>();
	
	private static void rellenarHotel(Hotel hotel) {
		
		for(int i = 0; i< 70; i++) {
			
			hotel.HABITACIONES.add(new Habitación(i+1));
			System.out.println(hotel.HABITACIONES.get(i));
		}
		
		
	}

	

	public static void main(String[] args) {
		
		Hotel HotelDaniel = new Hotel("Hotel");
		rellenarHotel(HotelDaniel);

	}



	
}
