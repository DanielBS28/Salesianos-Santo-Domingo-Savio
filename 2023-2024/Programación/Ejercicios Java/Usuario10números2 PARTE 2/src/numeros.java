import java.util.Scanner;

public class numeros {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);

		int numero;
		int resto7;
		int repeticiones;
		
		System.out.println("Cuantos números quieres introducir");
		repeticiones = teclado.nextInt();
		for (int i = 0; i < repeticiones; i++) {
			System.out.println("Introduce un número te lo pediré " + repeticiones + " veces");
		
			numero = teclado.nextInt();
			resto7 = numero % 7;
			
				System.out.println("El resto de dividir entre siete " + numero + " es " + resto7);
				System.out.println("#####################################");

			}
		System.out.println("FIN");
}
}