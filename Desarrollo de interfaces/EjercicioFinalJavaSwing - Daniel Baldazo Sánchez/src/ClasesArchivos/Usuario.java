package ClasesArchivos;

public class Usuario {
	
	/**
	 * Esta es la clase usuario donde guardamos los atributos de cada persona
	 * **/
	
	private String alias;
	private String nombre;
	private String contrasena;
	private String correo;
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	@Override
	public String toString() {
		return "Usuario [alias=" + alias + ", nombre=" + nombre + ", contrasena=" + contrasena + ", correo=" + correo
				+ "]";
	}
	public Usuario(String alias, String nombre, String contrasena, String correo) {
		super();
		this.alias = alias;
		this.nombre = nombre;
		this.contrasena = contrasena;
		this.correo = correo;
	}
	
	
	
	
	
	
	
	


}
