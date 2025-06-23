package ejerciciobea;

import java.util.Scanner;

public class ejercicio3 {
	
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		int array[]= new int[10];
		
		for (int i =0; i< array.length; i++) {
			
			System.out.println("Dime un número");
			array[i]=teclado.nextInt();
			//System.out.print(array[i]);
		}
		for (int j =0; j< array.length; j++) {
			System.out.println(array[j]);
		}
		
	}

}
