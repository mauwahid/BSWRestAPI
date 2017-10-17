/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bsw.domain;

import java.sql.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Maulana Wahid Abdurrahman
 */
@XmlRootElement
public class TbBWIPH {
    
    private String idIPH;
    
    private String applyTP;
    
    private String penjualId;
    
    private String pembeliId;
    
    private String pemohonId;
    
    private String nomorUrutPemohon;
    
    private String dateReceived;
    
    private String certNo;
    
    private String tglCert;
    
    private String plNo;
    
    private String tglPl;
    
    private String noPerjanjian;
    
    private String tglPerjanjian;
    
    private String noKeputusan;
    
    private String applyLttrNo;
    
    private String applyNM;
    private String docStatNM;
    private String ldUsgCdNM;
    private String ldUsgTpNM;
    private String addrCdNM;
    private String uwtoTpNM;
    private String pmtCondCdNM;
    
    private TbBwCust tbBWCUST;
    private TbBwCust tbBWPenjual;
    private TbBwCust tbBWPembeli;
    private TbBwCust tbBWPemilikAkun;
    
    
    private TbLdAddrCD wilPengembangan;

    public TbBwCust getTbBWPemilikAkun() {
        return tbBWPemilikAkun;
    }

    public void setTbBWPemilikAkun(TbBwCust tbBWPemilikAkun) {
        this.tbBWPemilikAkun = tbBWPemilikAkun;
    }
    
    

    public TbLdAddrCD getWilPengembangan() {
        return wilPengembangan;
    }

    public void setWilPengembangan(TbLdAddrCD wilPengembangan) {
        this.wilPengembangan = wilPengembangan;
    }
    
    

    public TbBwCust getTbBWPenjual() {
        return tbBWPenjual;
    }

    public void setTbBWPenjual(TbBwCust tbBWPenjual) {
        this.tbBWPenjual = tbBWPenjual;
    }

    public TbBwCust getTbBWPembeli() {
        return tbBWPembeli;
    }

    public void setTbBWPembeli(TbBwCust tbBWPembeli) {
        this.tbBWPembeli = tbBWPembeli;
    }
    
    
    
    private List<TbBWIPHDetl> tbBwIPHDetls;
    
    private List<TbBwIPHPemohon> tbBwIPHPemohon;

    public TbBwCust getTbBWCUST() {
        return tbBWCUST;
    }

    public void setTbBWCUST(TbBwCust tbBWCUST) {
        this.tbBWCUST = tbBWCUST;
    }
    
    
    

    public List<TbBWIPHDetl> getTbBwIPHDetls() {
        return tbBwIPHDetls;
    }

    public void setTbBwIPHDetls(List<TbBWIPHDetl> tbBwIPHDetls) {
        this.tbBwIPHDetls = tbBwIPHDetls;
    }

    public List<TbBwIPHPemohon> getTbBwIPHPemohon() {
        return tbBwIPHPemohon;
    }

    public void setTbBwIPHPemohon(List<TbBwIPHPemohon> tbBwIPHPemohon) {
        this.tbBwIPHPemohon = tbBwIPHPemohon;
    }
    

    public String getApplyLttrNo() {
        return applyLttrNo;
    }

    public void setApplyLttrNo(String applyLttrNo) {
        this.applyLttrNo = applyLttrNo;
    }
    
    
 //   @XmlElement(nillable=false)
    private String tglKeputusan;
    
 //   @XmlElement(nillable=false)
    private String docDMT;
    
  //  @XmlElement(nillable=false)
    private String applyLttrSBJT;
    
    //@XmlElement(nillable=false)
    private String regRemark;
    
 //   @XmlElement(nillable=false)
    private String docStat;
    
   // @XmlElement(nillable=false)
    private String applyStat;
    
   // @XmlElement(nillable=false)
    private String sendUser;
    
//    @XmlElement(nillable=false)
    private String addrCd;
    
  //  @XmlElement(nillable=false)
    private String addrDetl;
    
  //  @XmlElement(nillable=false)
    private String ldUsgCd;
    
  //  @XmlElement(nillable=false)
    private String ldUsgTp;
    
  //  @XmlElement(nillable=false)
    private String applyLdSize;
    
   // @XmlElement(nillable=false)
    private String blLen;
    
   // @XmlElement(nillable=false)
    private String uwtoTp;
    
   // @XmlElement(nillable=false)
    private String uwtoExpirDmt;
    
   // @XmlElement(nillable=false)
    private String pmtCondCd;
    
 //   @XmlElement(nillable=false)
    private String rentPerdYear;
    
 //   @XmlElement(nillable=false)
    private String ldPrcAmt;
    
  //  @XmlElement(nillable=false)
    private String totPrice;
    
   // @XmlElement(nillable=false)
    private String bapAmt;
    
  //  @XmlElement(nillable=false)
    private String vrfksiDt;
    
