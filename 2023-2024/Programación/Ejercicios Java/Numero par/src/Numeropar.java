import java.util.Scanner;

public class Numeropar {

	public static void main(String[] args) {
		
		int numero1; 
		
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce un número: ");
		numero1 = teclado.nextInt();
		
		if (numero1 % 2 == 0)
			System.out.println("El numero es par");
		else
			System.out.println("El numero es impar");
	}	
}