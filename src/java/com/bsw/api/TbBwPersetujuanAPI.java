/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bsw.api;

import com.bsw.controller.TbBwCustController;
import com.bsw.controller.TbBwPersetujuanController;
import com.bsw.domain.reqres.ResponseInterface;
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
@Path("persetujuan")
public class TbBwPersetujuanAPI {

    @POST
    @Produces("application/json")
    @Path("apprv")
    public ResponseInterface approve(
            @FormParam("token")String token,
            @FormParam("name")String name,
            @FormParam("type")String type, 
            @FormParam("application")String application,
            @FormParam("username")String username,
            @FormParam("company")String company){
        
        if(TbBwCustController.getInstance().isValidToken(token)==0){
            return null;
        }
        
        return TbBwPersetujuanController.getInstance().approvePersetujuan(name, type, application, username, company);
    }
    
    
    @GET
    @Produces("application/json")
    @Path("cek")
    public ResponseInterface cek(
            @QueryParam("token")String token,
            @QueryParam("name")String name,
            @QueryParam("type")String type, 
            @QueryParam("application")String application,
            @QueryParam("company")String company){
        
        if(TbBwCustController.getInstance().isValidToken(token)==0){
            return null;
        }
        
        return TbBwPersetujuanController.getInstance().cekPersetujuan(name, type, application, company);
    }
}
