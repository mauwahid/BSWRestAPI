/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bsw.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Maulana Wahid Abdurrahman
 */
@XmlRootElement
public class TbbwPematangan implements Serializable {
    //private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
  //  @XmlElement(nillable=false)
    private String idPl;
    
  //  @XmlElement(nillable=false)
    private String bfLicnMgmtNo;
    
   // @XmlElement(nillable=false)
    private String licnAplyLttrNo;
    
  //  @XmlElement(nillable=false)
    private String licnAplyDmt;
    
  //  @XmlElement(nillable=false)
    private String licnApltId;
    
  //  @XmlElement(nillable=false)
    private Date licnIssuDmt;
    
  //  @XmlElement(nillable=false)
    private Date excuInspDmt;
    
  //  @XmlElement(nillable=false)
    private String updtUserId;
    
  //  @XmlElement(nillable=false)
    private Date updtDmt;
    
  //  @XmlElement(nillable=false)
    private String evalRslt;
    
  //  @XmlElement(nillable=false)
    private String evalOpi;
    
   // @XmlElement(nillable=false)
    private String excuInspRslt;
    
  //  @XmlElement(nillable=false)
    private String licnAplyTp;
    
  //  @XmlElement(nillable=false)
    private String executer;
 //   @XmlElement(nillable=false)
    private Date rsDmt;
 //   @XmlElement(nillable=false)
    private Date rtDocDmt;
    
 //   @XmlElement(nillable=false)
    private Date bartWdDmt;
    
  //  @XmlElement(nillable=false)
    private Date mtDmt;
    
  //  @XmlElement(nillable=false)
    private Date baplWdDmt;
    
  //  @XmlElement(nillable=false)
    private Date baplMkDmt;
    
  //  @XmlElement(nillable=false)
    private Date srvDmt;
    
  //  @XmlElement(nillable=false)
    private String licnAplyLttrDmt;
    
  //  @XmlElement(nillable=false)
    private Character docCompltYn;
    
  //  @XmlElement(nillable=false)
    private String docCompltOpi;
    
  //  @XmlElement(nillable=false)
    private String statusBsw;
    
 //   @XmlElement(nillable=false)
    private String ketBsw;
    
  //  @XmlElement(nillable=false)
    private BigInteger idCust;
    
   // @XmlElement(nillable=false)
    private String createdBy;
    
  //  @XmlElement(nillable=false)
    private String createdTime;
    
  //  @XmlElement(nillable=false)
    private String lastupdatedBy;
    
  //  @XmlElement(nillable=false)
    private Date lastupdatedTime;
    
  //  @XmlElement(nillable=false)
    private Character hasViewYn;
    
  //  @XmlElement(nillable=false)
    private Date hasViewTime;
    
  //  @XmlElement(nillable=false)
    private Character hasViewAdmYn;
    
  //  @XmlElement(nillable=false)
    private Date hasViewAdmTime;
    
  //  @XmlElement(nillable=false)
    private String licnMgmtNo;
    
   // @XmlElement(nillable=false)
    private Date rfDocDmt;
    
  //  @XmlElement(nillable=false)
    private List<TbbwPematanganDetl> pematanganDetls;
    
  //  @XmlElement(nillable=false)
    private List<TbbwPematanganDoc> pematanganDocs;

    public List<TbbwPematanganDetl> getPematanganDetls() {
        return pematanganDetls;
    }

    public void setPematanganDetls(List<TbbwPematanganDetl> pematanganDetls) {
        this.pematanganDetls = pematanganDetls;
    }

    public List<TbbwPematanganDoc> getPematanganDocs() {
        return pematanganDocs;
    }

    public void setPematanganDocs(List<TbbwPematanganDoc> pematanganDocs) {
        this.pematanganDocs = pematanganDocs;
    }
    
    
    public TbbwPematangan() {
    }

    public TbbwPematangan(String idPl) {
        this.idPl = idPl;
    }

    public TbbwPematangan(String idPl, String createdBy) {
        this.idPl = idPl;
        this.createdBy = createdBy;
//        this.createdTime = createdTime;
    }

    public String getIdPl() {
        return idPl;
    }

    public void setIdPl(String idPl) {
        this.idPl = idPl;
    }

    public String getBfLicnMgmtNo() {
        return bfLicnMgmtNo;
    }

    public void setBfLicnMgmtNo(String bfLicnMgmtNo) {
        this.bfLicnMgmtNo = bfLicnMgmtNo;
    }

    public String getLicnAplyLttrNo() {
        return licnAplyLttrNo;
    }

    public void setLicnAplyLttrNo(String licnAplyLttrNo) {
        this.licnAplyLttrNo = licnAplyLttrNo;
    }

    public String getLicnAplyDmt() {
        return licnAplyDmt;
    }

    public void setLicnAplyDmt(String licnAplyDmt) {
        this.licnAplyDmt = licnAplyDmt;
    }

    public String getLicnApltId() {
        return licnApltId;
    }

    public void setLicnApltId(String licnApltId) {
        this.licnApltId = licnApltId;
    }

    public Date getLicnIssuDmt() {
        return licnIssuDmt;
    }

    public void setLicnIssuDmt(Date licnIssuDmt) {
        this.licnIssuDmt = licnIssuDmt;
    }

    public Date getExcuInspDmt() {
        return excuInspDmt;
    }

    public void setExcuInspDmt(Date excuInspDmt) {
        this.excuInspDmt = excuInspDmt;
    }

