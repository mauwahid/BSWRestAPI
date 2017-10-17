/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bsw.dao;

import com.bsw.domain.MonitoringReklame;
import com.bsw.domain.reqres.ReklameResponse;
import com.bsw.domain.TbBwReklame;
import com.bsw.domain.TbBwReklameDoc;
import com.bsw.domain.reqres.ResponseInterface;
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

/**
 *
 * @author Maulana Wahid Abdurrahman
 */
public class TbBwReklameDao {
    private Connection conn;
    private String queryAdd = "INSERT INTO TBBW_REKLAME (AD_CLIENT,AD_APLY_TP,AD_APLY_LTTR_DMT," +
    "AD_APLY_LTTR_NO,AD_APLY_DMT,AD_TEME," +
    "AD_SIDE,AD_WID,AD_LEN,AD_HGT,AD_LOC,AD_RMK,STATUS_BSW,KET_BSW,CREATED_TIME,CREATED_BY) " +
    "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
     private String queryUpdate = "UPDATE TBBW_REKLAME SET AD_CLIENT = ?,AD_APLY_TP=?,AD_APLY_LTTR_DMt=?," +
    "AD_APLY_LTTR_NO=?,AD_APLY_DMT=?,AD_TEME=?," +
    "AD_SIDE=?,AD_WID=?,AD_LEN=?,AD_HGT=?,AD_LOC=?,AD_RMK=?,KET_BSW=?,LASTUPDATED_TIME=?,LASTUPDATED_BY=? " +
    " WHERE ID_IR = ?";
     
     private String queryUpdateStatus = "UPDATE TBBW_REKLAME SET STATUS_BSW=? " +
    " WHERE ID_IR = ?";
     
     private String queryDelete = "DELETE TBBW_REKLAME WHERE ID_IR = ?";
   
    
    private String qMonitorReklame = "select id_ir \"No_BSW\",ad_client \"Perusahaan_Pengguna_Jasa\",status_bsw \"Status\",ad_mgmt_no \"No_Ijin_Reklame\",\n" +
    " US_BW.FUN_CODE_NAME(ad_aply_tp) \"Jenis_Permohonan\",ad_aply_lttr_no \"No_Surat_Permohonan\",\n" +
    " ad_teme \"Tema\",ad_loc \"Lokasi\",to_char(ad_aply_dmt,'dd/mm/yyyy') \"Tgl_Surat_Masuk\"\n" +
    ", (select cd_nm from us_ld.tbld_advet@linkld, us_ref.tbcm_com where AD_MGMT_NO  = a.AD_MGMT_NO  and com_cd = eval_rslt) as status_evaluasi\n" +
    " from US_BW.TBBW_REKLAME a\n" +
    " where id_ir =#ID_IR" +
    "  and ad_client =#AD_CLIENT" +
    "  and ad_aply_tp =#AD_APLY_TP" +
    "  and ad_aply_lttr_no =#AD_APLY_LTTR_NO";
    
    private String qMonitorReklameADClient = "select id_ir \"No_BSW\",ad_client \"Perusahaan_Pengguna_Jasa\",status_bsw \"Status\",ad_mgmt_no \"No_Ijin_Reklame\",\n" +
    " US_BW.FUN_CODE_NAME(ad_aply_tp) \"Jenis_Permohonan\",ad_aply_lttr_no \"No_Surat_Permohonan\",\n" +
    " ad_teme \"Tema\",ad_loc \"Lokasi\",to_char(ad_aply_dmt,'dd/mm/yyyy') \"Tgl_Surat_Masuk\"\n" +
    ", (select cd_nm from us_ld.tbld_advet@linkld, us_ref.tbcm_com where AD_MGMT_NO  = a.AD_MGMT_NO  and com_cd = eval_rslt) as status_evaluasi\n" +
    " from US_BW.TBBW_REKLAME a\n" +
    " where CREATED_BY =#CREATED_BY ORDER BY CREATED_TIME DESC";
    
