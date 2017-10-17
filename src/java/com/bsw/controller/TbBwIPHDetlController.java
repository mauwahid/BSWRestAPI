/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bsw.controller;

import com.bsw.dao.TbBwIPHDetlDao;
import com.bsw.domain.StringPath;
import com.bsw.domain.TbBWIPHDetl;
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
public class TbBwIPHDetlController {

    public static TbBwIPHDetlController getInstance(){
        return new TbBwIPHDetlController();
    }

    public  ResponseInterface saveIPHDetl(
            String token, String idIph, String fileSeq, String comCd,
            String fileNm, String fileExt, String fileSize,
            String fileTp, String documentNo, String extDmt, String createdBy,
            String docTp,InputStream uploadFile, String remarks
            ){
        
        String dateFormat = new SimpleDateFormat("yyyyyMMddHHmmSS").format(new Date());
        String phyFileName = dateFormat+"-"+fileNm;

       // String pathDir = Common.dirLocation();
        
        StringPath path = Common.dirLocation(TbBwCustController.getUsername(token));
        String absLocation = path.getAbsPath() + phyFileName;
        

    //    String phyLocation = pathDir + phyFileName;
        TbBWIPHDetl tbBwIPHDetl = new TbBWIPHDetl();
        tbBwIPHDetl.setIdIPH(idIph);
        tbBwIPHDetl.setFileSeq(fileSeq);
        tbBwIPHDetl.setComCd(comCd);
        tbBwIPHDetl.setFileNm(fileNm);
        tbBwIPHDetl.setFileExt(fileExt);
        tbBwIPHDetl.setFileSize(fileSize);
        tbBwIPHDetl.setFileTp(fileTp);
        tbBwIPHDetl.setDocumentNo(documentNo);
        tbBwIPHDetl.setPhyFileNm(phyFileName);
        tbBwIPHDetl.setPhyFilePath(path.getRelPath());
        tbBwIPHDetl.setExtDmt(extDmt);
        tbBwIPHDetl.setRemarks(remarks);
        
      /*  try {
            tbBwIPHDetl.setExtDmt(extDmt);
        } catch (Exception ex) {
            Logger.getLogger(TbBwIPHDetlController.class.getName()).log(Level.SEVERE, null, ex);
        } */
        tbBwIPHDetl.setCreatedBy(createdBy);
        tbBwIPHDetl.setDocTp(docTp);
        
        
        if(Common.writeToFile(uploadFile, absLocation)>0){
            return TbBwIPHDetlDao.getInstance(Common.getConnection()).saveIPHDet(tbBwIPHDetl);
        
        }else{
                StatusResponse response = new StatusResponse();
                response.setStatus("FAILED");
                response.setStatusDesc("WRITE REKLAME DOC FAILED RETURN IS 0");

                return response;
        }
        
        
   }
    
    public  ResponseInterface updateIPHDetl(
            String token, String idIph, String fileSeq, String comCd,
            String fileNm, String fileExt, String fileSize,
            String fileTp, String documentNo, String extDmt, String createdBy,
            String docTp,InputStream uploadFile, String remarks
            ){
        
        String dateFormat = new SimpleDateFormat("yyyyyMMddHHmmSS").format(new Date());
        String phyFileName = dateFormat+"-"+fileNm;

       // String pathDir = Common.dirLocation();
        
        StringPath path = Common.dirLocation(TbBwCustController.getUsername(token));
        String absLocation = path.getAbsPath() + phyFileName;
        

    //    String phyLocation = pathDir + phyFileName;
        TbBWIPHDetl tbBwIPHDetl = new TbBWIPHDetl();
        tbBwIPHDetl.setIdIPH(idIph);
        tbBwIPHDetl.setFileSeq(fileSeq);
        tbBwIPHDetl.setComCd(comCd);
        tbBwIPHDetl.setFileNm(fileNm);
        tbBwIPHDetl.setFileExt(fileExt);
        tbBwIPHDetl.setFileSize(fileSize);
        tbBwIPHDetl.setFileTp(fileTp);
        tbBwIPHDetl.setDocumentNo(documentNo);
        tbBwIPHDetl.setPhyFileNm(phyFileName);
        tbBwIPHDetl.setPhyFilePath(path.getRelPath());
        tbBwIPHDetl.setExtDmt(extDmt);
        tbBwIPHDetl.setRemarks(remarks);
       /* try {
            tbBwIPHDetl.setExtDmt(Common.convertToDate(extDmt));
        } catch (Exception ex) {
            Logger.getLogger(TbBwIPHDetlController.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        tbBwIPHDetl.setCreatedBy(createdBy);
        tbBwIPHDetl.setDocTp(docTp);
        
        
        if(Common.writeToFile(uploadFile, absLocation)>0){
            return TbBwIPHDetlDao.getInstance(Common.getConnection()).updateIPHDet(tbBwIPHDetl);
        
        }else{
                StatusResponse response = new StatusResponse();
                response.setStatus("FAILED");
                response.setStatusDesc("WRITE REKLAME DOC FAILED RETURN IS 0");

                return response;
        }
        
        
   }
    
    
    public  ResponseInterface deleteIPHDetl(
            String token, String idIph, String fileSeq, String docTp
            ){
        
            return TbBwIPHDetlDao.getInstance(Common.getConnection()).deleteIPHDet(idIph,fileSeq, docTp);
        
      
   }
    
    
}
