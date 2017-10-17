/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsw.utils;

import com.bsw.controller.TbBwCustController;
import com.bsw.domain.StringPath;
import com.bsw.domain.reqres.StatusResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import weblogic.auddi.util.Logger;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;
import java.util.Properties;
import java.util.logging.Level;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import org.apache.log4j.Logger;

/**
 *
 * @author Hansome
 */
public class Common {

    private static final Logger logger = Logger.getLogger(Common.class.getName());
   
    InputStream input = null;
   
    public static Connection getConnection(){
      //  System.out.println("TEST GET CONNECTION");
        
        logger.info("Mulai Koneksi: "+logger.getName());

        try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
            } catch (ClassNotFoundException e) {
                System.out.println("oracle "+e.toString());
                logger.error("oracle "+e.toString());
             //  Logger.getLogger(Common.class.getName()).log(Level.SEVERE, null, e);
               
              //  logger.log(Level.SEVERE, "Exception occur", e);

            }
        Connection connection = null;
        try {
        //      connection = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:bswtest","US_BW","welcome1");
       //       connection = DriverManager.getConnection("jdbc:oracle:thin:@118.97.149.154:1521:bswtest","US_BW","welcome1");
         //     connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.200.4:1521:bswtest","US_BW","welcome1");
       //       connection = DriverManager.getConnection("jdbc:oracle:thin:@172.16.11.121:1521:bsw","us_bw","bswdb");
               connection = DriverManager.getConnection("jdbc:oracle:thin:@172.16.10.101:1521:bsw","us_bw","bswdb");
       } catch (SQLException e) {
               logger.error("Gagal Konek "+e.toString());
               logger.error(e.getMessage());
            //  Logger.getLogger(Common.class.getName()).log(Level.SEVERE, null, e);
             // weblogic.logging
        }

