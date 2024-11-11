package JavaNIO;

import java.io.Serializable;
import java.util.ArrayList;

public class Cliente implements Serializable{
	
	private int numeroCliente;
	private String nombre;
	private String calle;
	private String ciudad;
	private int codigopostal;
	private String pais;
	private String rol;
	
	public Cliente(int numeroCliente, String nombre, String calle, String ciudad, int codigopostal, String pais,String rol) {
		super();
		this.numeroCliente = numeroCliente;
		this.nombre = nombre;
		this.calle = calle;
		this.ciudad = ciudad;
		this.codigopostal = codigopostal;
		this.pais = pais;
		this.rol = rol;
	
	}
	
	
	public String getRol() {
		return rol;
	}


	public void setRol(String rol) {
		this.rol = rol;
	}




	public int getNumeroCliente() {
		return numeroCliente;
	}


	public void setNumeroCliente(int numeroCliente) {
		this.numeroCliente = numeroCliente;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getCalle() {
		return calle;
	}


	public void setCalle(String calle) {
		this.calle = calle;
	}


	public String getCiudad() {
		return ciudad;
	}


	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}


	public int getCodigopostal() {
		return codigopostal;
	}


	public void setCodigopostal(int codigopostal) {
		this.codigopostal = codigopostal;
	}


	public String getPais() {
		return pais;
	}


	public void setPais(String pais) {
		this.pais = pais;
	}


	@Override
	public String toString() {
		return "Número de Cliente: " + numeroCliente + ", nombre: " + nombre + ", calle: " + calle + ", ciudad: "
				+ ciudad + ", código postal: " + codigopostal + ", pais: " + pais + ", rol: " + rol;
	}
	
	
	

}


