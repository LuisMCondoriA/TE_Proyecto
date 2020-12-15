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
                                        <br><center>
                                        <p>Realizar movimiento</p>
                                        
                                        
                                           
                                            
                                            <div class="container " style="width: 500px">
                                            
                                            
                                                    <form action="Movimientoss" method="POST">
                                                    <input type="hidden" name="id_mov" value="${movimientos.id_mov}"/>
                                                    <input type="hidden" name="id_cuenta" value="${cuentas.id}"/>
                                                    <div class="form-group">
                                                    <label>Cantidad:</label>
                                                    <input class="form-control" type="number" name="cantidad" value="${movimientos.cantidad}" required=""/>
                                                    </div> 
                                                    
                                                    <div class="form-group">
                                                        <label>Tipo:</label><br>
                                                    <input  type="radio" name="tipo" value="Ingreso" required="">Ingreso
                                                    <input  type="radio" name="tipo" value="Gasto" required="">Gasto
                                                    </div> 
                                                    
                                                    <div class="form-group">
                                                    <label>Fecha:</label>
                                                    <input class="form-control" type="date" name="fecha" value="${movimientos.fecha}" required=""/>
                                                    </div> 
                                                    
                                                    <div class="form-group">
                                                    <label>Categoria:</label>
                                                    <select class="form-control" name="id_categoria" required="">
                                                                <c:forEach var="item" items="${categorias}">
                                                                    <option  value="${item.id}">${item.descripcion}</option>
                                                                </c:forEach>
                                                            </select>
                                                    </div> 
                                                    
                                                    <div class="form-group">
                                                    <label>Metodo:</label>
                                                    <select class="form-control" name="id_bancos" required="">
                                                                <c:forEach var="items" items="${bancos}">
                                                                    <option  value="${items.id}">${items.descripcion_bancos}</option>
                                                                </c:forEach>
                                                            </select>
                                                    </div> 
                                                    <div class="form-group">
                                                    <label>Descripcion:</label>
                                                    <input class="form-control" type="text" name="descripcion_mov" value="${movimientos.descripcion_mov}"        
                                                    </div> 
                                                    </div> 
                                                    <div class="form-group">
                                                        <br>
                                                    <input class="btn btn-danger btn-block" style="background-color: #A1500F;border-color: #A1500F" class="btn btn-danger" type="submit" value="Registrar"/>
                                                    </div> 
                                                    </form>
                                                    <div>
                                                    <br>
                                                    <a href="Cuentass" style="text-decoration: none"><input class="btn btn-danger btn-block" style="background-color: #D3943F;border-color: #D3943F" class="btn btn-danger" type="submit" value="Cancelar" /></a>
                                                    </div> 
                                            
                                            
                                          
                                            
                                            
         
                                            
                                            
                                            
                                            
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
