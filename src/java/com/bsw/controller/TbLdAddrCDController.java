/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bsw.controller;

import com.bsw.dao.DaoManager;
import com.bsw.domain.TbBW2Status;
import com.bsw.domain.TbComTMP;
import com.bsw.domain.TbLdAddrCD;
import java.util.List;

/**
 *
 * @author Maulana Wahid Abdurrahman
 */
public class TbLdAddrCDController {
    
    public static List<TbLdAddrCD> getWilayah(){
        return DaoManager.getTbLdAddrCDDao().getWilayah();
    }
    
    public static List<TbLdAddrCD> getSubWilayah(String param){
        return DaoManager.getTbLdAddrCDDao().getSubWilayah(param);
    }
    
    public static List<TbLdAddrCD> getLokasi(String subWilNm, String dstrt){
        return DaoManager.getTbLdAddrCDDao().getLokasi(subWilNm,dstrt);
    }
    
    public static List<TbComTMP> getWilayahPengembangan(){
        return DaoManager.getTbLdAddrCDDao().getWilayahPengembangan();
    }
    
    public static TbComTMP getWilayahPengembanganByWil(String wilayah){
        return DaoManager.getTbLdAddrCDDao().getWilayahPengembanganByWilayah(wilayah);
    }
    
    public static List<TbLdAddrCD> getLokasiCode(){
        return DaoManager.getTbLdAddrCDDao().getLokasiCode();
    }
    
    public static TbLdAddrCD getWilayahSubWilayah(String addrCd){
        return DaoManager.getTbLdAddrCDDao().getWilayahSubWilayah(addrCd);
    }

}
