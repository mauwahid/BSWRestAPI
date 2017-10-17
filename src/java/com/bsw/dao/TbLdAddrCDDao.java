/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bsw.dao;

import com.bsw.domain.TbCMCountryCityTMP;
import com.bsw.domain.TbComTMP;
import com.bsw.domain.TbLdAddrCD;
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
public class TbLdAddrCDDao {

    private Connection connection;
    private String queryWilayah = "select distinct ADDR_CD, SUB_WIL_NM FROM TBLD_ADDR_CD where SUB_WIL_NM is not null and DSTRT_NM is null";
    private String querySubWilayah = "select * FROM TBLD_ADDR_CD where SUB_WIL_NM = ? and DSTRT_NM is not null and SUB_DSTRT_NM is null";
    private String querySubWilayah2 = "select distinct DSTRT_NM \"namasubwil\" FROM US_REF.TBLD_ADDR_CD where SUB_WIL_NM = #SUB_WIL_NM  and DSTRT_NM is not null";
    private String queryLokasi = "select distinct ADDR_CD, SUB_DSTRT_NM FROM TBLD_ADDR_CD " +
    " where SUB_WIL_NM = ? AND DSTRT_NM = ? ";
    private String queryWilayahPengembangan = "select COM_CD, CD_NM from US_REF.TBCM_COM\n" +
"         where COM_CD like 'D02%' and USE_YN = 'Y' and DISP_SEQ <> '0' ORDER BY COM_CD ASC";
    private String queryWilPengembanganByWil = "select distinct ADDR_CD, SUB_DIT_CD FROM TBLD_ADDR_CD where SUB_WIL_NM = ?";
    private String queryLokasiCode = "select * from TBLD_ADDR_CD  where sub_dstrt_nm is not null";
    private String queryWilayahSub = "select * from TBLD_ADDR_CD where ADDR_CD = #ADDR_CD";
    
    
    public TbLdAddrCDDao(Connection conn){
        connection = conn;
    }
    
