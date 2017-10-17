/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bsw.domain;

import java.sql.Date;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Maulana Wahid Abdurrahman
 */
@XmlRootElement
public class TbBwReklameDoc {
    
  //  @XmlElement(nillable=false)
    private String idDR;
    
  //  @XmlElement(nillable=false)
    private int fileSeq;
    
  //  @XmlElement(nillable=false)
    private String comCd;
    
  //  @XmlElement(nillable=false)
    private String fileNm;
    
 //   @XmlElement(nillable=false)
    private String phyFilePath;
    
 //   @XmlElement(nillable=false)
    private String phyFileNm;
    
  //  @XmlElement(nillable=false)
    private String fileExt;
    
 //   @XmlElement(nillable=false)
    private String fileSize;
    
 //   @XmlElement(nillable=false)
    private String fileTp;
    
 //   @XmlElement(nillable=false)
    private String remarks;
    
 //   @XmlElement(nillable=false)
    private String documentNo;
    
  //  @XmlElement(nillable=false)
    private Date extDmt;
    
  //  @XmlElement(nillable=false)
    private Date createdTime;
    
 //   @XmlElement(nillable=false)
    private String createdBy;
    
    private String comNm;

    public String getComNm() {
        return comNm;
    }

    public void setComNm(String comNm) {
        this.comNm = comNm;
    }
    

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getPhyFilePath() {
        return phyFilePath;
    }

    public void setPhyFilePath(String phyFilePath) {
        this.phyFilePath = phyFilePath;
    }
    
    public String getIdDR() {
        return idDR;
    }

    public void setIdDR(String idDR) {
        this.idDR = idDR;
    }

    public int getFileSeq() {
        return fileSeq;
    }

    public void setFileSeq(int fileSeq) {
        this.fileSeq = fileSeq;
    }

    public String getComCd() {
        return comCd;
    }

    public void setComCd(String comCd) {
        this.comCd = comCd;
    }

    public String getFileNm() {
        return fileNm;
    }

    public void setFileNm(String fileNm) {
        this.fileNm = fileNm;
    }

    public String getPhyFileNm() {
        return phyFileNm;
    }

    public void setPhyFileNm(String phyFileNm) {
        this.phyFileNm = phyFileNm;
    }

    public String getFileExt() {
        return fileExt;
    }

    public void setFileExt(String fileExt) {
        this.fileExt = fileExt;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileTp() {
        return fileTp;
    }

    public void setFileTp(String fileTp) {
        this.fileTp = fileTp;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getDocumentNo() {
        return documentNo;
    }

    public void setDocumentNo(String documentNo) {
        this.documentNo = documentNo;
    }

    public Date getExtDmt() {
        return extDmt;
    }

    public void setExtDmt(Date extDmt) {
        this.extDmt = extDmt;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }
    
    
    

}
