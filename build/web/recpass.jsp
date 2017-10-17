<%-- 
    Document   : recpass
    Created on : Dec 17, 2016, 11:16:51 PM
    Author     : Hansome
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Recovery Password</title>
    </head>
    <body>
        <form method="POST" action='RecoveryServlet' name="frmRec">
    
        <h1>New Password : </h1>
        <input type="password" id="passNew" value=""/><br/>
   <!--     <h1>Confirmation : </h1>
        <input type="passwor2d" id="passNew2" value=""/><br/> -->
         <input type="submit" value="Submit" />   
        
    </body>
</html>
