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
public class MonitoringPematangan {
    
    private String noBsw;
    private String namaPemohon;
    private String status;
    private String jenisPermohonan;
    private String noSuratPermohonan;
    private String noIjinPematangan;
    private String tglSuratMasuk;
    private String statusEvaluasi;

    public String getStatusEvaluasi() {
        return statusEvaluasi;
    }

    public void setStatusEvaluasi(String statusEvaluasi) {
        this.statusEvaluasi = statusEvaluasi;
    }
    
    

    public String getNoBsw() {
        return noBsw;
    }

    public void setNoBsw(String noBsw) {
        this.noBsw = noBsw;
    }

    public String getNamaPemohon() {
        return namaPemohon;
    }

    public void setNamaPemohon(String namaPemohon) {
        this.namaPemohon = namaPemohon;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getJenisPermohonan() {
        return jenisPermohonan;
    }

    public void setJenisPermohonan(String jenisPermohonan) {
        this.jenisPermohonan = jenisPermohonan;
    }

    public String getNoSuratPermohonan() {
        return noSuratPermohonan;
    }

    public void setNoSuratPermohonan(String noSuratPermohonan) {
        this.noSuratPermohonan = noSuratPermohonan;
    }

    public String getNoIjinPematangan() {
        return noIjinPematangan;
    }

    public void setNoIjinPematangan(String noIjinPematangan) {
        this.noIjinPematangan = noIjinPematangan;
    }

    public String getTglSuratMasuk() {
        return tglSuratMasuk;
    }

    public void setTglSuratMasuk(String tglSuratMasuk) {
        this.tglSuratMasuk = tglSuratMasuk;
    }
    
    

}
