package examendanielbaldazosanchez;

import java.util.Scanner;

public class ejercicio3 {

	static int sumar2(int N) {
		int res;
		int uno = (N/100);
        int dos = (N/10)%10;
        int tres = (N%10);
		res = uno + dos +tres;
		return res;}
	
	public static void main(String[] args) {
		
		int numero;
		
		System.out.println("Dime un número de 3 cifras");
		Scanner teclado = new Scanner(System.in);
		
		numero = teclado.nextInt();
		System.out.print("El número que has introducido es " + numero + " y su sumatorio de cifras es: ");
		System.out.print(sumar2(numero));
	}

}
