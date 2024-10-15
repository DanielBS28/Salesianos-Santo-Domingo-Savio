package FicherosBinarios;


	import java.io.Serializable;

	public class PersonaGimnasio implements Serializable {
	    private String nombre;
	    private double cuota;

	    public PersonaGimnasio(String nombre, double cuota) {
	        this.nombre = nombre;
	        this.cuota = cuota;
	    }

	    public String getNombre() {
	        return nombre;
	    }

	    public double getCuota() {
	        return cuota;
	    }

	    @Override
	    public String toString() {
	        return "Persona [nombre=" + nombre + ", cuota=" + cuota + "]";
	    }
	}


