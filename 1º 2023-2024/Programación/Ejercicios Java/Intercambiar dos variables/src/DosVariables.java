import java.util.Scanner;

public class DosVariables {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int numero1;
int numero2;
int aux;

Scanner teclado = new Scanner(System.in);

System.out.println("Dime un número ");
numero1=teclado.nextInt();
System.out.println("Dime otro número ");
numero2=teclado.nextInt();


System.out.println(numero1);
System.out.println(numero2);

aux = numero1;
numero1 = numero2;
numero2 =aux;

System.out.println(numero1);
System.out.println(numero2);


}
}