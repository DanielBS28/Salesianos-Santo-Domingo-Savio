package NodosJorge;

public class Cliente {
	
	  private int numeroDeCliente;
	    private String nombre;
	    private String calle;
	    private String ciudad;
	    private String codigoPostal;
	    private String pais;
		public int getNumeroDeCliente() {
			return numeroDeCliente;
		}
		public void setNumeroDeCliente(int numeroDeCliente) {
			this.numeroDeCliente = numeroDeCliente;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public String getCalle() {
			return calle;
		}
		public void setCalle(String calle) {
			this.calle = calle;
		}
		public String getCiudad() {
			return ciudad;
		}
		public void setCiudad(String ciudad) {
			this.ciudad = ciudad;
		}
		public String getCodigoPostal() {
			return codigoPostal;
		}
		public void setCodigoPostal(String codigoPostal) {
			this.codigoPostal = codigoPostal;
		}
		public String getPais() {
			return pais;
		}
		public void setPais(String pais) {
			this.pais = pais;
		}
		@Override
		public String toString() {
			return "Cliente [numeroDeCliente=" + numeroDeCliente + ", nombre=" + nombre + ", calle=" + calle
					+ ", ciudad=" + ciudad + ", codigoPostal=" + codigoPostal + ", pais=" + pais + "]";
		}
		public Cliente(int numeroDeCliente, String nombre, String calle, String ciudad, String codigoPostal,
				String pais) {
			super();
			this.numeroDeCliente = numeroDeCliente;
			this.nombre = nombre;
			this.calle = calle;
			this.ciudad = ciudad;
			this.codigoPostal = codigoPostal;
			this.pais = pais;
		}
	    
	    

}