    private String qMonitorReklameADClientSort = "select id_ir \"No_BSW\",ad_client \"Perusahaan_Pengguna_Jasa\",status_bsw \"Status\",ad_mgmt_no \"No_Ijin_Reklame\",\n" +
    " US_BW.FUN_CODE_NAME(ad_aply_tp) \"Jenis_Permohonan\",ad_aply_lttr_no \"No_Surat_Permohonan\",\n" +
    " ad_teme \"Tema\",ad_loc \"Lokasi\",to_char(ad_aply_dmt,'dd/mm/yyyy') \"Tgl_Surat_Masuk\"\n" +
    ", (select cd_nm from us_ld.tbld_advet@linkld, us_ref.tbcm_com where AD_MGMT_NO  = a.AD_MGMT_NO  and com_cd = eval_rslt) as status_evaluasi\n" +
    " from US_BW.TBBW_REKLAME a\n" +
    " where CREATED_BY =#CREATED_BY ORDER BY ";
    
    
    private String qSearchReklame = "select id_ir \"No_BSW\",ad_client \"Perusahaan_Pengguna_Jasa\",status_bsw \"Status\",ad_mgmt_no \"No_Ijin_Reklame\",\n" +
    " US_BW.FUN_CODE_NAME(ad_aply_tp) \"Jenis_Permohonan\",ad_aply_lttr_no \"No_Surat_Permohonan\",\n" +
    " ad_teme \"Tema\",ad_loc \"Lokasi\",to_char(ad_aply_dmt,'dd/mm/yyyy') \"Tgl_Surat_Masuk\"\n" +
    ", (select cd_nm from us_ld.tbld_advet@linkld, us_ref.tbcm_com where AD_MGMT_NO  = a.AD_MGMT_NO  and com_cd = eval_rslt) as status_evaluasi\n" +
    " from US_BW.TBBW_REKLAME a\n" +
    " where  (AD_CLIENT = #AD_CLIENT or AD_APLY_TP = #AD_APLY_TP "
            + "or AD_APLY_LTTR_NO = #AD_APLY_LTTR_NO or ID_IR = #ID_IR "
            + ") AND CREATED_BY =#CREATED_BY ";
    
    private String qSearchReklameSort = "select id_ir \"No_BSW\",ad_client \"Perusahaan_Pengguna_Jasa\",status_bsw \"Status\",ad_mgmt_no \"No_Ijin_Reklame\",\n" +
    " US_BW.FUN_CODE_NAME(ad_aply_tp) \"Jenis_Permohonan\",ad_aply_lttr_no \"No_Surat_Permohonan\",\n" +
    " ad_teme \"Tema\",ad_loc \"Lokasi\",to_char(ad_aply_dmt,'dd/mm/yyyy') \"Tgl_Surat_Masuk\"\n" +
    ", (select cd_nm from us_ld.tbld_advet@linkld, us_ref.tbcm_com where AD_MGMT_NO  = a.AD_MGMT_NO  and com_cd = eval_rslt) as status_evaluasi\n" +
    " from US_BW.TBBW_REKLAME a\n" +
    " where  (AD_CLIENT = #AD_CLIENT or AD_APLY_TP = #AD_APLY_TP "
            + "or AD_APLY_LTTR_NO = #AD_APLY_LTTR_NO or ID_IR = #ID_IR "
            + ") AND CREATED_BY =#CREATED_BY ORDER BY ";
    
    
    private String reklameDetail = "select a.ID_IR, a.AD_CLIENT, a.AD_APLY_TP, b.CD_NM as \"JENIS_PERMOHONAN\", a.AD_APLY_LTTR_DMT, a.AD_APLY_LTTR_NO, a.AD_APLY_DMT,\n" +
    "a.AD_TEME, a.AD_SIDE, a.AD_WID, a.AD_LEN, a.AD_HGT, a.AD_LOC, a.AD_RMK, a.STATUS_BSW, a.KET_BSW, a.ID_CUST, a.CREATED_BY,\n" +
    "a.AD_MGMT_NO from TBBW_REKLAME a left join\n" +
    "US_REF.TBCM_COM b on a.AD_APLY_TP = b.COM_CD\n" +
    "where a.ID_IR = ?";
    private String reklameDocs = "select a.* , (select CD_NM from US_REF.TBCM_COM where COM_CD = a.COM_CD) as COM_NM\n" +
"from TBBW_REKLAME_DOC a where ID_IR = ?";
    private String generatedColumns[] = { "ID_IR" };
    
    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    
    public TbBwReklameDao(Connection conn){
        this.conn = conn;
    }
    
