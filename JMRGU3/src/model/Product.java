package model;

public class Product {
	private int id;
	private float precio;
	private String descripcion;
	private int existencia;
	private String proveedor;
	
	public Product(int id, float precio, String descripcion, int existencia, String proveedor) {
		super();
		this.id = id;
		this.precio = precio;
		this.descripcion = descripcion;
		this.existencia = existencia;
		this.proveedor = proveedor;
	}

	public Product() {
		this(0, 0, "",0,"");
	}
	
	/**
	 * @return the idProducto
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param idProducto the idProducto to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the precio
	 */
	public float getPrecio() {
		return precio;
	}

	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(float precio) {
		this.precio = precio;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the existencia
	 */
	public int getExistencia() {
		return existencia;
	}

	/**
	 * @param existencia the existencia to set
	 */
	public void setExistencia(int existencia) {
		this.existencia = existencia;
	}

	/**
	 * @return the proveedor
	 */
	public String getProveedor() {
		return proveedor;
	}

	/**
	 * @param proveedor the proveedor to set
	 */
	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Product [id=" + id + ", precio=" + precio + ", descripcion=" + descripcion
				+ ", existencia=" + existencia + ", proveedor=" + proveedor + "]";
	}
	
	
	
	
	
}
