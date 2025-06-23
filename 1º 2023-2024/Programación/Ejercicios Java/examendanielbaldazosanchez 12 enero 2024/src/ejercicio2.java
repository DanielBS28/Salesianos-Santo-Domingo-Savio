import java.util.Scanner;

public class ejercicio2 {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner (System.in);

		int numero;
		
		System.out.println("Voy a pedirte números, pararemos el programa cuando sea mayor de 100 si no tendrás que seguir introduciendo números");
		
		do {
			System.out.println("Introduce un número");
			numero = teclado.nextInt();
			if (numero <= 100){
				System.out.println("Número menor o igual que 100, por favor repite el proceso");
			}
		}while (numero <= 100);
		System.out.println("Fin del programa al ser un número mayor que 100");
	}

}
