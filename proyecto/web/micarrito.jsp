<%-- 
    Document   : micarrito
    Created on : 07/05/2019, 07:26:20 AM
    Author     : TOSHIBA
--%>

<%@page import="DAO.ProductosDAO"%>
<%@page import="clases.registros"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <body>
        <%
            response.setHeader("Cache-Control", "no-cache");
           response.setHeader("Cache-Control", "no-store");
           response.setHeader("Pragma", "no-cache");
           response.setDateHeader("Expires", 0);
            
            %>
        <h1 align="center">Carrito de Compras</h1>
        <div class="container">
            <table class="table table-striped table-bordered">
                <thead class="table-danger" >
                    <tr>
                        <th>Id Venta</th>
                        <th>Nombre de producto</th>
                        <th>Precio</th>
                        <th>Cantidad</th>
                        <th>Importe</th>
                        <th>Accion</th>
                       
                    </tr>
                </thead>
        <%
            String codcliente=String.valueOf(request.getAttribute("codclientess"));
            ArrayList<registros> reg= new ArrayList<>();
            ProductosDAO dao= new ProductosDAO();
            reg=dao.listaregistros(codcliente);
            for(registros r:reg){
                %>
                <tbody>
                <tr>
                    <td><%=r.getIdventa() %></td>
                   <td><%=r.getNombrepro()%></td>
                   <td><%=r.getPrecio()%></td>
                    <td><%=r.getCantidad()%></td>
                    <td><%=r.getImporte()%></td>
                    <td><a href="Contollercarrito?action=elimcarro&codreg=<%=r.getIdventa() %>&codcli=<%=codcliente%>">Eliminar</a></td>
                </tr>

              
                
                
                <%
            }
            
            %>
              </tbody> 
                </table>
              </div>
              <form action="Controllerboleta" method="post">
        <center>
            <br>
            <input class="btn btn-info" type="submit" name="btnboleta"  value="Aceptar" >
            <input class="btn btn-info" type="submit" name="btncancelar" value="Cancelar" >
            <input type="hidden" name="txtcodcli" value="<%= codcliente%>">
            </center>
            </form>
    </body>
</html>
