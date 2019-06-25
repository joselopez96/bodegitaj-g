<%-- 
    Document   : topcliente
    Created on : 24/06/2019, 10:29:15 PM
    Author     : TOSHIBA
--%>
<%@page import="DAO.ProductosDAO"%>
<%@page import="clases.meses"%>
<%@page import="java.sql.CallableStatement"%>
<%@page import="utils.Conexiondb"%>
<%@page import="java.util.ArrayList"%>
<%@page import="clases.topcliente"%>
<%@page import="java.sql.ResultSet"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <%
            ProductosDAO dao=new ProductosDAO();
            ArrayList<meses> meses=dao.meses();
            request.setAttribute("mes", meses);
            %>
    <center>
        <h1>Filtro de clientes top</h1>
        <form action="topcliente.jsp">
        <select name = "mes" required="required">
                                         <option value="">Seleccione un opcion..</option>
                                        <c:forEach items = "${mes}" var = "mess">
                                            <option value = "${mess.getIdmes()}"> ${mess.getNomes()} </option>
                                        </c:forEach>
                                    </select>
        
            <input type="number" name="top" required="required" min="1" max="100" pattern="[0-9]">
        <input type="submit" name="btn">
        </form>
        
        <table class="table-bordered" align="center" >
            <thead class="bg-success">
                <tr align="center">
                    <th>Nombre</th>
                    <th>DNI</th>
                     <th>Direccion</th>
                     <th>Correo</th>
                     <th>mes</th>
                     <th>Importe</th>
                </tr>
            </thead>
           
      

        
        
  <%
      
      try{
          
     ResultSet rs;
     String nrofilas=request.getParameter("top");
     String mes=request.getParameter("mes");
        CallableStatement cs= Conexiondb.getConexion().prepareCall("{Call topclientedefault}");
        rs=cs.executeQuery();  
      
        if(request.getParameter("btn")!=null){
            if(nrofilas!=null && mes!=null){
                CallableStatement cstm= Conexiondb.getConexion().prepareCall("{Call topcliente(?,?)}");
           cstm.setString(1, mes);
            cstm.setString(2, nrofilas);
            rs=cstm.executeQuery();
            }
            
        }
           
          
        
           while(rs.next()){
               %>
                <tbody class="bg-light">
                <tr align="center">
                    <td><%=rs.getString(1) %></td>
                    <td><%=rs.getString(2) %></td>
                     <td><%=rs.getString(3) %></td>
                      <td><%=rs.getString(4) %></td>
                       <td><%=rs.getString(5) %></td>
                    <td><%=rs.getDouble(6) %></td>
                </tr>
            </tbody>
               
               
               
               
           <%    
           }
           
      }catch(Exception e){System.out.println("20"+e);}
      
     
   %>
    </table>      
    </center>
    </body>
</html>
