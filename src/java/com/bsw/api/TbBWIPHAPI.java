/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bsw.api;

import com.bsw.controller.TbBwCustController;
import com.bsw.controller.TbBwIPHController;
import com.bsw.domain.MonitoringIPH;
import com.bsw.domain.TbBWIPH;
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
@Path("iph")
public class TbBWIPHAPI {

    @POST
    @Produces("application/json")
    @Path("save")
    public ResponseInterface saveIPH(@FormParam("token") String token,
            @FormParam("applyTp") String applyTp, 
            @FormParam("pemohonId")String pemohonId,
            @FormParam("penjualId")String penjualId,
            @FormParam("pembeliId")String pembeliId,
            @FormParam("certNo") String certNo,
      @FormParam("plNo")String plNo, 
      @FormParam("applyLttrNo")String applyLttrNo,
      @FormParam("docDmt")String docDmt,
      @FormParam("applyLttrSbjt")String applyLttrSbjt, 
      @FormParam("regRemark")String regRemarks, 
      @FormParam("docStat")String docStat, 
      @FormParam("applyStat")String applyStat,
      @FormParam("addrCd")String addrCd,
      @FormParam("addrDet")String addrDet,
      @FormParam("ldUsgCd")String ldUsgCd,
      @FormParam("ldUsgTp")String ldUsgTp,
      @FormParam("aplyLdSize")String aplyLdSize,
      @FormParam("blLen")String blLen,
      @FormParam("uwtoTp")String uwtoTp,
      @FormParam("uwtoExpirDmt")String uwtoExpirDmt,
      @FormParam("pmtCondCd")String pmtCondCd,
      @FormParam("rentPerdYear")String rentPerdYear,
      @FormParam("ldPrcAmt")String ldPrcAmt,
      @FormParam("totPrc")String totPrc,
      @FormParam("bapAmt")String bapAmt,
      @FormParam("vrfksiDt")String vrfksiDt,
      @FormParam("asingFlg")String asingFlg,
      @FormParam("createdBy")String createdBy,
      @FormParam("custUsername")String custUsername,
      @FormParam("noPerjanjian")String noPerjanjian,
      @FormParam("tglPerjanjian")String tglPerjanjian,
      @FormParam("noKeputusan")String noKeputusan,
      @FormParam("tglKeputusan")String tglKeputusan,
      @FormParam("tglPL")String tglPL,
      @FormParam("tglCert")String tglCert){
       
        
        if(TbBwCustController.getInstance().isValidToken(token)==0){
            return null;
        }
        
        
        if(tglPL==null){
         //   tglPL = "00/00/0000";
        }else{
            if(tglPL.equalsIgnoreCase(""))
             //    tglPL = "00/00/0000";
                tglPL = null;
        }
        if(tglCert == null){
          //  tglCert = "00/00/0000";
        }else{
            if(tglCert.equalsIgnoreCase(""))
              //  tglCert = "00/00/0000";
                tglCert = null;
        }
        
        if(tglKeputusan == null){
          //  tglKeputusan = "00/00/0000";
        }else{
            if(tglKeputusan.equalsIgnoreCase(""))
           //     tglKeputusan = "00/00/0000";
                tglKeputusan = null;
        }
        
        
        return TbBwIPHController.getInstance().saveIPH(applyTp, pemohonId,penjualId, pembeliId, plNo, certNo, applyLttrNo, docDmt, 
                applyLttrSbjt, regRemarks, docStat, applyStat, addrCd,
                addrDet,ldUsgCd,ldUsgTp,aplyLdSize,blLen,uwtoTp,uwtoExpirDmt,pmtCondCd,rentPerdYear,
                ldPrcAmt,totPrc,bapAmt,vrfksiDt,asingFlg,createdBy,custUsername, noPerjanjian, tglPerjanjian, noKeputusan,tglKeputusan,tglPL, tglCert);
    }
    
