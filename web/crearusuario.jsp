

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <title>Crear ussuario</title>
        <link href="css/estilos.css" rel="stylesheet" type="text/css"/>
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
            <center>
        <h2>Bienvenido al formulario para crear nuevo usuario</h2>
   
        </center>
        <div class="container col-lg-3" style="background: #D0B193">
        <form action="Crearu" method="POST">
            <div class="form-group">
                <h3 style="color: white">Registra tus datos</h3>
            </div> 
                <input type ="hidden" name="id" value="0"/>
                <input type ="hidden" name="fecha" value=""/>
                <input type="hidden" name="aux" value="3"/>
            <div class="form-group">    
                <label style="color: white">Nombre:</label>
                <input class="form-control" type="text" name="nombre" value="" required="" />
            </div>
            <div class="form-group">    
                <label style="color: white">Apellido:</label>
                <input class="form-control" type="Text" name="apellido" value="" required="" />
            </div>
            <div class="form-group">
                <label style="color: white">Correo:</label>
                <input class="form-control" type="email" name="correo" value="" required="" />
            </div>
            <div class="form-group">    
                <label style="color: white">Contraseña</label>
                <input class="form-control" type="password" name="contra" value="" required=""/>   
            </div>
                <input class="btn btn-danger btn-block" style="background: #A1500F; border-color: #E0B080" type="submit" value="Registrar"/>
        </form>
            <center><p style="color: white"> o <a href="iniciarsesion.jsp" style="text-decoration: none; color: white"><strong>inicia</strong>  </a> sesion en una cuenta existente</p></center>
    </div>
    
    
            <br><br>
     <center><h4><font face="Comic Sans MS,Arial,Verdana">Estas a un paso de poder acceder al sistema</font></h4></center><br>
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
