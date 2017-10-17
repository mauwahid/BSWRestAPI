/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bsw.api;

import com.bsw.controller.TbBwCustController;
import com.bsw.controller.TbBwIPHDetlController;
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
@Path("iphdoc")
public class TbBwIPHDetAPI {

    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces("application/json")
    @Path("save")
    public ResponseInterface saveIPH(
            @FormDataParam("token")String token,
            @FormDataParam("idIph")String idIph,
            @FormDataParam("fileSeq") String fileSeq,
            @FormDataParam("comCd")String comCd,
             @FormDataParam("fileExt")String fileExt,
            @FormDataParam("fileTp")String fileTp,
            @FormDataParam("documentNo")String documentNo,
            @FormDataParam("extDmt")String extDmt,
            @FormDataParam("createdBy")String createdBy,
            @FormDataParam("docTp")String docTp,
            @FormDataParam("fileSize")String fileSize,
            @FormDataParam("remarks")String remarks,
            @FormDataParam("file") InputStream uploadedInputStream,
        @FormDataParam("file") FormDataContentDisposition fileDetail){
       
    //    fileDetail.getFileName();
      //  fileDetail.getType();
        
        if(TbBwCustController.getInstance().isValidToken(token)==0){
            return null;
        }
         
        return TbBwIPHDetlController.getInstance().saveIPHDetl(token,idIph, fileSeq, comCd, fileDetail.getFileName(), fileExt, fileSize,fileTp, documentNo, extDmt, createdBy, docTp,uploadedInputStream, remarks);
    }
    
    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces("application/json")
    @Path("update")
    public ResponseInterface updateIPH(
            @FormDataParam("token")String token,
            @FormDataParam("idIph")String idIph,
            @FormDataParam("fileSeq") String fileSeq,
            @FormDataParam("comCd")String comCd,
             @FormDataParam("fileExt")String fileExt,
            @FormDataParam("fileTp")String fileTp,
            @FormDataParam("documentNo")String documentNo,
            @FormDataParam("extDmt")String extDmt,
            @FormDataParam("createdBy")String createdBy,
            @FormDataParam("docTp")String docTp,
            @FormDataParam("remarks")String remarks,
            @FormDataParam("fileSize")String fileSize,
            @FormDataParam("file") InputStream uploadedInputStream,
        @FormDataParam("file") FormDataContentDisposition fileDetail){
       
        if(TbBwCustController.getInstance().isValidToken(token)==0){
            return null;
        }
        
        
        return TbBwIPHDetlController.getInstance().updateIPHDetl(token,idIph, fileSeq, comCd, fileDetail.getFileName(), fileExt, fileSize,fileTp, documentNo, extDmt, createdBy, docTp,uploadedInputStream, remarks);
    }
    
    @POST
    @Produces("application/json")
    @Path("delete")
    public ResponseInterface deleteIPH(
            @FormParam("token")String token,
            @FormParam("idIph")String idIph,
            @FormParam("fileSeq") String fileSeq,
            @FormParam("docTp")String docTp){
       
        if(TbBwCustController.getInstance().isValidToken(token)==0){
            return null;
        }
        
        
        return TbBwIPHDetlController.getInstance().deleteIPHDetl(token,idIph, fileSeq, docTp);
    }
}
