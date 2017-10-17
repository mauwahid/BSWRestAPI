/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsw.controller;

import com.bsw.utils.TbComTMPConfig;
import com.bsw.dao.DaoManager;
import com.bsw.domain.TbComTMP;
import java.util.List;

/**
 *
 * @author Maulana Wahid Abdurrahman
 */
public class TbComTMPController {
    
    public static List<TbComTMP> getCurrency(){
        return DaoManager.getTbComTMPDao().getTbComTMP(TbComTMPConfig.CURRENCY);
    }
    
    public static List<TbComTMP> getBankCode(){
        return DaoManager.getTbComTMPDao().getTbComTMP(TbComTMPConfig.BANK_CODE);
    }
    
    public static List<TbComTMP> getUnitCode(){
        return DaoManager.getTbComTMPDao().getTbComTMP(TbComTMPConfig.UNIT_CODE);
    }
    
    public static List<TbComTMP> getServiceType(){
        return DaoManager.getTbComTMPDao().getTbComTMP(TbComTMPConfig.SERVICE_TYPE);
    }
    
    public static List<TbComTMP> getUsahaList(){
        return DaoManager.getTbComTMPDao().getTbComTMP(TbComTMPConfig.USAHA_LIST);
    }
    
    public static List<TbComTMP> getBudgetType(){
        return DaoManager.getTbComTMPDao().getTbComTMP(TbComTMPConfig.BUDGET_TYPE);
    }
    
    public static List<TbComTMP> getPaymentMethod(){
        return DaoManager.getTbComTMPDao().getTbComTMP(TbComTMPConfig.PAYMENT_METHOD);
    }
    
    public static List<TbComTMP> getExchangeRateType(){
        return DaoManager.getTbComTMPDao().getTbComTMP(TbComTMPConfig.EXCHANGE_RATE);
    }
    
    public static List<TbComTMP> getPeriodType(){
        return DaoManager.getTbComTMPDao().getTbComTMP(TbComTMPConfig.PERIOD_TYPE);
    }
    
    public static List<TbComTMP> getArea(){
        return DaoManager.getTbComTMPDao().getTbComTMP(TbComTMPConfig.AREA);
    }
    
    public static List<TbComTMP> getDRCRType(){
        return DaoManager.getTbComTMPDao().getTbComTMP(TbComTMPConfig.DR_CR_TYPE);
    }
    
    public static List<TbComTMP> getTypePenyewa(){
        return DaoManager.getTbComTMPDao().getTbComTMP(TbComTMPConfig.TYPE_PENYEWA);
    }
    
    public static List<TbComTMP> getPenggunaanLahan(){
        return DaoManager.getTbComTMPDao().getTbComTMP(TbComTMPConfig.PENGGUNAAN_LAHAN);
    }
    
    public static List<TbComTMP> getKondisiPembayaran(){
        return DaoManager.getTbComTMPDao().getTbComTMP(TbComTMPConfig.KONDISI_PEMBAYARAN);
    }
    
    public static List<TbComTMP> getBussinessType(){
        return DaoManager.getTbComTMPDao().getTbComTMP(TbComTMPConfig.BUSSINESS_TYPE);
    }
    
    public static List<TbComTMP> getDocumentType(){
        return DaoManager.getTbComTMPDao().getTbComTMP(TbComTMPConfig.DOC_TYPE);
    }
    
    public static List<TbComTMP> getTipePemohon(){
        return DaoManager.getTbComTMPDao().getTbComTMP(TbComTMPConfig.TYPE_PEMOHON);
    }

    
    public static List<TbComTMP> getCaraUWTO(){
        return DaoManager.getTbComTMPDao().getTbComTMP(TbComTMPConfig.CARA_UWTO);
    }
    
    public static List<TbComTMP> getTipeUWTO(){
        return DaoManager.getTbComTMPDao().getTbComTMP(TbComTMPConfig.TIPE_UWTO);
    }
    
    public static List<TbComTMP> getStatusVer(){
        return DaoManager.getTbComTMPDao().getTbComTMP(TbComTMPConfig.STATUS_VER);
    }
    
    public static List<TbComTMP> getJenisPermohonan(){
        return DaoManager.getTbComTMPDao().getTbComTMP(TbComTMPConfig.JENIS_PERMOHONAN);
    }
    
    public static List<TbComTMP> getTipePematangan(){
        return DaoManager.getTbComTMPDao().getTbComTMP(TbComTMPConfig.TIPE_PEMATANGAN);
    }
    
     public static List<TbComTMP> getTipeLokasiPematangan(){
        return DaoManager.getTbComTMPDao().getTbComTMP(TbComTMPConfig.TIPE_LOKASI_PEMATANGAN);
    }
  
    
}
