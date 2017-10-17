/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bsw.dao;

import com.bsw.domain.MonitoringPematangan;
import com.bsw.domain.TbCMCountryCityTMP;
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
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Maulana Wahid Abdurrahman
 */
public class TbBwPematanganDao {
    
    private Connection conn;
    private String queryCreatePematangan  = "INSERT INTO TBBW_PEMATANGAN\n" +
        "(ID_PL, LICN_APLY_LTTR_NO, LICN_APLY_DMT, LICN_APLT_ID, LICN_APLY_TP, \n" +
        "EXECUTER, LICN_APLY_LTTR_DMT, STATUS_BSW, CREATED_BY, CREATED_TIME, HAS_VIEW_YN, HAS_VIEW_TIME,\n" +
        "HAS_VIEW_ADM_YN)\n" +
        "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private String queryUpdate  = "UPDATE TBBW_PEMATANGAN\n" +
        "SET LICN_APLY_LTTR_NO=?, LICN_APLY_DMT=?, LICN_APLT_ID=?, LICN_APLY_TP=?, \n" +
        "EXECUTER=?, LICN_APLY_LTTR_DMT=?, LASTUPDATED_BY=?, LASTUPDATED_TIME=? "+
        "WHERE ID_PL=?";
    
     private String queryUpdateStatus  = "UPDATE TBBW_PEMATANGAN\n" +
        "SET STATUS_BSW = ? WHERE ID_PL=?";
     private String queryDelete  = "DELETE TBBW_PEMATANGAN WHERE ID_PL=?";
    private String queryNextID = "SELECT MAX(ID_PL) + 1 as NEXTID FROM TBBW_PEMATANGAN WHERE ROWNUM =1";
    private String qMonitorPematangan = "select id_pl \"No_BSW\",licn_aplt_id \"Nama_Pemohon\",status_bsw \"Status\",\n" +
        "US_BW.FUN_CODE_NAME(licn_aply_tp) \"Jenis_Permohonan\",licn_aply_lttr_no \"No_Surat_Permohonan\",\n" +
        " licn_mgmt_no \"No_Ijin_Pematangan\",to_char(licn_aply_dmt,'dd/mm/yyyy') \"Tgl_Surat_Masuk\"\n" +
        " from US_BW.TBBW_PEMATANGAN\n" +
        " where id_pl =?\n" +
        "  and licn_aplt_id =?\n" +
        "  and licn_aply_tp =?\n" +
        "  and licn_aply_lttr_no =?";
    private String qMonitorPematangan2 = "select id_pl \"No_BSW\",licn_aplt_id \"Nama_Pemohon\",status_bsw \"Status\",\n" +
        "US_BW.FUN_CODE_NAME(licn_aply_tp) \"Jenis_Permohonan\",licn_aply_lttr_no \"No_Surat_Permohonan\",\n" +
        " licn_mgmt_no \"No_Ijin_Pematangan\",to_char(licn_aply_dmt,'dd/mm/yyyy') \"Tgl_Surat_Masuk\"\n" +
        " from US_BW.TBBW_PEMATANGAN\n" +
        " where ";
    
    private String qMonitorPematangan2Sort = "select id_pl \"No_BSW\",licn_aplt_id \"Nama_Pemohon\",status_bsw \"Status\",\n" +
        "US_BW.FUN_CODE_NAME(licn_aply_tp) \"Jenis_Permohonan\",licn_aply_lttr_no \"No_Surat_Permohonan\",\n" +
        " licn_mgmt_no \"No_Ijin_Pematangan\",to_char(licn_aply_dmt,'dd/mm/yyyy') \"Tgl_Surat_Masuk\"\n" +
        " from US_BW.TBBW_PEMATANGAN\n" +
        " where (LICN_APLT_ID =?\n" +
        "  or STATUS_BSW =?\n" +
        "  or EVAL_RSLT =?\n" +
        "  or LICN_APLY_TP =?  or LICN_APLY_LTTR_NO =?  or LICN_MGMT_NO =? "+
        "  or KET_BSW = ? or LICN_APLY_DMT = ? or LICN_APLY_LTTR_DMT =?) AND CREATED_BY=? ORDER BY ";
    
    
    private String qMonitorPematanganCreator = "select id_pl \"No_BSW\",licn_aplt_id \"Nama_Pemohon\",status_bsw \"Status\",\n" +
        "US_BW.FUN_CODE_NAME(licn_aply_tp) \"Jenis_Permohonan\",licn_aply_lttr_no \"No_Surat_Permohonan\",\n" +
        " licn_mgmt_no \"No_Ijin_Pematangan\",to_char(licn_aply_dmt,'dd/mm/yyyy') \"Tgl_Surat_Masuk\"\n" +
        " from US_BW.TBBW_PEMATANGAN\n" +
        " where CREATED_BY =? ORDER BY CREATED_TIME DESC";
    
