package JavaNIO;

public class Ticket {
	
	static int numeroTicket = 0;
	Cliente cliente;
	Gasolinera gasolinera;
	
	public Ticket(Cliente cliente, Gasolinera gasolinera) {
		super();
		this.cliente = cliente;
		this.gasolinera = gasolinera;
		numeroTicket++;
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
	
	

}
