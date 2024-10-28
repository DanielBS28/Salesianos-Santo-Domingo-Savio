package hilos.Ejercicios.condicionesDeCarrera.Ejer09;

import java.util.concurrent.atomic.AtomicInteger;

class UsuarioCajero implements Runnable {
	private CajeroAutomatico cajero;
	private int cantidad;

	public UsuarioCajero(CajeroAutomatico cajero, int cantidad) {
		this.cajero = cajero;
		this.cantidad = cantidad;
	}

	@Override
	public void run() {
		cajero.retirar(cantidad);
	}
}
/*
 * public class CajeroAutomatico {
 * 
 * // Para que todos los hilos vean todos los cambios volatile private int saldo
 * = 1000;
 * 
 * public void retirar(int cantidad) { synchronized (this) { if (saldo >=
 * cantidad) { saldo -= cantidad; System.out.println("Retiro de " + cantidad +
 * " exitoso. Saldo restante: " + saldo); return; } }
 * System.out.println("Fondos insuficientes para retirar " + cantidad); }
 */

public class CajeroAutomatico {

	private AtomicInteger saldo = new AtomicInteger(1000);

	public void retirar(int cantidad) {

		boolean actualizadoSaldo = false;
		int actual;
		do {
			actual = saldo.get();
			if (actual - cantidad <= 0) {

				System.out.println("No hay dinero");
				return;
			}
			actualizadoSaldo = saldo.compareAndSet(actual, saldo.get() - cantidad);

		} while (!actualizadoSaldo);

		System.out.println("Retiro de " + cantidad + " exitoso");

	}

	public int consultarSaldo() {
		return saldo.get();
	}

}
