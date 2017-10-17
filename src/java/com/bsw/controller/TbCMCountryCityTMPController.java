/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bsw.controller;

import com.bsw.dao.DaoManager;
import com.bsw.domain.TbCMCountryCityTMP;
import com.bsw.domain.TbComTMP;
import com.bsw.utils.TbComTMPConfig;
import java.util.List;

/**
 *
 * @author Maulana Wahid Abdurrahman
 */
public class TbCMCountryCityTMPController {

    public static List<TbCMCountryCityTMP> getCountry(){
        return DaoManager.getTBCMCountryCityTMPDao().getCountry();
    }
}
