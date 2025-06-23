package ejerciciosbuclesdiciembre;

import java.util.Scanner;

public class ejercicio1 {

	public static void main(String[] args) {
		
	 Scanner sc = new Scanner(System.in);
		
		int num, digitos=0;
		
		System.out.println("Dime un número y te diré el total de digitos");
		num = sc.nextInt();
		
		while(num !=0)
		 {
		   num = num/10;
		   digitos++;
		 }
		System.out.println("El número total de digitos es: " + digitos);

	}

}
