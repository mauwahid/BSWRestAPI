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
public class TbbwPematanganDoc {
    
    private String idPL;
    private String title;
    private String fileSeq;
    private String comCd;
    private String fileNm;
    private String phyFilePath;
    private String phyFileNm;
    private String fileExt;
    private String fileSize;
    private String fileTp;
    private String tempFileYN;
    private String remarks;
    private String documentNo;
    private Date extDmt;
    private String fileSeqOrg;
    private String createdBy;
    private Date createdTime;
    private String lastUpdatedBy;
    private Date lastUpdatedTime;
    private String thrDocNm;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    
    
    public String getIdPL() {
        return idPL;
    }

    public void setIdPL(String idPL) {
        this.idPL = idPL;
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

    public String getThrDocNm() {
        return thrDocNm;
    }

    public void setThrDocNm(String thrDocNm) {
        this.thrDocNm = thrDocNm;
    }
    
    

}
