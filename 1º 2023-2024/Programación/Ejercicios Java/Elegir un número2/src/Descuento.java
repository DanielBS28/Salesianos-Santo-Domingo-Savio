import java.util.Scanner;

public class Descuento {

	public static void main(String[] args) {

		int numero1;
		int numero2;
		int mayor;

		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce un número: ");
		numero1 = teclado.nextInt();
		System.out.println("Introduce otro número: ");
		numero2 = teclado.nextInt();

		if (numero1 > numero2)
			System.out.print("El número mayor es; " + numero1);

		else if (numero1 == numero2) {
			System.out.print("Los números son iguales");
		} else
			System.out.print("El número mayor es " + numero2);
	}

}
