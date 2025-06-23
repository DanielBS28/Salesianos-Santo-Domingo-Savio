package ejerciciocasino;

import java.util.Scanner;

public class ejercicio1 {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);

		double dado1;
		double dado2;
		double resultado;
		
		do {
			System.out.println("Dime el resultado del dado 1");
			dado1 = teclado.nextInt();
			if (dado1 <=0 || dado1>6) {
				System.out.println("El número que has introducido es erroneo, por favor repitelo");
			}
		}while (dado1 <= 0 || dado1  > 6);

		do {
			System.out.println("Dime el resultado del dado 2");
			dado2 = teclado.nextInt();
			if (dado2 <=0 || dado2 >6) {
				System.out.println("El número que has introducido es erroneo, por favor repitelo");
			}
		
		}while (dado2 <= 0 || dado2  > 6) ;
		
		resultado = dado1 + dado2;
		
		if (resultado == 2|| resultado == 12) {
			System.out.println("La probabilidad de ganar es: 6/36 + 1/36");
		}else if (resultado == 3|| resultado == 11) {
			System.out.println("a probabilidad de ganar es: 6/36 + 2/36");
		}else if (resultado == 4|| resultado == 10) {
			System.out.println("La probabilidad de ganar es: 6/36 + 3/36");
		}else if (resultado == 5 || resultado == 9) {
			System.out.println("La probabilidad de ganar es: 6/36 + 4/36");
		}else if (resultado == 6|| resultado == 8) {
			System.out.println("La probabilidad de ganar es: 6/36 + 5/36");
		}else if (resultado == 7) {
			System.out.println("La probabilidad de ganar es: 6/36");
		}
	
	}
		
}
