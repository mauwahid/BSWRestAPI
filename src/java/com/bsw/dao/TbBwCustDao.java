/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bsw.dao;

import com.bsw.domain.TbBW2Status;
import com.bsw.domain.TbBwCust;
import com.bsw.domain.TbCMCountryCityTMP;
import com.bsw.domain.reqres.ResponseInterface;
import com.bsw.domain.reqres.StatusResponse;
import com.bsw.domain.reqres.ValidationRes;
import com.bsw.utils.Common;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Maulana Wahid Abdurrahman
 */
public class TbBwCustDao {

    private Connection conn;
    private String queryValid = "SELECT CUST_USERNAME FROM US_BW.TBBW_CUST WHERE  CUST_USERNAME = ?";
    private String queryProfile = "SELECT a.*, (select CD_NM from US_REF.TBCM_COM where COM_CD = a.CUST_TP) as CUST_TP_NM FROM US_BW.TBBW_CUST a WHERE  a.CUST_USERNAME = ?";
    private String queryCreateCust = "INSERT INTO TBBW_CUST(IDCUST,CUST_USERNAME,CUST_NM,CUST_EMAIL,STATUS,DATE_INSERT)\n" +
                                    "VALUES(?,?,?,?,?,SYSDATE)";
    private String queryNextID = "SELECT MAX(IDCUST) + 1 as NEXTID FROM TBBW_CUST WHERE ROWNUM =1";
  //  private String queryPemohonUmum = "select a.*, b.DOCUMENT_NO, b.COM_CD as DOC_TIPE, (select CD_NM from US_REF.TBCM_COM  where COM_CD = a.CUST_TP) as CUST_TP_NM from TBBW_CUST a inner join TBBW_CUST_DETL b on a.IDCUST = b.IDCUST \n" +
    //           "where  b.DOCUMENT_NO like ? and (b.COM_CD = 'D0904' or b.COM_CD = 'D0901') order by a.idcust desc ";
    private String queryPemohonUmum = "select a.*, b.*, (select CD_NM from US_REF.TBCM_COM  where COM_CD = b.CUST_TP) as CUST_TP_NM  from tbbw_cust_detl a,  tbbw_cust b where a.idcust = b.idcust and a.document_no = ?";
    private String queryPemohonIPH = "select a.CUST_TP, a.CUST_CD, a.CUST_ID, a.CUST_NM, (select CD_NM from US_REF.TBCM_COM  where COM_CD = a.CUST_TP) as CUST_TP_NM from TBBW_IPH_PEMOHON a where a.CUST_ID like ?";
    private String queryPemohonEGov = "select * from us_cm.tbcm_cust where cust_id = ?";
    private String queryUpdateCust = "Update TBBW_CUST set CUST_NM = ?, CUST_TP = ?, CUST_ADDR = ?, CUST_TEL = ?, CUST_FAX = ?, \n" +
        "CUST_EMAIL=?, CUST_HP = ?, CUST_JOB = ?, CUST_NTNTY = ?, CUST_GEND = ?, PRG_NM = ?, UPDATEDBY = ?,\n" +
        "DATE_UPDATE = ?, BUSI_TP = ?, CUST_MARRI_YN = ?, CUST_BIRTH_DT = ? where CUST_USERNAME = ?";
    private String queryUpdateToken = "Update TBBW_APP_TOKEN set LASTUPDATE = SYSDATE, EXPDATE = SYSDATE+3, LOGINSTATUS = 1\n" +
        "WHERE TOKENID = ? and EXPDATE > SYSDATE";
    private String queryLogout = "Update TBBW_APP_TOKEN set LASTUPDATE = SYSDATE, EXPDATE = SYSDATE+3, LOGINSTATUS = 0\n" +
        "WHERE TOKENID = ? and EXPDATE > SYSDATE";
    
