import java.util.Scanner;
public class SeparaCifras {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        int N;

        System.out.print("Introduzca valor de N: ");
        N = sc.nextInt(); //supondremos que el número introducido tiene 4 cifras
        
        System.out.println("Primera cifra de " + N + " -> " + (N/1000));
        System.out.println("Cifra central de " + N + " -> " + (N/100)%10);
        System.out.println("Cifra central de " + N + " -> " + (N/10)%10);
        System.out.println("Última cifra  de " + N + " -> " + (N%10));
	}

}
