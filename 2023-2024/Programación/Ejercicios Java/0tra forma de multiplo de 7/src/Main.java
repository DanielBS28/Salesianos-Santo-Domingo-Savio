import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numero;

        do {
            // Solicitar al usuario que ingrese un número
            System.out.print("Ingrese un número: ");
            numero = scanner.nextInt();

            // Verificar si el número es divisible entre 7 y mayor que 30
            if (numero > 30 && numero % 7 == 0) {
                System.out.println("¡Número válido!");
            } else {
                System.out.println("Número no válido. Inténtelo de nuevo.");
            }
        } while (!(numero > 30 && numero % 7 == 0));

        scanner.close();
    }
}
