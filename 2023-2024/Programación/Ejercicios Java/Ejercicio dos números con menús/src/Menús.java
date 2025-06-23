import java.util.Scanner;

public class Menús {

	public static void main(String[] args) {
		int numero1;
		int numero2;
		int numeroelegido;
		int resultado = 0;
		int multiplicar = 1;

		Scanner teclado = new Scanner(System.in);
		System.out.println("Dime un número ");
		numero1 = teclado.nextInt();
		do {
			System.out.println("Dime otro número ");
			numero2 = teclado.nextInt();

			if (numero1 > numero2) {
				System.out.println("El segundo número que has introducido debe ser mayor que el primero");
			}
		} while (numero1 > numero2);
		do {
		System.out.println();
		System.out.println("Elige un menú del 1 al 5");
		System.out.println();
		System.out.println("1) Sumatorio");
		System.out.println("2) Multiplicatorio");
		System.out.println("3) Menor");
		System.out.println("4) Mayor");
		System.out.println("5) Salir");
		numeroelegido = teclado.nextInt();
		if (numeroelegido == 1) {
			System.out.println("Has elegido Sumatorio");
			for (int i = numero1; i<=numero2; i++)
				resultado = resultado + i;
			System.out.println("");
			System.out.println(resultado);
		} else if (numeroelegido == 2) {
			System.out.println("Has elegido Multiplicatorio");
			for (int i = numero1; i<=numero2; i++)
				multiplicar = multiplicar * i;
			System.out.println("");
			System.out.println(multiplicar);
		} else if (numeroelegido == 3) {
			System.out.println("El número menor es "+ numero1);
			System.out.println("");
		} else if (numeroelegido == 4) {
			System.out.println("El número mayor es "+ numero2);
			System.out.println("");
		} else if (numeroelegido <= 0 || numeroelegido > 5) {
			System.out.println("No has introducido un número que he pedido, repite el proceso");
			System.out.println("");
		}
		}while (numeroelegido != 5);
			
		System.out.println("Hasta luego");
		
		}
	
}
