
public class Documento implements Imprimible{


	 private String contenido;

	    public Documento(String contenido) {
	        this.contenido = contenido;
	    }


		@Override
		public void imprimir() {
			
		System.out.println("Imprimiendo documento: " + contenido);
			
		}


		@Override
		public void imprimir(String mensaje) {
			// TODO Auto-generated method stub
			
		}

}
