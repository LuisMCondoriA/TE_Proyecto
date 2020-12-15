

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <link href="css/estilos.css" rel="stylesheet" type="text/css"/>
        <link href="css/alertify.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/default.min.css" rel="stylesheet" type="text/css"/>
        
        
        
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
        
        <center><h1>Modificar datos</h1></center>
        <div class="container col-lg-3" style="background: #D0B193">
        <form action="Crearu" method="POST">
                <input type ="hidden" name="id" value="${id}"/>
                <input type ="hidden" name="fecha" value="${fecha}"/>
                <input type ="hidden" name="aux" value="1"/>
            <div class="form-group">
                <label style="color: white">Nombre:</label>
                <input class="form-control" type="text" name="nombre" value="${nombre}" required="" />
            </div>
            <div class="form-group">
                <label style="color: white">Apellido:</label>
                <input class="form-control" type="Text" name="apellido" value="${apellido}" required="" />
            </div>
            <div class="form-group">
                <label style="color: white">Correo:</label>
                <input class="form-control" type="email" name="correo" value="${correo}" required="" />
            </div>
            
            
            <input class="btn btn-danger btn-block" type="submit" value="Modificar" style="background: #A1500F; border-color: #A1500F"/>
               
        </form>
            <br>
            
        </div><br>
        <center><h1>Cambiar contraseña</h1></center>
        <div class="container col-lg-3" style="background: #D0B193">
    <form action="Crearu" method="POST">
                <input type ="hidden" name="id" value="${id}"/>
                <input type ="hidden" name="fecha" value="${fecha}"/>
                <input type ="hidden" name="aux" value="2"/>
                <input type ="hidden" name="nombre" value="${nombre}"/>
                <input type ="hidden" name="apellido" value="${apellido}"/>
                <input type ="hidden" name="correo" value="${correo}"/>
            <div class="form-group">
                <label style="color: white">Nueva contraseña</label>
                <input class="form-control" type="password" name="contra" value="" required=""/>   
            </div>
            
            
            <input class="btn btn-danger btn-block" type="submit" value="Modificar" style="background: #A1500F; border-color: #A1500F" />
               
        </form>
    </div>
        
    <div class="container col-lg-3" style="background: #fff;padding-top: 0px">    
    <a href="PaginaPrincipal.jsp" style="text-decoration: none"><input class="btn btn-danger btn-block" style="background-color: #931C1C" type="submit" value="Cancelar"/></a> 
    </div>
    
    </section> 
    
    
    
    <script src="css/alertify.min.js" type="text/javascript"></script>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    
    <footer style="height: 50px;background: rgba(0,0,0,0.9);text-align: center;margin-top: 10px;">
                                <p style="color: white;padding-top: 10px;">Todos los derechos reservados
                                <img src="img/iconos.png" alt="" height="40px" aling="left" style="float: right; padding-right: 50px"/>
                                </p>
                            </footer>
    </body>
</html>
