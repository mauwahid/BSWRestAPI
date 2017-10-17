/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bsw.dao;

import com.bsw.domain.TbBW2Status;
import com.bsw.domain.TbBwCustDetil;
import com.bsw.domain.TbCMCountryCityTMP;
import com.bsw.domain.reqres.StatusResponse;
import com.bsw.utils.Common;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OraclePreparedStatement;
/**
 *
 * @author Maulana Wahid Abdurrahman
 */
public class TbBwCustDetDao {
    
    private Connection conn;
    private String queryDocProfile = "SELECT a.*,(SELECT CD_NM FROM US_REF.TBCM_COM where COM_CD = a.COM_CD) as CD_NM  FROM US_BW.TBBW_CUST_DETL a WHERE IDCUST = ?";
    private String queryCreateDoc = "INSERT INTO TBBW_CUST_DETL (IDCUST, FILE_SEQ, COM_CD, FILE_NM, PHY_FILE_PATH, PHY_FILE_NM,"
            + "FILE_EXT, FILE_SIZE, FILE_TP,\n" +
            "TEMP_FILE_YN, CREATEDBY, REMARKS, DOCUMENT_NO, EXT_DMT, DATE_INSERT)\n" +
            "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private String queryNextID = "SELECT MAX(FILE_SEQ) + 1 as FileSeq FROM TBBW_CUST_DETL WHERE IDCUST=?";
    private String queryCekNPWP = "SELECT * FROM TBBW_CUST_DETL WHERE IDCUST=? and COM_CD = 'D0904' ";
    private String queryGetDoc = "SELECT * FROM TBBW_CUST_DETL WHERE IDCUST=? and COM_CD=?";
    private String queryUpdateDoc = "UPDATE TBBW_CUST_DETL set FILE_NM = ?, PHY_FILE_PATH = ?, PHY_FILE_NM = ?, FILE_SIZE = ?, FILE_TP = ?,\n" +
    "UPDATEDBY = ?, DATE_UPDATE = ?, REMARKS = ?, DOCUMENT_NO = ?, EXT_DMT = ? " +
    "WHERE  IDCUST = ? and COM_CD = ?";
    private String queryUpdateDocStat = "UPDATE TBBW_CUST_DETL set FILE_NM = #FILE_NM, PHY_FILE_PATH = #PHY_FILE_PATH, PHY_FILE_NM = #PHY_FILE_NM, FILE_SIZE = #FILE_SIZE, FILE_TP = #FILE_TP,\n" +
    "UPDATEDBY = #UPDATEDBY, DATE_UPDATE = #DATE_UPDATE, REMARKS = #REMARKS, DOCUMENT_NO = #DOCUMENT_NO, EXT_DMT = #EXT_DMT " +
    "WHERE  IDCUST=#IDCUST and COM_CD =#COM_CD";
     private String queryDeleteDoc = "DELETE TBBW_CUST_DETL WHERE IDCUST=#IDCUST and COM_CD =#COM_CD";
   
    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
     
