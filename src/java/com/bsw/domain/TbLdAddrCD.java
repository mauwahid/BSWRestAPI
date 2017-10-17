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
public class TbLdAddrCD {
    
    
    @XmlElement(nillable=false)
    private String addrCD;
    
    @XmlElement(nillable=false)
    private String wilNm;
    
    @XmlElement(nillable=false)
    private String subWilNm;
    
    @XmlElement(nillable=false)
    private String dstrtNm;
    
    @XmlElement(nillable=false)
    private String subDstrtNm;
    
    @XmlElement(nillable=false)
    private String plRgnCd;
    
    @XmlElement(nillable=false)
    private String subDitCd;
    
    @XmlElement(nillable=false)
    private String rgnSize;

    public String getAddrCD() {
        return addrCD;
    }

    public void setAddrCD(String addrCD) {
        this.addrCD = addrCD;
    }

    public String getWilNm() {
        return wilNm;
    }

    public void setWilNm(String wilNm) {
        this.wilNm = wilNm;
    }

    public String getSubWilNm() {
        return subWilNm;
    }

    public void setSubWilNm(String subWilNm) {
        this.subWilNm = subWilNm;
    }

    public String getDstrtNm() {
        return dstrtNm;
    }

    public void setDstrtNm(String dstrtNm) {
        this.dstrtNm = dstrtNm;
    }

    public String getSubDstrtNm() {
        return subDstrtNm;
    }

    public void setSubDstrtNm(String subDstrtNm) {
        this.subDstrtNm = subDstrtNm;
    }

    public String getPlRgnCd() {
        return plRgnCd;
    }

    public void setPlRgnCd(String plRgnCd) {
        this.plRgnCd = plRgnCd;
    }

    public String getSubDitCd() {
        return subDitCd;
    }

    public void setSubDitCd(String subDitCd) {
        this.subDitCd = subDitCd;
    }

    public String getRgnSize() {
        return rgnSize;
    }

    public void setRgnSize(String rgnSize) {
        this.rgnSize = rgnSize;
    }
    
    

}
