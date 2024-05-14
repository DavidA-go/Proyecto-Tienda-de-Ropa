package uts.java.proyectobd.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Productos {
    @Id
	@Min(value = 1) //El minimo valor es 1 
	private int codigo;
	@NotBlank(message = "El nombre no puede estar en blanco")
	@Size(min = 3, max = 50)
	private String nombre;
	
	//Relación con Proveedor muchos a uno, enlazado con el campo nitproveedor
	@ManyToOne
	@JoinColumn(name = "nitproveedor")
	private Proveedor nitproveedor;
	private double precio_compra;
	private double iva;
	private double precio_venta;
	
	//Constructores
	public Productos() {
		super();
	}

	public Productos(int codigo, String nombre, Proveedor nitproveedor, double precio_compra, double iva,
			double precio_venta) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.nitproveedor = nitproveedor;
		this.precio_compra = precio_compra;
		this.iva = iva;
		this.precio_venta = precio_venta;
	}

	//Setter and Getter
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Proveedor getNitproveedor() {
		return nitproveedor;
	}

	public void setNitproveedor(Proveedor nitproveedor) {
		this.nitproveedor = nitproveedor;
	}

	public double getPrecio_compra() {
		return precio_compra;
	}

	public void setPrecio_compra(double precio_compra) {
		this.precio_compra = precio_compra;
	}

	public double getIva() {
		return iva;
	}

	public void setIva(double iva) {
		this.iva = iva;
	}

	public double getPrecio_venta() {
		return precio_venta;
	}

	public void setPrecio_venta(double precio_venta) {
		this.precio_venta = precio_venta;
	}

	//toString
	@Override
	public String toString() {
		return "Producto [codigo=" + codigo + ", nombre=" + nombre + ", nitproveedor=" + nitproveedor
				+ ", precio_compra=" + precio_compra + ", iva=" + iva + ", precio_venta=" + precio_venta + "]";
	}
}