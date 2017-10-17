/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bsw.domain.reqres;

/**
 *
 * @author Maulana Wahid Abdurrahman
 */
public interface ResponseInterface {
    
    public String getStatus();
    public void setStatus(String status);
    public String getStatusDesc();
    public void setStatusDesc(String statusDesc);
    

}
