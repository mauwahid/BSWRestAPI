/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bsw.controller;

import com.bsw.dao.DaoManager;
import com.bsw.domain.MonitoringIPH;
import com.bsw.domain.TbBWIPH;
import com.bsw.domain.reqres.ResponseInterface;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Maulana Wahid Abdurrahman
 */
public class TbBwIPHController {
    
    
    public static TbBwIPHController getInstance(){
        return new TbBwIPHController();
    }

    public ResponseInterface saveIPH(
      String applyTp, String pemohonId,String penjualId, String pembeliId,
      String plNo, String certNum, String applyLttrNo, String docDmt,
      String applyLttrSbjt, String regRemarks,String docStat, String applyStat,
      String addrCd,String addrDetl,String ldUsgCd, String ldUsgTp, String aplyLdSize, String blLen,
      String uwtoTp, String uwtoExpirDmt, String pmtCondCd, String rentPerdYear, String ldPrcAmt, String totPrc,
      String bapAmt, String vrfksiDt, String asingFlg,String createdBy,String custUsername, String noPerjanjian, 
      String tglPerjanjian, String noKeputusan, String tglKeputusan,String tglPL, String tglCert){
        
        TbBWIPH tbBwIPH = new TbBWIPH();
        tbBwIPH.setApplyTP(applyTp);
        tbBwIPH.setPemohonId(pemohonId);
        tbBwIPH.setPlNo(plNo);
        tbBwIPH.setCertNo(certNum);
        tbBwIPH.setApplyLttrNo(applyLttrNo);
        try {
            tbBwIPH.setDocDMT(docDmt);
        } catch (Exception ex) {
            Logger.getLogger(TbBwIPHController.class.getName()).log(Level.SEVERE, null, ex);
        }
        tbBwIPH.setApplyLttrSBJT(applyLttrSbjt);
        tbBwIPH.setDocStat(docStat);
        tbBwIPH.setApplyStat(applyStat);
        tbBwIPH.setAddrCd(addrCd);
        tbBwIPH.setAddrDetl(addrDetl);
        tbBwIPH.setLdUsgCd(ldUsgCd);
        tbBwIPH.setLdUsgTp(ldUsgTp);
        tbBwIPH.setApplyLdSize(aplyLdSize);
        tbBwIPH.setBlLen(blLen);
        tbBwIPH.setUwtoTp(uwtoTp);
        tbBwIPH.setRegRemark(regRemarks);
        try {
            tbBwIPH.setUwtoExpirDmt(uwtoExpirDmt);
        } catch (Exception ex) {
            Logger.getLogger(TbBwIPHController.class.getName()).log(Level.SEVERE, null, ex);
        }
        tbBwIPH.setPmtCondCd(pmtCondCd);
        tbBwIPH.setRentPerdYear(rentPerdYear);
        tbBwIPH.setLdPrcAmt(ldPrcAmt);
        tbBwIPH.setTotPrice(totPrc);
        tbBwIPH.setBapAmt(bapAmt);
        tbBwIPH.setVrfksiDt(vrfksiDt);
        tbBwIPH.setAsingFlg(asingFlg);
        tbBwIPH.setCreatedBy(createdBy);
        tbBwIPH.setCustUsername(custUsername);
        tbBwIPH.setPembeliId(pembeliId);
        tbBwIPH.setPenjualId(penjualId);
        tbBwIPH.setNoPerjanjian(noPerjanjian);
        tbBwIPH.setTglPerjanjian(tglPerjanjian);
        tbBwIPH.setNoKeputusan(noKeputusan);
        tbBwIPH.setTglKeputusan(tglKeputusan);
        tbBwIPH.setTglPl(tglPL);
        tbBwIPH.setTglCert(tglCert);
        
        System.out.println("tgl cert "+tbBwIPH.getTglCert());
        
        return DaoManager.getTbBWIPHDao().saveIPH(tbBwIPH);
        
        
   }
   
    public List<MonitoringIPH> monitoringIPH(String idIPH, String plNo, String applyStat,
             String fromDate, String toDate, String applyTp, String statVer,String creator){
        try {
            return DaoManager.getTbBWIPHDao().getMonitoring(idIPH, plNo, applyStat, fromDate, toDate, applyTp, statVer, creator);
        } catch (SQLException ex) {
            System.out.println("EXC "+ex);
           return new ArrayList<MonitoringIPH>();
        }
    }
    
    public List<MonitoringIPH> monitoringIPH(String idIPH, String plNo, String applyStat,
             String fromDate, String toDate, String applyTp, String statVer,String creator, int tipe, String ascDesc){
        try {
            return DaoManager.getTbBWIPHDao().getMonitoringSort(idIPH, plNo, applyStat, fromDate, toDate, applyTp, statVer, creator, tipe, ascDesc);
        } catch (SQLException ex) {
            System.out.println("EXC "+ex);
           return new ArrayList<MonitoringIPH>();
        }
    }
    
