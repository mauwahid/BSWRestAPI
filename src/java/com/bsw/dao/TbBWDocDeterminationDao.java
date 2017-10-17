/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bsw.dao;

import com.bsw.domain.TbbwDocDetermination;
import com.bsw.utils.Common;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Maulana Wahid Abdurrahman
 */
public class TbBWDocDeterminationDao {
    
    private String queryDoc = "SELECT a.*, b.CD_NM FROM\n" +
"             TBBW_DOC_DETERMINATION a \n" +
"             left join US_REF.TBCM_COM b on\n" +
"             a.COM_CD = b.COM_CD where\n" +
"             a.AD_APP_LIST = ? Order by ISMANDATORY_YN DESC";
    
    public static TbBWDocDeterminationDao getInstance(){
        return new TbBWDocDeterminationDao();
    }
    
    
    public List<TbbwDocDetermination> getListDocs(String adAppList){
        PreparedStatement stat = null;
        Connection conn = Common.getConnection();
        ResultSet rs = null;
        List<TbbwDocDetermination> list = new ArrayList<TbbwDocDetermination>();
        TbbwDocDetermination tbBw = null;
        try {
            stat = conn.prepareStatement(queryDoc);
            stat.setString(1, adAppList);
            
            rs = stat.executeQuery();
            while(rs.next()){
                tbBw = new TbbwDocDetermination();
                tbBw.setComCd(rs.getString("COM_CD"));
                tbBw.setCdNm(rs.getString("CD_NM"));
                tbBw.setIskhususYn(rs.getString("ISKHUSUS_YN"));
                tbBw.setIsmandatoryYn(rs.getString("ISMANDATORY_YN"));
                tbBw.setIsperpanjanganYn(rs.getString("ISPERPANJANGAN_YN"));
                
                list.add(tbBw);

            }
            
            stat.close();
            conn.close();
        } catch (SQLException ex) {
           System.out.println("Ex "+ex.toString());
        }
        
        
        return list;
        
        
    }

}
