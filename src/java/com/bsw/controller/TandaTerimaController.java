/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bsw.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import org.apache.log4j.Logger;

/**
 *
 * @author Maulana Wahid Abdurrahman
 * 
 */
public class TandaTerimaController {
    
    private static final Logger logger = Logger.getLogger(TandaTerimaController.class.getName());
   
    public static TandaTerimaController getInstance(){
        return new TandaTerimaController();
    }
    
    public File generateStream(
            String token,
            String jenisPerizinan, String noBSW,
            String noIzin, String dataPemilikAkun,
            String jenisPermohonan, String pemohon,
            String noSurat, String tglRegistrasi,
            String tglVerifikasi){
            InputStream template = TandaTerimaController.class.getResourceAsStream("/report1.jrxml");
        // compile the report from the stream
        
        //TandaTerimaController.class.getRes
        
        JasperReport report = null;
        try {
            report = JasperCompileManager.compileReport(template);
           // report = (JasperReport) JRLoader.loadObject(template);
        } catch (Exception ex) {
            logger.error("JASPER ERROR : "+ex.getMessage());
        }
        // fill out the report into a print object, ready for export. 
        Map params = new HashMap<String,String>();
        params.put("jenis_perizinan", jenisPerizinan);
        params.put("no_bsw", noBSW);
        params.put("no_izin", noIzin);
        params.put("data_pemilik_akun", dataPemilikAkun);
        params.put("jenis_permohonan",jenisPermohonan);
        params.put("pemohon", pemohon);
        params.put("no_surat", noSurat);
        params.put("tgl_reg", tglRegistrasi);
        params.put("tgl_verifikasi", tglVerifikasi);
        
        JasperPrint print = null;
        try {
            print = JasperFillManager.fillReport(report, params);
        } catch (JRException ex) {
              logger.error("JASPER ERROR : "+ex.getMessage());
          }
        // export it!
        File pdf = null;
        try {
            pdf = File.createTempFile("TandaTerima_", ".pdf");
        } catch (IOException ex) {
               logger.error("CREATE FILE JASPER ERROR : "+ex.getMessage());
         }
        try {
            JasperExportManager.exportReportToPdfStream(print, new FileOutputStream(pdf));
        } catch (Exception ex) {
              logger.error("EXPORT JASPER ERROR : "+ex.getMessage());
          }
        
        return pdf;
    }
    
}
