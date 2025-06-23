import java.util.Scanner;

public class CalculoSalario {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Pedir al usuario el tipo de contrato (A, B o C) y el salario bruto
        System.out.print("Ingrese el tipo de contrato (A, B o C): ");
        String tipoContrato = scanner.next();

        System.out.print("Ingrese el salario bruto: ");
        double salarioBruto = scanner.nextDouble();

        double retencion = 0;
        double contribucion = 0;

        // Calcular retención y contribución según el tipo de contrato y salario bruto
        if (tipoContrato.equals("A")) {
            retencion = salarioBruto * 0.15;
            contribucion = salarioBruto * 0.10;
        } else if (tipoContrato.equals("B")) {
            if (salarioBruto < 1000) {
                retencion = salarioBruto * 0.05;
                contribucion = salarioBruto * 0.10;
            } else if (salarioBruto >= 1000 && salarioBruto <= 2000) {
                retencion = salarioBruto * 0.10;
                contribucion = salarioBruto * 0.10;
            } else {
                retencion = salarioBruto * 0.20;
                contribucion = salarioBruto * 0.10;
            }
        } else if (tipoContrato.equals("C")) {
            if (salarioBruto < 1500) {
                contribucion = salarioBruto * 0.05;
                retencion = salarioBruto * 0.10;
            } else {
                contribucion = salarioBruto * 0.15;
                retencion = salarioBruto * 0.10;
            }
        } else {
            System.out.println("Tipo de contrato no válido");
            return;
        }

        // Calcular salario neto restando retención y contribución del salario bruto
        double salarioNeto = salarioBruto - retencion - contribucion;

        // Mostrar salario neto al usuario
        System.out.println("El salario neto es: " + salarioNeto);

        scanner.close();
    }
}

