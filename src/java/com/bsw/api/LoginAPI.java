/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bsw.api;

import com.bsw.controller.LoginController;
import com.bsw.domain.reqres.LoginRes;
import javax.ejb.Stateless;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import org.apache.log4j.Logger;

/**
 *
 * @author Maulana Wahid Abdurrahman
 */
@Stateless
@Path("login")
public class LoginAPI {
  
    private static final Logger logger = Logger.getLogger(LoginAPI.class.getName());
   
    @POST
    @Produces("application/json")
    public LoginRes loginLDAP(@FormParam("username")String username,
            @FormParam("password")String password){
        return LoginController.getInstance().loginAct(username, password);
    }
    
    
}