    private String qMonitorPematanganCreatorSort = "select id_pl \"No_BSW\",licn_aplt_id \"Nama_Pemohon\",status_bsw \"Status\",\n" +
        "US_BW.FUN_CODE_NAME(licn_aply_tp) \"Jenis_Permohonan\",licn_aply_lttr_no \"No_Surat_Permohonan\",\n" +
        " licn_mgmt_no \"No_Ijin_Pematangan\",to_char(licn_aply_dmt,'dd/mm/yyyy') \"Tgl_Surat_Masuk\"\n" +
        " from US_BW.TBBW_PEMATANGAN\n" +
        " where CREATED_BY =? ORDER BY ";
    
    private String qMonitorPematanganSearch = "select id_pl \"No_BSW\",licn_aplt_id \"Nama_Pemohon\",status_bsw \"Status\",\n" +
        "US_BW.FUN_CODE_NAME(licn_aply_tp) \"Jenis_Permohonan\",licn_aply_lttr_no \"No_Surat_Permohonan\",\n" +
        " licn_mgmt_no \"No_Ijin_Pematangan\",to_char(licn_aply_dmt,'dd/mm/yyyy') \"Tgl_Surat_Masuk\"\n" +
        " from US_BW.TBBW_PEMATANGAN\n" +
        " where CREATED_BY =? "
            + "OR LICN_APLY_LTTR_NO =? OR LICN_APLT_ID=? OR LICN_APLY_DMT =? OR STATUS_BSW =? ";
    
    String queryGetPematangan = "Select * from TBBW_Pematangan where ID_PL = ?";
  //  String queryGetPematanganSearch = "Select * from TBBW_Pematangan where LICN_APLY_LTTR_NO, LICN_APLT_ID, LICN_APLY_DMT, STATUS_BSW ";
    
    String queryGetPematanganDetl = "select a.ID_PL, a.LICNS_PL_TYPE, (select distinct CD_NM from US_REF.TBCM_COM where COM_CD = a.LICNS_PL_TYPE) as tipePematangan,\n" +
        "a.LICNS_PL_NO, a.ADDR_DETL, a.ID_DETL_PL, a.LICNS_VOL_TP,\n" +
        "(select distinct CD_NM from US_REF.TBCM_COM where COM_CD =  a.LICNS_VOL_TP) as tipeLokasi, a.PL_SIZE, a.PL_ONR, a.LICNS_VOL,\n" +
        "b.WIL_NM, b.SUB_WIL_NM, a.FILE_NM from TBBW_PEMATANGAN_DETL a left join\n" +
        "TBLD_ADDR_CD b on a.ADDR_CD = b.ADDR_CD where a.ID_PL = ?";
    String queryGetPematanganDoc = "select a.id_pl, a.com_cd, a.file_nm, a.document_no, a.file_size, a.ext_dmt, a.created_time, a.remarks, a.FILE_SEQ, \n" +
        "b.CD_NM from\n" +
        "TBBW_PEMATANGAN_DOC a left join US_REF.TBCM_COM b\n" +
        "on a.COM_CD = b.COM_CD\n" +
        "where a.ID_PL = ?";
  
    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
         
    
    
    public static TbBwPematanganDao getInstance(){
       return new TbBwPematanganDao();
   }
    
    
    public TbBwPematanganDao(){
      //  this.conn = conn;
    }
    
    public TbbwPematangan getPematangan(String idPL){
        
        PreparedStatement stat = null;
        ResultSet rs = null;
        TbbwPematangan tbbwPematangan = new TbbwPematangan();
        conn = Common.getConnection();

            try {
            
            stat = conn.prepareStatement(queryGetPematangan);
            stat.setString(1, idPL);
            
            rs = stat.executeQuery();
            
                while(rs.next()){
                    tbbwPematangan.setIdPl(rs.getString("ID_PL"));
                    tbbwPematangan.setLicnApltId(rs.getString("LICN_APLT_ID"));
                    tbbwPematangan.setLicnAplyLttrNo(rs.getString("LICN_APLY_LTTR_NO"));
                 //   tbbwPematangan.set(rs.getString("LICN_APLY_LTTR_NO"));

                    try{
                        tbbwPematangan.setLicnAplyDmt(format.format(rs.getDate("LICN_APLY_DMT")));
                        
                    }catch(Exception ex){
                        
                    }
                    tbbwPematangan.setCreatedBy(rs.getString("CREATED_BY"));
                    try{
                        tbbwPematangan.setCreatedTime(format.format(rs.getDate("CREATED_TIME")));
                    }catch(Exception ex){
                        
                    }
                    tbbwPematangan.setExecuter(rs.getString("EXECUTER"));
                    tbbwPematangan.setStatusBsw(rs.getString("STATUS_BSW"));
                    
                    try{
                        tbbwPematangan.setLicnAplyLttrDmt(format.format(rs.getDate("LICN_APLY_LTTR_DMT")));
                    }catch(Exception ex){
                        
                    }
                    tbbwPematangan.setPematanganDetls(getPematanganDetails(idPL));
                    tbbwPematangan.setPematanganDocs(getPematanganDocs(idPL));

                }
                stat.close();
                conn.close();
            } catch (SQLException ex) {
         //   Logger.getLogger(TbBwPematanganDao.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("ex "+ex.toString());
            }
            
            
            return tbbwPematangan;
    }
    
