/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bsw.api;

import com.bsw.controller.TbldPrceController;
import com.bsw.domain.TarifUWTO;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 *
 * @author Maulana Wahid Abdurrahman
 * 
 * @description Mendapatkan data tarif
 */
@Stateless
@Path("tarif")
public class TarifUWTOAPI {

    
    
    @GET
    @Produces("application/json")
    @Path("uwto")
    public TarifUWTO getTarifUWTO(
            @QueryParam("addrCd")String addrCd,
            @QueryParam("ldUsgCd")String ldUsgCd,
            @QueryParam("prcTp")String prcTp, 
            @QueryParam("luas")double luas, 
            @QueryParam("garisPantai")double garisPantai){
        return TbldPrceController.getInstance().getTarifUWTO(addrCd, ldUsgCd, prcTp, luas, garisPantai);
    }
    
     @GET
    @Produces("application/json")
    @Path("get")
    public String getTarif(
            @QueryParam("addrCd")String addrCd,
            @QueryParam("ldUsgCd")String ldUsgCd,
            @QueryParam("prcTp")String prcTp){
        return TbldPrceController.getInstance().getTarif(addrCd, ldUsgCd, prcTp);
    }

    
}
