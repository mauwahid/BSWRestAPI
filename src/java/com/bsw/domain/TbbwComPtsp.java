/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bsw.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Maulana Wahid Abdurrahman
 */
@XmlRootElement
public class TbbwComPtsp implements Serializable {
    private String comId;
    private String comNm;
    private Character comTp;
    private String remark;
    private String dispSeq;
    private Character useYn;

    public TbbwComPtsp() {
    }

    public TbbwComPtsp(String comId) {
        this.comId = comId;
    }

    public String getComId() {
        return comId;
    }

    public void setComId(String comId) {
        this.comId = comId;
    }

    public String getComNm() {
        return comNm;
    }

    public void setComNm(String comNm) {
        this.comNm = comNm;
    }

    public Character getComTp() {
        return comTp;
    }

    public void setComTp(Character comTp) {
        this.comTp = comTp;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getDispSeq() {
        return dispSeq;
    }

    public void setDispSeq(String dispSeq) {
        this.dispSeq = dispSeq;
    }

    public Character getUseYn() {
        return useYn;
    }

    public void setUseYn(Character useYn) {
        this.useYn = useYn;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (comId != null ? comId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbbwComPtsp)) {
            return false;
        }
        TbbwComPtsp other = (TbbwComPtsp) object;
        if ((this.comId == null && other.comId != null) || (this.comId != null && !this.comId.equals(other.comId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bsw.domain.TbbwComPtsp[ comId=" + comId + " ]";
    }

}
