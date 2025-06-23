package funcionesprimerejercicio;

public class ejercicio {
	static int sumar2(int sumando1, int sumando2) {
		int res;
		res = sumando1 + sumando2;
		return res;
	}

	public static void main(String[] args) {
		int num1 = 30;
		int num2 = 45;
		int num3 = 6;
		int num4 = 2;

		sumar2(num1, num2);
		sumar2(num3, num4);

		System.out.println(sumar2(num1, num2));
		// sumar2((num1,num2), sumar2(num3,num4));
	}

}
