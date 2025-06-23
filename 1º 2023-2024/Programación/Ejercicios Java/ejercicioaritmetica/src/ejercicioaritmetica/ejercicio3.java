package ejercicioaritmetica;

public class ejercicio3 {

	public static void main(String[] args) {
		int numA = 1;
		int numB = 2;
		int numC = 3;
		
		System.out.println(numA);
		System.out.println(numB);
		System.out.println(numC);
		System.out.println();
		System.out.println("El orden al reves de las tres variables es: ");
		System.out.println();

		int Aux = numA;
		int Aux2 = 	numB;
		int Aux3 = numC;

		numA = Aux3;
		numB = Aux2;
		numC = Aux;

		System.out.println(numA);
		System.out.println(numB);
		System.out.println(numC);
	}
	}

