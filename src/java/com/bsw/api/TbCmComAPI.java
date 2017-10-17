/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bsw.api;

import com.bsw.controller.TbCmComController;
import com.bsw.domain.TbCmCom;
import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Maulana Wahid Abdurrahman
 */
@Stateless
@Path("cmcom")
public class TbCmComAPI {

    @GET
    @Path("/menulokasi")
    @Produces(MediaType.APPLICATION_JSON)
    public List<TbCmCom> getMenuAlokasi(){
        return new TbCmComController().getInstance().getMenu();
    }
    
    @GET
    @Path("/docmap")
    @Produces(MediaType.APPLICATION_JSON)
    public List<TbCmCom> getDocMap(
            @QueryParam("regTp")String regTp,
            @QueryParam("applTp")String applTp){
        return new TbCmComController().getInstance().getDocMapping(regTp, applTp);
    }
    
   
}
