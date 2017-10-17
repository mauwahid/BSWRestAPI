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
public class MonitoringReklame {
    
    private String noBsw;
    private String perusahaanPenggunaJasa;
    private String status;
    private String noIjinReklame;
    private String jenisPermohonan;
    private String noSuratPermohonan;
    private String tema;
    private String lokasi;
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

    public String getPerusahaanPenggunaJasa() {
        return perusahaanPenggunaJasa;
    }

    public void setPerusahaanPenggunaJasa(String perusahaanPenggunaJasa) {
        this.perusahaanPenggunaJasa = perusahaanPenggunaJasa;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNoIjinReklame() {
        return noIjinReklame;
    }

    public void setNoIjinReklame(String noIjinReklame) {
        this.noIjinReklame = noIjinReklame;
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

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public String getTglSuratMasuk() {
        return tglSuratMasuk;
    }

    public void setTglSuratMasuk(String tglSuratMasuk) {
        this.tglSuratMasuk = tglSuratMasuk;
    }
    
    

}
