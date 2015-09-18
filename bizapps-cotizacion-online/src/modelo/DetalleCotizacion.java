package modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the detalle_cotizacion database table.
 * 
 */
public class DetalleCotizacion implements Serializable {
	private static final long serialVersionUID = 1L;

	private String anexo;

	private Integer cantidadEncargada;

	private String descripcion;

	private String descripcion2;

	private Integer diasEntrega;

	private String estado;

	private Date fecha;

	private String hora;

	private Double idArticulo;

	private Double total;

	private String idProveedor;

	private String moneda;

	private Integer idrow;

	private Integer numCotizacion;

	private Integer numLinea;

	private Double precioUnitario;

	private String um;

	private String usuario;

	private String publicado;

	public DetalleCotizacion() {
	}

	public String getAnexo() {
		return this.anexo;
	}

	public void setAnexo(String anexo) {
		this.anexo = anexo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return this.hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public Double getIdArticulo() {
		return this.idArticulo;
	}

	public void setIdArticulo(Double idArticulo) {
		this.idArticulo = idArticulo;
	}

	public String getIdProveedor() {
		return this.idProveedor;
	}

	public void setIdProveedor(String idProveedor) {
		this.idProveedor = idProveedor;
	}

	public Integer getIdrow() {
		return this.idrow;
	}

	public void setIdrow(Integer idrow) {
		this.idrow = idrow;
	}

	public Integer getNumCotizacion() {
		return this.numCotizacion;
	}

	public void setNumCotizacion(Integer numCotizacion) {
		this.numCotizacion = numCotizacion;
	}

	public Integer getNumLinea() {
		return this.numLinea;
	}

	public void setNumLinea(Integer numLinea) {
		this.numLinea = numLinea;
	}

	public Double getTotal() {
		return total;
	}

	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	public void setTotal(Double total) {
		this.total = total;
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

	public Integer getCantidadEncargada() {
		return cantidadEncargada;
	}

	public void setCantidadEncargada(Integer cantidadEncargada) {
		this.cantidadEncargada = cantidadEncargada;
	}

	public Integer getDiasEntrega() {
		return diasEntrega;
	}

	public void setDiasEntrega(Integer diasEntrega) {
		this.diasEntrega = diasEntrega;
	}

	public Double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(Double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public String getDescripcion2() {
		return descripcion2;
	}

	public void setDescripcion2(String descripcion2) {
		this.descripcion2 = descripcion2;
	}

	public String getPublicado() {
		return publicado;
	}

	public void setPublicado(String publicado) {
		this.publicado = publicado;
	}

}