    public List<TbbwPematanganDetl> getPematanganDetails(String idPL){
        PreparedStatement stat = null;
        ResultSet rs = null;
        TbbwPematanganDetl tbbwPematanganDetl = null;
        conn = Common.getConnection();
        List<TbbwPematanganDetl> list = new ArrayList<TbbwPematanganDetl>();
            try {
            
            stat = conn.prepareStatement(queryGetPematanganDetl);
            stat.setString(1, idPL);
            
            rs = stat.executeQuery();
            
            while(rs.next()){
                tbbwPematanganDetl = new TbbwPematanganDetl();
                tbbwPematanganDetl.setIdPl(rs.getString("ID_PL"));
                tbbwPematanganDetl.setLicnsPlType(rs.getString("LICNS_PL_TYPE"));
                tbbwPematanganDetl.setLicnsPlType(rs.getString("TIPEPEMATANGAN"));
                tbbwPematanganDetl.setLicnsPlNo(rs.getString("LICNS_PL_NO"));
                tbbwPematanganDetl.setAddrDetl(rs.getString("ADDR_DETL"));
                tbbwPematanganDetl.setIdDetlPl(rs.getString("ID_DETL_PL"));
                tbbwPematanganDetl.setLicnsVolTp(rs.getString("LICNS_VOL_TP"));
                tbbwPematanganDetl.setPlSize(rs.getString("PL_SIZE"));
                tbbwPematanganDetl.setPlOnr(rs.getString("PL_ONR"));
                tbbwPematanganDetl.setLicnsVol(rs.getString("LICNS_VOL"));
                tbbwPematanganDetl.setAddrCd(rs.getString("WIL_NM") + " - " +rs.getString("SUB_WIL_NM"));
                tbbwPematanganDetl.setFileNm(rs.getString("FILE_NM"));
                list.add(tbbwPematanganDetl);
                
            }
                  stat.close();
          
            } catch (SQLException ex) {
         //   Logger.getLogger(TbBwPematanganDao.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("ex "+ex.getMessage());
            }
            return list;
    }
    
    public List<TbbwPematanganDoc> getPematanganDocs(String idPL){
        PreparedStatement stat = null;
        ResultSet rs = null;
        TbbwPematanganDoc tbbwPematanganDoc = null;
        List<TbbwPematanganDoc> list = new ArrayList<TbbwPematanganDoc>();
            try {
            
            conn = Common.getConnection();
            
            stat = conn.prepareStatement(queryGetPematanganDoc);
            stat.setString(1, idPL);
            
            rs = stat.executeQuery();
            
            while(rs.next()){
                tbbwPematanganDoc = new TbbwPematanganDoc();
                tbbwPematanganDoc.setIdPL(rs.getString("ID_PL"));
                tbbwPematanganDoc.setComCd(rs.getString("COM_CD"));
                tbbwPematanganDoc.setTitle(rs.getString("CD_NM"));
                tbbwPematanganDoc.setFileNm(rs.getString("FILE_NM"));
                tbbwPematanganDoc.setDocumentNo(rs.getString("DOCUMENT_NO"));
                tbbwPematanganDoc.setFileSize(rs.getString("FILE_SIZE"));
                tbbwPematanganDoc.setExtDmt(rs.getDate("EXT_DMT"));
                tbbwPematanganDoc.setCreatedTime(rs.getDate("CREATED_TIME"));
                tbbwPematanganDoc.setRemarks(rs.getString("REMARKS"));
                tbbwPematanganDoc.setFileSeq(rs.getString("FILE_SEQ"));
                
                list.add(tbbwPematanganDoc);
             }
            stat.close();
            } catch (SQLException ex) {
         //   Logger.getLogger(TbBwPematanganDao.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("ex "+ex.toString());
            }
            return list;
    }
    
