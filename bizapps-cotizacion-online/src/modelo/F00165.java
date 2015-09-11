package modelo;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;

import modelo.pk.F00165PK;


/**
 * The persistent class for the F00165 database table.
 * 
 */
@Entity
@NamedQuery(name="F00165.findAll", query="SELECT f FROM F00165 f")
public class F00165 implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private F00165PK id;

	@Column(name="GDGTFILENM")
	private String gdgtfilenm;

	@Column(name="GDGTFUTM1")
	private double gdgtfutm1;

	@Column(name="GDGTFUTM2")
	private double gdgtfutm2;

	@Column(name="GDGTFUTS1")
	private String gdgtfuts1;

	@Column(name="GDGTFUTS2")
	private String gdgtfuts2;

	@Column(name="GDGTFUTS3")
	private String gdgtfuts3;

	@Column(name="GDGTFUTS4")
	private String gdgtfuts4;

	@Column(name="GDGTITNM")
	private String gdgtitnm;

	@Column(name="GDGTMOTYPE")
	private BigDecimal gdgtmotype;

	@Column(name="GDLNGP")
	private String gdlngp;

	@Column(name="GDQUNAM")
	private String gdqunam;

	@Column(name="GDTDAY")
	private double gdtday;

	@Column(name="GDTXFT")
	private String gdtxft;

	@Column(name="GDUPMJ")
	private BigDecimal gdupmj;

	@Column(name="GDUSER")
	private String gduser;

	public F00165() {
	}

	public F00165PK getId() {
		return this.id;
	}

	public void setId(F00165PK id) {
		this.id = id;
	}

	public String getGdgtfilenm() {
		return this.gdgtfilenm;
	}

	public void setGdgtfilenm(String gdgtfilenm) {
		this.gdgtfilenm = gdgtfilenm;
	}

	public double getGdgtfutm1() {
		return this.gdgtfutm1;
	}

	public void setGdgtfutm1(double gdgtfutm1) {
		this.gdgtfutm1 = gdgtfutm1;
	}

	public double getGdgtfutm2() {
		return this.gdgtfutm2;
	}

	public void setGdgtfutm2(double gdgtfutm2) {
		this.gdgtfutm2 = gdgtfutm2;
	}

	public String getGdgtfuts1() {
		return this.gdgtfuts1;
	}

	public void setGdgtfuts1(String gdgtfuts1) {
		this.gdgtfuts1 = gdgtfuts1;
	}

	public String getGdgtfuts2() {
		return this.gdgtfuts2;
	}

	public void setGdgtfuts2(String gdgtfuts2) {
		this.gdgtfuts2 = gdgtfuts2;
	}

	public String getGdgtfuts3() {
		return this.gdgtfuts3;
	}

	public void setGdgtfuts3(String gdgtfuts3) {
		this.gdgtfuts3 = gdgtfuts3;
	}

	public String getGdgtfuts4() {
		return this.gdgtfuts4;
	}

	public void setGdgtfuts4(String gdgtfuts4) {
		this.gdgtfuts4 = gdgtfuts4;
	}

	public String getGdgtitnm() {
		return this.gdgtitnm;
	}

	public void setGdgtitnm(String gdgtitnm) {
		this.gdgtitnm = gdgtitnm;
	}

	public BigDecimal getGdgtmotype() {
		return this.gdgtmotype;
	}

	public void setGdgtmotype(BigDecimal gdgtmotype) {
		this.gdgtmotype = gdgtmotype;
	}

	public String getGdlngp() {
		return this.gdlngp;
	}

	public void setGdlngp(String gdlngp) {
		this.gdlngp = gdlngp;
	}

	public String getGdqunam() {
		return this.gdqunam;
	}

	public void setGdqunam(String gdqunam) {
		this.gdqunam = gdqunam;
	}

	public double getGdtday() {
		return this.gdtday;
	}

	public void setGdtday(double gdtday) {
		this.gdtday = gdtday;
	}

	public String getGdtxft() {
		return this.gdtxft;
	}

	public void setGdtxft(String gdtxft) {
		this.gdtxft = gdtxft;
	}

	public BigDecimal getGdupmj() {
		return this.gdupmj;
	}

	public void setGdupmj(BigDecimal gdupmj) {
		this.gdupmj = gdupmj;
	}

	public String getGduser() {
		return this.gduser;
	}

	public void setGduser(String gduser) {
		this.gduser = gduser;
	}

}