/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsw.dao;

import com.bsw.utils.TbComTMPConfig;
import com.bsw.domain.TbComTMP;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hansome
 */
public class TbComTMPDao {
    private Connection connection;
    
    public TbComTMPDao(Connection conn){
        connection = conn;
    }
    
    public List<TbComTMP> getTbComTMP(int type){
        Statement statement = null;
        ResultSet rs = null;
        List<TbComTMP> list = new ArrayList<TbComTMP>();
            
        try {
           
            statement = connection.createStatement();
            rs = statement.executeQuery(queryGenerator(type));
            TbComTMP tbComTMP = null;
            while (rs.next()) {
                tbComTMP = new TbComTMP();
                tbComTMP.setComCd(rs.getString("COM_CD"));
                tbComTMP.setCdNm(rs.getString("CD_NM"));
                tbComTMP.setUseYN(rs.getString("USE_YN"));
                tbComTMP.setCdDesc(rs.getString("CD_DESC"));
                tbComTMP.setDispSeq(rs.getString("DISP_SEQ"));
                tbComTMP.setRegDMT(rs.getString("REG_DMT"));
                tbComTMP.setRegEMPID(rs.getString("REG_EMP_ID"));
                tbComTMP.setChgDMT(rs.getString("CHG_DMT"));
                tbComTMP.setChgEmpID(rs.getString("CHG_EMP_ID"));
                list.add(tbComTMP);
            }
            statement.close();
          
        } catch (SQLException exception) {
            System.out.println("EXC "+exception.toString());
            
            try {
                statement.close();
                connection.close();
                
            } catch (SQLException ex) {
                System.out.println("EXC "+ex.toString());
           
            }
        } 
        return list;
        
    }
    
    private String queryGenerator(int type){
        
        String query = "";
        switch(type){
            case TbComTMPConfig.CURRENCY :
                query = TbComTMPConfig.getCurrencySQL();
                break;
            case TbComTMPConfig.BANK_CODE :
                query = TbComTMPConfig.getBankCodeSQL();
                break;
            case TbComTMPConfig.UNIT_CODE :
                query = TbComTMPConfig.getUnitCodeSQL();
                break;
            case TbComTMPConfig.SERVICE_TYPE :
                query = TbComTMPConfig.getServiceTypeSQL();
                break;
            case TbComTMPConfig.USAHA_LIST :
                query = TbComTMPConfig.getUsahaListSQL();
                break;
            case TbComTMPConfig.BUDGET_TYPE :
                query = TbComTMPConfig.getBudgetTypeSQL();
                break;
            case TbComTMPConfig.PAYMENT_METHOD :
                query = TbComTMPConfig.getPaymentMethodSQL();
                break;
            case TbComTMPConfig.EXCHANGE_RATE :
                query = TbComTMPConfig.getExchageRateSQL();
                break;
            case TbComTMPConfig.PERIOD_TYPE :
                query = TbComTMPConfig.getPeriodTypeSQL();
                break;
            case TbComTMPConfig.AREA :
                query = TbComTMPConfig.getAreaSQL();
                break;
            case TbComTMPConfig.DR_CR_TYPE :
                query = TbComTMPConfig.getDRCRSQL();
                break;
            case TbComTMPConfig.TYPE_PENYEWA :
                query = TbComTMPConfig.getTypePenyewaSQL();
                break;
            case TbComTMPConfig.PENGGUNAAN_LAHAN :
                query = TbComTMPConfig.getPenggunaanLahanSQL();
                break;
            case TbComTMPConfig.KONDISI_PEMBAYARAN :
                query = TbComTMPConfig.getKondisiPembayaranSQL();
                break;
            case TbComTMPConfig.BUSSINESS_TYPE :
                query = TbComTMPConfig.getBussinessTypeSQL();
                break;
            case TbComTMPConfig.DOC_TYPE :
                query = TbComTMPConfig.getDocTypeSQL();
                break;
            case TbComTMPConfig.TYPE_PEMOHON :
                query = TbComTMPConfig.getTypePemohon();
                break;
            case TbComTMPConfig.CARA_UWTO :
                query = TbComTMPConfig.getCaraUWTO();
                break;
            case TbComTMPConfig.TIPE_UWTO :
                query = TbComTMPConfig.getTipeUWTO();
                break;
            case TbComTMPConfig.STATUS_VER :
                query = TbComTMPConfig.getStatusVer();
                break;
            case TbComTMPConfig.JENIS_PERMOHONAN :
                query = TbComTMPConfig.getJenisPermohonan();
                break;
            case TbComTMPConfig.TIPE_PEMATANGAN :
                query = TbComTMPConfig.getTipePematangan();
                break;
            case TbComTMPConfig.TIPE_LOKASI_PEMATANGAN :
                query = TbComTMPConfig.getTipeLokasiPematangan();
                break;
        }
        return query;
    }
    
    
}
