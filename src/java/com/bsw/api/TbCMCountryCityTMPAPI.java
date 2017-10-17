/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bsw.api;

import com.bsw.controller.TbCMCountryCityTMPController;
import com.bsw.domain.TbCMCountryCityTMP;
import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author Maulana Wahid Abdurrahman
 */
@Stateless
@Path("country")
public class TbCMCountryCityTMPAPI {

    @GET
    @Produces("application/json")
    public List<TbCMCountryCityTMP> getCountry(){
        return TbCMCountryCityTMPController.getCountry();
    }
}
