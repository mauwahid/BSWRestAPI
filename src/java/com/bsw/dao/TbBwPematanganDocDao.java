/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bsw.dao;

import com.bsw.domain.TbBwCustDetil;
import com.bsw.domain.TbbwPematangan;
import com.bsw.domain.TbbwPematanganDetl;
import com.bsw.domain.TbbwPematanganDoc;
import com.bsw.domain.reqres.ResponseInterface;
import com.bsw.domain.reqres.SaveResponse;
import com.bsw.utils.Common;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Maulana Wahid Abdurrahman
 */
public class TbBwPematanganDocDao {

    Connection conn = null;
    String queryCreate = "INSERT INTO TBBW_PEMATANGAN_DOC(ID_PL, COM_CD, FILE_NM, PHY_FILE_PATH,\n" +
    "PHY_FILE_NM,FILE_EXT, FILE_SIZE, FILE_TP, REMARKS, DOCUMENT_NO, EXT_DMT, CREATED_BY, CREATED_TIME, FILE_SEQ)\n" +
    "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    String queryUpdate = "UPDATE TBBW_PEMATANGAN_DOC SET  FILE_NM=?, PHY_FILE_PATH=?,\n" +
    "PHY_FILE_NM=?,FILE_EXT=?, FILE_SIZE=?, FILE_TP=?, REMARKS=?, DOCUMENT_NO=?, EXT_DMT=?, LASTUPDATE_BY=?, LASUPDATED_TIME=?, FILE_SEQ=? \n" +
    " WHERE ID_PL=? AND COM_CD=? ";
    String queryDelete = "DELETE TBBW_PEMATANGAN_DOC WHERE ID_PL=? AND COM_CD=? ";
    String queryGetDoc = "Select * from TBBW_CUST_DETL where IDCUST = ? and COM_CD = ?";
    String queryGetDocPematangan = "Select * from TBBW_PEMATANGAN_DOC where ID_PL = ? AND COM_CD = ?";
    
    public static TbBwPematanganDocDao getInstance(){
        return new TbBwPematanganDocDao();
    }
    
