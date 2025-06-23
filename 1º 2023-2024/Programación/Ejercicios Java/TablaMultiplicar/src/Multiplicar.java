
public class Multiplicar {

	public static void main(String[] args) {
		// Generar tablas de multiplicar del 1,2,3 y 4
		for (int i = 0; i < 4; i++) {

			System.out.println("Tabla de multiplicar del " + i);
			{
				System.out.println("");
				for (int j = 0; j < 10; j++)
					System.out.println(i + "x" + j + " = " + i * j);
				System.out.println("");
			}
		}
	}

}
