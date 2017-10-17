/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bsw.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Maulana Wahid Abdurrahman
 */
@XmlRootElement
public class TbldPrce {

    
    @XmlElement(nillable=false)
    private String ldPrcNo;
    
    @XmlElement(nillable=false)
    private String addrCd;
    
    @XmlElement(nillable=false)
    private String ldUsgCd;
    
    @XmlElement(nillable=false)
    private String ldPrcAmt;
    
    @XmlElement(nillable=false)
    private String rgltNo;
    
    @XmlElement(nillable=false)
    private String vldStart;
    
    @XmlElement(nillable=false)
    private String updtUserId;
    
    @XmlElement(nillable=false)
    private String updtDmt;
    
    @XmlElement(nillable=false)
    private String prcTp;

    
    public String getLdPrcNo() {
        return ldPrcNo;
    }

    public void setLdPrcNo(String ldPrcNo) {
        this.ldPrcNo = ldPrcNo;
    }

    public String getAddrCd() {
        return addrCd;
    }

    public void setAddrCd(String addrCd) {
        this.addrCd = addrCd;
    }

    public String getLdUsgCd() {
        return ldUsgCd;
    }

    public void setLdUsgCd(String ldUsgCd) {
        this.ldUsgCd = ldUsgCd;
    }

    public String getLdPrcAmt() {
        return ldPrcAmt;
    }

    public void setLdPrcAmt(String ldPrcAmt) {
        this.ldPrcAmt = ldPrcAmt;
    }

    public String getRgltNo() {
        return rgltNo;
    }

    public void setRgltNo(String rgltNo) {
        this.rgltNo = rgltNo;
    }

    public String getVldStart() {
        return vldStart;
    }

    public void setVldStart(String vldStart) {
        this.vldStart = vldStart;
    }

    public String getUpdtUserId() {
        return updtUserId;
    }

    public void setUpdtUserId(String updtUserId) {
        this.updtUserId = updtUserId;
    }

    public String getUpdtDmt() {
        return updtDmt;
    }

    public void setUpdtDmt(String updtDmt) {
        this.updtDmt = updtDmt;
    }

    public String getPrcTp() {
        return prcTp;
    }

    public void setPrcTp(String prcTp) {
        this.prcTp = prcTp;
    }
    
    
    
}
