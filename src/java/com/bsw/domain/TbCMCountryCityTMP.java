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
public class TbCMCountryCityTMP {

    @XmlElement(nillable=false)
    private String codeTp;
    
    @XmlElement(nillable=false)
    private String mgmtNo;
    
    @XmlElement(nillable=false)
    private String codeNm;
    
    @XmlElement(nillable=false)
    private String codeAbbr;
    
    @XmlElement(nillable=false)
    private String dispSeq;

    public String getCodeTp() {
        return codeTp;
    }

    public void setCodeTp(String codeTp) {
        this.codeTp = codeTp;
    }

    public String getMgmtNo() {
        return mgmtNo;
    }

    public void setMgmtNo(String mgmtNo) {
        this.mgmtNo = mgmtNo;
    }

    public String getCodeNm() {
        return codeNm;
    }

    public void setCodeNm(String codeNm) {
        this.codeNm = codeNm;
    }

    public String getCodeAbbr() {
        return codeAbbr;
    }

    public void setCodeAbbr(String codeAbbr) {
        this.codeAbbr = codeAbbr;
    }

    public String getDispSeq() {
        return dispSeq;
    }

    public void setDispSeq(String dispSeq) {
        this.dispSeq = dispSeq;
    }
    
    
}
