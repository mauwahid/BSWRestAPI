/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bsw.dao;

import com.bsw.controller.TbBwCustController;
import com.bsw.controller.TbBwIPHDetlController;
import com.bsw.controller.TbLdAddrCDController;
import com.bsw.domain.MonitoringIPH;
import com.bsw.domain.TbBW2Status;
import com.bsw.domain.TbBWIPH;
import com.bsw.domain.TbBWIPHDetl;
import com.bsw.domain.TbBwIPHPemohon;
import com.bsw.domain.TbCMCountryCityTMP;
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
public class TbBWIPHDao {

    private Connection conn;
    private String queryCreateIPH  = "INSERT INTO TBBW_IPH " +
        "(ID_IPH, APPLY_TP, PEMOHON_ID, PL_NO, CERT_NO, APPLY_LTTR_NO, DOC_DMT, APPLY_LTTR_SBJT,DOC_STAT, " +
        "APPLY_STAT, ADDR_CD, ADDR_DETL, LD_USG_CD, LD_USG_TP, APLY_LD_SIZE, BL_LEN,UWTO_TP, UWTO_EXPIR_DMT,"
            + "PMT_COND_CD, RENT_PERD_YEAR, LD_PRC_AMT, TOT_PRC, BAP_AMT, VRFKSI_DT, ASING_FLG, "
            + "CREATED_BY, CREATED_TIME, CUST_USERNAME,REG_REMARK) VALUES " +
        "(?,?,?,?,?,?,?,?,?,?,"
            + "?,?,?,?,?,?,?,?,?,?,"
            + "?,?,?,?,?,?,?,?,?)";
    
    private String queryCreateIPH2 = "INSERT INTO TBBW_IPH " +
        "(ID_IPH, APPLY_TP, PENJUAL_ID, PEMBELI_ID, PEMOHON_ID, PL_NO, CERT_NO, APPLY_LTTR_NO, DOC_DMT, APPLY_LTTR_SBJT,DOC_STAT, " +
        "APPLY_STAT, ADDR_CD, ADDR_DETL, LD_USG_CD, LD_USG_TP, APLY_LD_SIZE, BL_LEN,UWTO_TP, UWTO_EXPIR_DMT,"
            + "PMT_COND_CD, RENT_PERD_YEAR, LD_PRC_AMT, TOT_PRC, BAP_AMT, VRFKSI_DT, ASING_FLG, "
            + "CREATED_BY, CREATED_TIME, CUST_USERNAME,REG_REMARK, NO_PERJANJIAN, TGL_PERJANJIAN, NO_KEPUTUSAN, TGL_KEPUTUSAN, TGL_PL, TGL_CERT) VALUES " +
        "(#ID_IPH, #APPLY_TP, #PENJUAL_ID, #PEMBELI_ID, #PEMOHON_ID, #PL_NO, #CERT_NO, #APPLY_LTTR_NO, #DOC_DMT, #APPLY_LTTR_SBJT,#DOC_STAT, " +
        "#APPLY_STAT, #ADDR_CD, #ADDR_DETL, #LD_USG_CD, #LD_USG_TP, #APLY_LD_SIZE, #BL_LEN,#UWTO_TP, #UWTO_EXPIR_DMT,"
            + "#PMT_COND_CD, #RENT_PERD_YEAR, #LD_PRC_AMT, #TOT_PRC, #BAP_AMT, #VRFKSI_DT, #ASING_FLG, "
            + "#CREATED_BY, #CREATED_TIME, #CUST_USERNAME,#REG_REMARK, #NO_PERJANJIAN, #TGL_PERJANJIAN, #NO_KEPUTUSAN, #TGL_KEPUTUSAN, #TGL_PL, #TGL_CERT)";
     
    //delete APPY_STAT & VER_DATE
    private String queryUpdateIPH = "UPDATE TBBW_IPH " +
        "SET APPLY_TP = #APPLY_TP, PEMOHON_ID = #PEMOHON_ID, PENJUAL_ID = #PENJUAL_ID, PEMBELI_ID = #PEMBELI_ID, PL_NO = #PL_NO, CERT_NO = #CERT_NO, "
             + "APPLY_LTTR_NO = #APPLY_LTTR_NO, DOC_DMT = #DOC_DMT, APPLY_LTTR_SBJT = #APPLY_LTTR_SBJT, "
             + "DOC_STAT = #DOC_STAT, ADDR_CD = #ADDR_CD, ADDR_DETL = #ADDR_DETL , "
             + "LD_USG_CD = #LD_USG_CD, LD_USG_TP = #LD_USG_TP, APLY_LD_SIZE = #APLY_LD_SIZE, BL_LEN = #BL_LEN ,"
             + "UWTO_TP = #UWTO_TP, UWTO_EXPIR_DMT = #UWTO_EXPIR_DMT,"
            + "PMT_COND_CD = #PMT_COND_CD , RENT_PERD_YEAR = #RENT_PERD_YEAR, LD_PRC_AMT = #LD_PRC_AMT, "
             + "TOT_PRC = #TOT_PRC, BAP_AMT = #BAP_AMT, ASING_FLG = #ASING_FLG, "
            + "LASTUPDATED_BY = #LASTUPDATED_BY, LASTUPDATED_TIME = #LASTUPDATED_TIME, CUST_USERNAME = #CUST_USERNAME,REG_REMARK = #REG_REMARK, "
             + "TGL_PL = #TGL_PL, TGL_CERT = #TGL_CERT WHERE ID_IPH = #ID_IPH ";
    private String queryUpdateVerIPH = "UPDATE TBBW_IPH " +
        "SET VRFKSI_DT = ? WHERE ID_IPH = ? ";
    private String queryUpdateDocStatIPH = "UPDATE TBBW_IPH " +
        "SET DOC_STAT = ? WHERE ID_IPH = ? ";
    private String queryUpdateApStatIPH = "UPDATE TBBW_IPH " +
        "SET APPLY_STAT = ? WHERE ID_IPH = ? ";
    
    
     
    private String queryNextID = "SELECT MAX(ID_IPH) + 1 as NEXTID FROM TBBW_IPH WHERE ROWNUM =1";
    private String qMonitoringIPHSearch = "select iph.CREATED_BY, IPH.APPLY_TP,US_BW.FUN_CODE_NAME(IPH.APPLY_TP) \"Jenis_Permohonan\",IPH.id_iph \"No_BSW\",IPH.pl_no \"No_PL\",\n" +
        " US_BW.GET_STATUS_EGOV_APPLY(IPH.NOMOR_URUT_PERMOHONAN) \"Status\",IPH.apply_stat \"Status_Registrasi\",\n" +
        " (select addr.sub_dstrt_nm from US_REF.TBLD_ADDR_CD addr where ADDR.ADDR_CD=IPH.ADDR_CD) \"Alokasi_Yang_Diminta\",\n" +
        " IPH.doc_dmt \"Tgl_Surat_Masuk\", IPH.VRFKSI_DT, IPH.BAP_AMT, GET_ACTIVE_BTN_IPH(VRFKSI_DT,APPLY_STAT) as button " +
        ",  (select cd_nm from us_ld.tbld_apply@linkld, us_ref.tbcm_com where aply_no = IPH.NOMOR_URUT_PERMOHONAN and com_cd = curr_aply_stat) as status_evaluasi "+
        " from US_BW.TBBW_IPH iph "+
        " where iph.CREATED_BY =? ";
    
    /* private String qMonitoringIPHSearchSort = "select IPH.APPLY_TP,US_BW.FUN_CODE_NAME(IPH.APPLY_TP) \"Jenis_Permohonan\",IPH.id_iph \"No_BSW\",IPH.pl_no \"No_PL\",\n" +
        " US_BW.GET_STATUS_EGOV_APPLY(IPH.NOMOR_URUT_PERMOHONAN) \"Status\",IPH.apply_stat \"Status_Registrasi\",\n" +
        " (select addr.sub_dstrt_nm from US_REF.TBLD_ADDR_CD addr where ADDR.ADDR_CD=IPH.ADDR_CD) \"Alokasi_Yang_Diminta\",\n" +
        " IPH.doc_dmt \"Tgl_Surat_Masuk\", IPH.VRFKSI_DT, IPH.BAP_AMT, GET_ACTIVE_BTN_IPH(VRFKSI_DT,APPLY_STAT) as button " +
        ",  (select cd_nm from us_ld.tbld_apply@linkld, us_ref.tbcm_com where aply_no = IPH.NOMOR_URUT_PERMOHONAN and com_cd = curr_aply_stat) as status_evaluasi "+
        " from US_BW.TBBW_IPH iph "+
        " where id_iph =?\n" +
        "  or pl_no =?\n" +
        "  or apply_stat =?\n" +
        "  or (VRFKSI_DT between to_date(?,'dd/MM/yyyy') and to_date(?,'dd/MM/yyyy')\n" +
        "  ) or apply_tp  =? or EVAL_RESULT = ?  AND CREATED_BY =? ORDER BY "; */
    
