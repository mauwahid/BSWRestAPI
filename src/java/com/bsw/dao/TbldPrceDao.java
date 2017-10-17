/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bsw.dao;

import com.bsw.domain.TarifUWTO;
import com.bsw.domain.TbldPrce;
import com.bsw.utils.Common;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Maulana Wahid Abdurrahman
 */
public class TbldPrceDao {
    
    Connection conn;
    String queryTarif = "SELECT LD_PRC_NO, " +
        "LD_PRC_AMT " +
        "FROM US_REF.TBLD_PRCE " +
        "WHERE ADDR_CD like ? || '%' " +
        "AND LD_USG_CD = ? " +
        "AND PRC_TP = ? " +
        "AND VLD_STAT = 'Y'";
    

    public static TbldPrceDao getInstance(){
        return new TbldPrceDao();
    }
    
    
    public TarifUWTO getTarifUWTO(String addrCd,
            String ldUsgCd, String prcTp, double luas, double garisPantai){
        
        PreparedStatement stat = null;
        ResultSet rs = null;
        TarifUWTO tarifUWTO = new TarifUWTO();
     //   TbldPrce tblPrc = new TbldPrce();
        
        int tarif = 0;
        
        conn = Common.getConnection();
        System.out.println("LD USG CD "+ldUsgCd);
        
        try {
            stat = conn.prepareStatement(queryTarif);
            stat.setString(1, addrCd);
            stat.setString(2, ldUsgCd);
            stat.setString(3, prcTp);
            
            rs = stat.executeQuery();
            
            while(rs.next()){
                tarif = rs.getInt("LD_PRC_AMT");
                System.out.println("TARIF "+tarif);
                
            }
            
            stat.close();
            conn.close();
        } catch (SQLException ex) {
             
            ex.printStackTrace();
        }
        
        double hitungTarif = 0;
        double bap = 0;
      //  if(!ldUsgCd.equalsIgnoreCase("")){
            hitungTarif = (tarif * luas)+ ((tarif * garisPantai) * 20);
     //   }else{
           bap  = 0.25 * hitungTarif;
     //   }
        
       /* NumberFormat nf = DecimalFormat.getInstance();
        nf.setMaximumFractionDigits(0);
        String str = nf.format(hitungTarif);
        String stringFormat = String.format("%f",hitungTarif);
        
        System.out.println("Hitung tarif "+hitungTarif);
        System.out.println("Tarif 2 "+str);
        */
         //  bap = 2.1;
         double bapCeil = Math.ceil(bap);
         long conv = (long) hitungTarif;
         long bapConv = (long) bapCeil;
         
      //   System.out.println("BAP "+bap+" round "+bapCeil);
       
        tarifUWTO.setHargaUwto(conv+"");
        tarifUWTO.setTarifM2(tarif+"");
        tarifUWTO.setBap(bapConv+"");
        
        
        return tarifUWTO;
        
    }
   
   
    public String getTarif(String addrCd,
            String ldUsgCd, String prcTp){
        
        PreparedStatement stat = null;
        ResultSet rs = null;
        TarifUWTO tarifUWTO = new TarifUWTO();
     //   TbldPrce tblPrc = new TbldPrce();
        
        int tarif = 1;
        
        conn = Common.getConnection();
        System.out.println("LD USG CD "+ldUsgCd);
        
        try {
            stat = conn.prepareStatement(queryTarif);
            stat.setString(1, addrCd);
            stat.setString(2, ldUsgCd);
            stat.setString(3, prcTp);
            
            rs = stat.executeQuery();
            
            while(rs.next()){
                tarif = rs.getInt("LD_PRC_AMT");
                System.out.println("TARIF "+tarif);
                
            }
            
            stat.close();
            conn.close();
        } catch (SQLException ex) {
             
            ex.printStackTrace();
        }
        
        return tarif+"";
        
    }
   

}
