/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bsw.controller;

import com.bsw.dao.TbBwIPHStatRegDao;
import com.bsw.domain.TbBwIPHStatReg;
import java.util.List;

/**
 *
 * @author Maulana Wahid Abdurrahman
 */
public class TbBwIPHStatRegController {

    public static TbBwIPHStatRegController getInstance(){
        return new TbBwIPHStatRegController();
    }
    
    public List<TbBwIPHStatReg> getIPHStatReg(){
        return TbBwIPHStatRegDao.getInstance().getIPHStatReg();
    }
}
