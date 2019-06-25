<%-- 
    Document   : carrito
    Created on : 02/05/2019, 06:45:54 AM
    Author     : TOSHIBA
--%>

<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="utils.Conexiondb"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <h1 align="center">Carrito de compras</h1>
        
       
        
        
            <%
                response.setHeader("Cache-Control", "no-cache");
           response.setHeader("Cache-Control", "no-store");
           response.setHeader("Pragma", "no-cache");
           response.setDateHeader("Expires", 0);
            String cod=String.valueOf(request.getAttribute("codcarrito"));
            String codcli=String.valueOf(request.getAttribute("codclientes"));
           try{
                PreparedStatement sta=Conexiondb.getConexion().prepareStatement("select codpro, nombrepro, descripcion,precio from productos where codpro=?");
                sta.setString(1, cod);
               ResultSet rs=sta.executeQuery();
               while(rs.next()){
                   %>
                   <form action="Contollercarrito" method="post">
                       <input type="hidden"  name="codcli" value="<%=codcli%>">
                     <table border="0"  align="center">
                   <tr>
                       <td><img src="Controllerimagen?codpro=<%=cod %>" width="250" height="230"></td>
                   <td><input type="hidden" name="codpro" value="<%=rs.getString(1) %>" readonly="readonly"></td>
                   </tr>
                 <tr>
                <td>Nombre</td>
                <td><input type="text" name="nombre" value="<%=rs.getString(2) %>" readonly="readonly"></td>
                </tr>
                <tr>
                <td>Descripcion</td>
                <td><input type="text" name="descripcion" value="<%=rs.getString(3) %>" readonly="readonly"></td>
                </tr>
                <tr>
                <td>Precio</td>
                <td><input type="text" name="precio" value="<%=rs.getDouble(4) %>" readonly="readonly"></td>
                </tr>
                <tr>
                <td>Cantidad</td>
                <td><input type="number" name="cantidad" min="0" max="100" step="1" value="0"></td>
                </tr>
                <tr>
                    <td><input class="btn btn-info" type="submit" value="Añadir producto" name="btnagregacarro"></td> 
                </tr>
                   
                     </table>
                
                </form>
                    <%
                                    }
            }catch(Exception e){System.out.println(e);}
            %> 
            
            
    </body>
</html>
