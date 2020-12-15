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
                                    <center><h2><strong>Movimientos</strong></h2></center>
                                    <center><h3>Cuenta: <strong>${cuentas.nombre_cuenta}</strong> </h3>
                                        <h5>Propietario: <strong>${cuentas.nombre} ${cuentas.apellido}</strong></h5>
                                    
                                    </center>
                                    
                                    <div class="tabla">
                                        <br>
                                        <p><strong>Movimientos realizados</strong></p>
                                        <a href="Movimientoss?action=add&id_cuenta=${cuentas.id}&id_propietario=${cuentas.id_propietario}"><input type="submit" value="Realizar nuevo movimiento" style="background-color: #A1500F;border-color: #A1500F" class="btn btn-danger "/></a>
                                        <a href="Cuentass?id=${id}"><input type="submit" value="Volver" style="background-color: #D3943F;border-color: #D3943F" class="btn btn-danger "/></a>
                                        <center>
                                            <br>
                                        <table>
                                            <thead>
                                            <tr>
                                                <th>Fecha</th>
                                                <th>Categoria</th>
                                                <th>Metodo</th>
                                                <th>Importe</th>
                                                <th>Descripcion</th>
                                                <th>Tipo</th>
                                                <th>Acciones</th>
                                               
                                            </tr>
                                            </thead>
                                            <c:forEach var="item" items="${movimientos}">
                                                <tr>
                                                    <td>${item.fecha}</td>
                                                    <td>${item.descripcion}</td>
                                                    <td>${item.descripcion_bancos}</td>
                                                    
                                                    <td>${item.cantidad}</td>
                                                    <td>${item.descripcion_mov}</td>
                                                    <td>${item.tipo}</td>
                                                    <td><center>
                                                    <a href="Movimientoss?action=edit&id_mov=${item.id_mov}&id_cuenta=${cuentas.id}&id_propietario=${cuentas.id_propietario}"><input style="background-color: #2D4685;border-color: #2D4685;width: 90px; height: 40px; margin: 5px" class="btn btn-danger" type="submit" value="Editar"/></a>
                                                    <c:if test="${cuentas.id_propietario==id}"><a href="Movimientoss?action=delete&id=${item.id_mov}&id_cuenta=${cuentas.id}"><input style="background-color: #B92C2C;border-color: #B92C2C;width: 90px; height: 40px; margin: 5px " class="btn btn-danger" type="submit" value="Eliminar" onclick="return ConfirmDelete()"/></a></c:if>
                                                    
                                                    
                                                    <a href="Movimientoss?action=detalles&id=${item.id_mov}&id_cuenta=${cuentas.id}"><input style="background-color: #A1500F;border-color: #A1500F;width: 110px; height: 40px; margin: 5px " class="btn btn-danger" type="submit" value="Ver detalles"/></a></center></td>
                                                </tr>
                                            </c:forEach>
                                        </table>
                                            <br>
                                            <p><strong>Total ingresos: </strong>${saldo.ingreso}</p>
                                            <p><strong>Total gastos: </strong>${saldo.gasto}</p>
                                            <p><strong>Saldo total </strong>${saldo.ingreso-saldo.gasto}</p>
                                            
                                            
         
                                            
                                            
                                            
                                            
                                        </center>    
                                    </div>
                                    
                                </div>  
                          
                        
                        
                    </section>
                    
                    
        <script>
        function ConfirmDelete()
        {
            var respuesta = confirm("Esta seguro de que desea eliminar el movimiento? Los datos se perderan para siempre");
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
