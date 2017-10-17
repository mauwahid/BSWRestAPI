/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bsw.api;

import com.bsw.controller.TbBwCustController;
import com.bsw.controller.TbBwDocDeterminationController;
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
@Path("docdetermine")
public class TbBwDocDeterminationAPI {

    @GET
    @Produces("application/json")
    public List getDocs(@QueryParam("token")String token,
            @QueryParam("adAppList")String adAppList){
        
         if(TbBwCustController.getInstance().isValidToken(token)==0){
            return null;
        }
        
        return TbBwDocDeterminationController.getInstance().getDocs(adAppList);
    }
}
