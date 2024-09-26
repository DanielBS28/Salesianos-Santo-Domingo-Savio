import java.util.Date;

public class Préstamo {
	
	private String idPréstamo;
	private Date fechaPréstamo;
	private Date fechaDevolución;
	private Usuario usuario;
	private Libro libro;
	
	
	public Préstamo(String idPréstamo, Libro libro, Usuario usuario,  Date fechaPréstamo) {
		
		this.idPréstamo = idPréstamo;
		this.usuario = usuario;
		this.libro = libro;
		this.fechaPréstamo = fechaPréstamo;
	}
	

	public void realizarPrestamo() {
		
		libro.Préstamo();
		usuario.librosUsuario.add(libro);
		
	}
	
	public void finalizarPrestamo(Date fechaDevolución) {
		
		libro.devolucion();
		this.fechaDevolución = fechaDevolución;
		
	}

}
