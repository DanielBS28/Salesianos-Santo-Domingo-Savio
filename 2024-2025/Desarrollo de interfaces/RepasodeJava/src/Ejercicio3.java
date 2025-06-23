
public class Ejercicio3 {

	public static void main(String[] args) {
		
		int []arrayEnteros = {1,5,7,2,5,8,4};
		int contador = 0;
		
		for(int n : arrayEnteros) {
			
			if(n % 2 == 0)
				contador++;	
		}
		
		System.out.println("El número total de pares es: " + contador);

	}

}
