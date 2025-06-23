package ejercicioaritmetica;

public class ejercicio {

	public static void main(String[] args) {
		int numA = 2;
		int numB = 67;

		int Aux = numA;

		numA = numB;
		numB = Aux;

		System.out.println(numA);
		System.out.println(numB);
	}
}
