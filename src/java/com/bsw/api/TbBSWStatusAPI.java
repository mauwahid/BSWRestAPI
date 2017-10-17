/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bsw.api;

import com.bsw.controller.TbBW2StatusController;
import com.bsw.controller.TbComTMPController;
import com.bsw.domain.TbBW2Status;
import com.bsw.domain.TbComTMP;
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
@Path("status")
public class TbBSWStatusAPI {

    @GET
    @Produces("application/json")
    public List<TbBW2Status> getStatus(){
        return TbBW2StatusController.getCurrency();
    }
}
