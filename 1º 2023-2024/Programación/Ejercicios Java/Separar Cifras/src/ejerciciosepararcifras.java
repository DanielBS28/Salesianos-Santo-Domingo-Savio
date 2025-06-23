import java.util.Scanner;

public class ejerciciosepararcifras {

	public static void main(String[] args) {
		
		// Crear un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Solicitar al usuario que ingrese un número entero
        System.out.print("Ingrese un número entero: ");
        int numeroDecimal = scanner.nextInt();

        // Cerrar el scanner después de su uso
        scanner.close();

        // Convertir el número decimal a binario
        String numeroBinario = Integer.toBinaryString(numeroDecimal);

        // Imprimir el resultado
        System.out.println("El número en formato binario es: " + numeroBinario);
        
        // Math.sqrt(numero);
    }
}