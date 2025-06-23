package LecturaEscritura;

import java.io.*;

public class W_ejercicio1 {

	private static void escribirArchivo(String ruta) {
		String Primos = "";
		try {
			BufferedWriter bf = new BufferedWriter(new FileWriter(ruta));
			
			for(int i = 1 ; i<= 500; i++) {
				if(esPrimo(i)) {
					if(Primos.equals(""))
						Primos += i;
					else 
						Primos+= ","+i;
				}
			}
			bf.write(Primos);

			bf.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static boolean esPrimo(int numero) {

		if(numero <= 1)
			return false;
		
		for(int i = 2; i< numero - 1 ; i++) {
			if(numero % i == 0)
				return false;	
		}
		return true;
	}

	public static void main(String[] args) {

		escribirArchivo("src/LecturaEscritura/Primos.txt");

	}

}