    public String getUpdtUserId() {
        return updtUserId;
    }

    public void setUpdtUserId(String updtUserId) {
        this.updtUserId = updtUserId;
    }

    public Date getUpdtDmt() {
        return updtDmt;
    }

    public void setUpdtDmt(Date updtDmt) {
        this.updtDmt = updtDmt;
    }

    public String getEvalRslt() {
        return evalRslt;
    }

    public void setEvalRslt(String evalRslt) {
        this.evalRslt = evalRslt;
    }

    public String getEvalOpi() {
        return evalOpi;
    }

    public void setEvalOpi(String evalOpi) {
        this.evalOpi = evalOpi;
    }

    public String getExcuInspRslt() {
        return excuInspRslt;
    }

    public void setExcuInspRslt(String excuInspRslt) {
        this.excuInspRslt = excuInspRslt;
    }

    public String getLicnAplyTp() {
        return licnAplyTp;
    }

    public void setLicnAplyTp(String licnAplyTp) {
        this.licnAplyTp = licnAplyTp;
    }

    public String getExecuter() {
        return executer;
    }

    public void setExecuter(String executer) {
        this.executer = executer;
    }

    public Date getRsDmt() {
        return rsDmt;
    }

    public void setRsDmt(Date rsDmt) {
        this.rsDmt = rsDmt;
    }

    public Date getRtDocDmt() {
        return rtDocDmt;
    }

    public void setRtDocDmt(Date rtDocDmt) {
        this.rtDocDmt = rtDocDmt;
    }

    public Date getBartWdDmt() {
        return bartWdDmt;
    }

    public void setBartWdDmt(Date bartWdDmt) {
        this.bartWdDmt = bartWdDmt;
    }

    public Date getMtDmt() {
        return mtDmt;
    }

    public void setMtDmt(Date mtDmt) {
        this.mtDmt = mtDmt;
    }

    public Date getBaplWdDmt() {
        return baplWdDmt;
    }

    public void setBaplWdDmt(Date baplWdDmt) {
        this.baplWdDmt = baplWdDmt;
    }

    public Date getBaplMkDmt() {
        return baplMkDmt;
    }

    public void setBaplMkDmt(Date baplMkDmt) {
        this.baplMkDmt = baplMkDmt;
    }

    public Date getSrvDmt() {
        return srvDmt;
    }

    public void setSrvDmt(Date srvDmt) {
        this.srvDmt = srvDmt;
    }

    public String getLicnAplyLttrDmt() {
        return licnAplyLttrDmt;
    }

    public void setLicnAplyLttrDmt(String licnAplyLttrDmt) {
        this.licnAplyLttrDmt = licnAplyLttrDmt;
    }

    public Character getDocCompltYn() {
        return docCompltYn;
    }

    public void setDocCompltYn(Character docCompltYn) {
        this.docCompltYn = docCompltYn;
    }

    public String getDocCompltOpi() {
        return docCompltOpi;
    }

    public void setDocCompltOpi(String docCompltOpi) {
        this.docCompltOpi = docCompltOpi;
    }

    public String getStatusBsw() {
        return statusBsw;
    }

    public void setStatusBsw(String statusBsw) {
        this.statusBsw = statusBsw;
    }

    public String getKetBsw() {
        return ketBsw;
    }

    public void setKetBsw(String ketBsw) {
        this.ketBsw = ketBsw;
    }

    public BigInteger getIdCust() {
        return idCust;
    }

    public void setIdCust(BigInteger idCust) {
        this.idCust = idCust;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getLastupdatedBy() {
        return lastupdatedBy;
    }

    public void setLastupdatedBy(String lastupdatedBy) {
        this.lastupdatedBy = lastupdatedBy;
    }

    public Date getLastupdatedTime() {
        return lastupdatedTime;
    }

    public void setLastupdatedTime(Date lastupdatedTime) {
        this.lastupdatedTime = lastupdatedTime;
    }

    public Character getHasViewYn() {
        return hasViewYn;
    }

    public void setHasViewYn(Character hasViewYn) {
        this.hasViewYn = hasViewYn;
    }

    public Date getHasViewTime() {
        return hasViewTime;
    }

    public void setHasViewTime(Date hasViewTime) {
        this.hasViewTime = hasViewTime;
    }

    public Character getHasViewAdmYn() {
        return hasViewAdmYn;
    }

    public void setHasViewAdmYn(Character hasViewAdmYn) {
        this.hasViewAdmYn = hasViewAdmYn;
    }

    public Date getHasViewAdmTime() {
        return hasViewAdmTime;
    }

    public void setHasViewAdmTime(Date hasViewAdmTime) {
        this.hasViewAdmTime = hasViewAdmTime;
    }

    public String getLicnMgmtNo() {
        return licnMgmtNo;
    }

    public void setLicnMgmtNo(String licnMgmtNo) {
        this.licnMgmtNo = licnMgmtNo;
    }

    public Date getRfDocDmt() {
        return rfDocDmt;
    }

    public void setRfDocDmt(Date rfDocDmt) {
        this.rfDocDmt = rfDocDmt;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPl != null ? idPl.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbbwPematangan)) {
            return false;
        }
        TbbwPematangan other = (TbbwPematangan) object;
        if ((this.idPl == null && other.idPl != null) || (this.idPl != null && !this.idPl.equals(other.idPl))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bsw.domain.TbbwPematangan[ idPl=" + idPl + " ]";
    }

}
