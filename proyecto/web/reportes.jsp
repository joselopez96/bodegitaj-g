<%-- 
    Document   : reportes
    Created on : 13/05/2019, 11:34:16 AM
    Author     : TOSHIBA
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.CallableStatement"%>
<%@page import="utils.Conexiondb"%>
<%@page import="utils.Conexiondb"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

    </head>
    <%
            response.setHeader("Cache-Control", "no-cache");
           response.setHeader("Cache-Control", "no-store");
           response.setHeader("Pragma", "no-cache");
           response.setDateHeader("Expires", 0);
            
            %>
    <body>
        <h1 align="center">Reporte de ventas</h1>
        <form action="reportes.jsp">
            <center>
        <input type="date" min="01-01-2019" max="01-01-2020" name="selfecha">
        <input class="btn-warning" type="submit" name="btnconsulta" value="Consultar">
                    </center>

         </form>
        <table class="table-bordered" align="center" style="margin-top: 30px">
                <thead class="bg-success">
                    <tr align="center">
                        <th>Codigo producto</th>
                        <th>Nombre de producto</th>
                        <th>Cantidad</th>
                        <th>Precio unitario</th>
                        <th>Importe</th>
                        <th>Nombre de usuario</th>
                        <th>Fecha de venta</th>
                    </tr>
                </thead>
       
            
            <% 
                     try{
                     ResultSet rs;
                         CallableStatement cs=Conexiondb.getConexion().prepareCall("{Call listareportes}");
                        rs=cs.executeQuery();
                         String consulta=request.getParameter("selfecha").toString();
                         if(request.getParameter("btnconsulta")!=null){
                         if(consulta!=null){
                         CallableStatement cstm=Conexiondb.getConexion().prepareCall("{Call buscareportes(?)}");
                         cstm.setString(1, consulta);
                         rs=cstm.executeQuery();
                         }else{
                             request.getRequestDispatcher("reportes.jsp").forward(request, response);
                         }
                         }
                         while(rs.next()){
                           //imag=ImageIO.read(e.getImagen().getBinaryStream());
                           
                          
                    %>
                <tbody class="bg-light">
                    <tr align="center">
        <td><%=rs.getString(1)%></td>
        <td><%=rs.getString(2)%></td>
        <td><%=rs.getInt(3)%></td>
        <td><%=rs.getDouble(4)%></td>
        <td><%=rs.getDouble(5)%></td>             
         <td><%=rs.getString(6)%></td> 
         <td><%=rs.getString(7)%></td> 
                        </tr>
                         <%}

                         
}catch(Exception e){System.out.println("16"+e);}
                         %>
               </tbody>
                 </table>
        
    </body>
</html>
