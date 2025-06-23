import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Ejercicio4 {

	static Random r = new Random();
	static Scanner teclado = new Scanner(System.in);

	static int numeroRandom() {

		return r.nextInt(0, 10);

	}
	
	static int dimensionesMatriz() {
		
		System.out.println("Dime el tamaño de la matriz ");
		return teclado.nextInt();
		
	}
	static void ejercicioMatriz() {
		
		int suma = 0;
		int dimensionesMatriz = dimensionesMatriz();
		
		int[][] matrizEnteros = new int[dimensionesMatriz][dimensionesMatriz];
		
		for (int i = 0; i < matrizEnteros.length; i++) {
			for (int j = 0; j < matrizEnteros[i].length; j++) {
				matrizEnteros[i][j] = numeroRandom();
				suma += matrizEnteros[i][j];
			}
			System.out.println(Arrays.toString(matrizEnteros[i]));
		}

		System.out.println("La suma total de los numeros de la matriz = " + suma);
		
	}

	public static void main(String[] args) {
		
		
		ejercicioMatriz();

	}

}
