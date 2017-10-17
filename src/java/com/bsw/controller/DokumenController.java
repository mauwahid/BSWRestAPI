/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bsw.controller;

import com.bsw.utils.Common;
import com.bsw.utils.DokumenConfig;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import org.apache.log4j.Logger;

/**
 *
 * @author Maulana Wahid Abdurrahman
 */
public class DokumenController {

    private static final Logger logger = Logger.getLogger(DokumenController.class.getName());
   
    public static DokumenController getInstance(){
        return new DokumenController();
    }
    
    
    public HashMap getDocumentLocation(int tipe, String id,String kodeDokumen){
        PreparedStatement statement = null;
        ResultSet rs = null;
      
        HashMap map = new HashMap();
        
     //   System.out.println(" TIPE "+tipe+" id "+id+" kdoe "+kodeDokumen);
        
        String root = Common.getRootLocation();
        
      //  System.out.println("ROOT "+root);
        
        Connection conn = Common.getConnection();
        try {
           
            statement = conn.prepareStatement(queryGenerator(tipe));
            statement.setString(1, id);
            statement.setString(2, kodeDokumen);
            rs = statement.executeQuery();
            while (rs.next()) {
                if(tipe==3){
                    map.put("file_name", rs.getString("PY_FILE_NM"));
                    map.put("file_tp", rs.getString("FILE_EXT"));
                }else{
                    map.put("file_name", rs.getString("PHY_FILE_NM"));
                    map.put("file_tp", rs.getString("FILE_TP"));
                }
                
                map.put("file_ext", rs.getString("FILE_EXT"));
                root = root + "/" + rs.getString("PHY_FILE_PATH");
                
           //     System.out.println("PATH "+root);
                map.put("file_path", root);
                
            }
            statement.close();
          
        } catch (SQLException exception) {
            try {
             //   statement.close();
                logger.error("root : "+root+", exception : "+exception.toString());
                conn.close();
        //       System.out.println("EX "+exception.toString());
                
            } catch (SQLException ex) {
               // Logger.getLogger(TbComTMPDao.class.getName()).log(Level.SEVERE, null, ex);
          //     System.out.println("EX "+ex.toString());
                      logger.error("close sql exception : "+exception.toString());
          
            }
        } 
        return map;
        
    }
    
    private String queryGenerator(int type){
        
        String query = "";
        switch(type){
            case DokumenConfig.CUST_DETL :
                query = DokumenConfig.queryCustDetlDoc();
                break;
            case DokumenConfig.IPH_DETL :
                query = DokumenConfig.queryIPHDetl();
                break;
            case DokumenConfig.PEMATANGAN_DETL :
                query = DokumenConfig.queryPematanganDetl();
                break;
            case DokumenConfig.PEMATANGAN_DOC :
                query = DokumenConfig.queryPematanganDoc();
                break;
            case DokumenConfig.REKLAME_DOC :
                query = DokumenConfig.queryReklameDoc();
                break;
           
        }
        
     //   System.out.println("QUERY "+query);
        return query;
    }
    
    
}
