package ejercicioerick;

public class ejercicio1 {

	public static void main(String[] args) {
		int totalalumnos = 31;
		int bachillerato = 15;
		int mayores20 = 6;
		int mayores20bach = 4;

		// cuantos tienen menos de 20 y no tienen bachillerato

		int menosde20 = (totalalumnos - mayores20);
		int bachilleratot = (bachillerato - mayores20bach);


		System.out.println(menosde20);
		System.out.println(bachilleratot);
	

		System.out.println(menosde20 - bachilleratot);

	}

}
