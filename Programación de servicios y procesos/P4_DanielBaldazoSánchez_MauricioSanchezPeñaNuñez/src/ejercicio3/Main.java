package ejercicio3;

import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.google.gson.Gson;

public class Main {

	public static ArrayList<Cliente> leerClientes() {
		Gson gson = new Gson();
		ArrayList<Cliente> Clientes = new ArrayList<>();

		for (int i = 1; i <= 6; i++) {
			try (FileReader reader = new FileReader("src/ejercicio3/JSON/data/cliente" + i + ".json")) {
				// Deserializar el JSON en un objeto Cliente
				Cliente cliente = gson.fromJson(reader, Cliente.class);
				Clientes.add(cliente);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return Clientes;
	}

	public static ArrayList<Transferencia[]> leerTransferencias() {
		ArrayList<Transferencia[]> Transferencias = new ArrayList<>();
		Transferencia[] transferencias = null;
		Gson gson = new Gson();

		for (int i = 1; i <= 10; i++) {
			try (FileReader reader = new FileReader("src/ejercicio3/JSON/data/transferencias" + i + ".json")) {
				transferencias = gson.fromJson(reader, Transferencia[].class);
				// Muestra el cliente leído
				Transferencias.add(transferencias);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return Transferencias;
	}

	public static void main(String[] args) {

		ArrayList<Cliente> CLIENTES = leerClientes();
		ArrayList<Transferencia[]> TRANSFERENCIAS = leerTransferencias();
		ExecutorService executor = Executors.newFixedThreadPool(10);

		for (int i = 0; i < TRANSFERENCIAS.size(); i++) {

			Transferencia[] t = TRANSFERENCIAS.get(i);
			for (int j = 0; j < t.length; j++) {
				
				
			}

		}

	}

}
