/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bsw.domain.reqres;

import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author Maulana Wahid Abdurrahman
 */
public class SaveResponse implements ResponseInterface {

    @XmlElement(nillable = false)
    private String id;
    private String status;
    private String statusDesc;
    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }

}
