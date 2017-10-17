/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bsw.api;

import com.bsw.controller.TbBwCustController;
import com.bsw.controller.TbBwIPHPemohonController;
import com.bsw.domain.reqres.ResponseInterface;
import javax.ejb.Stateless;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author Maulana Wahid Abdurrahman
 */
@Stateless
@Path("iphpemohon")
public class TbBwIPHPemohonAPI {

    @POST
    @Produces("application/json")
    @Path("add")
    public ResponseInterface saveCustomer(
            @FormParam("token")String token,
            @FormParam("custTp")String custTp,
            @FormParam("custId")String custId,
            @FormParam("custNm")String custNm,
            @FormParam("custAddr")String custAddr,
            @FormParam("prgNm")String prgNm,
            @FormParam("custEmail")String custEmail,
            @FormParam("custTelp")String custTelp,
            @FormParam("custNtnty")String custNtnty){
       
        if(TbBwCustController.getInstance().isValidToken(token)==0){
            return null;
        }
        
        
        return TbBwIPHPemohonController.getInstance().newPemohn(token,custTp, custId, custNm, custAddr, prgNm, custEmail, custTelp, custNtnty);
    }
}