    public ReklameResponse saveReklame(TbBwReklame tbBwReklame){
        PreparedStatement statement = null;
        
        System.out.println("SAVE REKLAME START");
        ReklameResponse response = new ReklameResponse();
        int rs = 0;
        
        String responseDesc = "ADD REKLAME SUCCESS";
        int idIR = 0;
        
        try {
           
            statement = conn.prepareStatement(queryAdd, generatedColumns);
            statement.setString(1, tbBwReklame.getaDClient());
            statement.setString(2, tbBwReklame.getaDAplyTP());
            
            try{
                statement.setDate(3, Common.convertToDate(tbBwReklame.getaDAplyLttrDMT()));
            }catch(Exception ex){
                statement.setDate(3, null);
                
            }
            
            statement.setDate(5, tbBwReklame.getaDAplyDMT());
           
            statement.setString(4, tbBwReklame.getaDAplyLttrNo());
         //   statement.setString(5, tbBwReklame.getaDAplyDMT());
            statement.setString(6, tbBwReklame.getaDTeme());
            statement.setString(7, tbBwReklame.getaDSide());
            statement.setString(8, tbBwReklame.getaDWid());
            statement.setString(9, tbBwReklame.getaDLen());
            statement.setString(10, tbBwReklame.getaDHgt());
            statement.setString(11, tbBwReklame.getaDLoc());
            statement.setString(12, tbBwReklame.getaDRmk());
            statement.setString(13, tbBwReklame.getStatusBSW());
            statement.setString(14, tbBwReklame.getKetBSW());
            statement.setDate(15, Common.getCurrentDate());
            statement.setString(16, tbBwReklame.getCreatedBy());
            
            rs = statement.executeUpdate();
            
            if(rs>0){
                ResultSet rset = statement.getGeneratedKeys();
                rset.next();
                idIR = rset.getInt(1);
                response.setIdIR(idIR);
            }
            
            statement.close();
            conn.close();
             
            
            
           // return list;
        } catch (SQLException ex) {
            try {
                statement.close();
                conn.close();
                System.out.println("SAVE REKLAME ERR "+ex.toString());
                responseDesc = ex.toString();
              //  return null;
            } catch (SQLException ex2) {
                System.out.println("SAVE REKLAME ERR "+ex2.toString());
                responseDesc = ex2.toString();
        // return null;
            }
        } 
        
        if(rs>0){
            response.setStatus("SUCCESS");
        }else{
            response.setStatus("FAILED");
        }
             response.setStatusDesc(responseDesc);
       
        
        return response;
    }

    public ReklameResponse updReklame(TbBwReklame tbBwReklame){
        PreparedStatement statement = null;
        
        System.out.println("UPD REKLAME START");
        ReklameResponse response = new ReklameResponse();
        int rs = 0;
        
        String responseDesc = "UPD REKLAME SUCCESS";
        int idIR = 0;
        
        try {
           
            statement = conn.prepareStatement(queryUpdate);
            statement.setString(1, tbBwReklame.getaDClient());
            statement.setString(2, tbBwReklame.getaDAplyTP());
            
            try{
                statement.setDate(3, Common.convertToDate(tbBwReklame.getaDAplyLttrDMT()));
            }catch(Exception ex){
                statement.setDate(3, null);
                
            }
            
            statement.setDate(5, tbBwReklame.getaDAplyDMT());
           
            statement.setString(4, tbBwReklame.getaDAplyLttrNo());
         //   statement.setString(5, tbBwReklame.getaDAplyDMT());
            statement.setString(6, tbBwReklame.getaDTeme());
            statement.setString(7, tbBwReklame.getaDSide());
            statement.setString(8, tbBwReklame.getaDWid());
            statement.setString(9, tbBwReklame.getaDLen());
            statement.setString(10, tbBwReklame.getaDHgt());
            statement.setString(11, tbBwReklame.getaDLoc());
            statement.setString(12, tbBwReklame.getaDRmk());
          //  statement.setString(13, tbBwReklame.getStatusBSW());
            statement.setString(13, tbBwReklame.getKetBSW());
            statement.setDate(14, Common.getCurrentDate());
            statement.setString(15, tbBwReklame.getCreatedBy());
            statement.setString(16, tbBwReklame.getIdIR());
            
            rs = statement.executeUpdate();
            
            if(rs>0){
                try{
                    response.setIdIR(Integer.parseInt(tbBwReklame.getIdIR()));
                }catch(Exception ex){
                    
                }
            }
            
            statement.close();
            conn.close();
             
            
            
           // return list;
        } catch (SQLException ex) {
            try {
                statement.close();
                conn.close();
                System.out.println("UPD REKLAME ERR "+ex.toString());
                responseDesc = ex.toString();
              //  return null;
            } catch (SQLException ex2) {
                System.out.println("UPD REKLAME ERR "+ex2.toString());
                responseDesc = ex2.toString();
        // return null;
            }
        } 
        
        if(rs>0){
            response.setStatus("SUCCESS");
        }else{
            response.setStatus("FAILED");
        }
             response.setStatusDesc(responseDesc);
       
        
        return response;
    }