    private String qMonitoringIPHCreator = "select IPH.CREATED_BY, IPH.APPLY_TP, US_BW.FUN_CODE_NAME(IPH.APPLY_TP) \"Jenis_Permohonan\",IPH.id_iph \"No_BSW\",IPH.pl_no \"No_PL\",\n" +
        " US_BW.GET_STATUS_EGOV_APPLY(IPH.NOMOR_URUT_PERMOHONAN) \"Status\",IPH.apply_stat \"Status_Registrasi\",\n" +
        " (select addr.sub_dstrt_nm from US_REF.TBLD_ADDR_CD addr where ADDR.ADDR_CD=IPH.ADDR_CD) \"Alokasi_Yang_Diminta\",\n" +
        " IPH.doc_dmt \"Tgl_Surat_Masuk\", IPH.VRFKSI_DT, IPH.BAP_AMT, GET_ACTIVE_BTN_IPH(VRFKSI_DT,APPLY_STAT) as button  " +
        ",  (select cd_nm from us_ld.tbld_apply@linkld, us_ref.tbcm_com where aply_no = IPH.NOMOR_URUT_PERMOHONAN and com_cd = curr_aply_stat) as status_evaluasi "+
        " from US_BW.TBBW_IPH iph "+
        " where CREATED_BY =? order by CREATED_TIME desc";
    
    private String qMonitoringIPHSortCreator = "select IPH.APPLY_TP, US_BW.FUN_CODE_NAME(IPH.APPLY_TP) \"Jenis_Permohonan\",IPH.id_iph \"No_BSW\",IPH.pl_no \"No_PL\",\n" +
        " US_BW.GET_STATUS_EGOV_APPLY(IPH.NOMOR_URUT_PERMOHONAN) \"Status\",IPH.apply_stat \"Status_Registrasi\",\n" +
        " (select addr.sub_dstrt_nm from US_REF.TBLD_ADDR_CD addr where ADDR.ADDR_CD=IPH.ADDR_CD) \"Alokasi_Yang_Diminta\",\n" +
        " IPH.doc_dmt \"Tgl_Surat_Masuk\", IPH.VRFKSI_DT, IPH.BAP_AMT, GET_ACTIVE_BTN_IPH(VRFKSI_DT,APPLY_STAT) as button  " +
        ",  (select cd_nm from us_ld.tbld_apply@linkld, us_ref.tbcm_com where aply_no = IPH.NOMOR_URUT_PERMOHONAN and com_cd = curr_aply_stat) as status_evaluasi "+
        " from US_BW.TBBW_IPH iph "+
        " where CREATED_BY =? order by ";
    
    
    private String queryGetIPH = "Select * from TBBW_IPH where ID_IPH=?";
    private String queryGetIPH2 = "select a.*, (select distinct CD_NM from US_REF.TBCM_COM where COM_CD = a.APPLY_TP) as APPLY_NM, \n" +
    "(select distinct CD_NM from US_REF.TBCM_COM where COM_CD = a.DOC_STAT) as DOC_STAT_NM,\n" +
    "(select distinct CD_NM from US_REF.TBCM_COM where COM_CD = a.LD_USG_CD) as LD_USG_CD_NM,\n" +
    "(select distinct CD_NM from US_REF.TBCM_COM where COM_CD = a.LD_USG_TP) as LD_USG_TP_NM,\n" +
    "(select distinct SUB_DSTRT_NM from US_REF.TBLD_ADDR_CD where ADDR_CD = a.ADDR_CD) as ADDR_CD_NM,\n" +
    "(select distinct CD_NM from US_REF.TBCM_COM where COM_CD = a.UWTO_TP) as UWTO_TP_NM,\n" +
    "(select distinct CD_NM from US_REF.TBCM_COM where COM_CD = a.PMT_COND_CD) as PMT_COND_CD_NM\n" +
    "from TBBW_IPH a where a.ID_IPH = ?";
    private String queryGetIPHDetl = "select a.*, (select distinct CD_NM from US_REF.TBCM_COM where COM_CD = a.COM_CD) as COM_NM,\n" +
            "(select distinct CD_NM from US_REF.TBCM_COM where COM_CD = a.DOC_TP) as DOC_TYPE\n" +
            "from TBBW_IPH_DETL a where a.ID_IPH = ? Order by FILE_SEQ ASC";
    private String queryGetIPHPemohon = "select a.*, (select distinct CD_NM from US_REF.TBCM_COM where COM_CD = a.CUST_CD) as CUSTCODE,\n" +
    "(select distinct CODE_NM from TBCM_COUNTRY_CITY_TMP where MGMT_NO = a.CUST_NTNTY) as NATIONALITY\n" +
    "from TBBW_IPH_PEMOHON a where id_iph = ?";
    
    private String queryGetAvailDate = "SELECT dateval from \n" +
        "(SELECT	TRUNC(SYSDATE+7) - ROWNUM dateval\n" +
        "                        FROM	all_objects\n" +
        "                        WHERE	ROWNUM < (7)) \n" +
        "WHERE dateval not in( SELECT NOT_AVAIL FROM \n" +
        "(\n" +
        "\n" +
        "SELECT VRFKSI_DT as NOT_AVAIL FROM(\n" +
        "SELECT VRFKSI_DT, COUNT(*) FROM TBBW_IPH WHERE VRFKSI_DT >= TRUNC(SYSDATE) AND APPLY_TP = ? \n" +
        "        HAVING COUNT(*) >= (SELECT LIMIT FROM TBBW_IPH_CONFIG WHERE APPLY_TP = ? ) GROUP BY VRFKSI_DT\n" +
        "         UNION SELECT TRUNC(SYSDATE) AS VRFKSI_DT, COUNT(*) FROM DUAL \n" +
        "         UNION select to_date(hday_dt,'yyyymmdd') AS VRFKSI_DT, count(*) from tbhr_hday_info@linkhr where to_date(hday_dt,'yyyymmdd') >= trunc(sysdate) group by hday_dt)\n" +
        " UNION SELECT NOT_AVAIL FROM\n" +
        " (WITH dateqry AS (\n" +
        "                      SELECT	TRUNC(SYSDATE+14) - ROWNUM dateval\n" +
        "                        FROM	all_objects\n" +
        "                        WHERE	ROWNUM < (7 * 2)\n" +
        "    				)\n" +
        "    SELECT DATEVAL as NOT_AVAIL\n" +
        "    FROM	dateqry dq\n" +
        "    WHERE	TO_CHAR(dq.dateval, 'DY') = 'SUN' or TO_CHAR(dq.dateval, 'DY') = 'SAT')\n" +
        ")\n" +
        "\n" +
        ") and ROWNUM < 4\n" +
        "          ";
    
    
    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
             
    
   public static TbBWIPHDao getInstance(Connection conn){
       return new TbBWIPHDao(conn);
   }
    
    
    public TbBWIPHDao(Connection conn){
        this.conn = conn;
    }
    
