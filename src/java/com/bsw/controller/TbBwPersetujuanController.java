/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bsw.controller;

import com.bsw.dao.TbBwPersetujuanDao;
import com.bsw.domain.reqres.ResponseInterface;

/**
 *
 * @author Maulana Wahid Abdurrahman
 */
public class TbBwPersetujuanController {

    public static TbBwPersetujuanController getInstance(){
        return new TbBwPersetujuanController();
    }
    
    public ResponseInterface approvePersetujuan(String name,String type, String application,
            String username,  String company){
        return TbBwPersetujuanDao.getInstance().savePersetujuan(name, type, application, username, company);
    }
    
    public ResponseInterface cekPersetujuan(String name,String type, String application,
            String company){
        return TbBwPersetujuanDao.getInstance().cek(name, type, application, company);
    }
}
