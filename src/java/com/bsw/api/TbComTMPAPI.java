/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsw.api;

import com.bsw.controller.TbComTMPController;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import com.bsw.domain.TbComTMP;
import java.util.List;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Maulana Wahid Abdurrahman
 */
@Stateless
@Path("comtmp")
public class TbComTMPAPI {
    
    @GET
    @Path("/curr")
    @Produces(MediaType.APPLICATION_JSON)
    public List<TbComTMP> getCurrency(){
        return TbComTMPController.getCurrency();
    }
    
    @GET
    @Path("/bank")
    @Produces(MediaType.APPLICATION_JSON)
    public List<TbComTMP> getBankCode(){
        return TbComTMPController.getBankCode();
    }
    
    @GET
    @Path("/unit")
    @Produces(MediaType.APPLICATION_JSON)
    public List<TbComTMP> getUnitCode(){
        return TbComTMPController.getUnitCode();
    }
    
    @GET
    @Path("/svctype")
    @Produces(MediaType.APPLICATION_JSON)
    public List<TbComTMP> getServiceType(){
        return TbComTMPController.getServiceType();
    }
    
    @GET
    @Path("/usaha")
    @Produces(MediaType.APPLICATION_JSON)
    public List<TbComTMP> getUsaha(){
        return TbComTMPController.getUsahaList();
    }
    
    @GET
    @Path("/budget")
    @Produces(MediaType.APPLICATION_JSON)
    public List<TbComTMP> getBudgetType(){
        return TbComTMPController.getBudgetType();
    }
    
    @GET
    @Path("/payment")
    @Produces(MediaType.APPLICATION_JSON)
    public List<TbComTMP> getPaymentMethod(){
        return TbComTMPController.getPaymentMethod();
    }
    
    @GET
    @Path("/exchange")
    @Produces(MediaType.APPLICATION_JSON)
    public List<TbComTMP> getExchangeRate(){
        return TbComTMPController.getExchangeRateType();
    }
    
    @GET
    @Path("/period")
    @Produces(MediaType.APPLICATION_JSON)
    public List<TbComTMP> getPeriodType(){
        return TbComTMPController.getPeriodType();
    }
    
    @GET
    @Path("/area")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getArea(){
        return Response.ok().entity(TbComTMPController.getArea()).build();
    }
    
    @GET
    @Path("/drcr")
    @Produces(MediaType.APPLICATION_JSON)
    public List<TbComTMP> getDRCR(){
        return TbComTMPController.getDRCRType();
    }
    
    @GET
    @Path("/tipepenyewa")
    @Produces(MediaType.APPLICATION_JSON)
    public List<TbComTMP> getTipePenyewa(){
        return TbComTMPController.getTypePenyewa();
    }
    
    @GET
    @Path("/penggunaanlahan")
    @Produces(MediaType.APPLICATION_JSON)
    public List<TbComTMP> getPenggunaanLahan(){
        return TbComTMPController.getPenggunaanLahan();
    }
    
    @GET
    @Path("/kondbayar")
    @Produces(MediaType.APPLICATION_JSON)
    public List<TbComTMP> getKondisiPembayaran(){
        return TbComTMPController.getKondisiPembayaran();
    }
    
    @GET
    @Path("/busstype")
    @Produces(MediaType.APPLICATION_JSON)
    public List<TbComTMP> getBussinessType(){
        return TbComTMPController.getBussinessType();
    }
    
    @GET
    @Path("/doctype")
    @Produces(MediaType.APPLICATION_JSON)
    public List<TbComTMP> getDocType(){
        return TbComTMPController.getDocumentType();
    }
    
    @GET
    @Path("/tipepemohon")
    @Produces(MediaType.APPLICATION_JSON)
    public List<TbComTMP> getTipePemohon(){
        return TbComTMPController.getTipePemohon();
    }
    
    @GET
    @Path("/carauwto")
    @Produces(MediaType.APPLICATION_JSON)
    public List<TbComTMP> getCaraUWTO(){
        return TbComTMPController.getCaraUWTO();
    }
    
    @GET
    @Path("/tipeuwto")
    @Produces(MediaType.APPLICATION_JSON)
    public List<TbComTMP> getTipeUWTO(){
        return TbComTMPController.getTipeUWTO();
    }
    
    @GET
    @Path("/statver")
    @Produces(MediaType.APPLICATION_JSON)
    public List<TbComTMP> getStatusVer(){
        return TbComTMPController.getStatusVer();
    }
    
    @GET
    @Path("/jenispermohonan")
    @Produces(MediaType.APPLICATION_JSON)
    public List<TbComTMP> getJenisPermohonan(){
        return TbComTMPController.getJenisPermohonan();
    }
    
    @GET
    @Path("/tipepematangan")
    @Produces(MediaType.APPLICATION_JSON)
    public List<TbComTMP> getTipePematangan(){
        return TbComTMPController.getTipePematangan();
    }
    
     @GET
    @Path("/tipelokasipematangan")
    @Produces(MediaType.APPLICATION_JSON)
    public List<TbComTMP> getTipeLokasiPematangan(){
        return TbComTMPController.getTipeLokasiPematangan();
    }
}
