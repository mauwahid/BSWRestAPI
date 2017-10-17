/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bsw.controller;

import com.bsw.dao.TbBwPematanganDao;
import com.bsw.dao.TbBwPematanganDocDao;
import com.bsw.domain.MonitoringPematangan;
import com.bsw.domain.TbbwPematangan;
import com.bsw.domain.reqres.ResponseInterface;
import com.bsw.utils.Common;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Maulana Wahid Abdurrahman
 */
public class TbBwPematanganController {

    public static TbBwPematanganController getInstance(){
        return new TbBwPematanganController();
    }
    
    

    public  ResponseInterface savePematangan(
        String token,
        String licnAplyLttrNo,
        String licnAplyDmt,
        String licnApltId,
        String licnAplyTp,
        String executer,
        String licnAplyLttrDmt,
        String statusBsw,
        String createdBy
        ){
        
        TbbwPematangan tbBwPematangan = new TbbwPematangan();
        tbBwPematangan.setLicnAplyLttrNo(licnAplyLttrNo);
        tbBwPematangan.setLicnApltId(licnApltId);
        tbBwPematangan.setLicnAplyTp(licnAplyTp);
        tbBwPematangan.setExecuter(executer);
        tbBwPematangan.setStatusBsw(statusBsw);
        tbBwPematangan.setCreatedBy(createdBy);
        
        try {
            tbBwPematangan.setLicnAplyDmt(licnAplyDmt);
            tbBwPematangan.setLicnAplyLttrDmt(licnAplyLttrDmt);
        
        } catch (Exception ex) {
            Logger.getLogger(TbBwIPHController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return TbBwPematanganDao.getInstance().savePematangan(tbBwPematangan);
        
        
   }
   
    public  List<MonitoringPematangan> monitor2(
        String idPL, String licnAplyId, String licnAplyTp,
             String licnAplyLttrNo){
        
        try {
            return TbBwPematanganDao.getInstance().getMonitoring(idPL, licnAplyId, licnAplyTp, licnAplyLttrNo);
        } catch (SQLException ex) {
        //    Logger.getLogger(TbBwPematanganController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Gagal "+ex.toString());
            return new ArrayList<MonitoringPematangan>();
        }
        
   }
    
   public  List<MonitoringPematangan> monitor(
        String creator){
        try {
            return TbBwPematanganDao.getInstance().getMonitoring(creator);
        } catch (SQLException ex) {
        //    Logger.getLogger(TbBwPematanganController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Gagal "+ex.toString());
            return new ArrayList<MonitoringPematangan>();
        }
   }
   
   public  List<MonitoringPematangan> monitorSort(
        String creator, int tipe, String ascDesc){
        try {
            return TbBwPematanganDao.getInstance().getMonitoringSort(creator, tipe, ascDesc);
        } catch (SQLException ex) {
        //    Logger.getLogger(TbBwPematanganController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Gagal "+ex.toString());
            return new ArrayList<MonitoringPematangan>();
        }
   }
   
   public  List<MonitoringPematangan> monitor(
            String creator,
            String licnAplyLttrNo, String licnApltID, String licnAplyDmt,
            String statusBSW     
   ){
        try {
            return TbBwPematanganDao.getInstance().getMonitoring(creator, licnAplyLttrNo, licnApltID, licnAplyDmt, statusBSW);
        } catch (SQLException ex) {
        //    Logger.getLogger(TbBwPematanganController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Gagal "+ex.toString());
            return new ArrayList<MonitoringPematangan>();
        }
   }
   
   
   public  List<MonitoringPematangan> monitor(
            String creator,
           String licnApltID, String statusBSW, String evalRslt, String licnAplyTp,String licnAplyLttrNo,String licnMgmtNo,String ketBSW,String licnAplyDmt,String licnAplyLtrDmt){
        try {
            return TbBwPematanganDao.getInstance().getMonitoring(creator,licnApltID, statusBSW, evalRslt, licnAplyTp, licnAplyLttrNo, licnMgmtNo, ketBSW, licnAplyDmt, licnAplyLtrDmt);
        } catch (SQLException ex) {
        //    Logger.getLogger(TbBwPematanganController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Gagal "+ex.toString());
            return new ArrayList<MonitoringPematangan>();
        }
   }
   
   public  List<MonitoringPematangan> monitorSort(
            String creator,
           String licnApltID, String statusBSW, String evalRslt, String licnAplyTp,
           String licnAplyLttrNo,String licnMgmtNo,String ketBSW,
           String licnAplyDmt,String licnAplyLtrDmt, int tipe, String ascDesc){
        try {
            return TbBwPematanganDao.getInstance().getMonitoringSort(creator,licnApltID, statusBSW, 
                    evalRslt, licnAplyTp, licnAplyLttrNo, licnMgmtNo, ketBSW, 
                    licnAplyDmt, licnAplyLtrDmt, tipe, ascDesc);
        } catch (SQLException ex) {
        //    Logger.getLogger(TbBwPematanganController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Gagal "+ex.toString());
            return new ArrayList<MonitoringPematangan>();
        }
   }
   
    public  TbbwPematangan getPematangan(String idPL){
            return TbBwPematanganDao.getInstance().getPematangan(idPL); 
   }
   
    public  ResponseInterface updPematangan(
        String token,
        String licnAplyLttrNo,
        String licnAplyDmt,
        String licnApltId,
        String licnAplyTp,
        String executer,
        String licnAplyLttrDmt,
        String statusBsw,
        String createdBy,
        String idPL
        ){
        
        TbbwPematangan tbBwPematangan = new TbbwPematangan();
        tbBwPematangan.setLicnAplyLttrNo(licnAplyLttrNo);
        tbBwPematangan.setLicnApltId(licnApltId);
        tbBwPematangan.setLicnAplyTp(licnAplyTp);
        tbBwPematangan.setExecuter(executer);
        tbBwPematangan.setStatusBsw(statusBsw);
        tbBwPematangan.setCreatedBy(createdBy);
        tbBwPematangan.setIdPl(idPL);
        
        try {
            tbBwPematangan.setLicnAplyDmt(licnAplyDmt);
            tbBwPematangan.setLicnAplyLttrDmt(licnAplyLttrDmt);
        
        } catch (Exception ex) {
            Logger.getLogger(TbBwIPHController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return TbBwPematanganDao.getInstance().updPematangan(tbBwPematangan);
        
        
   }
    
    
    public  ResponseInterface updStatusPematangan(
        String token,
        String statusBsw,
        String idPL
        ){
        
        TbbwPematangan tbBwPematangan = new TbbwPematangan();
        tbBwPematangan.setStatusBsw(statusBsw);
        tbBwPematangan.setIdPl(idPL);
        
        return TbBwPematanganDao.getInstance().updStatusPematangan(tbBwPematangan);
        
        
   }
    
    public ResponseInterface delete(String idPL){
        return TbBwPematanganDao.getInstance().deletePematangan(idPL);
    }
    
    public List getPematanganDetl(String idPL){
        return TbBwPematanganDao.getInstance().getPematanganDetails(idPL);
    }
    
    public List getPematanganDocs(String idPL){
        return TbBwPematanganDao.getInstance().getPematanganDocs(idPL);
    }
   
}
