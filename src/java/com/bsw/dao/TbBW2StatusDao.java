/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bsw.dao;

import com.bsw.domain.TbBW2Status;
import java.sql.Connection;
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
public class TbBW2StatusDao {
    private Connection connection;
    private String query = "select * from TBBW2_STATUS order by STATUS";
    
    
    public TbBW2StatusDao(Connection conn){
        connection = conn;
    }
    
    public List<TbBW2Status> getStatus(){
        Statement statement = null;
        ResultSet rs = null;
        List<TbBW2Status> list = new ArrayList<TbBW2Status>();
        try {
           
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            TbBW2Status tbBWStatus = null;
            while (rs.next()) {
                tbBWStatus = new TbBW2Status();
                tbBWStatus.setStatus(rs.getString("STATUS"));
                
                list.add(tbBWStatus);
            }
            statement.close();
            connection.close();
          
        } catch (SQLException exception) {
            try {
                statement.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(TbComTMPDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        
        return list;
        
    }
    
    
}
