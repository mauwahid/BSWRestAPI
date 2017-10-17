/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bsw.api;

import com.bsw.controller.TbBwCustController;
import com.bsw.controller.TbBwPematanganController;
import com.bsw.domain.MonitoringPematangan;
import com.bsw.domain.TbbwPematangan;
import com.bsw.domain.reqres.ResponseInterface;
import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 *
 * @author Maulana Wahid Abdurrahman
 */
@Stateless
@Path("pematangan")
public class TbBwPematanganAPI {

    @POST
    @Produces("application/json")
    @Path("/save")
    public ResponseInterface savePematangan(
    @FormParam("token")String token,
    @FormParam("licnAplyLttrNo")String licnAplyLttrNo,
    @FormParam("licnAplyDmt")String licnAplyDmt,
    @FormParam("licnApltId")String licnApltId,
    @FormParam("licnAplyTp")String licnAplyTp,
    @FormParam("executer")String executer,
    @FormParam("licnAplyLttrDmt")String licnAplyLttrDmt,
    @FormParam("statusBsw")String statusBsw,
    @FormParam("createdBy")String createdBy){
       
        if(TbBwCustController.getInstance().isValidToken(token)==0){
            return null;
        }
        
        return new TbBwPematanganController().getInstance().savePematangan(token, licnAplyLttrNo, licnAplyDmt, licnApltId, licnAplyTp, executer, licnAplyLttrDmt, statusBsw, createdBy);
        
    }
    
    @POST
    @Produces("application/json")
    @Path("/update")
    public ResponseInterface updPematangan(
    @FormParam("token")String token,
    @FormParam("licnAplyLttrNo")String licnAplyLttrNo,
    @FormParam("licnAplyDmt")String licnAplyDmt,
    @FormParam("licnApltId")String licnApltId,
    @FormParam("licnAplyTp")String licnAplyTp,
    @FormParam("executer")String executer,
    @FormParam("licnAplyLttrDmt")String licnAplyLttrDmt,
    @FormParam("statusBsw")String statusBsw,
    @FormParam("createdBy")String createdBy,
    @FormParam("idPL")String idPL){
       
        if(TbBwCustController.getInstance().isValidToken(token)==0){
            return null;
        }
        
        
        return new TbBwPematanganController().getInstance().updPematangan(token, licnAplyLttrNo, licnAplyDmt, licnApltId, licnAplyTp, executer, licnAplyLttrDmt, statusBsw, createdBy,idPL);
        
    }
    
    
    @POST
    @Produces("application/json")
    @Path("/updstatus")
    public ResponseInterface updStatusPematangan(
    @FormParam("token")String token,
    @FormParam("statusBSW")String statusBsw,
    @FormParam("idPL")String idPL){
       
        if(TbBwCustController.getInstance().isValidToken(token)==0){
            return null;
        }
        
        
        return new TbBwPematanganController().getInstance().updStatusPematangan(token, statusBsw,idPL);
        
    }
    
    
    @POST
    @Produces("application/json")
    @Path("/delete")
    public ResponseInterface delPematangan(
    @FormParam("token")String token,
    @FormParam("idPL")String idIPL){
       
        if(TbBwCustController.getInstance().isValidToken(token)==0){
            return null;
        }
        
        
        return new TbBwPematanganController().getInstance().delete(idIPL);
        
    }
    
    @GET
    @Produces("application/json")
    @Path("/detl")
    public List detPematangan(
    @QueryParam("token")String token,
    @QueryParam("idPL")String idIPL){
       
        if(TbBwCustController.getInstance().isValidToken(token)==0){
            return null;
        }
        
        
        return new TbBwPematanganController().getInstance().getPematanganDetl(idIPL);
        
    }
    
    @GET
    @Produces("application/json")
    @Path("/docs")
    public List docsPematangan(
    @QueryParam("token")String token,
    @QueryParam("idPL")String idIPL){
       
        if(TbBwCustController.getInstance().isValidToken(token)==0){
            return null;
        }
        
        
        return new TbBwPematanganController().getInstance().getPematanganDocs(idIPL);
        
    }
    
