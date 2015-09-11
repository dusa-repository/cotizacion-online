package modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the detalle_cotizacion database table.
 * 
 */
@Entity
@Table(name="detalle_cotizacion")
@NamedQuery(name="DetalleCotizacion.findAll", query="SELECT d FROM DetalleCotizacion d")
public class DetalleCotizacion implements Serializable {
	private static final long serialVersionUID = 1L;

	private String anexo;

	@Column(name="cantidad_encargada")
	private String cantidadEncargada;

	private String descripcion;

	@Column(name="dias_entrega")
	private String diasEntrega;

	private String estado;

	private String fecha;

	private String hora;

	@Column(name="id_articulo")
	private String idArticulo;

	@Column(name="id_proveedor")
	private String idProveedor;

	@Id
	private int idrow;

	@Column(name="num_cotizacion")
	private int numCotizacion;

	@Column(name="num_linea")
	private int numLinea;

	@Column(name="precio_unitario")
	private String precioUnitario;

	private String um;

	private String usuario;

	public DetalleCotizacion() {
	}

	public String getAnexo() {
		return this.anexo;
	}

	public void setAnexo(String anexo) {
		this.anexo = anexo;
	}

	public String getCantidadEncargada() {
		return this.cantidadEncargada;
	}

	public void setCantidadEncargada(String cantidadEncargada) {
		this.cantidadEncargada = cantidadEncargada;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDiasEntrega() {
		return this.diasEntrega;
	}

	public void setDiasEntrega(String diasEntrega) {
		this.diasEntrega = diasEntrega;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getFecha() {
		return this.fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return this.hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getIdArticulo() {
		return this.idArticulo;
	}

	public void setIdArticulo(String idArticulo) {
		this.idArticulo = idArticulo;
	}

	public String getIdProveedor() {
		return this.idProveedor;
	}

	public void setIdProveedor(String idProveedor) {
		this.idProveedor = idProveedor;
	}

	public int getIdrow() {
		return this.idrow;
	}

	public void setIdrow(int idrow) {
		this.idrow = idrow;
	}

	public int getNumCotizacion() {
		return this.numCotizacion;
	}

	public void setNumCotizacion(int numCotizacion) {
		this.numCotizacion = numCotizacion;
	}

	public int getNumLinea() {
		return this.numLinea;
	}

	public void setNumLinea(int numLinea) {
		this.numLinea = numLinea;
	}

	public String getPrecioUnitario() {
		return this.precioUnitario;
	}

	public void setPrecioUnitario(String precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public String getUm() {
		return this.um;
	}

	public void setUm(String um) {
		this.um = um;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}