package FicherosBinarios;
import java.io.Serializable;
import java.util.ArrayList;

public class Actividad implements Serializable {
    private String nombre;
    private String tipo;
    private int duracion; // En minutos
    private int numParticipantes;
    private int plazas; 
    private ArrayList<PersonaGimnasio> participantes;

    public Actividad(String nombre, String tipo, int duracion, int plazas) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.duracion = duracion;
        this.plazas = plazas;
        this.numParticipantes = 0;
        this.participantes = new ArrayList<>();
    }

    public boolean agregarParticipante(PersonaGimnasio persona) {
        if (numParticipantes < plazas) {
            participantes.add(persona);
            numParticipantes++;
            return true;
        } else {
            return false;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public int getDuracion() {
        return duracion;
    }

    public int getNumParticipantes() {
        return numParticipantes;
    }

    public int getPlazas() {
        return plazas;
    }

    @Override
    public String toString() {
        return "Actividad [nombre=" + nombre + ", tipo=" + tipo + ", duracion=" + duracion
                + " mins, participantes=" + numParticipantes + "/" + plazas + "]";
    }
}