    @GET
    @Produces("application/json")
    @Path("/moni")
    public List<MonitoringPematangan> monitor(
            @QueryParam("token")String token,
            @QueryParam("idPL")String idPL,
            @QueryParam("licnApltId")String licnAplyId,
            @QueryParam("licnAplyTp")String licnAplyTp,
            @QueryParam("licnAplyLttrNo")String licnAplyLttrNo){
       
        if(TbBwCustController.getInstance().isValidToken(token)==0){
            return null;
        }
        
        
        return new TbBwPematanganController().getInstance().monitor2(idPL, licnAplyId, licnAplyTp, licnAplyLttrNo);
        
    }
    
    
    
    @GET
    @Produces("application/json")
    @Path("/monitoring")
    public List<MonitoringPematangan> monitor(
            @QueryParam("token")String token,
            @QueryParam("creator")String creator){
       
        return new TbBwPematanganController().getInstance().monitor(creator);
        
    }
    
    @GET
    @Produces("application/json")
    @Path("/monitoringsort")
    public List<MonitoringPematangan> monitor(
            @QueryParam("token")String token,
            @QueryParam("creator")String creator,
            @QueryParam("tipe")int tipe,
            @QueryParam("ascdesc")String ascdesc){
       
        return new TbBwPematanganController().getInstance().monitorSort(creator, tipe, ascdesc);
        
    }
    
    @GET
    @Produces("application/json")
    @Path("/search2")
    public List<MonitoringPematangan> monitorSearch(
            @QueryParam("token")String token,
            @QueryParam("creator")String creator,
            @QueryParam("licnAplyLttrNo")String licnAplyLttrNo,
            @QueryParam("licnApltID")String licnApltID,
            @QueryParam("licnAplyDmt")String licnAplyDmt,
            @QueryParam("statusBSW")String statusBSW ){
       
        return new TbBwPematanganController().getInstance().monitor(creator, licnAplyLttrNo, licnApltID, licnAplyDmt, statusBSW);
                
        
    }
    
      
    @GET
    @Produces("application/json")
    @Path("/search")
    public List<MonitoringPematangan> monitorSearch(
            @QueryParam("token")String token,
            @QueryParam("creator")String creator,
            @QueryParam("licnApltID")String licnApltID,
            @QueryParam("statusBSW")String statusBSW,
            @QueryParam("evalRslt")String evalRslt,
            @QueryParam("licnAplyTp")String licnAplyTp,
            @QueryParam("licnAplyLttrNo")String licnAplyLttrNo,
            @QueryParam("licnMgmtNo")String licnMgmtNo,
            @QueryParam("ketBSW")String ketBSW, 
            @QueryParam("licnAplyDmt")String licnAplyDmt,
            @QueryParam("licnAplyLtrDmt")String licnAplyLtrDmt){
       
        return new TbBwPematanganController().getInstance().monitor(creator, licnApltID, statusBSW, evalRslt, licnAplyTp, licnAplyLttrNo, licnMgmtNo, ketBSW, licnAplyDmt, licnAplyLtrDmt);
    }
    
    @GET
    @Produces("application/json")
    @Path("/searchsort")
    public List<MonitoringPematangan> monitorSearch(
            @QueryParam("token")String token,
            @QueryParam("creator")String creator,
            @QueryParam("licnApltID")String licnApltID,
            @QueryParam("statusBSW")String statusBSW,
            @QueryParam("evalRslt")String evalRslt,
            @QueryParam("licnAplyTp")String licnAplyTp,
            @QueryParam("licnAplyLttrNo")String licnAplyLttrNo,
            @QueryParam("licnMgmtNo")String licnMgmtNo,
            @QueryParam("ketBSW")String ketBSW, 
            @QueryParam("licnAplyDmt")String licnAplyDmt,
            @QueryParam("licnAplyLtrDmt")String licnAplyLtrDmt,
            @QueryParam("tipe")int tipe,
            @QueryParam("ascdesc")String ascDesc){
       
        return new TbBwPematanganController().getInstance().monitorSort(creator, licnApltID, 
                statusBSW, evalRslt, licnAplyTp, licnAplyLttrNo, licnMgmtNo, ketBSW, 
                licnAplyDmt, licnAplyLtrDmt, tipe, ascDesc);
    }
    
    
    @GET
    @Produces("application/json")
    @Path("/get")
    public TbbwPematangan getPematangan(@QueryParam("token")String token, @QueryParam("idPL")String idPL){
        return new TbBwPematanganController().getInstance().getPematangan(idPL);
    }
}
