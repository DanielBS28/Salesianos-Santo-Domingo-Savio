package hilos.Ejercicios.condicionesDeCarrera.Ejer03;
import java.util.ArrayList;
import java.util.List;

class AgregarPedido implements Runnable {
    private ProcesadorDePedidos procesador;

    public AgregarPedido(ProcesadorDePedidos procesador) {
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


class ProcesarPedido implements Runnable {
    private ProcesadorDePedidos procesador;

    public ProcesarPedido(ProcesadorDePedidos procesador) {
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


public class ProcesadorDePedidos {
    private List<String> pedidos = new ArrayList<>(); // No es segura para concurrecia 
    // 

    //Como esta clase no tiene absolutamente nada mas que la variable pedido 
    // y metodos que la utilizan y la seccion critica de cada metodo es el metodo
    // entero synchcronized al método es una solución valida.
    
    // Lo unico que seguirá pasando que se quedan pedidos sin procesar Esto no es un problema de 
    // concurrencia. Si fuera secuencial podria pasarnos también dependiendo de los tiempos,
    //`podrian quedarse pedidos sin procesar.
    
    public synchronized void agregarPedido(String pedido) {
        pedidos.add(pedido);
        System.out.println("Pedido agregado: " + pedido);
    }

    public synchronized void procesarPedido() {
        if (!pedidos.isEmpty()) {
            String pedido = pedidos.remove(0);
            System.out.println("Pedido procesado: " + pedido);
        } else {
        	
        	// Tendría que esperar a que lleguen los siguientes pedidos.
            System.out.println("No hay pedidos para procesar.");
        }
    }
    
    public static void main(String[] args) {
        ProcesadorDePedidos procesador = new ProcesadorDePedidos();

        Thread hiloAgregar = new Thread(new AgregarPedido(procesador));
        Thread hiloProcesar = new Thread(new ProcesarPedido(procesador));

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
