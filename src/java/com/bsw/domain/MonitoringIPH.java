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
public class MonitoringIPH {
    private String jenisPermohonan;
    private String noBsw;
    private String noPl;
    private String status;
    private String statusRegistrasi;
    private String alokasiYangDiminta;
    private String tglSuratMasuk;
    private String verifikasiDate;
    private String bapAmt;
    private String button;
    private String applyTp;
    private String createdBy;
    private String statusEvaluasi;

    public String getStatusEvaluasi() {
        return statusEvaluasi;
    }

    public void setStatusEvaluasi(String statusEvaluasi) {
        this.statusEvaluasi = statusEvaluasi;
    }
    
    

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
    
    

    public String getApplyTp() {
        return applyTp;
    }

    public void setApplyTp(String applyTp) {
        this.applyTp = applyTp;
    }
    
    

    public String getButton() {
        return button;
    }

    public void setButton(String button) {
        this.button = button;
    }
    
    

    public String getVerifikasiDate() {
        return verifikasiDate;
    }

    public void setVerifikasiDate(String verifikasiDate) {
        this.verifikasiDate = verifikasiDate;
    }

    public String getBapAmt() {
        return bapAmt;
    }

    public void setBapAmt(String bapAmt) {
        this.bapAmt = bapAmt;
    }
    
    

    public String getJenisPermohonan() {
        return jenisPermohonan;
    }

    public void setJenisPermohonan(String jenisPermohonan) {
        this.jenisPermohonan = jenisPermohonan;
    }

    public String getNoBsw() {
        return noBsw;
    }

    public void setNoBsw(String noBsw) {
        this.noBsw = noBsw;
    }

    public String getNoPl() {
        return noPl;
    }

    public void setNoPl(String noPl) {
        this.noPl = noPl;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusRegistrasi() {
        return statusRegistrasi;
    }

    public void setStatusRegistrasi(String statusRegistrasi) {
        this.statusRegistrasi = statusRegistrasi;
    }

    public String getAlokasiYangDiminta() {
        return alokasiYangDiminta;
    }

    public void setAlokasiYangDiminta(String alokasiYangDiminta) {
        this.alokasiYangDiminta = alokasiYangDiminta;
    }

    public String getTglSuratMasuk() {
        return tglSuratMasuk;
    }

    public void setTglSuratMasuk(String tglSuratMasuk) {
        this.tglSuratMasuk = tglSuratMasuk;
    }
    
    
    

}
