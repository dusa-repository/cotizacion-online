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

public class CabeceraCotizacion implements Serializable {
	private static final long serialVersionUID = 1L;

	private String estado;

	private String fechaEmision;

	private String fechaVencimiento;

	private String idProveedor;

	private int idrow;

	private String numCotizacion;

	private String responsable;

	private Long diasEntrega;

	private String anexo;

	private String publicado;

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

	public Long getDiasEntrega() {
		return diasEntrega;
	}

	public void setDiasEntrega(Long diasEntrega) {
		this.diasEntrega = diasEntrega;
	}

	public String getAnexo() {
		return anexo;
	}

	public void setAnexo(String anexo) {
		this.anexo = anexo;
	}

	public String mostrarEstado() {
		if (estado != null)
			if (estado.equals("PENDIENTE"))
				return "NO RESPONDIDA";
			else
				return estado;
		return "N/A";
	}

	public String getPublicado() {
		return publicado;
	}

	public void setPublicado(String publicado) {
		this.publicado = publicado;
	}

}