package modelo;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;

import org.hibernate.annotations.Type;

import modelo.pk.F4331PK;


/**
 * The persistent class for the F4331 database table.
 * 
 */
@Entity
@NamedQuery(name="F4331.findAll", query="SELECT f FROM F4331 f")
public class F4331 implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private F4331PK id;

	@Column(name="P1CNDJ")
	private BigDecimal p1cndj;

	@Column(name="P1CRCD")
	private String p1crcd;

	@Column(name="P1PDDJ")
	private BigDecimal p1pddj;

	@Column(name="P1PRRC")
	private Double p1prrc;

	@Column(name="P1QRDJ")
	private BigDecimal p1qrdj;

	@Column(name="PUBLICADO")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private Boolean publicado;

	public F4331() {
	}

	public F4331PK getId() {
		return this.id;
	}

	public void setId(F4331PK id) {
		this.id = id;
	}

	public BigDecimal getP1cndj() {
		return this.p1cndj;
	}

	public void setP1cndj(BigDecimal p1cndj) {
		this.p1cndj = p1cndj;
	}

	public String getP1crcd() {
		return this.p1crcd;
	}

	public void setP1crcd(String p1crcd) {
		this.p1crcd = p1crcd;
	}

	public BigDecimal getP1pddj() {
		return this.p1pddj;
	}

	public void setP1pddj(BigDecimal p1pddj) {
		this.p1pddj = p1pddj;
	}

	public Double getP1prrc() {
		return this.p1prrc;
	}

	public void setP1prrc(Double p1prrc) {
		this.p1prrc = p1prrc;
	}

	public BigDecimal getP1qrdj() {
		return this.p1qrdj;
	}

	public void setP1qrdj(BigDecimal p1qrdj) {
		this.p1qrdj = p1qrdj;
	}

	public Boolean getPublicado() {
		return this.publicado;
	}

	public void setPublicado(Boolean publicado) {
		this.publicado = publicado;
	}

}