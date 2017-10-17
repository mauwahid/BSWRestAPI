/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bsw.dao;

import com.bsw.domain.TbBwIPHPemohon;
import com.bsw.domain.TbBwIPHStatReg;
import com.bsw.domain.TbCMCountryCityTMP;
import com.bsw.domain.reqres.ResponseInterface;
import com.bsw.domain.reqres.SaveResponse;
import com.bsw.utils.Common;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Maulana Wahid Abdurrahman
 */
public class TbBwIPHStatRegDao {

     private Connection conn;
    private String queryIPHStatReg = "SELECT * FROM TBBW_IPH_STAT_REG WHERE CDSTATUS != '1'";
    
    
    public static TbBwIPHStatRegDao getInstance(){
        return new TbBwIPHStatRegDao();
    }
   
    public List<TbBwIPHStatReg> getIPHStatReg(){
        
        Statement statement = null;
        ResultSet rs = null;
        TbBwIPHStatReg response = new TbBwIPHStatReg();
        List<TbBwIPHStatReg> list = new ArrayList<TbBwIPHStatReg>();
        TbBwIPHStatReg tbBw = null;
        try {
            conn = Common.getConnection();
            statement = conn.createStatement();
            
            rs = statement.executeQuery(queryIPHStatReg);
           
            while(rs.next()){
                tbBw = new TbBwIPHStatReg();
                tbBw.setCdStatus(rs.getString("CDSTATUS"));
                tbBw.setValStatus(rs.getString("VALSTATUS"));
                list.add(tbBw);
            }
            
            statement.close();
            conn.close();
                         
           // return list;
        } catch (SQLException exception) {
            try {
                statement.close();
                conn.close();
                System.out.println("EX "+exception.toString());
                //  return null;
            } catch (SQLException ex) {
                Logger.getLogger(TbCMCountryCityTMP.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("EX "+ex.toString());
             
              // return null;
            }
        } 
        return list;
        
    }
    
}
