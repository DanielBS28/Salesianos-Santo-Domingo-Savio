package JavaNIO;

import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class Ticket implements Serializable {

	static int numeroTicket = 1;
	final static int Gasolina95 = 1;
	final static int Diesel = 2;

	private int IDTicket;
	private Cliente cliente;
	private Gasolinera gasolinera;
	private int cantidadRepostada;
	private double Euros;
	private int tipoGasolina;

	public Ticket(Cliente cliente, Gasolinera gasolinera, int cantidadRepostada, double euros, int tipoGasolina) {
		IDTicket = numeroTicket++;
		this.cliente = cliente;
		this.gasolinera = gasolinera;
		this.cantidadRepostada = cantidadRepostada;
		this.tipoGasolina = tipoGasolina;
		Euros = euros;
	}

	public Ticket(int IDTicket, Cliente cliente, Gasolinera gasolinera, int cantidadRepostada, double euros,
			int tipoGasolina) {
		this.IDTicket = IDTicket;
		this.cliente = cliente;
		this.gasolinera = gasolinera;
		this.cantidadRepostada = cantidadRepostada;
		Euros = euros;
		this.tipoGasolina = tipoGasolina;
		numeroTicket++;
	}

	public static int getNumeroTicket() {
		return numeroTicket;
	}

	public static void setNumeroTicket(int numeroTicket) {
		Ticket.numeroTicket = numeroTicket;
	}

	public int getCantidadRepostada() {
		return cantidadRepostada;
	}

	public void setCantidadRepostada(int cantidadRepostada) {
		this.cantidadRepostada = cantidadRepostada;
	}

	public double getEuros() {
		return Euros;
	}

	public void setEuros(double euros) {
		Euros = euros;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Gasolinera getGasolinera() {
		return gasolinera;
	}

	public void setGasolinera(Gasolinera gasolinera) {
		this.gasolinera = gasolinera;
	}

	public int getIDTicket() {
		return IDTicket;
	}

	public void setIDTicket(int iDTicket) {
		IDTicket = iDTicket;
	}

	public int getTipoGasolina() {
		return tipoGasolina;
	}

	public void setTipoGasolina(int tipoGasolina) {
		this.tipoGasolina = tipoGasolina;
	}

	public void generarTicket(Path ruta, int tipoGasolina) {

		Path fichero = ruta.resolve(String.valueOf(IDTicket) + ".txt");

		if (!Files.exists(fichero)) {
			try {
				Files.writeString(fichero, "Numero de ticket: " + IDTicket + "\n");
				Files.writeString(fichero, String.valueOf(cliente.getNumeroCliente()) + "\n",
						StandardOpenOption.APPEND);
				Files.writeString(fichero, cliente.getNombre() + "\n", StandardOpenOption.APPEND);
				Files.writeString(fichero, gasolinera.getNombre() + "\n", StandardOpenOption.APPEND);
				Files.writeString(fichero, gasolinera.getUbicacion() + "\n\n", StandardOpenOption.APPEND);
				Files.writeString(fichero, tipoGasolina == Gasolina95
						? "Gasolina 95 (" + gasolinera.getPrecioLitro_G95() + ")-------" + cantidadRepostada + "L\n"
						: "Diesel (" + gasolinera.getPrecioLitro_Diesel() + ")-------" + cantidadRepostada + "L\n",
						StandardOpenOption.APPEND);
				Files.writeString(fichero, "total: " + getEuros() +" Euros", StandardOpenOption.APPEND);
				
				System.out.println("Se ha generado el ticket: " + fichero.getFileName());

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