    public ReklameResponse updStatusReklame(TbBwReklame tbBwReklame){
        PreparedStatement statement = null;
        
        System.out.println("UPD REKLAME START");
        ReklameResponse response = new ReklameResponse();
        int rs = 0;
        
        String responseDesc = "UPD STATUS SUCCESS";
        int idIR = 0;
        
        try {
           
            statement = conn.prepareStatement(queryUpdateStatus);
             statement.setString(1, tbBwReklame.getStatusBSW());
            statement.setString(2, tbBwReklame.getIdIR());
            
            rs = statement.executeUpdate();
            
            if(rs>0){
                response.setIdIR(idIR);
            }
            
            statement.close();
            conn.close();
             
            
            
           // return list;
        } catch (SQLException ex) {
            try {
                statement.close();
                conn.close();
                System.out.println("UPD STATUS ERR "+ex.toString());
                responseDesc = ex.toString();
              //  return null;
            } catch (SQLException ex2) {
                System.out.println("UPD STATUS ERR "+ex2.toString());
                responseDesc = ex2.toString();
        // return null;
            }
        } 
        
        if(rs>0){
            response.setStatus("SUCCESS");
        }else{
            response.setStatus("FAILED");
        }
             response.setStatusDesc(responseDesc);
       
        
        return response;
    }

    public ResponseInterface deleteReklame(String idIR){
        PreparedStatement statement = null;
        
        System.out.println("UPD REKLAME START");
        StatusResponse response = new StatusResponse();
        int rs = 0;
        
        String responseDesc = "UPD REKLAME SUCCESS";
        
        try {
           
            statement = conn.prepareStatement(queryDelete);
            statement.setString(1, idIR);
           
            rs = statement.executeUpdate();
            
            statement.close();
            conn.close();
            System.out.println(" ID IR "+idIR);
            response.setStatus("SUCCESS");
            
            
           // return list;
        } catch (SQLException ex) {
            try {
                statement.close();
                conn.close();
                System.out.println("SAVE REKLAME ERR "+ex.toString());
                responseDesc = ex.toString();
              //  return null;
            } catch (SQLException ex2) {
                System.out.println("SAVE REKLAME ERR "+ex2.toString());
                responseDesc = ex2.toString();
        // return null;
            }
        } 
        
        if(rs>0){
            response.setStatus("SUCCESS");
               response.setStatusDesc("DELETE REKLAME SUCCESS");
         
        }else{
            response.setStatus("FAILED");
               response.setStatusDesc("DELETE REKLAME FAILED");
         
        }
          //   response.setStatusDesc(responseDesc);
       
        
        return response;
    }

