package FicherosBinarios;

import java.io.*;
import java.util.ArrayList;

public class Gimnasio {
    private ArrayList<Actividad> actividades;
    private ArrayList<PersonaGimnasio> personas;

    public Gimnasio() {
        actividades = new ArrayList<>();
        personas = new ArrayList<>();
    }

    public void agregarActividad(Actividad actividad) {
        actividades.add(actividad);
    }

    public void agregarPersona(PersonaGimnasio persona) {
        personas.add(persona);
    }

    public boolean inscribirPersonaEnActividad(PersonaGimnasio persona, String nombreActividad) {
        for (Actividad actividad : actividades) {
            if (actividad.getNombre().equalsIgnoreCase(nombreActividad)) {
                if (actividad.agregarParticipante(persona)) {
                    System.out.println("Inscripción exitosa de " + persona.getNombre() + " en " + actividad.getNombre());
                    return true;
                } else {
                    System.out.println("No hay plazas disponibles en " + actividad.getNombre());
                    return false;
                }
            }
        }
        System.out.println("Actividad no encontrada: " + nombreActividad);
        return false;
    }

    public void guardarDatos(String nombreArchivo) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            oos.writeObject(actividades);
            oos.writeObject(personas);
            System.out.println("Datos guardados en " + nombreArchivo);
        }
    }

  
    public void cargarDatos(String nombreArchivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            actividades = (ArrayList<Actividad>) ois.readObject();
            personas = (ArrayList<PersonaGimnasio>) ois.readObject();
            System.out.println("Datos cargados desde " + nombreArchivo);
        }
    }

    public void mostrarActividades() {
        for (Actividad actividad : actividades) {
            System.out.println(actividad);
        }
    }

    public void mostrarPersonas() {
        for (PersonaGimnasio persona : personas) {
            System.out.println(persona);
        }
    }

    public static void main(String[] args) {
        Gimnasio gimnasio = new Gimnasio();

        PersonaGimnasio p1 = new PersonaGimnasio("Juan", 50.0);
        PersonaGimnasio p2 = new PersonaGimnasio("Ana", 45.0);

        Actividad a1 = new Actividad("Yoga", "Relajación", 60, 5);
        Actividad a2 = new Actividad("Spinning", "Cardio", 45, 3);

        gimnasio.agregarPersona(p1);
        gimnasio.agregarPersona(p2);
        gimnasio.agregarActividad(a1);
        gimnasio.agregarActividad(a2);

        gimnasio.inscribirPersonaEnActividad(p1, "Yoga");
        gimnasio.inscribirPersonaEnActividad(p2, "Spinning");

        try {
            gimnasio.guardarDatos("gimnasio.dat");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            gimnasio.cargarDatos("gimnasio.dat");
            gimnasio.mostrarActividades();
            gimnasio.mostrarPersonas();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}