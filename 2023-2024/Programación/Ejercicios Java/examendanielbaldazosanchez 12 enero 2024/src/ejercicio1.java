import java.util.Scanner;

public class ejercicio1 {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner (System.in);
		
		double nota1, nota2, nota3, media; /*CADA VEZ QUE PIDO UN NÚMEOR AÑADÍ UNA PROGRAMACIÓN DEFENSIVA PÀRA QUE EL USUARIO INTRODUZCA VALORES ENTRE
		0 Y 10, SI EL USUARIO METRE OTRO VALOR DISTINTO EL PROGRAMA SE REPITE EN ESA PARTE*/
		
		do {
			System.out.println("Dime la nota del primer examen");
			nota1 = teclado.nextDouble();
			if (nota1 < 0 || nota1 > 10) {
				System.out.println("La nota que has introducido para el primer examen es erronea por favor, repite el proceso");
			}
		} while (nota1 < 0 || nota1 > 10);
		do {
			System.out.println("Dime la nota del segundo examen");
			nota2 = teclado.nextDouble();
			if (nota2 < 0 || nota2 > 10) {
				System.out.println("La nota que has introducido para el segundo examen es erronea por favor, repite el proceso");
			}
		} while (nota2 < 0 || nota2 > 10);
		do {
			System.out.println("Dime la nota del tercer examen");
			nota3 = teclado.nextDouble();
			if (nota3 < 0 || nota3 > 10) {
				System.out.println("La nota que has introducido para el tercer examen es erronea por favor, repite el proceso");
			}
		} while (nota3 < 0 || nota3 > 10);
		
		media = ((nota1 + nota2 + nota3)/3);
		
		// AQUI AÑADI UN PRINTF PARA AJUSTAR LA NOTA A DOS DECIMALES
		
		if (media < 5) {
			System.out.printf("Tu media es %.2f", media);
		System.out.print(" por lo tanto has suspendido al ser menos de 5 puntos");
		}else 
			System.out.printf("Tu media es %.2f", media);
		System.out.print(" por lo tanto has aprobado al ser mas de 5 puntos");
	}

}
