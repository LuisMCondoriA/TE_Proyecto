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
                                    <center><h2><strong>Administracion de cuentas</strong></h2></center>
                                    <p style="padding-left: 30px;padding-right: 30px;">Bienvenido a la seccion de administracion de cuentas, esta seccion es la mas importante
                                        puesto que aqui podras crear, modificar y eliminar cuentas para iniciar tus movimientos,
                                        en esta seccion tambien podras gestionar movimientos a las cuentas que tengas creadas o de las 
                                        que seas invitado, se recomienda gestionar tus cuentas con mucho cuidado ya que la eliminacion de una cuenta 
                                        conllevara a la eliminacion de todos los movimientos realizados en dicha cuenta sin la posibilidad de recuperar los datos <strong>TEN CUIDADO!!!</strong></p>
                                    
                                    <div class="tabla">
                                        <br>
                                        <p><strong>Ingresa el nombre de la nueva cuenta</strong></p>
                                        <center>
                                      
                                            <table style="background: #E9E3DE">
                                            <tr>
                                                    <form action="Cuentass" method="POST">
                                                    <input type ="hidden" name="id" value="${cuentas.id}"/>
                                                    <td>
                                                        <label><strong>Nombre de cuenta:</strong></label>
                                                    <input type="text" name="nombre_cuenta" value="${cuentas.nombre_cuenta}"/>
                                                    </td>
                                                    <td style="padding-left: 20px">
                                                    <input style="background-color: #A1500F;border-color: #A1500F" class="btn btn-danger" type="submit" value="Registrar"/>
                                                    </form>
                                                    </td>
                                                    <td style="padding-left: 10px">
                                                    <a href="Cuentass" ><input style="background-color: #AB1717;border-color: #AB1717" class="btn btn-danger" type="submit" value="Cancelar" /></a>
                                                    </td>
                                            </tr>
                                        </table>
                                        </center>
                                                    <br><br>      
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