    public TbBwCustDetDao(Connection conn){
        this.conn = conn;
    }
    
    
    public List<TbBwCustDetil> getDocs(String idCust){
        PreparedStatement statement = null;
        ResultSet rs = null;
        TbBwCustDetil tbBwCustDetil;
        List<TbBwCustDetil> list = new ArrayList<TbBwCustDetil>();
        try {
            statement = conn.prepareStatement(queryDocProfile);
            statement.setString(1, idCust);
            rs = statement.executeQuery();
            while (rs.next()) {
               
               tbBwCustDetil = new TbBwCustDetil();
               tbBwCustDetil.setComCd(rs.getString("COM_CD"));
               tbBwCustDetil.setIdCust(rs.getString("IDCUST"));
               tbBwCustDetil.setFileSeq(rs.getString("FILE_SEQ"));
               tbBwCustDetil.setFileNm(rs.getString("FILE_NM"));
               tbBwCustDetil.setPhyFilePath(rs.getString("PHY_FILE_PATH"));
               tbBwCustDetil.setPhyFileNm(rs.getString("PHY_FILE_NM"));
               tbBwCustDetil.setFileExt(rs.getString("FILE_EXT"));
               tbBwCustDetil.setFileSize(rs.getString("FILE_SIZE"));
               tbBwCustDetil.setFileTp(rs.getString("FILE_TP"));
               tbBwCustDetil.setTempFileYN(rs.getString("TEMP_FILE_YN"));
               tbBwCustDetil.setRemarks(rs.getString("REMARKS"));
               tbBwCustDetil.setDocumentNo(rs.getString("DOCUMENT_NO"));
               try{
                   tbBwCustDetil.setExtDmt(format.format(rs.getDate("EXT_DMT")));
               }catch(Exception ex){
                   
               }
               tbBwCustDetil.setComNM(rs.getString("CD_NM"));
               
               list.add(tbBwCustDetil);
               
            }
            statement.close();
            conn.close();
             
           // return list;
        } catch (SQLException exception) {
            try {
                statement.close();
                conn.close();
              //  return null;
            } catch (SQLException ex) {
                Logger.getLogger(TbCMCountryCityTMP.class.getName()).log(Level.SEVERE, null, ex);
               
              // return null;
            }
        } 
        
        return list;
    }
    
    
    public TbBwCustDetil getNPWP(String idCust){
        PreparedStatement statement = null;
        ResultSet rs = null;
        TbBwCustDetil tbBwCustDetil = new TbBwCustDetil();
        try {
            statement = conn.prepareStatement(queryCekNPWP);
            statement.setString(1, idCust);
            
            rs = statement.executeQuery();
            while (rs.next()) {
               tbBwCustDetil.setIdCust(rs.getString("IDCUST"));
               tbBwCustDetil.setFileSeq(rs.getString("FILE_SEQ"));
               tbBwCustDetil.setFileNm(rs.getString("FILE_SEQ"));
               tbBwCustDetil.setPhyFilePath(rs.getString("FILE_SEQ"));
               tbBwCustDetil.setPhyFileNm(rs.getString("FILE_SEQ"));
               tbBwCustDetil.setFileExt(rs.getString("FILE_SEQ"));
               tbBwCustDetil.setFileSize(rs.getString("FILE_SEQ"));
               tbBwCustDetil.setFileTp(rs.getString("FILE_SEQ"));
               tbBwCustDetil.setTempFileYN(rs.getString("TEMP_FILE_YN"));
               tbBwCustDetil.setRemarks(rs.getString("REMARKS"));
               tbBwCustDetil.setDocumentNo(rs.getString("DOCUMENT_NO"));
               tbBwCustDetil.setExtDmt(format.format(rs.getDate("EXT_DMT")));
               
               
            }
            statement.close();
            conn.close();
             
           // return list;
        } catch (SQLException exception) {
            try {
                statement.close();
                conn.close();
              //  return null;
                System.out.println("ex "+exception.toString());
            } catch (SQLException ex) {
                Logger.getLogger(TbCMCountryCityTMP.class.getName()).log(Level.SEVERE, null, ex);
                         System.out.println("ex "+ex.toString());
      
              // return null;
            }
        } 
        
        return tbBwCustDetil;
    }
    

