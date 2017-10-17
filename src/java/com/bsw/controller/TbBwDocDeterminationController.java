/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bsw.controller;

import com.bsw.dao.TbBWDocDeterminationDao;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author Maulana Wahid Abdurrahman
 */
public class TbBwDocDeterminationController {
    
     private static final Logger logger = Logger.getLogger(TbBwDocDeterminationController.class.getName());
   

    public static TbBwDocDeterminationController getInstance(){
        return new TbBwDocDeterminationController();
    }
    
    public List getDocs(String idAppList){
        return TbBWDocDeterminationDao.getInstance().getListDocs(idAppList);
    }
}
