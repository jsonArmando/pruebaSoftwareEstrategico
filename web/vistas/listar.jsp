<%-- 

    Document   : list
    Created on : Jan 13, 2019, 10:05:50 AM
    Author     : json
--%>

<%@page import="java.util.Iterator"%>
<%@page import="modelo.persona"%>
<%@page import="java.util.List"%>
<%@page import="modeloDao.personaDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <title>Prueba Software Estratégico</title>
    </head>
    <body>
        <div class="container"> 
            <h1>
                Personas
            </h1>
            <h2>
                <a  class="btn btn-success" href="controlador?accion=add">Agregar Nueva Persona</a>
                <br>
                <br>
            </h2>
            Busqueda: (Nombres, Apellidos, Identificación): <br><br>
            <input class="form-control" id="myInput" type="text" placeholder="Search.."><br><br>
            <table class="table table-bordered table-striped" border="1">
                <thead>
                    <tr>
                        <th class="text text-center">id</th>
                        <th class="text text-center">Nombres</th>
                        <th class="text text-center">Apellidos</th>
                        <th class="text text-center">Telefono</th>
                        <th class="text text-center">Tipo de Identificación</th>
                        <th class="text text-center">Identificación</th>
                        <th class="text text-center">Fecha Nacimiento</th>
                        <th class="text text-center">Funciones</th>
                    </tr>
                </thead>
                <%
                    personaDao dao = new personaDao();
                    List<persona> list = dao.listar();
                    Iterator<persona> iter = list.iterator();
                    persona per = null;
                    while (iter.hasNext()) {
                        per = iter.next();

                %>
                <tbody id="myTable">
                    <tr>
                        <td class="text text-center"><%= per.getId()%></td>
                        <td class="text text-center"><%= per.getNombre()%></td>
                        <td class="text text-center"><%= per.getApellido()%></td>
                        <td class="text text-center"><%= per.getTelefono()%></td>
                        <td class="text text-center"><%= per.getTipoIdentificacion()%></td>
                        <td class="text text-center"><%= per.getIdentificacion()%></td>
                        <td class="text text-center"><%= per.getFechaNacimiento()%></td>
                        <td>
                            <a class="btn btn-warning" href="controlador?accion=editar&id=<%= per.getId()%>">Editar</a>
                            <a class="btn btn-primary" href="controlador?accion=eliminar&id=<%= per.getId()%>">Remove</a>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>
        <script>
            $(document).ready(function () {
                $("#myInput").on("keyup", function () {
                    var value = $(this).val().toLowerCase();
                    $("#myTable tr").filter(function () {
                        $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
                    });
                });
            });
        </script>

    </body>
</html>
