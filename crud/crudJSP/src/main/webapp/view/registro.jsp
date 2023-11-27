<%-- 
    Document   : registro
    Created on : 25 nov 2023, 0:43:33
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
            <form method="post" action="control">
                <div class="row">
                    <div class="card black white-text center-align z-depth-4">
                        <<h3>Ventas</h3>
                    </div>
                </div>
                <div class="row">
                    <div class="col m3"></div>
                    <div class="col m3">Ingrese fecha</div>
                    <div class="col m3">
                        <input type="hidden" name="txtID" value="${base.id_venta}"/>
                        <input type="text" name="txtFecha" required="" value="${base.fecha}"/>
                    </div>
                </div>
                <div class="row">
                    <div class="col m3"></div>
                    <div class="col m3">Ingresar cliente</div>
                    <div class="col m3">
                        <select name="cmbCliente">
                            <option value="">---Ingrese---</option>
                            <c:forEach items="${baseCliente}" var="cl">
                                <c:choose>
                                    <c:when test="${base.cliente.id_cliente == cl.id_cliente}">
                                        <option value="${cl.id_cliente}" selected=""> ${cl.nombre} ${cl.apellido}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${cl.id_cliente}"> ${cl.nombre} ${cl.apellido}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="row">
                    <div class="col m3"></div>
                    <div class="col m3">Seleccionar Producto</div>
                    <div class="col m3">
                        <select name="cmbProducto">
                            <option value="">---Seleccione---</option>
                            <c:forEach items="${baseProducto}" var="gr">
                                <c:choose>
                                    <c:when test="${base.producto.id_producto == pr.id_producto}">
                                        <option value="${pr.id_producto}" selected="">${pr.nombre_producto}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${pr.id_producto}">${pr.nombre_producto}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="row">
                    <div class="col m3"></div>
                    <div class="col m6">
                        <input type="submit" name="btnSave" value="Guardar" class="btn black white-text z-depth-3"/>
                    </div>
                    
                </div>
            </form>
        </div>
        <script src="resources/js/jquery-3.3.1.js"></script>
        <script src="resources/js/materialize.js"></script>
        <script>
            $(document).ready(function(){
                $('select').formSelect();
            });
        </script>
    </body>
</html>
