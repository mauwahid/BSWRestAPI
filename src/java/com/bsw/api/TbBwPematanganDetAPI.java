/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bsw.api;

import com.bsw.controller.TbBwCustController;
import com.bsw.controller.TbBwPematanganDetlController;
import com.bsw.domain.reqres.ResponseInterface;
import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;
import java.io.InputStream;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Maulana Wahid Abdurrahman
 */
@Stateless
@Path("pematangandet")
public class TbBwPematanganDetAPI {

    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces("application/json")
    @Path("/save")
    public ResponseInterface savePematanganDet(
          @FormDataParam("token")String token, 
          @FormDataParam("idPl")String idPl,
          @FormDataParam("licnsPlType")String licnsPlType,
          @FormDataParam("licnsPlSeq")String licnsPlSeq,
          @FormDataParam("licnsPlNo")String licnsPlNo, 
          @FormDataParam("createdBy")String createdBy, 
          @FormDataParam("fileNm")String fileNm,
          @FormDataParam("fileExt")String fileExt, 
          @FormDataParam("fileSize")String fileSize, 
          @FormDataParam("addrCd")String addrCd,
          @FormDataParam("addrDetl")String addrDetl,
          @FormDataParam("licnsVol")String licnsVol,
          @FormDataParam("licnsVolTp")String licnsVolTp, 
          @FormDataParam("plSize")String plSize, 
          @FormDataParam("plOnr")String plOnr,
          @FormDataParam("file")InputStream uploadedInputStream,
          @FormDataParam("file") FormDataContentDisposition fileDetail){
       
        if(TbBwCustController.getInstance().isValidToken(token)==0){
            return null;
        }
        
      //  System.out.println("LICNS ")
        return new TbBwPematanganDetlController().getInstance().savePematanganDetl(token, idPl, licnsPlType, licnsPlSeq, licnsPlNo, createdBy, fileNm, fileExt, fileSize, addrCd, addrDetl, licnsVol, licnsVolTp, plSize, plOnr, uploadedInputStream);
                
    }
    
    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces("application/json")
    @Path("/update")
    public ResponseInterface updPematanganDet(
          @FormDataParam("token")String token, 
          @FormDataParam("idPl")String idPl,
          @FormDataParam("licnsPlType")String licnsPlType,
          @FormDataParam("licnsPlSeq")String licnsPlSeq,
          @FormDataParam("licnsPlNo")String licnsPlNo, 
          @FormDataParam("createdBy")String createdBy, 
          @FormDataParam("fileNm")String fileNm,
          @FormDataParam("fileExt")String fileExt, 
          @FormDataParam("fileSize")String fileSize, 
          @FormDataParam("idDetlPL")String idDetlPL, 
          @FormDataParam("addrCd")String addrCd,
          @FormDataParam("addrDetl")String addrDetl,
          @FormDataParam("licnsVol")String licnsVol,
          @FormDataParam("licnsVolTp")String licnsVolTp, 
          @FormDataParam("plSize")String plSize, 
          @FormDataParam("plOnr")String plOnr,
          @FormDataParam("file")InputStream uploadedInputStream,
          @FormDataParam("file") FormDataContentDisposition fileDetail){
       
        if(TbBwCustController.getInstance().isValidToken(token)==0){
            return null;
        }
        
        
        return new TbBwPematanganDetlController().getInstance().updPematanganDetl(token, idPl, licnsPlType, licnsPlSeq, licnsPlNo, createdBy, fileNm, fileExt, fileSize, idDetlPL, addrCd, addrDetl, licnsVol, licnsVolTp, plSize, plOnr, uploadedInputStream);
                
    }
    
    @POST
    @Produces("application/json")
    @Path("/delete")
    public ResponseInterface delPematanganDet(
          @FormParam("token")String token, 
          @FormParam("idPL")String idPl,
          @FormParam("licnsPlType")String licnsPlType
         ){
       
        if(TbBwCustController.getInstance().isValidToken(token)==0){
            return null;
        }
        
        return new TbBwPematanganDetlController().getInstance().delete(idPl, licnsPlType);
                
    }
}
