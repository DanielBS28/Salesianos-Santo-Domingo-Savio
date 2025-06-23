package herenciaColegio;

public class Estudiante extends Persona {
	
	private String NIA, curso;
	private double notaMedia;
	
	public Estudiante(String nIA, String curso, double notaMedia) {
		super();
		NIA = nIA;
		this.curso = curso;
		this.notaMedia = notaMedia;
	}

	public Estudiante(String nombre, String direccion,String nIA, String curso, double notaMedia) {
		super(nombre, direccion);
		NIA = nIA;
		this.curso = curso;
		this.notaMedia = notaMedia;
	}

	public String getNIA() {
		return NIA;
	}

	public void setNIA(String nIA) {
		NIA = nIA;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public double getNotaMedia() {
		return notaMedia;
	}

	public void setNotaMedia(double notaMedia) {
		this.notaMedia = notaMedia;
	}

	@Override
	public String toString() {
		return super.toString()+"Estudiante selecionado es: [NIA=" + NIA + ", curso=" + curso + ", notaMedia=" + notaMedia + "]";
	}

}
