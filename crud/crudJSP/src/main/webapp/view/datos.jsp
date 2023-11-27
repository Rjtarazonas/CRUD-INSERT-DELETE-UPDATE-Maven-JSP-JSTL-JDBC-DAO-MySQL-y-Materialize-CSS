<%-- 
    Document   : datos
    Created on : 24 nov 2023, 21:53:23
    Author     : jezuz
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="resources/css/materialize.css"/>

    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col mi2">
                    <div class="card black white-text center-align z-depth-3">
                        <<h3>Registro de compras de Panaderia D'Nena</h3>
                    </div>
                    <div class="col mi2">
                        <table class="responsive-table">
                            <tr class="black z-depth-4 white-text">
                                <th>ID_Venta</th>
                                <th>Fecha_Compra</th>
                                <th>Nombre</th>
                                <th>Apellido</th>
                                <th>Producto</th>
                                <<th></th>
                            </tr>
                            <c:forEach items="${base}" var="v">
                                <tr>
                                    <td>${v.id_venta}</td>
                                    <td>${v.fecha}</td>
                                    <td>${v.cliente.nombre}</td>
                                    <td>${v.cliente.apellido}</td>
                                    <td>${v.producto.nombre_producto}</td>
                                    <td>
                                        <a href="control?action=eliminar&id_venta=${v.id_venta}" class="btn red white-text z-depth-4">Eliminar</a>
                                        <a href="control?action=actualizar&id_venta=${v.id_venta}" class="btn green white-text z-depth-4">Actualizar</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
                        <a href="control?action=nuevo" class="btn btn-block black white-text z-depth-4"> Nueva vennta</a>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