    public TbBwCustDetil getDoc(String idCust,String docTp){
        PreparedStatement statement = null;
      //  Statement statement1 = null;
        ResultSet rs = null;
      //  String query = "SELECT * FROM TBBW_CUST_DETL WHERE IDCUST='"+idCust+"' and COM_CD='"+docTp+"'";
        TbBwCustDetil tbBwCustDetil = new TbBwCustDetil();
        System.out.println("ID CUST "+idCust);
      //  conn = Common.getConnection();
        try {
            statement = conn.prepareStatement(queryGetDoc);
            statement.setString(1, idCust);
            statement.setString(2, docTp);
            
            rs = statement.executeQuery();
            
       //     statement1 = conn.createStatement();
       //     rs = statement1.executeQuery(query);
            
          //  System.out.println("DO QUERY "+query);
               
            while (rs.next()) {
               System.out.println("NEXT RS "+rs.getString("IDCUST"));
               tbBwCustDetil = new TbBwCustDetil();
               tbBwCustDetil.setComCd(rs.getString("COM_CD"));
               tbBwCustDetil.setIdCust(rs.getString("IDCUST"));
               tbBwCustDetil.setFileSeq(rs.getString("FILE_SEQ"));
               tbBwCustDetil.setFileNm(rs.getString("FILE_NM"));
               tbBwCustDetil.setPhyFilePath(rs.getString("PHY_FILE_PATH"));
               tbBwCustDetil.setPhyFileNm(rs.getString("PHY_FILE_NM"));
               tbBwCustDetil.setFileExt(rs.getString("FILE_EXT"));
               tbBwCustDetil.setFileSize(rs.getString("FILE_SIZE"));
               tbBwCustDetil.setFileTp(rs.getString("FILE_TP"));
               tbBwCustDetil.setTempFileYN(rs.getString("TEMP_FILE_YN"));
               tbBwCustDetil.setRemarks(rs.getString("REMARKS"));
               tbBwCustDetil.setDocumentNo(rs.getString("DOCUMENT_NO"));
                try{
                   tbBwCustDetil.setExtDmt(format.format(rs.getDate("EXT_DMT")));
               }catch(Exception ex){
                   
               }               
               
            }
            statement.close();
            conn.close();
             
           // return list;
        } catch (SQLException exception) {
            try {
                statement.close();
                conn.close();
              //  return null;
                System.out.println("EXCEPTION "+exception.toString());
            } catch (SQLException ex) {
                Logger.getLogger(TbCMCountryCityTMP.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("EXCEPTION "+ex.toString());
               
              // return null;
            }
        } 
        
        return tbBwCustDetil;
    }
    
    
    
    private int getNextID(){
        int id = 0;
        
        Statement statement = null;
        ResultSet rs = null;
        List<TbBW2Status> list = new ArrayList<TbBW2Status>();
        try {
            statement = Common.getConnection().createStatement();
            rs = statement.executeQuery(queryNextID);
            while (rs.next()) {
                id = rs.getInt("FileSeq");
            }
            statement.close();
            conn.close();
          
        } catch (SQLException exception) {
            try {
                statement.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(TbComTMPDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        
        return id;
        
    }
    
    public StatusResponse saveDoc(TbBwCustDetil tbBwCustDetil){
        PreparedStatement statement = null;
        
        StatusResponse response = new StatusResponse();
        int rs = 0;
        try {
           
            statement = conn.prepareStatement(queryCreateDoc);
            statement.setString(1, tbBwCustDetil.getIdCust());
            statement.setString(2, tbBwCustDetil.getFileSeq());
            statement.setString(3, tbBwCustDetil.getComCd());
            statement.setString(4, tbBwCustDetil.getFileNm());
            statement.setString(5, tbBwCustDetil.getPhyFilePath());
            statement.setString(6, tbBwCustDetil.getPhyFileNm());
            statement.setString(7, tbBwCustDetil.getFileExt());
            statement.setString(8, tbBwCustDetil.getFileSize());
            statement.setString(9, tbBwCustDetil.getFileTp());
            statement.setString(10, tbBwCustDetil.getTempFileYN());
            statement.setString(11, tbBwCustDetil.getCreatedBy());
            statement.setString(12, tbBwCustDetil.getRemarks());
            statement.setString(13, tbBwCustDetil.getDocumentNo());
            try {
                statement.setDate(14, Common.convertToDate(tbBwCustDetil.getExtDmt()));
            } catch (Exception ex) {
                statement.setDate(14, null);
            }
            statement.setDate(15, Common.getCurrentDate());
            
            rs = statement.executeUpdate();
            
            statement.close();
            conn.close();
             
           // return list;
        } catch (SQLException exception) {
            try {
                statement.close();
                conn.close();
                System.out.println("EXCEPTION "+exception.toString());
             
              //  return null;
            } catch (SQLException ex) {
                Logger.getLogger(TbCMCountryCityTMP.class.getName()).log(Level.SEVERE, null, ex);
               // return null;
                 System.out.println("EXCEPTION "+ex.toString());
             
            }
        } 
        
        if(rs>0){
            response.setStatus("SUCCESS");
            response.setStatusDesc("ADD Cust DOC SUCCESS");
        }else{
            response.setStatus("FAILED");
            response.setStatusDesc("ADD Cust DOC FAILED");
       
        }
        
        return response;
        
    }
    
    
    public StatusResponse updateDoc(TbBwCustDetil tbBwCustDetil){
      //  PreparedStatement statement = null;
        Statement statement = null;
        
        StatusResponse response = new StatusResponse();
        int rs = 0;
        try {
            statement = conn.createStatement();
            
        /*   
            statement = conn.prepareStatement(queryUpdateDoc);
            statement.setString(1, tbBwCustDetil.getFileNm());
            statement.setString(2, tbBwCustDetil.getPhyFilePath());
            statement.setString(3, tbBwCustDetil.getPhyFileNm());
            statement.setString(4, tbBwCustDetil.getFileSize());
            statement.setString(5, tbBwCustDetil.getFileTp());
            statement.setString(6, tbBwCustDetil.getCreatedBy());
            statement.setDate(7, Common.getCurrentDate());
            statement.setString(8, tbBwCustDetil.getRemarks());
            statement.setString(9, tbBwCustDetil.getDocumentNo());
            statement.setDate(10, tbBwCustDetil.getExtDmt());
            statement.setString(11, tbBwCustDetil.getIdCust());
            statement.setString(12, tbBwCustDetil.getComCd());
         */
            
            queryUpdateDocStat = queryUpdateDocStat.replace("#FILE_NM", "'"+tbBwCustDetil.getFileNm()+"'");
            queryUpdateDocStat = queryUpdateDocStat.replace("#PHY_FILE_PATH", "'"+tbBwCustDetil.getPhyFilePath()+"'");
            queryUpdateDocStat = queryUpdateDocStat.replace("#PHY_FILE_NM", "'"+tbBwCustDetil.getPhyFileNm()+"'");
            queryUpdateDocStat = queryUpdateDocStat.replace("#FILE_SIZE","'"+ tbBwCustDetil.getFileSize()+"'");
            queryUpdateDocStat = queryUpdateDocStat.replace("#FILE_TP", "'"+tbBwCustDetil.getFileTp()+"'");
            queryUpdateDocStat = queryUpdateDocStat.replace("#UPDATEDBY", "'"+tbBwCustDetil.getCreatedBy()+"'");
            queryUpdateDocStat = queryUpdateDocStat.replace("#DATE_UPDATE", "SYSDATE");
            queryUpdateDocStat = queryUpdateDocStat.replace("#REMARKS", "'"+tbBwCustDetil.getRemarks()+"'");
            queryUpdateDocStat = queryUpdateDocStat.replace("#DOCUMENT_NO", "'"+tbBwCustDetil.getDocumentNo()+"'");
            queryUpdateDocStat = queryUpdateDocStat.replace("#EXT_DMT", "to_date('"+tbBwCustDetil.getExtDmt()+"','dd/MM/yyyy')");
            queryUpdateDocStat = queryUpdateDocStat.replace("#IDCUST", "'"+tbBwCustDetil.getIdCust()+"'");
            queryUpdateDocStat = queryUpdateDocStat.replace("#COM_CD", "'"+tbBwCustDetil.getComCd()+"'");
            
            rs = statement.executeUpdate(queryUpdateDocStat);
          //  OraclePreparedStatement sql = ((OraclePreparedStatement) statement);
            System.out.println("RS : "+rs+" PS : "+queryUpdateDocStat);
            
            statement.close();
            conn.close();
             
           // return list;
        } catch (SQLException exception) {
            try {
                statement.close();
                conn.close();
               System.out.println("EXC "+exception.toString());
              
              //  return null;
            } catch (SQLException ex) {
                Logger.getLogger(TbCMCountryCityTMP.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("EXC "+ex.toString());
               // return null;
            }
        } 
        
        if(rs>0){
            response.setStatus("SUCCESS");
            response.setStatusDesc("UPD Cust DOC SUCCESS");
        }else{
            response.setStatus("FAILED");
            response.setStatusDesc("UPD Cust DOC FAILED");
       
        }
        
        return response;
        
    }
    
    public StatusResponse deleteDoc(String custId, String docTp){
      //  PreparedStatement statement = null;
        Statement statement = null;
        
        StatusResponse response = new StatusResponse();
        int rs = 0;
        try {
            statement = conn.createStatement();
            
            queryDeleteDoc = queryDeleteDoc.replace("#IDCUST", ""+custId+"");
            queryDeleteDoc = queryDeleteDoc.replace("#COM_CD", "'"+docTp+"'");
            
           // rs = statement.executeUpdate(queryUpdateDocStat);
          //  OraclePreparedStatement sql = ((OraclePreparedStatement) statement);
            System.out.println("RS : "+rs+" PS : "+queryDeleteDoc);
            
            rs = statement.executeUpdate(queryDeleteDoc);
            
            statement.close();
            conn.close();
             
           // return list;
        } catch (SQLException exception) {
            try {
                statement.close();
                conn.close();
               System.out.println("EXC "+exception.toString());
              
              //  return null;
            } catch (SQLException ex) {
                Logger.getLogger(TbCMCountryCityTMP.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("EXC "+ex.toString());
               // return null;
            }
        } 
        
        if(rs>0){
            response.setStatus("SUCCESS");
            response.setStatusDesc("DELETE Cust DOC SUCCESS");
        }else{
            response.setStatus("FAILED");
            response.setStatusDesc("DELETE Cust DOC FAILED");
       
        }
        
        return response;
        
    }
    
    
}