 //   @XmlElement(nillable=false)
    private String asingFlg;
    
//    @XmlElement(nillable=false)
    private String createdBy;
    
//    @XmlElement(nillable=false)
    private Date createdTime;
    
 //   @XmlElement(nillable=false)
    private String lastUpdatedBy;
    
 //   @XmlElement(nillable=false)
    private String lastUpdatedTime;
    
    @XmlElement(nillable=false)
    private String hasViewAdmTime;
    
    @XmlElement(nillable=false)
    private String hasViewAdmYN;
    
    @XmlElement(nillable=false)
    private String hasViewTime;
    
    @XmlElement(nillable=false)
    private String hasViewYn;
    
    //@XmlElement(nillable=false)
    private String regRemarkAdmin;
    
 //   @XmlElement(nillable=false)
    private String evalResult;
    
 //   @XmlElement(nillable=false)
    private String custUsername;

    
    public String getIdIPH() {
        return idIPH;
    }

    public void setIdIPH(String idIPH) {
        this.idIPH = idIPH;
    }

    public String getApplyTP() {
        return applyTP;
    }

    public void setApplyTP(String applyTP) {
        this.applyTP = applyTP;
    }

    public String getPenjualId() {
        return penjualId;
    }

    public void setPenjualId(String penjualId) {
        this.penjualId = penjualId;
    }

    public String getPembeliId() {
        return pembeliId;
    }

    public void setPembeliId(String pembeliId) {
        this.pembeliId = pembeliId;
    }

    public String getPemohonId() {
        return pemohonId;
    }

    public void setPemohonId(String pemohonId) {
        this.pemohonId = pemohonId;
    }

    public String getNomorUrutPemohon() {
        return nomorUrutPemohon;
    }

    public void setNomorUrutPemohon(String nomorUrutPemohon) {
        this.nomorUrutPemohon = nomorUrutPemohon;
    }

    public String getDateReceived() {
        return dateReceived;
    }

    public void setDateReceived(String dateReceived) {
        this.dateReceived = dateReceived;
    }

    public String getCertNo() {
        return certNo;
    }

    public void setCertNo(String certNo) {
        this.certNo = certNo;
    }

    public String getTglCert() {
        return tglCert;
    }

    public void setTglCert(String tglCert) {
        this.tglCert = tglCert;
    }

    public String getPlNo() {
        return plNo;
    }

    public void setPlNo(String plNo) {
        this.plNo = plNo;
    }

    public String getTglPl() {
        return tglPl;
    }

    public void setTglPl(String tglPl) {
        this.tglPl = tglPl;
    }

    public String getNoPerjanjian() {
        return noPerjanjian;
    }

    public void setNoPerjanjian(String noPerjanjian) {
        this.noPerjanjian = noPerjanjian;
    }

    public String getTglPerjanjian() {
        return tglPerjanjian;
    }

    public void setTglPerjanjian(String tglPerjanjian) {
        this.tglPerjanjian = tglPerjanjian;
    }

    public String getNoKeputusan() {
        return noKeputusan;
    }

    public void setNoKeputusan(String noKeputusan) {
        this.noKeputusan = noKeputusan;
    }

    public String getTglKeputusan() {
        return tglKeputusan;
    }

    public void setTglKeputusan(String tglKeputusan) {
        this.tglKeputusan = tglKeputusan;
    }

    public String getDocDMT() {
        return docDMT;
    }

    public void setDocDMT(String docDMT) {
        this.docDMT = docDMT;
    }

    public String getApplyLttrSBJT() {
        return applyLttrSBJT;
    }

    public void setApplyLttrSBJT(String applyLttrSBJT) {
        this.applyLttrSBJT = applyLttrSBJT;
    }

    public String getRegRemark() {
        return regRemark;
    }

    public void setRegRemark(String regRemark) {
        this.regRemark = regRemark;
    }

    public String getDocStat() {
        return docStat;
    }

    public void setDocStat(String docStat) {
        this.docStat = docStat;
    }

    public String getApplyStat() {
        return applyStat;
    }

    public void setApplyStat(String applyStat) {
        this.applyStat = applyStat;
    }

    public String getSendUser() {
        return sendUser;
    }

    public void setSendUser(String sendUser) {
        this.sendUser = sendUser;
    }

    public String getAddrCd() {
        return addrCd;
    }

    public void setAddrCd(String addrCd) {
        this.addrCd = addrCd;
    }

    public String getAddrDetl() {
        return addrDetl;
    }

    public void setAddrDetl(String addrDetl) {
        this.addrDetl = addrDetl;
    }

    public String getLdUsgCd() {
        return ldUsgCd;
    }

    public void setLdUsgCd(String ldUsgCd) {
        this.ldUsgCd = ldUsgCd;
    }

    public String getLdUsgTp() {
        return ldUsgTp;
    }

