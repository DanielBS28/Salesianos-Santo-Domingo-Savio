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
			mayor = numero1;
		else
			mayor = numero2;
		
		System.out.println("El número mayor es " + mayor);
		
	}

}
