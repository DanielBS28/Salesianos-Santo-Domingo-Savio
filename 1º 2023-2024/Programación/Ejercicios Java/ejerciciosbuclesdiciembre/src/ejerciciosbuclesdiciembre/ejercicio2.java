package ejerciciosbuclesdiciembre;

import java.util.Scanner;

public class ejercicio2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int numero, cifra, nuevoNumero =0;
		
		System.out.println("Dime un número y te diré el número invertido");
		numero = sc.nextInt();		
		  while (numero != 0) {        
	            cifra = numero % 10;  
	            numero = numero / 10;    
	            nuevoNumero = nuevoNumero * 10 + cifra;                               
	        }
	        
	        numero = nuevoNumero;
	        
	        System.out.println("Número con las cifras invertidas: " + numero);
	    }
	}