    public ResponseInterface saveIPHold(TbBWIPH tbBwIPH){
        PreparedStatement statement = null;
        int res = 0;
       // conn = Common.getConnection();
        SaveResponse response = new SaveResponse();
        try {
           
            conn = Common.getConnection();
            System.out.println("Start TO INSERT");
            
            statement = conn.prepareStatement(queryCreateIPH);
     /*       statement.setString(1, getNextID()+"");
            statement.setString(2, tbBwIPH.getApplyTP());
            statement.setString(3, tbBwIPH.getPemohonId());
            statement.setString(4, tbBwIPH.getPlNo());
            statement.setString(5, tbBwIPH.getCertNo());
            statement.setString(6, tbBwIPH.getApplyLttrNo());
            statement.setDate(7, tbBwIPH.getDocDMT());
            statement.setString(8, tbBwIPH.getApplyLttrSBJT());
            statement.setString(9, tbBwIPH.getDocStat());
            statement.setString(10, tbBwIPH.getApplyStat());
            statement.setString(11, tbBwIPH.getAddrCd());
            statement.setString(12, tbBwIPH.getAddrDetl());
            statement.setString(13, tbBwIPH.getLdUsgCd());
            statement.setString(14, tbBwIPH.getLdUsgTp());
            statement.setString(15, tbBwIPH.getApplyLdSize());
            statement.setString(16, tbBwIPH.getBlLen());
            statement.setString(17, tbBwIPH.getUwtoTp());
            statement.setDate(18, tbBwIPH.getUwtoExpirDmt());
            statement.setString(19, tbBwIPH.getPmtCondCd());
            statement.setString(20, tbBwIPH.getRentPerdYear());
            statement.setString(21, tbBwIPH.getLdPrcAmt());
            statement.setString(22, tbBwIPH.getTotPrice());
            statement.setString(23, tbBwIPH.getBapAmt());
            statement.setString(24, tbBwIPH.getVrfksiDt());
            statement.setString(25, tbBwIPH.getAsingFlg());
            statement.setString(26, tbBwIPH.getCreatedBy());
            statement.setDate(27, Common.getCurrentDate());
            statement.setString(28, tbBwIPH.getCustUsername());
            statement.setString(29, tbBwIPH.getRegRemark());
            */
            
            res = statement.executeUpdate();
            System.out.println("SETELAH EKSEKUSI");
            if (res>0) {
                response.setId(tbBwIPH.getIdIPH());
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
    
    
    public ResponseInterface saveIPH(TbBWIPH tbBwIPH){
        Statement statement = null;
        int res = 0;
       // conn = Common.getConnection();
        String nextId = getNextID()+"";
        System.out.println(" NEXT ID "+nextId);
        SaveResponse response = new SaveResponse();
        
        queryCreateIPH2 = queryCreateIPH2.replace("#ID_IPH", ""+nextId+"");
        queryCreateIPH2 = queryCreateIPH2.replace("#APPLY_TP", "'"+tbBwIPH.getApplyTP()+"'");
        queryCreateIPH2 = queryCreateIPH2.replace("#PENJUAL_ID", "'"+tbBwIPH.getPenjualId()+"'");
        queryCreateIPH2 = queryCreateIPH2.replace("#PEMBELI_ID", "'"+tbBwIPH.getPembeliId()+"'");
        queryCreateIPH2 = queryCreateIPH2.replace("#PEMOHON_ID", "'"+tbBwIPH.getPemohonId()+"'");
        queryCreateIPH2 = queryCreateIPH2.replace("#PL_NO", "'"+tbBwIPH.getPlNo()+"'");
        queryCreateIPH2 = queryCreateIPH2.replace("#CERT_NO", "'"+tbBwIPH.getCertNo()+"'");
        queryCreateIPH2 = queryCreateIPH2.replace("#APPLY_LTTR_NO", "'"+tbBwIPH.getApplyLttrNo()+"'");
        queryCreateIPH2 = queryCreateIPH2.replace("#DOC_DMT", "to_date('"+tbBwIPH.getDocDMT()+"','dd/MM/yyyy')");
        queryCreateIPH2 = queryCreateIPH2.replace("#APPLY_LTTR_SBJT", "'"+tbBwIPH.getApplyLttrSBJT()+"'");
        queryCreateIPH2 = queryCreateIPH2.replace("#DOC_STAT", "'"+tbBwIPH.getDocStat()+"'");
        queryCreateIPH2 = queryCreateIPH2.replace("#APPLY_STAT", "'"+tbBwIPH.getApplyStat()+"'");
        queryCreateIPH2 = queryCreateIPH2.replace("#ADDR_CD", "'"+tbBwIPH.getAddrCd()+"'");
        queryCreateIPH2 = queryCreateIPH2.replace("#ADDR_DETL", "'"+tbBwIPH.getAddrDetl()+"'");
        queryCreateIPH2 = queryCreateIPH2.replace("#LD_USG_CD", "'"+tbBwIPH.getLdUsgCd()+"'");
        queryCreateIPH2 = queryCreateIPH2.replace("#LD_USG_TP", "'"+tbBwIPH.getLdUsgTp()+"'");
        queryCreateIPH2 = queryCreateIPH2.replace("#APLY_LD_SIZE", "'"+tbBwIPH.getApplyLdSize()+"'");
        queryCreateIPH2 = queryCreateIPH2.replace("#BL_LEN", "'"+tbBwIPH.getBlLen()+"'");
        queryCreateIPH2 = queryCreateIPH2.replace("#UWTO_TP", "'"+tbBwIPH.getUwtoTp()+"'");
        queryCreateIPH2 = queryCreateIPH2.replace("#UWTO_EXPIR_DMT", "to_date('"+tbBwIPH.getUwtoExpirDmt()+"','dd/MM/yyyy')");
        queryCreateIPH2 = queryCreateIPH2.replace("#PMT_COND_CD", "'"+tbBwIPH.getPmtCondCd()+"'");
        queryCreateIPH2 = queryCreateIPH2.replace("#RENT_PERD_YEAR", "'"+tbBwIPH.getRentPerdYear()+"'");
        queryCreateIPH2 = queryCreateIPH2.replace("#LD_PRC_AMT", "'"+tbBwIPH.getLdPrcAmt()+"'");
        queryCreateIPH2 = queryCreateIPH2.replace("#TOT_PRC", "'"+tbBwIPH.getTotPrice()+"'");
        queryCreateIPH2 = queryCreateIPH2.replace("#BAP_AMT", "'"+tbBwIPH.getBapAmt()+"'");
        
        queryCreateIPH2 = queryCreateIPH2.replace("#ASING_FLG", "'"+tbBwIPH.getAsingFlg()+"'");
        queryCreateIPH2 = queryCreateIPH2.replace("#CREATED_BY", "'"+tbBwIPH.getCreatedBy()+"'");
        queryCreateIPH2 = queryCreateIPH2.replace("#CREATED_TIME", "to_date('"+format.format(Common.getCurrentDate())+"','dd/MM/yyyy')");
        queryCreateIPH2 = queryCreateIPH2.replace("#CUST_USERNAME", "'"+tbBwIPH.getCustUsername()+"'");
        queryCreateIPH2 = queryCreateIPH2.replace("#REG_REMARK", "'"+tbBwIPH.getRegRemark()+"'");
        
        queryCreateIPH2 = queryCreateIPH2.replace("#NO_PERJANJIAN", "'"+tbBwIPH.getNoPerjanjian()+"'");
        
        if(tbBwIPH.getVrfksiDt()!=null){
            if(tbBwIPH.getVrfksiDt().equalsIgnoreCase(""))
                   queryCreateIPH2 = queryCreateIPH2.replace("#VRFKSI_DT", "null");
            else
                queryCreateIPH2 = queryCreateIPH2.replace("#VRFKSI_DT", "to_date('"+tbBwIPH.getVrfksiDt()+"','dd/MM/yyyy')");
                
            }   
        else{
             queryCreateIPH2 = queryCreateIPH2.replace("#VRFKSI_DT", "null");
            
        }
        
        if(tbBwIPH.getTglPerjanjian()!=null){
            if(tbBwIPH.getTglPerjanjian().equalsIgnoreCase(""))
                   queryCreateIPH2 = queryCreateIPH2.replace("#TGL_PERJANJIAN", "null");
            else
                   queryCreateIPH2 = queryCreateIPH2.replace("#TGL_PERJANJIAN", "to_date('"+tbBwIPH.getTglPerjanjian()+"','dd/MM/yyyy')");
                
            }   
        else{
             queryCreateIPH2 = queryCreateIPH2.replace("#TGL_PERJANJIAN", "null");
            
        }
        
        if(tbBwIPH.getTglKeputusan()!=null){
            if(tbBwIPH.getTglKeputusan().equalsIgnoreCase(""))
                   queryCreateIPH2 = queryCreateIPH2.replace("#TGL_KEPUTUSAN", "null");
            else
                queryCreateIPH2 = queryCreateIPH2.replace("#TGL_KEPUTUSAN", "to_date('"+tbBwIPH.getTglKeputusan()+"','dd/MM/yyyy')");
             
            }   
        else{
             queryCreateIPH2 = queryCreateIPH2.replace("#TGL_KEPUTUSAN", "null");
            
        }
        
        if(tbBwIPH.getTglPl()!=null){
            if(tbBwIPH.getTglPl().equalsIgnoreCase(""))
                   queryCreateIPH2 = queryCreateIPH2.replace("#TGL_PL", "null");
            else
               queryCreateIPH2 = queryCreateIPH2.replace("#TGL_PL", "to_date('"+tbBwIPH.getTglPl()+"','dd/MM/yyyy')");
        
            }   
        else{
             queryCreateIPH2 = queryCreateIPH2.replace("#TGL_PL", "null");
            
        }
        
        if(tbBwIPH.getTglCert()!=null){
            if(tbBwIPH.getTglCert().equalsIgnoreCase(""))
                   queryCreateIPH2 = queryCreateIPH2.replace("#TGL_CERT", "null");
            else
                queryCreateIPH2 = queryCreateIPH2.replace("#TGL_CERT", "to_date('"+tbBwIPH.getTglCert()+"','dd/MM/yyyy')");
        
            }   
        else{
             queryCreateIPH2 = queryCreateIPH2.replace("#TGL_CERT", "null");
            
        }
                  
        
        queryCreateIPH2 = queryCreateIPH2.replace("#NO_KEPUTUSAN", "'"+tbBwIPH.getNoKeputusan()+"'");
        
        
        
        
        System.out.println("QUERY INSERT IPH : "+queryCreateIPH2);
        try {
           
            conn = Common.getConnection();
            System.out.println("Start TO INSERT");
            statement = conn.createStatement();
            
            
            res = statement.executeUpdate(queryCreateIPH2);
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
    
    
    public ResponseInterface updateIPH(TbBWIPH tbBwIPH){
        Statement statement = null;
        int res = 0;
       // conn = Common.getConnection();
      //  String nextId = getNextID()+"";
        SaveResponse response = new SaveResponse();
        
        queryUpdateIPH = queryUpdateIPH.replace("#APPLY_TP", "'"+tbBwIPH.getApplyTP()+"'");
        queryUpdateIPH = queryUpdateIPH.replace("#PEMOHON_ID", "'"+tbBwIPH.getPemohonId()+"'");
        queryUpdateIPH = queryUpdateIPH.replace("#PL_NO", "'"+tbBwIPH.getPlNo()+"'");
        queryUpdateIPH = queryUpdateIPH.replace("#CERT_NO", "'"+tbBwIPH.getCertNo()+"'");
        queryUpdateIPH = queryUpdateIPH.replace("#APPLY_LTTR_NO", "'"+tbBwIPH.getApplyLttrNo()+"'");
        queryUpdateIPH = queryUpdateIPH.replace("#APPLY_LTTR_SBJT", "'"+tbBwIPH.getApplyLttrSBJT()+"'");
        queryUpdateIPH = queryUpdateIPH.replace("#DOC_STAT", "'"+tbBwIPH.getDocStat()+"'");
    //    queryUpdateIPH = queryUpdateIPH.replace("#APPLY_STAT", "'"+tbBwIPH.getApplyStat()+"'");
        queryUpdateIPH = queryUpdateIPH.replace("#ADDR_CD", "'"+tbBwIPH.getAddrCd()+"'");
        queryUpdateIPH = queryUpdateIPH.replace("#ADDR_DETL", "'"+tbBwIPH.getAddrDetl()+"'");
        queryUpdateIPH = queryUpdateIPH.replace("#LD_USG_CD", "'"+tbBwIPH.getLdUsgCd()+"'");
        queryUpdateIPH = queryUpdateIPH.replace("#LD_USG_TP", "'"+tbBwIPH.getLdUsgTp()+"'");
        queryUpdateIPH = queryUpdateIPH.replace("#APLY_LD_SIZE", "'"+tbBwIPH.getApplyLdSize()+"'");
        queryUpdateIPH = queryUpdateIPH.replace("#BL_LEN", "'"+tbBwIPH.getBlLen()+"'");
        queryUpdateIPH = queryUpdateIPH.replace("#UWTO_TP", "'"+tbBwIPH.getUwtoTp()+"'");
        queryUpdateIPH = queryUpdateIPH.replace("#PMT_COND_CD", "'"+tbBwIPH.getPmtCondCd()+"'");
        queryUpdateIPH = queryUpdateIPH.replace("#RENT_PERD_YEAR", "'"+tbBwIPH.getRentPerdYear()+"'");
        queryUpdateIPH = queryUpdateIPH.replace("#LD_PRC_AMT", "'"+tbBwIPH.getLdPrcAmt()+"'");
        queryUpdateIPH = queryUpdateIPH.replace("#TOT_PRC", "'"+tbBwIPH.getTotPrice()+"'");
        queryUpdateIPH = queryUpdateIPH.replace("#BAP_AMT", "'"+tbBwIPH.getBapAmt()+"'");
        
        queryUpdateIPH = queryUpdateIPH.replace("#ASING_FLG", "'"+tbBwIPH.getAsingFlg()+"'");
        queryUpdateIPH = queryUpdateIPH.replace("#LASTUPDATED_BY", "'"+tbBwIPH.getCreatedBy()+"'");
        queryUpdateIPH = queryUpdateIPH.replace("#LASTUPDATED_TIME", "to_date('"+format.format(Common.getCurrentDate())+"','dd/MM/yyyy')");
        queryUpdateIPH = queryUpdateIPH.replace("#CUST_USERNAME", "'"+tbBwIPH.getCustUsername()+"'");
        queryUpdateIPH = queryUpdateIPH.replace("#REG_REMARK", "'"+tbBwIPH.getRegRemark()+"'");
        queryUpdateIPH = queryUpdateIPH.replace("#ID_IPH", ""+tbBwIPH.getIdIPH()+"");
       
        queryUpdateIPH = queryUpdateIPH.replace("#PEMBELI_ID", "'"+tbBwIPH.getPembeliId()+"'");
        queryUpdateIPH = queryUpdateIPH.replace("#PENJUAL_ID", "'"+tbBwIPH.getPenjualId()+"'");
        
        if(tbBwIPH.getDocDMT()!=null){
            if(tbBwIPH.getDocDMT().equalsIgnoreCase(""))
                   queryUpdateIPH = queryUpdateIPH.replace("#DOC_DMT", "null");
            else
                queryUpdateIPH = queryUpdateIPH.replace("#DOC_DMT", "to_date('"+tbBwIPH.getDocDMT()+"','dd/MM/yyyy')");
        
            }   
        else{
             queryUpdateIPH = queryUpdateIPH.replace("#DOC_DMT", "null");
            
        }
        
        if(tbBwIPH.getUwtoExpirDmt()!=null){
            if(tbBwIPH.getUwtoExpirDmt().equalsIgnoreCase(""))
                   queryUpdateIPH = queryUpdateIPH.replace("#UWTO_EXPIR_DMT", "null");
            else
                queryUpdateIPH = queryUpdateIPH.replace("#UWTO_EXPIR_DMT", "to_date('"+tbBwIPH.getUwtoExpirDmt()+"','dd/MM/yyyy')");
        
            }   
        else{
             queryUpdateIPH = queryUpdateIPH.replace("#UWTO_EXPIR_DMT", "null");
            
        }
        
   /*     if(tbBwIPH.getVrfksiDt()!=null){
            if(tbBwIPH.getVrfksiDt().equalsIgnoreCase(""))
                queryUpdateIPH = queryUpdateIPH.replace("#VRFKSI_DT", "null");
            else
                queryUpdateIPH = queryUpdateIPH.replace("#VRFKSI_DT", "to_date('"+tbBwIPH.getVrfksiDt()+"','dd/MM/yyyy')");
            }   
        else{
             queryUpdateIPH = queryUpdateIPH.replace("#VRFKSI_DT", "null");
            
        }
        
    */    
        
        if(tbBwIPH.getTglPl()!=null){
            if(tbBwIPH.getTglPl().equalsIgnoreCase(""))
                   queryUpdateIPH = queryUpdateIPH.replace("#TGL_PL", "null");
            else
            queryUpdateIPH = queryUpdateIPH.replace("#TGL_PL", "to_date('"+tbBwIPH.getTglPl()+"','dd/MM/yyyy')");
        
            }   
        else{
             queryUpdateIPH = queryUpdateIPH.replace("#TGL_PL", "null");
            
        }
        
        if(tbBwIPH.getTglCert()!=null){
            if(tbBwIPH.getTglCert().equalsIgnoreCase(""))
                   queryUpdateIPH = queryUpdateIPH.replace("#TGL_CERT", "null");
            else
            queryUpdateIPH = queryUpdateIPH.replace("#TGL_CERT", "to_date('"+tbBwIPH.getTglCert()+"','dd/MM/yyyy')");
        
            }   
        else{
             queryUpdateIPH = queryUpdateIPH.replace("#TGL_CERT", "null");
            
        }
        
        System.out.println("QUERY UPDATE IPH : "+queryUpdateIPH);
        try {
           
            conn = Common.getConnection();
            System.out.println("Start TO UPDATE");
            statement = conn.createStatement();
            
            
            res = statement.executeUpdate(queryUpdateIPH);
            System.out.println("SETELAH EKSEKUSI");
            if (res>0) {
                response.setId(tbBwIPH.getIdIPH());
                response.setStatus("SUCCESS");
                response.setStatusDesc("UPDATE SUCCESS");
            }else{
                response.setStatus("FAILED");
                response.setStatusDesc("UPDATE FAILED");
                
            }
           statement.close();
            conn.close();
             System.out.println("AFTER UPDATE");
            
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
    
    
    public ResponseInterface updateVerIPH(String date,String idIPH){
        PreparedStatement statement = null;
        int res = 0;
       // conn = Common.getConnection();
      //  String nextId = getNextID()+"";
        SaveResponse response = new SaveResponse();
        
          
       // System.out.println("QUERY UPDATE IPH : "+queryUpdateIPH);
        try {
           
            conn = Common.getConnection();
            System.out.println("Start TO UPDATE");
            statement = conn.prepareStatement(queryUpdateVerIPH);
            try {
                statement.setDate(1, Common.convertToDate(date));
            } catch (Exception ex) {
                statement.setString(1, "SYSDATE+1");
                System.out.println("EXC "+ex.toString());
           
            }
            statement.setString(2, idIPH);
            
            
            res = statement.executeUpdate();
            System.out.println("SETELAH EKSEKUSI");
            if (res>0) {
                response.setId(idIPH);
                response.setStatus("SUCCESS");
                response.setStatusDesc("UPDATE VER DATE SUCCESS");
            }else{
                response.setStatus("FAILED");
                response.setStatusDesc("UPDATE FAILED");
                
            }
           statement.close();
            conn.close();
             System.out.println("AFTER UPDATE");
            
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
    
    public ResponseInterface updateDocStatIPH(String docStat,String idIPH){
        PreparedStatement statement = null;
        int res = 0;
       // conn = Common.getConnection();
      //  String nextId = getNextID()+"";
        SaveResponse response = new SaveResponse();
        
          
      //  System.out.println("QUERY UPDATE DocStat : "+queryUpdateIPH);
        try {
           
            conn = Common.getConnection();
            System.out.println("Start TO UPDATE");
            statement = conn.prepareStatement(queryUpdateDocStatIPH);
            statement.setString(1,docStat);
            statement.setString(2, idIPH);
            
            
            res = statement.executeUpdate();
            System.out.println("SETELAH EKSEKUSI");
            if (res>0) {
                response.setId(idIPH);
                response.setStatus("SUCCESS");
                response.setStatusDesc("UPDATE DOC STAT DATE SUCCESS");
            }else{
                response.setStatus("FAILED");
                response.setStatusDesc("UPDATE FAILED");
                
            }
           statement.close();
            conn.close();
             System.out.println("AFTER UPDATE");
            
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
    
    public ResponseInterface updateApStatIPH(String apStat,String idIPH){
        PreparedStatement statement = null;
        int res = 0;
       // conn = Common.getConnection();
      //  String nextId = getNextID()+"";
        SaveResponse response = new SaveResponse();
        
          
      //  System.out.println("QUERY UPDATE DocStat : "+queryUpdateIPH);
        try {
           
            conn = Common.getConnection();
            System.out.println("Start TO UPDATE");
            statement = conn.prepareStatement(queryUpdateApStatIPH);
            statement.setString(1,apStat);
            statement.setString(2, idIPH);
            
            
            res = statement.executeUpdate();
            System.out.println("SETELAH EKSEKUSI");
            if (res>0) {
                response.setId(idIPH);
                response.setStatus("SUCCESS");
                response.setStatusDesc("UPDATE DOC STAT DATE SUCCESS");
            }else{
                response.setStatus("FAILED");
                response.setStatusDesc("UPDATE FAILED");
                
            }
           statement.close();
            conn.close();
             System.out.println("AFTER UPDATE");
            
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
    //    List<TbBW2Status> list = new ArrayList<TbBW2Status>();
        try {
            statement = Common.getConnection().createStatement();
            rs = statement.executeQuery(queryNextID);
            while (rs.next()) {
                System.out.println("NEXT ID DETECTED");
                id = rs.getString("NEXTID");
                System.out.println("ID : "+id);
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

     public List<MonitoringIPH> getMonitoring(String idIPH, String plNo, String applyStat,
             String fromDate, String toDate, String applyTp, String statVer, String creator) throws SQLException{
         
             System.out.println(""
                     + idIPH+" "+ plNo+" "+applyStat+ " "+fromDate + " "+ toDate + " "+applyTp + " "+statVer+" "+creator );
             String cond = "AND (id_iph =?\n" +
                "  or pl_no =?\n" +
                "  or apply_stat =?\n" +
                "  or (VRFKSI_DT between to_date(?,'dd/MM/yyyy') and to_date(?,'dd/MM/yyyy')\n" +
                "  ) or apply_tp  =? or EVAL_RESULT = ?)";
             
             if(idIPH!=null | plNo !=null | applyStat!=null | fromDate!=null | toDate!=null | 
                     applyTp!=null | statVer!=null){
                 
             qMonitoringIPHSearch = qMonitoringIPHSearch + " AND (";
             
             
             if(idIPH!=null){
                 qMonitoringIPHSearch = qMonitoringIPHSearch + " id_iph = '"+idIPH+"' or";
             }
             
             if(plNo!=null){
                 qMonitoringIPHSearch = qMonitoringIPHSearch + " pl_no = '"+plNo+"' or";
             }
             
             if(applyStat!=null){
                 qMonitoringIPHSearch = qMonitoringIPHSearch + " apply_stat = '"+applyStat+"'  or";
             }
             
             if(fromDate!=null & toDate!=null){
                qMonitoringIPHSearch = qMonitoringIPHSearch + " (VRFKSI_DT between to_date('"+fromDate+"','dd/MM/yyyy') and to_date('"+toDate+"','dd/MM/yyyy') or";
             
             }
             
             if(applyTp !=null){
                qMonitoringIPHSearch = qMonitoringIPHSearch + " apply_tp  ='"+applyTp+"' or";
          
             }
             
             
             if(statVer!=null){
                   qMonitoringIPHSearch = qMonitoringIPHSearch + " EVAL_RESULT = '"+statVer+"'";
           
             }
             
            
             qMonitoringIPHSearch = qMonitoringIPHSearch + ")";
             
             if(qMonitoringIPHSearch.contains("or)")){
                 qMonitoringIPHSearch = qMonitoringIPHSearch.replace("or)", ")");
                }
             
             }

             
             
             List<MonitoringIPH> monitors = new ArrayList<MonitoringIPH>();
             PreparedStatement stat = null;
             MonitoringIPH monitor = null;
             ResultSet rs = null;
             SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            
           //  System.out.println("Q "+qMonitoringIPHSearch);
             
             stat = conn.prepareStatement(qMonitoringIPHSearch);
             stat.setString(1, creator);
            
             
             
             rs = stat.executeQuery();
             
             while(rs.next()){
                 monitor = new MonitoringIPH();
                 monitor.setAlokasiYangDiminta(rs.getString("Alokasi_Yang_Diminta"));
                 monitor.setJenisPermohonan(rs.getString("Jenis_Permohonan"));
                 monitor.setNoBsw(rs.getString("No_BSW"));
                 monitor.setNoPl(rs.getString("No_PL"));
                 monitor.setStatus(rs.getString("Status"));
                 monitor.setStatusRegistrasi(rs.getString("Status_Registrasi"));
                 monitor.setButton(rs.getString("button"));
                 monitor.setCreatedBy(rs.getString("CREATED_BY"));
                 monitor.setStatusEvaluasi(rs.getString("status_evaluasi"));
                 
                 
                try{
                    monitor.setApplyTp(rs.getString("APPLY_TP"));
                     
                 }catch(Exception ex){
                    // monitor.setTglSuratMasuk("");
                    
                 }
                  try{
                    monitor.setTglSuratMasuk(dateFormat.format(rs.getDate("Tgl_Surat_Masuk")));
                     
                 }catch(Exception ex){
                     monitor.setTglSuratMasuk("");
                    
                 }
                try{
                     monitor.setVerifikasiDate(dateFormat.format(rs.getDate("VRFKSI_DT")));
                 }catch(Exception ex){
                     monitor.setVerifikasiDate("");
                 }
                 
                 monitor.setBapAmt(rs.getString("BAP_AMT"));
                
                 
                 monitors.add(monitor);
             
             }
             
             return monitors;
     }
    
     public List<MonitoringIPH> getMonitoringSort(String idIPH, String plNo, String applyStat,
             String fromDate, String toDate, String applyTp, String statVer, String creator, int tipe, String ascDesc) throws SQLException{
         
             System.out.println(""
                     + idIPH+" "+ plNo+" "+applyStat+ " "+fromDate + " "+ toDate + " "+applyTp + " "+statVer+" "+creator );
             
             System.out.println("tipe "+tipe);
             String param = sortParam(tipe,ascDesc);
             
             
             if(idIPH!=null | plNo !=null | applyStat!=null | fromDate!=null | toDate!=null | 
                     applyTp!=null | statVer!=null){
                 
             qMonitoringIPHSearch = qMonitoringIPHSearch + " AND (";
             
             
             if(idIPH!=null){
                 qMonitoringIPHSearch = qMonitoringIPHSearch + " id_iph = '"+idIPH+"' or";
             }
             
             if(plNo!=null){
                 qMonitoringIPHSearch = qMonitoringIPHSearch + " pl_no = '"+plNo+"' or";
             }
             
             if(applyStat!=null){
                 qMonitoringIPHSearch = qMonitoringIPHSearch + " apply_stat = '"+applyStat+"'  or";
             }
             
             if(fromDate!=null & toDate!=null){
                qMonitoringIPHSearch = qMonitoringIPHSearch + " (VRFKSI_DT between to_date('"+fromDate+"','dd/MM/yyyy') and to_date('"+toDate+"','dd/MM/yyyy') or";
             
             }
             
             if(applyTp !=null){
                qMonitoringIPHSearch = qMonitoringIPHSearch + " apply_tp  ='"+applyTp+"' or";
          
             }
             
             
             if(statVer!=null){
                   qMonitoringIPHSearch = qMonitoringIPHSearch + " EVAL_RESULT = '"+statVer+"'";
           
             }
             
            
             qMonitoringIPHSearch = qMonitoringIPHSearch + ")";
             
             if(qMonitoringIPHSearch.contains("or)")){
                 qMonitoringIPHSearch = qMonitoringIPHSearch.replace("or)", ")");
                }
             
             }
             
             qMonitoringIPHSearch = qMonitoringIPHSearch + " ORDER BY "+param;
             
             System.out.println("Q "+qMonitoringIPHSearch);

             List<MonitoringIPH> monitors = new ArrayList<MonitoringIPH>();
             PreparedStatement stat = null;
             MonitoringIPH monitor = null;
             ResultSet rs = null;
             SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            
             stat = conn.prepareStatement(qMonitoringIPHSearch);
             stat.setString(1, creator);
             
             
             rs = stat.executeQuery();
             
             while(rs.next()){
                 monitor = new MonitoringIPH();
                 monitor.setAlokasiYangDiminta(rs.getString("Alokasi_Yang_Diminta"));
                 monitor.setJenisPermohonan(rs.getString("Jenis_Permohonan"));
                 monitor.setNoBsw(rs.getString("No_BSW"));
                 monitor.setNoPl(rs.getString("No_PL"));
                 monitor.setStatus(rs.getString("Status"));
                 monitor.setStatusRegistrasi(rs.getString("Status_Registrasi"));
                 monitor.setButton(rs.getString("button"));
                 monitor.setStatusEvaluasi(rs.getString("status_evaluasi"));
                 
                  try{
                    monitor.setApplyTp(rs.getString("APPLY_TP"));
                     
                 }catch(Exception ex){
                    // monitor.setTglSuratMasuk("");
                    
                 }
                 try{
                    monitor.setTglSuratMasuk(dateFormat.format(rs.getDate("Tgl_Surat_Masuk")));
                     
                 }catch(Exception ex){
                     monitor.setTglSuratMasuk("");
                    
                 }
                 
                try{
                    monitor.setApplyTp(rs.getString("APPLY_TP"));
                     
                 }catch(Exception ex){
                    // monitor.setTglSuratMasuk("");
                    
                 }
                try{
                     monitor.setVerifikasiDate(dateFormat.format(rs.getDate("VRFKSI_DT")));
                 }catch(Exception ex){
                     monitor.setVerifikasiDate("");
                 }
                 
                 monitor.setBapAmt(rs.getString("BAP_AMT"));
                
                 
                 monitors.add(monitor);
             
             }
             
             
             return monitors;
     }
    

     public List<MonitoringIPH> getMonitoring(String creator) throws SQLException{
         
             List<MonitoringIPH> monitors = new ArrayList<MonitoringIPH>();
             PreparedStatement stat = null;
             MonitoringIPH monitor = null;
             ResultSet rs = null;
             
             SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            
             stat = conn.prepareStatement(qMonitoringIPHCreator);
             stat.setString(1, creator);
              
             rs = stat.executeQuery();
             
             while(rs.next()){
                 monitor = new MonitoringIPH();
                 monitor.setAlokasiYangDiminta(rs.getString("Alokasi_Yang_Diminta"));
                 monitor.setJenisPermohonan(rs.getString("Jenis_Permohonan"));
                 monitor.setNoBsw(rs.getString("No_BSW"));
                 monitor.setNoPl(rs.getString("No_PL"));
                 monitor.setStatus(rs.getString("Status"));
                 monitor.setStatusRegistrasi(rs.getString("Status_Registrasi"));
                 monitor.setButton(rs.getString("button"));
                 monitor.setCreatedBy(rs.getString("CREATED_BY"));
                 monitor.setStatusEvaluasi(rs.getString("status_evaluasi"));
                 
                 
                 try{
                    monitor.setApplyTp(rs.getString("APPLY_TP"));
                     
                 }catch(Exception ex){
                    // monitor.setTglSuratMasuk("");
                    
                 }
                 try{
                    monitor.setTglSuratMasuk(dateFormat.format(rs.getDate("Tgl_Surat_Masuk")));
                     
                 }catch(Exception ex){
                     monitor.setTglSuratMasuk("");
                    
                 }
                 
                 try{
                     monitor.setVerifikasiDate(dateFormat.format(rs.getDate("VRFKSI_DT")));
                 }catch(Exception ex){
                     monitor.setVerifikasiDate("");
                 }
                 
                 monitor.setBapAmt(rs.getString("BAP_AMT"));
                // monitor.setReg
                 monitors.add(monitor);
             
             }
             
             return monitors;
     }

     
     public List<MonitoringIPH> getMonitoringSort(String creator, int tipe, String ascDesc) throws SQLException{
         
             List<MonitoringIPH> monitors = new ArrayList<MonitoringIPH>();
             PreparedStatement stat = null;
             MonitoringIPH monitor = null;
             ResultSet rs = null;
             
             String param = sortParam(tipe,ascDesc);
             qMonitoringIPHSortCreator = qMonitoringIPHSortCreator + param;
             
             SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            
             stat = conn.prepareStatement(qMonitoringIPHSortCreator);
             stat.setString(1, creator);
              
             rs = stat.executeQuery();
             
             while(rs.next()){
                 monitor = new MonitoringIPH();
                 monitor.setAlokasiYangDiminta(rs.getString("Alokasi_Yang_Diminta"));
                 monitor.setJenisPermohonan(rs.getString("Jenis_Permohonan"));
                 monitor.setNoBsw(rs.getString("No_BSW"));
                 monitor.setNoPl(rs.getString("No_PL"));
                 monitor.setStatus(rs.getString("Status"));
                 monitor.setStatusRegistrasi(rs.getString("Status_Registrasi"));
                 monitor.setButton(rs.getString("button"));
                 monitor.setStatusEvaluasi(rs.getString("status_evaluasi"));
                 
                  try{
                    monitor.setApplyTp(rs.getString("APPLY_TP"));
                     
                 }catch(Exception ex){
                    // monitor.setTglSuratMasuk("");
                    
                 }
                 try{
                    monitor.setTglSuratMasuk(dateFormat.format(rs.getDate("Tgl_Surat_Masuk")));
                     
                 }catch(Exception ex){
                     monitor.setTglSuratMasuk("");
                    
                 }
                 
                 try{
                     monitor.setVerifikasiDate(dateFormat.format(rs.getDate("VRFKSI_DT")));
                 }catch(Exception ex){
                     monitor.setVerifikasiDate("");
                 }
                 
                 monitor.setBapAmt(rs.getString("BAP_AMT"));
                // monitor.setReg
                 monitors.add(monitor);
             
             }
             
             return monitors;
     }

     
     
     public TbBWIPH getIPH(String idIPH) throws SQLException{
            
          //   SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
         
             PreparedStatement stat = null;
             TbBWIPH tbBwIPH = new TbBWIPH();
             ResultSet rs = null;
             
             
             stat = conn.prepareStatement(queryGetIPH2);
             stat.setString(1, idIPH);
             
             String pemohonID = "";
             String penjualID = "";
             String pembeliID = "";
             String addrCd = "";
                
             String username = "";
      
             rs = stat.executeQuery();
             if(rs.next()){
                 
                 System.out.println("MASUK 1");
                 
                 tbBwIPH.setNomorUrutPemohon(rs.getString("NOMOR_URUT_PERMOHONAN"));
                 try{
                    tbBwIPH.setDateReceived(format.format(rs.getDate("DATE_RECEIVED")));
                     
                 }catch(Exception ex){
                    tbBwIPH.setDateReceived(rs.getString("DATE_RECEIVED"));
                     
                 }
                 tbBwIPH.setCertNo(rs.getString("CERT_NO"));
                  try{
                    tbBwIPH.setTglCert(format.format(rs.getDate("TGL_CERT")));
                  } catch(Exception ex){
                        tbBwIPH.setTglCert("");
                  
                  }
                
                tbBwIPH.setPlNo(rs.getString("PL_NO"));
                 
                try{
                    tbBwIPH.setTglPl(format.format(rs.getDate("TGL_PL")));
                } catch(Exception ex){
                    tbBwIPH.setTglPl("");
                }
                
                System.out.println("MASUK 2");
                 
                tbBwIPH.setNoPerjanjian(rs.getString("NO_PERJANJIAN"));
                 
                try{
                    tbBwIPH.setTglPerjanjian(format.format(rs.getDate("TGL_PERJANJIAN")));
                } catch(Exception ex){
                    tbBwIPH.setTglCert("");
                }
                
                tbBwIPH.setNoKeputusan(rs.getString("NO_KEPUTUSAN"));
                try{
                    tbBwIPH.setTglKeputusan(format.format(rs.getDate("TGL_KEPUTUSAN")));
                } catch(Exception ex){
                    tbBwIPH.setTglCert("");
                }
                
                addrCd = rs.getString("ADDR_CD");
                
               tbBwIPH.setAddrCd(addrCd);
               //  tbBwIPH.setAddrDetl(rs.getString("ADDR_DETL"));

               
               tbBwIPH.setAddrCdNM(rs.getString("ADDR_CD_NM"));
                 
               tbBwIPH.setAddrDetl(rs.getString("ADDR_DETL"));
               tbBwIPH.setLdUsgCd(rs.getString("LD_USG_CD"));
               tbBwIPH.setLdUsgCdNM(rs.getString("LD_USG_CD_NM"));
                 
               tbBwIPH.setBlLen(rs.getString("BL_LEN"));
               tbBwIPH.setLdUsgTp(rs.getString("LD_USG_TP"));
               
               try{
                    tbBwIPH.setUwtoExpirDmt(format.format(rs.getDate("UWTO_EXPIR_DMT")));
                }catch(Exception ex){
                    tbBwIPH.setUwtoExpirDmt("");
                    
                } 
               
                 
               
               
               tbBwIPH.setApplyLdSize(rs.getString("APLY_LD_SIZE"));
               tbBwIPH.setUwtoTp(rs.getString("UWTO_TP"));
               tbBwIPH.setUwtoTpNM(rs.getString("UWTO_TP_NM"));
               tbBwIPH.setIdIPH(rs.getString("ID_IPH"));
               tbBwIPH.setApplyTP(rs.getString("APPLY_TP"));
              // tbBwIPH.setApplyTP(rs.getString("APPLY_TP"));
               
               tbBwIPH.setApplyNM(rs.getString("APPLY_NM"));
               
                pemohonID = rs.getString("PEMOHON_ID");
                penjualID = rs.getString("PENJUAL_ID");
                pembeliID = rs.getString("PEMBELI_ID");
                 
               
                tbBwIPH.setPenjualId(penjualID);

                tbBwIPH.setPemohonId(pemohonID);
                tbBwIPH.setPembeliId(pembeliID);
                
                tbBwIPH.setPemohonId(pemohonID);
                 
                tbBwIPH.setPmtCondCd(rs.getString("PMT_COND_CD"));
                tbBwIPH.setPmtCondCdNM(rs.getString("PMT_COND_CD_NM"));
                
                tbBwIPH.setLdPrcAmt(rs.getString("LD_PRC_AMT"));
               // System.out.println("MASUK 3");
              
                tbBwIPH.setRentPerdYear(rs.getString("RENT_PERD_YEAR"));
                tbBwIPH.setTotPrice(rs.getString("TOT_PRC"));
                tbBwIPH.setBapAmt(rs.getString("BAP_AMT"));
                
               // System.out.println("MASUK 4");
                 
                tbBwIPH.setApplyLttrNo(rs.getString("APPLY_LTTR_NO"));
                tbBwIPH.setApplyLttrSBJT(rs.getString("APPLY_LTTR_SBJT"));
                tbBwIPH.setApplyStat(rs.getString("APPLY_STAT"));
                tbBwIPH.setRegRemark(rs.getString("REG_REMARK"));
                tbBwIPH.setRegRemarkAdmin(rs.getString("REG_REMARK_ADMIN"));
                tbBwIPH.setEvalResult(rs.getString("EVAL_RESULT"));
                
                try{
                    tbBwIPH.setDocDMT(format.format(rs.getDate("DOC_DMT")));
                }catch(Exception e){
                    tbBwIPH.setDocDMT("");
                    
                }
                
                tbBwIPH.setDocStat(rs.getString("DOC_STAT"));
                tbBwIPH.setDocStatNM(rs.getString("DOC_STAT_NM"));
                
                 try{
                    tbBwIPH.setVrfksiDt(format.format(rs.getDate("VRFKSI_DT")));
                
                } catch(Exception ex){
                    tbBwIPH.setVrfksiDt("");
                }
                 
                 username = rs.getString("CUST_USERNAME");
                 tbBwIPH.setCustUsername(username);
                 
               
             }
             
             stat.close();
             conn.close();
             
             if(tbBwIPH.getIdIPH()!=null){
                
                System.out.println("MASUK DETAIL 1");
                
                System.out.println(" "+pemohonID);
                System.out.println(" "+penjualID);
                System.out.println(" "+pembeliID);
                
                System.out.println("DATA DETLS");
                
               //  try{
                    tbBwIPH.setTbBwIPHDetls(getIPHDetl(tbBwIPH.getIdIPH()));
                // }catch(Exception ex){
                    
               // }
                 
                tbBwIPH.setTbBWPemilikAkun(TbBwCustController.getInstance().getProfileAkun(username));
                
                tbBwIPH.setTbBWCUST(TbBwCustController.getInstance().getPemohon("IPH", pemohonID));
                System.out.println("MASUK DETAIL 2");
                
                tbBwIPH.setTbBWPenjual(TbBwCustController.getInstance().getPemohon("IPH", penjualID));
                
                System.out.println("MASUK DETAIL 3");
                tbBwIPH.setTbBWPembeli(TbBwCustController.getInstance().getPemohon("IPH", pembeliID));
                
                  System.out.println("MASUK DETAIL 4");
               
                try{
                    tbBwIPH.setWilPengembangan(TbLdAddrCDController.getWilayahSubWilayah(addrCd));
                }catch(Exception ex){
                        
                } 
                
               
                
                
             }
             return tbBwIPH;
     }

     public List<TbBWIPHDetl> getIPHDetl(String idIPH){
            List<TbBWIPHDetl> list = new ArrayList<TbBWIPHDetl>();
             PreparedStatement stat = null;
             TbBWIPHDetl tbBWIPHDetl = null;
             ResultSet rs = null;
             
             System.out.println("DETL");
            
             conn = Common.getConnection();
             try{
                 
             stat = conn.prepareStatement(queryGetIPHDetl);
             stat.setString(1, idIPH);
             
             
             rs = stat.executeQuery();
             
             while(rs.next()){
                 tbBWIPHDetl = new TbBWIPHDetl();
                 tbBWIPHDetl.setIdIPH(rs.getString("ID_IPH"));
                 tbBWIPHDetl.setFileSeq(rs.getString("FILE_SEQ"));
               //  tbBWIPHDetl.setComCd(rs.getString("CD_DOCUMENT"));
                 tbBWIPHDetl.setDocTp(rs.getString("DOC_TP"));
                 tbBWIPHDetl.setDocTpNM(rs.getString("DOC_TYPE"));
                 tbBWIPHDetl.setComCd(rs.getString("COM_CD"));
                 tbBWIPHDetl.setComCdNM(rs.getString("COM_NM"));
                 tbBWIPHDetl.setCreatedBy(rs.getString("CREATED_BY"));
                 tbBWIPHDetl.setDocumentNo(rs.getString("DOCUMENT_NO"));
                 tbBWIPHDetl.setRemarks(rs.getString("REMARKS"));
                 tbBWIPHDetl.setFileTp(rs.getString("FILE_TP"));
                 
                 try{
                 tbBWIPHDetl.setExtDmt(format.format(rs.getDate("EXT_DMT")));
                     
                 }catch(Exception ex){
                     
                 }
                 tbBWIPHDetl.setFileExt(rs.getString("FILE_EXT"));
                 tbBWIPHDetl.setPhyFileNm(rs.getString("PHY_FILE_NM"));
                 tbBWIPHDetl.setFileNm(rs.getString("FILE_NM"));
                 
                 
                 list.add(tbBWIPHDetl);
             
             }
             
             stat.close();
             conn.close();
             }catch(Exception ex){
                 System.out.println("TEST "+ex.toString());
             }
             
             return list;
     }
     
     public List<TbBwIPHPemohon> getIPHPemohons(String idIPH) throws SQLException{
          List<TbBwIPHPemohon> list = new ArrayList<TbBwIPHPemohon>();
             PreparedStatement stat = null;
             TbBwIPHPemohon tbBwIPHPemohon = null;
             ResultSet rs = null;
            
             stat = conn.prepareStatement(queryGetIPHPemohon);
             stat.setString(1, idIPH);
             
             
             rs = stat.executeQuery();
             
             while(rs.next()){
                 tbBwIPHPemohon = new TbBwIPHPemohon();
                 tbBwIPHPemohon.setIdIph(rs.getString("ID_IPH"));
                 tbBwIPHPemohon.setCustTp(rs.getString("CUST_TP"));
                 tbBwIPHPemohon.setCustId(rs.getString("CUST_ID"));
                 tbBwIPHPemohon.setCustNm(rs.getString("CUST_NM"));
                 tbBwIPHPemohon.setCustNtNy(rs.getString("NATIONALITY"));
                 tbBwIPHPemohon.setCustAddr(rs.getString("CUST_ADDR"));
                 tbBwIPHPemohon.setPrgNm(rs.getString("PRG_NM"));
                 tbBwIPHPemohon.setStatus(rs.getString("STATUS"));
                 tbBwIPHPemohon.setCustEmail(rs.getString("CUST_EMAIL"));
                 tbBwIPHPemohon.setCustTelp(rs.getString("CUST_TELP"));
                 tbBwIPHPemohon.setCustCd(rs.getString("CUSTCODE"));
                 
                 
                 list.add(tbBwIPHPemohon);
             
             }
             
             return list;
     }
     
     /*
     public Date getMaxDate(String applyTpe, String tanggalDatang) { 
// get tanggal hari libur nasional, cuti nasional, dan hari yang full book
        ArrayList disableDays = new ArrayList(); 
        Connection con = null;
        Statement stmt = null;
        String select = " SELECT VRFKSI_DT, COUNT(*) FROM TBBW_IPH WHERE VRFKSI_DT >= TRUNC(SYSDATE) AND APPLY_TP = '"+applyTpe+"' " +
        " HAVING COUNT(*) >= (SELECT LIMIT FROM TBBW_IPH_CONFIG WHERE APPLY_TP = '"+applyTpe+"' ) GROUP BY VRFKSI_DT " +
        " UNION SELECT TRUNC(SYSDATE) AS VRFKSI_DT, COUNT(*) FROM DUAL " +
        " UNION select to_date(hday_dt,'yyyymmdd') AS VRFKSI_DT, count(*) from tbhr_hday_info@linkhr where to_date(hday_dt,'yyyymmdd') >= trunc(sysdate) group by hday_dt " ;

        if(tanggalDatang != null){
            select = ("SELECT * FROM ("+select+") WHERE VRFKSI_DT != to_date('"+tanggalDatang+"','yyyy-MM-dd')");
        }

        System.out.println(" select " + select);

        try{
            con = Common.getConnection();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(select);
            int i =0;
        while(rs.next()){
            try {
                DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                Date date = rs.getDate("VRFKSI_DT");
                String dateString = formatter.format(date); 
                disableDays.add(dateString.trim());
            } catch (Exception e){
                System.out.println("error"); 
            }
            i++;
        }
        rs.close(); 
        } catch (Exception e){
            e.printStackTrace();
        } finally{
            try {
                stmt.close();
                con.close();
            } catch (SQLException f) {
                 f.printStackTrace();
            }
        } 
        // get today date and today number date
        int today = 0;
        int maxDay = 2;
        int i = 0;
        String todayDate = null;
        int todayNumber = 0;
        String firstAvailableDate = null;
        System.out.println(" disableDays " + disableDays);
        while (today <= maxDay){ 
           // todayDate = getStringDate(i); 
            System.out.println(" todayDate " + todayDate);
           // todayNumber = getNumberofWeek(i); 
            if (disableDays.contains(todayDate)){
                i = i +1;
            } 
            else if (todayNumber == 7){
                i = i +1;
            }
            else if (todayNumber == 1){
                i = i +1;
            } else {
                i = i +1;
                if(today == 0){
                    firstAvailableDate = todayDate;
                }
                today = today + 1;
            }
        }
        try { 
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//            return formatter.parse(todayDate);
        } catch (Exception e) {
            e.printStackTrace();
      //      return null;
        }

        return new ;
    }
     
*/
     
     public List<String> getAvailableDate(String applyTp){
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<String> list = new ArrayList<String>();
        SimpleDateFormat simple = new SimpleDateFormat("dd/MM/yyyy");
        
        
            
         try {
           
            conn = Common.getConnection();
            
            stat = conn.prepareStatement(queryGetAvailDate);
            stat.setString(1, applyTp);
            stat.setString(2, applyTp);
            
            
            String data = "";
            Date date = null;
            rs = stat.executeQuery();
            while(rs.next()){
              date = rs.getDate("DATEVAL");
              data = simple.format(date);
              
              list.add(data);
            }
            
            stat.close();
            conn.close();
            
        } catch (Exception ex) {
            System.out.println("EXC "+ex.toString());
            try{
                conn.close();
            }catch(Exception ex2){
                System.out.println("ex "+ex2.toString());
            }
        }
         
          return list;
           
     }
     
     
     private String sortParam(int paramTipe, String ascDesc){
         String param = "";
         
         switch(paramTipe){
             case 1 :
                 param  = " US_BW.FUN_CODE_NAME(IPH.APPLY_TP) "+ascDesc;
                 break;
             case 2 :
                 param = " IPH.id_iph "+ascDesc;
                 break;
             case 3 :
                 param = " IPH.pl_no "+ascDesc;
                 break;
            case 4 :
                 param = " US_BW.GET_STATUS_EGOV_APPLY(IPH.NOMOR_URUT_PERMOHONAN) "+ascDesc;
                 break;
            case 5 :
                 param = " IPH.apply_stat "+ascDesc;
                 break;
            case 6 :
                 param = " IPH.apply_stat "+ascDesc;
                 break;
            case 7 :
                 param = "(select addr.sub_dstrt_nm from US_REF.TBLD_ADDR_CD addr where ADDR.ADDR_CD=IPH.ADDR_CD) "+ascDesc;
                 break;
            case 8 :
                param = " IPH.doc_dmt "+ascDesc;
                break;
            case 9 :
                 param = " IPH.VRFKSI_DT "+ascDesc;
                break;
            case 10 :
                param = " IPH.BAP_AMT "+ascDesc;
                
                 
         }
         return param;
     }
}