    public void setLdUsgTp(String ldUsgTp) {
        this.ldUsgTp = ldUsgTp;
    }

    public String getApplyLdSize() {
        return applyLdSize;
    }

    public void setApplyLdSize(String applyLdSize) {
        this.applyLdSize = applyLdSize;
    }

    public String getBlLen() {
        return blLen;
    }

    public void setBlLen(String blLen) {
        this.blLen = blLen;
    }

    public String getUwtoTp() {
        return uwtoTp;
    }

    public void setUwtoTp(String uwtoTp) {
        this.uwtoTp = uwtoTp;
    }

    public String getUwtoExpirDmt() {
        return uwtoExpirDmt;
    }

    public void setUwtoExpirDmt(String uwtoExpirDmt) {
        this.uwtoExpirDmt = uwtoExpirDmt;
    }

    public String getPmtCondCd() {
        return pmtCondCd;
    }

    public void setPmtCondCd(String pmtCondCd) {
        this.pmtCondCd = pmtCondCd;
    }

    public String getRentPerdYear() {
        return rentPerdYear;
    }

    public void setRentPerdYear(String rentPerdYear) {
        this.rentPerdYear = rentPerdYear;
    }

    public String getLdPrcAmt() {
        return ldPrcAmt;
    }

    public void setLdPrcAmt(String ldPrcAmt) {
        this.ldPrcAmt = ldPrcAmt;
    }

    public String getTotPrice() {
        return totPrice;
    }

    public void setTotPrice(String totPrice) {
        this.totPrice = totPrice;
    }

    public String getBapAmt() {
        return bapAmt;
    }

    public void setBapAmt(String bapAmt) {
        this.bapAmt = bapAmt;
    }

    public String getVrfksiDt() {
        return vrfksiDt;
    }

    public void setVrfksiDt(String vrfksiDt) {
        this.vrfksiDt = vrfksiDt;
    }

    public String getAsingFlg() {
        return asingFlg;
    }

    public void setAsingFlg(String asingFlg) {
        this.asingFlg = asingFlg;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public String getLastUpdatedTime() {
        return lastUpdatedTime;
    }

    public void setLastUpdatedTime(String lastUpdatedTime) {
        this.lastUpdatedTime = lastUpdatedTime;
    }

    public String getHasViewAdmTime() {
        return hasViewAdmTime;
    }

    public void setHasViewAdmTime(String hasViewAdmTime) {
        this.hasViewAdmTime = hasViewAdmTime;
    }

    public String getHasViewAdmYN() {
        return hasViewAdmYN;
    }

    public void setHasViewAdmYN(String hasViewAdmYN) {
        this.hasViewAdmYN = hasViewAdmYN;
    }

    public String getHasViewTime() {
        return hasViewTime;
    }

    public void setHasViewTime(String hasViewTime) {
        this.hasViewTime = hasViewTime;
    }

    public String getHasViewYn() {
        return hasViewYn;
    }

    public void setHasViewYn(String hasViewYn) {
        this.hasViewYn = hasViewYn;
    }

    public String getRegRemarkAdmin() {
        return regRemarkAdmin;
    }

    public void setRegRemarkAdmin(String regRemarkAdmin) {
        this.regRemarkAdmin = regRemarkAdmin;
    }

    public String getEvalResult() {
        return evalResult;
    }

    public void setEvalResult(String evalResult) {
        this.evalResult = evalResult;
    }

    public String getCustUsername() {
        return custUsername;
    }

    public void setCustUsername(String custUsername) {
        this.custUsername = custUsername;
    }

    public String getApplyNM() {
        return applyNM;
    }

    public void setApplyNM(String applyNM) {
        this.applyNM = applyNM;
    }

    public String getDocStatNM() {
        return docStatNM;
    }

    public void setDocStatNM(String docStatNM) {
        this.docStatNM = docStatNM;
    }

    public String getLdUsgCdNM() {
        return ldUsgCdNM;
    }

    public void setLdUsgCdNM(String ldUsgCdNM) {
        this.ldUsgCdNM = ldUsgCdNM;
    }

    public String getLdUsgTpNM() {
        return ldUsgTpNM;
    }

    public void setLdUsgTpNM(String ldUsgTpNM) {
        this.ldUsgTpNM = ldUsgTpNM;
    }

    public String getAddrCdNM() {
        return addrCdNM;
    }

    public void setAddrCdNM(String addrCdNM) {
        this.addrCdNM = addrCdNM;
    }

    public String getUwtoTpNM() {
        return uwtoTpNM;
    }

    public void setUwtoTpNM(String uwtoTpNM) {
        this.uwtoTpNM = uwtoTpNM;
    }

    public String getPmtCondCdNM() {
        return pmtCondCdNM;
    }

    public void setPmtCondCdNM(String pmtCondCdNM) {
        this.pmtCondCdNM = pmtCondCdNM;
    }
    
    
    
    
    

}
