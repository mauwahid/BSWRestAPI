/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bsw.utils;

/**
 *
 * @author Maulana Wahid Abdurrahman
 */
public class DokumenConfig {
    
    public static final int CUST_DETL = 1;
    public static final int IPH_DETL = 2;
    public static final int PEMATANGAN_DETL = 3;
    public static final int PEMATANGAN_DOC = 4;
    public static final int REKLAME_DOC = 5;
    
    
    public static String queryCustDetlDoc(){
        return "SELECT PHY_FILE_NM, FILE_EXT, FILE_TP, PHY_FILE_PATH FROM TBBW_CUST_DETL WHERE IDCUST = ? AND COM_CD = ? ";
    }
    
    public static String queryIPHDetl(){
        return "SELECT PHY_FILE_NM, FILE_EXT, FILE_TP,PHY_FILE_PATH FROM TBBW_IPH_DETL WHERE ID_IPH = ? AND DOC_TP = ? ";
    }
    
    public static String queryPematanganDetl(){
        return "SELECT PY_FILE_NM, FILE_EXT, PHY_FILE_PATH FROM TBBW_PEMATANGAN_DETL WHERE ID_PL = ? AND LICNS_PL_TYPE = ? ";
    }
    
    public static String queryPematanganDoc(){
        return "SELECT PHY_FILE_NM, FILE_EXT, FILE_TP, PHY_FILE_PATH FROM TBBW_PEMATANGAN_DOC WHERE ID_PL = ? AND COM_CD = ? ";
    }
    
    public static String queryReklameDoc(){
        return "SELECT PHY_FILE_NM, FILE_EXT, FILE_TP, PHY_FILE_PATH FROM TBBW_REKLAME_DOC WHERE ID_IR = ? AND COM_CD = ? ";
    }
    
    
    
    

}
