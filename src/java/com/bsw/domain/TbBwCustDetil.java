/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bsw.domain;

import java.sql.Date;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Maulana Wahid Abdurrahman
 */
@XmlRootElement
public class TbBwCustDetil {

    private String idCust;
    private String fileSeq;
    private String comCd;
    private String fileNm;
    private String phyFilePath;
    private String phyFileNm;
    private String fileExt;
    private String fileSize;
    private String fileTp;
    private String tempFileYN;
    private String createdBy;
    private Date dateInsert;
    private String comNM;

    public String getComNM() {
        return comNM;
    }

    public void setComNM(String comNM) {
        this.comNM = comNM;
    }
    
    

    public Date getDateInsert() {
        return dateInsert;
    }

    public void setDateInsert(Date dateInsert) {
        this.dateInsert = dateInsert;
    }
 

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
    private String dateUpdate;
    private String remarks;
    private String documentNo;
    private String extDmt;
    private String fileSeqOrg;

    public String getIdCust() {
        return idCust;
    }

    public void setIdCust(String idCust) {
        this.idCust = idCust;
    }

    public String getFileSeq() {
        return fileSeq;
    }

    public void setFileSeq(String fileSeq) {
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

    public String getPhyFilePath() {
        return phyFilePath;
    }

    public void setPhyFilePath(String phyFilePath) {
        this.phyFilePath = phyFilePath;
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

    public String getTempFileYN() {
        return tempFileYN;
    }

    public void setTempFileYN(String tempFileYN) {
        this.tempFileYN = tempFileYN;
    }

   
    public String getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(String dateUpdate) {
        this.dateUpdate = dateUpdate;
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

    public String getExtDmt() {
        return extDmt;
    }

    public void setExtDmt(String extDmt) {
        this.extDmt = extDmt;
    }

    public String getFileSeqOrg() {
        return fileSeqOrg;
    }

    public void setFileSeqOrg(String fileSeqOrg) {
        this.fileSeqOrg = fileSeqOrg;
    }
    
    
}
