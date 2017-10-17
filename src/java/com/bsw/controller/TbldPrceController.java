/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bsw.controller;

import com.bsw.dao.TbldPrceDao;
import com.bsw.domain.TarifUWTO;

/**
 *
 * @author Maulana Wahid Abdurrahman
 */
public class TbldPrceController {

    public static TbldPrceController getInstance(){
        return new TbldPrceController();
    }
    
    public TarifUWTO getTarifUWTO(String addrCd,
            String ldUsgCd, String prcTp, double luas, double garisPantai){
        return TbldPrceDao.getInstance().getTarifUWTO(addrCd, ldUsgCd, prcTp, luas, garisPantai);
    }
    
    public String getTarif(String addrCd,
            String ldUsgCd, String prcTp){
        return TbldPrceDao.getInstance().getTarif(addrCd, ldUsgCd, prcTp);
    }
}
