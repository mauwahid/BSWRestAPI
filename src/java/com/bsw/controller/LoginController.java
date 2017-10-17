/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bsw.controller;

import com.bsw.dao.DaoManager;
import com.bsw.domain.reqres.LoginRes;
import com.bsw.utils.Common;
import java.util.Hashtable;
import javax.naming.AuthenticationException;
import javax.naming.AuthenticationNotSupportedException;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import org.apache.log4j.Logger;

/**
 *
 * @author Maulana Wahid Abdurrahman
 */
public class LoginController {
    
    private String username;
    private String password;
    
    private static final Logger logger = Logger.getLogger(LoginController.class.getName());
   
    
    public static LoginController getInstance(){
        return new LoginController();
    }
    
    public LoginRes loginAct(String username, String password){
        logger.info("LOGIN : "+username+", PASS : "+password);
        this.username = username;
        this.password = password;
        
        return loginProcess();
    }
    
    private LoginRes loginProcess(){
        LoginRes response = new LoginRes();
      //  DirContext ctx = new InitialDirContext(env);
            String url = "ldap://172.18.160.16:6501";
            
            Hashtable env = new Hashtable();
            env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
            env.put(Context.PROVIDER_URL, url);
            env.put(Context.SECURITY_AUTHENTICATION, "simple");
            env.put(Context.SECURITY_PRINCIPAL, "cn="+this.username);
            env.put(Context.SECURITY_CREDENTIALS, this.password);
            
            logger.debug("CONNECT TO "+url);
            logger.debug("ENV : "+env.toString());

            try {
                DirContext ctx = new InitialDirContext(env);
                System.out.println("connected");
                System.out.println(ctx.getEnvironment());

                logger.debug("CONNECTED "+url);
             
                
                response.setStatus("SUCCESS");
                response.setStatusDesc("CONNECTED TO LDAP");

                ctx.close();

            } catch (AuthenticationNotSupportedException ex) {
                logger.error("ERROR LOGIN "+ex.toString());
             
                System.out.println("The authentication is not supported by the server");
                response.setStatus("FAILED");
                response.setStatusDesc(ex.toString());

            } catch (AuthenticationException ex) {
                logger.error("ERROR LOGIN "+ex.toString());
                System.out.println("incorrect password or username");
                response.setStatus("FAILED");
                response.setStatusDesc(ex.toString());

            } catch (NamingException ex) {
                logger.error("ERROR LOGIN "+ex.toString());
             
                System.out.println("error when trying to create the context");
                response.setStatus("FAILED");
                response.setStatusDesc(ex.toString());

            }
        
        return response;
    }
   
    public static boolean checkValidation(String tokenID){
        return DaoManager.getTokenDao().isValid(tokenID);
    }
    
    public static String getUsername(String tokenID){
        return DaoManager.getTbBwCustDao().getUsername(tokenID);
    }
    

}
