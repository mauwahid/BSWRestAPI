/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bsw.controller;

import com.bsw.dao.DaoManager;
import com.bsw.dao.TbBwCustDao;
import com.bsw.domain.TbBwCust;
import com.bsw.domain.reqres.LoginRes;
import com.bsw.domain.reqres.ResponseInterface;
import com.bsw.domain.reqres.StatusResponse;
import com.bsw.utils.Common;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.BasicAttribute;
import javax.naming.directory.BasicAttributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import org.apache.log4j.Logger;
import java.util.logging.Level;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.naming.AuthenticationException;
import javax.naming.AuthenticationNotSupportedException;
import javax.naming.NamingEnumeration;
import javax.naming.directory.Attributes;
import javax.naming.directory.ModificationItem;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

/**
 *
 * @author Maulana Wahid Abdurrahman
 */
public class TbBwCustController {

    private static final Logger logger = Logger.getLogger(TbBwCustController.class.getName());
    private String username = "orcladmin";
    private String password = "bswoid2017";
  //  private String url = "ldap://172.18.160.16:3060";
    private String url = "ldap://172.16.9.70:3060";
  //  private String url = "ldap://172.16.11.141:3060";
    String base = "cn=Users,dc=bsw,dc=go,dc=id";
   //   String base = "cn=Users,dc=bswtest,dc=go,dc=id";
          
   
   public static TbBwCustController getInstance(){
        return new TbBwCustController();
   }
   
   public void loadConfig(){
       ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Properties prop = new Properties();
        InputStream input = null;
        try {
          //  input = new FileInputStream("config.properties");
           input =  classLoader.getResourceAsStream("config.properties");
           prop.load(input);
           
           username = prop.getProperty("ldapuser");
           password = prop.getProperty("ldappass");
           url = prop.getProperty("ldapuri");
        } catch (Exception ex) {
    //        logger.error("FILE PROPERTIES TIDAK TERBACA "+ex.toString());
        }
        
        
   }
    
   public static ResponseInterface checkValidation(String username){
        return DaoManager.getTbBwCustDao().checkValidation(username);
   }
   
   public static TbBwCust getProfile(String username){
        return DaoManager.getTbBwCustDao().getProfile(username);
   }
   
   public  TbBwCust getPemohon(String tipe,String custId){
        return DaoManager.getTbBwCustDao().getPemohon(tipe, custId);
   }
   
   public  TbBwCust getProfileAkun(String username){
        return DaoManager.getTbBwCustDao().getProfile(username);
   }
   
   
   
    public  ResponseInterface saveCustomer(String username,String password, String custNm,String email){
        
        String availableName = TbBwCustDao.getInstance().getUsernameByMail(email);
        StatusResponse response = new StatusResponse();
            
        if(!availableName.equalsIgnoreCase("")){
            
            response.setStatus("FAILED");
            response.setStatusDesc("EMAIL TELAH TERDAFTAR");
            
            return response;
        }
        
        
       if(createUser(username, password, custNm, email)>0){
             //      return DaoManager.getTbBwCustDao().saveCustomer(username,custNm,email);
            response.setStatus("SUCCESS");
            response.setStatusDesc("SUC ADD USER");
     
             return response;
            
        }else{
          //  StatusResponse response = new StatusResponse();
            response.setStatus("FAILED");
            response.setStatusDesc("FAILED ADD USER");
            
            return response;
        }
   }
   
   
     public LoginRes loginAct(String username, String password,String fcmid){
        logger.info("LOGIN : "+username+", FCM ID "+fcmid);
         
        LoginRes response = loginProcess(username, password,fcmid);
        
        return response;
    }
    
