/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsw.utils;

/**
 *
 * @author Hansome
 */
public class TbComTMPConfig {
    
    public static final int CURRENCY = 1;
    public static final int BANK_CODE = 2;
    public static final int UNIT_CODE = 3;
    public static final int SERVICE_TYPE = 4;
    public static final int USAHA_LIST = 5;
    public static final int BUDGET_TYPE = 6;
    public static final int PAYMENT_METHOD = 7;
    public static final int EXCHANGE_RATE = 8;
    public static final int PERIOD_TYPE = 9;
    public static final int AREA = 10;
    public static final int DR_CR_TYPE = 11;
    public static final int TYPE_PENYEWA = 12;
    public static final int PENGGUNAAN_LAHAN = 13;
    public static final int KONDISI_PEMBAYARAN = 14;
    public static final int BUSSINESS_TYPE = 15;
    public static final int DOC_TYPE = 16;
    public static final int TYPE_PEMOHON = 17;
    public static final int CARA_UWTO = 18;
    public static final int TIPE_UWTO = 19;
    public static final int STATUS_VER = 20;
    public static final int JENIS_PERMOHONAN = 21;
    public static final int TIPE_PEMATANGAN = 22;
    public static final int TIPE_LOKASI_PEMATANGAN = 23;
    
    
    public static String getCurrencySQL(){
        return "select * from TBCM_COM_TMP\n" +
        " where COM_CD like 'A10%' and USE_YN = 'Y' and DISP_SEQ <> '0'";
    }
    
    public static String getBankCodeSQL(){
        return "select * from TBCM_COM_TMP\n" +
        " where COM_CD like 'A11%' and USE_YN = 'Y' and DISP_SEQ <> '0'";
    }
    
    public static String getUnitCodeSQL(){
        return "select * from TBCM_COM_TMP\n" +
        " where COM_CD like 'A12%' and USE_YN = 'Y' and DISP_SEQ <> '0'";
    }
    
    public static String getServiceTypeSQL(){
        return "select * from TBCM_COM_TMP\n" +
        " where COM_CD like 'A14%' and USE_YN = 'Y' and DISP_SEQ <> '0'";
    }
    
    public static String getUsahaListSQL(){
        return "select * from TBCM_COM_TMP\n" +
        " where COM_CD like 'A18%' and USE_YN = 'Y' and DISP_SEQ <> '0' ORDER BY CD_NM ASC";
    }
    
    public static String getBudgetTypeSQL(){
        return "select * from TBCM_COM_TMP\n" +
        " where COM_CD like 'A19%' and USE_YN = 'Y' ORDER BY CD_NM ASC";
    }
    
    public static String getPaymentMethodSQL(){
        return "select * from TBCM_COM_TMP\n" +
        " where COM_CD like 'A31%' and USE_YN = 'Y' and CD_TP <> 'C' ORDER BY CD_NM ASC";
    }
    
    public static String getExchageRateSQL(){
        return "select * from TBCM_COM_TMP\n" +
        " where COM_CD like 'A32%' and USE_YN = 'Y' and CD_TP <> 'C' ORDER BY CD_NM ASC";
    }
    
    public static String getPeriodTypeSQL(){
        return "select * from TBCM_COM_TMP\n" +
        " where COM_CD like 'A37%' and USE_YN = 'Y' and DISP_SEQ <> '0' ORDER BY CD_NM ASC";
    }
    
    public static String getAreaSQL(){
        return "select * from TBCM_COM_TMP\n" +
        " where COM_CD like 'A38%' and USE_YN = 'Y' and DISP_SEQ <> '0' ORDER BY CD_NM ASC";
    }
    
    public static String getDRCRSQL(){
        return "select * from TBCM_COM_TMP\n" +
        " where COM_CD like 'A42%' and USE_YN = 'Y' and DISP_SEQ <> '0' ORDER BY CD_NM ASC";
    }
    
    public static String getTypePenyewaSQL(){
        return "select * from US_REF.TBCM_COM\n" +
        " where COM_CD like 'D01%' and USE_YN = 'Y' and DISP_SEQ <> '0' ORDER BY DISP_SEQ ASC";
    }
    
