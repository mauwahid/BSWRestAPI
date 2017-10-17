/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bsw.domain;

import java.sql.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Maulana Wahid Abdurrahman
 */
@XmlRootElement
public class TbBwReklame {

  //  @XmlElement(nillable=false)
    private String idIR;
    
    
  //  @XmlElement(nillable=false)
    private String aDClient;
    
 //   @XmlElement(nillable=false)
    private String aDAplyTP;
    
 //   @XmlElement(nillable=false)
    private String aDAplyLttrDMT;
    
 //   @XmlElement(nillable=false)
    private String aDAplyLttrNo;
    
 //   @XmlElement(nillable=false)
    private Date aDAplyDMT;
    
  //  @XmlElement(nillable=false)
    private String aDTeme;
    
 //   @XmlElement(nillable=false)
    private String aDSide;
    
 //   @XmlElement(nillable=false)
    private String aDWid;
    
 //   @XmlElement(nillable=false)
    private String aDLen;
    
  //  @XmlElement(nillable=false)
    private String aDHgt;
    
 //   @XmlElement(nillable=false)
    private String aDLoc;
    
  //  @XmlElement(nillable=false)
    private String aDRmk;
    
  //  @XmlElement(nillable=false)
    private String statusBSW;
    
  //  @XmlElement(nillable=false)
    private String ketBSW;
    
  //  @XmlElement(nillable=false)
    private Date createdTime;
    
  //  @XmlElement(nillable=false)
    private String createdBy;
    
  //  @XmlElement(nillable=false)
    private String idCust;
    
  //  @XmlElement(nillable=false)
    private String adMgmtNo;
    
   // @XmlElement(nillable=false)
    private List<TbBwReklameDoc> reklameDocs;
    
    

    public String getIdIR() {
        return idIR;
    }

    public void setIdIR(String idIR) {
        this.idIR = idIR;
    }

      
    public List<TbBwReklameDoc> getReklameDocs() {
        return reklameDocs;
    }

    public void setReklameDocs(List<TbBwReklameDoc> reklameDocs) {
        this.reklameDocs = reklameDocs;
    }

    public String getaDClient() {
        return aDClient;
    }

    public void setaDClient(String aDClient) {
        this.aDClient = aDClient;
    }

    public String getaDAplyTP() {
        return aDAplyTP;
    }

    public void setaDAplyTP(String aDAplyTP) {
        this.aDAplyTP = aDAplyTP;
    }

    public String getaDAplyLttrDMT() {
        return aDAplyLttrDMT;
    }

    public void setaDAplyLttrDMT(String aDAplyLttrDMT) {
        this.aDAplyLttrDMT = aDAplyLttrDMT;
    }

    public String getaDAplyLttrNo() {
        return aDAplyLttrNo;
    }

    public void setaDAplyLttrNo(String aDAplyLttrNo) {
        this.aDAplyLttrNo = aDAplyLttrNo;
    }

    public Date getaDAplyDMT() {
        return aDAplyDMT;
    }

    public void setaDAplyDMT(Date aDAplyDMT) {
        this.aDAplyDMT = aDAplyDMT;
    }

    public String getaDTeme() {
        return aDTeme;
    }

    public void setaDTeme(String aDTeme) {
        this.aDTeme = aDTeme;
    }

    public String getaDSide() {
        return aDSide;
    }

    public void setaDSide(String aDSide) {
        this.aDSide = aDSide;
    }

    public String getaDWid() {
        return aDWid;
    }

    public void setaDWid(String aDWid) {
        this.aDWid = aDWid;
    }

    public String getaDLen() {
        return aDLen;
    }

    public void setaDLen(String aDLen) {
        this.aDLen = aDLen;
    }

    public String getaDHgt() {
        return aDHgt;
    }

    public void setaDHgt(String aDHgt) {
        this.aDHgt = aDHgt;
    }

    public String getaDLoc() {
        return aDLoc;
    }

    public void setaDLoc(String aDLoc) {
        this.aDLoc = aDLoc;
    }

    public String getaDRmk() {
        return aDRmk;
    }

    public void setaDRmk(String aDRmk) {
        this.aDRmk = aDRmk;
    }

    public String getStatusBSW() {
        return statusBSW;
    }

    public void setStatusBSW(String statusBSW) {
        this.statusBSW = statusBSW;
    }

    public String getKetBSW() {
        return ketBSW;
    }

    public void setKetBSW(String ketBSW) {
        this.ketBSW = ketBSW;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getIdCust() {
        return idCust;
    }

    public void setIdCust(String idCust) {
        this.idCust = idCust;
    }

    public String getAdMgmtNo() {
        return adMgmtNo;
    }

    public void setAdMgmtNo(String adMgmtNo) {
        this.adMgmtNo = adMgmtNo;
    }
    
    
    
    
    
}
