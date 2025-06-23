package ejercicioerick;

import java.util.Scanner;

public class ejercicio2 {

	public static void main(String[] args) {
		
		 Scanner sc = new Scanner(System.in);
	        System.out.print("Introduce la altura de la pirámide: ");
	        int altura = sc.nextInt();
	        for (int i = 1; i <= altura; i++) {
	            for (int j = 1; j <= altura - i; j++) {
	                System.out.print(" ");
	            }
	            for (int k = 1; k <= i * 2 - 1; k++) {
	                System.out.print("*");
	            }
	            System.out.println();
	        }
	    }
	}
