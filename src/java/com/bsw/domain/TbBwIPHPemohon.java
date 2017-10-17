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
public class TbBwIPHPemohon {
    
    private String idIph;
    private String custTp;
    private String custId;
    private String custCd;
    private String custNm;
    private String custNtNy;
    private String custAddr;
    private String prgNm;
    private String status;
    private String custEmail;
    private String custTelp;
    private String ntnty;

    public String getNtnty() {
        return ntnty;
    }

    public void setNtnty(String ntnty) {
        this.ntnty = ntnty;
    }

    public String getIdIph() {
        return idIph;
    }

    public void setIdIph(String idIph) {
        this.idIph = idIph;
    }
    
     public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getCustTp() {
        return custTp;
    }

    public void setCustTp(String custTp) {
        this.custTp = custTp;
    }

    public String getCustCd() {
        return custCd;
    }

    public void setCustCd(String custCd) {
        this.custCd = custCd;
    }

    public String getCustNm() {
        return custNm;
    }

    public void setCustNm(String custNm) {
        this.custNm = custNm;
    }

    public String getCustNtNy() {
        return custNtNy;
    }

    public void setCustNtNy(String custNtNy) {
        this.custNtNy = custNtNy;
    }

    public String getCustAddr() {
        return custAddr;
    }

    public void setCustAddr(String custAddr) {
        this.custAddr = custAddr;
    }

    public String getPrgNm() {
        return prgNm;
    }

    public void setPrgNm(String prgNm) {
        this.prgNm = prgNm;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCustEmail() {
        return custEmail;
    }

    public void setCustEmail(String custEmail) {
        this.custEmail = custEmail;
    }

    public String getCustTelp() {
        return custTelp;
    }

    public void setCustTelp(String custTelp) {
        this.custTelp = custTelp;
    }
    
    

}
