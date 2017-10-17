/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bsw.dao;

import com.bsw.domain.reqres.ResponseInterface;
import com.bsw.domain.reqres.SaveResponse;
import com.bsw.utils.Common;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Maulana Wahid Abdurrahman
 */
public class TbBwPersetujuanDao {
    
    Connection conn;
    String queryInsert = "INSERT INTO TBBW_PERSETUJUAN\n" +
                    "(NAME, TYPE, APPLICATION, USERNAME, STATUS, REMARKS, COMPANY, DATE_INSERT, CREATEDBY)\n" +
                    " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
    
    String queryCek = "SELECT * from TBBW_PERSETUJUAN " +
                     " where NAME = ? and TYPE = ? and APPLICATION = ?  and COMPANY=?";
                   
    public static TbBwPersetujuanDao getInstance(){
        return new TbBwPersetujuanDao();
    }
    
    public ResponseInterface savePersetujuan(String name,String type, String application,
            String username,  String company){
        PreparedStatement statement = null;
        conn = Common.getConnection();
        SaveResponse response = new SaveResponse();
        int rs = 0;
        
        try {
            statement = conn.prepareStatement(queryInsert);
            statement.setString(1, name);
            statement.setString(2,type);
            statement.setString(3, application);
            statement.setString(4, username);
            statement.setString(5, "APPROVE");
            statement.setString(6, "Sudah menyetujui seluruh aturan dan ketetapan");
            statement.setString(7, company);
            statement.setDate(8, Common.getCurrentDate());
            statement.setString(9, username);
           // statement.setString(10, username);
            
            rs = statement.executeUpdate();
            response.setStatus("SUCCESS");
            response.setStatusDesc("PERSETUJUAN SUCCESS");
        
        } catch (SQLException ex) {
            response.setStatus("FAILED");
            response.setStatusDesc("PERSETUJUAN FAILED "+ex.toString());
        
        }
        
        return response;
    }
    
    
    public ResponseInterface cek(String name,String type, String application,
            String company){
        PreparedStatement statement = null;
        conn = Common.getConnection();
        SaveResponse response = new SaveResponse();
        ResultSet rs = null;
        
        response.setStatus("NOTFOUND");
        response.setStatusDesc("BELUM MELAKUKAN PERSETUJUAN");
        
        
        try {
            statement = conn.prepareStatement(queryCek);
            statement.setString(1, name);
            statement.setString(2,type);
            statement.setString(3, application);
          //  statement.setString(4, username);
           // statement.setString(5, "APPROVE");
          //  statement.setString(6, "Sudah menyetujui seluruh aturan dan ketetapan");
            statement.setString(4, company);
           // statement.setString(10, username);
            
            rs = statement.executeQuery();
            
            while(rs.next()){
                response.setStatus(rs.getString("STATUS"));
                response.setStatusDesc("SUDAH MELAKUKAN PERSETUJUAN");
            }
            
            
        } catch (SQLException ex) {
            response.setStatus("FAILED");
            response.setStatusDesc("PERSETUJUAN FAILED "+ex.toString());
        
        }
        
        return response;
    }
    
    
    

}
