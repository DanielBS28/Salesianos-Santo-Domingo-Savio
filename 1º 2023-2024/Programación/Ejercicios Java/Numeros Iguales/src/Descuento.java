import java.util.Scanner;

public class Descuento {

	public static void main(String[] args) {

		int numero1;
		int numero2;
		boolean SonNumerosIguales;

		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce un número: ");
		numero1 = teclado.nextInt();
		System.out.println("Introduce otro número: ");
		numero2 = teclado.nextInt();

		if (numero1 == numero2) 
			SonNumerosIguales = true;
		else
			SonNumerosIguales = false;
		
		if (SonNumerosIguales) {
			numero1 = numero1 + 1;
			System.out.println("Le he sumado 1 al primer numero por que son iguales");
			System.out.println("Numero1 es " +  numero1 + " y numero 2 es " + numero2);
		}
		else {
			System.out.println("No son iguales");
		}
		}
	

}
