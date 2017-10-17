/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bsw.dao;

import com.bsw.domain.TbBWIPHDetl;
import com.bsw.domain.TbCMCountryCityTMP;
import com.bsw.domain.reqres.ResponseInterface;
import com.bsw.domain.reqres.SaveResponse;
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
public class TbBwIPHDetlTempDao {

    private Connection conn;
    private String queryCreateIPHDet  = "INSERT INTO TBBW_IPH_DETL_TEMP " +
            "(ID_IPH, FILE_SEQ, COM_CD, FILE_NM," +
            "PHY_FILE_NM, FILE_EXT, FILE_SIZE, FILE_TP," +
            "DOCUMENT_NO, EXT_DMT, CREATED_BY, CREATED_TIME," +
            "DOC_TP, PHY_FILE_PATH) " +
            "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    
     private String queryUpdateIPHDet  = "UPDATE TBBW_IPH_DETL_TEMP " +
            "SET FILE_SEQ = ?,  FILE_NM =?," +
            "PHY_FILE_NM =?, FILE_EXT =?, FILE_SIZE=?, FILE_TP=?," +
            "DOCUMENT_NO=?, EXT_DMT=?, CREATED_BY=?, CREATED_TIME=?," +
            "DOC_TP=?, PHY_FILE_PATH=? WHERE ID_IPH =? AND COM_CD =?";
    
   public static TbBwIPHDetlTempDao getInstance(Connection conn){
       return new TbBwIPHDetlTempDao(conn);
   }
    
    
    public TbBwIPHDetlTempDao(Connection conn){
        this.conn = conn;
    }
    
    public ResponseInterface saveIPHDet(TbBWIPHDetl tbBwIPHDet){
        PreparedStatement statement = null;
        int res = 0;
        SaveResponse response = new SaveResponse();
        try {
           
            statement = conn.prepareStatement(queryCreateIPHDet);
            statement.setString(1, tbBwIPHDet.getIdIPH());
            statement.setString(2, tbBwIPHDet.getFileSeq());
            statement.setString(3, tbBwIPHDet.getComCd());
            statement.setString(4, tbBwIPHDet.getFileNm());
            statement.setString(5, tbBwIPHDet.getPhyFileNm());
            statement.setString(6, tbBwIPHDet.getFileExt());
            statement.setString(7, tbBwIPHDet.getFileSize());
            statement.setString(8, tbBwIPHDet.getFileTp());
            statement.setString(9, tbBwIPHDet.getDocumentNo());
            try {
                statement.setDate(10, Common.convertToDate(tbBwIPHDet.getExtDmt()));
            } catch (Exception ex) {
                Logger.getLogger(TbBwIPHDetlTempDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            statement.setString(11, tbBwIPHDet.getCreatedBy());
            statement.setDate(12, Common.getCurrentDate());
            statement.setString(13, tbBwIPHDet.getDocTp());
            statement.setString(14, tbBwIPHDet.getPhyFilePath());
            
            res = statement.executeUpdate();
            if (res>0) {
                response.setId(tbBwIPHDet.getIdIPH());
                response.setStatus("SUCCESS");
                response.setStatusDesc("SAVE SUCCESS");
            }else{
                response.setStatus("FAILED");
                response.setStatusDesc("SAVE FAILED");
                
            }
            statement.close();
            conn.close();
            
            System.out.println("AFTER ALL");
           // return list;
        } catch (SQLException exception) {
            try {
                statement.close();
                conn.close();
             System.out.println("EXCEPTION 1");
            //    response.setUserStatus("NOT FOUND");
                response.setStatus("FAILED");
                response.setStatusDesc(exception.getMessage());
              //  return null;
            } catch (SQLException ex) {
                Logger.getLogger(TbCMCountryCityTMP.class.getName()).log(Level.SEVERE, null, ex);
            //    response.setUserStatus("NOT FOUND");
             System.out.println("EXCEPTION 2");
                response.setStatus("FAILED");
                response.setStatus(exception.getMessage());
              // return null;
            }
        } 
        
        return response;
    }

     public ResponseInterface updateIPHDet(TbBWIPHDetl tbBwIPHDet){
        PreparedStatement statement = null;
        int res = 0;
        SaveResponse response = new SaveResponse();
        try {
           
            statement = conn.prepareStatement(queryUpdateIPHDet);
            statement.setString(1, tbBwIPHDet.getFileSeq());
            statement.setString(2, tbBwIPHDet.getFileNm());
            statement.setString(3, tbBwIPHDet.getPhyFileNm());
            statement.setString(4, tbBwIPHDet.getFileExt());
            statement.setString(5, tbBwIPHDet.getFileSize());
            statement.setString(6, tbBwIPHDet.getFileTp());
            statement.setString(7, tbBwIPHDet.getDocumentNo());
            try {
                statement.setDate(8, Common.convertToDate(tbBwIPHDet.getExtDmt()));
            } catch (Exception ex) {
                Logger.getLogger(TbBwIPHDetlTempDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            statement.setString(9, tbBwIPHDet.getCreatedBy());
            statement.setDate(10, Common.getCurrentDate());
            statement.setString(11, tbBwIPHDet.getDocTp());
            statement.setString(12, tbBwIPHDet.getPhyFilePath());
            statement.setString(13, tbBwIPHDet.getIdIPH());
            statement.setString(14, tbBwIPHDet.getComCd());
            
            res = statement.executeUpdate();
            if (res>0) {
                response.setId(tbBwIPHDet.getIdIPH());
                response.setStatus("SUCCESS");
                response.setStatusDesc("UPDATE SUCCESS");
            }else{
                response.setStatus("FAILED");
                response.setStatusDesc("UPDATE FAILED");
                
            }
            statement.close();
            conn.close();
            
            System.out.println("AFTER ALL");
           // return list;
        } catch (SQLException exception) {
            try {
                statement.close();
                conn.close();
             System.out.println("EXCEPTION 1");
            //    response.setUserStatus("NOT FOUND");
                response.setStatus("FAILED");
                response.setStatusDesc(exception.getMessage());
              //  return null;
            } catch (SQLException ex) {
                Logger.getLogger(TbCMCountryCityTMP.class.getName()).log(Level.SEVERE, null, ex);
            //    response.setUserStatus("NOT FOUND");
             System.out.println("EXCEPTION 2");
                response.setStatus("FAILED");
                response.setStatus(exception.getMessage());
              // return null;
            }
        } 
        
        return response;
    }

}
