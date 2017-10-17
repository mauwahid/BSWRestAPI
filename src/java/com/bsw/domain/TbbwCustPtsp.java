/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bsw.domain;

import java.io.Serializable;
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
public class TbbwCustPtsp implements Serializable {
    private static final long serialVersionUID = 1L;
    private String idCust;
    private String npwpCust;
    private String nmCust;
    private String addressCust;
    private String tpCust;
    private Date inputDate;
    private String userInput;

    public TbbwCustPtsp() {
    }

    public TbbwCustPtsp(String idCust) {
        this.idCust = idCust;
    }

    public String getIdCust() {
        return idCust;
    }

    public void setIdCust(String idCust) {
        this.idCust = idCust;
    }

    public String getNpwpCust() {
        return npwpCust;
    }

    public void setNpwpCust(String npwpCust) {
        this.npwpCust = npwpCust;
    }

    public String getNmCust() {
        return nmCust;
    }

    public void setNmCust(String nmCust) {
        this.nmCust = nmCust;
    }

    public String getAddressCust() {
        return addressCust;
    }

    public void setAddressCust(String addressCust) {
        this.addressCust = addressCust;
    }

    public String getTpCust() {
        return tpCust;
    }

    public void setTpCust(String tpCust) {
        this.tpCust = tpCust;
    }

    public Date getInputDate() {
        return inputDate;
    }

    public void setInputDate(Date inputDate) {
        this.inputDate = inputDate;
    }

    public String getUserInput() {
        return userInput;
    }

    public void setUserInput(String userInput) {
        this.userInput = userInput;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCust != null ? idCust.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbbwCustPtsp)) {
            return false;
        }
        TbbwCustPtsp other = (TbbwCustPtsp) object;
        if ((this.idCust == null && other.idCust != null) || (this.idCust != null && !this.idCust.equals(other.idCust))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bsw.domain.TbbwCustPtsp[ idCust=" + idCust + " ]";
    }

}
