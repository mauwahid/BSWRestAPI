/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bsw.api;

import com.bsw.controller.TbBwCustController;
import com.bsw.controller.TbBwCustDetController;
import com.bsw.domain.TbBwCustDetil;
import com.bsw.domain.reqres.ResponseInterface;
import com.bsw.domain.reqres.StatusResponse;
import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;
import java.io.InputStream;
import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Maulana Wahid Abdurrahman
 */
@Stateless
@Path("userdoc")
public class TbBwCustDetAPI {

    @POST
    @Path("/save")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces("application/json")
    public StatusResponse saveCustDet(
        @FormDataParam("token")String token, 
        @FormDataParam("idcust")String idCust,
        @FormDataParam("comCd")String comCd, 
        @FormDataParam("fileName")String fileName,
        @FormDataParam("remarks")String remarks,
        @FormDataParam("docNo")String docNo,
        @FormDataParam("extDmt")String extDmt,
        @FormDataParam("fileSize")String fileSize,
        @FormDataParam("fileTp")String fileTp,
        @FormDataParam("fileExt")String fileExt,
        @FormDataParam("file") InputStream uploadedInputStream,
        @FormDataParam("file") FormDataContentDisposition fileDetail){
     /*  
        System.out.println("token "+token+" comCd "+comCd);
        System.out.println("file name "+fileDetail.getFileName());
      */
        
         if(TbBwCustController.getInstance().isValidToken(token)==0){
            return null;
        }
        return TbBwCustDetController.getInstance().saveCustDet(token, idCust, comCd, uploadedInputStream, fileName, remarks, docNo, extDmt, fileSize, fileTp, fileExt);
    }
    
    @POST
    @Path("/update")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces("application/json")
    public StatusResponse updateDoc(
        @FormDataParam("token")String token,
        @FormDataParam("idcust")String idCust,
        @FormDataParam("fileName")String fileName,
        @FormDataParam("fileSize")String fileSize, 
        @FormDataParam("fileTipe")String fileTipe,
        @FormDataParam("username")String username, 
        @FormDataParam("remarks")String remarks, 
        @FormDataParam("docNum")String docNum, 
        @FormDataParam("extDmt")String extDmt,
        @FormDataParam("comCd")String comCd,
        @FormDataParam("file")InputStream uploadFile,
        @FormDataParam("file")FormDataContentDisposition fileDetail){
        
         if(TbBwCustController.getInstance().isValidToken(token)==0){
            return null;
        }
        
        return TbBwCustDetController.getInstance().updateDoc(token, idCust, fileName, fileSize, fileTipe, username, remarks, docNum, extDmt, comCd, uploadFile);
    }
    
    @GET
    @Produces("application/json")
    @Path("get")
    public List getDetail(@QueryParam("token")String token,
            @QueryParam("custid")String userid){
        
         if(TbBwCustController.getInstance().isValidToken(token)==0){
            return null;
        }
         
        return TbBwCustDetController.getInstance().getDocument(token,userid);
    }
    
    @GET
    @Produces("application/json")
    @Path("getNPWP")
    public TbBwCustDetil getNPWP(@QueryParam("custid")String userid){
        return TbBwCustDetController.getInstance().getNPWP(userid);
    }
    
     
    @GET
    @Produces("application/json")
    @Path("doc")
    public TbBwCustDetil getDoc(@QueryParam("token")String token,
            @QueryParam("custid")String userid,
            @QueryParam("doctp")String docTp){
        
         if(TbBwCustController.getInstance().isValidToken(token)==0){
            return null;
        }
         
        return TbBwCustDetController.getInstance().getDoc(token, userid, docTp);
    }
    
    @POST
    @Produces("application/json")
    @Path("delete")
    public ResponseInterface delete(@FormParam("token")String token,
            @FormParam("custid")String userid,
            @FormParam("doctp")String docTp){
        
         if(TbBwCustController.getInstance().isValidToken(token)==0){
            return null;
        }
         
        return TbBwCustDetController.getInstance().deleteDoc(userid, docTp);
    }
    
    
   
}
