/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bsw.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Maulana Wahid Abdurrahman
 */
@XmlRootElement
public class TbCmCom {
    
    @XmlElement(nillable=false)
    private String comCd;
    
    @XmlElement(nillable=false)
    private String cdNm;

    @XmlElement(nillable=false)
    private String mustYN;

    public String getMustYN() {
        return mustYN;
    }

    public void setMustYN(String mustYN) {
        this.mustYN = mustYN;
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
    
    

}
