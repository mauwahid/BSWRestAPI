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
public class TbBWIPHDetl {
    
    private String idIPH;
    
    private String fileSeq;
    
    private String comCd;
    
    private String fileNm;
    
    private String phyFilePath;
    
    private String phyFileNm;
    
    private String fileExt;
    
    private String fileSize;
    
    private String fileTp;
    
    private String remarks;
    
    private String documentNo;
    
    private String extDmt;
    
    private String fileSeqOrg;
    
    private String createdBy;
    
    private Date createdTime;
    
    private String lastUpdatedBy;
    
    private Date lastUpdatedTime;
    
    private String docTp;
    
    private String comCdNM;
    private String docTpNM;

    public String getComCdNM() {
        return comCdNM;
    }

    public void setComCdNM(String comCdNM) {
        this.comCdNM = comCdNM;
    }

    public String getDocTpNM() {
        return docTpNM;
    }

    public void setDocTpNM(String docTpNM) {
        this.docTpNM = docTpNM;
    }
    
    

    
    public String getIdIPH() {
        return idIPH;
    }

    public void setIdIPH(String idIPH) {
        this.idIPH = idIPH;
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

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public Date getLastUpdatedTime() {
        return lastUpdatedTime;
    }

    public void setLastUpdatedTime(Date lastUpdatedTime) {
        this.lastUpdatedTime = lastUpdatedTime;
    }

    public String getDocTp() {
        return docTp;
    }

    public void setDocTp(String docTp) {
        this.docTp = docTp;
    }
    
    
    

}
