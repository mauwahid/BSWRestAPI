/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsw.dao;

import com.bsw.utils.Common;
import java.sql.Connection;

/**
 *
 * @author Hansome
 */
public class DaoManager {
    
    private static Connection conn;
    private static TbComTMPDao tbComTMPDao;
    private static TbBW2StatusDao tbBW2StatusDao;
    private static TBCMCountryCityTMPDao tBCMCountryCityTMPDao;
    private static TbLdAddrCDDao tbLdAddrCDDao;
    private static TbBwReklameDao tbBwReklameDao;
    private static TokenDao tokenDao;
    private static TbBwReklameDocDao tbBwReklameDocDao;
    private static TbBwCustDao tbBwCustDao;
    private static TbCmComDao tbCmComDao;
    private static TbBwCustDetDao tbBwCustDetDao;
    private static TbBWIPHDao tbBwIPHDao;
    
    private static TbBWIPHTempDao tbBwIPHTempDao;
    
    public static Connection getConnection(){
        //if(conn == null){
         //   conn = Common.getConnection();
       // }
       // return conn;
        return Common.getConnection();
    }
    
    public static TbComTMPDao getTbComTMPDao(){
   //     if(tbComTMPDao == null){
            tbComTMPDao = new TbComTMPDao(getConnection());
     //   }
        return tbComTMPDao;
    }
    
    public static TbBW2StatusDao getTbBW2Status(){
       // if(tbBW2StatusDao == null){
            tbBW2StatusDao = new TbBW2StatusDao(getConnection());
       // }
        return tbBW2StatusDao;
    }
    
    public static TBCMCountryCityTMPDao getTBCMCountryCityTMPDao(){
       // if(tBCMCountryCityTMPDao == null){
            tBCMCountryCityTMPDao = new TBCMCountryCityTMPDao(getConnection());
       // }
        return tBCMCountryCityTMPDao;
    }
    
    public static TbLdAddrCDDao getTbLdAddrCDDao(){
       // if(tbLdAddrCDDao == null){
            tbLdAddrCDDao = new TbLdAddrCDDao(getConnection());
       // }
        return tbLdAddrCDDao;
    }
    
   public static TbBwReklameDao getTbBWReklameDao(){
        tbBwReklameDao = new TbBwReklameDao(getConnection());
        return tbBwReklameDao;
    }
     
    public static TbBwReklameDocDao getTbBWReklameDocDao(){
        tbBwReklameDocDao = new TbBwReklameDocDao(getConnection());
        return tbBwReklameDocDao;
    }
     
    public static TokenDao getTokenDao(){
        tokenDao = new TokenDao(getConnection());
        return tokenDao;
    }

    public static TbBwCustDao getTbBwCustDao(){
        tbBwCustDao = new TbBwCustDao(getConnection());
        return tbBwCustDao;
    }
    
    public static TbCmComDao getTbCmComDao(){
        tbCmComDao = new TbCmComDao(getConnection());
        return tbCmComDao;
    }
    
    public static TbBwCustDetDao getTbBwCustDetDao(){
        tbBwCustDetDao = new TbBwCustDetDao(getConnection());
        return tbBwCustDetDao;
    }
    
    public static TbBWIPHDao getTbBWIPHDao(){
        tbBwIPHDao = new TbBWIPHDao(getConnection());
        return tbBwIPHDao;
    }
    
    public static TbBWIPHTempDao getTbBWIPHTempDao(){
        tbBwIPHTempDao = new TbBWIPHTempDao(getConnection());
        return tbBwIPHTempDao;
    }

}
