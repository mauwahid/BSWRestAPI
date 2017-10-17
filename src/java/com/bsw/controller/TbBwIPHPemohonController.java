/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bsw.controller;

import com.bsw.dao.TbBwIPHPemohonDao;
import com.bsw.domain.TbBwIPHPemohon;
import com.bsw.domain.reqres.ResponseInterface;
import org.apache.log4j.Logger;

/**
 *
 * @author Maulana Wahid Abdurrahman
 */
public class TbBwIPHPemohonController {

    private static final Logger logger = Logger.getLogger(TbBwIPHPemohonController.class.getName());
    
    public static TbBwIPHPemohonController getInstance(){
        return new TbBwIPHPemohonController();
    }
    
    public ResponseInterface newPemohn(String token,String custTp,
            String custId, String custNm, String custAddr, String prgNm,
            String custEmail, String custTelp, String ntnty){
        
        TbBwIPHPemohon tbBwIPHPemohon = new TbBwIPHPemohon();
        tbBwIPHPemohon.setCustId(custId);
        tbBwIPHPemohon.setCustNm(custNm);
        tbBwIPHPemohon.setCustTp(custTp);
        tbBwIPHPemohon.setCustAddr(custAddr);
        tbBwIPHPemohon.setPrgNm(prgNm);
        tbBwIPHPemohon.setCustEmail(custEmail);
        tbBwIPHPemohon.setCustTelp(custTelp);
        tbBwIPHPemohon.setNtnty(ntnty);
        
        System.out.println("cstId "+custId);
        System.out.println("custNm "+custNm);
        System.out.println("custAddr "+custAddr);
        System.out.println("prgNm "+prgNm);
        System.out.println("custEmail "+custEmail);
        System.out.println("custTelp "+custTelp);
        
        return TbBwIPHPemohonDao.getInstance().newPemohon(tbBwIPHPemohon);
        
    }
    
    
}
