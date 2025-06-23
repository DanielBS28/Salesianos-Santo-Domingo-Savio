import java.util.Scanner;

public class bucles {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int numerointroducido;
		int resultado = 1;
		System.out.println("Introduce un número");
		numerointroducido= teclado.nextInt();
		for (int i = 1; i <= numerointroducido; i++)
			
		{
			resultado = resultado*i;

		}
		System.out.println("El resultado es: " +resultado);
	}

}
