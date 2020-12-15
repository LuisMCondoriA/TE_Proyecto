
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <link href="css/estilos.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <header>
            <nav class="navbar" style="padding-top: 0px" >
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
        
                    
                    <section class="contenido wrapper" style="padding-right: 0px;padding-top: 0px;padding-left: 0px"><br>
                        <div style=" padding-top: 70px; float: right;width: 400px;height: 1040px;margin-top: 40px; margin-right: 0px; padding-left: 15px;padding-right: 15px;background-color: #353496;border-radius: 10px;">
                            <center><h4 style="color: white">Consejos para iniciar</h4></center>
                            <img src="img/line.jpg" alt="" width="100%"/>
                            <center><img src="img/editar.png" alt="" width="70px"/></center>
                            <p style="color:white">No te olvides de revizar tu buzon en el apartado de Usuario-Buzon, puede que tengas invitaciones pendientes</p>
                            
                            
                            <img src="img/line.jpg" alt="" width="100%"/>
                            <center><img src="img/organizar.png" alt="" width="70px"/></center>
                            <p style="color:white">Organiza todos tus movimientos con la fecha adecuada para asi gestionar tus cuentas de manera mas ordenada</p>
                            <img src="img/line.jpg" alt="" width="100%"/>
                            <center><img src="img/invitacion.png" alt="" width="70px"/></center>
                            <p style="color:white">NECESITAS AYUDA?, puedes enviar invitaciones a otros usuarios para que te ayuden a gestionar tus cuentas con tan solo su correo electronico</p>
                            <img src="img/line.jpg" alt="" width="100%"/>
                            <center><img src="img/cancelar.png" alt="" width="70px"/></center>
                            <p style="color:white">Puedes cancelar las invitaciones que realizaste antes de que el otro usuario la acepte, y asi tambien puedes eliminar a un usuario invitado en cualquier momento</p>    
                            <img src="img/line.jpg" alt="" width="100%" />
                            <center><img src="img/vertodo.png" alt="" width="70px"/></center>
                            <p style="color:white">Puedes ver todos tus movimientos en el apartado Cuentas, escoge la cuenta en la que deseas ver tus movimientos</p>
                        </div>
                        <div id="cuerp" style=" width: 70%;max-width: 670px; height: auto;margin: 0 auto; padding-left: 15px;padding-right: 15px">
                            <center><h1 style="padding-top: 80px">Bienvenido al sistema ${nombre} ${apellido}</h1><br>
                            <h5><font face="Comic Sans MS,Arial,Verdana">"La única forma segura de éxito es saber todo lo que puedas de lo que haces”</font></h5>           
                       </center> 
                            <img src="img/dinero.png" alt="" width="100%" style="width: 100%;height: auto;"/>
                        </div>
                        <div id="cuerp" style=" width: 70%;max-width: 670px; height: auto;margin: 0 auto; padding-left: 15px;padding-right: 15px">
                            <center><h5>Contacto</h5>
                                <p>Tienes dudas? Escribenos para que nos pongamos en contacto con usted, por favor rellena el siguiente formulario
                                 y nos contactaremos con usted tan pronto como sea posible</p>           
                       </center> 
                            <form action="PaginaPrincipal.jsp">
                            
                            <div class="form-group">
                                <label>Asunto</label>
                                <input class="form-control" type="text" name="correo" placeholder="Ingresa el asunto" required=""/>   
                            </div>    
                            <div class="form-group">
                                <label>Consulta</label>
                                <textarea class="form-control" cols="50" rows="5" placeholder="Escribe aqui tu consulta" required="" name="consulta"></textarea>  
                            </div>
                            <input class="btn btn-danger btn-block" type="submit" value="Enviar consulta" style="background: #A1500F; border-color: #A1500F" />

                        </form>
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