    @GET
    @Produces("application/json")
    @Path("search")
    public List<MonitoringIPH> monitor(@QueryParam("token")String token,
            @QueryParam("idIPH")String idIPH,
            @QueryParam("plNo")String plNo,
            @QueryParam("applyStat")String applyStat,
            @QueryParam("fromDate")String fromDate,
            @QueryParam("toDate")String toDate,
            @QueryParam("applyTp")String applyTp,
             @QueryParam("statVer")String statVer,
             @QueryParam("creator")String creator){
        
      /*  if(TbBwCustController.getInstance().isValidToken(token)==0){
            return null;
        }
        
      */ 
         if(TbBwCustController.getInstance().isValidToken(token)==0){
            return null;
        }
         
        return TbBwIPHController.getInstance().monitoringIPH(idIPH, plNo, applyStat, fromDate, toDate, applyTp, statVer,creator);
    }
    
    @GET
    @Produces("application/json")
    @Path("searchsort")
    public List<MonitoringIPH> monitorSearchSort(@QueryParam("token")String token,
            @QueryParam("idIPH")String idIPH,
            @QueryParam("plNo")String plNo,
            @QueryParam("applyStat")String applyStat,
            @QueryParam("fromDate")String fromDate,
            @QueryParam("toDate")String toDate,
            @QueryParam("applyTp")String applyTp,
             @QueryParam("statVer")String statVer,
             @QueryParam("creator")String creator,
             @QueryParam("tipe")int tipe,
             @QueryParam("ascdesc")String ascDesc){
        
        if(TbBwCustController.getInstance().isValidToken(token)==0){
            return null;
        }
       
        return TbBwIPHController.getInstance().monitoringIPH(idIPH, plNo, applyStat, fromDate, toDate, applyTp, statVer,creator, tipe,  ascDesc);
    }
    
    @POST
    @Produces("application/json")
    @Path("update")
    public ResponseInterface updateIPH(
            @FormParam("token") String token,
            @FormParam("idIPH") String idIPH,
            @FormParam("applyTp") String applyTp, 
            @FormParam("pemohonId")String pemohonId,
             @FormParam("penjualId")String penjualId,
            @FormParam("pembeliId")String pembeliId,
            @FormParam("certNo") String certNo,
      @FormParam("plNo")String plNo, 
      @FormParam("applyLttrNo")String applyLttrNo,
      @FormParam("docDmt")String docDmt,
      @FormParam("applyLttrSbjt")String applyLttrSbjt, 
      @FormParam("regRemark")String regRemarks, 
      @FormParam("docStat")String docStat, 
      @FormParam("applyStat")String applyStat,
      @FormParam("addrCd")String addrCd,
      @FormParam("addrDet")String addrDet,
      @FormParam("ldUsgCd")String ldUsgCd,
      @FormParam("ldUsgTp")String ldUsgTp,
      @FormParam("aplyLdSize")String aplyLdSize,
      @FormParam("blLen")String blLen,
      @FormParam("uwtoTp")String uwtoTp,
      @FormParam("uwtoExpirDmt")String uwtoExpirDmt,
      @FormParam("pmtCondCd")String pmtCondCd,
      @FormParam("rentPerdYear")String rentPerdYear,
      @FormParam("ldPrcAmt")String ldPrcAmt,
      @FormParam("totPrc")String totPrc,
      @FormParam("bapAmt")String bapAmt,
      @FormParam("vrfksiDt")String vrfksiDt,
      @FormParam("asingFlg")String asingFlg,
      @FormParam("createdBy")String createdBy,
      @FormParam("custUsername")String custUsername,
      @FormParam("noPerjanjian")String noPerjanjian,
      @FormParam("tglPerjanjian")String tglPerjanjian,
      @FormParam("noKeputusan")String noKeputusan,
      @FormParam("tglKeputusan")String tglKeputusan,
      @FormParam("tglPL")String tglPL,
      @FormParam("tglCert")String tglCert){
        
        if(TbBwCustController.getInstance().isValidToken(token)==0){
            return null;
        }
       
        return TbBwIPHController.getInstance().updateIPH(idIPH, applyTp, pemohonId, plNo, certNo, applyLttrNo, docDmt, 
                applyLttrSbjt, regRemarks, docStat, applyStat, addrCd,
                addrDet,ldUsgCd,ldUsgTp,aplyLdSize,blLen,uwtoTp,uwtoExpirDmt,pmtCondCd,rentPerdYear,
                ldPrcAmt,totPrc,bapAmt,vrfksiDt,asingFlg,createdBy,custUsername,
                noPerjanjian, tglPerjanjian, noKeputusan,tglKeputusan,tglPL, tglCert, penjualId, pembeliId
                );
    }
    
