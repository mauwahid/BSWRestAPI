/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bsw.controller;

import com.bsw.dao.TbBwPematanganDetlDao;
import com.bsw.dao.TbBwPematanganDocDao;
import com.bsw.domain.StringPath;
import com.bsw.domain.TbbwPematanganDetl;
import com.bsw.domain.TbbwPematanganDoc;
import com.bsw.domain.reqres.ResponseInterface;
import com.bsw.domain.reqres.StatusResponse;
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
public class TbBwPematanganDocController {

     public static TbBwPematanganDocController getInstance(){
        return new TbBwPematanganDocController();
    }
    
    
    public  ResponseInterface savePematanganDoc(
            String token, String idPl, String comCd, 
            String fileNm, String fileExt, String fileSize, String fileTp,
            String remarks, String documentNo, String extDmt, String createdBy,
            InputStream uploadFile, String fileSeq){
        
        String dateFormat = new SimpleDateFormat("yyyyyMMddHHmmSS").format(new Date());
        String phyFileName = dateFormat+"-"+fileNm;

//        String pathDir = Common.dirLocation();
        StringPath path = Common.dirLocation(TbBwCustController.getUsername(token));
        String absLocation = path.getAbsPath() + phyFileName;
        
        

      //  String phyLocation = pathDir + phyFileName;
        TbbwPematanganDoc tbBwPematanganDoc = new TbbwPematanganDoc();
        tbBwPematanganDoc.setIdPL(idPl);
        tbBwPematanganDoc.setComCd(comCd);
        tbBwPematanganDoc.setFileNm(fileNm);
        tbBwPematanganDoc.setFileExt(fileExt);
        tbBwPematanganDoc.setFileSize(fileSize);
        tbBwPematanganDoc.setFileTp(fileTp);
        tbBwPematanganDoc.setRemarks(remarks);
        
        tbBwPematanganDoc.setFileSeq(fileSeq);
        tbBwPematanganDoc.setDocumentNo(documentNo);
         try {
             tbBwPematanganDoc.setExtDmt(Common.convertToDate(extDmt));
         } catch (Exception ex) {
             Logger.getLogger(TbBwPematanganDocController.class.getName()).log(Level.SEVERE, null, ex);
         }
         
         tbBwPematanganDoc.setCreatedBy(createdBy);
         tbBwPematanganDoc.setPhyFileNm(phyFileName);
         tbBwPematanganDoc.setPhyFilePath(path.getRelPath());
         tbBwPematanganDoc.setFileSeq(fileSeq);
        
       
        
        if(Common.writeToFile(uploadFile, absLocation)>0){
            return TbBwPematanganDocDao.getInstance().savePematanganDoc(tbBwPematanganDoc);
        
        }else{
                StatusResponse response = new StatusResponse();
                response.setStatus("FAILED");
                response.setStatusDesc("WRITE PEMATANGAN DETL FAILED");

                return response;
        }
        
        
   }
    
    
    public  ResponseInterface updatePematanganDoc(
            String token, String idPl, String comCd, 
            String fileNm, String fileExt, String fileSize, String fileTp,
            String remarks, String documentNo, String extDmt, String createdBy,
            InputStream uploadFile, String fileSeq){
        
        String dateFormat = new SimpleDateFormat("yyyyyMMddHHmmSS").format(new Date());
        String phyFileName = dateFormat+"-"+fileNm;

//        String pathDir = Common.dirLocation();
        StringPath path = Common.dirLocation(TbBwCustController.getUsername(token));
        String absLocation = path.getAbsPath() + phyFileName;
        

       // String phyLocation = pathDir + phyFileName;
        TbbwPematanganDoc tbBwPematanganDoc = new TbbwPematanganDoc();
        tbBwPematanganDoc.setIdPL(idPl);
        tbBwPematanganDoc.setComCd(comCd);
        tbBwPematanganDoc.setFileNm(fileNm);
        tbBwPematanganDoc.setFileExt(fileExt);
        tbBwPematanganDoc.setFileSize(fileSize);
        tbBwPematanganDoc.setFileTp(fileTp);
        tbBwPematanganDoc.setRemarks(remarks);
        
        tbBwPematanganDoc.setFileSeq(fileSeq);
        tbBwPematanganDoc.setDocumentNo(documentNo);
         try {
             tbBwPematanganDoc.setExtDmt(Common.convertToDate(extDmt));
         } catch (Exception ex) {
             Logger.getLogger(TbBwPematanganDocController.class.getName()).log(Level.SEVERE, null, ex);
         }
         
         tbBwPematanganDoc.setCreatedBy(createdBy);
         tbBwPematanganDoc.setPhyFileNm(phyFileName + "."+fileExt);
         tbBwPematanganDoc.setPhyFilePath(path.getRelPath());
         tbBwPematanganDoc.setFileSeq(fileSeq);
        
       
        
        if(Common.writeToFile(uploadFile, absLocation)>0){
            return TbBwPematanganDocDao.getInstance().updatePematanganDoc(tbBwPematanganDoc);
        
        }else{
                StatusResponse response = new StatusResponse();
                response.setStatus("FAILED");
                response.setStatusDesc("WRITE PEMATANGAN DETL FAILED");

                return response;
        }
        
        
   }
    
    
    public ResponseInterface transferDoc(String idPL, String comCd, String idCust){
        return TbBwPematanganDocDao.getInstance().transferDoc(idPL, comCd, idCust);
    }
    
    
    public ResponseInterface delete(String idPL,String comCd){
        return TbBwPematanganDocDao.getInstance().deletePematanganDoc(idPL,comCd);
    }
}
