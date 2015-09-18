package modelo;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;

import modelo.pk.F5544330PK;

/**
 * The persistent class for the F554330 database table.
 * 
 */
@Entity
public class F554330 implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private F5544330PK id;

	@Column(name = "EXBHFU26")
	private String exbhfu26;

	@Column(name = "EXDEL1")
	private String exdel1;

	@Column(name = "EXDEL2")
	private String exdel2;

	@Column(name = "EXDTSE")
	private BigDecimal exdtse;

	@Column(name = "EXFRTH")
	private String exfrth;

	@Column(name = "EXJOBN")
	private String exjobn;

	@Column(name = "EXPID")
	private String expid;

	@Column(name = "EXPTC")
	private String exptc;

	@Column(name = "EXRUPT")
	private BigDecimal exrupt;

	@Column(name = "EXSFXO")
	private String exsfxo;

	@Column(name = "EXSOQS")
	private Double exsoqs;

	@Column(name = "EXSORG")
	private String exsorg;

	@Column(name = "EXSTDS")
	private String exstds;

	@Column(name = "EXSTRNGVAL")
	private String exstrngval;

	@Column(name = "EXUPMJ")
	private BigDecimal exupmj;

	@Column(name = "EXUPMT")
	private BigDecimal exupmt;

	@Column(name = "EXURAB")
	private BigDecimal exurab;

	@Column(name = "EXURAT")
	private Double exurat;

	@Column(name = "EXURCD")
	private String exurcd;

	@Column(name = "EXURDT")
	private BigDecimal exurdt;

	@Column(name = "EXURRF")
	private String exurrf;

	@Column(name = "EXUSER")
	private String exuser;

	public F554330() {
	}

	public String getExbhfu26() {
		return this.exbhfu26;
	}

	public void setExbhfu26(String exbhfu26) {
		this.exbhfu26 = exbhfu26;
	}

	public String getExdel1() {
		return this.exdel1;
	}

	public void setExdel1(String exdel1) {
		this.exdel1 = exdel1;
	}

	public String getExdel2() {
		return this.exdel2;
	}

	public void setExdel2(String exdel2) {
		this.exdel2 = exdel2;
	}

	public BigDecimal getExdtse() {
		return this.exdtse;
	}

	public void setExdtse(BigDecimal exdtse) {
		this.exdtse = exdtse;
	}

	public String getExfrth() {
		return this.exfrth;
	}

	public void setExfrth(String exfrth) {
		this.exfrth = exfrth;
	}

	public String getExjobn() {
		return this.exjobn;
	}

	public void setExjobn(String exjobn) {
		this.exjobn = exjobn;
	}

	public String getExpid() {
		return this.expid;
	}

	public void setExpid(String expid) {
		this.expid = expid;
	}

	public String getExptc() {
		return this.exptc;
	}

	public void setExptc(String exptc) {
		this.exptc = exptc;
	}

	public BigDecimal getExrupt() {
		return this.exrupt;
	}

	public void setExrupt(BigDecimal exrupt) {
		this.exrupt = exrupt;
	}

	public String getExsfxo() {
		return this.exsfxo;
	}

	public void setExsfxo(String exsfxo) {
		this.exsfxo = exsfxo;
	}

	public Double getExsoqs() {
		return this.exsoqs;
	}

	public void setExsoqs(Double exsoqs) {
		this.exsoqs = exsoqs;
	}

	public String getExsorg() {
		return this.exsorg;
	}

	public void setExsorg(String exsorg) {
		this.exsorg = exsorg;
	}

	public String getExstds() {
		return this.exstds;
	}

	public void setExstds(String exstds) {
		this.exstds = exstds;
	}

	public String getExstrngval() {
		return this.exstrngval;
	}

	public void setExstrngval(String exstrngval) {
		this.exstrngval = exstrngval;
	}

	public BigDecimal getExupmj() {
		return this.exupmj;
	}

	public void setExupmj(BigDecimal exupmj) {
		this.exupmj = exupmj;
	}

	public BigDecimal getExupmt() {
		return this.exupmt;
	}

	public void setExupmt(BigDecimal exupmt) {
		this.exupmt = exupmt;
	}

	public BigDecimal getExurab() {
		return this.exurab;
	}

	public void setExurab(BigDecimal exurab) {
		this.exurab = exurab;
	}

	public Double getExurat() {
		return this.exurat;
	}

	public void setExurat(Double exurat) {
		this.exurat = exurat;
	}

	public String getExurcd() {
		return this.exurcd;
	}

	public void setExurcd(String exurcd) {
		this.exurcd = exurcd;
	}

	public BigDecimal getExurdt() {
		return this.exurdt;
	}

	public void setExurdt(BigDecimal exurdt) {
		this.exurdt = exurdt;
	}

	public String getExurrf() {
		return this.exurrf;
	}

	public void setExurrf(String exurrf) {
		this.exurrf = exurrf;
	}

	public String getExuser() {
		return this.exuser;
	}

	public void setExuser(String exuser) {
		this.exuser = exuser;
	}

	public F5544330PK getId() {
		return id;
	}

	public void setId(F5544330PK id) {
		this.id = id;
	}

}