<%-- 
    Document   : reporteprodvendido
    Created on : 08/06/2019, 12:42:09 PM
    Author     : TOSHIBA
--%>

<%@page import="clases.productosmasvend"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.CallableStatement"%>
<%@page import="utils.Conexiondb"%>
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
            response.setHeader("Cache-Control", "no-cache");
           response.setHeader("Cache-Control", "no-store");
           response.setHeader("Pragma", "no-cache");
           response.setDateHeader("Expires", 0);
            
            %>
        <h1 align="center">Top de productos vendidos</h1>
        <form action="reporteprodvendido.jsp">
             <center>
        <p>Ingrese top para el producto mas vendido</p>
        <input type="number" min="2" max="100" step="1" value="2" name="top" pattern="[0-9]"><br>
        <input type="submit" name="btn" value="buscar">
             </center>
        </form>
        <br>
        <table class="table-bordered" align="center" >
            <thead class="bg-success">
                <tr align="center">
                    <th>Coddigo de producto</th>
                    <th>Nombre de producto</th>
                     <th>Cantidad comprada</th>
                </tr>
            </thead>
           
      

        
        
  <%
      
      try{
          
     ResultSet rs;
     
     //int nro=Integer.parseInt(request.getParameter("top"));
        ArrayList<productosmasvend> masvend= new ArrayList<>();
        CallableStatement cs= Conexiondb.getConexion().prepareCall("{Call listaprodvend}");
        rs=cs.executeQuery();  
        String nrofilas=request.getParameter("top");
        if(request.getParameter("btn")!=null){
            if(nrofilas!=null){
                CallableStatement cstm= Conexiondb.getConexion().prepareCall("{Call prodmasvendido(?)}");
           cstm.setString(1, nrofilas);
            rs=cstm.executeQuery();
            }else{
                request.getRequestDispatcher("reporteprodvendido").forward(request, response);
            }
            
        }
           
          
        
           while(rs.next()){
               %>
                <tbody class="bg-light">
                <tr align="center">
                    <td><%=rs.getString(1) %></td>
                    <td><%=rs.getString(2) %></td>
                    <td><%=rs.getInt(3) %></td>
                </tr>
            </tbody>
               
               
               
               
           <%    
           }
           
      }catch(Exception e){System.out.println("20"+e);}
      
     
   %>
    </table>      
    
        
        
        
        
        
        
    </body>
</html>
