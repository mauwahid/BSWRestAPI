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
public class TbbwShipTemp implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    private BigDecimal idship;
    private String shipNo;
    private String shipNm;
    private String callSign;
    private String shipTpCd;
    private String shipNtnCd;
    private String shipCor;
    private String imoNo;
    private BigDecimal loaLength;
    private BigDecimal dwtWeight;
    private BigInteger gtWeight;
    private BigDecimal draftLength;
    private String ownerNm;
    private String regPortNm;
    private String compNtnCd;
    private Character activeYn;
    private String regEmpId;
    private Date regDmt;
    private String chgEmpId;
    private Date chgDmt;
    private BigInteger regPortSeq;
    private String remarks;
    private String status;
    private Date dateInsert;
    private Date dateUpdate;
    private String createdby;
    private String updatedby;
    private String reason;
    private String username;

    public TbbwShipTemp() {
    }

    public TbbwShipTemp(BigDecimal idship) {
        this.idship = idship;
    }

    public BigDecimal getIdship() {
        return idship;
    }

    public void setIdship(BigDecimal idship) {
        this.idship = idship;
    }

    public String getShipNo() {
        return shipNo;
    }

    public void setShipNo(String shipNo) {
        this.shipNo = shipNo;
    }

    public String getShipNm() {
        return shipNm;
    }

    public void setShipNm(String shipNm) {
        this.shipNm = shipNm;
    }

    public String getCallSign() {
        return callSign;
    }

    public void setCallSign(String callSign) {
        this.callSign = callSign;
    }

    public String getShipTpCd() {
        return shipTpCd;
    }

    public void setShipTpCd(String shipTpCd) {
        this.shipTpCd = shipTpCd;
    }

    public String getShipNtnCd() {
        return shipNtnCd;
    }

    public void setShipNtnCd(String shipNtnCd) {
        this.shipNtnCd = shipNtnCd;
    }

    public String getShipCor() {
        return shipCor;
    }

    public void setShipCor(String shipCor) {
        this.shipCor = shipCor;
    }

    public String getImoNo() {
        return imoNo;
    }

    public void setImoNo(String imoNo) {
        this.imoNo = imoNo;
    }

    public BigDecimal getLoaLength() {
        return loaLength;
    }

    public void setLoaLength(BigDecimal loaLength) {
        this.loaLength = loaLength;
    }

    public BigDecimal getDwtWeight() {
        return dwtWeight;
    }

    public void setDwtWeight(BigDecimal dwtWeight) {
        this.dwtWeight = dwtWeight;
    }

    public BigInteger getGtWeight() {
        return gtWeight;
    }

    public void setGtWeight(BigInteger gtWeight) {
        this.gtWeight = gtWeight;
    }

    public BigDecimal getDraftLength() {
        return draftLength;
    }

    public void setDraftLength(BigDecimal draftLength) {
        this.draftLength = draftLength;
    }

    public String getOwnerNm() {
        return ownerNm;
    }

    public void setOwnerNm(String ownerNm) {
        this.ownerNm = ownerNm;
    }

    public String getRegPortNm() {
        return regPortNm;
    }

    public void setRegPortNm(String regPortNm) {
        this.regPortNm = regPortNm;
    }

    public String getCompNtnCd() {
        return compNtnCd;
    }

    public void setCompNtnCd(String compNtnCd) {
        this.compNtnCd = compNtnCd;
    }

    public Character getActiveYn() {
        return activeYn;
    }

    public void setActiveYn(Character activeYn) {
        this.activeYn = activeYn;
    }

    public String getRegEmpId() {
        return regEmpId;
    }

    public void setRegEmpId(String regEmpId) {
        this.regEmpId = regEmpId;
    }

    public Date getRegDmt() {
        return regDmt;
    }

    public void setRegDmt(Date regDmt) {
        this.regDmt = regDmt;
    }

    public String getChgEmpId() {
        return chgEmpId;
    }

    public void setChgEmpId(String chgEmpId) {
        this.chgEmpId = chgEmpId;
    }

    public Date getChgDmt() {
        return chgDmt;
    }

    public void setChgDmt(Date chgDmt) {
        this.chgDmt = chgDmt;
    }

    public BigInteger getRegPortSeq() {
        return regPortSeq;
    }

    public void setRegPortSeq(BigInteger regPortSeq) {
        this.regPortSeq = regPortSeq;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDateInsert() {
        return dateInsert;
    }

    public void setDateInsert(Date dateInsert) {
        this.dateInsert = dateInsert;
    }

    public Date getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(Date dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    public String getUpdatedby() {
        return updatedby;
    }

    public void setUpdatedby(String updatedby) {
        this.updatedby = updatedby;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idship != null ? idship.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbbwShipTemp)) {
            return false;
        }
        TbbwShipTemp other = (TbbwShipTemp) object;
        if ((this.idship == null && other.idship != null) || (this.idship != null && !this.idship.equals(other.idship))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bsw.domain.TbbwShipTemp[ idship=" + idship + " ]";
    }

}
