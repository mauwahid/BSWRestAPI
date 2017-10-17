/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bsw.domain;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Maulana Wahid Abdurrahman
 */
@XmlRootElement
public class TbBwIPHStatReg {
    
    private String cdStatus;
    private String valStatus;

    public String getCdStatus() {
        return cdStatus;
    }

    public void setCdStatus(String cdStatus) {
        this.cdStatus = cdStatus;
    }

    public String getValStatus() {
        return valStatus;
    }

    public void setValStatus(String valStatus) {
        this.valStatus = valStatus;
    }
    
    

}
