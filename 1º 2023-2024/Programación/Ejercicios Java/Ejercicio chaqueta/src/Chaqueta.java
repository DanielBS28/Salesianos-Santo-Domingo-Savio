
public class Chaqueta {

	public static void main(String[] args) {
	double precio = 85.05;
	double descuento = 0.15;
	
	double operación = precio * descuento;
	double preciofinal = precio - operación;
	System.out.printf("El precio final de la chaqueta es %.2f" , preciofinal);
	}

}