    public List<MonitoringIPH> monitoringIPH(String creator){
        try {
            return DaoManager.getTbBWIPHDao().getMonitoring(creator);
        } catch (SQLException ex) {
            System.out.println("EXC "+ex);
           return new ArrayList<MonitoringIPH>();
        }
    }
    
    public List<MonitoringIPH> monitoringIPHSort(String creator, int tipe, String content, String ascDesc){
        try {
            return DaoManager.getTbBWIPHDao().getMonitoringSort(creator, tipe,  ascDesc);
        } catch (SQLException ex) {
            System.out.println("EXC "+ex);
           return new ArrayList<MonitoringIPH>();
        }
    }
    
    public TbBWIPH getIPH(String iph){
        try {
            return DaoManager.getTbBWIPHDao().getIPH(iph);
        } catch (SQLException ex) {
            System.out.println("EXC 2 "+ex.toString());
            return new TbBWIPH();
        }
    }
    
    public ResponseInterface updateIPH(
      String idIPH, String applyTp, String pemohonId,
      String plNo, String certNum, String applyLttrNo, String docDmt,
      String applyLttrSbjt, String regRemarks,String docStat, String applyStat,
      String addrCd,String addrDetl,String ldUsgCd, String ldUsgTp, String aplyLdSize, String blLen,
      String uwtoTp, String uwtoExpirDmt, String pmtCondCd, String rentPerdYear, String ldPrcAmt, String totPrc,
      String bapAmt, String vrfksiDt, String asingFlg,String createdBy,String custUsername,
      String noPerjanjian, 
      String tglPerjanjian, String noKeputusan, String tglKeputusan, String tglPL, String tglCert,
      String penjualId, String pembeliId){
        
        TbBWIPH tbBwIPH = new TbBWIPH();
        tbBwIPH.setIdIPH(idIPH);
        tbBwIPH.setApplyTP(applyTp);
        tbBwIPH.setPemohonId(pemohonId);
        tbBwIPH.setPlNo(plNo);
        tbBwIPH.setCertNo(certNum);
        tbBwIPH.setApplyLttrNo(applyLttrNo);
        try {
            tbBwIPH.setDocDMT(docDmt);
        } catch (Exception ex) {
            Logger.getLogger(TbBwIPHController.class.getName()).log(Level.SEVERE, null, ex);
        }
        tbBwIPH.setApplyLttrSBJT(applyLttrSbjt);
        tbBwIPH.setDocStat(docStat);
        tbBwIPH.setApplyStat(applyStat);
        tbBwIPH.setAddrCd(addrCd);
        tbBwIPH.setAddrDetl(addrDetl);
        tbBwIPH.setLdUsgCd(ldUsgCd);
        tbBwIPH.setLdUsgTp(ldUsgTp);
        tbBwIPH.setApplyLdSize(aplyLdSize);
        tbBwIPH.setBlLen(blLen);
        tbBwIPH.setUwtoTp(uwtoTp);
        tbBwIPH.setRegRemark(regRemarks);
        try {
            tbBwIPH.setUwtoExpirDmt(uwtoExpirDmt);
        } catch (Exception ex) {
            Logger.getLogger(TbBwIPHController.class.getName()).log(Level.SEVERE, null, ex);
        }
        tbBwIPH.setPmtCondCd(pmtCondCd);
        tbBwIPH.setRentPerdYear(rentPerdYear);
        tbBwIPH.setLdPrcAmt(ldPrcAmt);
        tbBwIPH.setTotPrice(totPrc);
        tbBwIPH.setBapAmt(bapAmt);
        tbBwIPH.setVrfksiDt(vrfksiDt);
        tbBwIPH.setAsingFlg(asingFlg);
        tbBwIPH.setCreatedBy(createdBy);
        tbBwIPH.setCustUsername(custUsername);
        tbBwIPH.setNoPerjanjian(noPerjanjian);
        tbBwIPH.setTglPerjanjian(tglPerjanjian);
        tbBwIPH.setNoKeputusan(noKeputusan);
        tbBwIPH.setTglKeputusan(tglKeputusan);
        tbBwIPH.setTglCert(tglCert);
        tbBwIPH.setTglPl(tglPL);
        tbBwIPH.setPenjualId(penjualId);
        tbBwIPH.setPembeliId(pembeliId);
        
        
        return DaoManager.getTbBWIPHDao().updateIPH(tbBwIPH);
        
        
   }
    
   public ResponseInterface updateIPH(String date, String idIPH){
        return DaoManager.getTbBWIPHDao().updateVerIPH(date,idIPH);
        
   }
   
   public ResponseInterface updateDocStatIPH(String docStat, String idIPH){
        return DaoManager.getTbBWIPHDao().updateDocStatIPH(docStat,idIPH);
        
   }
   
   public ResponseInterface updateApStatIPH(String apStat, String idIPH){
        return DaoManager.getTbBWIPHDao().updateApStatIPH(apStat,idIPH);
        
   }
   
 
   
    public List getAvailableDate(String token, String applyTp){
        return DaoManager.getTbBWIPHDao().getAvailableDate(applyTp);
        
   }
   
}
