package RepasoExamen;

import java.io.Serializable;

public class Alumno implements Serializable {

	private int ID;
	private int nota;

	public Alumno() {

	}

	public Alumno(int iD, int nota) {
		super();
		ID = iD;
		this.nota = nota;
	}

	@Override
	public String toString() {
		return "Alumno [ID=" + ID + ", nota=" + nota + "]";
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

}
