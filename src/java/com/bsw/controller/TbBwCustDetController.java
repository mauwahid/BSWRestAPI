/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bsw.controller;

import com.bsw.dao.DaoManager;
import com.bsw.domain.StringPath;
import com.bsw.domain.TbBwCustDetil;
import com.bsw.domain.reqres.ResponseInterface;
import com.bsw.domain.reqres.StatusResponse;
import com.bsw.utils.Common;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author Maulana Wahid Abdurrahman
 */
public class TbBwCustDetController {

    private static final Logger logger = Logger.getLogger(TbBwCustDetController.class.getName());
    
    String fileLocation = "docusr";
    
    public static TbBwCustDetController getInstance(){
        return new TbBwCustDetController();
    }
     
    public StatusResponse saveCustDet(String token, 
            String idCust,
            String comCd, 
            InputStream uploadFile,
            String fileName,
            String remarks,
            String docNo,
            String extDmt,
            String fileSize,
            String fileTp,
            String fileExt){
        
        
        
        if(LoginController.checkValidation(token)){
            String dateFormat = new SimpleDateFormat("yyyyyMMddHHmmSS").format(new Date());
            String phyFileName = dateFormat+"-"+fileName;

           // String pathDir = Common.dirLocation();
            
            StringPath path = Common.dirLocation(TbBwCustController.getUsername(token));
            String absLocation = path.getAbsPath() + phyFileName;
        

//            String phyLocation = pathDir + phyFileName;
        
          //  String location = fileLocation + "/" + fileName;
            TbBwCustDetil tbBwCustDetil = new TbBwCustDetil();
            tbBwCustDetil.setComCd(comCd);
            tbBwCustDetil.setFileNm(fileName);
            tbBwCustDetil.setRemarks(remarks);
            tbBwCustDetil.setIdCust(idCust);
            tbBwCustDetil.setDocumentNo(docNo);
            tbBwCustDetil.setPhyFilePath(path.getRelPath());
            tbBwCustDetil.setPhyFileNm(phyFileName + "." + fileExt);
            tbBwCustDetil.setFileExt(fileExt);
            tbBwCustDetil.setFileTp(fileTp);
            tbBwCustDetil.setFileSize(fileSize);
            tbBwCustDetil.setPhyFileNm(dateFormat+"-"+fileName);
           // try {
                tbBwCustDetil.setExtDmt(extDmt);
          /*  } catch (Exception ex) {
                Logger.getLogger(TbBwCustDetController.class.getName()).log(Level.SEVERE, null, ex);
            }
           */ 
            
            if(Common.writeToFile(uploadFile, absLocation) == 1){
               
                return DaoManager.getTbBwCustDetDao().saveDoc(tbBwCustDetil);
            
            }else{
               
                StatusResponse response = new StatusResponse();
                response.setStatus("FAILED");
                response.setStatusDesc("WRITE CUST DOC FAILED");

                return response;
            }
        }else{
           return Common.getErrorResponse(1);
        }
    }
    
    
   public StatusResponse updateDoc(String token,String idCust, String fileName, String fileSize, String fileTipe,
           String username, String remarks, String docNum, String extDmt,
           String comCd,InputStream uploadFile){
       
       System.out.println("-- START UPDATE DOC --");
       
        if(LoginController.checkValidation(token)){
            
            String dateFormat = new SimpleDateFormat("yyyyyMMddHHmmSS").format(new Date());
            String location = fileLocation + "/" + fileName;
            
            String phyFileName = dateFormat+"-"+fileName;

          //  String pathDir = Common.dirLocation();
            
            StringPath path = Common.dirLocation(TbBwCustController.getUsername(token));
            String absLocation = path.getAbsPath() + phyFileName;
        

          //  String phyLocation = pathDir + phyFileName;
       
        
            TbBwCustDetil tbBwCustDetil = new TbBwCustDetil();
            tbBwCustDetil.setComCd(comCd);
            tbBwCustDetil.setFileNm(fileName);
            tbBwCustDetil.setPhyFilePath(path.getRelPath());
          //  tbBwCustDetil.setIdCust(idCust);
            tbBwCustDetil.setIdCust(idCust);
           // try {
                tbBwCustDetil.setExtDmt(extDmt);
          
            tbBwCustDetil.setCreatedBy(username);
            tbBwCustDetil.setFileTp(fileTipe);
            tbBwCustDetil.setRemarks(remarks);
            tbBwCustDetil.setDocumentNo(docNum);
            
            
            tbBwCustDetil.setPhyFileNm(phyFileName);
            if(Common.writeToFile(uploadFile, absLocation) > 0){
               
                return DaoManager.getTbBwCustDetDao().updateDoc(tbBwCustDetil);
            
            }else{
               
                StatusResponse response = new StatusResponse();
                response.setStatus("FAILED");
                response.setStatusDesc("WRITE CUST DOC FAILED RET 0");

                return response;
            }
        }else{
           return Common.getErrorResponse(1);
        }
   }
    
    
    public StatusResponse upsetDet(String token, String comCd, String docNo, String remarks,
            InputStream uploadFile,String fileName,String extDmt){
        
        if(LoginController.checkValidation(token)){
            
            String dateFormat = new SimpleDateFormat("yyyyyMMddHHmmSS").format(new Date());
            String location = fileLocation + "/" + fileName;
            TbBwCustDetil tbBwCustDetil = new TbBwCustDetil();
            tbBwCustDetil.setComCd(comCd);
            tbBwCustDetil.setFileNm(fileName);
            tbBwCustDetil.setPhyFilePath(location);
            tbBwCustDetil.setPhyFileNm(dateFormat+"-"+fileName);
//            try {
                tbBwCustDetil.setExtDmt(extDmt);
  //          } catch (Exception ex) {
    //            Logger.getLogger(TbBwCustDetController.class.getName()).log(Level.SEVERE, null, ex);
      //      }
            
            
            if(writeToFile(uploadFile, location) == 1){
               
                return DaoManager.getTbBwCustDetDao().saveDoc(tbBwCustDetil);
            
            }else{
               
                StatusResponse response = new StatusResponse();
                response.setStatus("FAILED");
                response.setStatusDesc("WRITE CUST DOC FAILED");

                return response;
            }
        }else{
           return Common.getErrorResponse(1);
        }
    }
    
    private int writeToFile(InputStream uploadedInputStream,
		String uploadedFileLocation) {

		try {
                        OutputStream out = new FileOutputStream(new File(
					uploadedFileLocation));
			int read = 0;
			byte[] bytes = new byte[1024];

			out = new FileOutputStream(new File(uploadedFileLocation));
			while ((read = uploadedInputStream.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			out.flush();
			out.close();
                        return 1;
		} catch (IOException e) {

                        logger.error("Error write file : "+e.getMessage());
                        return 0;
		}
    }
     
    
    public List<TbBwCustDetil> getDocument(String token,String userId){
        return DaoManager.getTbBwCustDetDao().getDocs(userId);
    }
    
    public TbBwCustDetil getNPWP(String custId){
        return DaoManager.getTbBwCustDetDao().getNPWP(custId);
    }
    
     public TbBwCustDetil getDoc(String token,String custId,String docTp){
        return DaoManager.getTbBwCustDetDao().getDoc(custId, docTp);
    }
     
      public ResponseInterface deleteDoc(String custId,String docTp){
        return DaoManager.getTbBwCustDetDao().deleteDoc(custId, docTp);
    }
}
