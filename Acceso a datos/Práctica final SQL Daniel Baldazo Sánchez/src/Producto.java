
public class Producto {
	
	private int idProducto;
	private String nombre;
	private double precioUnitario;
	private int stock;
	public int getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecioUnitario() {
		return precioUnitario;
	}
	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	@Override
	public String toString() {
		return "ID: " +idProducto +" | " + nombre +" | Precio unitario: " + precioUnitario+ "€ | Stock: " + stock;
	}
	public Producto(int idProducto, String nombre, double precioUnitario, int stock) {
		super();
		this.idProducto = idProducto;
		this.nombre = nombre;
		this.precioUnitario = precioUnitario;
		this.stock = stock;
	}
	
	

}
