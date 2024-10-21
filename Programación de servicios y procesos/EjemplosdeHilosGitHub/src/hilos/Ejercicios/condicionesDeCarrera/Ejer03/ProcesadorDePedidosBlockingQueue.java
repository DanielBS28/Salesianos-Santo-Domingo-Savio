package hilos.Ejercicios.condicionesDeCarrera.Ejer03;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * EJEMPLO DE PRODUCTOR CONSUMIDOR.
 */
class BQAgregarPedido implements Runnable {
	private ProcesadorDePedidosBlockingQueue procesador;

	public BQAgregarPedido(ProcesadorDePedidosBlockingQueue procesador) {
		this.procesador = procesador;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 20; i++) {
			procesador.agregarPedido("Pedido " + i);
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class BQProcesarPedido implements Runnable {
	private ProcesadorDePedidosBlockingQueue procesador;

	public BQProcesarPedido(ProcesadorDePedidosBlockingQueue procesador) {
		this.procesador = procesador;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 20; i++) {
			procesador.procesarPedido();
			try {
				Thread.sleep(70);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class ProcesadorDePedidosBlockingQueue {
	// private List<String> pedidos = new ArrayList<>();

	private LinkedBlockingQueue<String> pedidos = new LinkedBlockingQueue<String>();
	// Permite a un hilo esperar (Bloquear un hilo)

	public void agregarPedido(String pedido) {
		pedidos.add(pedido);
		System.out.println("Pedido agregado: " + pedido);
	}

	public void procesarPedido() {

		String pedido;
		try {
			pedido = pedidos.take();
			System.out.println("Pedido procesado: " + pedido);

		} catch (InterruptedException e) {
			System.out.println("No hay pedidos para procesar");
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		ProcesadorDePedidosBlockingQueue procesador = new ProcesadorDePedidosBlockingQueue();

		Thread hiloAgregar = new Thread(new BQAgregarPedido(procesador));
		Thread hiloProcesar = new Thread(new BQProcesarPedido(procesador));

		hiloAgregar.start();
		hiloProcesar.start();

		try {
			hiloAgregar.join();
			hiloProcesar.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
