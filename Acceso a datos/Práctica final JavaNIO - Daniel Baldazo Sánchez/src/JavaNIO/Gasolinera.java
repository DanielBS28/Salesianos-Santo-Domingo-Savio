package JavaNIO;

import java.io.Serializable;

public class Gasolinera implements Serializable{

	static int NumeroGasolinera = 1;
	
	private int ID;
	private String nombre;
	private String ubicacion;
	private double precioLitro_G95;
	private double precioLitro_Diesel;
	private int cantidadG95;
	private int cantidadDiesel;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	public double getPrecioLitro_G95() {
		return precioLitro_G95;
	}
	public void setPrecioLitro_G95(double precioLitro_G95) {
		this.precioLitro_G95 = precioLitro_G95;
	}
	public double getPrecioLitro_Diesel() {
		return precioLitro_Diesel;
	}
	public void setPrecioLitro_Diesel(double precioLitro_Diesel) {
		this.precioLitro_Diesel = precioLitro_Diesel;
	}
	public int getCantidadG95() {
		return cantidadG95;
	}
	public void setCantidadG95(int cantidadG95) {
		this.cantidadG95 = cantidadG95;
	}
	public int getCantidadDiesel() {
		return cantidadDiesel;
	}
	public void setCantidadDiesel(int cantidadDiesel) {
		this.cantidadDiesel = cantidadDiesel;
	}
	
	public static int getNumeroGasolinera() {
		return NumeroGasolinera;
	}
	public static void setNumeroGasolinera(int numeroGasolinera) {
		NumeroGasolinera = numeroGasolinera;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	
	@Override
	public String toString() {
		return "#ID: " + ID + " -> Gasolinera: " + nombre + ", ubicacion: " + ubicacion + ", Precio/litro de Gasolina95= " + precioLitro_G95
				+ "€, Precio/litro del Diesel= " + precioLitro_Diesel + "€, Litros Gasolina95 disponibles: " + cantidadG95 +
				 "L, Litros Diesel disponibles: "
				+ cantidadDiesel + "L";
	}
	public Gasolinera(String nombre, String ubicacion, double precioLitro_G95, double precioLitro_Diesel,
			int cantidadG95, int cantidadDiesel) {
		
		this.ID = NumeroGasolinera++;
		this.nombre = nombre;
		this.ubicacion = ubicacion;
		this.precioLitro_G95 = precioLitro_G95;
		this.precioLitro_Diesel = precioLitro_Diesel;
		this.cantidadG95 = cantidadG95;
		this.cantidadDiesel = cantidadDiesel;
	}
	public Gasolinera(int iD, String nombre, String ubicacion, double precioLitro_G95, double precioLitro_Diesel,
			int cantidadG95, int cantidadDiesel) {
		ID = iD;
		this.nombre = nombre;
		this.ubicacion = ubicacion;
		this.precioLitro_G95 = precioLitro_G95;
		this.precioLitro_Diesel = precioLitro_Diesel;
		this.cantidadG95 = cantidadG95;
		this.cantidadDiesel = cantidadDiesel;
		NumeroGasolinera++;
	}
	
	
	

}


