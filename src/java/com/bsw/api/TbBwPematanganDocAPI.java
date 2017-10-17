/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bsw.api;

import com.bsw.controller.TbBwCustController;
import com.bsw.controller.TbBwPematanganDocController;
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
@Path("pematangandoc")
public class TbBwPematanganDocAPI {

    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces("application/json")
    @Path("save")
    public ResponseInterface savePematanganDoc(
           @FormDataParam("token")String token, 
            @FormDataParam("idPl")String idPl, 
            @FormDataParam("comCd")String comCd, 
            @FormDataParam("fileNm")String fileNm,
            @FormDataParam("fileExt")String fileExt, 
            @FormDataParam("fileSize")String fileSize, 
            @FormDataParam("fileTp")String fileTp,
            @FormDataParam("remarks")String remarks, 
            @FormDataParam("documentNo")String documentNo, 
            @FormDataParam("extDmt")String extDmt, 
            @FormDataParam("createdBy")String createdBy,
            @FormDataParam("fileSeq")String fileSeq,
            @FormDataParam("file")InputStream uploadedInputStream,
        @FormDataParam("file") FormDataContentDisposition fileDetail){
       
        if(TbBwCustController.getInstance().isValidToken(token)==0){
            return null;
        }
        
        System.out.println("file Seq "+fileSeq);
        return new TbBwPematanganDocController().getInstance().savePematanganDoc(token, idPl, comCd, fileNm, fileExt, fileSize, fileTp, remarks, documentNo, extDmt, createdBy, uploadedInputStream, fileSeq);
    }
    
    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces("application/json")
    @Path("update")
    public ResponseInterface updPematanganDoc(
           @FormDataParam("token")String token, 
            @FormDataParam("idPl")String idPl, 
            @FormDataParam("comCd")String comCd, 
            @FormDataParam("fileNm")String fileNm,
            @FormDataParam("fileExt")String fileExt, 
            @FormDataParam("fileSize")String fileSize, 
            @FormDataParam("fileTp")String fileTp,
            @FormDataParam("remarks")String remarks, 
            @FormDataParam("documentNo")String documentNo, 
            @FormDataParam("extDmt")String extDmt, 
            @FormDataParam("createdBy")String createdBy,
            @FormDataParam("fileSeq")String fileSeq,
            @FormDataParam("file")InputStream uploadedInputStream,
        @FormDataParam("file") FormDataContentDisposition fileDetail){
       
        if(TbBwCustController.getInstance().isValidToken(token)==0){
            return null;
        }
        
        return new TbBwPematanganDocController().getInstance().updatePematanganDoc(token, idPl, comCd, fileNm, fileExt, fileSize, fileTp, remarks, documentNo, extDmt, createdBy, uploadedInputStream, fileSeq);
    }
    
    @POST
    @Produces("application/json")
    @Path("transfer")
    public ResponseInterface transferDoc(
           @FormParam("token")String token, 
           @FormParam("idPL")String idPL, 
           @FormParam("comCd")String comCd, 
           @FormParam("idCust")String idCust 
            ){
        
        if(TbBwCustController.getInstance().isValidToken(token)==0){
            return null;
        }
        
        return TbBwPematanganDocController.getInstance().transferDoc(idPL, comCd, idCust);
    }
    
    @POST
    @Produces("application/json")
    @Path("delete")
    public ResponseInterface deleteDoc(
           @FormParam("token")String token,
           @FormParam("idPL")String idPL, 
           @FormParam("comCd")String comCd 
            ){
        
        if(TbBwCustController.getInstance().isValidToken(token)==0){
            return null;
        }
        
        
        return TbBwPematanganDocController.getInstance().delete(idPL, comCd);
    }
}
