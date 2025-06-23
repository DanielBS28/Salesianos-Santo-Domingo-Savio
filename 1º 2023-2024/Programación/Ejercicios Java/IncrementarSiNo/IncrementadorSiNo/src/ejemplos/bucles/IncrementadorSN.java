package ejemplos.bucles;

import java.util.Scanner;

public class IncrementadorSN {
	public static void main (String args []) {
		Scanner teclado = new Scanner(System.in);
		int numIntroducido;
		int numIncrementado;
		char respuesta;
		boolean esSi = false;
		
		
		do {
			System.out.println("Introduce un número");
			numIntroducido = teclado.nextInt();
			numIncrementado = numIntroducido + 1;
			System.out.printf("El número incrementado es: %d%n", numIncrementado);
			
			System.out.println("¿Quieres volver a usar el incrementador de números: S/N? ");
			respuesta = teclado.next().charAt(0);
			
			if (respuesta == 'S' || respuesta == 's' ) {
				esSi = true;
			} else if (respuesta == 'N' || respuesta == 'n' ) {
				esSi=false;
				System.out.println("Hasta Luego");
			} else
				System.out.println("Carácter erróneo");
				while (respuesta!='S' && respuesta!='s' && respuesta!='N' && respuesta!='n') {
					System.out.println("¿Quieres volver a usar el incrementador de números: S/N? ");
					respuesta = teclado.next().charAt(0);
				}
		}while(esSi);
	}

}
