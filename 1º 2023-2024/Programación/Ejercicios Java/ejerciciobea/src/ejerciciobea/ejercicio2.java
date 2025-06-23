package ejerciciobea;

public class ejercicio2 {

	public static void recorrerArray(int array[]) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
		}
	}

	public static void recorrerMatriz(int matriz[][]) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.print(matriz[i][j]);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {

		// Array definido para 3 dimensiones
		int vector[] = new int[3];

		// Consultar posiciones del array

		// Array inicializado
		int vector2[] = { 1, 2, 3 };

		System.out.println(vector2.length);

		recorrerArray(vector2);
		System.out.println();

		int matriz[][] = { { 1, 2, 3 }, { 4, 5, 6 } };
		recorrerMatriz(matriz);

	}

}