    public ResponseInterface savePematanganDoc(TbbwPematanganDoc tbBwPemDoc){
        PreparedStatement statement = null;
        int res = 0;
        SaveResponse response = new SaveResponse();
        Date currDate = Common.getCurrentDate();
        conn = Common.getConnection();
        try {
           
            statement = conn.prepareStatement(queryCreate);
            statement.setString(1, tbBwPemDoc.getIdPL());
            statement.setString(2, tbBwPemDoc.getComCd());
            statement.setString(3, tbBwPemDoc.getFileNm());
            statement.setString(4, tbBwPemDoc.getPhyFilePath());
            statement.setString(5, tbBwPemDoc.getPhyFileNm());
            statement.setString(6, tbBwPemDoc.getFileExt());
            statement.setString(7, tbBwPemDoc.getFileSize());
            statement.setString(8, tbBwPemDoc.getFileTp());
            statement.setString(9, tbBwPemDoc.getRemarks());
            statement.setString(10, tbBwPemDoc.getDocumentNo());
            statement.setDate(11, tbBwPemDoc.getExtDmt());
            statement.setString(12, tbBwPemDoc.getCreatedBy());
            statement.setDate(13, currDate);
            System.out.println("FILE SEQ "+tbBwPemDoc.getFileSeq());
            statement.setString(14, tbBwPemDoc.getFileSeq());
            
            res = statement.executeUpdate();
            if (res>0) {
                response.setId(tbBwPemDoc.getIdPL());
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
    
    
    public ResponseInterface updatePematanganDoc(TbbwPematanganDoc tbBwPemDoc){
        PreparedStatement statement = null;
        int res = 0;
        SaveResponse response = new SaveResponse();
        Date currDate = Common.getCurrentDate();
        conn = Common.getConnection();
        try {
           
            statement = conn.prepareStatement(queryUpdate);
            statement.setString(1, tbBwPemDoc.getFileNm());
            statement.setString(2, tbBwPemDoc.getPhyFilePath());
            statement.setString(3, tbBwPemDoc.getPhyFileNm());
            statement.setString(4, tbBwPemDoc.getFileExt());
            statement.setString(5, tbBwPemDoc.getFileSize());
            statement.setString(6, tbBwPemDoc.getFileTp());
            statement.setString(7, tbBwPemDoc.getRemarks());
            statement.setString(8, tbBwPemDoc.getDocumentNo());
            statement.setDate(9, tbBwPemDoc.getExtDmt());
            statement.setString(10, tbBwPemDoc.getCreatedBy());
            statement.setDate(11, currDate);
            statement.setString(12, tbBwPemDoc.getFileSeq());
            statement.setString(13, tbBwPemDoc.getIdPL());
            statement.setString(14, tbBwPemDoc.getComCd());
            
            res = statement.executeUpdate();
            if (res>0) {
                response.setId(tbBwPemDoc.getIdPL());
                response.setStatus("SUCCESS");
                response.setStatusDesc("UPD SUCCESS");
            }else{
                response.setStatus("FAILED");
                response.setStatusDesc("UP FAILED");
                
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
    
    public ResponseInterface deletePematanganDoc(String idPL,String comCd){
        PreparedStatement statement = null;
        int res = 0;
        SaveResponse response = new SaveResponse();
      //  Date currDate = Common.getCurrentDate();
        conn = Common.getConnection();
        System.out.println("ID PL "+idPL+ " COmCd "+comCd);
        try {
           
                statement = conn.prepareStatement(queryDelete);
                statement.setString(1, idPL);
                statement.setString(2, comCd);
            
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
    
    public List<TbbwPematanganDoc> getDocPematangans(String idPL){
        PreparedStatement statement = null;
        SaveResponse response = new SaveResponse();
        List<TbbwPematanganDoc> list = new ArrayList<TbbwPematanganDoc>();
        ResultSet rs = null;
        TbbwPematanganDoc tbBw = null;
        try {
           
                statement = conn.prepareStatement(queryDelete);
                statement.setString(1, idPL);
                
                
            rs = statement.executeQuery();
            while(rs.next()) {
               //response.setId(tbBwPemDoc.getIdPL());
                tbBw.setComCd(rs.getString("COM_CD"));
                tbBw.setDocumentNo(rs.getString("DOCUMENT_NO"));
                tbBw.setExtDmt(rs.getDate("EXT_DMT"));
                tbBw.setFileNm(rs.getString("FILE_NM"));
                tbBw.setRemarks(rs.getString("REMARKS"));
                tbBw.setFileTp(rs.getString("FILE_TP"));
                tbBw.setThrDocNm(rs.getString("THR_DOC_NM"));
                
                list.add(tbBw);
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
        
        return list;
    }
    
    
    public ResponseInterface transferDoc(String idPL, String comCd, String idCust){
        
        PreparedStatement statement = null;
        ResultSet rs = null;
        SaveResponse response = new SaveResponse();
        TbBwCustDetil tbBwCustDetl = new TbBwCustDetil();
        conn = Common.getConnection();
        try {
           
            statement = conn.prepareStatement(queryGetDoc);
            statement.setString(1, idCust);
            statement.setString(2, comCd);
            
            rs = statement.executeQuery();
            while (rs.next()) {
                tbBwCustDetl.setComCd(rs.getString("COM_CD"));
                tbBwCustDetl.setFileNm(rs.getString("FILE_NM"));
                tbBwCustDetl.setPhyFileNm(rs.getString("PHY_FILE_NM"));
                tbBwCustDetl.setPhyFilePath(rs.getString("PHY_FILE_PATH"));
                tbBwCustDetl.setPhyFilePath(rs.getString("PHY_FILE_PATH"));
                tbBwCustDetl.setFileExt(rs.getString("FILE_EXT"));
                tbBwCustDetl.setFileSize(rs.getString("FILE_SIZE"));
                tbBwCustDetl.setFileTp(rs.getString("FILE_TP"));
                tbBwCustDetl.setCreatedBy(rs.getString("CREATEDBY"));
                tbBwCustDetl.setDateInsert(rs.getDate("DATE_INSERT"));
                tbBwCustDetl.setRemarks(rs.getString("REMARKS"));
                tbBwCustDetl.setDocumentNo(rs.getString("DOCUMENT_NO"));
                tbBwCustDetl.setFileSeqOrg(rs.getString("FILE_SEQ_ORG"));
                tbBwCustDetl.setFileSeq(rs.getString("FILE_SEQ"));
                
            }
            
            statement.close();
            conn.close();
            
            return duplicateDoc(idPL, tbBwCustDetl);
            
        //    System.out.println("AFTER ALL");
           // return list;
        } catch (SQLException exception) {
            try {
                statement.close();
                conn.close();
             System.out.println("EXCEPTION 11 "+exception.toString());
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
    
    public ResponseInterface duplicateDoc(String idPL, TbBwCustDetil tbBwCustDet){
        
        PreparedStatement statement = null;
        int res = 0;
        SaveResponse response = new SaveResponse();
        Date currDate = Common.getCurrentDate();
        conn = Common.getConnection();
        try {
           
            statement = conn.prepareStatement(queryCreate);
            statement.setString(1, idPL);
            statement.setString(2, tbBwCustDet.getComCd());
            statement.setString(3, tbBwCustDet.getFileNm());
            statement.setString(4, tbBwCustDet.getPhyFilePath());
            statement.setString(5, tbBwCustDet.getPhyFileNm());
            statement.setString(6, tbBwCustDet.getFileExt());
            statement.setString(7, tbBwCustDet.getFileSize());
            statement.setString(8, tbBwCustDet.getFileTp());
            statement.setString(9, tbBwCustDet.getRemarks());
            statement.setString(10, tbBwCustDet.getDocumentNo());
            try {
                statement.setDate(11, Common.convertToDate(tbBwCustDet.getExtDmt()));
            } catch (Exception ex) {
                statement.setDate(11, null);
         //       statement.setNull(11,SQL);
            }
            statement.setString(12, tbBwCustDet.getCreatedBy());
            statement.setDate(13, currDate);
            statement.setString(14, tbBwCustDet.getFileSeq());
            res = statement.executeUpdate();
            if (res>0) {
                response.setId(idPL);
                response.setStatus("SUCCESS");
                response.setStatusDesc("DUPLICATE SUCCESS");
            }else{
                response.setStatus("FAILED");
                response.setStatusDesc("DUPLICATE FAILED");
                
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
             //   Logger.getLogger(TbCMCountryCityTMP.class.getName()).log(Level.SEVERE, null, ex);
            //    response.setUserStatus("NOT FOUND");
             System.out.println("EXCEPTION 2");
                response.setStatus("FAILED");
                response.setStatus(exception.getMessage());
              // return null;
            }
        } 
        
        return response;
        
       // return 1;
    }
    
    
    
    
}
