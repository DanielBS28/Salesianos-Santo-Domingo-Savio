import java.util.Scanner;

public class Cilindro {

	public static void main(String[] args) {
		// Declaración de variables
		
		// Constante con la palabra final
		final double Pi = 3.1416;
		double radio;
		double altura;
		double volumen;
		
		Scanner teclado = new Scanner(System.in);
		// pedimos datos al usuario
		System.out.println("Introduce los datos del cilindro");
		System.out.println("################################");
		System.out.println("Introduce el radio: ");
		radio = teclado.nextDouble();
		System.out.println("Introduce la altura");
		altura = teclado.nextDouble();
		volumen = Pi * radio * radio * altura;
		System.out.println("El volumen del cilindro es: " + volumen);
	}

}