    public ResponseInterface updPematangan(TbbwPematangan tbBwPematangan){
        PreparedStatement statement = null;
        int res = 0;
       // conn = Common.getConnection();
        String nextId = "";
        SaveResponse response = new SaveResponse();
        try {
           
            conn = Common.getConnection();
          //  nextId = getNextID();
            System.out.println("Start TO UPDATE");
            
            Date currDate = Common.getCurrentDate();
            
           // conn = Common.getConnection();
            statement = conn.prepareStatement(queryUpdate);
            statement.setString(1, tbBwPematangan.getLicnAplyLttrNo());
            try {
                statement.setDate(2, Common.convertToDate(tbBwPematangan.getLicnAplyDmt()));
            } catch (Exception ex) {
                statement.setDate(2, null);
            }
            statement.setString(3, tbBwPematangan.getLicnApltId());
            statement.setString(4, tbBwPematangan.getLicnAplyTp());
            statement.setString(5, tbBwPematangan.getExecuter());
            try {
                statement.setDate(6, Common.convertToDate(tbBwPematangan.getLicnAplyDmt()));
            } catch (Exception ex) {
                statement.setDate(6, null);
            }
          //  statement.setString(7, tbBwPematangan.getStatusBsw());
            statement.setString(7, tbBwPematangan.getCreatedBy());
            statement.setDate(8, currDate);
         //   statement.setString(10,"Y");
        //    statement.setDate(11, currDate);
        //    statement.setString(12, "N");
            statement.setString(9, tbBwPematangan.getIdPl());
            
            res = statement.executeUpdate();
            System.out.println("SETELAH EKSEKUSI");
            if (res>0) {
                response.setId(nextId);
                response.setStatus("SUCCESS");
                response.setStatusDesc("SAVE SUCCESS");
            }else{
                response.setStatus("FAILED");
                response.setStatusDesc("SAVE FAILED");
                
            }
           statement.close();
            conn.close();
             System.out.println("AFTER TO INSERT");
            
           // return list;
        } catch (SQLException exception) {
            try {
                statement.close();
                conn.close();
              System.out.println("EXC 1 "+exception.toString());
            
            //    response.setUserStatus("NOT FOUND");
                response.setStatus("FAILED");
                response.setStatusDesc(exception.getMessage());
              //  return null;
            } catch (Exception ex) {
                Logger.getLogger(TbCMCountryCityTMP.class.getName()).log(Level.SEVERE, null, ex);
            //    response.setUserStatus("NOT FOUND");
                System.out.println("EXC 2");
            response.setStatus("FAILED");
                response.setStatus(exception.getMessage());
              // return null;
            }
        } 
        
        return response;
    }
   
   
    public ResponseInterface updStatusPematangan(TbbwPematangan tbBwPematangan){
        PreparedStatement statement = null;
        int res = 0;
       // conn = Common.getConnection();
        String nextId = "";
        SaveResponse response = new SaveResponse();
        try {
           
            conn = Common.getConnection();
          //  nextId = getNextID();
            System.out.println("Start TO UPDATE");
            
            Date currDate = Common.getCurrentDate();
            
           // conn = Common.getConnection();
            statement = conn.prepareStatement(queryUpdateStatus);
           
            statement.setString(1, tbBwPematangan.getStatusBsw());
            statement.setString(2, tbBwPematangan.getIdPl());
            
            res = statement.executeUpdate();
            System.out.println("SETELAH EKSEKUSI");
            if (res>0) {
                response.setId(nextId);
                response.setStatus("SUCCESS");
                response.setStatusDesc("UPDATE SUCCESS");
            }else{
                response.setStatus("FAILED");
                response.setStatusDesc("UPDATE FAILED");
                
            }
           statement.close();
            conn.close();
             System.out.println("AFTER TO UPDATE");
            
           // return list;
        } catch (SQLException exception) {
            try {
                statement.close();
                conn.close();
              System.out.println("EXC 1 "+exception.toString());
            
            //    response.setUserStatus("NOT FOUND");
                response.setStatus("FAILED");
                response.setStatusDesc(exception.getMessage());
              //  return null;
            } catch (Exception ex) {
                Logger.getLogger(TbCMCountryCityTMP.class.getName()).log(Level.SEVERE, null, ex);
            //    response.setUserStatus("NOT FOUND");
                System.out.println("EXC 2");
            response.setStatus("FAILED");
                response.setStatus(exception.getMessage());
              // return null;
            }
        } 
        
        return response;
    }
   