           return connection;
	}
    
    public static Connection getConnectionGov(){
       // System.out.println("TEst GET CONNECTION");
        
        logger.info("Mulai Koneksi EGOV: "+logger.getName());

        try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
            } catch (ClassNotFoundException e) {
                System.out.println("oracle "+e.toString());
                logger.error("oracle "+e.toString());
             //  Logger.getLogger(Common.class.getName()).log(Level.SEVERE, null, e);
               
              //  logger.log(Level.SEVERE, "Exception occur", e);

            }
        Connection connection = null;
        try {
        //      connection = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:bswtest","US_BW","welcome1");
       //       connection = DriverManager.getConnection("jdbc:oracle:thin:@118.97.149.154:1521:bswtest","US_BW","welcome1");
     //         connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.200.2:1521:BEGS","us_ld","us_ld");
                connection = DriverManager.getConnection("jdbc:oracle:thin:@172.16.101.50:1521:BEGS","us_ld","us_ld");
      } catch (SQLException e) {
               logger.error("Gagal Konek "+e.toString());
               logger.error(e.getMessage());
            //  Logger.getLogger(Common.class.getName()).log(Level.SEVERE, null, e);
             // weblogic.logging
        }

           return connection;
	}
    
    
    public static Connection getConnectionOld(){
        System.out.println("TEST GET CONNECTION");
        
        logger.info("Mulai Koneksi: "+logger.getName());
        
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Properties prop = new Properties();
        InputStream input = null;
        try {
          //  input = new FileInputStream("config.properties");
           input =  classLoader.getResourceAsStream("config.properties");
           prop.load(input);
        } catch (Exception ex) {
            logger.error("FILE PROPERTIES TIDAK TERBACA "+ex.toString());
        }
        
        DataSource ds = null;
        Context context = null;
        Connection connection = null;
        
        
        Hashtable ht = new Hashtable();
        ht.put(Context.INITIAL_CONTEXT_FACTORY,"weblogic.jndi.WLInitialContextFactory");
        ht.put(Context.PROVIDER_URL,"t3://"+prop.getProperty("dsurl"));
        try {
                context = new InitialContext(ht);
                ds = (DataSource)context.lookup(prop.getProperty("dsjndi"));
        } catch (NamingException e) {
                logger.error("Unable to get Datasource...");
                e.printStackTrace();
        }
        try {
               connection = ds.getConnection();
       
        } catch (SQLException e) {
               logger.error("Gagal Konek "+e.toString());
               logger.error(e.getMessage());
            //  Logger.getLogger(Common.class.getName()).log(Level.SEVERE, null, e);
             // weblogic.logging
        }

           return connection;
	}
    
    
    public static StatusResponse getErrorResponse(int type){
        StatusResponse response = new StatusResponse();
        response.setStatus("FAILED");
        // 0 - token
        switch(type){
            case 1 :
                response.setStatusDesc("TOKEN NOT VALID or EXPIRED");
                break;
        }
        
        return response;
    }
    
    public static java.sql.Date getCurrentDate() {
        java.util.Date today = new java.util.Date();
        return new java.sql.Date(today.getTime());
    }
    
    public static java.sql.Date convertToDate(String stringDate) throws Exception{
   //     return new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse(stringDate).getTime());
         return new java.sql.Date(new SimpleDateFormat("dd/MM/yyyy").parse(stringDate).getTime());
    }
    
    public static StringPath dirLocation(String username){
            //String rootLocation = "/oracle/imageBSW/";
            StringPath path = new StringPath();
            String rootLocation = getRootLocation();
            String phyLocation = "";
            int year = Calendar.getInstance().get(Calendar.YEAR);
            int month = Calendar.getInstance().get(Calendar.MONTH);

            month = month + 1;
            
            String sMonth = "";
            
            if(month<10){
                sMonth = "0"+month;
            }
            
            String pathYear = rootLocation + "/"+year;
            String pathMonth = pathYear +"/" + sMonth;
            String pathUsername = pathMonth + "/" +username + "/";
            String pathRel = year + "/" + sMonth + "/" +username;
            
            File dirYear = new File(pathYear);
            File dirMonth = new File(pathMonth);
            File dirUser = new File(pathUsername);
            
            if(!dirYear.exists()){
                    logger.info("MAKE DIR OF "+pathYear);
                    dirYear.mkdir();
                    if(!dirMonth.exists()){
                        logger.info("MAKE DIR OF "+pathMonth);
                        dirMonth.mkdir();
                        
                        if(!dirUser.exists()){
                            logger.info("MAKE DIR OF "+pathMonth);
                            dirUser.mkdir();
                        }
                    }
                }else{
                    if(!dirMonth.exists()){
                        logger.info("Make dir of "+pathMonth);
                        dirMonth.mkdir();
                        
                        if(!dirUser.exists()){
                            logger.info("MAKE DIR OF "+pathMonth);
                            dirUser.mkdir();
                        }
                    }
                }
            
            path.setAbsPath(pathUsername);
            path.setRelPath(pathRel);
            
            
            
            return path;
    }
    
    public static String getRootLocation(){
        String location = "";
            
        try {
            Connection conn = getConnection();
            String sql = "select CONFIG_VALUE from TBBW_CONFIG where CONFIG_NAME='UPLOAD_LOCAL_PREFIX'";
            Statement stat = conn.createStatement();
            
            ResultSet rs =  stat.executeQuery(sql);
            
            while(rs.next()){
                location = rs.getString("CONFIG_VALUE");
            }
            
            stat.close();
            conn.close();
        } catch (SQLException ex) {
           logger.error("EX "+ex.getMessage());
        }
        
        return location;
    }
    
    public static int writeToFile(InputStream uploadedInputStream,
		String uploadedFileLocation) {           
		try {
                        OutputStream out = new FileOutputStream(new File(
					uploadedFileLocation));
			int read = 0;
			byte[] bytes = new byte[1024];
                   //     byte[] bytes = new byte[uploadedInputStream.available()];

                        logger.info(logger.getName()+" : Process Save "+uploadedFileLocation);
			
                        out = new FileOutputStream(new File(uploadedFileLocation));
			while ((read = uploadedInputStream.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			out.flush();
			out.close();
                        System.out.println("SAVE FILE SUCCESS");
                        logger.info(logger.getName()+" : Finish Save "+uploadedFileLocation);
			
                        return 1;
		} catch (IOException e) {

			e.printStackTrace();
                        
                        logger.error(logger.getName()+" : Process Save Error "+e.toString());
			
                        return 0;
		}
    }

    
    public static String generateDigest(String username){
        Date date = new Date();
        
        String salt = date.toString();
        String toDigest = username + salt;
        
        MessageDigest md = null;
        StringBuffer sb = new StringBuffer();
        try {
            md = MessageDigest.getInstance("MD5");
            md.update(toDigest.getBytes());
            byte[] digest = md.digest();
            
		for (byte b : digest) {
			sb.append(String.format("%02x", b & 0xff));
		}
        } catch (NoSuchAlgorithmException ex) {
            java.util.logging.Logger.getLogger(TbBwCustController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
                
        return sb.toString();
    }
}