    public static String getPenggunaanLahanSQLOld(){
        return "select * from US_REF.TBCM_COM\n" +
        " where COM_CD like 'D04%' and USE_YN = 'Y' and DISP_SEQ <> '0' ORDER BY DISP_SEQ ASC"; 
    }
    
    public static String getPenggunaanLahanSQLOld2(){
        return "select * from US_REF.TBCM_COM" +
        " where COM_CD like 'D7%' and USE_YN = 'Y' and DISP_SEQ <> '0' and CD_TP = 'B' ORDER BY CD_NM ASC"; 
    }
    
     public static String getPenggunaanLahanSQL(){
        return "SELECT '' as CD_TP, '' as USE_YN, '' as CD_DESC,\n" +
"'' as DISP_SEQ, '' as REG_DMT, '' as REG_EMP_ID, '' as CHG_DMT, '' as CHG_EMP_ID , A.COM_CD, B.CD_NM || ' - ' || A.CD_NM CD_NM  \n" +
"FROM (SELECT COM_CD, CD_NM FROM US_REF.TBCM_COM WHERE COM_CD LIKE 'D7%' AND CD_TP = 'B' AND USE_YN = 'Y' ORDER BY COM_CD) A, (SELECT COM_CD, CD_NM FROM US_REF.TBCM_COM WHERE COM_CD LIKE 'D7%' AND CD_TP = 'A') B \n" +
"WHERE SUBSTR(A.COM_CD,1,3) = SUBSTR(B.COM_CD,1,3) ORDER BY A.COM_CD"; 
    }
    
    public static String getKondisiPembayaranSQL(){
        return "select * from US_REF.TBCM_COM\n" +
        " where COM_CD like 'D06%' and USE_YN = 'Y' and DISP_SEQ <> '0' ORDER BY DISP_SEQ ASC";
    }
    
    public static String getBussinessTypeSQL(){
        return "select * from US_REF.TBCM_COM\n" +
        " where COM_CD like 'Z05%' AND USE_YN = 'Y' AND CD_TP <> 'A' ORDER BY CD_NM ASC";
    }
    
    public static String getDocTypeSQL(){
        return "select * from US_REF.TBCM_COM\n" +
        " where COM_CD like 'D09%' AND USE_YN = 'Y' AND CD_TP <> 'A' ORDER BY CD_NM ASC";
    }
    
    public static String getTypePemohon(){
        return "select * from US_REF.TBCM_COM\n" +
        " where COM_CD like 'Z03%' and USE_YN = 'Y' and DISP_SEQ <> '0' ORDER BY COM_CD ASC";
    }
    
    public static String getCaraUWTO(){
        return "select * from US_REF.TBCM_COM " +
        " where COM_CD like 'D06%' and USE_YN = 'Y' and DISP_SEQ <> '0' ORDER BY COM_CD ASC";
    }
    
    public static String getTipeUWTO(){
        return "select * from US_REF.TBCM_COM " +
        " where COM_CD like 'D5%' and USE_YN = 'Y' and DISP_SEQ <> '0' ORDER BY DISP_SEQ ASC";
    }
    
     public static String getStatusVer(){
        return "select * from US_REF.TBCM_COM " +
        " where COM_CD like 'D120%' and USE_YN = 'Y' and DISP_SEQ <> '0' ORDER BY DISP_SEQ ASC";
    }
     
    public static String getJenisPermohonan(){
        return "select * from US_REF.TBCM_COM " +
        " where COM_CD like 'D220%' and USE_YN = 'Y' and DISP_SEQ <> '0' ORDER BY DISP_SEQ ASC";
    }
    
    public static String getTipePematangan(){
        return "select * from US_REF.TBCM_COM " +
        " where COM_CD like 'D29%' and USE_YN = 'Y' and DISP_SEQ <> '0' ORDER BY DISP_SEQ ASC";
    }
    
    public static String getTipeLokasiPematangan(){
        return "select * from US_REF.TBCM_COM " +
        " where COM_CD like 'D31%' and USE_YN = 'Y' and DISP_SEQ <> '0' ORDER BY DISP_SEQ ASC";
    }
    
    
}