   public ResponseInterface savePematangan(TbbwPematangan tbBwPematangan){
        PreparedStatement statement = null;
        int res = 0;
       // conn = Common.getConnection();
        String nextId = "";
        SaveResponse response = new SaveResponse();
        try {
           
            conn = Common.getConnection();
            nextId = getNextID();
            System.out.println("Start TO INSERT");
            
            Date currDate = Common.getCurrentDate();
            
           // conn = Common.getConnection();
            statement = conn.prepareStatement(queryCreatePematangan);
            statement.setString(1, nextId);
            statement.setString(2, tbBwPematangan.getLicnAplyLttrNo());
           
            try {
                statement.setDate(3, Common.convertToDate(tbBwPematangan.getLicnAplyDmt()));
            } catch (Exception ex) {
                statement.setDate(3, null);
            }

            statement.setString(4, tbBwPematangan.getLicnApltId());
            statement.setString(5, tbBwPematangan.getLicnAplyTp());
            statement.setString(6, tbBwPematangan.getExecuter());
            
            try {
                statement.setDate(7, Common.convertToDate(tbBwPematangan.getLicnAplyDmt()));
            } catch (Exception ex) {
                statement.setDate(7, null);
            }
            
            statement.setString(8, tbBwPematangan.getStatusBsw());
            statement.setString(9, tbBwPematangan.getCreatedBy());
            statement.setDate(10, currDate);
            statement.setString(11,"Y");
            statement.setDate(12, currDate);
            statement.setString(13, "N");
            
            res = statement.executeUpdate();
            System.out.println("SETELAH EKSEKUSI");
            if (res>0) {
                response.setId(nextId);
                response.setStatus("SUCCESS");
                response.setStatusDesc("SAVE SUCCESS");
            }else{
                response.setStatus("FAILED");
                response.setStatusDesc("SAVE FAILED");
                
            }
           statement.close();
            conn.close();
             System.out.println("AFTER TO INSERT");
            
           // return list;
        } catch (SQLException exception) {
            try {
                statement.close();
                conn.close();
              System.out.println("EXC 1 "+exception.toString());
            
            //    response.setUserStatus("NOT FOUND");
                response.setStatus("FAILED");
                response.setStatusDesc(exception.getMessage());
              //  return null;
            } catch (Exception ex) {
                Logger.getLogger(TbCMCountryCityTMP.class.getName()).log(Level.SEVERE, null, ex);
            //    response.setUserStatus("NOT FOUND");
                System.out.println("EXC 2");
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

    
    public List<MonitoringPematangan> getMonitoring(String idPL, String licnAplyId, String licnAplyTp,
             String licnAplyLttrNo) throws SQLException{
         
             List<MonitoringPematangan> monitors = new ArrayList<MonitoringPematangan>();
             PreparedStatement stat = null;
             MonitoringPematangan monitor = null;
             ResultSet rs = null;
             conn = Common.getConnection();
             stat = conn.prepareStatement(qMonitorPematangan);
             stat.setString(1,idPL);
             stat.setString(2, licnAplyId);
             stat.setString(3, licnAplyTp);
             stat.setString(4, licnAplyLttrNo);
             
             rs = stat.executeQuery();
             
             while(rs.next()){
                 monitor = new MonitoringPematangan();
                 monitor.setNoBsw(rs.getString("No_BSW"));
                 monitor.setNamaPemohon(rs.getString("Nama_Pemohon"));
                 monitor.setStatus(rs.getString("Status"));
                 monitor.setJenisPermohonan(rs.getString("Jenis_Permohonan"));
                 monitor.setNoSuratPermohonan(rs.getString("No_Surat_Permohonan"));
                 monitor.setNoIjinPematangan(rs.getString("No_Ijin_Pematangan"));
                 try{
                    monitor.setTglSuratMasuk(format.format(rs.getDate("Tgl_Surat_Masuk")));
                     
                 }catch(Exception ex){
                    monitor.setTglSuratMasuk(rs.getString("Tgl_Surat_Masuk"));
                     
                 }
                 monitors.add(monitor);
             }
             
             stat.close();
             conn.close();
             return monitors;
     }

    public List<MonitoringPematangan> getMonitoring(String creator,
           String licnApltID, String statusBSW, String evalRslt, String licnAplyTp,String licnAplyLttrNo,String licnMgmtNo,String ketBSW,String licnAplyDmt,String licnAplyLtrDmt) throws SQLException{
         
        System.out.println("createtor "+creator);
        System.out.println("licnApltID "+licnApltID);
        System.out.println("statusBSW "+statusBSW);
        System.out.println("evalRslt "+evalRslt);
        System.out.println("licnAplyTp "+licnAplyTp);
        System.out.println("licnAplyLttrNo "+licnAplyLttrNo);
        System.out.println("licnMgmtNo "+licnMgmtNo);
        System.out.println("ketBSW "+ketBSW);
        
            String cond = "CREATED_BY=?  AND (LICN_APLT_ID =?\n" +
        "  or STATUS_BSW =?\n" +
        "  or EVAL_RSLT =?\n" +
        "  or LICN_APLY_TP =?  or LICN_APLY_LTTR_NO =?  or LICN_MGMT_NO =? "+
        "  or KET_BSW = ? or LICN_APLY_DMT = ? or LICN_APLY_LTTR_DMT =?)";
            
            qMonitorPematangan2 = qMonitorPematangan2 + " CREATED_BY=? AND (";
            
            if(licnApltID !=null | statusBSW!=null | evalRslt !=null | licnAplyTp !=null |
                    licnAplyLttrNo!=null | licnMgmtNo!=null | ketBSW!=null){
                
                if(licnApltID!=null){
                    qMonitorPematangan2 = qMonitorPematangan2 + " LICN_APLT_ID = '"+licnApltID+"' or";
                }
                
                if(statusBSW!=null){
                     qMonitorPematangan2 = qMonitorPematangan2 + " STATUS_BSW = '"+statusBSW+"' or";
                }
                
                if(evalRslt!=null){
                      qMonitorPematangan2 = qMonitorPematangan2 + " EVAL_RSLT = '"+evalRslt+"' or";
                }
                
                if(licnAplyTp!=null){
                      qMonitorPematangan2 = qMonitorPematangan2 + " LICN_APLY_TP = '"+licnAplyTp+"' or";
                }
                
                if(licnAplyLttrNo!=null){
                      qMonitorPematangan2 = qMonitorPematangan2 + " LICN_APLY_LTTR_NO = '"+licnAplyLttrNo+"' or";
                }
                
                if(licnMgmtNo!=null){
                  qMonitorPematangan2 = qMonitorPematangan2 + " LICN_MGMT_NO = '"+licnMgmtNo+"' or";
                }
                
                if(ketBSW!=null){
                    qMonitorPematangan2 = qMonitorPematangan2 + " KET_BSW = '"+ketBSW+"'";
                }
            }
            
            qMonitorPematangan2 = qMonitorPematangan2 + ")";
            
            if(qMonitorPematangan2.contains("or)")){
                qMonitorPematangan2 = qMonitorPematangan2.replace("or)", ")");
            }
                    
             List<MonitoringPematangan> monitors = new ArrayList<MonitoringPematangan>();
             PreparedStatement stat = null;
             MonitoringPematangan monitor = null;
             ResultSet rs = null;
             conn = Common.getConnection();
             stat = conn.prepareStatement(qMonitorPematangan2);
             stat.setString(1, creator);
             /*
             stat.setString(2, licnApltID);
             stat.setString(3, statusBSW);
             stat.setString(4, evalRslt);
             stat.setString(5, licnAplyTp);
             stat.setString(6, licnAplyLttrNo);
             stat.setString(7, licnMgmtNo);
             stat.setString(8, ketBSW); */
        try {
            stat.setDate(9, Common.convertToDate(licnAplyDmt));
        } catch (Exception ex) {
            stat.setDate(9, null);
        }
            
        try {
            stat.setDate(10, Common.convertToDate(licnAplyLtrDmt));
        } catch (Exception ex) {
            stat.setDate(10, null);
        }
             
             rs = stat.executeQuery();
             
             while(rs.next()){
                 monitor = new MonitoringPematangan();
                 monitor.setNoBsw(rs.getString("No_BSW"));
                 monitor.setNamaPemohon(rs.getString("Nama_Pemohon"));
                 monitor.setStatus(rs.getString("Status"));
                 monitor.setJenisPermohonan(rs.getString("Jenis_Permohonan"));
                 monitor.setNoSuratPermohonan(rs.getString("No_Surat_Permohonan"));
                 monitor.setNoIjinPematangan(rs.getString("No_Ijin_Pematangan"));
                 try{
                    monitor.setTglSuratMasuk(format.format(rs.getDate("Tgl_Surat_Masuk")));
                     
                 }catch(Exception ex){
                    monitor.setTglSuratMasuk(rs.getString("Tgl_Surat_Masuk"));
                     
                 }
                 monitors.add(monitor);
             }
             
             stat.close();
             conn.close();
             return monitors;
     }


    public List<MonitoringPematangan> getMonitoringSort(String creator,
           String licnApltID, String statusBSW, String evalRslt, String licnAplyTp,
           String licnAplyLttrNo,String licnMgmtNo,String ketBSW,
           String licnAplyDmt,String licnAplyLtrDmt, int tipe, String ascDesc) throws SQLException{
         
           qMonitorPematangan2 = qMonitorPematangan2 + " CREATED_BY=? AND (";
            
            if(licnApltID !=null | statusBSW!=null | evalRslt !=null | licnAplyTp !=null |
                    licnAplyLttrNo!=null | licnMgmtNo!=null | ketBSW!=null){
                
                if(licnApltID!=null){
                    qMonitorPematangan2 = qMonitorPematangan2 + " LICN_APLT_ID = '"+licnApltID+"' or";
                }
                
                if(statusBSW!=null){
                     qMonitorPematangan2 = qMonitorPematangan2 + " STATUS_BSW = '"+statusBSW+"' or";
                }
                
                if(evalRslt!=null){
                      qMonitorPematangan2 = qMonitorPematangan2 + " EVAL_RSLT = '"+evalRslt+"' or";
                }
                
                if(licnAplyTp!=null){
                      qMonitorPematangan2 = qMonitorPematangan2 + " LICN_APLY_TP = '"+licnAplyTp+"' or";
                }
                
                if(licnAplyLttrNo!=null){
                      qMonitorPematangan2 = qMonitorPematangan2 + " LICN_APLY_LTTR_NO = '"+licnAplyLttrNo+"' or";
                }
                
                if(licnMgmtNo!=null){
                  qMonitorPematangan2 = qMonitorPematangan2 + " LICN_MGMT_NO = '"+licnMgmtNo+"' or";
                }
                
                if(ketBSW!=null){
                    qMonitorPematangan2 = qMonitorPematangan2 + " KET_BSW = '"+ketBSW+"'";
                }
            }
            
            qMonitorPematangan2 = qMonitorPematangan2 + ")";
            
            if(qMonitorPematangan2.contains("or)")){
                qMonitorPematangan2 = qMonitorPematangan2.replace("or)", ")");
            }
            
            qMonitorPematangan2 = qMonitorPematangan2 + " ORDER BY "+ getOrder(tipe, ascDesc);
           // qMonitorPematangan2Sort = qMonitorPematangan2Sort + getOrder(tipe, ascDesc);
            List<MonitoringPematangan> monitors = new ArrayList<MonitoringPematangan>();
            PreparedStatement stat = null;
            MonitoringPematangan monitor = null;
            ResultSet rs = null;
            conn = Common.getConnection();
            stat = conn.prepareStatement(qMonitorPematangan2);
            stat.setString(1, creator);
            stat.setString(2, licnApltID);
            stat.setString(3, statusBSW);
            stat.setString(4, evalRslt);
            stat.setString(5, licnAplyTp);
            stat.setString(6, licnAplyLttrNo);
            stat.setString(7, licnMgmtNo);
            stat.setString(8, ketBSW);
        
       try {
            stat.setDate(9, Common.convertToDate(licnAplyDmt));
        } catch (Exception ex) {
            stat.setDate(9, null);
        }
            
        try {
            stat.setDate(10, Common.convertToDate(licnAplyLtrDmt));
        } catch (Exception ex) {
            stat.setDate(10, null);
        }
             
             rs = stat.executeQuery();
             
             while(rs.next()){
                 monitor = new MonitoringPematangan();
                 monitor.setNoBsw(rs.getString("No_BSW"));
                 monitor.setNamaPemohon(rs.getString("Nama_Pemohon"));
                 monitor.setStatus(rs.getString("Status"));
                 monitor.setJenisPermohonan(rs.getString("Jenis_Permohonan"));
                 monitor.setNoSuratPermohonan(rs.getString("No_Surat_Permohonan"));
                 monitor.setNoIjinPematangan(rs.getString("No_Ijin_Pematangan"));
                 try{
                    monitor.setTglSuratMasuk(format.format(rs.getDate("Tgl_Surat_Masuk")));
                     
                 }catch(Exception ex){
                    monitor.setTglSuratMasuk(rs.getString("Tgl_Surat_Masuk"));
                     
                 }
                 monitors.add(monitor);
             }
             
             stat.close();
             conn.close();
             return monitors;
     }

    public List<MonitoringPematangan> getMonitoring(String creator) throws SQLException{
         
             List<MonitoringPematangan> monitors = new ArrayList<MonitoringPematangan>();
             PreparedStatement stat = null;
             MonitoringPematangan monitor = null;
             ResultSet rs = null;
             conn = Common.getConnection();
             stat = conn.prepareStatement(qMonitorPematanganCreator);
             stat.setString(1,creator);
             
             rs = stat.executeQuery();
             
             while(rs.next()){
                 monitor = new MonitoringPematangan();
                 monitor.setNoBsw(rs.getString("No_BSW"));
                 monitor.setNamaPemohon(rs.getString("Nama_Pemohon"));
                 monitor.setStatus(rs.getString("Status"));
                 monitor.setJenisPermohonan(rs.getString("Jenis_Permohonan"));
                 monitor.setNoSuratPermohonan(rs.getString("No_Surat_Permohonan"));
                 monitor.setNoIjinPematangan(rs.getString("No_Ijin_Pematangan"));
                 try{
                    monitor.setTglSuratMasuk(format.format(rs.getDate("Tgl_Surat_Masuk")));
                     
                 }catch(Exception ex){
                    monitor.setTglSuratMasuk(rs.getString("Tgl_Surat_Masuk"));
                     
                 }
                 monitors.add(monitor);
             }
             
             stat.close();
             conn.close();
             return monitors;
     }

    public List<MonitoringPematangan> getMonitoringSort(String creator, int tipe, String ascDesc) throws SQLException{
         
             List<MonitoringPematangan> monitors = new ArrayList<MonitoringPematangan>();
             PreparedStatement stat = null;
             MonitoringPematangan monitor = null;
             ResultSet rs = null;
             conn = Common.getConnection();
             
             qMonitorPematanganCreatorSort = qMonitorPematanganCreatorSort + getOrder(tipe, ascDesc);
             stat = conn.prepareStatement(qMonitorPematanganCreatorSort);
             stat.setString(1,creator);
             
             rs = stat.executeQuery();
             
             while(rs.next()){
                 monitor = new MonitoringPematangan();
                 monitor.setNoBsw(rs.getString("No_BSW"));
                 monitor.setNamaPemohon(rs.getString("Nama_Pemohon"));
                 monitor.setStatus(rs.getString("Status"));
                 monitor.setJenisPermohonan(rs.getString("Jenis_Permohonan"));
                 monitor.setNoSuratPermohonan(rs.getString("No_Surat_Permohonan"));
                 monitor.setNoIjinPematangan(rs.getString("No_Ijin_Pematangan"));
                 try{
                    monitor.setTglSuratMasuk(format.format(rs.getDate("Tgl_Surat_Masuk")));
                     
                 }catch(Exception ex){
                    monitor.setTglSuratMasuk(rs.getString("Tgl_Surat_Masuk"));
                     
                 }
                 monitors.add(monitor);
             }
             
             stat.close();
             conn.close();
             return monitors;
     }

    public List<MonitoringPematangan> getMonitoring(String creator,
            String licnAplyLttrNo, String licnApltID, String licnAplyDmt,
            String statusBSW) throws SQLException{
         
             List<MonitoringPematangan> monitors = new ArrayList<MonitoringPematangan>();
             PreparedStatement stat = null;
             MonitoringPematangan monitor = null;
             ResultSet rs = null;
             conn = Common.getConnection();
             stat = conn.prepareStatement(qMonitorPematanganSearch);
             stat.setString(1,creator);
             stat.setString(2,licnAplyLttrNo);
             stat.setString(3,licnApltID);
            try {
                stat.setDate(4,Common.convertToDate(licnAplyDmt));
            } catch (Exception ex) {
                Logger.getLogger(TbBwPematanganDao.class.getName()).log(Level.SEVERE, null, ex);
                stat.setDate(4,null);
           
            }
             stat.setString(5,statusBSW);
             
             
             rs = stat.executeQuery();
             
             while(rs.next()){
                 monitor = new MonitoringPematangan();
                 monitor.setNoBsw(rs.getString("No_BSW"));
                 monitor.setNamaPemohon(rs.getString("Nama_Pemohon"));
                 monitor.setStatus(rs.getString("Status"));
                 monitor.setJenisPermohonan(rs.getString("Jenis_Permohonan"));
                 monitor.setNoSuratPermohonan(rs.getString("No_Surat_Permohonan"));
                 monitor.setNoIjinPematangan(rs.getString("No_Ijin_Pematangan"));
                 
                 try{
                    monitor.setTglSuratMasuk(format.format(rs.getDate("Tgl_Surat_Masuk")));
                     
                 }catch(Exception ex){
                    monitor.setTglSuratMasuk(rs.getString("Tgl_Surat_Masuk"));
                     
                 }
                 
                 monitors.add(monitor);
             }
             
             stat.close();
             conn.close();
             return monitors;
     }


    public ResponseInterface deletePematangan(String idPL){
        PreparedStatement statement = null;
        int res = 0;
        SaveResponse response = new SaveResponse();
        conn = Common.getConnection();
        try {
           
                statement = conn.prepareStatement(queryDelete);
             statement.setString(1, idPL);
           // statement.setString(2, licnsPlType);
            
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
    
    
    public String getOrder(int tipe, String ascDesc){
        String orderData = "";
        
        switch(tipe){
            case 1 :
                orderData = " id_pl "+ascDesc;
                break;
            case 2 :
                orderData = " licn_aplt_id "+ascDesc;
                break;
            case 3 :
                orderData = " status_bsw "+ascDesc;
                break;
            case 4 :
                orderData = " US_BW.FUN_CODE_NAME(licn_aply_tp) "+ascDesc;
                break;
            case 5 :
                orderData = " licn_aply_lttr_no "+ascDesc;
                break;
            case 6 :
                orderData = " licn_mgmt_no "+ascDesc;
                break;
            case 7 :
                orderData = " to_char(licn_aply_dmt,'dd/mm/yyyy') "+ascDesc;
                break;
                
        }
        return orderData;
    }
    
}