    private String queryGetUserID = "SELECT USERID TBBW_APP_TOKEN WHERE TOKENID = ?";
    private String queryGetUserNameByMail = "SELECT CUST_USERNAME from TBBW_CUST WHERE CUST_EMAIL = ?";
    private String qInsertPassPass = "INSERT INTO TBBW_FORGET_PASSWORD(USERNAME,VERCODE)\n" +
                                    "VALUES(?,?)";
    private String qSelectUserPass = "SELECT USERNAME FROM TBBW_FORGET_PASSWORD WHERE VERCODE = ?";
    private String queryGetTpNM = "SELECT CD_NM from US_REF.TBCM_COM WHERE COM_CD = ?";
    
    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    
    public TbBwCustDao(Connection conn){
        this.conn = conn;
    }
    
    public TbBwCustDao(){
        
    }
    
    public static TbBwCustDao getInstance(){
        return new TbBwCustDao();
    }
    
    public ValidationRes checkValidation(String username){
        PreparedStatement statement = null;
        ResultSet rs = null;
        ValidationRes response = new ValidationRes();
        try {
           
            statement = conn.prepareStatement(queryValid);
            statement.setString(1, username);
            
            rs = statement.executeQuery();
            if (rs.next()) {
                response.setUserStatus(rs.getString("CUST_USERNAME"));
                response.setStatus("SUCCESS");
                response.setStatusDesc("SUCCESS QUERY/USER NOT AVAILABLE FOR JOIN");
            }else{
                response.setUserStatus("NOT FOUND");
                response.setStatus("SUCCESS");
                response.setStatusDesc("SUCCESS QUERY/USER AVAILABLE FOR JOIN");
             
            }
            statement.close();
            conn.close();
             
           // return list;
        } catch (SQLException exception) {
            try {
                statement.close();
                conn.close();
             
                response.setUserStatus("NOT FOUND");
                response.setStatus("FAILED");
                response.setStatusDesc(exception.getMessage());
              //  return null;
            } catch (SQLException ex) {
                Logger.getLogger(TbCMCountryCityTMP.class.getName()).log(Level.SEVERE, null, ex);
                response.setUserStatus("NOT FOUND");
                response.setStatus("FAILED");
                response.setStatus(exception.getMessage());
              // return null;
            }
        } 
        
        return response;
    }
    
    public TbBwCust getProfile(String username){
        PreparedStatement statement = null;
        ResultSet rs = null;
        TbBwCust tbBwCust = new TbBwCust();
        try {
           
            statement = conn.prepareStatement(queryProfile);
            statement.setString(1, username);
            
            rs = statement.executeQuery();
            if (rs.next()) {
               tbBwCust.setIdCust(rs.getString("IDCUST"));
               tbBwCust.setCustCd(rs.getString("CUST_CD"));
               tbBwCust.setCustUsername(rs.getString("CUST_USERNAME"));
               tbBwCust.setCustNm(rs.getString("CUST_NM"));
               tbBwCust.setCustTp(rs.getString("CUST_TP"));
               tbBwCust.setCustAddr(rs.getString("CUST_ADDR"));
               tbBwCust.setCustZip(rs.getString("CUST_ZIP"));
               tbBwCust.setCustTel(rs.getString("CUST_TEL"));
               tbBwCust.setCustFax(rs.getString("CUST_FAX"));
               tbBwCust.setCustCityNm(rs.getString("CUST_CITY_NM"));
               if(rs.getDate("CUST_BIRTH_DT")!=null){
                   tbBwCust.setCustBirthDt(format.format(rs.getDate("CUST_BIRTH_DT")));
               
               }
               tbBwCust.setCustBirthPlcd(rs.getString("CUST_BIRTH_PLCD"));
               tbBwCust.setCustMarriYn(rs.getString("CUST_MARRI_YN"));
               tbBwCust.setCustEmail(rs.getString("CUST_EMAIL"));
               tbBwCust.setCustHp(rs.getString("CUST_HP"));
               tbBwCust.setCustJob(rs.getString("CUST_JOB"));
               tbBwCust.setCustNtNty(rs.getString("CUST_NTNTY"));
               tbBwCust.setCustGend(rs.getString("CUST_GEND"));
               tbBwCust.setCustRmk(rs.getString("CUST_RMK"));
               tbBwCust.setBusiTp(rs.getString("BUSI_TP"));
               tbBwCust.setPrgID(rs.getString("PRG_ID"));
               tbBwCust.setPrgNm(rs.getString("PRG_NM"));
               tbBwCust.setBrchNm(rs.getString("BRCH_NM"));
               tbBwCust.setStatus(rs.getString("STATUS"));
               tbBwCust.setCustTpNm(rs.getString("CUST_TP_NM"));
               
            }
            statement.close();
            conn.close();
             
           // return list;
        } catch (SQLException exception) {
            try {
                statement.close();
                conn.close();
              //  return null;
            } catch (SQLException ex) {
                Logger.getLogger(TbCMCountryCityTMP.class.getName()).log(Level.SEVERE, null, ex);
               
              // return null;
            }
        } 
        
        return tbBwCust;
        
        
    }
    
