package modelo.pk;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The primary key class for the F00165 database table.
 * 
 */
@Embeddable
public class F00165PK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="GDOBNM")
	private String gdobnm;

	@Column(name="GDTXKY")
	private String gdtxky;

	@Column(name="GDMOSEQN")
	private long gdmoseqn;

	public F00165PK() {
	}
	public String getGdobnm() {
		return this.gdobnm;
	}
	public void setGdobnm(String gdobnm) {
		this.gdobnm = gdobnm;
	}
	public String getGdtxky() {
		return this.gdtxky;
	}
	public void setGdtxky(String gdtxky) {
		this.gdtxky = gdtxky;
	}
	public long getGdmoseqn() {
		return this.gdmoseqn;
	}
	public void setGdmoseqn(long gdmoseqn) {
		this.gdmoseqn = gdmoseqn;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof F00165PK)) {
			return false;
		}
		F00165PK castOther = (F00165PK)other;
		return 
			this.gdobnm.equals(castOther.gdobnm)
			&& this.gdtxky.equals(castOther.gdtxky)
			&& (this.gdmoseqn == castOther.gdmoseqn);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.gdobnm.hashCode();
		hash = hash * prime + this.gdtxky.hashCode();
		hash = hash * prime + ((int) (this.gdmoseqn ^ (this.gdmoseqn >>> 32)));
		
		return hash;
	}
}