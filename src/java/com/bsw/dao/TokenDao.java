/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bsw.dao;

import com.bsw.domain.TbBW2Status;
import com.bsw.domain.Token;
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
public class TokenDao {
    
    private Connection conn;
    private String query = "select  from TBBW2_STATUS order by STATUS";
    
    
    public TokenDao(Connection conn){
        this.conn = conn;
    }
    
    public boolean isValid(String tokenID){
        
        return true;
    }
    
    public boolean updateToken(String tokenID){
        return true;
    }
    
    public boolean  saveToken(Token token){
        return true;
    }
 
}
