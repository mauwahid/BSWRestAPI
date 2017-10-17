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
 * @author Hansome
 */
@XmlRootElement
public class TbComTMP {
    
    
    @XmlElement(nillable=false)
    private String addrCd;
    
    
    @XmlElement(nillable=false)
    private String comCd;
    
    @XmlElement(nillable=false)
    private String cdNm;
    
    @XmlElement(nillable=false)
    private String cdTp;
    
    @XmlElement(nillable=false)
    private String useYN;
    
    @XmlElement(nillable=false)
    private String cdDesc;
    
    @XmlElement(nillable=false)
    private String dispSeq;
    
    @XmlElement(nillable=false)
    private String regDMT;
    
    @XmlElement(nillable=false)
    private String regEMPID;
    
    @XmlElement(nillable=false)
    private String chgDMT;
    
    @XmlElement(nillable=false)
    private String chgEmpID;

    public String getAddrCd() {
        return addrCd;
    }

    public void setAddrCd(String addrCd) {
        this.addrCd = addrCd;
    }

    
    
    public String getComCd() {
        return comCd;
    }

    public void setComCd(String comCd) {
        this.comCd = comCd;
    }

    public String getCdNm() {
        return cdNm;
    }

    public void setCdNm(String cdNm) {
        this.cdNm = cdNm;
    }

    public String getCdTp() {
        return cdTp;
    }

    public void setCdTp(String cdTp) {
        this.cdTp = cdTp;
    }

    public String getUseYN() {
        return useYN;
    }

    public void setUseYN(String useYN) {
        this.useYN = useYN;
    }

    public String getCdDesc() {
        return cdDesc;
    }

    public void setCdDesc(String cdDesc) {
        this.cdDesc = cdDesc;
    }

    public String getDispSeq() {
        return dispSeq;
    }

    public void setDispSeq(String dispSeq) {
        this.dispSeq = dispSeq;
    }

    public String getRegDMT() {
        return regDMT;
    }

    public void setRegDMT(String regDMT) {
        this.regDMT = regDMT;
    }

    public String getRegEMPID() {
        return regEMPID;
    }

    public void setRegEMPID(String regEMPID) {
        this.regEMPID = regEMPID;
    }

    public String getChgDMT() {
        return chgDMT;
    }

    public void setChgDMT(String chgDMT) {
        this.chgDMT = chgDMT;
    }

    public String getChgEmpID() {
        return chgEmpID;
    }

    public void setChgEmpID(String chgEmpID) {
        this.chgEmpID = chgEmpID;
    }
    
    
    
    
}
