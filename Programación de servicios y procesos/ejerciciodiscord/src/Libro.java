
public class Libro {

	private String isbn;
	private String titulo;
	private String autor;
	private int anioPublicacion;
	private boolean  disponible = true;
	
	
	public Libro(String isbn, String titulo, String autor, int anioPublicacion) {

		this.isbn = isbn;
		this.titulo = titulo;
		this.autor = autor;
		this.anioPublicacion = anioPublicacion;
	
	}
	
	public void Préstamo() {
		
		disponible = false;
	
	}
	
	public void devolucion() {
		
		disponible = true;
	}
	
	
	public String informacion() {
		
		return "Libro [isbn=" + isbn + ", titulo=" + titulo + ", autor=" + autor + ", anioPublicacion="
				+ anioPublicacion + ", disponible=" + disponible + "]";
	}

	
	
	
}
