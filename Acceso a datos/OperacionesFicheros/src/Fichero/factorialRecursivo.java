package Fichero;

public class factorialRecursivo {

	static int factorialRecursivo_(int n) {

		if (n == 1)
			return n;
		else
			return n * factorialRecursivo_(n - 1);
	}


	public static void main(String[] args) {

		System.out.println(factorialRecursivo_(7));

	}

}