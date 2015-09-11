package modelo.pk;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class F5544330PK implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name="EXDCTO")
	private String exdcto;

	@Column(name="EXDOCO")
	private BigDecimal exdoco;

	@Column(name="EXKCOO")
	private String exkcoo;

	@Column(name="EXLNID")
	private double exlnid;

	public F5544330PK() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getExdcto() {
		return exdcto;
	}

	public void setExdcto(String exdcto) {
		this.exdcto = exdcto;
	}

	public BigDecimal getExdoco() {
		return exdoco;
	}

	public void setExdoco(BigDecimal exdoco) {
		this.exdoco = exdoco;
	}

	public String getExkcoo() {
		return exkcoo;
	}

	public void setExkcoo(String exkcoo) {
		this.exkcoo = exkcoo;
	}

	public double getExlnid() {
		return exlnid;
	}

	public void setExlnid(double exlnid) {
		this.exlnid = exlnid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((exdcto == null) ? 0 : exdcto.hashCode());
		result = prime * result + ((exdoco == null) ? 0 : exdoco.hashCode());
		result = prime * result + ((exkcoo == null) ? 0 : exkcoo.hashCode());
		long temp;
		temp = Double.doubleToLongBits(exlnid);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		F5544330PK other = (F5544330PK) obj;
		if (exdcto == null) {
			if (other.exdcto != null)
				return false;
		} else if (!exdcto.equals(other.exdcto))
			return false;
		if (exdoco == null) {
			if (other.exdoco != null)
				return false;
		} else if (!exdoco.equals(other.exdoco))
			return false;
		if (exkcoo == null) {
			if (other.exkcoo != null)
				return false;
		} else if (!exkcoo.equals(other.exkcoo))
			return false;
		if (Double.doubleToLongBits(exlnid) != Double
				.doubleToLongBits(other.exlnid))
			return false;
		return true;
	}

}
