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
import com.bsw.domain.reqres.ResponseInterface;
import com.bsw.domain.reqres.StatusResponse;
import com.bsw.utils.Common;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Maulana Wahid Abdurrahman
 */
public class TbBwPematanganDetlController {

    public static TbBwPematanganDetlController getInstance(){
        return new TbBwPematanganDetlController();
    }
    
    
    public  ResponseInterface savePematanganDetl(
            String token, String idPl, String licnsPlType, String licnsPlSeq,
            String licnsPlNo, String createdBy, String fileNm,
            String fileExt, String fileSize,  String addrCd,
            String addrDetl,String licnsVol, String licnsVolTp, String plSize, String plOnr, InputStream uploadFile
            ){
        
        String dateFormat = new SimpleDateFormat("yyyyyMMddHHmmSS").format(new Date());
        String phyFileName = dateFormat+"-"+fileNm;

      //  String pathDir = Common.dirLocation();
        
        StringPath path = Common.dirLocation(TbBwCustController.getUsername(token));
        String absLocation = path.getAbsPath() + phyFileName;
        

       // String phyLocation = pathDir + phyFileName;
        TbbwPematanganDetl tbBwPematanganDetl = new TbbwPematanganDetl();
        tbBwPematanganDetl.setIdPl(idPl);
        tbBwPematanganDetl.setPhyFilePath(path.getRelPath());
        tbBwPematanganDetl.setPyFileNm(phyFileName);
        
        tbBwPematanganDetl.setLicnsPlType(licnsPlType);
        tbBwPematanganDetl.setLicnsPlSeq(licnsPlSeq);
        tbBwPematanganDetl.setLicnsPlNo(licnsPlNo);
        tbBwPematanganDetl.setCreatedBy(createdBy);
        tbBwPematanganDetl.setFileNm(fileNm);
        tbBwPematanganDetl.setFileExt(fileExt);
        tbBwPematanganDetl.setFileSize(fileSize);
       // tbBwPematanganDetl.setIdDetlPl(next);
        tbBwPematanganDetl.setAddrCd(addrCd);
        tbBwPematanganDetl.setAddrDetl(addrDetl);
        tbBwPematanganDetl.setLicnsVol(licnsVol);
        tbBwPematanganDetl.setLicnsVolTp(licnsVolTp);
        tbBwPematanganDetl.setPlSize(plSize);
        tbBwPematanganDetl.setPlOnr(plOnr);
        
       
        
        if(Common.writeToFile(uploadFile, absLocation)>0){
            return TbBwPematanganDetlDao.getInstance().savePematanganDet(tbBwPematanganDetl);
        
        }else{
                StatusResponse response = new StatusResponse();
                response.setStatus("FAILED");
                response.setStatusDesc("WRITE PEMATANGAN DETL FAILED");

                return response;
        }
        
        
   }

    public  ResponseInterface updPematanganDetl(
            String token, String idPl, String licnsPlType, String licnsPlSeq,
            String licnsPlNo, String createdBy, String fileNm,
            String fileExt, String fileSize, String idDetlPL, String addrCd,
            String addrDetl,String licnsVol, String licnsVolTp, String plSize, String plOnr, InputStream uploadFile
            ){
        
        String dateFormat = new SimpleDateFormat("yyyyyMMddHHmmSS").format(new Date());
        String phyFileName = dateFormat+"-"+fileNm;
        
        StringPath path = Common.dirLocation(TbBwCustController.getUsername(token));
        String absLocation = path.getAbsPath() + phyFileName;
        

     //   String pathDir = Common.dirLocation();

      //  String phyLocation = pathDir + phyFileName;
        TbbwPematanganDetl tbBwPematanganDetl = new TbbwPematanganDetl();
        tbBwPematanganDetl.setIdPl(idPl);
        tbBwPematanganDetl.setPhyFilePath(path.getRelPath());
        tbBwPematanganDetl.setPyFileNm(phyFileName);
        
        tbBwPematanganDetl.setLicnsPlType(licnsPlType);
        tbBwPematanganDetl.setLicnsPlSeq(licnsPlSeq);
        tbBwPematanganDetl.setLicnsPlNo(licnsPlNo);
        tbBwPematanganDetl.setCreatedBy(createdBy);
        tbBwPematanganDetl.setFileNm(fileNm);
        tbBwPematanganDetl.setFileExt(fileExt);
        tbBwPematanganDetl.setFileSize(fileSize);
        tbBwPematanganDetl.setIdDetlPl(idDetlPL);
        tbBwPematanganDetl.setAddrCd(addrCd);
        tbBwPematanganDetl.setAddrDetl(addrDetl);
        tbBwPematanganDetl.setLicnsVol(licnsVol);
        tbBwPematanganDetl.setLicnsVolTp(licnsVolTp);
        tbBwPematanganDetl.setPlSize(licnsVol);
        tbBwPematanganDetl.setPlOnr(plOnr);
        
       
        
        if(Common.writeToFile(uploadFile, absLocation)>0){
            return TbBwPematanganDetlDao.getInstance().updPematanganDet(tbBwPematanganDetl);
        
        }else{
                StatusResponse response = new StatusResponse();
                response.setStatus("FAILED");
                response.setStatusDesc("WRITE PEMATANGAN DETL FAILED");

                return response;
        }
        
        
   }

    
     public ResponseInterface delete(String idPL,String licnsPlType){
        return TbBwPematanganDetlDao.getInstance().deletePematanganDetl(idPL,licnsPlType);
    }
    
}
