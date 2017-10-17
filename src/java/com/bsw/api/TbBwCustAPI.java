/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bsw.api;

import com.bsw.controller.TbBwCustController;
import com.bsw.domain.TbBwCust;
import com.bsw.domain.reqres.ResponseInterface;
import com.sun.jersey.api.json.JSONWithPadding;
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
@Path("user")
public class TbBwCustAPI {

    @POST
    @Produces("application/json")
    @Path("login")
    public ResponseInterface loginLDAP(@FormParam("username")String username,
            @FormParam("password")String password, @FormParam("fcmid")String fcmid){
        return TbBwCustController.getInstance().loginAct(username, password,fcmid);
    }
    
    @GET
    @Produces("application/json")
    @Path("validcheck")
    public ResponseInterface checkValidation(@QueryParam("username")String username){
        return TbBwCustController.getInstance().checkValidation(username);
    }
    
    @GET
    @Produces("application/json")
    @Path("getpemohon")
    public TbBwCust getPemohon(
            @QueryParam("tipe")String tipe,
            @QueryParam("custid")String custid){
        return TbBwCustController.getInstance().getPemohon(tipe, custid);
    }
    
    @GET
    @Produces("application/json")
    @Path("profile")
    public TbBwCust getProfile(@QueryParam("username")String username){
        return TbBwCustController.getInstance().getProfile(username);
    }
    
    @POST
    @Produces("application/json")
    @Path("add")
    public ResponseInterface saveCustomer(@FormParam("username")String username,
            @FormParam("password")String password,
           @FormParam("custNm")String custNm,@FormParam("email")String email){
        return TbBwCustController.getInstance().saveCustomer(username,password,custNm,email);
    }
    
    @POST
    @Produces("application/json")
    @Path("update")
    public ResponseInterface updateCustomer(
            @FormParam("token")String token,
            @FormParam("username")String username,
            @FormParam("custNm")String custNm,@FormParam("custTp")String custTp,
           @FormParam("custAddr")String custAddr,@FormParam("custTel")String custTel,
           @FormParam("custFax")String custFax, @FormParam("custEmail")String custEmail,
           @FormParam("custHp")String custHp,
           @FormParam("custJob")String custJob,
           @FormParam("custNtnty")String custNtnty,
           @FormParam("custGend")String custGend,
           @FormParam("prgNm")String prgNm,
           @FormParam("busTp")String busTp,
           @FormParam("custMarryYN")String custMaryYN,
            @FormParam("birthDate")String birthDate){
        
         if(TbBwCustController.getInstance().isValidToken(token)==0){
            return null;
        }
        
        return TbBwCustController.getInstance().updateCustomer(token, username, custNm, custTp, custAddr, custTel, custFax, custEmail, custHp, custJob, custNtnty, custGend, prgNm,busTp, custMaryYN, birthDate);
    }
    
    
    @POST
    @Produces("application/json")
    @Path("logout")
    public ResponseInterface logout(@FormParam("token")String token){
        return TbBwCustController.getInstance().logout(token);
    }
    
    @POST
    @Produces("application/json")
    @Path("relogin")
    public ResponseInterface relogin(@FormParam("token")String token){
        return TbBwCustController.getInstance().relogin(token);
    }
  
    @POST
    @Produces("application/json")
    @Path("reset")
    public ResponseInterface resetPassowrd(@FormParam("email")String email){
        return TbBwCustController.getInstance().reset(email);
    }
    
    @POST
    @Produces("application/json")
    @Path("updpass")
    public ResponseInterface resetPassowrd(@FormParam("token")String token,
            @FormParam("username")String username, @FormParam("newPassword")String newPassword){
        
         if(TbBwCustController.getInstance().isValidToken(token)==0){
            return null;
        }
         
        return TbBwCustController.getInstance().updatePassByUname(username, newPassword);
    }
}
