/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bsw.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Maulana Wahid Abdurrahman
 */
@XmlRootElement
public class TbbwFatwa implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    private BigDecimal idFatwa;
    private String pemohonId;
    private String applyLttrNo;
    private String applyTp;
    private String evalResult;
    private BigInteger aplyLdSize;
    private String plNo;
    private String usgCd;
    private String usgTp;
    private String addrCd;
    private String addrDetl;
    private String regRemark;
    private Date createdTime;
    private String createdBy;
    private Date fatwaDmt;
    private String docStat;
    private Date dateReceived;
    private String fatwaNo;
    private String plOwner;
    private String ldUsgCd;
    private String applyStat;
    private Date vrfksiDmt;
    private String lastupdatedBy;
    private Date lastupdatedTime;
    private Date hasViewAdmTime;
    private Character hasViewAdmYn;
    private Date hasViewTime;
    private Character hasViewYn;
    private String regRemarkAdmin;
    private String custUsername;

    public TbbwFatwa() {
    }

    public TbbwFatwa(BigDecimal idFatwa) {
        this.idFatwa = idFatwa;
    }

    public BigDecimal getIdFatwa() {
        return idFatwa;
    }

    public void setIdFatwa(BigDecimal idFatwa) {
        this.idFatwa = idFatwa;
    }

    public String getPemohonId() {
        return pemohonId;
    }

    public void setPemohonId(String pemohonId) {
        this.pemohonId = pemohonId;
    }

    public String getApplyLttrNo() {
        return applyLttrNo;
    }

    public void setApplyLttrNo(String applyLttrNo) {
        this.applyLttrNo = applyLttrNo;
    }

    public String getApplyTp() {
        return applyTp;
    }

    public void setApplyTp(String applyTp) {
        this.applyTp = applyTp;
    }

    public String getEvalResult() {
        return evalResult;
    }

    public void setEvalResult(String evalResult) {
        this.evalResult = evalResult;
    }

    public BigInteger getAplyLdSize() {
        return aplyLdSize;
    }

    public void setAplyLdSize(BigInteger aplyLdSize) {
        this.aplyLdSize = aplyLdSize;
    }

    public String getPlNo() {
        return plNo;
    }

    public void setPlNo(String plNo) {
        this.plNo = plNo;
    }

    public String getUsgCd() {
        return usgCd;
    }

    public void setUsgCd(String usgCd) {
        this.usgCd = usgCd;
    }

    public String getUsgTp() {
        return usgTp;
    }

    public void setUsgTp(String usgTp) {
        this.usgTp = usgTp;
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

    public String getRegRemark() {
        return regRemark;
    }

    public void setRegRemark(String regRemark) {
        this.regRemark = regRemark;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getFatwaDmt() {
        return fatwaDmt;
    }

    public void setFatwaDmt(Date fatwaDmt) {
        this.fatwaDmt = fatwaDmt;
    }

    public String getDocStat() {
        return docStat;
    }

    public void setDocStat(String docStat) {
        this.docStat = docStat;
    }

    public Date getDateReceived() {
        return dateReceived;
    }

    public void setDateReceived(Date dateReceived) {
        this.dateReceived = dateReceived;
    }

    public String getFatwaNo() {
        return fatwaNo;
    }

    public void setFatwaNo(String fatwaNo) {
        this.fatwaNo = fatwaNo;
    }

    public String getPlOwner() {
        return plOwner;
    }

    public void setPlOwner(String plOwner) {
        this.plOwner = plOwner;
    }

    public String getLdUsgCd() {
        return ldUsgCd;
    }

    public void setLdUsgCd(String ldUsgCd) {
        this.ldUsgCd = ldUsgCd;
    }

    public String getApplyStat() {
        return applyStat;
    }

    public void setApplyStat(String applyStat) {
        this.applyStat = applyStat;
    }

    public Date getVrfksiDmt() {
        return vrfksiDmt;
    }

    public void setVrfksiDmt(Date vrfksiDmt) {
        this.vrfksiDmt = vrfksiDmt;
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

    public Date getHasViewAdmTime() {
        return hasViewAdmTime;
    }

    public void setHasViewAdmTime(Date hasViewAdmTime) {
        this.hasViewAdmTime = hasViewAdmTime;
    }

    public Character getHasViewAdmYn() {
        return hasViewAdmYn;
    }

    public void setHasViewAdmYn(Character hasViewAdmYn) {
        this.hasViewAdmYn = hasViewAdmYn;
    }

    public Date getHasViewTime() {
        return hasViewTime;
    }

    public void setHasViewTime(Date hasViewTime) {
        this.hasViewTime = hasViewTime;
    }

    public Character getHasViewYn() {
        return hasViewYn;
    }

    public void setHasViewYn(Character hasViewYn) {
        this.hasViewYn = hasViewYn;
    }

    public String getRegRemarkAdmin() {
        return regRemarkAdmin;
    }

    public void setRegRemarkAdmin(String regRemarkAdmin) {
        this.regRemarkAdmin = regRemarkAdmin;
    }

    public String getCustUsername() {
        return custUsername;
    }

    public void setCustUsername(String custUsername) {
        this.custUsername = custUsername;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFatwa != null ? idFatwa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbbwFatwa)) {
            return false;
        }
        TbbwFatwa other = (TbbwFatwa) object;
        if ((this.idFatwa == null && other.idFatwa != null) || (this.idFatwa != null && !this.idFatwa.equals(other.idFatwa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bsw.domain.TbbwFatwa[ idFatwa=" + idFatwa + " ]";
    }

}
