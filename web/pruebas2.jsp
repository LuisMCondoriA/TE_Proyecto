<%-- 
    Document   : pruebas2
    Created on : 14-12-2020, 02:20:29 PM
    Author     : wwwsd
--%>

<%@page import="java.math.BigInteger"%>
<%@page import="java.security.MessageDigest"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/alertify.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/default.min.css" rel="stylesheet" type="text/css"/>
        <script src="css/md5.js" type="text/javascript"></script>
    </head>
    <body>
        <h1>Hello World!</h1>
        <script src="css/alertify.min.js" type="text/javascript"></script>
        <script>
            alertify.message('todo bien');
        </script>
        
        <form>
            <input type="password" name="passv" onkeyup="this.form.passve.value=md5(this.form.passv.value)" placeholder="Ingresa tu contraseña" required=""/>
            <input type="text" name="passve" />
        </form>
        
        
    </body>
</html>