    public List<MonitoringReklame> getMonitoring(String creator) throws SQLException{
         
             SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
             List<MonitoringReklame> monitors = new ArrayList<MonitoringReklame>();
           //  PreparedStatement stat = null;
             Statement stat = null;
             MonitoringReklame monitor = null;
             ResultSet rs = null;
           // System.out.println("QUERY "+qMonitorReklame);
             
           //  stat = conn.prepareStatement(qMonitorReklame);
             stat = conn.createStatement();
          //   System.out.println("ID IR "+idIR+", "+adClient+" "+adApplyTp+" "+adAplyLttrNo);
           /*  stat.setString(1, idIR);
             stat.setString(2, adClient);
             stat.setString(3, adApplyTp);
             stat.setString(4, adAplyLttrNo); */
        //     stat.setString()
             
         //    qMonitorReklame = qMonitorReklame.replace("#ID_IR", "'"+idIR+"'");
             qMonitorReklameADClient = qMonitorReklameADClient.replace("#CREATED_BY", "'"+creator+"'");
          //   qMonitorReklame = qMonitorReklame.replace("#AD_APLY_TP", "'"+adApplyTp+"'");
          //   qMonitorReklame = qMonitorReklame.replace("#AD_APLY_LTTR_NO", "'"+adAplyLttrNo+"'");
            
             System.out.println("QUERY "+qMonitorReklame);
             rs = stat.executeQuery(qMonitorReklameADClient);
             
             while(rs.next()){
                 monitor = new MonitoringReklame();
                 monitor.setNoBsw(rs.getString("No_BSW"));
                 monitor.setPerusahaanPenggunaJasa(rs.getString("Perusahaan_Pengguna_Jasa"));
                 monitor.setStatus(rs.getString("Status"));
                 monitor.setNoIjinReklame(rs.getString("No_Ijin_Reklame"));
                 monitor.setJenisPermohonan(rs.getString("Jenis_Permohonan"));
                 monitor.setNoSuratPermohonan(rs.getString("No_Surat_Permohonan"));
                 monitor.setStatusEvaluasi(rs.getString("status_evaluasi"));
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
    
    public List<MonitoringReklame> getMonitoringSort(String creator, int tipe, String ascDesc) throws SQLException{
         
             SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
             List<MonitoringReklame> monitors = new ArrayList<MonitoringReklame>();
           //  PreparedStatement stat = null;
             Statement stat = null;
             MonitoringReklame monitor = null;
             ResultSet rs = null;
           // System.out.println("QUERY "+qMonitorReklame);
             
           //  stat = conn.prepareStatement(qMonitorReklame);
             stat = conn.createStatement();
          //   System.out.println("ID IR "+idIR+", "+adClient+" "+adApplyTp+" "+adAplyLttrNo);
           /*  stat.setString(1, idIR);
             stat.setString(2, adClient);
             stat.setString(3, adApplyTp);
             stat.setString(4, adAplyLttrNo); */
        //     stat.setString()
             
         //    qMonitorReklame = qMonitorReklame.replace("#ID_IR", "'"+idIR+"'");
             qMonitorReklameADClientSort = qMonitorReklameADClientSort.replace("#CREATED_BY", "'"+creator+"'");
             qMonitorReklameADClientSort = qMonitorReklameADClientSort + getOrder(tipe, ascDesc);
          //   qMonitorReklame = qMonitorReklame.replace("#AD_APLY_TP", "'"+adApplyTp+"'");
          //   qMonitorReklame = qMonitorReklame.replace("#AD_APLY_LTTR_NO", "'"+adAplyLttrNo+"'");
            
             System.out.println("QUERY "+qMonitorReklameADClientSort);
             rs = stat.executeQuery(qMonitorReklameADClientSort);
             
             while(rs.next()){
                 monitor = new MonitoringReklame();
                 monitor.setNoBsw(rs.getString("No_BSW"));
                 monitor.setPerusahaanPenggunaJasa(rs.getString("Perusahaan_Pengguna_Jasa"));
                 monitor.setStatus(rs.getString("Status"));
                 monitor.setNoIjinReklame(rs.getString("No_Ijin_Reklame"));
                 monitor.setJenisPermohonan(rs.getString("Jenis_Permohonan"));
                 monitor.setNoSuratPermohonan(rs.getString("No_Surat_Permohonan"));
                 monitor.setStatusEvaluasi(rs.getString("status_evaluasi"));
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

    public List<MonitoringReklame> getMonitoring(String creator, String adClient, String adAplyTp,
            String adAplyLttrNo, String idIR) throws SQLException{
         SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
             
             List<MonitoringReklame> monitors = new ArrayList<MonitoringReklame>();
           //  PreparedStatement stat = null;
             Statement stat = null;
             MonitoringReklame monitor = null;
             ResultSet rs = null;
           // System.out.println("QUERY "+qMonitorReklame);
             
           //  stat = conn.prepareStatement(qMonitorReklame);
             stat = conn.createStatement();
          //   System.out.println("ID IR "+idIR+", "+adClient+" "+adApplyTp+" "+adAplyLttrNo);
           /*  stat.setString(1, idIR);
             stat.setString(2, adClient);
             stat.setString(3, adApplyTp);
             stat.setString(4, adAplyLttrNo); */
        //     stat.setString()
             
         //    qMonitorReklame = qMonitorReklame.replace("#ID_IR", "'"+idIR+"'");
             qSearchReklame = qSearchReklame.replace("#CREATED_BY", "'"+creator+"'");
             qSearchReklame = qSearchReklame.replace("#AD_CLIENT", "'"+adClient+"'");
             qSearchReklame = qSearchReklame.replace("#AD_APLY_TP", "'"+adAplyTp+"'");
             qSearchReklame = qSearchReklame.replace("#AD_APLY_LTTR_NO", "'"+adAplyLttrNo+"'");
             qSearchReklame = qSearchReklame.replace("#ID_IR", ""+idIR+"");
          //  qMonitorReklame = qMonitorReklame.replace("#AD_APLY_TP", "'"+adApplyTp+"'");
          //   qMonitorReklame = qMonitorReklame.replace("#AD_APLY_LTTR_NO", "'"+adAplyLttrNo+"'");
            
             System.out.println("QUERY "+qSearchReklame);
             rs = stat.executeQuery(qSearchReklame);
             
             while(rs.next()){
                 monitor = new MonitoringReklame();
                 monitor.setNoBsw(rs.getString("No_BSW"));
                 monitor.setPerusahaanPenggunaJasa(rs.getString("Perusahaan_Pengguna_Jasa"));
                 monitor.setStatus(rs.getString("Status"));
                 monitor.setNoIjinReklame(rs.getString("No_Ijin_Reklame"));
                 monitor.setJenisPermohonan(rs.getString("Jenis_Permohonan"));
                 monitor.setNoSuratPermohonan(rs.getString("No_Surat_Permohonan"));
                 monitor.setStatusEvaluasi(rs.getString("status_evaluasi"));
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

    public List<MonitoringReklame> getMonitoringSort(String creator, String adClient, String adAplyTp,
            String adAplyLttrNo, String idIR, int tipe, String ascDesc) throws SQLException{
         SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
             
             List<MonitoringReklame> monitors = new ArrayList<MonitoringReklame>();
           //  PreparedStatement stat = null;
             Statement stat = null;
             MonitoringReklame monitor = null;
             ResultSet rs = null;
           // System.out.println("QUERY "+qMonitorReklame);
             
           //  stat = conn.prepareStatement(qMonitorReklame);
             stat = conn.createStatement();
          //   System.out.println("ID IR "+idIR+", "+adClient+" "+adApplyTp+" "+adAplyLttrNo);
           /*  stat.setString(1, idIR);
             stat.setString(2, adClient);
             stat.setString(3, adApplyTp);
             stat.setString(4, adAplyLttrNo); */
        //     stat.setString()
             
         //    qMonitorReklame = qMonitorReklame.replace("#ID_IR", "'"+idIR+"'");
             qSearchReklameSort = qSearchReklameSort.replace("#CREATED_BY", "'"+creator+"'");
             qSearchReklameSort = qSearchReklameSort.replace("#AD_CLIENT", "'"+adClient+"'");
             qSearchReklameSort = qSearchReklameSort.replace("#AD_APLY_TP", "'"+adAplyTp+"'");
             qSearchReklameSort = qSearchReklameSort.replace("#AD_APLY_LTTR_NO", "'"+adAplyLttrNo+"'");
             qSearchReklameSort = qSearchReklameSort.replace("#ID_IR", ""+idIR+"");
          //  qMonitorReklame = qMonitorReklame.replace("#AD_APLY_TP", "'"+adApplyTp+"'");
          //   qMonitorReklame = qMonitorReklame.replace("#AD_APLY_LTTR_NO", "'"+adAplyLttrNo+"'");
            
             qSearchReklameSort = qSearchReklameSort + getOrder(tipe, ascDesc);
             System.out.println("QUERY "+qSearchReklameSort);
             rs = stat.executeQuery(qSearchReklameSort);
             
             while(rs.next()){
                 monitor = new MonitoringReklame();
                 monitor.setNoBsw(rs.getString("No_BSW"));
                 monitor.setPerusahaanPenggunaJasa(rs.getString("Perusahaan_Pengguna_Jasa"));
                 monitor.setStatus(rs.getString("Status"));
                 monitor.setNoIjinReklame(rs.getString("No_Ijin_Reklame"));
                 monitor.setJenisPermohonan(rs.getString("Jenis_Permohonan"));
                 monitor.setNoSuratPermohonan(rs.getString("No_Surat_Permohonan"));
                 monitor.setStatusEvaluasi(rs.getString("status_evaluasi"));
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

    public List<MonitoringReklame> getMonitoring(String idIR, String adClient, String adApplyTp,
             String adAplyLttrNo) throws SQLException{
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
         
         
             List<MonitoringReklame> monitors = new ArrayList<MonitoringReklame>();
           //  PreparedStatement stat = null;
             Statement stat = null;
             MonitoringReklame monitor = null;
             ResultSet rs = null;
           // System.out.println("QUERY "+qMonitorReklame);
             
           //  stat = conn.prepareStatement(qMonitorReklame);
             stat = conn.createStatement();
             System.out.println("ID IR "+idIR+", "+adClient+" "+adApplyTp+" "+adAplyLttrNo);
           /*  stat.setString(1, idIR);
             stat.setString(2, adClient);
             stat.setString(3, adApplyTp);
             stat.setString(4, adAplyLttrNo); */
        //     stat.setString()
             
             qMonitorReklame = qMonitorReklame.replace("#ID_IR", "'"+idIR+"'");
             qMonitorReklame = qMonitorReklame.replace("#AD_CLIENT", "'"+adClient+"'");
             qMonitorReklame = qMonitorReklame.replace("#AD_APLY_TP", "'"+adApplyTp+"'");
             qMonitorReklame = qMonitorReklame.replace("#AD_APLY_LTTR_NO", "'"+adAplyLttrNo+"'");
            
             System.out.println("QUERY "+qMonitorReklame);
             rs = stat.executeQuery(qMonitorReklame);
             
             while(rs.next()){
                 monitor = new MonitoringReklame();
                 monitor.setNoBsw(rs.getString("No_BSW"));
                 monitor.setPerusahaanPenggunaJasa(rs.getString("Perusahaan_Pengguna_Jasa"));
                 monitor.setStatus(rs.getString("Status"));
                 monitor.setNoIjinReklame(rs.getString("No_Ijin_Reklame"));
                 monitor.setJenisPermohonan(rs.getString("Jenis_Permohonan"));
                 monitor.setNoSuratPermohonan(rs.getString("No_Surat_Permohonan"));
                 monitor.setStatusEvaluasi(rs.getString("status_evaluasi"));
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

    
    public TbBwReklame getReklame(String idIR){
        PreparedStatement stat = null;
        ResultSet rs = null;
        TbBwReklame tbBwReklame = new TbBwReklame();
        
        conn = Common.getConnection();
        try{
            
            stat = conn.prepareStatement(reklameDetail);
            stat.setString(1, idIR);
            
            System.out.println("EXECUTE");
            
            rs = stat.executeQuery();
            while(rs.next()){
              //  String idIR = rs.getString("ID_IR");
             //   tbBwReklame = new TbBwReklame();
                 System.out.println("FOUND");
            
                tbBwReklame.setIdIR(rs.getString("ID_IR"));
                tbBwReklame.setaDClient(rs.getString("AD_CLIENT"));
                tbBwReklame.setaDAplyTP(rs.getString("JENIS_PERMOHONAN"));
                try{
                    tbBwReklame.setaDAplyLttrDMT(format.format(rs.getDate("AD_APLY_LTTR_DMT")));
                    
                }catch(Exception ex){
                    
                }
                
                tbBwReklame.setaDAplyLttrNo(rs.getString("AD_APLY_LTTR_NO"));
                tbBwReklame.setaDAplyDMT(rs.getDate("AD_APLY_DMT"));
                tbBwReklame.setaDTeme(rs.getString("AD_TEME"));
                tbBwReklame.setaDSide(rs.getString("AD_SIDE"));
                tbBwReklame.setaDWid(rs.getString("AD_WID"));
                tbBwReklame.setaDLen(rs.getString("AD_LEN"));
                tbBwReklame.setaDHgt(rs.getString("AD_HGT"));
                tbBwReklame.setaDLoc(rs.getString("AD_LOC"));
                tbBwReklame.setaDRmk(rs.getString("AD_RMK"));
                tbBwReklame.setStatusBSW(rs.getString("STATUS_BSW"));
                tbBwReklame.setKetBSW(rs.getString("KET_BSW"));
                tbBwReklame.setCreatedBy(rs.getString("CREATED_BY"));
                tbBwReklame.setIdCust(rs.getString("ID_CUST"));
                tbBwReklame.setAdMgmtNo(rs.getString("AD_MGMT_NO"));
                tbBwReklame.setReklameDocs(getReklameDocs(idIR));
                
                
            }
           
        }catch(SQLException ex){
            System.out.println("EX "+ex.toString());
        }
        
        return tbBwReklame;
    }
    
    public List<TbBwReklameDoc> getReklameDocs(String idIR){
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<TbBwReklameDoc> list = new ArrayList<TbBwReklameDoc>();
        TbBwReklameDoc tbBwReklameDoc = new TbBwReklameDoc();
        
        try{
            
            stat = conn.prepareStatement(reklameDocs);
            stat.setString(1, idIR);
            
            rs = stat.executeQuery();
            while(rs.next()){
              //  String idIR = rs.getString("ID_IR");
                tbBwReklameDoc  = new TbBwReklameDoc();
                tbBwReklameDoc.setIdDR(rs.getString("ID_IR"));
                tbBwReklameDoc.setComCd(rs.getString("COM_CD"));
                tbBwReklameDoc.setComNm(rs.getString("COM_NM"));
                tbBwReklameDoc.setFileNm(rs.getString("FILE_NM"));
                tbBwReklameDoc.setFileSize(rs.getString("FILE_SIZE"));
                tbBwReklameDoc.setFileTp(rs.getString("FILE_TP"));
                tbBwReklameDoc.setRemarks(rs.getString("REMARKS"));
                tbBwReklameDoc.setDocumentNo(rs.getString("DOCUMENT_NO"));
                tbBwReklameDoc.setExtDmt(rs.getDate("EXT_DMT"));
                tbBwReklameDoc.setCreatedBy(rs.getString("CREATED_BY"));
                
                tbBwReklameDoc.setFileSeq(rs.getInt("FILE_SEQ"));
                list.add(tbBwReklameDoc);
                
            }
           
        }catch(SQLException ex){
            System.out.println("EXCE "+ex.toString());
        }
        
        return list;
    }
    
    public String getOrder(int tipe, String ascDesc){
        String orderData = "";
        
        switch(tipe){
            case 1 :
                orderData = " id_ir "+ascDesc;
                break;
            case 2 :
                orderData = " status_bsw "+ascDesc;
                break;
            case 3 :
                orderData = " ad_mgmt_no "+ascDesc;
                break;
            case 4 :
                orderData = " US_BW.FUN_CODE_NAME(ad_aply_tp) "+ascDesc;
                break;
            case 5 :
                orderData = " ad_aply_lttr_no "+ascDesc;
                break;
            case 6 :
                orderData = " ad_teme "+ascDesc;
                break;
            case 7 :
                orderData = " ad_loc "+ascDesc;
                break;
            case 8 :
                orderData = " to_char(ad_aply_dmt,'dd/mm/yyyy') "+ascDesc;
                break;
        }
        
        return orderData;
    }
    
    
}
