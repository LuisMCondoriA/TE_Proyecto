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
        <title>Administrar categorias</title>
    </head>
    <body>
        
        <header>
            <nav class="navbar" style="padding-top: 0px">
                <ul>
                    <li><a href="PaginaPrincipal.jsp" style="text-decoration: none">Inicio</a></li>
                    <li><a href="Cuentass?id=${id}" style="color: white;text-decoration: none" >Cuentas</a></li>
                    <li><a href="Cat?id=${id}" style="color: white;text-decoration: none" >Categorias</a></li>
                    <li><a href="Bancoss?id=${id}" style="color: white;text-decoration: none" >Metodos de pago y cobro</a></li>
                    
                </ul>
                
                <div class="dropdown">
                <a style="color: white;padding-right: 100px;padding-top: 0px" href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">Usuario</a>
                <div class="dropdown-menu text-center">
                    <a>${nombre}</a>
                    <a>${apellido}</a>
                    <a>${correo}</a>
                    <div class="dropdown-divider"></div>
                        <p>Fecha creacion</p>    
                    <a>${fecha}</a>                     
                    <div class="dropdown-divider"></div>
                    <a href="Invitacioness?action=misinv" class="dropdown-item">Buzon</a>
                    <a href="frmmodificarusuario.jsp" class="dropdown-item">Modificar datos</a>
                    <a href="Crearu?action=close" class="dropdown-item">Cerrar sesion</a>
                </div>
            </div>
                
            </nav>
        </header> 
                    

                    
                    <section class="contenido wrapper">
                                <div class="texto">
                                    <center><h2>Buzon</h2></center>
                                    <p style="padding-left: 30px;padding-right: 30px">En esta seccion podra ver las invitaciones que te enviaron otros usuarios para que le ayude a administrar sus movimientos</p>
                                    
                                    <div class="tabla">
                                        <br>
                                        <p><strong>Invitaciones recibidas</strong></p>
                                       
                                        <center>
                                            <br>
                                            <table style="background: #E9E3DE">
                                            <thead>
                                            <tr>
                                                <th>Todas mis invitaciones</th>
                                                <th>Acciones</th>
                                                <th></th>
                                            </tr>
                                            </thead>
                                            <c:forEach var="item" items="${invitaciones2}">
                                                <tr>
                                                    <td>El usuario <strong>${item.nombre} ${item.apellido}</strong> te esta invitando a administrar la cuenta <strong>${item.nombre_cuenta}</strong></td>
                                                    <td><a href="Miembross?action=add&id_cuenta=${item.id_cuenta}&&id_inv=${item.id_inv}"><input style="background-color: #2D4685;border-color: #2D4685;width: 100px; height: 40px" class="btn btn-danger" type="submit" value="Aceptar"/></a></td>
                                                    <td><a href="Invitacioness?action=deleteinv&id=${item.id_inv}"><input style="background-color: #B92C2C;border-color: #B92C2C;width: 100px; height: 40px " class="btn btn-danger" type="submit" value="Rechazar"/></a></td>
                                                </tr>
                                            </c:forEach>
                                        </table>
                                        </center>    
                                    </div>
                                    
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
