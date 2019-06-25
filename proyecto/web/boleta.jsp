<%-- 
    Document   : boleta
    Created on : 13/05/2019, 08:10:46 PM
    Author     : TOSHIBA
--%>

<%@page import="clases.usuarios"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DAO.ProductosDAO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="utils.Conexiondb"%>
<%@page import="java.sql.CallableStatement"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        
         <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <h1 align="center">Boleta electronica</h1>
       
        <table border="0" align="center">
         <%
            String codcliente=request.getAttribute("codcliente").toString();
            %>
            <%
          ProductosDAO dao= new ProductosDAO();
          ArrayList<usuarios> lista=new ArrayList<usuarios>();
          lista=dao.listusu(codcliente);
          for(usuarios u:lista){
              %>
              
              <tr><td>Señor(a): <%=u.getNombre() %></td></tr>
                  <tr><td>DNI: <%=u.getDni()%></td></tr>
                  <tr><td>Direccion: <%=u.getDireccion()%></td></tr>
              
              <%
          }
            %>
            <br>
            </table>
           
    <center>
       
             <%
            try{
                CallableStatement cst=Conexiondb.getConexion().prepareCall("{Call fechabol(?)}");
                cst.setString(1, codcliente);
                ResultSet rs=cst.executeQuery();
                if(rs.next()){
                    %>
                    <p value="<%=rs.getString(1) %>">Fecha: <%=rs.getString(1) %></p>
        
                    <%
                        
                }
            }catch(Exception e){System.out.println(e);
            }
            %>

            
            </center>
            <table class="table-bordered" align="center" style="margin-top: 30px">
                <thead class="bg-success">
                    <tr align="center">
                        <th>Codigo producto</th>
                        <th>Nombre de producto</th>
                        <th>Cantidad</th>
                        <th>Precio unitario</th>
                        <th>Importe</th>
                    </tr>
                </thead>
           
            <%
                
            try{
                CallableStatement cs=Conexiondb.getConexion().prepareCall("{Call listboleta(?)}");
                cs.setString(1, codcliente);
                ResultSet rs=cs.executeQuery();
                while(rs.next()){
                    %>
                    <tbody class="bg-light">
                    <tr align="center">
                        <td><%=rs.getString(1)%></td>
                        <td><%=rs.getString(2)%></td>
                        <td><%=rs.getInt(3)%></td>
                        <td><%=rs.getDouble(4)%></td>
                        <td><%=rs.getDouble(5)%></td>
                        
                        
                         </tr>
                 
       
        
                    <%
                        
                }
            }catch(Exception e){System.out.println(e); }
            %>
               </tbody>
                 </table>
            <%
                try{
                    CallableStatement cstm=Conexiondb.getConexion().prepareCall("{ Call importetotal(?)}");
                    cstm.setString(1, codcliente);
                    ResultSet rs=cstm.executeQuery();
                    while(rs.next()){
                        %>
                        <div style="margin-top: 300px;margin-left: 700px" >Total a pagar: <input type="text" name="importet" value="<%=rs.getDouble(1) %>"> </div>
                        
                        <%
                    }
                }catch(Exception e){}


                %>
          
          
        
           
    </body>
</html>
