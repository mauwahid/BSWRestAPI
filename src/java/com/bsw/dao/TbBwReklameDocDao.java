/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bsw.dao;

import com.bsw.domain.reqres.StatusResponse;
import com.bsw.domain.TbBwReklame;
import com.bsw.domain.TbBwReklameDoc;
import com.bsw.domain.TbCMCountryCityTMP;
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
public class TbBwReklameDocDao {

    private Connection conn;
    private String queryAdd = "INSERT INTO TBBW_REKLAME_DOC " +
        "(ID_IR, FILE_SEQ, COM_CD, FILE_NM, PHY_FILE_PATH, PHY_FILE_NM, FILE_EXT, FILE_SIZE, " +
        "FILE_TP, REMARKS, DOCUMENT_NO, EXT_DMT, CREATED_BY) " +
        " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private String queryUpd = "UPDATE TBBW_REKLAME_DOC " +
        "SET FILE_SEQ=?,FILE_NM=?,PHY_FILE_PATH=?,PHY_FILE_NM=?,FILE_EXT=?,FILE_SIZE=?, " +
        "FILE_TP=?,REMARKS=?,DOCUMENT_NO=?,EXT_DMT=? " +
        " where ID_IR = ? AND COM_CD=?";
    private String queryDelete = "DELETE TBBW_REKLAME_DOC " +
        "WHERE ID_IR = ? AND COM_CD=?";
    private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(Common.class.getName());
   
   
    
    public TbBwReklameDocDao(Connection conn){
        this.conn = conn;
    }
    
    public StatusResponse saveReklameDoc(TbBwReklameDoc tbBwReklameDoc){
        PreparedStatement statement = null;
        System.out.println("FILE SEQ "+tbBwReklameDoc.getFileSeq());
            
        StatusResponse response = new StatusResponse();
        int rs = 0;
        try {
           
            statement = conn.prepareStatement(queryAdd);
            statement.setString(1, tbBwReklameDoc.getIdDR());
            statement.setInt(2, tbBwReklameDoc.getFileSeq());
            statement.setString(3, tbBwReklameDoc.getComCd());
            statement.setString(4, tbBwReklameDoc.getFileNm());
            statement.setString(5, tbBwReklameDoc.getPhyFilePath());
            statement.setString(6, tbBwReklameDoc.getPhyFileNm());
            statement.setString(7, tbBwReklameDoc.getFileExt());
            statement.setString(8, tbBwReklameDoc.getFileSize());
            statement.setString(9, tbBwReklameDoc.getFileTp());
            statement.setString(10, tbBwReklameDoc.getRemarks());
            statement.setString(11, tbBwReklameDoc.getDocumentNo());
            statement.setDate(12, tbBwReklameDoc.getExtDmt());
           statement.setString(13, tbBwReklameDoc.getCreatedBy());
            
            rs = statement.executeUpdate();
            
            statement.close();
            conn.close();
            logger.info("FINISH SAVE, status "+rs);
            
            
             
           // return list;
        } catch (SQLException exception) {
            try {
                
                logger.error(logger.getName()+" : "+exception.toString());
                statement.close();
                conn.close();
             
              //  return null;
            } catch (SQLException ex) {
                logger.error(logger.getName()+" : "+ex.toString());
               // return null;
            }
        } 
        
        if(rs>0){
            response.setStatus("SUCCESS");
            response.setStatusDesc("ADD REKLAME DOC SUCCESS");
        }else{
            response.setStatus("FAILED");
            response.setStatusDesc("ADD REKLAME DOC FAILED");
       
        }
        
        return response;
        
    }
    
    public StatusResponse updateReklameDoc(TbBwReklameDoc tbBwReklameDoc){
        PreparedStatement statement = null;
        conn = Common.getConnection();
        StatusResponse response = new StatusResponse();
        int rs = 0;
        try {
           
            statement = conn.prepareStatement(queryUpd);
           // statement.setString(1, tbBwReklameDoc.getIdDR());
            statement.setInt(1, tbBwReklameDoc.getFileSeq());
            statement.setString(2, tbBwReklameDoc.getFileNm());
            statement.setString(3, tbBwReklameDoc.getPhyFilePath());
            statement.setString(4, tbBwReklameDoc.getPhyFileNm());
            statement.setString(5, tbBwReklameDoc.getFileExt());
            statement.setString(6, tbBwReklameDoc.getFileSize());
            statement.setString(7, tbBwReklameDoc.getFileTp());
            statement.setString(8, tbBwReklameDoc.getRemarks());
            statement.setString(9, tbBwReklameDoc.getDocumentNo());
            statement.setDate(10, tbBwReklameDoc.getExtDmt());
            statement.setString(11, tbBwReklameDoc.getIdDR());
            statement.setString(12, tbBwReklameDoc.getComCd());
            
   //         statement.setDate(13, tbBwReklameDoc.getExtDmt());
            
            rs = statement.executeUpdate();
            
            statement.close();
            conn.close();
            logger.info("FINISH SAVE, status "+rs);
            
            
             
           // return list;
        } catch (SQLException exception) {
            try {
                
                logger.error(logger.getName()+" : "+exception.toString());
                statement.close();
                conn.close();
             
              //  return null;
            } catch (SQLException ex) {
                logger.error(logger.getName()+" : "+ex.toString());
               // return null;
            }
        } 
        
        if(rs>0){
            response.setStatus("SUCCESS");
            response.setStatusDesc("ADD REKLAME DOC SUCCESS");
        }else{
            response.setStatus("FAILED");
            response.setStatusDesc("ADD REKLAME DOC FAILED");
       
        }
        
        return response;
        
    }
    
     public StatusResponse deleteDoc(String idIR, String comCd){
        PreparedStatement statement = null;
        
        StatusResponse response = new StatusResponse();
        int rs = 0;
        try {
           
            statement = conn.prepareStatement(queryDelete);
            statement.setString(1, idIR);
            statement.setString(2, comCd);
            
            rs = statement.executeUpdate();
            
            statement.close();
            conn.close();
            logger.info("FINISH DELETE, status "+rs);
            
            
             
           // return list;
        } catch (SQLException exception) {
            try {
                
                logger.error(logger.getName()+" : "+exception.toString());
                statement.close();
                conn.close();
             
              //  return null;
            } catch (SQLException ex) {
                logger.error(logger.getName()+" : "+ex.toString());
               // return null;
            }
        } 
        
        if(rs>0){
            response.setStatus("SUCCESS");
            response.setStatusDesc("DELETE REKLAME DOC SUCCESS");
        }else{
            response.setStatus("FAILED");
            response.setStatusDesc("DELETE REKLAME DOC FAILED");
       
        }
        
        return response;
        
    }
   
    
}
