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
public class TbBwCust {
    
   // @XmlElement(nillable=false)
    private String idCust;
    
  //  @XmlElement(nillable=false)
    private String custCd;
    
  //  @XmlElement(nillable=false)
    private String custUsername;
    
  //  @XmlElement(nillable=false)
    private String custNm;
    
  //  @XmlElement(nillable=false)
    private String custTp;
    
   // @XmlElement(nillable=false)
    private String custAddr;
    
  //  @XmlElement(nillable=false)
    private String custZip;
    
  //  @XmlElement(nillable=false)
    private String custTel;
    
   // @XmlElement(nillable=false)
    private String custFax;
    
   // @XmlElement(nillable=false)
    private String custCityNm;
    
   // @XmlElement(nillable=false)
    private String custBirthDt;
    
   // @XmlElement(nillable=false)
    private String custBirthPlcd;
    
   // @XmlElement(nillable=false)
    private String custMarriYn;
    
    //@XmlElement(nillable=false)
    private String custEmail;
    
    //@XmlElement(nillable=false)
    private String custHp;
    
   // @XmlElement(nillable=false)
    private String custJob;
    
   // @XmlElement(nillable=false)
    private String custNtNty;
    
   // @XmlElement(nillable=false)
    private String custGend;
    
   // @XmlElement(nillable=false)
    private String custRmk;
    
   // @XmlElement(nillable=false)
    private String busiTp;
    
  //  @XmlElement(nillable=false)
    private String prgID;
    
   // @XmlElement(nillable=false)
    private String prgNm;
    
   // @XmlElement(nillable=false)
    private String brchNm;
    
   // @XmlElement(nillable=false)
    private String status;
    
   // @XmlElement(nillable=false)
    private String compTp;
    
   // @XmlElement(nillable=false)
    private String compStatCd;
    
    //tambahan dokumen
    private String docNum;
    
    private String docTp;
    
    private String custTpNm;

    public String getCustTpNm() {
        return custTpNm;
    }

    public void setCustTpNm(String custTpNm) {
        this.custTpNm = custTpNm;
    }
    
    
    

    public String getIdCust() {
        return idCust;
    }

    public void setIdCust(String idCust) {
        this.idCust = idCust;
    }

    public String getDocNum() {
        return docNum;
    }

    public void setDocNum(String docNum) {
        this.docNum = docNum;
    }

    public String getDocTp() {
        return docTp;
    }

    public void setDocTp(String docTp) {
        this.docTp = docTp;
    }

  
    
    public String getCustCd() {
        return custCd;
    }

    public void setCustCd(String custCd) {
        this.custCd = custCd;
    }

    public String getCustUsername() {
        return custUsername;
    }

    public void setCustUsername(String custUsername) {
        this.custUsername = custUsername;
    }

    public String getCustNm() {
        return custNm;
    }

    public void setCustNm(String custNm) {
        this.custNm = custNm;
    }

    public String getCustTp() {
        return custTp;
    }

    public void setCustTp(String custTp) {
        this.custTp = custTp;
    }

    public String getCustAddr() {
        return custAddr;
    }

    public void setCustAddr(String custAddr) {
        this.custAddr = custAddr;
    }

    public String getCustZip() {
        return custZip;
    }

    public void setCustZip(String custZip) {
        this.custZip = custZip;
    }

    public String getCustTel() {
        return custTel;
    }

    public void setCustTel(String custTel) {
        this.custTel = custTel;
    }

    public String getCustFax() {
        return custFax;
    }

    public void setCustFax(String custFax) {
        this.custFax = custFax;
    }

    public String getCustCityNm() {
        return custCityNm;
    }

    public void setCustCityNm(String custCityNm) {
        this.custCityNm = custCityNm;
    }

    public String getCustBirthDt() {
        return custBirthDt;
    }

    public void setCustBirthDt(String custBirthDt) {
        this.custBirthDt = custBirthDt;
    }

    public String getCustBirthPlcd() {
        return custBirthPlcd;
    }

    public void setCustBirthPlcd(String custBirthPlcd) {
        this.custBirthPlcd = custBirthPlcd;
    }

    public String getCustMarriYn() {
        return custMarriYn;
    }

    public void setCustMarriYn(String custMarriYn) {
        this.custMarriYn = custMarriYn;
    }

    public String getCustEmail() {
        return custEmail;
    }

    public void setCustEmail(String custEmail) {
        this.custEmail = custEmail;
    }

    public String getCustHp() {
        return custHp;
    }

    public void setCustHp(String custHp) {
        this.custHp = custHp;
    }

    public String getCustJob() {
        return custJob;
    }

    public void setCustJob(String custJob) {
        this.custJob = custJob;
    }

    public String getCustNtNty() {
        return custNtNty;
    }

    public void setCustNtNty(String custNtNty) {
        this.custNtNty = custNtNty;
    }

    public String getCustGend() {
        return custGend;
    }

    public void setCustGend(String custGend) {
        this.custGend = custGend;
    }

    public String getCustRmk() {
        return custRmk;
    }

    public void setCustRmk(String custRmk) {
        this.custRmk = custRmk;
    }

    public String getBusiTp() {
        return busiTp;
    }

    public void setBusiTp(String busiTp) {
        this.busiTp = busiTp;
    }

    public String getPrgID() {
        return prgID;
    }

    public void setPrgID(String prgID) {
        this.prgID = prgID;
    }

    public String getPrgNm() {
        return prgNm;
    }

    public void setPrgNm(String prgNm) {
        this.prgNm = prgNm;
    }

    public String getBrchNm() {
        return brchNm;
    }

    public void setBrchNm(String brchNm) {
        this.brchNm = brchNm;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCompTp() {
        return compTp;
    }

    public void setCompTp(String compTp) {
        this.compTp = compTp;
    }

    public String getCompStatCd() {
        return compStatCd;
    }

    public void setCompStatCd(String compStatCd) {
        this.compStatCd = compStatCd;
    }
    
    

}
