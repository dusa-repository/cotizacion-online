package modelo;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;


/**
 * The persistent class for the F0014 database table.
 * 
 */
@Entity
@NamedQuery(name="F0014.findAll", query="SELECT f FROM F0014 f")
public class F0014 implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="PNPTC")
	private String pnptc;

	@Column(name="PNDCD")
	private double pndcd;

	@Column(name="PNDCP")
	private double pndcp;

	@Column(name="PNDDJ")
	private BigDecimal pnddj;

	@Column(name="PNDTPA")
	private double pndtpa;

	@Column(name="PNEIR")
	private double pneir;

	@Column(name="PNJOBN")
	private String pnjobn;

	@Column(name="PNNDTP")
	private double pnndtp;

	@Column(name="PNNSP")
	private double pnnsp;

	@Column(name="PNPID")
	private String pnpid;

	@Column(name="PNPTD")
	private String pnptd;

	@Column(name="PNPXDD")
	private double pnpxdd;

	@Column(name="PNPXDM")
	private double pnpxdm;

	@Column(name="PNUPMJ")
	private BigDecimal pnupmj;

	@Column(name="PNUPMT")
	private double pnupmt;

	@Column(name="PNUSER")
	private String pnuser;

	public F0014() {
	}

	public String getPnptc() {
		return this.pnptc;
	}

	public void setPnptc(String pnptc) {
		this.pnptc = pnptc;
	}

	public double getPndcd() {
		return this.pndcd;
	}

	public void setPndcd(double pndcd) {
		this.pndcd = pndcd;
	}

	public double getPndcp() {
		return this.pndcp;
	}

	public void setPndcp(double pndcp) {
		this.pndcp = pndcp;
	}

	public BigDecimal getPnddj() {
		return this.pnddj;
	}

	public void setPnddj(BigDecimal pnddj) {
		this.pnddj = pnddj;
	}

	public double getPndtpa() {
		return this.pndtpa;
	}

	public void setPndtpa(double pndtpa) {
		this.pndtpa = pndtpa;
	}

	public double getPneir() {
		return this.pneir;
	}

	public void setPneir(double pneir) {
		this.pneir = pneir;
	}

	public String getPnjobn() {
		return this.pnjobn;
	}

	public void setPnjobn(String pnjobn) {
		this.pnjobn = pnjobn;
	}

	public double getPnndtp() {
		return this.pnndtp;
	}

	public void setPnndtp(double pnndtp) {
		this.pnndtp = pnndtp;
	}

	public double getPnnsp() {
		return this.pnnsp;
	}

	public void setPnnsp(double pnnsp) {
		this.pnnsp = pnnsp;
	}

	public String getPnpid() {
		return this.pnpid;
	}

	public void setPnpid(String pnpid) {
		this.pnpid = pnpid;
	}

	public String getPnptd() {
		return this.pnptd;
	}

	public void setPnptd(String pnptd) {
		this.pnptd = pnptd;
	}

	public double getPnpxdd() {
		return this.pnpxdd;
	}

	public void setPnpxdd(double pnpxdd) {
		this.pnpxdd = pnpxdd;
	}

	public double getPnpxdm() {
		return this.pnpxdm;
	}

	public void setPnpxdm(double pnpxdm) {
		this.pnpxdm = pnpxdm;
	}

	public BigDecimal getPnupmj() {
		return this.pnupmj;
	}

	public void setPnupmj(BigDecimal pnupmj) {
		this.pnupmj = pnupmj;
	}

	public double getPnupmt() {
		return this.pnupmt;
	}

	public void setPnupmt(double pnupmt) {
		this.pnupmt = pnupmt;
	}

	public String getPnuser() {
		return this.pnuser;
	}

	public void setPnuser(String pnuser) {
		this.pnuser = pnuser;
	}

}