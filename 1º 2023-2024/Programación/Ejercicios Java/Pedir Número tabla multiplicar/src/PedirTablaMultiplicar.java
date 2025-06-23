import java.util.Scanner;

public class PedirTablaMultiplicar {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);

		int numerointroducido;

		System.out.println("Dime un número y te digo su tabla de multiplicar ");
		numerointroducido = teclado.nextInt();
		System.out.println("La tabla de multiplicar del " + numerointroducido + " es: ");
		System.out.println("");
		for (int i = 0; i < 10; i++) {
			System.out.println(i + "x" + numerointroducido + " = " + i * numerointroducido);
		} 
	}

}
