package examendanielbaldazosanchez;

import java.util.Scanner;

public class ejercicio5 {

	static int sumar2(int numero) {
		int suma = 0;
		int digito;
		while (numero != 0) {
			digito = (numero % 10);
			suma = suma + digito;
			numero = numero / 10;
		}
		return suma;
	}

	public static void main(String[] args) {

		int numero;

		System.out.println("Introduce un número y te devolveré la suma de sus cifras");
		Scanner teclado = new Scanner(System.in);

		numero = teclado.nextInt();
		System.out.print("El número que has introducido es " + numero + " y su sumatorio de cifras es: ");
		System.out.print(sumar2(numero));
	}

}
