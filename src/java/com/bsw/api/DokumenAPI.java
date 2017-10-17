/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bsw.api;

import com.bsw.controller.DokumenController;
import com.bsw.controller.TandaTerimaController;
import com.bsw.controller.TbBW2StatusController;
import com.bsw.domain.DocBase64;
import com.bsw.domain.TbBW2Status;
import com.sun.jersey.core.util.Base64;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

/**
 * REST WS FOR GENERATE DOKUMENT
 * @author Maulana Wahid Abdurrahman
 */
@Stateless
@Path("dokumen")
public class DokumenAPI {

    
    /**
    * GET REQUEST FOR GENERATE DOKUMENT TANDA TERIMA
    * @author Maulana Wahid Abdurrahman
    * 
    * @param jnsPerizinan 
    * @param noBsw
    * @param noIzin
    * @param dtPmlkAkn
    * @param jnsPrmhonan
    * @param pemohon
    * @param noSurat
    * @param tglReg
    * @param tglVer
    * @return PDF Tanda Terima
    */
    @GET
    @Path("tandaterima")
    @Produces("application/pdf")
    public Response getTandaTerima(
     @QueryParam("token")String token,
            @QueryParam("jnsPerizinan")String jenisPerizinan,
            @QueryParam("noBsw")String noBSW,
            @QueryParam("noIzin")String noIzin, 
            @QueryParam("dtPmlkAkn")String dataPemilikAkun,
            @QueryParam("jnsPrmhonan")String jenisPermohonan,
            @QueryParam("pemohon")String pemohon,
            @QueryParam("noSurat")String noSurat, 
            @QueryParam("tglReg")String tglReg,
            @QueryParam("tglVer")String tglVerifikasi){
        
        File file = TandaTerimaController.getInstance().generateStream(token, jenisPerizinan, noBSW, noIzin, dataPemilikAkun, jenisPermohonan, pemohon, noSurat, tglReg, tglVerifikasi);
        ResponseBuilder response = Response.ok((Object) file);
        SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyyMMddHHmmSS");
        String fileName = "TandaTerima_"+dataPemilikAkun+"_"+simpleFormat.format(new Date());
        
        response.header("Content-Disposition",
                        "attachment; filename="+fileName+".pdf");
        return response.build();
    }
    
    
 //   private static final String FILE_PATH = "c:\\file.log";

	@GET
	@Path("/get") 
        @Produces({"image/png,image/jpeg,application/pdf,application/vnd.ms-word"})
        public Response getFile(
        @QueryParam("token")String token,
        @QueryParam("tipe")int tipe,
        @QueryParam("id")String id,
        @QueryParam("code")String code) {

            HashMap map = DokumenController.getInstance().getDocumentLocation(tipe, id, code);
            
              if(map.get("file_path")!=null){
                  
                  if(map.get("file_path").toString().equalsIgnoreCase("")){
               //     ResponseBuilder response = Response.
                    System.out.println("GAK ADA FILE PATH");
                    return Response.serverError().build();
                    }
                
                String fileName = map.get("file_name").toString();
                String path = map.get("file_path").toString() + "/" + fileName;
                String fileTp = map.get("file_tp").toString();
                
                if(fileTp.equalsIgnoreCase("jpg")|fileTp.equalsIgnoreCase("jpeg")){
                    fileTp = "image/jpeg";
                }else if(fileTp.equalsIgnoreCase("png")){
                    fileTp = "image/png";
                }else if(fileTp.equalsIgnoreCase("pdf")){
                    fileTp = "application/pdf";
                }else if(fileTp.equalsIgnoreCase("doc")|fileTp.equalsIgnoreCase("docx")){
                    fileTp = "application/msword";
                }
                String ext = map.get("file_ext").toString();
                
                System.out.println("path "+path);
                System.out.println("tipe "+fileTp);
                System.out.println("name "+fileName);
		File file = new File(path);

		ResponseBuilder response = Response.ok((Object) file);
	//	 response.header("Content-Disposition",
          //             "attachment; filename="+fileName+"");
                response.header("Content-Disposition",
                        "Content-Type = "+fileTp+"; filename="+fileName+"");
                response.header("Content-Type",fileTp);
                return response.build(); 
               
              }else{
                  ResponseBuilder response = Response.noContent();
	//	
                return response.build();
              }
                

	}
        
        @GET
	@Path("/getbase64") 
        @Produces("application/json")
        public DocBase64 getBase64(
        @QueryParam("token")String token,
        @QueryParam("tipe")int tipe,
        @QueryParam("id")String id,
        @QueryParam("code")String code) {

            
                HashMap map = DokumenController.getInstance().getDocumentLocation(tipe, id, code);
            
                if(map.get("file_path").toString().equalsIgnoreCase("")){
               //     ResponseBuilder response = Response.
                    System.out.println("GAK ADA FILE PATH");
                    return new DocBase64();
                }
                
               
                String fileName = map.get("file_name").toString();
                String uriFile = map.get("file_path").toString() + "/" + fileName;
             //   String ext = map.get("file_ext").toString();
		//File file = new File(path);
                
                java.nio.file.Path path = Paths.get(uriFile);
                byte[] data = null;
                try {
                    data = Files.readAllBytes(path);
                } catch (IOException ex) {
                    Logger.getLogger(DokumenAPI.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                byte[] base64 = null;
                base64 = Base64.encode(data);
                
                DocBase64 docBase = new DocBase64();
                docBase.setType(map.get("file_tp").toString());
                docBase.setDoc64(base64.toString());
                
                return docBase;

	}
}
