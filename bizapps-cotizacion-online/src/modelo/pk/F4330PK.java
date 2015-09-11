package modelo.pk;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The primary key class for the F4330 database table.
 * 
 */
@Embeddable
public class F4330PK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="P0DOCO")
	private double p0doco;

	@Column(name="P0DCTO")
	private String p0dcto;

	@Column(name="P0KCOO")
	private String p0kcoo;

	@Column(name="P0SFXO")
	private String p0sfxo;

	@Column(name="P0LNID")
	private double p0lnid;

	@Column(name="P0AN8")
	private double p0an8;

	public F4330PK() {
	}
	public double getP0doco() {
		return this.p0doco;
	}
	public void setP0doco(double p0doco) {
		this.p0doco = p0doco;
	}
	public String getP0dcto() {
		return this.p0dcto;
	}
	public void setP0dcto(String p0dcto) {
		this.p0dcto = p0dcto;
	}
	public String getP0kcoo() {
		return this.p0kcoo;
	}
	public void setP0kcoo(String p0kcoo) {
		this.p0kcoo = p0kcoo;
	}
	public String getP0sfxo() {
		return this.p0sfxo;
	}
	public void setP0sfxo(String p0sfxo) {
		this.p0sfxo = p0sfxo;
	}
	public double getP0lnid() {
		return this.p0lnid;
	}
	public void setP0lnid(double p0lnid) {
		this.p0lnid = p0lnid;
	}
	public double getP0an8() {
		return this.p0an8;
	}
	public void setP0an8(double p0an8) {
		this.p0an8 = p0an8;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof F4330PK)) {
			return false;
		}
		F4330PK castOther = (F4330PK)other;
		return 
			(this.p0doco == castOther.p0doco)
			&& this.p0dcto.equals(castOther.p0dcto)
			&& this.p0kcoo.equals(castOther.p0kcoo)
			&& this.p0sfxo.equals(castOther.p0sfxo)
			&& (this.p0lnid == castOther.p0lnid)
			&& (this.p0an8 == castOther.p0an8);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (java.lang.Double.doubleToLongBits(this.p0doco) ^ (java.lang.Double.doubleToLongBits(this.p0doco) >>> 32)));
		hash = hash * prime + this.p0dcto.hashCode();
		hash = hash * prime + this.p0kcoo.hashCode();
		hash = hash * prime + this.p0sfxo.hashCode();
		hash = hash * prime + ((int) (java.lang.Double.doubleToLongBits(this.p0lnid) ^ (java.lang.Double.doubleToLongBits(this.p0lnid) >>> 32)));
		hash = hash * prime + ((int) (java.lang.Double.doubleToLongBits(this.p0an8) ^ (java.lang.Double.doubleToLongBits(this.p0an8) >>> 32)));
		
		return hash;
	}
}