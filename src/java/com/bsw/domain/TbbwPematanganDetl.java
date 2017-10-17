/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bsw.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Maulana Wahid Abdurrahman
 */
@XmlRootElement
public class TbbwPematanganDetl  {
    private String idPl;
    private String licnsPlType;
    private String licnsPlSeq;
    private int licnsVolIn;
    private BigInteger licnsVolOut;
    private BigInteger licnsPlDoc;
    private Date updtDmt;
    private String updtUserId;
    private String licnsPlNo;
    private int licnsRdjtProg;
    private String createdBy;
    private Date createdTime;
    private String lastupdatedBy;
    private Date lastupdatedTime;
    private String fileNm;
    private String phyFilePath;
    private String pyFileNm;
    private String fileExt;
    private String fileSize;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    private String idDetlPl;
    private String thrDocNm;
    private String addrCd;
    private String addrDetl;
    private String licnsVol;
    private String licnsVolTp;
    private String plSize;
    private String plOnr;
    private String oldDat;

    public TbbwPematanganDetl() {
    }

    public TbbwPematanganDetl(String idDetlPl) {
        this.idDetlPl = idDetlPl;
    }

    public TbbwPematanganDetl(String idDetlPl, String idPl, String licnsPlType, String createdBy, Date createdTime) {
        this.idDetlPl = idDetlPl;
        this.idPl = idPl;
        this.licnsPlType = licnsPlType;
        this.createdBy = createdBy;
        this.createdTime = createdTime;
    }

    public String getIdPl() {
        return idPl;
    }

    public void setIdPl(String idPl) {
        this.idPl = idPl;
    }

    public String getLicnsPlType() {
        return licnsPlType;
    }

    public void setLicnsPlType(String licnsPlType) {
        this.licnsPlType = licnsPlType;
    }

    public String getLicnsPlSeq() {
        return licnsPlSeq;
    }

    public void setLicnsPlSeq(String licnsPlSeq) {
        this.licnsPlSeq = licnsPlSeq;
    }

    public int getLicnsVolIn() {
        return licnsVolIn;
    }

    public void setLicnsVolIn(int licnsVolIn) {
        this.licnsVolIn = licnsVolIn;
    }

    public BigInteger getLicnsVolOut() {
        return licnsVolOut;
    }

    public void setLicnsVolOut(BigInteger licnsVolOut) {
        this.licnsVolOut = licnsVolOut;
    }

    public BigInteger getLicnsPlDoc() {
        return licnsPlDoc;
    }

    public void setLicnsPlDoc(BigInteger licnsPlDoc) {
        this.licnsPlDoc = licnsPlDoc;
    }

    public Date getUpdtDmt() {
        return updtDmt;
    }

    public void setUpdtDmt(Date updtDmt) {
        this.updtDmt = updtDmt;
    }

    public String getUpdtUserId() {
        return updtUserId;
    }

    public void setUpdtUserId(String updtUserId) {
        this.updtUserId = updtUserId;
    }

    public String getLicnsPlNo() {
        return licnsPlNo;
    }

    public void setLicnsPlNo(String licnsPlNo) {
        this.licnsPlNo = licnsPlNo;
    }

    public int getLicnsRdjtProg() {
        return licnsRdjtProg;
    }

    public void setLicnsRdjtProg(int licnsRdjtProg) {
        this.licnsRdjtProg = licnsRdjtProg;
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

    public String getLastupdatedBy() {
        return lastupdatedBy;
    }

    public void setLastupdatedBy(String lastupdatedBy) {
        this.lastupdatedBy = lastupdatedBy;
    }

    public Date getLastupdatedTime() {
        return lastupdatedTime;
    }

    public void setLastupdatedTime(Date lastupdatedTime) {
        this.lastupdatedTime = lastupdatedTime;
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

    public String getPyFileNm() {
        return pyFileNm;
    }

    public void setPyFileNm(String pyFileNm) {
        this.pyFileNm = pyFileNm;
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

    public String getIdDetlPl() {
        return idDetlPl;
    }

    public void setIdDetlPl(String idDetlPl) {
        this.idDetlPl = idDetlPl;
    }

    public String getThrDocNm() {
        return thrDocNm;
    }

    public void setThrDocNm(String thrDocNm) {
        this.thrDocNm = thrDocNm;
    }

    public String getAddrCd() {
        return addrCd;
    }

    public void setAddrCd(String addrCd) {
        this.addrCd = addrCd;
    }

    public String getAddrDetl() {
        return addrDetl;
    }

    public void setAddrDetl(String addrDetl) {
        this.addrDetl = addrDetl;
    }

    public String getLicnsVol() {
        return licnsVol;
    }

    public void setLicnsVol(String licnsVol) {
        this.licnsVol = licnsVol;
    }

    public String getLicnsVolTp() {
        return licnsVolTp;
    }

    public void setLicnsVolTp(String licnsVolTp) {
        this.licnsVolTp = licnsVolTp;
    }

    public String getPlSize() {
        return plSize;
    }

    public void setPlSize(String plSize) {
        this.plSize = plSize;
    }

    public String getPlOnr() {
        return plOnr;
    }

    public void setPlOnr(String plOnr) {
        this.plOnr = plOnr;
    }

    public String getOldDat() {
        return oldDat;
    }

    public void setOldDat(String oldDat) {
        this.oldDat = oldDat;
    }

    @Override
    public int hashCode() {
        int hash = 0;
//        hash += (idDetlPl != null ? idDetlPl.hashCode() : 0);
        return hash;
    }

    

    @Override
    public String toString() {
        return "com.bsw.domain.TbbwPematanganDetl[ idDetlPl=" + idDetlPl + " ]";
    }

}
