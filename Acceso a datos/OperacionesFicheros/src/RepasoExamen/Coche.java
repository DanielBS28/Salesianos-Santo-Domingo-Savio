package RepasoExamen;

import java.io.Serializable;

public class Coche implements Serializable{
	
	private String ID;
	private String modelo;
	private String marca;
	private String color;
	private boolean vendido = false;
	
	
	public Coche(String ID, String modelo, String marca, String color) {
	
		
		this.ID = ID;
		this.modelo = modelo;
		this.marca = marca;
		this.color = color;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public boolean isVendido() {
		return vendido;
	}
	public void setVendido(boolean vendido) {
		this.vendido = vendido;
	}
	@Override
	public String toString() {
		return "Coche [ID=" + ID + ", modelo=" + modelo + ", marca=" + marca + ", color=" + color + ", vendido="
				+ vendido + "]";
	}
	
	
	

}
