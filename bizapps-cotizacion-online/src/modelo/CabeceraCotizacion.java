package modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the cabecera_cotizacion database table.
 * 
 */
@Entity
@Table(name="cabecera_cotizacion")
@NamedQuery(name="CabeceraCotizacion.findAll", query="SELECT c FROM CabeceraCotizacion c")
public class CabeceraCotizacion implements Serializable {
	private static final long serialVersionUID = 1L;

	private String estado;

	@Column(name="fecha_emision")
	private String fechaEmision;

	@Column(name="fecha_vencimiento")
	private String fechaVencimiento;

	@Column(name="id_proveedor")
	private String idProveedor;

	@Id
	private int idrow;

	@Column(name="num_cotizacion")
	private String numCotizacion;

	private String responsable;

	public CabeceraCotizacion() {
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getFechaEmision() {
		return this.fechaEmision;
	}

	public void setFechaEmision(String fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public String getFechaVencimiento() {
		return this.fechaVencimiento;
	}

	public void setFechaVencimiento(String fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
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

	public String getNumCotizacion() {
		return this.numCotizacion;
	}

	public void setNumCotizacion(String numCotizacion) {
		this.numCotizacion = numCotizacion;
	}

	public String getResponsable() {
		return this.responsable;
	}

	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}

}