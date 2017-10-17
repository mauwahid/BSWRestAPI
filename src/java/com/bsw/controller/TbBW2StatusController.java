/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bsw.controller;

import com.bsw.dao.DaoManager;
import com.bsw.domain.TbBW2Status;
import java.util.List;

/**
 *
 * @author Maulana Wahid Abdurrahman
 */
public class TbBW2StatusController {

     public static List<TbBW2Status> getCurrency(){
        return DaoManager.getTbBW2Status().getStatus();
    }
}
