package RepasoExamen;

import java.io.Serializable;

public class Venta implements Serializable{
	
	static int contador;
	
	private int IDVenta;
	private String IDcoche;
	private String comprador;
	
	
	
	public Venta(String idcoche, String comprador) {
		contador++;
		IDVenta = contador;
		this.IDcoche = idcoche;
		this.comprador = comprador;
	}
	public int getIDVenta() {
		return IDVenta;
	}
	public void setIDVenta(int iDVenta) {
		IDVenta = iDVenta;
	}
	
	public String getIDcoche() {
		return IDcoche;
	}
	public void setIDcoche(String iDcoche) {
		IDcoche = iDcoche;
	}
	public String getComprador() {
		return comprador;
	}
	public void setComprador(String comprador) {
		this.comprador = comprador;
	}
	@Override
	public String toString() {
		return "Venta [IDVenta=" + IDVenta + ", IDcoche=" + IDcoche + ", comprador=" + comprador + "]";
	}
	
	
	

}
