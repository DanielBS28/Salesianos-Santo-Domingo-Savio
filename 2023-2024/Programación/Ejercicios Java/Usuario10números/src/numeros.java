import java.util.Scanner;

public class numeros {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);

		int numero;
		int resto7;
		for (int i = 0; i < 10; i++) {
			System.out.println("Introduce un número (te lo pediré 10 veces)");
		
			numero = teclado.nextInt();
			resto7 = numero % 7;
			
				System.out.println("El resto de dividir entre siete " + numero + " es " + resto7);
				System.out.println("#####################################");

			}
		System.out.println("FIN");
}
}