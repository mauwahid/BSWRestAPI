/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bsw.dao;

import com.bsw.domain.TbCMCountryCityTMP;
import com.bsw.domain.TbCmCom;
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
public class TbCmComDao {
    
    private Connection connection;
        private String queryMenu = "select COM_CD, CD_NM from US_REF.TBCM_COM where com_cd like 'D41%' and USE_YN = 'Y' and COM_CD <> 'D4100'";
    private String queryDocMapping = "select a.DOC_TP, b.CD_NM \n" +
    "from US_REF.TBLD_REGISTER_MAP a \n" +
    "inner join US_BW.TBCM_COM_TMP b on a.DOC_TP = b.COM_CD\n" +
    "where a.REG_TP = ? and a.APPLCNT_TP = ?";
   private String queryDocMapping2 = "select a.DOC_TP, a.MUST_YN, b.CD_NM \n" +
            "from \n" +
            "US_REF.TBLD_REGISTER_MAP a, US_REF.TBCM_COM b \n" +
            "where A.DOC_TP = B.COM_CD\n" +
           // "and A.MUST_YN = 'Y'\n" +
            "and a.REG_TP = ? and a.APPLCNT_TP = ? " +
            "ORDER BY a.MUST_YN DESC,a.DISP_SEQ ASC";
   
    
    public TbCmComDao(Connection conn){
        connection = conn;
    }
    
    
    public List<TbCmCom> getMenuAlokasiLahan(){
        Statement statement = null;
        ResultSet rs = null;
        List<TbCmCom> list = new ArrayList<TbCmCom>();
           
        try {
           
            statement = connection.createStatement();
            rs = statement.executeQuery(queryMenu);
            TbCmCom tbCmCom = null;
            while (rs.next()) {
                tbCmCom = new TbCmCom();
                tbCmCom.setComCd(rs.getString("COM_CD"));
                tbCmCom.setCdNm(rs.getString("CD_NM"));
              
                list.add(tbCmCom);
            }
            statement.close();
            connection.close();
          //  return list;
        } catch (SQLException exception) {
            try {
                statement.close();
                connection.close();
            //    return null;
            } catch (SQLException ex) {
                Logger.getLogger(TbCMCountryCityTMP.class.getName()).log(Level.SEVERE, null, ex);
            //    return null;
            }
        } 
        
        return list;
        
    }
    
    public List<TbCmCom> getDocMapping(String regTp, String applicantTp){
        PreparedStatement statement = null;
        ResultSet rs = null;
        List<TbCmCom> list = new ArrayList<TbCmCom>();
           
        try {
            statement = connection.prepareCall(queryDocMapping2);
            statement.setString(1, regTp);
            statement.setString(2, applicantTp);
            rs = statement.executeQuery();
            TbCmCom tbCmCom = null;
            while (rs.next()) {
                tbCmCom = new TbCmCom();
                tbCmCom.setComCd(rs.getString("DOC_TP"));
                tbCmCom.setCdNm(rs.getString("CD_NM"));
                tbCmCom.setMustYN(rs.getString("MUST_YN"));
              
                list.add(tbCmCom);
            }
            statement.close();
            connection.close();
          //  return list;
        } catch (SQLException exception) {
            try {
                statement.close();
                connection.close();
                System.out.println("EX "+exception);
            //    return null;
            } catch (SQLException ex) {
                Logger.getLogger(TbCMCountryCityTMP.class.getName()).log(Level.SEVERE, null, ex);
            //    return null;
            }
        } 
        
        return list;
        
    }
    

}
