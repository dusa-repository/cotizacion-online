package modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;

import modelo.pk.F4301PK;


/**
 * The persistent class for the F4301 database table.
 * 
 */
@Entity
@NamedQuery(name="F4301.findAll", query="SELECT f FROM F4301 f")
public class F4301 implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private F4301PK id;

	@Column(name="PHADDJ")
	private BigDecimal phaddj;

	@Column(name="PHAN8")
	private double phan8;

	@Column(name="PHANBY")
	private double phanby;

	@Column(name="PHANCR")
	private double phancr;

	@Column(name="PHARTG")
	private String phartg;

	@Column(name="PHASN")
	private String phasn;

	@Column(name="PHATXT")
	private String phatxt;

	@Column(name="PHAVCH")
	private String phavch;

	@Column(name="PHBCRC")
	private String phbcrc;

	@Column(name="PHCLASS01")
	private String phclass01;

	@Column(name="PHCLASS02")
	private String phclass02;

	@Column(name="PHCLASS03")
	private String phclass03;

	@Column(name="PHCLASS04")
	private String phclass04;

	@Column(name="PHCLASS05")
	private String phclass05;

	@Column(name="PHCNDJ")
	private BigDecimal phcndj;

	@Column(name="PHCNID")
	private String phcnid;

	@Column(name="PHCORD")
	private double phcord;

	@Column(name="PHCOT")
	private String phcot;

	@Column(name="PHCRCD")
	private String phcrcd;

	@Column(name="PHCRMD")
	private String phcrmd;

	@Column(name="PHCRR")
	private double phcrr;

	@Column(name="PHCRRM")
	private String phcrrm;

	@Column(name="PHCUKID")
	private double phcukid;

	@Column(name="PHDCT4")
	private String phdct4;

	@Column(name="PHDEL1")
	private String phdel1;

	@Column(name="PHDEL2")
	private String phdel2;

	@Column(name="PHDESC")
	private String phdesc;

	@Column(name="PHDOC1")
	private double phdoc1;

	@Column(name="PHDRQJ")
	private BigDecimal phdrqj;

	@Column(name="PHDRQT")
	private double phdrqt;

	@Column(name="PHEXR1")
	private String phexr1;

	@Column(name="PHFAP")
	private double phfap;

	@Column(name="PHFRTC")
	private String phfrtc;

	@Column(name="PHFRTH")
	private String phfrth;

	@Column(name="PHFUF1")
	private String phfuf1;

	@Column(name="PHFUF2")
	private String phfuf2;

	@Column(name="PHHOLD")
	private String phhold;

	@Column(name="PHINMG")
	private String phinmg;

	@Column(name="PHINVC")
	private double phinvc;

	@Column(name="PHJOBN")
	private String phjobn;

	@Column(name="PHLGCT")
	private String phlgct;

	@Column(name="PHLNGP")
	private String phlngp;

	@Column(name="PHMATY")
	private String phmaty;

	@Column(name="PHMCU")
	private String phmcu;

	@Column(name="PHMKFR")
	private double phmkfr;

	@Column(name="PHMOT")
	private String phmot;

	@Column(name="PHNTR")
	private String phntr;

	@Column(name="PHOCTO")
	private String phocto;

	@Column(name="PHOKCO")
	private String phokco;

	@Column(name="PHOORN")
	private String phoorn;

	@Column(name="PHOPDJ")
	private BigDecimal phopdj;

	@Column(name="PHORBY")
	private String phorby;

	@Column(name="PHOSTS")
	private String phosts;

	@Column(name="PHOTOT")
	private double photot;

	@Column(name="PHPCRT")
	private double phpcrt;

	@Column(name="PHPDDJ")
	private BigDecimal phpddj;

	@Column(name="PHPEFJ")
	private BigDecimal phpefj;

	@Column(name="PHPID")
	private String phpid;

	@Column(name="PHPOHAB01")
	private double phpohab01;

	@Column(name="PHPOHAB02")
	private double phpohab02;

	@Column(name="PHPOHC01")
	private String phpohc01;

	@Column(name="PHPOHC02")
	private String phpohc02;

	@Column(name="PHPOHC03")
	private String phpohc03;

	@Column(name="PHPOHC04")
	private String phpohc04;

	@Column(name="PHPOHC05")
	private String phpohc05;

	@Column(name="PHPOHC06")
	private String phpohc06;

	@Column(name="PHPOHC07")
	private String phpohc07;

	@Column(name="PHPOHC08")
	private String phpohc08;

	@Column(name="PHPOHC09")
	private String phpohc09;

	@Column(name="PHPOHC10")
	private String phpohc10;

	@Column(name="PHPOHC11")
	private String phpohc11;

	@Column(name="PHPOHC12")
	private String phpohc12;

	@Column(name="PHPOHD01")
	private BigDecimal phpohd01;

	@Column(name="PHPOHD02")
	private BigDecimal phpohd02;

	@Column(name="PHPOHP01")
	private String phpohp01;

	@Column(name="PHPOHP02")
	private String phpohp02;

	@Column(name="PHPOHP03")
	private String phpohp03;

	@Column(name="PHPOHP04")
	private String phpohp04;

	@Column(name="PHPOHP05")
	private String phpohp05;

	@Column(name="PHPOHP06")
	private String phpohp06;

	@Column(name="PHPOHP07")
	private String phpohp07;

	@Column(name="PHPOHP08")
	private String phpohp08;

	@Column(name="PHPOHP09")
	private String phpohp09;

	@Column(name="PHPOHP10")
	private String phpohp10;

	@Column(name="PHPOHP11")
	private String phpohp11;

	@Column(name="PHPOHP12")
	private String phpohp12;

	@Column(name="PHPOHP13")
	private String phpohp13;

	@Column(name="PHPOHU01")
	private Timestamp phpohu01;

	@Column(name="PHPOHU02")
	private Timestamp phpohu02;

	@Column(name="PHPPDJ")
	private BigDecimal phppdj;

	@Column(name="PHPRGP")
	private String phprgp;

	@Column(name="PHPROM")
	private String phprom;

	@Column(name="PHPRP5")
	private String phprp5;

	@Column(name="PHPRPY")
	private String phprpy;

	@Column(name="PHPSDJ")
	private BigDecimal phpsdj;

	@Column(name="PHPTC")
	private String phptc;

	@Column(name="PHPURG")
	private String phpurg;

	@Column(name="PHRCD")
	private String phrcd;

	@Column(name="PHRCTO")
	private String phrcto;

	@Column(name="PHRETI")
	private String phreti;

	@Column(name="PHRKCO")
	private String phrkco;

	@Column(name="PHRMK")
	private String phrmk;

	@Column(name="PHRORN")
	private String phrorn;

	@Column(name="PHRSHT")
	private double phrsht;

	@Column(name="PHRTNR")
	private String phrtnr;

	@Column(name="PHSHAN")
	private double phshan;

	@Column(name="PHTDAY")
	private double phtday;

	@Column(name="PHTKBY")
	private String phtkby;

	@Column(name="PHTRDJ")
	private BigDecimal phtrdj;

	@Column(name="PHTXA1")
	private String phtxa1;

	@Column(name="PHTXCT")
	private String phtxct;

	@Column(name="PHUPMJ")
	private BigDecimal phupmj;

	@Column(name="PHURAB")
	private double phurab;

	@Column(name="PHURAT")
	private double phurat;

	@Column(name="PHURCD")
	private String phurcd;

	@Column(name="PHURDT")
	private BigDecimal phurdt;

	@Column(name="PHURRF")
	private String phurrf;

	@Column(name="PHUSER")
	private String phuser;

	@Column(name="PHVR01")
	private String phvr01;

	@Column(name="PHVR02")
	private String phvr02;

	@Column(name="PHVUMD")
	private String phvumd;

	@Column(name="PHWUMD")
	private String phwumd;

	@Column(name="PHZON")
	private String phzon;

	public F4301() {
	}

	public F4301PK getId() {
		return this.id;
	}

	public void setId(F4301PK id) {
		this.id = id;
	}

	public BigDecimal getPhaddj() {
		return this.phaddj;
	}

	public void setPhaddj(BigDecimal phaddj) {
		this.phaddj = phaddj;
	}

	public double getPhan8() {
		return this.phan8;
	}

	public void setPhan8(double phan8) {
		this.phan8 = phan8;
	}

	public double getPhanby() {
		return this.phanby;
	}

	public void setPhanby(double phanby) {
		this.phanby = phanby;
	}

	public double getPhancr() {
		return this.phancr;
	}

	public void setPhancr(double phancr) {
		this.phancr = phancr;
	}

	public String getPhartg() {
		return this.phartg;
	}

	public void setPhartg(String phartg) {
		this.phartg = phartg;
	}

	public String getPhasn() {
		return this.phasn;
	}

	public void setPhasn(String phasn) {
		this.phasn = phasn;
	}

	public String getPhatxt() {
		return this.phatxt;
	}

	public void setPhatxt(String phatxt) {
		this.phatxt = phatxt;
	}

	public String getPhavch() {
		return this.phavch;
	}

	public void setPhavch(String phavch) {
		this.phavch = phavch;
	}

	public String getPhbcrc() {
		return this.phbcrc;
	}

	public void setPhbcrc(String phbcrc) {
		this.phbcrc = phbcrc;
	}

	public String getPhclass01() {
		return this.phclass01;
	}

	public void setPhclass01(String phclass01) {
		this.phclass01 = phclass01;
	}

	public String getPhclass02() {
		return this.phclass02;
	}

	public void setPhclass02(String phclass02) {
		this.phclass02 = phclass02;
	}

	public String getPhclass03() {
		return this.phclass03;
	}

	public void setPhclass03(String phclass03) {
		this.phclass03 = phclass03;
	}

	public String getPhclass04() {
		return this.phclass04;
	}

	public void setPhclass04(String phclass04) {
		this.phclass04 = phclass04;
	}

	public String getPhclass05() {
		return this.phclass05;
	}

	public void setPhclass05(String phclass05) {
		this.phclass05 = phclass05;
	}

	public BigDecimal getPhcndj() {
		return this.phcndj;
	}

	public void setPhcndj(BigDecimal phcndj) {
		this.phcndj = phcndj;
	}

	public String getPhcnid() {
		return this.phcnid;
	}

	public void setPhcnid(String phcnid) {
		this.phcnid = phcnid;
	}

	public double getPhcord() {
		return this.phcord;
	}

	public void setPhcord(double phcord) {
		this.phcord = phcord;
	}

	public String getPhcot() {
		return this.phcot;
	}

	public void setPhcot(String phcot) {
		this.phcot = phcot;
	}

	public String getPhcrcd() {
		return this.phcrcd;
	}

	public void setPhcrcd(String phcrcd) {
		this.phcrcd = phcrcd;
	}

	public String getPhcrmd() {
		return this.phcrmd;
	}

	public void setPhcrmd(String phcrmd) {
		this.phcrmd = phcrmd;
	}

	public double getPhcrr() {
		return this.phcrr;
	}

	public void setPhcrr(double phcrr) {
		this.phcrr = phcrr;
	}

	public String getPhcrrm() {
		return this.phcrrm;
	}

	public void setPhcrrm(String phcrrm) {
		this.phcrrm = phcrrm;
	}

	public double getPhcukid() {
		return this.phcukid;
	}

	public void setPhcukid(double phcukid) {
		this.phcukid = phcukid;
	}

	public String getPhdct4() {
		return this.phdct4;
	}

	public void setPhdct4(String phdct4) {
		this.phdct4 = phdct4;
	}

	public String getPhdel1() {
		return this.phdel1;
	}

	public void setPhdel1(String phdel1) {
		this.phdel1 = phdel1;
	}

	public String getPhdel2() {
		return this.phdel2;
	}

	public void setPhdel2(String phdel2) {
		this.phdel2 = phdel2;
	}

	public String getPhdesc() {
		return this.phdesc;
	}

	public void setPhdesc(String phdesc) {
		this.phdesc = phdesc;
	}

	public double getPhdoc1() {
		return this.phdoc1;
	}

	public void setPhdoc1(double phdoc1) {
		this.phdoc1 = phdoc1;
	}

	public BigDecimal getPhdrqj() {
		return this.phdrqj;
	}

	public void setPhdrqj(BigDecimal phdrqj) {
		this.phdrqj = phdrqj;
	}

	public double getPhdrqt() {
		return this.phdrqt;
	}

	public void setPhdrqt(double phdrqt) {
		this.phdrqt = phdrqt;
	}

	public String getPhexr1() {
		return this.phexr1;
	}

	public void setPhexr1(String phexr1) {
		this.phexr1 = phexr1;
	}

	public double getPhfap() {
		return this.phfap;
	}

	public void setPhfap(double phfap) {
		this.phfap = phfap;
	}

	public String getPhfrtc() {
		return this.phfrtc;
	}

	public void setPhfrtc(String phfrtc) {
		this.phfrtc = phfrtc;
	}

	public String getPhfrth() {
		return this.phfrth;
	}

	public void setPhfrth(String phfrth) {
		this.phfrth = phfrth;
	}

	public String getPhfuf1() {
		return this.phfuf1;
	}

	public void setPhfuf1(String phfuf1) {
		this.phfuf1 = phfuf1;
	}

	public String getPhfuf2() {
		return this.phfuf2;
	}

	public void setPhfuf2(String phfuf2) {
		this.phfuf2 = phfuf2;
	}

	public String getPhhold() {
		return this.phhold;
	}

	public void setPhhold(String phhold) {
		this.phhold = phhold;
	}

	public String getPhinmg() {
		return this.phinmg;
	}

	public void setPhinmg(String phinmg) {
		this.phinmg = phinmg;
	}

	public double getPhinvc() {
		return this.phinvc;
	}

	public void setPhinvc(double phinvc) {
		this.phinvc = phinvc;
	}

	public String getPhjobn() {
		return this.phjobn;
	}

	public void setPhjobn(String phjobn) {
		this.phjobn = phjobn;
	}

	public String getPhlgct() {
		return this.phlgct;
	}

	public void setPhlgct(String phlgct) {
		this.phlgct = phlgct;
	}

	public String getPhlngp() {
		return this.phlngp;
	}

	public void setPhlngp(String phlngp) {
		this.phlngp = phlngp;
	}

	public String getPhmaty() {
		return this.phmaty;
	}

	public void setPhmaty(String phmaty) {
		this.phmaty = phmaty;
	}

	public String getPhmcu() {
		return this.phmcu;
	}

	public void setPhmcu(String phmcu) {
		this.phmcu = phmcu;
	}

	public double getPhmkfr() {
		return this.phmkfr;
	}

	public void setPhmkfr(double phmkfr) {
		this.phmkfr = phmkfr;
	}

	public String getPhmot() {
		return this.phmot;
	}

	public void setPhmot(String phmot) {
		this.phmot = phmot;
	}

	public String getPhntr() {
		return this.phntr;
	}

	public void setPhntr(String phntr) {
		this.phntr = phntr;
	}

	public String getPhocto() {
		return this.phocto;
	}

	public void setPhocto(String phocto) {
		this.phocto = phocto;
	}

	public String getPhokco() {
		return this.phokco;
	}

	public void setPhokco(String phokco) {
		this.phokco = phokco;
	}

	public String getPhoorn() {
		return this.phoorn;
	}

	public void setPhoorn(String phoorn) {
		this.phoorn = phoorn;
	}

	public BigDecimal getPhopdj() {
		return this.phopdj;
	}

	public void setPhopdj(BigDecimal phopdj) {
		this.phopdj = phopdj;
	}

	public String getPhorby() {
		return this.phorby;
	}

	public void setPhorby(String phorby) {
		this.phorby = phorby;
	}

	public String getPhosts() {
		return this.phosts;
	}

	public void setPhosts(String phosts) {
		this.phosts = phosts;
	}

	public double getPhotot() {
		return this.photot;
	}

	public void setPhotot(double photot) {
		this.photot = photot;
	}

	public double getPhpcrt() {
		return this.phpcrt;
	}

	public void setPhpcrt(double phpcrt) {
		this.phpcrt = phpcrt;
	}

	public BigDecimal getPhpddj() {
		return this.phpddj;
	}

	public void setPhpddj(BigDecimal phpddj) {
		this.phpddj = phpddj;
	}

	public BigDecimal getPhpefj() {
		return this.phpefj;
	}

	public void setPhpefj(BigDecimal phpefj) {
		this.phpefj = phpefj;
	}

	public String getPhpid() {
		return this.phpid;
	}

	public void setPhpid(String phpid) {
		this.phpid = phpid;
	}

	public double getPhpohab01() {
		return this.phpohab01;
	}

	public void setPhpohab01(double phpohab01) {
		this.phpohab01 = phpohab01;
	}

	public double getPhpohab02() {
		return this.phpohab02;
	}

	public void setPhpohab02(double phpohab02) {
		this.phpohab02 = phpohab02;
	}

	public String getPhpohc01() {
		return this.phpohc01;
	}

	public void setPhpohc01(String phpohc01) {
		this.phpohc01 = phpohc01;
	}

	public String getPhpohc02() {
		return this.phpohc02;
	}

	public void setPhpohc02(String phpohc02) {
		this.phpohc02 = phpohc02;
	}

	public String getPhpohc03() {
		return this.phpohc03;
	}

	public void setPhpohc03(String phpohc03) {
		this.phpohc03 = phpohc03;
	}

	public String getPhpohc04() {
		return this.phpohc04;
	}

	public void setPhpohc04(String phpohc04) {
		this.phpohc04 = phpohc04;
	}

	public String getPhpohc05() {
		return this.phpohc05;
	}

	public void setPhpohc05(String phpohc05) {
		this.phpohc05 = phpohc05;
	}

	public String getPhpohc06() {
		return this.phpohc06;
	}

	public void setPhpohc06(String phpohc06) {
		this.phpohc06 = phpohc06;
	}

	public String getPhpohc07() {
		return this.phpohc07;
	}

	public void setPhpohc07(String phpohc07) {
		this.phpohc07 = phpohc07;
	}

	public String getPhpohc08() {
		return this.phpohc08;
	}

	public void setPhpohc08(String phpohc08) {
		this.phpohc08 = phpohc08;
	}

	public String getPhpohc09() {
		return this.phpohc09;
	}

	public void setPhpohc09(String phpohc09) {
		this.phpohc09 = phpohc09;
	}

	public String getPhpohc10() {
		return this.phpohc10;
	}

	public void setPhpohc10(String phpohc10) {
		this.phpohc10 = phpohc10;
	}

	public String getPhpohc11() {
		return this.phpohc11;
	}

	public void setPhpohc11(String phpohc11) {
		this.phpohc11 = phpohc11;
	}

	public String getPhpohc12() {
		return this.phpohc12;
	}

	public void setPhpohc12(String phpohc12) {
		this.phpohc12 = phpohc12;
	}

	public BigDecimal getPhpohd01() {
		return this.phpohd01;
	}

	public void setPhpohd01(BigDecimal phpohd01) {
		this.phpohd01 = phpohd01;
	}

	public BigDecimal getPhpohd02() {
		return this.phpohd02;
	}

	public void setPhpohd02(BigDecimal phpohd02) {
		this.phpohd02 = phpohd02;
	}

	public String getPhpohp01() {
		return this.phpohp01;
	}

	public void setPhpohp01(String phpohp01) {
		this.phpohp01 = phpohp01;
	}

	public String getPhpohp02() {
		return this.phpohp02;
	}

	public void setPhpohp02(String phpohp02) {
		this.phpohp02 = phpohp02;
	}

	public String getPhpohp03() {
		return this.phpohp03;
	}

	public void setPhpohp03(String phpohp03) {
		this.phpohp03 = phpohp03;
	}

	public String getPhpohp04() {
		return this.phpohp04;
	}

	public void setPhpohp04(String phpohp04) {
		this.phpohp04 = phpohp04;
	}

	public String getPhpohp05() {
		return this.phpohp05;
	}

	public void setPhpohp05(String phpohp05) {
		this.phpohp05 = phpohp05;
	}

	public String getPhpohp06() {
		return this.phpohp06;
	}

	public void setPhpohp06(String phpohp06) {
		this.phpohp06 = phpohp06;
	}

	public String getPhpohp07() {
		return this.phpohp07;
	}

	public void setPhpohp07(String phpohp07) {
		this.phpohp07 = phpohp07;
	}

	public String getPhpohp08() {
		return this.phpohp08;
	}

	public void setPhpohp08(String phpohp08) {
		this.phpohp08 = phpohp08;
	}

	public String getPhpohp09() {
		return this.phpohp09;
	}

	public void setPhpohp09(String phpohp09) {
		this.phpohp09 = phpohp09;
	}

	public String getPhpohp10() {
		return this.phpohp10;
	}

	public void setPhpohp10(String phpohp10) {
		this.phpohp10 = phpohp10;
	}

	public String getPhpohp11() {
		return this.phpohp11;
	}

	public void setPhpohp11(String phpohp11) {
		this.phpohp11 = phpohp11;
	}

	public String getPhpohp12() {
		return this.phpohp12;
	}

	public void setPhpohp12(String phpohp12) {
		this.phpohp12 = phpohp12;
	}

	public String getPhpohp13() {
		return this.phpohp13;
	}

	public void setPhpohp13(String phpohp13) {
		this.phpohp13 = phpohp13;
	}

	public Timestamp getPhpohu01() {
		return this.phpohu01;
	}

	public void setPhpohu01(Timestamp phpohu01) {
		this.phpohu01 = phpohu01;
	}

	public Timestamp getPhpohu02() {
		return this.phpohu02;
	}

	public void setPhpohu02(Timestamp phpohu02) {
		this.phpohu02 = phpohu02;
	}

	public BigDecimal getPhppdj() {
		return this.phppdj;
	}

	public void setPhppdj(BigDecimal phppdj) {
		this.phppdj = phppdj;
	}

	public String getPhprgp() {
		return this.phprgp;
	}

	public void setPhprgp(String phprgp) {
		this.phprgp = phprgp;
	}

	public String getPhprom() {
		return this.phprom;
	}

	public void setPhprom(String phprom) {
		this.phprom = phprom;
	}

	public String getPhprp5() {
		return this.phprp5;
	}

	public void setPhprp5(String phprp5) {
		this.phprp5 = phprp5;
	}

	public String getPhprpy() {
		return this.phprpy;
	}

	public void setPhprpy(String phprpy) {
		this.phprpy = phprpy;
	}

	public BigDecimal getPhpsdj() {
		return this.phpsdj;
	}

	public void setPhpsdj(BigDecimal phpsdj) {
		this.phpsdj = phpsdj;
	}

	public String getPhptc() {
		return this.phptc;
	}

	public void setPhptc(String phptc) {
		this.phptc = phptc;
	}

	public String getPhpurg() {
		return this.phpurg;
	}

	public void setPhpurg(String phpurg) {
		this.phpurg = phpurg;
	}

	public String getPhrcd() {
		return this.phrcd;
	}

	public void setPhrcd(String phrcd) {
		this.phrcd = phrcd;
	}

	public String getPhrcto() {
		return this.phrcto;
	}

	public void setPhrcto(String phrcto) {
		this.phrcto = phrcto;
	}

	public String getPhreti() {
		return this.phreti;
	}

	public void setPhreti(String phreti) {
		this.phreti = phreti;
	}

	public String getPhrkco() {
		return this.phrkco;
	}

	public void setPhrkco(String phrkco) {
		this.phrkco = phrkco;
	}

	public String getPhrmk() {
		return this.phrmk;
	}

	public void setPhrmk(String phrmk) {
		this.phrmk = phrmk;
	}

	public String getPhrorn() {
		return this.phrorn;
	}

	public void setPhrorn(String phrorn) {
		this.phrorn = phrorn;
	}

	public double getPhrsht() {
		return this.phrsht;
	}

	public void setPhrsht(double phrsht) {
		this.phrsht = phrsht;
	}

	public String getPhrtnr() {
		return this.phrtnr;
	}

	public void setPhrtnr(String phrtnr) {
		this.phrtnr = phrtnr;
	}

	public double getPhshan() {
		return this.phshan;
	}

	public void setPhshan(double phshan) {
		this.phshan = phshan;
	}

	public double getPhtday() {
		return this.phtday;
	}

	public void setPhtday(double phtday) {
		this.phtday = phtday;
	}

	public String getPhtkby() {
		return this.phtkby;
	}

	public void setPhtkby(String phtkby) {
		this.phtkby = phtkby;
	}

	public BigDecimal getPhtrdj() {
		return this.phtrdj;
	}

	public void setPhtrdj(BigDecimal phtrdj) {
		this.phtrdj = phtrdj;
	}

	public String getPhtxa1() {
		return this.phtxa1;
	}

	public void setPhtxa1(String phtxa1) {
		this.phtxa1 = phtxa1;
	}

	public String getPhtxct() {
		return this.phtxct;
	}

	public void setPhtxct(String phtxct) {
		this.phtxct = phtxct;
	}

	public BigDecimal getPhupmj() {
		return this.phupmj;
	}

	public void setPhupmj(BigDecimal phupmj) {
		this.phupmj = phupmj;
	}

	public double getPhurab() {
		return this.phurab;
	}

	public void setPhurab(double phurab) {
		this.phurab = phurab;
	}

	public double getPhurat() {
		return this.phurat;
	}

	public void setPhurat(double phurat) {
		this.phurat = phurat;
	}

	public String getPhurcd() {
		return this.phurcd;
	}

	public void setPhurcd(String phurcd) {
		this.phurcd = phurcd;
	}

	public BigDecimal getPhurdt() {
		return this.phurdt;
	}

	public void setPhurdt(BigDecimal phurdt) {
		this.phurdt = phurdt;
	}

	public String getPhurrf() {
		return this.phurrf;
	}

	public void setPhurrf(String phurrf) {
		this.phurrf = phurrf;
	}

	public String getPhuser() {
		return this.phuser;
	}

	public void setPhuser(String phuser) {
		this.phuser = phuser;
	}

	public String getPhvr01() {
		return this.phvr01;
	}

	public void setPhvr01(String phvr01) {
		this.phvr01 = phvr01;
	}

	public String getPhvr02() {
		return this.phvr02;
	}

	public void setPhvr02(String phvr02) {
		this.phvr02 = phvr02;
	}

	public String getPhvumd() {
		return this.phvumd;
	}

	public void setPhvumd(String phvumd) {
		this.phvumd = phvumd;
	}

	public String getPhwumd() {
		return this.phwumd;
	}

	public void setPhwumd(String phwumd) {
		this.phwumd = phwumd;
	}

	public String getPhzon() {
		return this.phzon;
	}

	public void setPhzon(String phzon) {
		this.phzon = phzon;
	}

}