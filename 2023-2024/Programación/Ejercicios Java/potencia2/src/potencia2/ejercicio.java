package potencia2;

import java.util.Scanner;

public class ejercicio {

	static int mcd(int num1, int num2) {

		int resultado;
		int maxposible;
		boolean esmcd = false;
		if (num1 < num2)
			maxposible = num1;
		else
			maxposible = num2;

		while (!esmcd) {
			
			if (num1 % maxposible == 0 && num2 % maxposible == 0)
				esmcd = true;

			else
				maxposible = maxposible - 1;
		}
		return maxposible;
	}

	public static void main(String[] args) {

		System.out.println(mcd(3, 6));

	}

}
