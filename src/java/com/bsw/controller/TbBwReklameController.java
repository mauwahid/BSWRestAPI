/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bsw.controller;

import com.bsw.dao.DaoManager;
import com.bsw.domain.MonitoringReklame;
import com.bsw.domain.reqres.ReklameResponse;
import com.bsw.domain.reqres.ResponseInterface;
import com.bsw.domain.reqres.StatusResponse;
import com.bsw.domain.TbBwReklame;
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
public class TbBwReklameController {

    public static TbBwReklameController getInstance(){
        return new TbBwReklameController();
    }
    
    public ResponseInterface saveReklame(
        String token,
        String aDClient,
        String aDAplyTP,
        String aDAplyLttrDMT,
        String aDAplyLttrNo,
        String aDAplyDMT,
        String aDTeme,
        String aDSide,
        String aDWid,
        String aDLen,
        String aDHgt,   
        String aDLoc,
        String aDRmk,
        String statusBSW,
        String ketBSW,
        String createdBy
       ){
        
        if(LoginController.checkValidation(token)){
            TbBwReklame tbBwReklame = new TbBwReklame();
            tbBwReklame.setCreatedBy(createdBy);
            tbBwReklame.setCreatedTime(Common.getCurrentDate());
            tbBwReklame.setKetBSW(ketBSW);
            tbBwReklame.setStatusBSW(statusBSW);
            
            try{
               tbBwReklame.setaDAplyDMT(Common.convertToDate(aDAplyDMT));
             
            }catch(Exception e){
                System.out.println("EXC "+e.toString());
            }
            
            tbBwReklame.setaDAplyLttrDMT(aDAplyLttrDMT);

            
            tbBwReklame.setaDAplyLttrNo(aDAplyLttrNo);
            tbBwReklame.setaDAplyTP(aDAplyTP);
            tbBwReklame.setaDClient(aDClient);
            tbBwReklame.setaDHgt(aDHgt);
            tbBwReklame.setaDLen(aDLen);
            tbBwReklame.setaDLoc(aDLoc);
            tbBwReklame.setaDRmk(aDRmk);
            tbBwReklame.setaDSide(aDSide);
            tbBwReklame.setaDTeme(aDTeme);
            tbBwReklame.setaDWid(aDWid);
            
            return DaoManager.getTbBWReklameDao().saveReklame(tbBwReklame);
            
            
        }else{
            return Common.getErrorResponse(1);
        }
    }
    
    
    public ResponseInterface updReklame(
        String token,
        String aDClient,
        String aDAplyTP,
        String aDAplyLttrDMT,
        String aDAplyLttrNo,
        String aDAplyDMT,
        String aDTeme,
        String aDSide,
        String aDWid,
        String aDLen,
        String aDHgt,   
        String aDLoc,
        String aDRmk,
        String statusBSW,
        String ketBSW,
        String createdBy,
        String idIR
       ){
        
        if(LoginController.checkValidation(token)){
            TbBwReklame tbBwReklame = new TbBwReklame();
            tbBwReklame.setCreatedBy(createdBy);
            tbBwReklame.setCreatedTime(Common.getCurrentDate());
            tbBwReklame.setKetBSW(ketBSW);
            tbBwReklame.setStatusBSW(statusBSW);
            
            try{
               tbBwReklame.setaDAplyDMT(Common.convertToDate(aDAplyDMT));
               
            }catch(Exception e){
                System.out.println("EXC "+e.toString());
            }
               
            tbBwReklame.setaDAplyLttrDMT(aDAplyLttrDMT);
            
            
            tbBwReklame.setaDAplyLttrNo(aDAplyLttrNo);
            tbBwReklame.setaDAplyTP(aDAplyTP);
            tbBwReklame.setaDClient(aDClient);
            tbBwReklame.setaDHgt(aDHgt);
            tbBwReklame.setaDLen(aDLen);
            tbBwReklame.setaDLoc(aDLoc);
            tbBwReklame.setaDRmk(aDRmk);
            tbBwReklame.setaDSide(aDSide);
            tbBwReklame.setaDTeme(aDTeme);
            tbBwReklame.setaDWid(aDWid);
            tbBwReklame.setIdIR(idIR);
            
            return DaoManager.getTbBWReklameDao().updReklame(tbBwReklame);
            
            
        }else{
            return Common.getErrorResponse(1);
        }
    }
    
     public ResponseInterface updStatusReklame(
        String token,
       String statusBSW,
        String idIR
       ){
        
        if(LoginController.checkValidation(token)){
            TbBwReklame tbBwReklame = new TbBwReklame();
            tbBwReklame.setStatusBSW(statusBSW);
            
            
            tbBwReklame.setIdIR(idIR);
            
            return DaoManager.getTbBWReklameDao().updStatusReklame(tbBwReklame);
            
            
        }else{
            return Common.getErrorResponse(1);
        }
    }
    
    
    public List<MonitoringReklame> monitoring(
        String creator, String adClient, String adAplyTp,
            String adAplyLttrNo, String idIR){
        try {
            return DaoManager.getTbBWReklameDao().getMonitoring(creator, adClient, adAplyTp, adAplyLttrNo, idIR);
        } catch (SQLException ex) {
           System.out.println("Reklame Monitoring "+ex.getMessage());
           return new ArrayList<MonitoringReklame>();
        }
            
    }
    
    public List<MonitoringReklame> monitoring(
        String creator, String adClient, String adAplyTp,
            String adAplyLttrNo, String idIR, int tipe, String ascDesc){
        try {
            return DaoManager.getTbBWReklameDao().getMonitoringSort(creator, adClient, adAplyTp, adAplyLttrNo, idIR, tipe, ascDesc);
        } catch (SQLException ex) {
           System.out.println("Reklame Monitoring "+ex.getMessage());
           return new ArrayList<MonitoringReklame>();
        }
            
    }

    public List<MonitoringReklame> monitoring(String creator){
        try {
            return DaoManager.getTbBWReklameDao().getMonitoring(creator);
        } catch (SQLException ex) {
           System.out.println("Reklame Monitoring "+ex.getMessage());
           return new ArrayList<MonitoringReklame>();
        }
            
    }
    
    
    
    public List<MonitoringReklame> monitoring(String creator, int tipe, String ascDesc){
        try {
            return DaoManager.getTbBWReklameDao().getMonitoringSort(creator, tipe, ascDesc);
        } catch (SQLException ex) {
           System.out.println("Reklame Monitoring "+ex.getMessage());
           return new ArrayList<MonitoringReklame>();
        }
            
    }
    
     public TbBwReklame getReklame(String idIR){
            return DaoManager.getTbBWReklameDao().getReklame(idIR);
            
    }
     
     public List getReklameDocs(String idIR){
            return DaoManager.getTbBWReklameDao().getReklameDocs(idIR);
            
    }
     
     public ResponseInterface deleteReklame(String idIR){
         return DaoManager.getTbBWReklameDao().deleteReklame(idIR);
     }

}
