/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bsw.api;

import com.bsw.controller.TbLdAddrCDController;
import com.bsw.domain.TbComTMP;
import com.bsw.domain.TbLdAddrCD;
import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 *
 * @author Maulana Wahid Abdurrahman
 */
@Stateless
@Path("ldaddr")
public class TbLdAddrCDAPI {

    @GET
    @Path("/wilayah")
    @Produces("application/json")
    public List<TbLdAddrCD> getWilayah(){
        return TbLdAddrCDController.getWilayah();
    }
    
    @GET
    @Path("/subwilayah")
    @Produces("application/json")
    public List<TbLdAddrCD> getSubWilayah(@QueryParam("wilayah") String wilayah){
        return TbLdAddrCDController.getSubWilayah(wilayah);
    }
    
    @GET
    @Path("/lokasi")
    @Produces("application/json")
    public List<TbLdAddrCD> getLokasi(@QueryParam("wilayah")String wilayah,
            @QueryParam("subwilayah")String subwilayah){
        
        return TbLdAddrCDController.getLokasi(subwilayah,wilayah);
    }
    
    @GET
    @Path("/wilkembang")
    @Produces("application/json")
    public List<TbComTMP> getWilayahPengembangan(){
        
        return TbLdAddrCDController.getWilayahPengembangan();
    }
    
    @GET
    @Path("/wilkembangbywil")
    @Produces("application/json")
    public TbComTMP getWilayahPengembanganByWilayah(
            @QueryParam("wilayah")String wilayah){
        
        return TbLdAddrCDController.getWilayahPengembanganByWil(wilayah);
    }
    
    @GET
    @Path("/lokasiCode")
    @Produces("application/json")
    public List<TbLdAddrCD> getLokasiCode(){
        
        return TbLdAddrCDController.getLokasiCode();
    }
    
    @GET
    @Path("/wilsub")
    @Produces("application/json")
    public TbLdAddrCD getWilSub(@QueryParam("addrCd")String addrCd){
        
        return TbLdAddrCDController.getWilayahSubWilayah(addrCd);
    }
}
