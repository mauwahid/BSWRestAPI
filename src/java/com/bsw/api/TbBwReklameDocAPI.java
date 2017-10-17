/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bsw.api;

import com.bsw.controller.TbBwCustController;
import com.bsw.controller.TbBwReklameController;
import com.bsw.controller.TbBwReklameDocController;
import com.bsw.domain.reqres.StatusResponse;
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
@Path("reklamedoc")
public class TbBwReklameDocAPI {

    @POST
    @Path("/save")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces("application/json")
    public StatusResponse saveReklameDoc(
        @FormDataParam("token")String token,
        @FormDataParam("comCd")String comCd,
        @FormDataParam("idIR")String idIR,
        @FormDataParam("extdmt")String extDmt,
        @FormDataParam("file") InputStream uploadedInputStream,
        @FormDataParam("file") FormDataContentDisposition fileDetail,
        @FormDataParam("tipeDoc")String tipeDoc,
        @FormDataParam("extFile")String extFile,
        @FormDataParam("ukuranFile")String ukuranFile,
        @FormDataParam("tipeFile")String tipeFile,
        @FormDataParam("keterangan")String keterangan,
        @FormDataParam("noDoc")String noDoc,
        @FormDataParam("fileSeq")String fileSeq,
        @FormDataParam("createdBy")String createdBy){
        
    //    System.out.println("token "+token+" comCd "+comCd);
      //  System.out.println("file name "+fileDetail.getFileName());
        
        if(TbBwCustController.getInstance().isValidToken(token)==0){
            return null;
        }
        
        return TbBwReklameDocController.getInstance().saveReklameDoc(token,
                comCd,
                idIR,
                uploadedInputStream,
                fileDetail.getFileName(),
                extDmt,
                tipeDoc,
                extFile,
                ukuranFile,
                tipeFile,
                keterangan,
                noDoc,
                fileSeq,
                createdBy);
    }
    
    @POST
    @Path("/update")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces("application/json")
    public StatusResponse updateReklameDoc(
        @FormDataParam("token")String token,
        @FormDataParam("comCd")String comCd,
        @FormDataParam("idIR")String idIR,
        @FormDataParam("extdmt")String extDmt,
        @FormDataParam("file") InputStream uploadedInputStream,
        @FormDataParam("file") FormDataContentDisposition fileDetail,
        @FormDataParam("tipeDoc")String tipeDoc,
        @FormDataParam("extFile")String extFile,
        @FormDataParam("ukuranFile")String ukuranFile,
        @FormDataParam("tipeFile")String tipeFile,
        @FormDataParam("keterangan")String keterangan,
        @FormDataParam("noDoc")String noDoc,
        @FormDataParam("fileSeq")String fileSeq){
        
      //  System.out.println("token "+token+" comCd "+comCd);
       // System.out.println("file name "+fileDetail.getFileName());
        
        if(TbBwCustController.getInstance().isValidToken(token)==0){
            return null;
        }
        
        return TbBwReklameDocController.getInstance().updReklameDoc(token,
                comCd,
                idIR,
                uploadedInputStream,
                fileDetail.getFileName(),
                extDmt,
                tipeDoc,
                extFile,
                ukuranFile,
                tipeFile,
                keterangan,
                noDoc,
                fileSeq);
    }
    
    @POST
    @Path("/delete")
    @Produces("application/json")
    public StatusResponse deleteReklameDoc(
        @FormParam("token")String token,
        @FormParam("idIR")String idIR,
        @FormParam("comCd")String comCd){
       
        if(TbBwCustController.getInstance().isValidToken(token)==0){
            return null;
        }
        
        return TbBwReklameDocController.getInstance().deleteReklameDoc(token, idIR, comCd);
    }
}
