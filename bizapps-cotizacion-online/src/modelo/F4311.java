package modelo;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;

import modelo.pk.F4311PK;


/**
 * The persistent class for the F4311 database table.
 * 
 */
@Entity
@NamedQuery(name="F4311.findAll", query="SELECT f FROM F4311 f")
public class F4311 implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private F4311PK id;

	@Column(name="PDACHG")
	private Double pdachg;

	@Column(name="PDADDJ")
	private BigDecimal pdaddj;

	@Column(name="PDAEXP")
	private Double pdaexp;

	@Column(name="PDAID")
	private String pdaid;

	@Column(name="PDAITM")
	private String pdaitm;

	@Column(name="PDAMC3")
	private Double pdamc3;

	@Column(name="PDAN8")
	private Double pdan8;

	@Column(name="PDANBY")
	private Double pdanby;

	@Column(name="PDANCR")
	private Double pdancr;

	@Column(name="PDANI")
	private String pdani;

	@Column(name="PDAOPN")
	private Double pdaopn;

	@Column(name="PDAREC")
	private Double pdarec;

	@Column(name="PDARLV")
	private Double pdarlv;

	@Column(name="PDARTG")
	private String pdartg;

	@Column(name="PDASID")
	private String pdasid;

	@Column(name="PDASN")
	private String pdasn;

	@Column(name="PDATXT")
	private String pdatxt;

	@Column(name="PDAVCH")
	private String pdavch;

	@Column(name="PDBALU")
	private String pdbalu;

	@Column(name="PDBCRC")
	private String pdbcrc;

	@Column(name="PDCATN")
	private String pdcatn;

	@Column(name="PDCCMP")
	private Double pdccmp;

	@Column(name="PDCDCD")
	private String pdcdcd;

	@Column(name="PDCFGFL")
	private String pdcfgfl;

	@Column(name="PDCHDT")
	private String pdchdt;

	@Column(name="PDCHLN")
	private Double pdchln;

	@Column(name="PDCHMJ")
	private BigDecimal pdchmj;

	@Column(name="PDCHRS")
	private String pdchrs;

	@Column(name="PDCHRT")
	private Double pdchrt;

	@Column(name="PDCHT")
	private Double pdcht;

	@Column(name="PDCLVL")
	private String pdclvl;

	@Column(name="PDCMDCDE")
	private String pdcmdcde;

	@Column(name="PDCNDJ")
	private BigDecimal pdcndj;

	@Column(name="PDCNID")
	private String pdcnid;

	@Column(name="PDCNTRTDID")
	private Double pdcntrtdid;

	@Column(name="PDCNTRTID")
	private Double pdcntrtid;

	@Column(name="PDCO")
	private String pdco;

	@Column(name="PDCORD")
	private Double pdcord;

	@Column(name="PDCOT")
	private String pdcot;

	@Column(name="PDCPNT")
	private Double pdcpnt;

	@Column(name="PDCRCD")
	private String pdcrcd;

	@Column(name="PDCREC")
	private Double pdcrec;

	@Column(name="PDCRMD")
	private String pdcrmd;

	@Column(name="PDCRR")
	private Double pdcrr;

	@Column(name="PDCSMP")
	private String pdcsmp;

	@Column(name="PDCSTO")
	private String pdcsto;

	@Column(name="PDCTAM")
	private Double pdctam;

	@Column(name="PDCTRY")
	private Double pdctry;

	@Column(name="PDDGL")
	private BigDecimal pddgl;

	@Column(name="PDDLEJ")
	private BigDecimal pddlej;

	@Column(name="PDDMCS")
	private Double pddmcs;

	@Column(name="PDDMCT")
	private String pddmct;

	@Column(name="PDDOCC")
	private Double pddocc;

	@Column(name="PDDRQJ")
	private BigDecimal pddrqj;

	@Column(name="PDDRQT")
	private Double pddrqt;

	@Column(name="PDDSC1")
	private String pddsc1;

	@Column(name="PDDSC2")
	private String pddsc2;

	@Column(name="PDDSPR")
	private Double pddspr;

	@Column(name="PDDSVJ")
	private BigDecimal pddsvj;

	@Column(name="PDDUAL")
	private String pddual;

	@Column(name="PDECST")
	private Double pdecst;

	@Column(name="PDELEV")
	private String pdelev;

	@Column(name="PDEXR1")
	private String pdexr1;

	@Column(name="PDFAP")
	private Double pdfap;

	@Column(name="PDFCHG")
	private Double pdfchg;

	@Column(name="PDFEA")
	private Double pdfea;

	@Column(name="PDFEC")
	private Double pdfec;

	@Column(name="PDFNLP")
	private String pdfnlp;

	@Column(name="PDFRAT")
	private String pdfrat;

	@Column(name="PDFREC")
	private Double pdfrec;

	@Column(name="PDFRGD")
	private String pdfrgd;

	@Column(name="PDFRMP")
	private Double pdfrmp;

	@Column(name="PDFRRC")
	private Double pdfrrc;

	@Column(name="PDFRTC")
	private String pdfrtc;

	@Column(name="PDFRTH")
	private String pdfrth;

	@Column(name="PDFTN1")
	private Double pdftn1;

	@Column(name="PDFTRL")
	private Double pdftrl;

	@Column(name="PDFUC")
	private Double pdfuc;

	@Column(name="PDFUF1")
	private String pdfuf1;

	@Column(name="PDFUF2")
	private String pdfuf2;

	@Column(name="PDFY")
	private Double pdfy;

	@Column(name="PDGLC")
	private String pdglc;

	@Column(name="PDGRWT")
	private Double pdgrwt;

	@Column(name="PDGWUM")
	private String pdgwum;

	@Column(name="PDINMG")
	private String pdinmg;

	@Column(name="PDITM")
	private Double pditm;

	@Column(name="PDITVL")
	private Double pditvl;

	@Column(name="PDITWT")
	private Double pditwt;

	@Column(name="PDJBCD")
	private String pdjbcd;

	@Column(name="PDJOBN")
	private String pdjobn;

	@Column(name="PDKTLN")
	private Double pdktln;

	@Column(name="PDLCOD")
	private String pdlcod;

	@Column(name="PDLDNM")
	private Double pdldnm;

	@Column(name="PDLITM")
	private String pdlitm;

	@Column(name="PDLNTY")
	private String pdlnty;

	@Column(name="PDLOCN")
	private String pdlocn;

	@Column(name="PDLOTN")
	private String pdlotn;

	@Column(name="PDLT")
	private String pdlt;

	@Column(name="PDLTTR")
	private String pdlttr;

	@Column(name="PDMACT")
	private String pdmact;

	@Column(name="PDMATY")
	private String pdmaty;

	@Column(name="PDMCLN")
	private Double pdmcln;

	@Column(name="PDMCU")
	private String pdmcu;

	@Column(name="PDMERL")
	private String pdmerl;

	@Column(name="PDMKFR")
	private Double pdmkfr;

	@Column(name="PDMOADJ")
	private String pdmoadj;

	@Column(name="PDMOT")
	private String pdmot;

	@Column(name="PDNTR")
	private String pdntr;

	@Column(name="PDNXTR")
	private String pdnxtr;

	@Column(name="PDOBJ")
	private String pdobj;

	@Column(name="PDOCTO")
	private String pdocto;

	@Column(name="PDOGNO")
	private Double pdogno;

	@Column(name="PDOKCO")
	private String pdokco;

	@Column(name="PDOMCU")
	private String pdomcu;

	@Column(name="PDOORN")
	private String pdoorn;

	@Column(name="PDOPDJ")
	private BigDecimal pdopdj;

	@Column(name="PDOSFX")
	private String pdosfx;

	@Column(name="PDOTQY")
	private String pdotqy;

	@Column(name="PDPDDJ")
	private BigDecimal pdpddj;

	@Column(name="PDPDP1")
	private String pdpdp1;

	@Column(name="PDPDP2")
	private String pdpdp2;

	@Column(name="PDPDP3")
	private String pdpdp3;

	@Column(name="PDPDP4")
	private String pdpdp4;

	@Column(name="PDPDP5")
	private String pdpdp5;

	@Column(name="PDPDS1")
	private String pdpds1;

	@Column(name="PDPDS2")
	private String pdpds2;

	@Column(name="PDPDS3")
	private String pdpds3;

	@Column(name="PDPDS4")
	private String pdpds4;

	@Column(name="PDPDS5")
	private String pdpds5;

	@Column(name="PDPEFJ")
	private BigDecimal pdpefj;

	@Column(name="PDPID")
	private String pdpid;

	@Column(name="PDPL")
	private String pdpl;

	@Column(name="PDPMTN")
	private String pdpmtn;

	@Column(name="PDPN")
	private Double pdpn;

	@Column(name="PDPODC01")
	private String pdpodc01;

	@Column(name="PDPODC02")
	private String pdpodc02;

	@Column(name="PDPODC03")
	private String pdpodc03;

	@Column(name="PDPODC04")
	private String pdpodc04;

	@Column(name="PDPPDJ")
	private BigDecimal pdppdj;

	@Column(name="PDPQOR")
	private Double pdpqor;

	@Column(name="PDPRGR")
	private String pdprgr;

	@Column(name="PDPRJM")
	private Double pdprjm;

	@Column(name="PDPROM")
	private String pdprom;

	@Column(name="PDPROV")
	private String pdprov;

	@Column(name="PDPRPY")
	private String pdprpy;

	@Column(name="PDPRRC")
	private Double pdprrc;

	@Column(name="PDPS01")
	private String pdps01;

	@Column(name="PDPS02")
	private String pdps02;

	@Column(name="PDPS03")
	private String pdps03;

	@Column(name="PDPS04")
	private String pdps04;

	@Column(name="PDPS05")
	private String pdps05;

	@Column(name="PDPS06")
	private String pdps06;

	@Column(name="PDPS07")
	private String pdps07;

	@Column(name="PDPS08")
	private String pdps08;

	@Column(name="PDPS09")
	private String pdps09;

	@Column(name="PDPS10")
	private String pdps10;

	@Column(name="PDPSDJ")
	private BigDecimal pdpsdj;

	@Column(name="PDPTC")
	private String pdptc;

	@Column(name="PDPURG")
	private String pdpurg;

	@Column(name="PDR001")
	private String pdr001;

	@Column(name="PDRATT")
	private String pdratt;

	@Column(name="PDRCD")
	private String pdrcd;

	@Column(name="PDRCPF")
	private String pdrcpf;

	@Column(name="PDRCTO")
	private String pdrcto;

	@Column(name="PDRKCO")
	private String pdrkco;

	@Column(name="PDRLIT")
	private String pdrlit;

	@Column(name="PDRLLN")
	private Double pdrlln;

	@Column(name="PDRORN")
	private String pdrorn;

	@Column(name="PDRSFX")
	private String pdrsfx;

	@Column(name="PDRSHT")
	private Double pdrsht;

	@Column(name="PDRTGC")
	private String pdrtgc;

	@Column(name="PDRTNR")
	private String pdrtnr;

	@Column(name="PDSBL")
	private String pdsbl;

	@Column(name="PDSBLT")
	private String pdsblt;

	@Column(name="PDSHAN")
	private Double pdshan;

	@Column(name="PDSHCM")
	private String pdshcm;

	@Column(name="PDSHCN")
	private String pdshcn;

	@Column(name="PDSHPN")
	private Double pdshpn;

	@Column(name="PDSQOR")
	private Double pdsqor;

	@Column(name="PDSRQTY")
	private Double pdsrqty;

	@Column(name="PDSRUOM")
	private String pdsruom;

	@Column(name="PDSTTS")
	private String pdstts;

	@Column(name="PDSUB")
	private String pdsub;

	@Column(name="PDTAG")
	private String pdtag;

	@Column(name="PDTDAY")
	private Double pdtday;

	@Column(name="PDTHGD")
	private String pdthgd;

	@Column(name="PDTHRP")
	private Double pdthrp;

	@Column(name="PDTORG")
	private String pdtorg;

	@Column(name="PDTRDJ")
	private BigDecimal pdtrdj;

	@Column(name="PDTRLV")
	private Double pdtrlv;

	@Column(name="PDTX")
	private String pdtx;

	@Column(name="PDTXA1")
	private String pdtxa1;

	@Column(name="PDUCHG")
	private Double pduchg;

	@Column(name="PDUKID")
	private Double pdukid;

	@Column(name="PDUNCD")
	private String pduncd;

	@Column(name="PDUNSPSC")
	private String pdunspsc;

	@Column(name="PDUOM")
	private String pduom;

	@Column(name="PDUOM1")
	private String pduom1;

	@Column(name="PDUOM2")
	private String pduom2;

	@Column(name="PDUOM3")
	private String pduom3;

	@Column(name="PDUOPN")
	private Double pduopn;

	@Column(name="PDUORG")
	private Double pduorg;

	@Column(name="PDUPMJ")
	private BigDecimal pdupmj;

	@Column(name="PDURAB")
	private Double pdurab;

	@Column(name="PDURAT")
	private Double pdurat;

	@Column(name="PDURCD")
	private String pdurcd;

	@Column(name="PDURDT")
	private BigDecimal pdurdt;

	@Column(name="PDUREC")
	private Double pdurec;

	@Column(name="PDURLV")
	private Double pdurlv;

	@Column(name="PDURRF")
	private String pdurrf;

	@Column(name="PDUSER")
	private String pduser;

	@Column(name="PDVLUM")
	private String pdvlum;

	@Column(name="PDVR01")
	private String pdvr01;

	@Column(name="PDVR02")
	private String pdvr02;

	@Column(name="PDVR03")
	private String pdvr03;

	@Column(name="PDVR04")
	private String pdvr04;

	@Column(name="PDVR05")
	private String pdvr05;

	@Column(name="PDWR01")
	private String pdwr01;

	@Column(name="PDWTUM")
	private String pdwtum;

	@Column(name="PDWVID")
	private Double pdwvid;

	@Column(name="PDZON")
	private String pdzon;

	@Column(name="PUBLICADO")
	private Boolean publicado;

	public F4311() {
	}

	public F4311PK getId() {
		return this.id;
	}

	public void setId(F4311PK id) {
		this.id = id;
	}

	public Double getPdachg() {
		return this.pdachg;
	}

	public void setPdachg(Double pdachg) {
		this.pdachg = pdachg;
	}

	public BigDecimal getPdaddj() {
		return this.pdaddj;
	}

	public void setPdaddj(BigDecimal pdaddj) {
		this.pdaddj = pdaddj;
	}

	public Double getPdaexp() {
		return this.pdaexp;
	}

	public void setPdaexp(Double pdaexp) {
		this.pdaexp = pdaexp;
	}

	public String getPdaid() {
		return this.pdaid;
	}

	public void setPdaid(String pdaid) {
		this.pdaid = pdaid;
	}

	public String getPdaitm() {
		return this.pdaitm;
	}

	public void setPdaitm(String pdaitm) {
		this.pdaitm = pdaitm;
	}

	public Double getPdamc3() {
		return this.pdamc3;
	}

	public void setPdamc3(Double pdamc3) {
		this.pdamc3 = pdamc3;
	}

	public Double getPdan8() {
		return this.pdan8;
	}

	public void setPdan8(Double pdan8) {
		this.pdan8 = pdan8;
	}

	public Double getPdanby() {
		return this.pdanby;
	}

	public void setPdanby(Double pdanby) {
		this.pdanby = pdanby;
	}

	public Double getPdancr() {
		return this.pdancr;
	}

	public void setPdancr(Double pdancr) {
		this.pdancr = pdancr;
	}

	public String getPdani() {
		return this.pdani;
	}

	public void setPdani(String pdani) {
		this.pdani = pdani;
	}

	public Double getPdaopn() {
		return this.pdaopn;
	}

	public void setPdaopn(Double pdaopn) {
		this.pdaopn = pdaopn;
	}

	public Double getPdarec() {
		return this.pdarec;
	}

	public void setPdarec(Double pdarec) {
		this.pdarec = pdarec;
	}

	public Double getPdarlv() {
		return this.pdarlv;
	}

	public void setPdarlv(Double pdarlv) {
		this.pdarlv = pdarlv;
	}

	public String getPdartg() {
		return this.pdartg;
	}

	public void setPdartg(String pdartg) {
		this.pdartg = pdartg;
	}

	public String getPdasid() {
		return this.pdasid;
	}

	public void setPdasid(String pdasid) {
		this.pdasid = pdasid;
	}

	public String getPdasn() {
		return this.pdasn;
	}

	public void setPdasn(String pdasn) {
		this.pdasn = pdasn;
	}

	public String getPdatxt() {
		return this.pdatxt;
	}

	public void setPdatxt(String pdatxt) {
		this.pdatxt = pdatxt;
	}

	public String getPdavch() {
		return this.pdavch;
	}

	public void setPdavch(String pdavch) {
		this.pdavch = pdavch;
	}

	public String getPdbalu() {
		return this.pdbalu;
	}

	public void setPdbalu(String pdbalu) {
		this.pdbalu = pdbalu;
	}

	public String getPdbcrc() {
		return this.pdbcrc;
	}

	public void setPdbcrc(String pdbcrc) {
		this.pdbcrc = pdbcrc;
	}

	public String getPdcatn() {
		return this.pdcatn;
	}

	public void setPdcatn(String pdcatn) {
		this.pdcatn = pdcatn;
	}

	public Double getPdccmp() {
		return this.pdccmp;
	}

	public void setPdccmp(Double pdccmp) {
		this.pdccmp = pdccmp;
	}

	public String getPdcdcd() {
		return this.pdcdcd;
	}

	public void setPdcdcd(String pdcdcd) {
		this.pdcdcd = pdcdcd;
	}

	public String getPdcfgfl() {
		return this.pdcfgfl;
	}

	public void setPdcfgfl(String pdcfgfl) {
		this.pdcfgfl = pdcfgfl;
	}

	public String getPdchdt() {
		return this.pdchdt;
	}

	public void setPdchdt(String pdchdt) {
		this.pdchdt = pdchdt;
	}

	public Double getPdchln() {
		return this.pdchln;
	}

	public void setPdchln(Double pdchln) {
		this.pdchln = pdchln;
	}

	public BigDecimal getPdchmj() {
		return this.pdchmj;
	}

	public void setPdchmj(BigDecimal pdchmj) {
		this.pdchmj = pdchmj;
	}

	public String getPdchrs() {
		return this.pdchrs;
	}

	public void setPdchrs(String pdchrs) {
		this.pdchrs = pdchrs;
	}

	public Double getPdchrt() {
		return this.pdchrt;
	}

	public void setPdchrt(Double pdchrt) {
		this.pdchrt = pdchrt;
	}

	public Double getPdcht() {
		return this.pdcht;
	}

	public void setPdcht(Double pdcht) {
		this.pdcht = pdcht;
	}

	public String getPdclvl() {
		return this.pdclvl;
	}

	public void setPdclvl(String pdclvl) {
		this.pdclvl = pdclvl;
	}

	public String getPdcmdcde() {
		return this.pdcmdcde;
	}

	public void setPdcmdcde(String pdcmdcde) {
		this.pdcmdcde = pdcmdcde;
	}

	public BigDecimal getPdcndj() {
		return this.pdcndj;
	}

	public void setPdcndj(BigDecimal pdcndj) {
		this.pdcndj = pdcndj;
	}

	public String getPdcnid() {
		return this.pdcnid;
	}

	public void setPdcnid(String pdcnid) {
		this.pdcnid = pdcnid;
	}

	public Double getPdcntrtdid() {
		return this.pdcntrtdid;
	}

	public void setPdcntrtdid(Double pdcntrtdid) {
		this.pdcntrtdid = pdcntrtdid;
	}

	public Double getPdcntrtid() {
		return this.pdcntrtid;
	}

	public void setPdcntrtid(Double pdcntrtid) {
		this.pdcntrtid = pdcntrtid;
	}

	public String getPdco() {
		return this.pdco;
	}

	public void setPdco(String pdco) {
		this.pdco = pdco;
	}

	public Double getPdcord() {
		return this.pdcord;
	}

	public void setPdcord(Double pdcord) {
		this.pdcord = pdcord;
	}

	public String getPdcot() {
		return this.pdcot;
	}

	public void setPdcot(String pdcot) {
		this.pdcot = pdcot;
	}

	public Double getPdcpnt() {
		return this.pdcpnt;
	}

	public void setPdcpnt(Double pdcpnt) {
		this.pdcpnt = pdcpnt;
	}

	public String getPdcrcd() {
		return this.pdcrcd;
	}

	public void setPdcrcd(String pdcrcd) {
		this.pdcrcd = pdcrcd;
	}

	public Double getPdcrec() {
		return this.pdcrec;
	}

	public void setPdcrec(Double pdcrec) {
		this.pdcrec = pdcrec;
	}

	public String getPdcrmd() {
		return this.pdcrmd;
	}

	public void setPdcrmd(String pdcrmd) {
		this.pdcrmd = pdcrmd;
	}

	public Double getPdcrr() {
		return this.pdcrr;
	}

	public void setPdcrr(Double pdcrr) {
		this.pdcrr = pdcrr;
	}

	public String getPdcsmp() {
		return this.pdcsmp;
	}

	public void setPdcsmp(String pdcsmp) {
		this.pdcsmp = pdcsmp;
	}

	public String getPdcsto() {
		return this.pdcsto;
	}

	public void setPdcsto(String pdcsto) {
		this.pdcsto = pdcsto;
	}

	public Double getPdctam() {
		return this.pdctam;
	}

	public void setPdctam(Double pdctam) {
		this.pdctam = pdctam;
	}

	public Double getPdctry() {
		return this.pdctry;
	}

	public void setPdctry(Double pdctry) {
		this.pdctry = pdctry;
	}

	public BigDecimal getPddgl() {
		return this.pddgl;
	}

	public void setPddgl(BigDecimal pddgl) {
		this.pddgl = pddgl;
	}

	public BigDecimal getPddlej() {
		return this.pddlej;
	}

	public void setPddlej(BigDecimal pddlej) {
		this.pddlej = pddlej;
	}

	public Double getPddmcs() {
		return this.pddmcs;
	}

	public void setPddmcs(Double pddmcs) {
		this.pddmcs = pddmcs;
	}

	public String getPddmct() {
		return this.pddmct;
	}

	public void setPddmct(String pddmct) {
		this.pddmct = pddmct;
	}

	public Double getPddocc() {
		return this.pddocc;
	}

	public void setPddocc(Double pddocc) {
		this.pddocc = pddocc;
	}

	public BigDecimal getPddrqj() {
		return this.pddrqj;
	}

	public void setPddrqj(BigDecimal pddrqj) {
		this.pddrqj = pddrqj;
	}

	public Double getPddrqt() {
		return this.pddrqt;
	}

	public void setPddrqt(Double pddrqt) {
		this.pddrqt = pddrqt;
	}

	public String getPddsc1() {
		return this.pddsc1;
	}

	public void setPddsc1(String pddsc1) {
		this.pddsc1 = pddsc1;
	}

	public String getPddsc2() {
		return this.pddsc2;
	}

	public void setPddsc2(String pddsc2) {
		this.pddsc2 = pddsc2;
	}

	public Double getPddspr() {
		return this.pddspr;
	}

	public void setPddspr(Double pddspr) {
		this.pddspr = pddspr;
	}

	public BigDecimal getPddsvj() {
		return this.pddsvj;
	}

	public void setPddsvj(BigDecimal pddsvj) {
		this.pddsvj = pddsvj;
	}

	public String getPddual() {
		return this.pddual;
	}

	public void setPddual(String pddual) {
		this.pddual = pddual;
	}

	public Double getPdecst() {
		return this.pdecst;
	}

	public void setPdecst(Double pdecst) {
		this.pdecst = pdecst;
	}

	public String getPdelev() {
		return this.pdelev;
	}

	public void setPdelev(String pdelev) {
		this.pdelev = pdelev;
	}

	public String getPdexr1() {
		return this.pdexr1;
	}

	public void setPdexr1(String pdexr1) {
		this.pdexr1 = pdexr1;
	}

	public Double getPdfap() {
		return this.pdfap;
	}

	public void setPdfap(Double pdfap) {
		this.pdfap = pdfap;
	}

	public Double getPdfchg() {
		return this.pdfchg;
	}

	public void setPdfchg(Double pdfchg) {
		this.pdfchg = pdfchg;
	}

	public Double getPdfea() {
		return this.pdfea;
	}

	public void setPdfea(Double pdfea) {
		this.pdfea = pdfea;
	}

	public Double getPdfec() {
		return this.pdfec;
	}

	public void setPdfec(Double pdfec) {
		this.pdfec = pdfec;
	}

	public String getPdfnlp() {
		return this.pdfnlp;
	}

	public void setPdfnlp(String pdfnlp) {
		this.pdfnlp = pdfnlp;
	}

	public String getPdfrat() {
		return this.pdfrat;
	}

	public void setPdfrat(String pdfrat) {
		this.pdfrat = pdfrat;
	}

	public Double getPdfrec() {
		return this.pdfrec;
	}

	public void setPdfrec(Double pdfrec) {
		this.pdfrec = pdfrec;
	}

	public String getPdfrgd() {
		return this.pdfrgd;
	}

	public void setPdfrgd(String pdfrgd) {
		this.pdfrgd = pdfrgd;
	}

	public Double getPdfrmp() {
		return this.pdfrmp;
	}

	public void setPdfrmp(Double pdfrmp) {
		this.pdfrmp = pdfrmp;
	}

	public Double getPdfrrc() {
		return this.pdfrrc;
	}

	public void setPdfrrc(Double pdfrrc) {
		this.pdfrrc = pdfrrc;
	}

	public String getPdfrtc() {
		return this.pdfrtc;
	}

	public void setPdfrtc(String pdfrtc) {
		this.pdfrtc = pdfrtc;
	}

	public String getPdfrth() {
		return this.pdfrth;
	}

	public void setPdfrth(String pdfrth) {
		this.pdfrth = pdfrth;
	}

	public Double getPdftn1() {
		return this.pdftn1;
	}

	public void setPdftn1(Double pdftn1) {
		this.pdftn1 = pdftn1;
	}

	public Double getPdftrl() {
		return this.pdftrl;
	}

	public void setPdftrl(Double pdftrl) {
		this.pdftrl = pdftrl;
	}

	public Double getPdfuc() {
		return this.pdfuc;
	}

	public void setPdfuc(Double pdfuc) {
		this.pdfuc = pdfuc;
	}

	public String getPdfuf1() {
		return this.pdfuf1;
	}

	public void setPdfuf1(String pdfuf1) {
		this.pdfuf1 = pdfuf1;
	}

	public String getPdfuf2() {
		return this.pdfuf2;
	}

	public void setPdfuf2(String pdfuf2) {
		this.pdfuf2 = pdfuf2;
	}

	public Double getPdfy() {
		return this.pdfy;
	}

	public void setPdfy(Double pdfy) {
		this.pdfy = pdfy;
	}

	public String getPdglc() {
		return this.pdglc;
	}

	public void setPdglc(String pdglc) {
		this.pdglc = pdglc;
	}

	public Double getPdgrwt() {
		return this.pdgrwt;
	}

	public void setPdgrwt(Double pdgrwt) {
		this.pdgrwt = pdgrwt;
	}

	public String getPdgwum() {
		return this.pdgwum;
	}

	public void setPdgwum(String pdgwum) {
		this.pdgwum = pdgwum;
	}

	public String getPdinmg() {
		return this.pdinmg;
	}

	public void setPdinmg(String pdinmg) {
		this.pdinmg = pdinmg;
	}

	public Double getPditm() {
		return this.pditm;
	}

	public void setPditm(Double pditm) {
		this.pditm = pditm;
	}

	public Double getPditvl() {
		return this.pditvl;
	}

	public void setPditvl(Double pditvl) {
		this.pditvl = pditvl;
	}

	public Double getPditwt() {
		return this.pditwt;
	}

	public void setPditwt(Double pditwt) {
		this.pditwt = pditwt;
	}

	public String getPdjbcd() {
		return this.pdjbcd;
	}

	public void setPdjbcd(String pdjbcd) {
		this.pdjbcd = pdjbcd;
	}

	public String getPdjobn() {
		return this.pdjobn;
	}

	public void setPdjobn(String pdjobn) {
		this.pdjobn = pdjobn;
	}

	public Double getPdktln() {
		return this.pdktln;
	}

	public void setPdktln(Double pdktln) {
		this.pdktln = pdktln;
	}

	public String getPdlcod() {
		return this.pdlcod;
	}

	public void setPdlcod(String pdlcod) {
		this.pdlcod = pdlcod;
	}

	public Double getPdldnm() {
		return this.pdldnm;
	}

	public void setPdldnm(Double pdldnm) {
		this.pdldnm = pdldnm;
	}

	public String getPdlitm() {
		return this.pdlitm;
	}

	public void setPdlitm(String pdlitm) {
		this.pdlitm = pdlitm;
	}

	public String getPdlnty() {
		return this.pdlnty;
	}

	public void setPdlnty(String pdlnty) {
		this.pdlnty = pdlnty;
	}

	public String getPdlocn() {
		return this.pdlocn;
	}

	public void setPdlocn(String pdlocn) {
		this.pdlocn = pdlocn;
	}

	public String getPdlotn() {
		return this.pdlotn;
	}

	public void setPdlotn(String pdlotn) {
		this.pdlotn = pdlotn;
	}

	public String getPdlt() {
		return this.pdlt;
	}

	public void setPdlt(String pdlt) {
		this.pdlt = pdlt;
	}

	public String getPdlttr() {
		return this.pdlttr;
	}

	public void setPdlttr(String pdlttr) {
		this.pdlttr = pdlttr;
	}

	public String getPdmact() {
		return this.pdmact;
	}

	public void setPdmact(String pdmact) {
		this.pdmact = pdmact;
	}

	public String getPdmaty() {
		return this.pdmaty;
	}

	public void setPdmaty(String pdmaty) {
		this.pdmaty = pdmaty;
	}

	public Double getPdmcln() {
		return this.pdmcln;
	}

	public void setPdmcln(Double pdmcln) {
		this.pdmcln = pdmcln;
	}

	public String getPdmcu() {
		return this.pdmcu;
	}

	public void setPdmcu(String pdmcu) {
		this.pdmcu = pdmcu;
	}

	public String getPdmerl() {
		return this.pdmerl;
	}

	public void setPdmerl(String pdmerl) {
		this.pdmerl = pdmerl;
	}

	public Double getPdmkfr() {
		return this.pdmkfr;
	}

	public void setPdmkfr(Double pdmkfr) {
		this.pdmkfr = pdmkfr;
	}

	public String getPdmoadj() {
		return this.pdmoadj;
	}

	public void setPdmoadj(String pdmoadj) {
		this.pdmoadj = pdmoadj;
	}

	public String getPdmot() {
		return this.pdmot;
	}

	public void setPdmot(String pdmot) {
		this.pdmot = pdmot;
	}

	public String getPdntr() {
		return this.pdntr;
	}

	public void setPdntr(String pdntr) {
		this.pdntr = pdntr;
	}

	public String getPdnxtr() {
		return this.pdnxtr;
	}

	public void setPdnxtr(String pdnxtr) {
		this.pdnxtr = pdnxtr;
	}

	public String getPdobj() {
		return this.pdobj;
	}

	public void setPdobj(String pdobj) {
		this.pdobj = pdobj;
	}

	public String getPdocto() {
		return this.pdocto;
	}

	public void setPdocto(String pdocto) {
		this.pdocto = pdocto;
	}

	public Double getPdogno() {
		return this.pdogno;
	}

	public void setPdogno(Double pdogno) {
		this.pdogno = pdogno;
	}

	public String getPdokco() {
		return this.pdokco;
	}

	public void setPdokco(String pdokco) {
		this.pdokco = pdokco;
	}

	public String getPdomcu() {
		return this.pdomcu;
	}

	public void setPdomcu(String pdomcu) {
		this.pdomcu = pdomcu;
	}

	public String getPdoorn() {
		return this.pdoorn;
	}

	public void setPdoorn(String pdoorn) {
		this.pdoorn = pdoorn;
	}

	public BigDecimal getPdopdj() {
		return this.pdopdj;
	}

	public void setPdopdj(BigDecimal pdopdj) {
		this.pdopdj = pdopdj;
	}

	public String getPdosfx() {
		return this.pdosfx;
	}

	public void setPdosfx(String pdosfx) {
		this.pdosfx = pdosfx;
	}

	public String getPdotqy() {
		return this.pdotqy;
	}

	public void setPdotqy(String pdotqy) {
		this.pdotqy = pdotqy;
	}

	public BigDecimal getPdpddj() {
		return this.pdpddj;
	}

	public void setPdpddj(BigDecimal pdpddj) {
		this.pdpddj = pdpddj;
	}

	public String getPdpdp1() {
		return this.pdpdp1;
	}

	public void setPdpdp1(String pdpdp1) {
		this.pdpdp1 = pdpdp1;
	}

	public String getPdpdp2() {
		return this.pdpdp2;
	}

	public void setPdpdp2(String pdpdp2) {
		this.pdpdp2 = pdpdp2;
	}

	public String getPdpdp3() {
		return this.pdpdp3;
	}

	public void setPdpdp3(String pdpdp3) {
		this.pdpdp3 = pdpdp3;
	}

	public String getPdpdp4() {
		return this.pdpdp4;
	}

	public void setPdpdp4(String pdpdp4) {
		this.pdpdp4 = pdpdp4;
	}

	public String getPdpdp5() {
		return this.pdpdp5;
	}

	public void setPdpdp5(String pdpdp5) {
		this.pdpdp5 = pdpdp5;
	}

	public String getPdpds1() {
		return this.pdpds1;
	}

	public void setPdpds1(String pdpds1) {
		this.pdpds1 = pdpds1;
	}

	public String getPdpds2() {
		return this.pdpds2;
	}

	public void setPdpds2(String pdpds2) {
		this.pdpds2 = pdpds2;
	}

	public String getPdpds3() {
		return this.pdpds3;
	}

	public void setPdpds3(String pdpds3) {
		this.pdpds3 = pdpds3;
	}

	public String getPdpds4() {
		return this.pdpds4;
	}

	public void setPdpds4(String pdpds4) {
		this.pdpds4 = pdpds4;
	}

	public String getPdpds5() {
		return this.pdpds5;
	}

	public void setPdpds5(String pdpds5) {
		this.pdpds5 = pdpds5;
	}

	public BigDecimal getPdpefj() {
		return this.pdpefj;
	}

	public void setPdpefj(BigDecimal pdpefj) {
		this.pdpefj = pdpefj;
	}

	public String getPdpid() {
		return this.pdpid;
	}

	public void setPdpid(String pdpid) {
		this.pdpid = pdpid;
	}

	public String getPdpl() {
		return this.pdpl;
	}

	public void setPdpl(String pdpl) {
		this.pdpl = pdpl;
	}

	public String getPdpmtn() {
		return this.pdpmtn;
	}

	public void setPdpmtn(String pdpmtn) {
		this.pdpmtn = pdpmtn;
	}

	public Double getPdpn() {
		return this.pdpn;
	}

	public void setPdpn(Double pdpn) {
		this.pdpn = pdpn;
	}

	public String getPdpodc01() {
		return this.pdpodc01;
	}

	public void setPdpodc01(String pdpodc01) {
		this.pdpodc01 = pdpodc01;
	}

	public String getPdpodc02() {
		return this.pdpodc02;
	}

	public void setPdpodc02(String pdpodc02) {
		this.pdpodc02 = pdpodc02;
	}

	public String getPdpodc03() {
		return this.pdpodc03;
	}

	public void setPdpodc03(String pdpodc03) {
		this.pdpodc03 = pdpodc03;
	}

	public String getPdpodc04() {
		return this.pdpodc04;
	}

	public void setPdpodc04(String pdpodc04) {
		this.pdpodc04 = pdpodc04;
	}

	public BigDecimal getPdppdj() {
		return this.pdppdj;
	}

	public void setPdppdj(BigDecimal pdppdj) {
		this.pdppdj = pdppdj;
	}

	public Double getPdpqor() {
		return this.pdpqor;
	}

	public void setPdpqor(Double pdpqor) {
		this.pdpqor = pdpqor;
	}

	public String getPdprgr() {
		return this.pdprgr;
	}

	public void setPdprgr(String pdprgr) {
		this.pdprgr = pdprgr;
	}

	public Double getPdprjm() {
		return this.pdprjm;
	}

	public void setPdprjm(Double pdprjm) {
		this.pdprjm = pdprjm;
	}

	public String getPdprom() {
		return this.pdprom;
	}

	public void setPdprom(String pdprom) {
		this.pdprom = pdprom;
	}

	public String getPdprov() {
		return this.pdprov;
	}

	public void setPdprov(String pdprov) {
		this.pdprov = pdprov;
	}

	public String getPdprpy() {
		return this.pdprpy;
	}

	public void setPdprpy(String pdprpy) {
		this.pdprpy = pdprpy;
	}

	public Double getPdprrc() {
		return this.pdprrc;
	}

	public void setPdprrc(Double pdprrc) {
		this.pdprrc = pdprrc;
	}

	public String getPdps01() {
		return this.pdps01;
	}

	public void setPdps01(String pdps01) {
		this.pdps01 = pdps01;
	}

	public String getPdps02() {
		return this.pdps02;
	}

	public void setPdps02(String pdps02) {
		this.pdps02 = pdps02;
	}

	public String getPdps03() {
		return this.pdps03;
	}

	public void setPdps03(String pdps03) {
		this.pdps03 = pdps03;
	}

	public String getPdps04() {
		return this.pdps04;
	}

	public void setPdps04(String pdps04) {
		this.pdps04 = pdps04;
	}

	public String getPdps05() {
		return this.pdps05;
	}

	public void setPdps05(String pdps05) {
		this.pdps05 = pdps05;
	}

	public String getPdps06() {
		return this.pdps06;
	}

	public void setPdps06(String pdps06) {
		this.pdps06 = pdps06;
	}

	public String getPdps07() {
		return this.pdps07;
	}

	public void setPdps07(String pdps07) {
		this.pdps07 = pdps07;
	}

	public String getPdps08() {
		return this.pdps08;
	}

	public void setPdps08(String pdps08) {
		this.pdps08 = pdps08;
	}

	public String getPdps09() {
		return this.pdps09;
	}

	public void setPdps09(String pdps09) {
		this.pdps09 = pdps09;
	}

	public String getPdps10() {
		return this.pdps10;
	}

	public void setPdps10(String pdps10) {
		this.pdps10 = pdps10;
	}

	public BigDecimal getPdpsdj() {
		return this.pdpsdj;
	}

	public void setPdpsdj(BigDecimal pdpsdj) {
		this.pdpsdj = pdpsdj;
	}

	public String getPdptc() {
		return this.pdptc;
	}

	public void setPdptc(String pdptc) {
		this.pdptc = pdptc;
	}

	public String getPdpurg() {
		return this.pdpurg;
	}

	public void setPdpurg(String pdpurg) {
		this.pdpurg = pdpurg;
	}

	public String getPdr001() {
		return this.pdr001;
	}

	public void setPdr001(String pdr001) {
		this.pdr001 = pdr001;
	}

	public String getPdratt() {
		return this.pdratt;
	}

	public void setPdratt(String pdratt) {
		this.pdratt = pdratt;
	}

	public String getPdrcd() {
		return this.pdrcd;
	}

	public void setPdrcd(String pdrcd) {
		this.pdrcd = pdrcd;
	}

	public String getPdrcpf() {
		return this.pdrcpf;
	}

	public void setPdrcpf(String pdrcpf) {
		this.pdrcpf = pdrcpf;
	}

	public String getPdrcto() {
		return this.pdrcto;
	}

	public void setPdrcto(String pdrcto) {
		this.pdrcto = pdrcto;
	}

	public String getPdrkco() {
		return this.pdrkco;
	}

	public void setPdrkco(String pdrkco) {
		this.pdrkco = pdrkco;
	}

	public String getPdrlit() {
		return this.pdrlit;
	}

	public void setPdrlit(String pdrlit) {
		this.pdrlit = pdrlit;
	}

	public Double getPdrlln() {
		return this.pdrlln;
	}

	public void setPdrlln(Double pdrlln) {
		this.pdrlln = pdrlln;
	}

	public String getPdrorn() {
		return this.pdrorn;
	}

	public void setPdrorn(String pdrorn) {
		this.pdrorn = pdrorn;
	}

	public String getPdrsfx() {
		return this.pdrsfx;
	}

	public void setPdrsfx(String pdrsfx) {
		this.pdrsfx = pdrsfx;
	}

	public Double getPdrsht() {
		return this.pdrsht;
	}

	public void setPdrsht(Double pdrsht) {
		this.pdrsht = pdrsht;
	}

	public String getPdrtgc() {
		return this.pdrtgc;
	}

	public void setPdrtgc(String pdrtgc) {
		this.pdrtgc = pdrtgc;
	}

	public String getPdrtnr() {
		return this.pdrtnr;
	}

	public void setPdrtnr(String pdrtnr) {
		this.pdrtnr = pdrtnr;
	}

	public String getPdsbl() {
		return this.pdsbl;
	}

	public void setPdsbl(String pdsbl) {
		this.pdsbl = pdsbl;
	}

	public String getPdsblt() {
		return this.pdsblt;
	}

	public void setPdsblt(String pdsblt) {
		this.pdsblt = pdsblt;
	}

	public Double getPdshan() {
		return this.pdshan;
	}

	public void setPdshan(Double pdshan) {
		this.pdshan = pdshan;
	}

	public String getPdshcm() {
		return this.pdshcm;
	}

	public void setPdshcm(String pdshcm) {
		this.pdshcm = pdshcm;
	}

	public String getPdshcn() {
		return this.pdshcn;
	}

	public void setPdshcn(String pdshcn) {
		this.pdshcn = pdshcn;
	}

	public Double getPdshpn() {
		return this.pdshpn;
	}

	public void setPdshpn(Double pdshpn) {
		this.pdshpn = pdshpn;
	}

	public Double getPdsqor() {
		return this.pdsqor;
	}

	public void setPdsqor(Double pdsqor) {
		this.pdsqor = pdsqor;
	}

	public Double getPdsrqty() {
		return this.pdsrqty;
	}

	public void setPdsrqty(Double pdsrqty) {
		this.pdsrqty = pdsrqty;
	}

	public String getPdsruom() {
		return this.pdsruom;
	}

	public void setPdsruom(String pdsruom) {
		this.pdsruom = pdsruom;
	}

	public String getPdstts() {
		return this.pdstts;
	}

	public void setPdstts(String pdstts) {
		this.pdstts = pdstts;
	}

	public String getPdsub() {
		return this.pdsub;
	}

	public void setPdsub(String pdsub) {
		this.pdsub = pdsub;
	}

	public String getPdtag() {
		return this.pdtag;
	}

	public void setPdtag(String pdtag) {
		this.pdtag = pdtag;
	}

	public Double getPdtday() {
		return this.pdtday;
	}

	public void setPdtday(Double pdtday) {
		this.pdtday = pdtday;
	}

	public String getPdthgd() {
		return this.pdthgd;
	}

	public void setPdthgd(String pdthgd) {
		this.pdthgd = pdthgd;
	}

	public Double getPdthrp() {
		return this.pdthrp;
	}

	public void setPdthrp(Double pdthrp) {
		this.pdthrp = pdthrp;
	}

	public String getPdtorg() {
		return this.pdtorg;
	}

	public void setPdtorg(String pdtorg) {
		this.pdtorg = pdtorg;
	}

	public BigDecimal getPdtrdj() {
		return this.pdtrdj;
	}

	public void setPdtrdj(BigDecimal pdtrdj) {
		this.pdtrdj = pdtrdj;
	}

	public Double getPdtrlv() {
		return this.pdtrlv;
	}

	public void setPdtrlv(Double pdtrlv) {
		this.pdtrlv = pdtrlv;
	}

	public String getPdtx() {
		return this.pdtx;
	}

	public void setPdtx(String pdtx) {
		this.pdtx = pdtx;
	}

	public String getPdtxa1() {
		return this.pdtxa1;
	}

	public void setPdtxa1(String pdtxa1) {
		this.pdtxa1 = pdtxa1;
	}

	public Double getPduchg() {
		return this.pduchg;
	}

	public void setPduchg(Double pduchg) {
		this.pduchg = pduchg;
	}

	public Double getPdukid() {
		return this.pdukid;
	}

	public void setPdukid(Double pdukid) {
		this.pdukid = pdukid;
	}

	public String getPduncd() {
		return this.pduncd;
	}

	public void setPduncd(String pduncd) {
		this.pduncd = pduncd;
	}

	public String getPdunspsc() {
		return this.pdunspsc;
	}

	public void setPdunspsc(String pdunspsc) {
		this.pdunspsc = pdunspsc;
	}

	public String getPduom() {
		return this.pduom;
	}

	public void setPduom(String pduom) {
		this.pduom = pduom;
	}

	public String getPduom1() {
		return this.pduom1;
	}

	public void setPduom1(String pduom1) {
		this.pduom1 = pduom1;
	}

	public String getPduom2() {
		return this.pduom2;
	}

	public void setPduom2(String pduom2) {
		this.pduom2 = pduom2;
	}

	public String getPduom3() {
		return this.pduom3;
	}

	public void setPduom3(String pduom3) {
		this.pduom3 = pduom3;
	}

	public Double getPduopn() {
		return this.pduopn;
	}

	public void setPduopn(Double pduopn) {
		this.pduopn = pduopn;
	}

	public Double getPduorg() {
		return this.pduorg;
	}

	public void setPduorg(Double pduorg) {
		this.pduorg = pduorg;
	}

	public BigDecimal getPdupmj() {
		return this.pdupmj;
	}

	public void setPdupmj(BigDecimal pdupmj) {
		this.pdupmj = pdupmj;
	}

	public Double getPdurab() {
		return this.pdurab;
	}

	public void setPdurab(Double pdurab) {
		this.pdurab = pdurab;
	}

	public Double getPdurat() {
		return this.pdurat;
	}

	public void setPdurat(Double pdurat) {
		this.pdurat = pdurat;
	}

	public String getPdurcd() {
		return this.pdurcd;
	}

	public void setPdurcd(String pdurcd) {
		this.pdurcd = pdurcd;
	}

	public BigDecimal getPdurdt() {
		return this.pdurdt;
	}

	public void setPdurdt(BigDecimal pdurdt) {
		this.pdurdt = pdurdt;
	}

	public Double getPdurec() {
		return this.pdurec;
	}

	public void setPdurec(Double pdurec) {
		this.pdurec = pdurec;
	}

	public Double getPdurlv() {
		return this.pdurlv;
	}

	public void setPdurlv(Double pdurlv) {
		this.pdurlv = pdurlv;
	}

	public String getPdurrf() {
		return this.pdurrf;
	}

	public void setPdurrf(String pdurrf) {
		this.pdurrf = pdurrf;
	}

	public String getPduser() {
		return this.pduser;
	}

	public void setPduser(String pduser) {
		this.pduser = pduser;
	}

	public String getPdvlum() {
		return this.pdvlum;
	}

	public void setPdvlum(String pdvlum) {
		this.pdvlum = pdvlum;
	}

	public String getPdvr01() {
		return this.pdvr01;
	}

	public void setPdvr01(String pdvr01) {
		this.pdvr01 = pdvr01;
	}

	public String getPdvr02() {
		return this.pdvr02;
	}

	public void setPdvr02(String pdvr02) {
		this.pdvr02 = pdvr02;
	}

	public String getPdvr03() {
		return this.pdvr03;
	}

	public void setPdvr03(String pdvr03) {
		this.pdvr03 = pdvr03;
	}

	public String getPdvr04() {
		return this.pdvr04;
	}

	public void setPdvr04(String pdvr04) {
		this.pdvr04 = pdvr04;
	}

	public String getPdvr05() {
		return this.pdvr05;
	}

	public void setPdvr05(String pdvr05) {
		this.pdvr05 = pdvr05;
	}

	public String getPdwr01() {
		return this.pdwr01;
	}

	public void setPdwr01(String pdwr01) {
		this.pdwr01 = pdwr01;
	}

	public String getPdwtum() {
		return this.pdwtum;
	}

	public void setPdwtum(String pdwtum) {
		this.pdwtum = pdwtum;
	}

	public Double getPdwvid() {
		return this.pdwvid;
	}

	public void setPdwvid(Double pdwvid) {
		this.pdwvid = pdwvid;
	}

	public String getPdzon() {
		return this.pdzon;
	}

	public void setPdzon(String pdzon) {
		this.pdzon = pdzon;
	}

	public Boolean getPublicado() {
		return this.publicado;
	}

	public void setPublicado(Boolean publicado) {
		this.publicado = publicado;
	}

}