package funcionesejerciciodificil;

public class ejercicio {

	static int potencia(int base, int exponente) {
		int resultado = 1;
		for (int i=0; i<exponente; i++)
			
			resultado = resultado * base;
		
		return resultado;
	}

	public static void main(String[] args) {
		
		System.out.println(potencia(2,3));
		System.out.println(potencia(25,2));

	}

}
