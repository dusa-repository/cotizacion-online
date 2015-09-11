package modelo;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;

import modelo.pk.F4330PK;


/**
 * The persistent class for the F4330 database table.
 * 
 */
@Entity
@NamedQuery(name="F4330.findAll", query="SELECT f FROM F4330 f")
public class F4330 implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private F4330PK id;

	@Column(name="P0AREL")
	private double p0arel;

	@Column(name="P0PDDJ")
	private BigDecimal p0pddj;

	@Column(name="P0QPRT")
	private String p0qprt;

	@Column(name="P0QRDJ")
	private BigDecimal p0qrdj;

	@Column(name="P0RQQJ")
	private BigDecimal p0rqqj;

	@Column(name="P0RSPO")
	private String p0rspo;

	@Column(name="P0TRDJ")
	private BigDecimal p0trdj;

	@Column(name="P0UREL")
	private double p0urel;

	public F4330() {
	}

	public F4330PK getId() {
		return this.id;
	}

	public void setId(F4330PK id) {
		this.id = id;
	}

	public double getP0arel() {
		return this.p0arel;
	}

	public void setP0arel(double p0arel) {
		this.p0arel = p0arel;
	}

	public BigDecimal getP0pddj() {
		return this.p0pddj;
	}

	public void setP0pddj(BigDecimal p0pddj) {
		this.p0pddj = p0pddj;
	}

	public String getP0qprt() {
		return this.p0qprt;
	}

	public void setP0qprt(String p0qprt) {
		this.p0qprt = p0qprt;
	}

	public BigDecimal getP0qrdj() {
		return this.p0qrdj;
	}

	public void setP0qrdj(BigDecimal p0qrdj) {
		this.p0qrdj = p0qrdj;
	}

	public BigDecimal getP0rqqj() {
		return this.p0rqqj;
	}

	public void setP0rqqj(BigDecimal p0rqqj) {
		this.p0rqqj = p0rqqj;
	}

	public String getP0rspo() {
		return this.p0rspo;
	}

	public void setP0rspo(String p0rspo) {
		this.p0rspo = p0rspo;
	}

	public BigDecimal getP0trdj() {
		return this.p0trdj;
	}

	public void setP0trdj(BigDecimal p0trdj) {
		this.p0trdj = p0trdj;
	}

	public double getP0urel() {
		return this.p0urel;
	}

	public void setP0urel(double p0urel) {
		this.p0urel = p0urel;
	}

}