/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bsw.dao;

import com.bsw.domain.TbCMCountryCityTMP;
import java.sql.Connection;
import java.sql.DriverManager;
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
public class TBCMCountryCityTMPDao {
    private Connection connection;
    private String query = "select * from TBBW2_STATUS order by STATUS";
 //   private String queryCountry = "select * from TBCM_COUNTRY_CITY_BSW3  where CODE_TP = 'A' order by MGMT_NO";
      private String queryCountry = "select * from TBCM_COUNTRY_CITY_BSW3  where CODE_TP = 'A' order by MGMT_NO";
    
    
    public TBCMCountryCityTMPDao(Connection conn){
        connection = conn;
    }
    
    public List<TbCMCountryCityTMP> getCountry(){
        Statement statement = null;
        ResultSet rs = null;
        List<TbCMCountryCityTMP> list = new ArrayList<TbCMCountryCityTMP>();
            
        try {
         //   Class.forName("oracle.jdbc.driver.OracleDriver"); 
          //  Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:bswtest","US_BW","welcome1");
            
            statement = connection.createStatement();
            rs = statement.executeQuery(queryCountry);
            TbCMCountryCityTMP tbCMCountryCityTMP = null;
            while (rs.next()) {
                tbCMCountryCityTMP = new TbCMCountryCityTMP();
                tbCMCountryCityTMP.setCodeTp(rs.getString("CODE_TP"));
                tbCMCountryCityTMP.setMgmtNo(rs.getString("MGMT_NO"));
                tbCMCountryCityTMP.setCodeNm(rs.getString("CODE_NM"));
                tbCMCountryCityTMP.setCodeAbbr(rs.getString("CODE_ABBR"));
                tbCMCountryCityTMP.setDispSeq(rs.getString("DISP_SEQ"));
                list.add(tbCMCountryCityTMP);
            }
            statement.close();
            connection.close();
          
          //  return list;
        } catch (Exception exception) {
              Logger.getLogger(TbCMCountryCityTMP.class.getName()).log(Level.SEVERE, null, exception);
              
              
        }
        return list;
        
    }
}
