package Mecanografía;

public class Estadísticas {
	
	private String id;
	private double NotaFácil;
	private int AciertosTeclasF;
	private int ErroresTeclasF;
	private int PPMF;
	private int SegundosRestantesF;
	private int LetralDelTextoF;
	private int TiempoTotalF;

	private double NotaDifícil;
	private int AciertosTeclasD;
	private int ErroresTeclasD;
	private int PPMD;
	private int SegundosRestantesD;
	private int LetralDelTextoD;
	private int TiempoTotalD;
	
	public Estadísticas(String id, double notaFácil, int aciertosTeclasF, int erroresTeclasF, int pPMF,
			int segundosRestantesF, int letralDelTextoF, int tiempoTotalF, double notaDifícil, int aciertosTeclasD,
			int erroresTeclasD, int pPMD, int segundosRestantesD, int letralDelTextoD, int tiempoTotalD) {
		this.id = id;
		NotaFácil = notaFácil;
		AciertosTeclasF = aciertosTeclasF;
		ErroresTeclasF = erroresTeclasF;
		PPMF = pPMF;
		SegundosRestantesF = segundosRestantesF;
		LetralDelTextoF = letralDelTextoF;
		TiempoTotalF = tiempoTotalF;
		NotaDifícil = notaDifícil;
		AciertosTeclasD = aciertosTeclasD;
		ErroresTeclasD = erroresTeclasD;
		PPMD = pPMD;
		SegundosRestantesD = segundosRestantesD;
		LetralDelTextoD = letralDelTextoD;
		TiempoTotalD = tiempoTotalD;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getNotaFácil() {
		return NotaFácil;
	}

	public void setNotaFácil(double notaFácil) {
		NotaFácil = notaFácil;
	}

	public int getAciertosTeclasF() {
		return AciertosTeclasF;
	}

	public void setAciertosTeclasF(int aciertosTeclasF) {
		AciertosTeclasF = aciertosTeclasF;
	}

	public int getErroresTeclasF() {
		return ErroresTeclasF;
	}

	public void setErroresTeclasF(int erroresTeclasF) {
		ErroresTeclasF = erroresTeclasF;
	}

	public int getPPMF() {
		return PPMF;
	}

	public void setPPMF(int pPMF) {
		PPMF = pPMF;
	}

	public int getSegundosRestantesF() {
		return SegundosRestantesF;
	}

	public void setSegundosRestantesF(int segundosRestantesF) {
		SegundosRestantesF = segundosRestantesF;
	}

	public int getLetralDelTextoF() {
		return LetralDelTextoF;
	}

	public void setLetralDelTextoF(int letralDelTextoF) {
		LetralDelTextoF = letralDelTextoF;
	}

	public int getTiempoTotalF() {
		return TiempoTotalF;
	}

	public void setTiempoTotalF(int tiempoTotalF) {
		TiempoTotalF = tiempoTotalF;
	}

	public double getNotaDifícil() {
		return NotaDifícil;
	}

	public void setNotaDifícil(double notaDifícil) {
		NotaDifícil = notaDifícil;
	}

	public int getAciertosTeclasD() {
		return AciertosTeclasD;
	}

	public void setAciertosTeclasD(int aciertosTeclasD) {
		AciertosTeclasD = aciertosTeclasD;
	}

	public int getErroresTeclasD() {
		return ErroresTeclasD;
	}

	public void setErroresTeclasD(int erroresTeclasD) {
		ErroresTeclasD = erroresTeclasD;
	}

	public int getPPMD() {
		return PPMD;
	}

	public void setPPMD(int pPMD) {
		PPMD = pPMD;
	}

	public int getSegundosRestantesD() {
		return SegundosRestantesD;
	}

	public void setSegundosRestantesD(int segundosRestantesD) {
		SegundosRestantesD = segundosRestantesD;
	}

	public int getLetralDelTextoD() {
		return LetralDelTextoD;
	}

	public void setLetralDelTextoD(int letralDelTextoD) {
		LetralDelTextoD = letralDelTextoD;
	}

	public int getTiempoTotalD() {
		return TiempoTotalD;
	}

	public void setTiempoTotalD(int tiempoTotalD) {
		TiempoTotalD = tiempoTotalD;
	}
	
	
	
	

	
	
	
	
	

}
