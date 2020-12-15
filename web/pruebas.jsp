
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/alertify.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/default.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1>Hello World!</h1>
        
        <form name="frm" action="pruebas2.jsp" >
            <input type="text" value="" name="txtNombre">
            <input type="submit" onclick="return validar_nombre()">
        </form>
        <script src="css/alertify.min.js" type="text/javascript"></script>
<script>
    function validar_nombre(){
        nom = document.frm.txtNombre.value;
        
        if (nom == 'hola'){
            alertify.error('el mensaje dice hola');       
            return true;        
        }else{
            alertify.error('el mensaje es otro');
            return false;
        }
    }
    
    
</script>
    </body>
</html>
