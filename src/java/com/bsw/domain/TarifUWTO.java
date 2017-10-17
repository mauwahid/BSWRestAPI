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
public class TarifUWTO {

    
    @XmlElement(nillable = false)
    private String caraUwto;
    
    @XmlElement(nillable = false)
    private String periodeSewa;
    
    @XmlElement(nillable = false)
    private String tarifM2;
    
    @XmlElement(nillable = false)
    private String hargaUwto;

    @XmlElement(nillable = false)
    private String bap;

    public String getBap() {
        return bap;
    }

    public void setBap(String bap) {
        this.bap = bap;
    }
    
    
    
    public String getCaraUwto() {
        return caraUwto;
    }

    public void setCaraUwto(String caraUwto) {
        this.caraUwto = caraUwto;
    }

    public String getPeriodeSewa() {
        return periodeSewa;
    }

    public void setPeriodeSewa(String periodeSewa) {
        this.periodeSewa = periodeSewa;
    }

    public String getTarifM2() {
        return tarifM2;
    }

    public void setTarifM2(String tarifM2) {
        this.tarifM2 = tarifM2;
    }

    public String getHargaUwto() {
        return hargaUwto;
    }

    public void setHargaUwto(String hargaUwto) {
        this.hargaUwto = hargaUwto;
    }
    
    
    
}
