/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bsw.controller;

import com.bsw.dao.TbBwPengumumanDao;
import java.util.List;

/**
 *
 * @author Maulana Wahid Abdurrahman
 */
public class TbBwPengumumanController {

    public static TbBwPengumumanController getInstance(){
        return new TbBwPengumumanController();
    }
    
    public List getPengumumans(){
        return TbBwPengumumanDao.getInstance().getPengumuman();
    }
}
