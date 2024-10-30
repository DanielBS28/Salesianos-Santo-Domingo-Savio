
public class Reporte implements Imprimible{

	
	private String mensaje;
	
	public Reporte(String mensaje) {

		this.mensaje = mensaje;
	}
	

	@Override
	public void imprimir() {
		
		System.out.println("Imprimiendo reporte: " + mensaje);
	}


	@Override
	public void imprimir(String mensaje) {
		// TODO Auto-generated method stub
		
	}

	
}
