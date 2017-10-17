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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Maulana Wahid Abdurrahman
 */
@XmlRootElement
public class TbbwDocDetermination implements Serializable {
  //  private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @XmlElement(nillable = false)
    private BigDecimal idDocDetermination;
    
    @XmlElement(nillable = false)
    private String comCd;
    
    @XmlElement(nillable = false)
    private String cdNm;

    public String getCdNm() {
        return cdNm;
    }

    public void setCdNm(String cdNm) {
        this.cdNm = cdNm;
    }
    
    @XmlElement(nillable = false)
    private BigInteger adAppList;
    
    @XmlElement(nillable = false)
    private String iskhususYn;
    
    @XmlElement(nillable = false)
    private String createdBy;
    
    @XmlElement(nillable = false)
    private Date createdTime;
    
    @XmlElement(nillable = false)
    private String lastupdatedBy;
    
    @XmlElement(nillable = false)
    private Date lastupdatedTime;
    
    @XmlElement(nillable = false)
    private String ismandatoryYn;
    
    @XmlElement(nillable = false)
    private String isperpanjanganYn;

    public TbbwDocDetermination() {
    }

    public TbbwDocDetermination(BigDecimal idDocDetermination) {
        this.idDocDetermination = idDocDetermination;
    }

    public BigDecimal getIdDocDetermination() {
        return idDocDetermination;
    }

    public void setIdDocDetermination(BigDecimal idDocDetermination) {
        this.idDocDetermination = idDocDetermination;
    }

    public String getComCd() {
        return comCd;
    }

    public void setComCd(String comCd) {
        this.comCd = comCd;
    }

    public BigInteger getAdAppList() {
        return adAppList;
    }

    public void setAdAppList(BigInteger adAppList) {
        this.adAppList = adAppList;
    }

    public String getIskhususYn() {
        return iskhususYn;
    }

    public void setIskhususYn(String iskhususYn) {
        this.iskhususYn = iskhususYn;
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

    public String getIsmandatoryYn() {
        return ismandatoryYn;
    }

    public void setIsmandatoryYn(String ismandatoryYn) {
        this.ismandatoryYn = ismandatoryYn;
    }

    public String getIsperpanjanganYn() {
        return isperpanjanganYn;
    }

    public void setIsperpanjanganYn(String isperpanjanganYn) {
        this.isperpanjanganYn = isperpanjanganYn;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDocDetermination != null ? idDocDetermination.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbbwDocDetermination)) {
            return false;
        }
        TbbwDocDetermination other = (TbbwDocDetermination) object;
        if ((this.idDocDetermination == null && other.idDocDetermination != null) || (this.idDocDetermination != null && !this.idDocDetermination.equals(other.idDocDetermination))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bsw.domain.TbbwDocDetermination[ idDocDetermination=" + idDocDetermination + " ]";
    }

}
