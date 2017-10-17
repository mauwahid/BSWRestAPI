/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bsw.dao;

import com.bsw.domain.TbBwIPHPemohon;
import com.bsw.domain.TbCMCountryCityTMP;
import com.bsw.domain.reqres.ResponseInterface;
import com.bsw.domain.reqres.SaveResponse;
import com.bsw.domain.reqres.StatusResponse;
import com.bsw.utils.Common;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Maulana Wahid Abdurrahman
 */
public class TbBwIPHPemohonDao {
    private Connection conn;
    private String queryNewPemohon = "insert into TBBW_IPH_PEMOHON(CUST_TP, CUST_ID, CUST_NM, CUST_ADDR, "
            + "PRG_NM, STATUS, CUST_EMAIL, CUST_TELP, CUST_NTNTY)\n" +
    "values(?, ?, ?, ?, ?, ?, ?, ?,?)";
    
    
    public static TbBwIPHPemohonDao getInstance(){
        return new TbBwIPHPemohonDao();
    }
   
    public ResponseInterface newPemohon(TbBwIPHPemohon tbBwIPHPemohon){
        
        PreparedStatement statement = null;
        
        int affectRow = 0;
        SaveResponse response = new SaveResponse();
        try {
            conn = Common.getConnection();
            statement = conn.prepareStatement(queryNewPemohon);
            statement.setString(1, tbBwIPHPemohon.getCustTp());
            statement.setString(2, tbBwIPHPemohon.getCustId());
            statement.setString(3, tbBwIPHPemohon.getCustNm());
            statement.setString(4, tbBwIPHPemohon.getCustAddr());
            statement.setString(5, tbBwIPHPemohon.getPrgNm());
            statement.setString(6, "INITIAL");
            statement.setString(7, tbBwIPHPemohon.getCustEmail());
            statement.setString(8, tbBwIPHPemohon.getCustTelp());
            statement.setString(9, tbBwIPHPemohon.getNtnty());
            
            affectRow = statement.executeUpdate();
            
            statement.close();
            conn.close();
            
            if(affectRow>0){
                response.setId(tbBwIPHPemohon.getCustId());
                response.setStatus("SUCCESS");
                response.setStatusDesc("ADD PEMOHON SUCCESS");
            }else{
                  response.setStatus("FAILED");
                  response.setStatusDesc("ADD PEMOHON FAILED");

            }
             
           // return list;
        } catch (SQLException exception) {
            try {
                statement.close();
                conn.close();
                response.setStatus("FAILED");
                response.setStatusDesc(""+exception.getMessage());
              //  return null;
            } catch (SQLException ex) {
                Logger.getLogger(TbCMCountryCityTMP.class.getName()).log(Level.SEVERE, null, ex);
                response.setStatus("FAILED");
                  response.setStatusDesc(""+ex.getMessage());
          
              // return null;
            }
        } 
        return response;
        
    }
}