    public List<TbLdAddrCD> getWilayah(){
        Statement statement = null;
        ResultSet rs = null;
        List<TbLdAddrCD> list = new ArrayList<TbLdAddrCD>();
           
        try {
           
            statement = connection.createStatement();
            rs = statement.executeQuery(queryWilayah);
            TbLdAddrCD tbLdAddrCD = null;
            while (rs.next()) {
                tbLdAddrCD = new TbLdAddrCD();
              tbLdAddrCD.setAddrCD(rs.getString("ADDR_CD"));
              tbLdAddrCD.setSubWilNm(rs.getString("SUB_WIL_NM"));
              
              list.add(tbLdAddrCD);
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
    
    public List<TbLdAddrCD> getSubWilayah(String param){
        PreparedStatement statement = null;
        ResultSet rs = null;
         List<TbLdAddrCD> list = new ArrayList<TbLdAddrCD>();
        try {
            statement = connection.prepareStatement(querySubWilayah);
            statement.setString(1, param);
            rs = statement.executeQuery();
            TbLdAddrCD tbLdAddrCD = null;
            while (rs.next()) {
                tbLdAddrCD = new TbLdAddrCD();
                tbLdAddrCD.setAddrCD(rs.getString("ADDR_CD"));
                String data = rs.getString("DSTRT_NM");
             //   System.out.println("DATA "+data);
                tbLdAddrCD.setDstrtNm(data);
              
                list.add(tbLdAddrCD);
            }
            statement.close();
            connection.close();
             
           // return list;
        } catch (SQLException exception) {
            try {
                statement.close();
                connection.close();
             
              //  return null;
            } catch (SQLException ex) {
                Logger.getLogger(TbCMCountryCityTMP.class.getName()).log(Level.SEVERE, null, ex);
               // return null;
            }
        } 
        
        return list;
        
    }

    public List<TbLdAddrCD> getLokasi(String subWil,String dstrt){
        PreparedStatement statement = null;
        ResultSet rs = null;
        System.out.println("SUBWIL "+subWil+" dstrt "+dstrt);
        List<TbLdAddrCD> list = new ArrayList<TbLdAddrCD>();
            try {
           
            statement = connection.prepareStatement(queryLokasi);
            statement.setString(2, subWil);
            statement.setString(1, dstrt);
            
            rs = statement.executeQuery();
            TbLdAddrCD tbLdAddrCD = null;
            while (rs.next()) {
                System.out.println("Data ");
                tbLdAddrCD = new TbLdAddrCD();
                tbLdAddrCD.setAddrCD(rs.getString("ADDR_CD"));
                tbLdAddrCD.setSubDstrtNm(rs.getString("SUB_DSTRT_NM"));
                System.out.println(""+tbLdAddrCD.getSubDstrtNm());
              
                list.add(tbLdAddrCD);
            }
            statement.close();
            connection.close();
            
        } catch (SQLException exception) {
            try {
                statement.close();
                connection.close();
            
            } catch (SQLException ex) {
                Logger.getLogger(TbCMCountryCityTMP.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        return list;
        
    }
    
    public List<TbComTMP> getWilayahPengembangan(){
        Statement statement = null;
        ResultSet rs = null;
        List<TbComTMP> list = new ArrayList<TbComTMP>();
           
        try {
           
            statement = connection.createStatement();
            rs = statement.executeQuery(queryWilayahPengembangan);
            TbComTMP tbComCMP = null;
            while (rs.next()) {
                tbComCMP = new TbComTMP();
                tbComCMP.setCdNm(rs.getString("CD_NM"));
                tbComCMP.setComCd(rs.getString("COM_CD"));
                list.add(tbComCMP);
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
    
    public TbComTMP getWilayahPengembanganByWilayah(String wilayah){
        PreparedStatement statement = null;
        ResultSet rs = null;
        TbComTMP tbComCMP = null;
        System.out.println("WiL : "+wilayah);
               
        try {
           
            statement = connection.prepareStatement(queryWilPengembanganByWil);
            statement.setString(1, wilayah);
            rs = statement.executeQuery();
           // TbComTMP tbComCMP = null;
            while (rs.next()) {
                tbComCMP = new TbComTMP();
                tbComCMP.setAddrCd(rs.getString("ADDR_CD"));
                tbComCMP.setComCd(rs.getString("SUB_DIT_CD"));
            //    list.add(tbComCMP);
            }
            statement.close();
            connection.close();
          //  return list;
        } catch (SQLException exception) {
            try {
                statement.close();
                connection.close();
                System.out.println("EXC "+exception);
            //    return null;
            } catch (SQLException ex) {
                Logger.getLogger(TbCMCountryCityTMP.class.getName()).log(Level.SEVERE, null, ex);
            //    return null;
            }
        } 
        
        return tbComCMP;
        
    }
    
    public List<TbLdAddrCD> getLokasiCode(){
        Statement statement = null;
        ResultSet rs = null;
        List<TbLdAddrCD> list = new ArrayList<TbLdAddrCD>();
           
        try {
           
            statement = connection.createStatement();
            rs = statement.executeQuery(queryLokasiCode);
            TbLdAddrCD tbLdAddrCD = null;
            while (rs.next()) {
                tbLdAddrCD = new TbLdAddrCD();
                tbLdAddrCD.setAddrCD(rs.getString("ADDR_CD"));
                tbLdAddrCD.setSubWilNm(rs.getString("WIL_NM") + " - "+ rs.getString("SUB_DSTRT_NM"));
              
              list.add(tbLdAddrCD);
            }
            statement.close();
            connection.close();
          //  return list;
        } catch (SQLException exception) {
            try {
                statement.close();
                connection.close();
                System.out.println("EX "+exception.toString());
            //    return null;
            } catch (SQLException ex) {
                Logger.getLogger(TbCMCountryCityTMP.class.getName()).log(Level.SEVERE, null, ex);
            //    return null;
            }
        } 
        
        return list;
        
    }
    
    public TbLdAddrCD getWilayahSubWilayah(String addrCd){
        Statement statement = null;
        ResultSet rs = null;
        TbLdAddrCD tbLdAddrCD = new TbLdAddrCD();
        System.out.println("System : "+addrCd);
          queryWilayahSub = queryWilayahSub.replace("#ADDR_CD", "'"+addrCd+"'");
            System.out.println("query "+queryWilayahSub);
          
        
      //  connection = Common.getConnection();
               
        try {
           
            statement = connection.createStatement();
          //  statement.setString(1, addrCd);
            rs = statement.executeQuery(queryWilayahSub);
           // TbComTMP tbComCMP = null;
            if(rs.next()) {
                tbLdAddrCD.setAddrCD(rs.getString("ADDR_CD"));
                tbLdAddrCD.setDstrtNm(rs.getString("DSTRT_NM"));
                tbLdAddrCD.setSubDstrtNm(rs.getString("SUB_DSTRT_NM"));
                tbLdAddrCD.setSubWilNm(rs.getString("SUB_WIL_NM"));
                tbLdAddrCD.setWilNm(rs.getString("WIL_NM"));
            //    list.add(tbComCMP);
            }
            statement.close();
            connection.close();
          //  return list;
        } catch (SQLException exception) {
            try {
                statement.close();
                connection.close();
                System.out.println("EXC "+exception);
            //    return null;
            } catch (SQLException ex) {
                Logger.getLogger(TbCMCountryCityTMP.class.getName()).log(Level.SEVERE, null, ex);
            //    return null;
            }
        } 
        
        return tbLdAddrCD;
        
    }
    

    
    
}
