<%-- 
    Document   : add
    Created on : Jan 13, 2019, 10:05:41 AM
    Author     : json
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>Prueba Software Estratégico</title>
    </head>
    <body>
        <div class="container">
            <div class="col-lg-6">
                <h1>Agregar Personas</h1> 
                <form action="controlador">
                    Nombres: <br>
                    <input class="form-control" type="text" name="txtNombre"><br>
                    Apellidos: <br>
                    <input class="form-control" type="text" name="txtApellido"><br>
                    Telefono: <br>
                    <input class="form-control" type="text" name="txtTelefono"><br>
                    Tipo de Identificación: <br>
                    <input class="form-control" type="text" name="txtTipoIdentificacion"><br>
                    Identificación: <br>
                    <input class="form-control" type="text" name="txtIdentificacion"><br>
                    Fecha Nacimiento: <br>
                    <input class="form-control" type="text" name="txtFechaNacimiento"><br>
                    <input class="btn btn-primary" type="submit" name="accion" value="Agregar">
                    <a class="btn btn-primary" href="controlador?accion=listar">Regresar</a>
                </form>
            </div>

        </div>
    </body>
</html>