  /*  @GET
    @Produces("application/json")
    @Path("monitoring3")
    public List<MonitoringIPH> monitor2(@QueryParam("token")String token,
            @QueryParam("idIPH")String idIPH,
            @QueryParam("plNo")String plNo,
            @QueryParam("applyStat")String applyStat,
            @QueryParam("fromDate")String fromDate,
            @QueryParam("toDate")String toDate,
            @QueryParam("applyTp")String applyTp){
       
        return TbBwIPHController.getInstance().monitoringIPH(idIPH, plNo, applyStat, fromDate, toDate, applyTp,applyTp);
    } */
    
    @GET
    @Produces("application/json")
    @Path("monitoring")
    public List<MonitoringIPH> monitor(@QueryParam("token")String token,
            @QueryParam("creator")String creator){
       
        if(TbBwCustController.getInstance().isValidToken(token)==0){
            return null;
        }
        return TbBwIPHController.getInstance().monitoringIPH(creator);
    }
    
    @GET
    @Produces("application/json")
    @Path("monitoringsort")
    public List<MonitoringIPH> monitorSort(@QueryParam("token")String token,
            @QueryParam("creator")String creator, 
            @QueryParam("tipe")int tipe, String content,@QueryParam("ascdesc") String ascDesc){
       
        if(TbBwCustController.getInstance().isValidToken(token)==0){
            return null;
        }
        
        return TbBwIPHController.getInstance().monitoringIPHSort(creator, tipe, content, ascDesc);
    }
    
    @GET
    @Produces("application/json")
    @Path("get")
    public TbBWIPH getIPH(@QueryParam("token")String token,
            @QueryParam("idIPH")String idIPH){
       
        if(TbBwCustController.getInstance().isValidToken(token)==0){
            return null;
        }
        
        return TbBwIPHController.getInstance().getIPH(idIPH);
    }
    
    @GET
    @Produces("application/json")
    @Path("avdt")
    public List getAvailableDate(@QueryParam("token")String token,
            @QueryParam("applyTp")String aplyTp){
       
        if(TbBwCustController.getInstance().isValidToken(token)==0){
            return null;
        }
        
        return TbBwIPHController.getInstance().getAvailableDate(token, aplyTp);
    }
    
    
    @POST
    @Produces("application/json")
    @Path("verdate")
    public ResponseInterface verIPH(@FormParam("token")String token, 
            @FormParam("dateVer")String date,
            @FormParam("idIPH")String idIPH){
       
        if(TbBwCustController.getInstance().isValidToken(token)==0){
            return null;
        }
       
        return TbBwIPHController.getInstance().updateIPH(date, idIPH);
    }
    
    @POST
    @Produces("application/json")
    @Path("updds")
    public ResponseInterface updateDocStat(@FormParam("token")String token, 
            @FormParam("docStat")String docStat,
            @FormParam("idIPH")String idIPH){
       
        if(TbBwCustController.getInstance().isValidToken(token)==0){
            return null;
        }
        
        return TbBwIPHController.getInstance().updateDocStatIPH(docStat, idIPH);
    }
    
    @POST
    @Produces("application/json")
    @Path("upapstat")
    public ResponseInterface updateAppStatStat(@FormParam("token")String token, 
            @FormParam("apStat")String apStat,
            @FormParam("idIPH")String idIPH){
       
        if(TbBwCustController.getInstance().isValidToken(token)==0){
            return null;
        }
        
        return TbBwIPHController.getInstance().updateApStatIPH(apStat, idIPH);
    }
    
    
}
