package ejercicio1;

import java.io.Serializable;

public class Alumno implements Serializable{
	
	private String nombre;
	private int notaMedia;
	private int curso;
	
	public Alumno(String nombre, int notaMedia, int curso) {
		super();
		this.nombre = nombre;
		this.notaMedia = notaMedia;
		this.curso = curso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNotaMedia() {
		return notaMedia;
	}

	public void setNotaMedia(int notaMedia) {
		this.notaMedia = notaMedia;
	}

	public int getCurso() {
		return curso;
	}

	public void setCurso(int curso) {
		this.curso = curso;
	}

	@Override
	public String toString() {
		return "nombre:" + nombre + ", Nota:" + notaMedia + ", Curso:" + curso;
	}
	
	

}
