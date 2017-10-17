/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bsw.dao;

import com.bsw.domain.TbCMCountryCityTMP;
import com.bsw.domain.TbbwPematanganDetl;
import com.bsw.domain.reqres.ResponseInterface;
import com.bsw.domain.reqres.SaveResponse;
import com.bsw.utils.Common;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Maulana Wahid Abdurrahman
 */
public class TbBwPematanganDetlDao {
    private Connection conn;
    private String queryCreatePematanganDet  = "INSERT INTO TBBW_PEMATANGAN_DETL\n" +
    "(ID_PL, LICNS_PL_TYPE, LICNS_PL_SEQ, LICNS_PL_NO, CREATED_BY, CREATED_TIME, FILE_NM, PHY_FILE_PATH, PY_FILE_NM, FILE_EXT,\n" +
    "FILE_SIZE, ID_DETL_PL, ADDR_CD, ADDR_DETL, LICNS_VOL, LICNS_VOL_TP, PL_SIZE, PL_ONR)\n" +
    "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private String queryUpdate  = "UPDATE TBBW_PEMATANGAN_DETL\n" +
    "SET  LICNS_PL_SEQ=?, LICNS_PL_NO=?, LASUPDATED_BY=?, LASTUPDATED_TIME=?, FILE_NM=?, PHY_FILE_PATH=?, PY_FILE_NM=?, FILE_EXT=?,\n" +
    "FILE_SIZE=?, ID_DETL_PL=?, ADDR_CD=?, ADDR_DETL=?, LICNS_VOL=?, LICNS_VOL_TP=?, PL_SIZE=?, PL_ONR=?" +
    " WHERE ID_PL=? and LICNS_PL_TYPE=?";
    private String queryDelete  = "DELETE TBBW_PEMATANGAN_DETL WHERE  ID_PL=? and LICNS_PL_TYPE=?";
    private String queryNextID = "SELECT MAX(ID_DETL_PL) + 1 as NEXTID FROM TBBW_PEMATANGAN_DETL WHERE ROWNUM =1";
    
    
    public static TbBwPematanganDetlDao getInstance(){
       return new TbBwPematanganDetlDao();
   }
    
    
    public TbBwPematanganDetlDao(){
      //  this.conn = conn;
    }
    
    public ResponseInterface savePematanganDet(TbbwPematanganDetl tbBwPemDet){
        PreparedStatement statement = null;
        int res = 0;
        SaveResponse response = new SaveResponse();
        Date currDate = Common.getCurrentDate();
        conn = Common.getConnection();
        String nextId = getNextID();
        try {
           
            statement = conn.prepareStatement(queryCreatePematanganDet);
            statement.setString(1, tbBwPemDet.getIdPl());
            statement.setString(2, tbBwPemDet.getLicnsPlType());
            statement.setString(3, tbBwPemDet.getLicnsPlSeq());
            statement.setString(4, tbBwPemDet.getLicnsPlNo());
            statement.setString(5, tbBwPemDet.getCreatedBy());
            statement.setDate(6, currDate);
            statement.setString(7, tbBwPemDet.getFileNm());
            statement.setString(8, tbBwPemDet.getPhyFilePath());
            statement.setString(9, tbBwPemDet.getPyFileNm());
            statement.setString(10, tbBwPemDet.getFileExt());
            statement.setString(11, tbBwPemDet.getFileSize());
            statement.setString(12, nextId);
            statement.setString(13, tbBwPemDet.getAddrCd());
            statement.setString(14, tbBwPemDet.getAddrDetl());
            statement.setString(15, tbBwPemDet.getLicnsVol());
            statement.setString(16, tbBwPemDet.getLicnsVolTp());
            statement.setString(17, tbBwPemDet.getPlSize());
            statement.setString(18, tbBwPemDet.getPlOnr());
            
            res = statement.executeUpdate();
            if (res>0) {
                response.setId(tbBwPemDet.getIdPl());
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
    
    public ResponseInterface updPematanganDet(TbbwPematanganDetl tbBwPemDet){
        PreparedStatement statement = null;
        int res = 0;
        SaveResponse response = new SaveResponse();
        Date currDate = Common.getCurrentDate();
        conn = Common.getConnection();
        try {
           
            statement = conn.prepareStatement(queryCreatePematanganDet);
            statement.setString(1, tbBwPemDet.getLicnsPlSeq());
            statement.setString(2, tbBwPemDet.getLicnsPlNo());
            statement.setString(3, tbBwPemDet.getCreatedBy());
            statement.setDate(4, currDate);
            statement.setString(5, tbBwPemDet.getFileNm());
            statement.setString(6, tbBwPemDet.getPhyFilePath());
            statement.setString(7, tbBwPemDet.getPyFileNm());
            statement.setString(8, tbBwPemDet.getFileExt());
            statement.setString(9, tbBwPemDet.getFileSize());
            statement.setString(10, tbBwPemDet.getIdDetlPl());
            statement.setString(11, tbBwPemDet.getAddrCd());
            statement.setString(12, tbBwPemDet.getAddrDetl());
            statement.setString(13, tbBwPemDet.getLicnsVol());
            statement.setString(14, tbBwPemDet.getLicnsVolTp());
            statement.setString(15, tbBwPemDet.getPlSize());
            statement.setString(16, tbBwPemDet.getPlOnr());
             statement.setString(17, tbBwPemDet.getIdPl());
            statement.setString(18, tbBwPemDet.getLicnsPlType());
            
            res = statement.executeUpdate();
            if (res>0) {
                response.setId(tbBwPemDet.getIdPl());
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
    
    public ResponseInterface deletePematanganDetl(String idPL, String licnsPlType){
        PreparedStatement statement = null;
        int res = 0;
        SaveResponse response = new SaveResponse();
        conn = Common.getConnection();
        try {
           
                statement = conn.prepareStatement(queryDelete);
             statement.setString(1, idPL);
            statement.setString(2, licnsPlType);
            
            res = statement.executeUpdate();
            if (res>0) {
               //response.setId(tbBwPemDoc.getIdPL());
                response.setStatus("SUCCESS");
                response.setStatusDesc("DELETE SUCCESS");
            }else{
                response.setStatus("FAILED");
                response.setStatusDesc("DELETE FAILED");
                
            }
            statement.close();
            conn.close();
            
            System.out.println("AFTER ALL");
           // return list;
        } catch (SQLException exception) {
            try {
                statement.close();
                conn.close();
             System.out.println("EXCEPTION ");
            //    response.setUserStatus("NOT FOUND");
                response.setStatus("FAILED");
                response.setStatusDesc(exception.getMessage());
              //  return null;
            } catch (SQLException ex) {
             //   Logger.getLogger(TbCMCountryCityTMP.class.getName()).log(Level.SEVERE, null, ex);
            //    response.setUserStatus("NOT FOUND");
             System.out.println("EXCEPTION 2");
                response.setStatus("FAILED");
                response.setStatus(exception.getMessage());
              // return null;
            }
        } 
        
        return response;
    }
    
    
    private String getNextID(){
        String id = "0";
        
        Statement statement = null;
        ResultSet rs = null;
        //conn = 
    //    List<TbBW2Status> list = new ArrayList<TbBW2Status>();
        try {
            statement = conn.createStatement();
            rs = statement.executeQuery(queryNextID);
            while (rs.next()) {
                System.out.println("NEXT ID DETECTED");
                id = rs.getString("NEXTID");
                System.out.println("ID : "+id);
            }
            statement.close();
          //  conn.close();
          
        } catch (SQLException exception) {
            try {
                statement.close();
           //     conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(TbComTMPDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        
        return id;
        
    }

}
