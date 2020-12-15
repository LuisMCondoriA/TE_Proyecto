<%-- 
    Document   : AdministrarCat
    Created on : 04-12-2020, 04:21:30 PM
    Author     : wwwsd
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <link href="css/estilos.css" rel="stylesheet" type="text/css"/>
        <title>Pagina principal</title>
    </head>
    <body>      
        <header>
            <nav>
                <ul>
                    <li><a href="index.jsp" style="text-decoration: none">Inicio</a></li>
                    <li><a href="iniciarsesion.jsp" style="text-decoration: none">Iniciar sesion</a></li>
                    <li><a href="crearusuario.jsp" style="text-decoration: none">Crear cuenta</a></li>
                </ul>
            </nav>
        </header>
                    
        <section class="contenido wrapper">
            
            <div id="informacion" style="background-color: #F9F6F3;border-radius: 15px;">
                    <center><img src="img/escudo.png" alt="" width="120px"/>
                        <p><font face="Comic Sans MS,Arial,Verdana">Proyecto final de Tecnologias Emergentes II<br>
                            Realizado por el estudiante Luis Miguel Condori<br>
                        “La diferencia entre donde estuviste ayer <br>
                        y donde estarás mañana <br>
                        es lo que pienses digas y hagas hoy.”</font></p>
                    </center>  
                                    
                 </div>  
            <div id="titulo">
                <center><h1 style="margin-top: 50px">Bienvenido a la pagina principal</h1><br>
                        <h3>Sistema de control de ingresos y gastos</h3><br><br> 
                    <p>Con esta pagina podras realizar el control de tus ingresos y gastos de manera optima, <br>
                        podras realizar el control de todos tus movimientos, tendras la capacidad de dirigir <br>
                        movimientos masivos asi como poder ayudar a otras personas con sus finanzas siendo invitado <br>
                        a administrar sus cuentas de ingresos y gastos. Registrate ya!!!</p>
                    <br>
               
                    
                    
                    </center>
            </div>
            <div id="cuerpo">
                <img src="img/moneye.jpg" alt="" width="100%" height="580px"/>
                
            </div>
            <br>
            <center><h4><font face="Comic Sans MS,Arial,Verdana">Lo que puedo hacer con el sistema</font></h4></center><br>
            <div style="float: right;width: 450px;height: 300px;margin-top: 10px;margin-right: 20px;padding-left: 15px;padding-right: 15px;background-color: #F9F6F3;border-radius: 15px;">
                <br><center><h4>Crea una cuenta para tu empresa</h4>
                <img src="img/tres.png" alt="" width="100px"/></center>
                <p><font face="Comic Sans MS,Arial,Verdana">Con la opcion de poder crear varias cuentas podras gestionar tu cuenta personal e inclusive de tu empresa, al crear una cuenta para tu empresa podras tener la posivilidad 
                de invitar a tus empleados para que gestionen la cuenta empresarial</font></p>
            </div>
            <div style="float: right;width: 450px;height: 300px;margin-top: 10px;margin-right: 20px;padding-left: 15px;padding-right: 15px;background-color: #F9F6F3;border-radius: 15px;">
                <br><center><h4>Administra los ingresos y gastos de tu familia</h4>
                <img src="img/dos.png" alt="" width="100px"/></center>
                <p><font face="Comic Sans MS,Arial,Verdana">Puedes compartir tu cuenta de ingresos y gastos con tu familia para que te ayuden en la gestion de la cuenta, asi podras llevar una cuenta familiar o inclusive 
                entre amigos</font></p>
            </div>
            <div style="float: right;width: 450px;height: 300px;margin-top: 10px;margin-right: 20px;padding-left: 15px;padding-right: 15px;background-color: #F9F6F3;border-radius: 15px;">
                <br><center><h4>Administra tus ingresos y gastos personales</h4>
                <img src="img/uno.png" alt="" width="100px"/></center>
                <p><font face="Comic Sans MS,Arial,Verdana">Puedes crear una o varias cuentas con un solo usuario para poder llevar el control de tus ingresos y gastos de manera mas optima y ordenada,
                </font></p>
            </div>
           
                   
        </section>
                    
                    
                    

                    
        <footer style="height: 50px;background: rgba(0,0,0,0.9);text-align: center;margin-top: 10px;">
                                <p style="color: white;padding-top: 10px;">Todos los derechos reservados
                                <img src="img/iconos.png" alt="" height="40px" aling="left" style="float: right; padding-right: 50px"/>
                                </p>
                            </footer>            
                   
                    
                    
                    
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    </body>
</html>
