package modelo.pk;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The primary key class for the F4331 database table.
 * 
 */
@Embeddable
public class F4331PK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="P1DOCO")
	private double p1doco;

	@Column(name="P1DCTO")
	private String p1dcto;

	@Column(name="P1KCOO")
	private String p1kcoo;

	@Column(name="P1SFXO")
	private String p1sfxo;

	@Column(name="P1AN8")
	private double p1an8;

	@Column(name="P1LNID")
	private double p1lnid;

	@Column(name="P1UORG")
	private double p1uorg;

	public F4331PK() {
	}
	public double getP1doco() {
		return this.p1doco;
	}
	public void setP1doco(double p1doco) {
		this.p1doco = p1doco;
	}
	public String getP1dcto() {
		return this.p1dcto;
	}
	public void setP1dcto(String p1dcto) {
		this.p1dcto = p1dcto;
	}
	public String getP1kcoo() {
		return this.p1kcoo;
	}
	public void setP1kcoo(String p1kcoo) {
		this.p1kcoo = p1kcoo;
	}
	public String getP1sfxo() {
		return this.p1sfxo;
	}
	public void setP1sfxo(String p1sfxo) {
		this.p1sfxo = p1sfxo;
	}
	public double getP1an8() {
		return this.p1an8;
	}
	public void setP1an8(double p1an8) {
		this.p1an8 = p1an8;
	}
	public double getP1lnid() {
		return this.p1lnid;
	}
	public void setP1lnid(double p1lnid) {
		this.p1lnid = p1lnid;
	}
	public double getP1uorg() {
		return this.p1uorg;
	}
	public void setP1uorg(double p1uorg) {
		this.p1uorg = p1uorg;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof F4331PK)) {
			return false;
		}
		F4331PK castOther = (F4331PK)other;
		return 
			(this.p1doco == castOther.p1doco)
			&& this.p1dcto.equals(castOther.p1dcto)
			&& this.p1kcoo.equals(castOther.p1kcoo)
			&& this.p1sfxo.equals(castOther.p1sfxo)
			&& (this.p1an8 == castOther.p1an8)
			&& (this.p1lnid == castOther.p1lnid)
			&& (this.p1uorg == castOther.p1uorg);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (java.lang.Double.doubleToLongBits(this.p1doco) ^ (java.lang.Double.doubleToLongBits(this.p1doco) >>> 32)));
		hash = hash * prime + this.p1dcto.hashCode();
		hash = hash * prime + this.p1kcoo.hashCode();
		hash = hash * prime + this.p1sfxo.hashCode();
		hash = hash * prime + ((int) (java.lang.Double.doubleToLongBits(this.p1an8) ^ (java.lang.Double.doubleToLongBits(this.p1an8) >>> 32)));
		hash = hash * prime + ((int) (java.lang.Double.doubleToLongBits(this.p1lnid) ^ (java.lang.Double.doubleToLongBits(this.p1lnid) >>> 32)));
		hash = hash * prime + ((int) (java.lang.Double.doubleToLongBits(this.p1uorg) ^ (java.lang.Double.doubleToLongBits(this.p1uorg) >>> 32)));
		
		return hash;
	}
}