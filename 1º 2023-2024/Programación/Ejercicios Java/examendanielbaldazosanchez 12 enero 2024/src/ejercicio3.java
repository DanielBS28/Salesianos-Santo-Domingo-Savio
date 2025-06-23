import java.util.Scanner;

public class ejercicio3 {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);

		int numero;

		System.out.println("Dime un número y te diré los siguientes cuatro números impares");
		numero = teclado.nextInt();
		numero = numero +1; /* ESTO ES IMPORTANTE YA QUE SI NO LE SUMO UNO AL NUMERO ORIGINAL ME VA A IMPRIMIR EL NÚMERO QUE YO 
		HE INTRODUCIDO Y LOS SIGUIENTES 3 NUMEROS IMPARES, SI YO LE SUMO 1 MODIFICO EL NÚMERO ORIGINAL Y 
		ME VA A DAR LOS SIGUIENTES 4 NUMEROS IMPARES QUE ES LO QUE ME PIDE EL EJERCICIO*/

		for (int i = 0; i < 4; numero++) {
			if (numero % 2 == 0) {
		
				System.out.println(numero);
			}
		}

	}

}
