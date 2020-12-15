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
                   <p style="padding-left: 30px;padding-right: 30px">Bienvenido a la seccion de administracion de cuentas, esta seccion es la mas importante
                                        puesto que aqui podras crear, modificar y eliminar cuentas para iniciar tus movimientos,
                                        en esta seccion tambien podras gestionar movimientos a las cuentas que tengas creadas o de las 
                                        que seas invitado, se recomienda gestionar tus cuentas con mucho cuidado ya que la eliminacion de una cuenta 
                                        conllevara a la eliminacion de todos los movimientos realizados en dicha cuenta sin la posibilidad de recuperar los datos <strong>TEN CUIDADO!!!</strong></p>
                                    
                                    <div class="tabla">
                                        <br>
                                        <p><strong>Lista de cuentas de usuario</strong></p>
                                        <a href="Cuentass?action=add"><input type="submit" value="Registrar nueva cuenta" style="background-color: #A1500F;border-color: #A1500F" class="btn btn-danger "/></a>
                                        <a href="Invitacioness?id=${id}"><input type="submit" value="Administrar invitados e invitaciones" style="background-color: #BA6338;border-color: #BA6338" class="btn btn-danger "/></a>
                                       
                                            <br>
                                            <br>
                                        <table>
                                            <thead>
                                            <tr>
                                                <th>Mis cuentas</th>
                                                <th>Fecha de creacion</th>
                                                <th>Fecha de ultima modificacion</th>
                                                <th>Invitados</th>
                                                <th>Acciones</th>
                                               
                                            </tr>
                                            </thead>
                                            <c:forEach var="item" items="${cuentas}">
                                                <tr>
                                                    <td>${item.nombre_cuenta}</td>
                                                    <td>${item.fecha_creacion}</td>
                                                    <td>${item.fecha_modificacion}</td>
                                                    <td>  
                                                    <c:forEach var="itemm" items="${miembrosall}">
                                                        <c:if test="${itemm.id_cuenta==item.id}">- ${itemm.nombre} ${itemm.apellido}<br></c:if>
                                                    </c:forEach>
                                                    </td>
                                                    <td><center><a href="Movimientoss?id=${item.id}"><input style="background-color: #A1500F;border-color: #A1500F;width: 90px; height: 40px; margin: 5px" class="btn btn-danger" type="submit" value="Gestionar"/></a>
                                                    <a href="Invitacioness?action=add&id=${item.id}"><input style="background-color: #232284;border-color: #232284;width: 90px; height: 40px; margin: 5px" class="btn btn-danger" type="submit" value="Invitar"/></a>
                                                    <a href="Cuentass?action=edit&id=${item.id}"><input style="background-color: #A1500F;border-color: #A1500F;width: 90px; height: 40px; margin: 5px" class="btn btn-danger" type="submit" value="Editar"/></a>
                                                    <a href="Cuentass?action=delete&id=${item.id}"><input style="background-color: #B13725;border-color: #B13725;width: 90px; height: 40px; margin: 5px " class="btn btn-danger" type="submit" value="Eliminar" onclick="return ConfirmDelete()"/></a></center></td>
                                                </tr>
                                            </c:forEach>
                                        </table>
                                            <br><br>
                                            <p><strong>Lista de cuentas de terceros</strong></p>
                                            
                                            
                                                                                    <table>
                                            <thead>
                                            <tr>
                                                <th>Nombre de cuenta</th>
                                                <th>Propietario</th>
                                                <th>fecha de ingreso</th>
                                                <th>Acciones</th>
                                               
                                            </tr>
                                            </thead>
                                            <c:forEach var="items" items="${miembros}">
                                                <tr>
                                                    <td>${items.nombre_cuenta}</td>
                                                    <td>${items.nombre} ${items.apellido}</td>
                                                    <td>${items.fecha_ingreso}</td>
                                                    <td><center><a href="Movimientoss?id=${items.id_cuenta}"><input style="background-color: #7B1898;border-color: #7B1898;width: 90px; height: 40px; margin: 5px" class="btn btn-danger" type="submit" value="Gestionar"/></a>
                                                     </center></td>
                                                </tr>
                                            </c:forEach>
                                        </table>
                                            
                                            
                                            
                                            
                                            
                                           
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
                    
        <footer  style="height: 50px;background: rgba(0,0,0,0.9);text-align: center;margin-top: 10px;float: button;margin-bottom: 0px">
                                <p style="color: white;padding-top: 10px;">Todos los derechos reservados
                                <img src="img/iconos.png" alt="" height="40px" aling="left" style="float: right; padding-right: 50px"/>
                                </p>
                            </footer>      
                    
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    </body>
</html>
