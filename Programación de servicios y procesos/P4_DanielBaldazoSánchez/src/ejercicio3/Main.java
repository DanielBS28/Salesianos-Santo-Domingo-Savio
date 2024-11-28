package ejercicio3;

import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.google.gson.Gson;

public class Main {

    /**
     * Lee los datos de clientes desde archivos JSON y los almacena en una lista.
     * 
     * @return una lista de objetos {@link Cliente} deserializados desde los archivos.
     */
    public static ArrayList<Cliente> leerClientes() {
        Gson gson = new Gson();
        ArrayList<Cliente> clientes = new ArrayList<>();

        for (int i = 1; i <= 6; i++) {
            try (FileReader reader = new FileReader("src/ejercicio3/JSON/data/cliente" + i + ".json")) {
                Cliente cliente = gson.fromJson(reader, Cliente.class);
                clientes.add(cliente);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return clientes;
    }

    /**
     * Lee las transferencias desde archivos JSON y las almacena en una lista de
     * arreglos.
     * 
     * @return una lista de arreglos de objetos {@link Transferencia} deserializados
     *         desde los archivos.
     */
    public static ArrayList<Transferencia[]> leerTransferencias() {
        ArrayList<Transferencia[]> transferencias = new ArrayList<>();
        Gson gson = new Gson();

        for (int i = 1; i <= 10; i++) {
            try (FileReader reader = new FileReader("src/ejercicio3/JSON/data/transferencias" + i + ".json")) {
                Transferencia[] t = gson.fromJson(reader, Transferencia[].class);
                transferencias.add(t);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return transferencias;
    }

    /**
     * Punto de entrada de la aplicación. Lee los datos de clientes y transferencias
     * desde archivos JSON, ejecuta las transferencias concurrentemente y muestra
     * los saldos finales de los clientes.
     * 
     * @param args argumentos de línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        ArrayList<Cliente> CLIENTES = leerClientes();
        ArrayList<Transferencia[]> TRANSFERENCIAS = leerTransferencias();
        ExecutorService executor = Executors.newFixedThreadPool(10); // Pool con 10 hilos.

        for (Transferencia[] transferencias : TRANSFERENCIAS) {
            for (Transferencia transferencia : transferencias) {

                // Crear una tarea para procesar la transferencia.
                Runnable task = () -> {
                    procesarTransferencia(transferencia, CLIENTES);
                };

                // Enviar la tarea al pool de hilos.
                executor.submit(task);
            }
        }

        // Apagar el pool de hilos de forma ordenada después de terminar las tareas.
        executor.shutdown();

        try {
            // Esperar a que todos los hilos terminen antes de continuar.
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                System.out.println("Algunos hilos no terminaron a tiempo.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Imprimir los resultados finales de los clientes.
        System.out.println("Saldo final tras realizar las transferencias:");
        for (Cliente c : CLIENTES) {
            System.out.println(c);
        }
    }

    /**
     * Procesa una transferencia entre dos clientes, actualizando sus saldos de
     * manera segura utilizando sincronización.
     * 
     * @param transferencia el objeto {@link Transferencia} que contiene los datos
     *                      de la operación.
     * @param clientes      la lista de clientes donde se buscarán el origen y
     *                      destino de la transferencia.
     */
    private static void procesarTransferencia(Transferencia transferencia, ArrayList<Cliente> clientes) {
        Cliente origen = buscarCliente(transferencia.getOrigen(), clientes);
        Cliente destino = buscarCliente(transferencia.getDestino(), clientes);

        if (origen != null && destino != null && origen.getSaldo() >= transferencia.getMonto()) {
            // Sincronizar el acceso a los clientes involucrados en la transferencia.
            synchronized (origen) {
                synchronized (destino) {
                    origen.setSaldo(origen.getSaldo() - transferencia.getMonto());
                    destino.setSaldo(destino.getSaldo() + transferencia.getMonto());
                }
            }
            System.out.println("Transferencia procesada: " + transferencia);
        } else {
            System.out.println("Error en transferencia: " + transferencia);
        }
    }

    /**
     * Busca un cliente por su ID en la lista de clientes.
     * 
     * @param id       el ID del cliente que se desea buscar.
     * @param clientes la lista de clientes donde buscar.
     * @return el cliente encontrado, o {@code null} si no se encuentra.
     */
    private static Cliente buscarCliente(String id, ArrayList<Cliente> clientes) {
        for (Cliente cliente : clientes) {
            if (cliente.getId().equals(id)) {
                return cliente;
            }
        }
        return null;
    }
}
