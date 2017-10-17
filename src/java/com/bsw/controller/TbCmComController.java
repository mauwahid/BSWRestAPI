/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bsw.controller;

import com.bsw.dao.DaoManager;
import com.bsw.domain.TbBwCust;
import com.bsw.domain.TbCmCom;
import com.bsw.domain.reqres.ResponseInterface;
import java.util.List;

/**
 *
 * @author Maulana Wahid Abdurrahman
 */
public class TbCmComController {

     public static TbCmComController getInstance(){
        return new TbCmComController();
    }
    
    public  List<TbCmCom> getMenu(){
         return DaoManager.getTbCmComDao().getMenuAlokasiLahan();
    }
    
    public  List<TbCmCom> getDocMapping(String regTp, String applTp){
         return DaoManager.getTbCmComDao().getDocMapping(regTp, applTp);
    }
    
    
}
