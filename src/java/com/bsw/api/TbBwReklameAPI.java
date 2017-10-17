/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bsw.api;

import com.bsw.controller.TbBwCustController;
import com.bsw.controller.TbBwReklameController;
import com.bsw.domain.MonitoringReklame;
import com.bsw.domain.reqres.ResponseInterface;
import com.bsw.domain.TbBwReklame;
import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 *
 * @author Maulana Wahid Abdurrahman
 */
@Stateless
@Path("reklame")
public class TbBwReklameAPI {

    @POST
    @Path("/add")
    @Produces("application/json")
    public ResponseInterface saveReklame(
       @FormParam("token") String token,
       @FormParam("aDClient") String aDClient,
       @FormParam("aDAplyTP") String aDAplyTP,
       @FormParam("aDAplyLttrDMT") String aDAplyLttrDMT,
       @FormParam("aDAplyLttrNo") String aDAplyLttrNo,
       @FormParam("aDAplyDMT") String aDAplyDMT,
       @FormParam("aDTeme") String aDTeme,
       @FormParam("aDSide") String aDSide,
       @FormParam("aDWid") String aDWid,
       @FormParam("aDLen") String aDLen,
       @FormParam("aDHgt") String aDHgt,
       @FormParam("aDLoc") String aDLoc,
       @FormParam("aDRmk") String aDRmk,
       @FormParam("statusBSW") String statusBSW,
       @FormParam("ketBSW") String ketBSW,
       @FormParam("createdBy") String createdBy){
        
        if(TbBwCustController.getInstance().isValidToken(token)==0){
            return null;
        }
        
       return TbBwReklameController.getInstance().saveReklame(token, aDClient, aDAplyTP, aDAplyLttrDMT, 
               aDAplyLttrNo, aDAplyDMT, aDTeme, aDSide, aDWid, aDLen, aDHgt, aDLoc, aDRmk, statusBSW, 
               ketBSW, createdBy);
    }
    
    @POST
    @Path("/update")
    @Produces("application/json")
    public ResponseInterface updReklame(
       @FormParam("token") String token,
       @FormParam("aDClient") String aDClient,
       @FormParam("aDAplyTP") String aDAplyTP,
       @FormParam("aDAplyLttrDMT") String aDAplyLttrDMT,
       @FormParam("aDAplyLttrNo") String aDAplyLttrNo,
       @FormParam("aDAplyDMT") String aDAplyDMT,
       @FormParam("aDTeme") String aDTeme,
       @FormParam("aDSide") String aDSide,
       @FormParam("aDWid") String aDWid,
       @FormParam("aDLen") String aDLen,
       @FormParam("aDHgt") String aDHgt,
       @FormParam("aDLoc") String aDLoc,
       @FormParam("aDRmk") String aDRmk,
       @FormParam("statusBSW") String statusBSW,
       @FormParam("ketBSW") String ketBSW,
       @FormParam("createdBy") String createdBy,
       @FormParam("idIR") String idIR){
        
        if(TbBwCustController.getInstance().isValidToken(token)==0){
            return null;
        }
        
        
       return TbBwReklameController.getInstance().updReklame(token, aDClient, aDAplyTP, aDAplyLttrDMT, 
               aDAplyLttrNo, aDAplyDMT, aDTeme, aDSide, aDWid, aDLen, aDHgt, aDLoc, aDRmk, statusBSW, 
               ketBSW, createdBy,idIR);
    }
    
    
    @POST
    @Path("/updstatus")
    @Produces("application/json")
    public ResponseInterface updReklame(
       @FormParam("token") String token,
       @FormParam("statusBSW") String statusBSW,
       @FormParam("idIR") String idIR){
        
        if(TbBwCustController.getInstance().isValidToken(token)==0){
            return null;
        }
        
       return TbBwReklameController.getInstance().updStatusReklame(token, statusBSW, idIR);
    }
    
    @GET
    @Path("/search")
    @Produces("application/json")
    public List<MonitoringReklame> monitoring(
            @QueryParam("token")String token,
            @QueryParam("creator")String creator, 
            @QueryParam("adClient")String adClient, 
            @QueryParam("adAplyTp")String adAplyTp,
            @QueryParam("adAplyLttrNo")String adAplyLttrNo, 
            @QueryParam("idIR")String idIR
       ){
        
        if(TbBwCustController.getInstance().isValidToken(token)==0){
            return null;
        }
        
       return TbBwReklameController.getInstance().monitoring(creator, adClient, adAplyTp, adAplyLttrNo, idIR);
    }
    
    @GET
    @Path("/searchsort")
    @Produces("application/json")
    public List<MonitoringReklame> monitoring(
            @QueryParam("token")String token,
            @QueryParam("creator")String creator, 
            @QueryParam("adClient")String adClient, 
            @QueryParam("adAplyTp")String adAplyTp,
            @QueryParam("adAplyLttrNo")String adAplyLttrNo, 
            @QueryParam("idIR")String idIR,
            @QueryParam("tipe")int tipe,
            @QueryParam("ascdesc")String ascDesc
       ){
        
        if(TbBwCustController.getInstance().isValidToken(token)==0){
            return null;
        }
        
       return TbBwReklameController.getInstance().monitoring(creator, adClient, adAplyTp, adAplyLttrNo, idIR, tipe, ascDesc);
    }
    
    @GET
    @Path("/monitoringsort")
    @Produces("application/json")
    public List<MonitoringReklame> monitoring(
            @QueryParam("token")String token,
            @QueryParam("creator")String creator,
            @QueryParam("tipe")int tipe,
            @QueryParam("ascdesc")String ascDesc){
        
        if(TbBwCustController.getInstance().isValidToken(token)==0){
            return null;
        }
        
        
       return TbBwReklameController.getInstance().monitoring(creator, tipe, ascDesc);
    }
    
    @GET
    @Path("/monitoring")
    @Produces("application/json")
    public List<MonitoringReklame> monitoring(
            @QueryParam("token")String token,
            @QueryParam("creator")String creator){
        
       return TbBwReklameController.getInstance().monitoring(creator);
    }
    
    
    @POST
    @Path("/delete")
    @Produces("application/json")
    public ResponseInterface delete(
            @FormParam("token")String token,
            @FormParam("idIR")String idIR){
        
        if(TbBwCustController.getInstance().isValidToken(token)==0){
            return null;
        }
        
        
       return TbBwReklameController.getInstance().deleteReklame(idIR);
    }
    
    @GET
    @Path("/get")
    @Produces("application/json")
    public TbBwReklame getReklame(
            @QueryParam("token")String token,
            @QueryParam("idIR")String idIR){
        
        if(TbBwCustController.getInstance().isValidToken(token)==0){
            return null;
        }
        
       return TbBwReklameController.getInstance().getReklame(idIR);
    }
    
    
    @GET
    @Path("/docs")
    @Produces("application/json")
    public List getReklameDOcs(
            @QueryParam("token")String token,
            @QueryParam("idIR")String idIR){
        
        if(TbBwCustController.getInstance().isValidToken(token)==0){
            return null;
        }
        
       return TbBwReklameController.getInstance().getReklameDocs(idIR);
    }
}
