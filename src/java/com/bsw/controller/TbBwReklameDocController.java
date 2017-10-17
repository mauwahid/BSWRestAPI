/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bsw.controller;

import com.bsw.dao.DaoManager;
import com.bsw.domain.StringPath;
import com.bsw.domain.TbBwCust;
import com.bsw.domain.reqres.StatusResponse;
import com.bsw.domain.TbBwReklameDoc;
import com.bsw.utils.Common;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Maulana Wahid Abdurrahman
 */
public class TbBwReklameDocController {

    String fileLocation = "docmob";
    private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(Common.class.getName());
   
    
    public static TbBwReklameDocController getInstance(){
        return new TbBwReklameDocController();
    }
    
    public StatusResponse saveReklameDoc(
            String token, 
            String comCd, 
            String idIr,
            InputStream uploadFile,
            String fileName,
            String extDmt,
            String tipeDocument,
            String extFile,
            String ukuranFile,
            String tipeFile,
            String keterangan,
            String noDocument,
            String fileSeq,
            String createdBy){
        
        System.out.println("FILE SEQ "+fileSeq);
        
        if(LoginController.checkValidation(token)){
         // if(true){
            
            String dateFormat = new SimpleDateFormat("yyyyyMMddHHmmSS").format(new Date());
            String phyFileName = dateFormat+"-"+fileName;
            
        //    String pathDir = Common.dirLocation();
            StringPath path = Common.dirLocation(TbBwCustController.getUsername(token));
        
            String absLocation = path.getAbsPath() + phyFileName;
            String phyLocation = path.getRelPath() + phyFileName;
               
            TbBwReklameDoc tbBwReklameDoc = new TbBwReklameDoc();
            tbBwReklameDoc.setIdDR(idIr);
            tbBwReklameDoc.setComCd(comCd);
            tbBwReklameDoc.setFileNm(fileName);
            tbBwReklameDoc.setPhyFilePath(path.getRelPath());
            tbBwReklameDoc.setPhyFileNm(phyFileName);
            tbBwReklameDoc.setCreatedTime(Common.getCurrentDate());
            tbBwReklameDoc.setDocumentNo(noDocument);
            try {
                tbBwReklameDoc.setExtDmt(Common.convertToDate(extDmt));
            } catch (Exception ex) {
                logger.error(logger.getName()+" : Parsing EXT DMT DATE "+ex.toString());
            }
            
            tbBwReklameDoc.setFileExt(extFile);
         //   tbBwReklameDoc.setFileNm(fileName);
            tbBwReklameDoc.setFileSeq(Integer.parseInt(fileSeq));
            tbBwReklameDoc.setFileSize(ukuranFile);
            tbBwReklameDoc.setFileTp(tipeFile);
           // tbBwReklameDoc.setIdDR(idIr);
          //  tbBwReklameDoc.setPhyFilePath(phyFileName);
            tbBwReklameDoc.setRemarks(keterangan);
            tbBwReklameDoc.setCreatedBy(createdBy);
            
            
         
            try {
                tbBwReklameDoc.setExtDmt(Common.convertToDate(extDmt));
            } catch (Exception ex) {
                Logger.getLogger(TbBwReklameDocController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
            if(Common.writeToFile(uploadFile, absLocation) == 1){
            //  if(true){
               
                return DaoManager.getTbBWReklameDocDao().saveReklameDoc(tbBwReklameDoc);
              /*  StatusResponse response = new StatusResponse();
                response.setStatus("SUCCESS");
                response.setStatusDesc("WRITE REKLAME DOC SUCCESS"); 
                return response; */
            }else{
               
                StatusResponse response = new StatusResponse();
                response.setStatus("FAILED");
                response.setStatusDesc("WRITE REKLAME DOC FAILED");

                return response;
            }
        }else{
           return Common.getErrorResponse(1);
        }
    }
    
    public StatusResponse updReklameDoc(
            String token, 
            String comCd, 
            String idIr,
            InputStream uploadFile,
            String fileName,
            String extDmt,
            String tipeDocument,
            String extFile,
            String ukuranFile,
            String tipeFile,
            String keterangan,
            String noDocument,
            String fileSeq){
        
        if(LoginController.checkValidation(token)){
            
            String dateFormat = new SimpleDateFormat("yyyyyMMddHHmmSS").format(new Date());
            String phyFileName = dateFormat+"-"+fileName;
            
         //   String pathDir = Common.dirLocation();
            
           StringPath path = Common.dirLocation(TbBwCustController.getUsername(token));
           String absLocation = path.getAbsPath() + phyFileName;
        
        
      //      String phyLocation = pathDir + phyFileName;
               
            TbBwReklameDoc tbBwReklameDoc = new TbBwReklameDoc();
            tbBwReklameDoc.setIdDR(idIr);
            tbBwReklameDoc.setComCd(comCd);
            tbBwReklameDoc.setFileNm(fileName);
            tbBwReklameDoc.setPhyFilePath(path.getRelPath());
            tbBwReklameDoc.setPhyFileNm(phyFileName);
            tbBwReklameDoc.setCreatedTime(Common.getCurrentDate());
            tbBwReklameDoc.setDocumentNo(noDocument);
            try {
                tbBwReklameDoc.setExtDmt(Common.convertToDate(extDmt));
            } catch (Exception ex) {
                logger.error(logger.getName()+" : Parsing EXT DMT DATE "+ex.toString());
            }
            
            tbBwReklameDoc.setFileExt(extFile);
         //   tbBwReklameDoc.setFileNm(fileName);
            tbBwReklameDoc.setFileSeq(Integer.parseInt(fileSeq));
            tbBwReklameDoc.setFileSize(ukuranFile);
            tbBwReklameDoc.setFileTp(tipeFile);
           // tbBwReklameDoc.setIdDR(idIr);
          //  tbBwReklameDoc.setPhyFilePath(phyFileName);
            tbBwReklameDoc.setRemarks(keterangan);
            
            
         
            try {
                tbBwReklameDoc.setExtDmt(Common.convertToDate(extDmt));
            } catch (Exception ex) {
                Logger.getLogger(TbBwReklameDocController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
            if(Common.writeToFile(uploadFile, absLocation) == 1){
               
                return DaoManager.getTbBWReklameDocDao().updateReklameDoc(tbBwReklameDoc);
              /*  StatusResponse response = new StatusResponse();
                response.setStatus("SUCCESS");
                response.setStatusDesc("WRITE REKLAME DOC SUCCESS"); 
                return response; */
            }else{
               
                StatusResponse response = new StatusResponse();
                response.setStatus("FAILED");
                response.setStatusDesc("WRITE REKLAME DOC FAILED");

                return response;
            }
        }else{
           return Common.getErrorResponse(1);
        }
    }
    
    
    public StatusResponse deleteReklameDoc(
            String token,
            String idIR, 
            String comCd){
        
        if(LoginController.checkValidation(token)){
            
                return DaoManager.getTbBWReklameDocDao().deleteDoc(idIR, comCd);
              /*  StatusResponse response = new StatusResponse();
                response.setStatus("SUCCESS");
                response.setStatusDesc("WRITE REKLAME DOC SUCCESS"); 
                return response; */
           
        }else{
           return Common.getErrorResponse(1);
        }
    }
    
}
