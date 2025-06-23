package ejerciciobea;

public class ejercicio1 {

	public static void visualizar(char m[]) {
		for (int i = 0; i < m.length; i++) {
			System.out.println(m[i]);
		}
	}

	public static void main(String[] args) {

		char letras[] = new char[4];

		letras[0] = 'A';
		letras[1] = 'A';
		letras[2] = 'A';
		letras[3] = 'A'; 

		for (int i = 0; i < letras.length; i++) {
			letras[i] = 'B';
		}
		for (int i = 0; i < letras.length; i++) {
			System.out.println(letras[i]);
		}
		
		visualizar(letras);

	}

}
