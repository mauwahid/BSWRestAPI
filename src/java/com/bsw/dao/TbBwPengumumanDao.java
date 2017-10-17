/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bsw.dao;

import com.bsw.domain.TbBwPengumuman;
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

/**
 *
 * @author Maulana Wahid Abdurrahman
 */
public class TbBwPengumumanDao {

    Connection conn;
   
    String querySelect5 = "SELECT * from TBBW_PENGUMUMAN ORDER BY ID DESC";
                   
    public static TbBwPengumumanDao getInstance(){
        return new TbBwPengumumanDao();
    }
    
    public List<TbBwPengumuman> getPengumuman(){
        Statement statement = null;
        conn = Common.getConnection();
       // SaveResponse response = new SaveResponse();
        
        List<TbBwPengumuman> list = new ArrayList<TbBwPengumuman>();
        TbBwPengumuman tbBw = null;
        
        ResultSet rs = null;
        
        try {
            statement = conn.createStatement();
           
            rs = statement.executeQuery(querySelect5);
            
            while(rs.next()){
                tbBw = new TbBwPengumuman();
                tbBw.setCreatedBy(rs.getString("CREATED_BY"));
                tbBw.setCreatedTime(rs.getString("CREATED_TIME"));
                tbBw.setId(rs.getString("ID"));
                tbBw.setJudul(rs.getString("JUDUL"));
                tbBw.setKonten(rs.getString("KONTEN"));
                tbBw.setUpdatedBy(rs.getString("UPDATED_BY"));
                tbBw.setUpdatedTime(rs.getString("UPDATED_TIME"));
                
                list.add(tbBw);
            }
        
        } catch (SQLException ex) {
            System.out.println("ex "+ex.toString());
        }
        
        return list;
    }
    
    
}
