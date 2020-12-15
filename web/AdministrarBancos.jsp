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
                                    <center><h2><strong>Administracion de metodos de pago y cobro</strong></h2></center>
                                    <p>Bienbenido a la administracion de tus metodos de pagos y cobros, en esta seccion 
                                    podras incluir, modificar y eliminar los tipos de ingresos o gastos de tus 
                                    movimientos ya sea mediante efectivo o bancos, crear un metodo de cobro o pago 
                                    te ayudara a a distinguir los ingresos que resibiste ya sea en efectivo o un prestamo 
                                    y tambien distinguir los tipos de pagos que se han realizado. <br> Ten en cuenta que al 
                                    eliminar un tipo de ingreso o egreso, tambien se eliminaran todos los movimientos que 
                                    realizaste con los metodos que creaste <strong>TEN MUCHO CUIDADO!!!</strong></p>
                                    
                                    <div class="tabla">
                                        <br>
                                        <p> <strong>Lista de metodos de pago y cobro</strong> </p>
                                        <a href="Bancoss?action=add"><input type="submit" value="Registrar nuevo metodo" style="background-color: #A1500F;border-color: #A1500F" class="btn btn-danger "/></a>
                                        <center>
                                            <br>
                                        <table>
                                            <thead>
                                            <tr>
                                                <th>Metodos registrados</th>
                                                <th>Acciones</th>
                                                <th></th>
                                            </tr>
                                            </thead>
                                            <c:forEach var="item" items="${bancos}">
                                                <tr>
                                                    <td>${item.descripcion_bancos}</td>
                                                    <td><a href="Bancoss?action=edit&id=${item.id}"><input style="background-color: #A1500F;border-color: #A1500F;width: 100px; height: 40px" class="btn btn-danger" type="submit" value="Editar"/></a></td>
                                                    <td><a href="Bancoss?action=delete&id=${item.id}"><input style="background-color: #931C1C;border-color: #931C1C;width: 100px; height: 40px " class="btn btn-danger" type="submit" value="Eliminar" onclick="return ConfirmDelete()"/></a></td>
                                                </tr>
                                            </c:forEach>
                                        </table>
                                        </center>    
                                    </div>
                                    
                                </div>  
                          
                      
                    </section>
                    
                    
                    
                    
        <script>
        function ConfirmDelete()
        {
            var respuesta = confirm("Esta seguro de que desea eliminar. Los datos no se podran recuperar");
            if(respuesta == true)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        </script>               
                    
                    
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
