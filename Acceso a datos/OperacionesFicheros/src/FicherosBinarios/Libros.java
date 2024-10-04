package FicherosBinarios;

import java.io.Serializable;

public class Libros implements Serializable, Comparable<Libros> {
	
	private String Titulo;
	private String Autor;
	private double Precio;
	public Libros(String titulo, String autor, double precio) {
		
		this.Titulo = titulo;
		this.Autor = autor;
		this.Precio = precio;
	}
	
	public String getTitulo() {
		return Titulo;
	}
	public void setTitulo(String titulo) {
		Titulo = titulo;
	}
	public String getAutor() {
		return Autor;
	}
	public void setAutor(String autor) {
		Autor = autor;
	}
	public double getPrecio() {
		return Precio;
	}
	public void setPrecio(double precio) {
		Precio = precio;
	}
	@Override
	public String toString() {
		return "Libro [Titulo=" + Titulo + ", Autor=" + Autor + ", Precio=" + Precio + "]";
	}
	@Override
	public int compareTo(Libros l) {
		if(Precio > l.getPrecio())
		return 1;
		if(Precio < l.getPrecio())
			return -1;
		
		return 0;
	}
	
	

	

}
