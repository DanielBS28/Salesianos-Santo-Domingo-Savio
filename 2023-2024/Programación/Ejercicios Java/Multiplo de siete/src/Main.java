import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numero = 0;

        // Ciclo para solicitar un número hasta que sea divisible entre 7 y mayor que 30
        while (numero <= 30 || numero % 7 != 0) {
            System.out.print("Ingrese un número natural: ");
            numero = scanner.nextInt();
        }

        System.out.println("¡El número " + numero + " es mayor que 30 y divisible entre 7!");
        
        scanner.close();
    }
}