    public int saveCustomer(String username,
        String custNm, String email){
        
       // PreparedStatement statement = null;
         Statement statement = null;
        
        conn = Common.getConnection();
        
        int affectRow = 0;
        int nextId = getNextID();
      //  StatusResponse response = new StatusResponse();
        try {
            System.out.println("NEXT ID "+nextId);
            
            queryCreateCust = "INSERT INTO TBBW_CUST(IDCUST,CUST_USERNAME,CUST_NM,CUST_EMAIL,STATUS,DATE_INSERT)"+
                                  "  VALUES('"+nextId+"','"+username+"','"+custNm+"','"+email+"','NEW',SYSDATE)";
        /*  statement = Common.getConnection().prepareStatement(queryCreateCust);
            statement.setInt(1, nextId);
            statement.setString(2, username);
            statement.setString(3, custNm);
            statement.setString(4, email);
            statement.setString(5, "NEW");
            affectRow = statement.executeUpdate(); */
            
            statement = conn.createStatement();
            System.out.println("QCreateCust : "+queryCreateCust);
            
            affectRow = statement.executeUpdate(queryCreateCust);
            statement.close();
            conn.close();
             
           // return list;
        } catch (SQLException exception) {
            try {
                statement.close();
                conn.close();
            //    response.setStatusDesc(""+exception.getMessage());
              //  return null;
            } catch (SQLException ex) {
                Logger.getLogger(TbCMCountryCityTMP.class.getName()).log(Level.SEVERE, null, ex);
              //  response.setStatusDesc(""+ex.getMessage());
            }
        } 
        
        return affectRow;
    }
    
    
    public ResponseInterface updateCust(TbBwCust tbBwCust){
        
        PreparedStatement statement = null;
        
        int affectRow = 0;
     //   int nextId = getNextID();
        StatusResponse response = new StatusResponse();
        try {
            statement = Common.getConnection().prepareStatement(queryUpdateCust);
            statement.setString(1,tbBwCust.getCustNm());
            statement.setString(2, tbBwCust.getCustTp());
            statement.setString(3, tbBwCust.getCustAddr());
            statement.setString(4, tbBwCust.getCustTel());
            statement.setString(5, tbBwCust.getCustFax());
            statement.setString(6, tbBwCust.getCustEmail());
            statement.setString(7, tbBwCust.getCustHp());
            statement.setString(8, tbBwCust.getCustJob());
            statement.setString(9, tbBwCust.getCustNtNty());
            statement.setString(10, tbBwCust.getCustGend());
            statement.setString(11, tbBwCust.getPrgNm());
            statement.setString(12, tbBwCust.getCustUsername());
            statement.setDate(13, Common.getCurrentDate());
            statement.setString(14,tbBwCust.getBusiTp());
            statement.setString(15,tbBwCust.getCustMarriYn());
            try {
                statement.setDate(16, Common.convertToDate(tbBwCust.getCustBirthDt()));
            } catch (Exception ex) {
               statement.setDate(16, null);
            }
            statement.setString(17,tbBwCust.getCustUsername());
            affectRow = statement.executeUpdate();
            
            statement.close();
            conn.close();
             
           // return list;
        } catch (SQLException exception) {
            try {
                statement.close();
                conn.close();
                response.setStatusDesc(""+exception.getMessage());
              //  return null;
            } catch (SQLException ex) {
                Logger.getLogger(TbCMCountryCityTMP.class.getName()).log(Level.SEVERE, null, ex);
                response.setStatusDesc(""+ex.getMessage());
            }
        } 
        if(affectRow>0){
            response.setStatus("SUCCESS");
            response.setStatusDesc("UPDATE CUSTOMER SUCCESS");
        }else{
              response.setStatus("FAILED");
              response.setStatusDesc("Update Failed, No data updated");
        }
        return response;
    }
    
    
    private int getNextID(){
        int id = 0;
        
        Statement statement = null;
        ResultSet rs = null;
        List<TbBW2Status> list = new ArrayList<TbBW2Status>();
        try {
            statement = Common.getConnection().createStatement();
            System.out.println("Next Query : "+queryNextID);
            rs = statement.executeQuery(queryNextID);
            while (rs.next()) {
                id = rs.getInt("NEXTID");
            }
            statement.close();
            conn.close();
          
        } catch (SQLException exception) {
            try {
                statement.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(TbComTMPDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        
        return id;
        
    }
    
    public TbBwCust getPemohon(String tipe, String custId){
        PreparedStatement statement = null;
        ResultSet rs = null;
        TbBwCust tbBwCust = new TbBwCust();
        
      //  System.out.println("custID ")
        
        tbBwCust.setCustUsername("");
        tbBwCust.setCustTp("");
        tbBwCust.setCustTpNm("");
        tbBwCust.setCustNm("");
        tbBwCust.setDocNum("");
        tbBwCust.setDocTp("");
            
        try {
           
            statement = conn.prepareStatement(queryPemohonUmum);
            statement.setString(1, custId);
            
            rs = statement.executeQuery();
            if (rs.next()) {
              tbBwCust.setIdCust(custId);
              tbBwCust.setCustUsername(rs.getString("CUST_USERNAME"));
              tbBwCust.setCustTp(rs.getString("CUST_TP")!=null?rs.getString("CUST_TP"):"");
              tbBwCust.setCustTpNm(rs.getString("CUST_TP_NM")!=null?rs.getString("CUST_TP_NM"):"");
              tbBwCust.setCustNm(rs.getString("CUST_NM")!=null?rs.getString("CUST_NM"):"");
              tbBwCust.setDocNum(rs.getString("DOCUMENT_NO")!=null?rs.getString("DOCUMENT_NO"):"");
              tbBwCust.setDocTp(rs.getString("COM_CD")!=null?rs.getString("COM_CD"):"");
             // tbBwCust.set
            //  tbBwCust.setIdCust(custId);
               
            }else{
                tbBwCust.setCustTp("");
                tbBwCust.setCustNm("");
            }
            statement.close();
            conn.close();
             
           // return list;
        } catch (SQLException exception) {
            try {
                statement.close();
                conn.close();
              //  return null;
            } catch (SQLException ex) {
                Logger.getLogger(TbCMCountryCityTMP.class.getName()).log(Level.SEVERE, null, ex);
               
              // return null;
            }
        } 
        if(tbBwCust.getCustNm().equalsIgnoreCase("") && tipe.equalsIgnoreCase("IPH")){
            tbBwCust = getPemohonByIPH(custId);
            
        }
        
        if(tbBwCust.getCustNm().equalsIgnoreCase("")){
            tbBwCust = getPemohonByEGOV(custId);
            
        }
        return tbBwCust;
        
    }
    
     
    public TbBwCust getPemohonByIPH(String custId){
        PreparedStatement statement = null;
        ResultSet rs = null;
        TbBwCust tbBwCust = new TbBwCust();
        conn = Common.getConnection();
        try {
           
            statement = conn.prepareStatement(queryPemohonIPH);
            statement.setString(1, custId);
            
            rs = statement.executeQuery();
            if (rs.next()) {
              tbBwCust.setIdCust(custId);
              tbBwCust.setCustTp(rs.getString("CUST_TP"));
              tbBwCust.setCustTpNm(rs.getString("CUST_TP_NM"));
              tbBwCust.setCustNm(rs.getString("CUST_NM"));
           //   tbBwCust.
               
            }else{
                tbBwCust.setCustTp("");
                tbBwCust.setCustNm("");
            }
            statement.close();
            conn.close();
             
           // return list;
        } catch (SQLException exception) {
            try {
                statement.close();
                conn.close();
              //  return null;
            } catch (SQLException ex) {
                Logger.getLogger(TbCMCountryCityTMP.class.getName()).log(Level.SEVERE, null, ex);
               
              // return null;
            }
        } 
        return tbBwCust;
    }
    
    public TbBwCust getPemohonByEGOV(String custId){
        PreparedStatement statement = null;
        ResultSet rs = null;
        TbBwCust tbBwCust = new TbBwCust();
        conn = Common.getConnectionGov();
        try {
           
            statement = conn.prepareStatement(queryPemohonEGov);
            statement.setString(1, custId);
            
              String custTp = "";
            rs = statement.executeQuery();
            if (rs.next()) {
              tbBwCust.setIdCust(custId);
              custTp = rs.getString("CUST_TP");
              tbBwCust.setCustTp(custTp);
              tbBwCust.setCustNm(rs.getString("CUST_NM"));
           //   tbBwCust.
               
            }
            statement.close();
            conn.close();
            
      //     tbBwCust.setCustTpNm(getTpNM(custTp));
         
             
           // return list;
        } catch (SQLException exception) {
            try {
                statement.close();
                conn.close();
              //  return null;
            } catch (SQLException ex) {
                Logger.getLogger(TbCMCountryCityTMP.class.getName()).log(Level.SEVERE, null, ex);
               
              // return null;
            }
        } 
        return tbBwCust;
    }
    
    
    
    public int saveUpdateToken(String username, String token,String fcmid) throws SQLException{
      
        int res = 0;
        CallableStatement callableStatement = null;
        
        System.out.println("FCM "+fcmid);

        String insertStoreProc = "{call PROC_SAVEUPDTOKEN(?,?,?)}";

        conn = Common.getConnection();
         callableStatement = conn.prepareCall(insertStoreProc);

         callableStatement.setString(1,username);
         callableStatement.setString(2, token);
         callableStatement.setString(3, fcmid);

         // execute insertDBUSER store procedure
         res = callableStatement.executeUpdate();

       // System.out.println("Record is inserted into DBUSER table!");

        
        return res;
    }
    
    
    public int getTokenStatus(String token){
       PreparedStatement statement = null;
       int rs = 0;
      //  TbBwCust tbBwCust = new TbBwCust();
        conn = Common.getConnection();
        try {
           
            statement = conn.prepareStatement(queryUpdateToken);
            statement.setString(1, token);
            
            rs = statement.executeUpdate();
            
            statement.close();
            conn.close();
             
           // return list;
        } catch (SQLException exception) {
            try {
                statement.close();
                conn.close();
              //  return null;
            } catch (SQLException ex) {
                Logger.getLogger(TbCMCountryCityTMP.class.getName()).log(Level.SEVERE, null, ex);
               
              // return null;
            }
        } 
        return rs;
        
    }
    
    public int logout(String token){
       PreparedStatement statement = null;
       int rs = 0;
      //  TbBwCust tbBwCust = new TbBwCust();
        conn = Common.getConnection();
        try {
           
            statement = conn.prepareStatement(queryLogout);
            statement.setString(1, token);
            
            rs = statement.executeUpdate();
            
            statement.close();
            conn.close();
             
           // return list;
        } catch (SQLException exception) {
            try {
                statement.close();
                conn.close();
              //  return null;
            } catch (SQLException ex) {
                Logger.getLogger(TbCMCountryCityTMP.class.getName()).log(Level.SEVERE, null, ex);
               
              // return null;
            }
        } 
        return rs;
        
    }
    
    public String getUsername(String token){
       PreparedStatement statement = null;
       String username = "";
       ResultSet rs = null;
      //  TbBwCust tbBwCust = new TbBwCust();
        conn = Common.getConnection();
        try {
           
            statement = conn.prepareStatement(queryGetUserID);
            statement.setString(1, token);
            
            rs = statement.executeQuery();
            
            while(rs.next()){
                username = rs.getString("USERID");
            }
            
            statement.close();
            conn.close();
             
           // return list;
        } catch (SQLException exception) {
            try {
                statement.close();
                conn.close();
              //  return null;
            } catch (SQLException ex) {
                Logger.getLogger(TbCMCountryCityTMP.class.getName()).log(Level.SEVERE, null, ex);
               
              // return null;
            }
        } 
        return username;
    }
    
    public String getUsernameByMail(String email){
      // PreparedStatement statement = null;
       String username = "";
       ResultSet rs = null;
       
       Statement statement = null;
       
       queryGetUserNameByMail = "SELECT CUST_USERNAME from TBBW_CUST WHERE CUST_EMAIL = '"+email+"'";
    
       System.out.println("Query : "+queryGetUserNameByMail);
      //  TbBwCust tbBwCust = new TbBwCust();
        conn = Common.getConnection();
        
        
        try {
           
          /*  statement = conn.prepareStatement(queryGetUserNameByMail);
            statement.setString(1, email);
            
            rs = statement.executeQuery();
                  */
            
            statement = conn.createStatement();
            rs = statement.executeQuery(queryCreateCust);
            
            while(rs.next()){
                username = rs.getString("CUST_USERNAME");
            }
            
            statement.close();
            conn.close();
             
           // return list;
        } catch (SQLException exception) {
            try {
                statement.close();
                conn.close();
              //  return null;
            } catch (SQLException ex) {
                Logger.getLogger(TbCMCountryCityTMP.class.getName()).log(Level.SEVERE, null, ex);
               
              // return null;
            }
        } 
        return username;
    }
    
    
    public String getUsernameByPasscode(String token){
       PreparedStatement statement = null;
       String username = "";
       ResultSet rs = null;
      //  TbBwCust tbBwCust = new TbBwCust();
        conn = Common.getConnection();
        try {
           
            statement = conn.prepareStatement(qSelectUserPass);
            statement.setString(1, token);
            
            rs = statement.executeQuery();
            
            while(rs.next()){
                username = rs.getString("USERNAME");
            }
            
            statement.close();
            conn.close();
             
           // return list;
        } catch (SQLException exception) {
            try {
                statement.close();
                conn.close();
              //  return null;
            } catch (SQLException ex) {
                Logger.getLogger(TbCMCountryCityTMP.class.getName()).log(Level.SEVERE, null, ex);
               
              // return null;
            }
        } 
        return username;
    }
    
    public int savePasscode(String username, String verCode){
       PreparedStatement statement = null;
       int rs = 0;
      //  TbBwCust tbBwCust = new TbBwCust();
        conn = Common.getConnection();
        try {
           
            statement = conn.prepareStatement(qInsertPassPass);
            statement.setString(1, username);
            statement.setString(2, verCode);
            
            rs = statement.executeUpdate();
            
            
            
            statement.close();
            conn.close();
             
           // return list;
        } catch (SQLException exception) {
            try {
                statement.close();
                conn.close();
              //  return null;
            } catch (SQLException ex) {
                Logger.getLogger(TbCMCountryCityTMP.class.getName()).log(Level.SEVERE, null, ex);
               
              // return null;
            }
        } 
        return rs;
    }
    
    
    public String getTpNM(String tpCd){
       PreparedStatement statement = null;
       String nm = "";
       ResultSet rs = null;
      //  TbBwCust tbBwCust = new TbBwCust();
       System.out.println("tpCd "+tpCd);
        conn = Common.getConnection();
        try {
           
            statement = conn.prepareStatement(queryGetTpNM);
            statement.setString(1, tpCd);
            
            rs = statement.executeQuery();
            
            if(rs.next()){
                nm = rs.getString("CD_NM");
            }
            
            statement.close();
            conn.close();
             
           // return list;
        } catch (SQLException exception) {
            try {
                System.out.println("EXC "+exception.toString());
                statement.close();
                conn.close();
              //  return null;
            } catch (SQLException ex) {
                Logger.getLogger(TbCMCountryCityTMP.class.getName()).log(Level.SEVERE, null, ex);
               
              // return null;
            }
        } 
        return nm;
    }
    
    
}
