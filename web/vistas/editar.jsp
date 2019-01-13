<%-- 
    Document   : editar
    Created on : Jan 13, 2019, 10:06:14 AM
    Author     : json
--%>

<%@page import="modelo.persona"%>
<%@page import="modeloDao.personaDao"%>
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
            <%
              personaDao dao=new personaDao();
              int id=Integer.parseInt((String)request.getAttribute("idper"));
              persona p=(persona)dao.list(id);
            %>
            <h1>Modificar Personas</h1>
            <form action="controlador">
                Nombres: <br>
                <input class="form-control"  type="text" name="txtNombre" value="<%=p.getNombre() %>"><br>
                Apellidos: <br>
                <input class="form-control"  type="text" name="txtApellido" value="<%=p.getApellido() %>"><br>
                Telefono: <br>
                <input class="form-control"  type="text" name="txtTelefono" value="<%=p.getTelefono() %>"><br>
                Tipo de Identificación: <br>
                <input class="form-control"  type="text" name="txtTipoIdentificacion" value="<%=p.getTipoIdentificacion() %>"><br>
                Identificación: <br>
                <input class="form-control"  type="text" name="txtIdentificacion" value="<%=p.getIdentificacion() %>"><br>
                Fecha Nacimiento: <br>
                <input class="form-control"  type="text" name="txtFechaNacimiento" value="<%=p.getFechaNacimiento() %>"><br>
                <input type="hidden" name="txtid" value="<%=p.getId() %>"><br>
                <input class="btn btn-primary" type="submit" name="accion" value="Actualizar">
                <a class="btn btn-primary" href="controlador?accion=listar">Regresar</a>
            </form>
            </div>
        </div>
    </body>
</html>