    private LoginRes loginProcess(String custName, String custPassword,String fcmid){
            LoginRes response = new LoginRes();
      //  DirContext ctx = new InitialDirContext(env);
            
            loadConfig();
            Hashtable env = new Hashtable();
            env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
            env.put(Context.PROVIDER_URL, url);
            env.put(Context.SECURITY_AUTHENTICATION, "simple");
            env.put(Context.SECURITY_PRINCIPAL, "cn="+this.username);
            env.put(Context.SECURITY_CREDENTIALS, this.password);
            
            logger.debug("CONNECT TO "+url);
            logger.debug("ENV : "+env.toString());
            
            try {
                DirContext ctx = new InitialDirContext(env);
                System.out.println("connected");
                System.out.println(ctx.getEnvironment());
                logger.debug("CONNECTED  "+url);
                String[] attributeFilter = { "cn" };
              
                SearchControls sc = new SearchControls();
                sc.setReturningAttributes(attributeFilter);
                sc.setSearchScope(SearchControls.SUBTREE_SCOPE);
                
                String searchFilter = "(cn=" + custName + ")";
                NamingEnumeration<SearchResult> results = ctx.search(base, searchFilter, sc);
                
                if (results.hasMore()) {
                        // get the users DN (distinguishedName) from the result
                        SearchResult result = results.next();
                        String distinguishedName = result.getNameInNamespace();

                        // attempt another authentication, now with the user
                        Properties authEnv = new Properties();
                        authEnv.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
                        authEnv.put(Context.PROVIDER_URL, url);
                        authEnv.put(Context.SECURITY_PRINCIPAL, distinguishedName);
                        authEnv.put(Context.SECURITY_CREDENTIALS, custPassword);
                        new InitialDirContext(authEnv);
 
                        System.out.println("CUST USERNAME "+custName);
                        System.out.println("Authentication successful");
                       // return true;
                        
                        String token = Common.generateDigest(custName);
                        logger.info("TOKEN "+token);
                
                        try {
                            DaoManager.getTbBwCustDao().saveUpdateToken(custName, token, fcmid);

                            response.setTokenID(token);
                            response.setStatus("SUCCESS");
                            response.setStatusDesc("CONNECTED TO LDAP");

                            ctx.close();

                        } catch (SQLException ex) {
                            logger.error("SQL EXC : "+ex.getMessage());
                            response.setStatus("FAILED");
                            response.setStatusDesc("CONNECTED TO DB FAILED "+ex.toString());

                        }

                    }else{
                    
                    response.setStatus("FAILED");
                    response.setStatusDesc("USER MAY BE NOT FOUND");
                }
                // do something useful with the context...
                
            } catch (AuthenticationNotSupportedException ex) {
                logger.error("ERROR LOGIN "+ex.toString());
             
                System.out.println("The authentication is not supported by the server");
                response.setStatus("FAILED");
                response.setStatusDesc(ex.toString());

            } catch (AuthenticationException ex) {
                logger.error("ERROR LOGIN "+ex.toString());
                System.out.println("incorrect password or username");
                response.setStatus("FAILED");
                response.setStatusDesc(ex.toString());

            } catch (NamingException ex) {
                logger.error("ERROR LOGIN "+ex.toString());
             
                System.out.println("error when trying to create the context");
                response.setStatus("FAILED");
                response.setStatusDesc(ex.toString());

            }
        
        return response;
    }
   
    
   private int createUser(String username, String password, String custNm, String email){
        
        loadConfig();
        Hashtable env = new Hashtable();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, url);
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_PRINCIPAL, "cn="+this.username);
        env.put(Context.SECURITY_CREDENTIALS, this.password);
                // TODO code application logic here  

                          // entry's DN 
       // String entryDN = "uid=user1,ou=system";  
        String entryDN = "cn="+username+",cn=Users,dc=bsw,dc=go,dc=id";  
        //  String entryDN = "cn="+username;
         // entry's attributes  

         Attribute uid = new BasicAttribute("uid", username);  
         Attribute cn = new BasicAttribute("cn", username);  
         Attribute sn = new BasicAttribute("sn", username);  
         Attribute mail = new BasicAttribute("mail", email);  
         Attribute givenName = new BasicAttribute("givenName", custNm);  
         Attribute displayName = new BasicAttribute("displayName", custNm);  
       //  Attribute mobile = new BasicAttribute("mobile", email);  
       //  Attribute telephoneNumber = new BasicAttribute("telephoneNumber", email);  
         Attribute pass = new BasicAttribute("userPassword", password);   
         Attribute oc = new BasicAttribute("objectClass");  
         oc.add("top");  
         oc.add("person");  
         oc.add("organizationalPerson");  
         oc.add("inetOrgPerson");  
         DirContext ctx = null;  

         try {  
             // get a handle to an Initial DirContext  
             ctx = new InitialDirContext(env);  
            //    System.out.println("connected");
             //   System.out.println(ctx.getEnvironment());

        //        logger.debug("CONNECTED "+url);
                //logger.debug("NS : "+ctx.);
               // ctx.get
              
             System.out.println("CONNECTED "+url);
             // build the entry  
             BasicAttributes entry = new BasicAttributes();  
             entry.put(uid);
             entry.put(cn);  
             entry.put(sn);  
             entry.put(mail);  
             entry.put(pass);
             entry.put(givenName);
             entry.put(displayName);
             
            entry.put(oc);  
             ctx.createSubcontext(entryDN, entry);  
         //    System.out.println( "AddUser: added entry " + entryDN + ".");  
           //  logger.info("SUCCESS ADD USER "+username);
             System.out.println("SUCCESS ADD USER "+username);
             
             return TbBwCustDao.getInstance().saveCustomer(username, custNm, email);
             
         } catch (NamingException e) {  
             System.err.println("AddUser: error adding entry." + e);  
          //   logger.error("ERROR ADD USER "+e.toString());
             
             return 0;
         }
         
    }
   
   
   public ResponseInterface resetOld(String email){
       
       HashMap map = updatePassword(email);
       
       StatusResponse response = new StatusResponse();
       
       if(map.get("status").toString().equalsIgnoreCase("FAILED")){
           response.setStatus(map.get("status").toString());
           response.setStatusDesc(map.get("statusDesc").toString());
           
           return response;
       }
       
       String content = "Dengan Hormat,\n" +
                    "\n" +
                    "Berikut akses login dengan password yang baru :\n" +
                    "\n" +
                    "username : "+map.get("username").toString()+" \n" +
                    "\n" +
                    "password : "+map.get("password").toString()+"";
       
       String title = "Reset Password BSW";
       
       HashMap mapEmail = sendEmail(email, title, content);
       
       response.setStatus(mapEmail.get("status").toString());
       response.setStatusDesc(mapEmail.get("statusDesc").toString());
       
       return response;
       
   }
   
   public ResponseInterface reset(String email){
       
       HashMap map = generateSendVerCode(email);
       
       StatusResponse response = new StatusResponse();
       
       if(map.get("status").toString().equalsIgnoreCase("FAILED")){
           response.setStatus(map.get("status").toString());
           response.setStatusDesc(map.get("statusDesc").toString());
           
           return response;
       }
       
  //     String url = "http://118.97.149.154:8891/REST/ResetServlet?";
       String url = "http://www.bsw.go.id:8891/REST/ResetServlet?";
      // String url = "http://localhost:7001/REST/ResetServlet?";
       
       String content = "Dengan Hormat,\n" +
                    "\n" +
                    "Berikut link untuk generate login user : "+map.get("username")+" dengan password yang baru :\n" +
                    "\n" +url+"vercode="+map.get("statusDesc");
                    
       
       String title = "Reset Password BSW";
       
       HashMap mapEmail = sendEmail(email, title, content);
       
       response.setStatus(mapEmail.get("status").toString());
       response.setStatusDesc(mapEmail.get("statusDesc").toString());
       
       return response;
       
   }
   
   
   private HashMap updatePassword(String email){
       
       
        String username = DaoManager.getTbBwCustDao().getUsernameByMail(email);
        
        HashMap map = new HashMap();
        
        if(username.equalsIgnoreCase("")){
            System.out.println("USERNAME NOT AVAILABLE");
            map.put("status", "FAILED");
            map.put("statusDesc", "Username Not Available");
        }
       
        Hashtable env = new Hashtable();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, url);
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_PRINCIPAL, "cn="+this.username);
        env.put(Context.SECURITY_CREDENTIALS, this.password);
        
        DirContext context = null;  

         try {  
             // get a handle to an Initial DirContext  
            context = new InitialDirContext(env);  
            System.out.println("connected");
            System.out.println(context.getEnvironment());

            Attributes attrs = context.getAttributes("cn="+username+",cn=Users,dc=bsw,dc=go,dc=id");
            System.out.println("Before update..");
            displayAttributes(attrs);

            System.out.println("Updating..");

            int randomPIN = (int)(Math.random()*9000)+1000;
            String val = ""+randomPIN;
            String genPassword = "BSW"+val;

            Attribute attribute = new BasicAttribute("userPassword",genPassword);
            ModificationItem[] item = new ModificationItem[1];
            item[0] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE,attribute);
            context.modifyAttributes("cn="+username+",cn=Users,dc=bsw,dc=go,dc=id", item);
            System.out.println("After update ..");
            Attributes attrs1 = context.getAttributes("cn="+username+",cn=Users,dc=bsw,dc=go,dc=id");
            displayAttributes(attrs1);


            logger.info("SUCCESS UPD USER "+username);
            map.put("status", "SUCCESS");
            map.put("statusDesc", "Username Available");
            map.put("username", username);
            map.put("password", genPassword);
            
    
            // return DaoManager.getTbBwCustDao().saveCustomer(username, "", email);
             
            return map;
         } catch (NamingException e) {  
             System.err.println("AddUser: error adding entry." + e);  
             logger.error("ERROR ADD USER "+e.toString());
             
            map.put("status", "FAILED");
            map.put("statusDesc", ""+e.toString());
            
            
             return map;
         }
         
    }
   
   
   private HashMap generateSendVerCode(String email){
       
        String username = DaoManager.getTbBwCustDao().getUsernameByMail(email);
        String result = "FAILED";
        HashMap map = new HashMap();
        
        if(username.equalsIgnoreCase("")){
            System.out.println("USERNAME NOT AVAILABLE");
            map.put("status", "FAILED");
            map.put("statusDesc", "Username Not Available");
            return map;
        }

        String digest = Common.generateDigest(username);
        
        if(DaoManager.getTbBwCustDao().savePasscode(username, digest)>0){
            map.put("status", "SUCCESS");
            map.put("statusDesc", digest);
            map.put("username", username);
        }else{
            map.put("status","FAILED");
            map.put("statusDesc", "Save data failed");
            map.put("username", username);
        }
        
        return map;
        
         
    }
   
   
   public ResponseInterface updatePassByUname(String username, String password){
       HashMap hash = updatePasswordByUsername(username, password);
       
       StatusResponse response = new StatusResponse();
       
       String status = hash.get("status").toString();
       if(status.contentEquals("SUCCESS")){
           response.setStatus("SUCCESS");
           response.setStatusDesc("UPDATE PASSWORD SUCCESS");
       }else{
           response.setStatus("FAILED");
           response.setStatusDesc(hash.get("statusDesc").toString());
       }
       
       return response;
   }
   
   public HashMap updatePasswordByUsername(String username,String password){
       
       // String username = DaoManager.getTbBwCustDao().getUsernameByMail(email);
        
        HashMap map = new HashMap();
        
        if(username.equalsIgnoreCase("")){
            System.out.println("USERNAME NOT AVAILABLE");
            map.put("status", "FAILED");
            map.put("statusDesc", "Username Not Available");
        }
       
        Hashtable env = new Hashtable();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, url);
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_PRINCIPAL, "cn="+this.username);
        env.put(Context.SECURITY_CREDENTIALS, this.password);
        
        DirContext context = null;  

         try {  
             // get a handle to an Initial DirContext  
            context = new InitialDirContext(env);  
            System.out.println("connected");
            System.out.println(context.getEnvironment());

            Attributes attrs = context.getAttributes("cn="+username+",cn=Users,dc=bsw,dc=go,dc=id");
            System.out.println("Before update..");
            displayAttributes(attrs);

         //   System.out.println("Updating..");

           // int randomPIN = (int)(Math.random()*9000)+1000;
          //  String val = ""+randomPIN;
           // String genPassword = "BSW"+val;
            String genPassword = password;

            Attribute attribute = new BasicAttribute("userPassword",genPassword);
            ModificationItem[] item = new ModificationItem[1];
            item[0] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE,attribute);
            context.modifyAttributes("cn="+username+",cn=Users,dc=bsw,dc=go,dc=id", item);
            System.out.println("After update ..");
            Attributes attrs1 = context.getAttributes("cn="+username+",cn=Users,dc=bsw,dc=go,dc=id");
            displayAttributes(attrs1);


            logger.info("SUCCESS UPD USER "+username);
            map.put("status", "SUCCESS");
            map.put("statusDesc", "Username Available");
            map.put("username", username);
            map.put("password", genPassword);
            
    
            // return DaoManager.getTbBwCustDao().saveCustomer(username, "", email);
             
            return map;
         } catch (NamingException e) {  
             System.err.println("AddUser: error adding entry." + e);  
             logger.error("ERROR UPD PASS "+e.toString());
             
            map.put("status", "FAILED");
            map.put("statusDesc", ""+e.toString());
            
            
             return map;
         }
         
    }
   
   
 /*   
   private HashMap savePic(String username, InputStream input){
       
       // String username = DaoManager.getTbBwCustDao().getUsernameByMail(email);
        
        HashMap map = new HashMap();
        
        if(username.equalsIgnoreCase("")){
            System.out.println("USERNAME NOT AVAILABLE");
            map.put("status", "FAILED");
            map.put("statusDesc", "Username Not Available");
        }
       
        Hashtable env = new Hashtable();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, url);
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_PRINCIPAL, "cn="+this.username);
        env.put(Context.SECURITY_CREDENTIALS, this.password);
        
        DirContext context = null;  

         try {  
             // get a handle to an Initial DirContext  
            context = new InitialDirContext(env);  
            System.out.println("connected");
            System.out.println(context.getEnvironment());

            Attributes attrs = context.getAttributes("cn="+username+",cn=Users,dc=bswtest,dc=go,dc=id");
            System.out.println("Before update..");
            displayAttributes(attrs);

            System.out.println("Updating Foto..");

            byte[] data = input.
            Attribute attribute = new BasicAttribute("jpegphoto",input);
            ModificationItem[] item = new ModificationItem[1];
            item[0] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE,attribute);
            context.modifyAttributes("cn="+username+",cn=Users,dc=bswtest,dc=go,dc=id", item);
            System.out.println("After update ..");
            Attributes attrs1 = context.getAttributes("cn="+username+",cn=Users,dc=bswtest,dc=go,dc=id");
            displayAttributes(attrs1);


            logger.info("SUCCESS UPD USER "+username);
            map.put("status", "SUCCESS");
            map.put("statusDesc", "Username Available");
            map.put("username", username);
            map.put("password", genPassword);
            
    
            // return DaoManager.getTbBwCustDao().saveCustomer(username, "", email);
             
            return map;
         } catch (NamingException e) {  
             System.err.println("AddUser: error adding entry." + e);  
             logger.error("ERROR ADD USER "+e.toString());
             
            map.put("status", "FAILED");
            map.put("statusDesc", ""+e.toString());
            
            
             return map;
         }
         
    }
*/   
   
   
   public ResponseInterface updateCustomer(String token, String username,String custNm, String custTp,
           String custAddr, String custTel, String custFax, String custEmail,
           String custHp, String custJob, String custNtnty, String custGend, String prgNm,
           String busTp, String custMarryYN, String birthDate){
       
       TbBwCust tbBwCust = new TbBwCust();
       tbBwCust.setCustUsername(username);
       tbBwCust.setCustNm(custNm);
       tbBwCust.setCustTel(custTel);
       tbBwCust.setCustTp(custTp);
       tbBwCust.setCustAddr(custAddr);
       tbBwCust.setCustFax(custFax);
       tbBwCust.setCustEmail(custEmail);
       tbBwCust.setCustHp(custHp);
       tbBwCust.setCustJob(custJob);
       tbBwCust.setCustNtNty(custNtnty);
       tbBwCust.setCustGend(custGend);
       tbBwCust.setPrgNm(prgNm);
       tbBwCust.setBusiTp(busTp);
       tbBwCust.setCustMarriYn(custMarryYN);
       tbBwCust.setCustBirthDt(birthDate);
       
       return DaoManager.getTbBwCustDao().updateCust(tbBwCust);
   }
   
   
   
   
   private void printSearchEnumeration(NamingEnumeration retEnum) {
        try {
            while (retEnum.hasMore()) {
            SearchResult sr = (SearchResult) retEnum.next();
            System.out.println(">>" + sr.getNameInNamespace());
            }
        } catch (NamingException e) {
           logger.error("Error Search Enum "+e.getMessage());
        }
   }
   
   
   
   
   public static int isValidToken(String token){
       return  DaoManager.getTbBwCustDao().getTokenStatus(token);
   }
   
   public ResponseInterface logout(String token){
       int res = 0;
       res = DaoManager.getTbBwCustDao().logout(token);
       
       StatusResponse response = new StatusResponse();
       
       
       if(res>0){
           response.setStatus("SUCCESS");
           response.setStatusDesc("LOGOUT SUCCESS");
       }else{
           response.setStatus("FAILED");
           response.setStatusDesc("LOGOUT FAILED");
       }
       
       return response;
   }
   
    public ResponseInterface relogin(String token){
       int res = 0;
       
       res = isValidToken(token);
       StatusResponse response = new StatusResponse();
       
       if(res>0){
           response.setStatus("SUCCESS");
           response.setStatusDesc("RELOGIN SUCCESS");
       }else{
           response.setStatus("FAILED");
           response.setStatusDesc("RELOGIN FAILED");
       }
       
       return response;
   }
    
    public static String getUsername(String token){
        return  DaoManager.getTbBwCustDao().getUsername(token);

    }
    
    
    
    public HashMap sendEmail(String target, String title, String content){
      //  String to = "mau.wahid@gmail.com";//change accordingly  
        String from = "support@bsw.go.id"; //change accordingly  
        String host = "mta1.bpbatam.go.id";//or IP address 
        
        HashMap map = new HashMap();

     //Get the session object  
      Properties properties = System.getProperties();  
    //  properties.setProperty("mail.smtp.host", host);  
    //  properties.setProperty("mail.smtp.port", "465");
      properties.put("mail.smtp.host", "mta1.bpbatam.go.id");
      properties.put("mail.smtp.socketFactory.port", "465");
      properties.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
      properties.put("mail.smtp.ssl.enable","true");
      properties.put("mail.smtp.auth", "true");
      properties.put("mail.smtp.port", "465");
        
      
     Session session = Session.getInstance(properties,new javax.mail.Authenticator() {
        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication("support@bsw.go.id","support15243");
        }
        });
     //compose the message  
      try{  
         MimeMessage message = new MimeMessage(session);  
            try {  
                message.setFrom(new InternetAddress(from, "Support BSW"));
            } catch (UnsupportedEncodingException ex) {
                java.util.logging.Logger.getLogger(TbBwCustController.class.getName()).log(Level.SEVERE, null, ex);
                message.setFrom(new InternetAddress(from));
       
            }
         message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(target));  
         message.setSubject("Reset Password BSW");  
         message.setContent(content, "text/html; charset=utf-8");  
  
         // Send message  
         Transport.send(message);  
         System.out.println("message sent successfully....");  
         
         map.put("status", "SUCCESS");
         map.put("statusDesc", "Link konfirmasi telah dikirim ke email");
         
  
      }catch (MessagingException mex) {
          
          System.out.println("MES "+mex.toString());
          mex.printStackTrace();
          
          map.put("status", "FAILED");
          map.put("statusDesc", "Link konfirmasi gagal dikirim");
         
      
      }  
      
      return map;
     
    }
    
    
    private void UpdateSample(){
        Properties properties = new Properties();
        
        

        properties.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.ldap.LdapCtxFactory");
        properties.put(Context.PROVIDER_URL, "ldap://localhost:10389");
            try {
                DirContext context = new InitialDirContext(properties);
                Attributes attrs = context.getAttributes("employeeNumber=112233,ou=users,ou=system");
                System.out.println("Before update..");
                displayAttributes(attrs);
                System.out.println("Updating..");
                Attribute attribute = new BasicAttribute("telephoneNumber","88888888");
                ModificationItem[] item = new ModificationItem[1];
                item[0] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE,attribute);
                context.modifyAttributes("employeeNumber=112233,ou=users,ou=system", item);
                System.out.println("After update ..");
                Attributes attrs1 = context.getAttributes("employeeNumber=112233,ou=users,ou=system");
                displayAttributes(attrs1);
            } catch (NamingException e) {
                e.printStackTrace();
            }
        
        }
    
        
    public void displayAttributes(Attributes attributes) {
            try {
            System.out.println("Surname: " + attributes.get("sn").get());
            System.out.println("Common name : " + attributes.get("cn").get());
//            System.out.println("Telephone number : "+ attributes.get("telephoneNumber").get());
            } catch (NamingException e) {

            e.printStackTrace();
            }
            }
            
    private HashMap updateProfilPic(String username, FileInputStream input){
       
      //  String username = DaoManager.getTbBwCustDao().getUsernameByMail(email);
        
        HashMap map = new HashMap();
        
        if(username.equalsIgnoreCase("")){
            System.out.println("USERNAME NOT AVAILABLE");
            map.put("status", "FAILED");
            map.put("statusDesc", "Username Not Available");
        }
       
        Hashtable env = new Hashtable();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, url);
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_PRINCIPAL, "cn="+this.username);
        env.put(Context.SECURITY_CREDENTIALS, this.password);
        
        DirContext context = null;  

         try {  
             // get a handle to an Initial DirContext  
            context = new InitialDirContext(env);  
            System.out.println("connected");
            System.out.println(context.getEnvironment());

            Attributes attrs = context.getAttributes("cn="+username+",cn=Users,dc=bsw,dc=go,dc=id");
            System.out.println("Before update..");
            displayAttributes(attrs);

            System.out.println("Updating..");

            int randomPIN = (int)(Math.random()*9000)+1000;
            String val = ""+randomPIN;
            String genPassword = "BSW"+val;

            Attribute attribute = new BasicAttribute("userPassword",genPassword);
            ModificationItem[] item = new ModificationItem[1];
            item[0] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE,attribute);
            context.modifyAttributes("cn="+username+",cn=Users,dc=bsw,dc=go,dc=id", item);
            System.out.println("After update ..");
            Attributes attrs1 = context.getAttributes("cn="+username+",cn=Users,dc=bsw,dc=go,dc=id");
            displayAttributes(attrs1);


            logger.info("SUCCESS UPD USER "+username);
            map.put("status", "SUCCESS");
            map.put("statusDesc", "Username Available");
            map.put("username", username);
            map.put("password", genPassword);
            
    
            // return DaoManager.getTbBwCustDao().saveCustomer(username, "", email);
             
            return map;
         } catch (NamingException e) {  
             System.err.println("AddUser: error adding entry." + e);  
             logger.error("ERROR ADD USER "+e.toString());
             
            map.put("status", "FAILED");
            map.put("statusDesc", ""+e.toString());
            
            
             return map;
         }
         
    }
    
   /* 
    private byte[] getProfilPic(String username){
       
      //  String username = DaoManager.getTbBwCustDao().getUsernameByMail(email);
        
        HashMap map = new HashMap();
        
        if(username.equalsIgnoreCase("")){
            System.out.println("USERNAME NOT AVAILABLE");
            map.put("status", "FAILED");
            map.put("statusDesc", "Username Not Available");
        }
       
        Hashtable env = new Hashtable();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, url);
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_PRINCIPAL, "cn="+this.username);
        env.put(Context.SECURITY_CREDENTIALS, this.password);
        
        DirContext context = null;  

         try {  
             // get a handle to an Initial DirContext  
            context = new InitialDirContext(env);  
            System.out.println("connected");
            System.out.println(context.getEnvironment());

            Attributes attrs = context.getAttributes("cn="+username+",cn=Users,dc=bsw,dc=go,dc=id");
            System.out.println("Before update..");
            displayAttributes(attrs);

            System.out.println("Updating..");


            SearchControls constraints = new SearchControls();
            constraints.setSearchScope(SearchControls.SUBTREE_SCOPE);
            String[] attrIDs = { "jpegPhoto"};
            constraints.setReturningAttributes(attrIDs);
            //First input parameter is search bas, it can be "CN=Users,DC=YourDomain,DC=com"
            //Second Attribute can be uid=username
            NamingEnumeration<SearchResult> results = context.search(base, "cn="+ username, constraints);
            
            if(results.hasMore()){
                 SearchResult result = results.next();
            
                 Attributes attr = result.getAttributes();
                 String photo = (String)attr.get("jpegPhoto");
                 
            }
                        
            
//            context.modifyAttributes("cn="+username+",cn=Users,dc=bsw,dc=go,dc=id", item);
            System.out.println("After update ..");
            Attributes attrs1 = context.getAttributes("cn="+username+",cn=Users,dc=bsw,dc=go,dc=id");
            displayAttributes(attrs1);


            logger.info("SUCCESS UPD USER "+username);
           
    
            // return DaoManager.getTbBwCustDao().saveCustomer(username, "", email);
             
            return map;
         } catch (NamingException e) {  
             System.err.println("AddUser: error adding entry." + e);  
             logger.error("ERROR ADD USER "+e.toString());
             
            map.put("status", "FAILED");
            map.put("statusDesc", ""+e.toString());
            
            
             return map;
         }
         
    }
   */ 
       
        

}