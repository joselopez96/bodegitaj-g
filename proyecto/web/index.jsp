<%-- 
    Document   : index
    Created on : 24/04/2019, 01:34:57 PM
    Author     : TOSHIBA
--%>


<%@page import="clases.categoria"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.CallableStatement"%>
<%@page import="utils.Conexiondb"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="clases.Productosadmin"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.io.ByteArrayInputStream"%>
<%@page import="java.awt.Image"%>
<%@page import="java.io.BufferedInputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="javax.swing.ImageIcon"%>
<%@page import="javax.imageio.ImageIO"%>
<%@page import="java.awt.image.BufferedImage"%>
<%@page import="DAO.ProductosDAO"%>
<%@page import="clases.Productos"%>
<a href="../src/java/Servet/Controllerimagen.java"></a>
<%@page import="java.util.ArrayList"%>
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
         <style type="text/css">
             ul,ol{
                 list-style: none;
             }
             .nav li a{
                 background-color: #434342;
                 color:#fff;
                 text-decoration: none;
                 padding: 10px 15px;
                 display: block;
             }
             
             .nav li a:hover{
                 background-color: #003366;
             }
             .nav li ul{
                 display: none;
                 position: absolute;
                 min-width: 140px;
             }
             .nav li:hover > ul{
                 display: block;
             }
             .fake a:hover{
                  background-color: #003366;
             }
             
         </style>
       <%
           response.setHeader("Cache-Control", "no-cache");
           response.setHeader("Cache-Control", "no-store");
           response.setHeader("Pragma", "no-cache");
           response.setDateHeader("Expires", 0);
            HttpSession sesion=request.getSession();
            String usuario;
            String nivel;
            if(sesion.getAttribute("user")!=null && sesion.getAttribute("nivel")!=null){
                usuario=sesion.getAttribute("user").toString();
                nivel=sesion.getAttribute("nivel").toString();
                
                %>
                 
                
              
<%
String user=sesion.getAttribute("user").toString();
            %>
      
       <nav class="navbar navbar-expand-md navbar-light bg-dark sticky-top">
       <div class="container-fluid">
           <a class="navbar-brand"><img src="imagen/logo2.png"></a>
           <div class="collapse navbar-collapse" id="navbarResponsive">
               <ul class="navbar-nav ml-auto">
                   <li class="nav-item ">
                       <a class="nav-item" style="color: #fff;margin-right: 150px">Bienvenido al sistema, Administrador: <%=user %></a>
                </li>
                <li class="nav-item active fake" style=" background-color: #434342;
                 color:#fff;
                 text-decoration: none;
                 display: block;">
                       <a class="nav-link"style="color: #fff" href="Controller?action=Nuevo">Nuevo Producto</a>
                   </li>
                   <ul class="nav">
                   <li >
                       <a style="color: #fff" href="">Categorias</a>
                       <ul>
                           <% 
                               ProductosDAO dao=new ProductosDAO();
                                       
                               ArrayList<categoria> lista=dao.categoria();
                               for(categoria c:lista){
                               %>
                               <li><a href="Controller?action=cate&codcli=<%= user %>&id=<%=String.valueOf(c.getIdcate()) %>"><%=c.getNomcate() %></a></li>
                           <%} %>
                       </ul>
                       </ul>
                   </li>
                   <ul class="nav">
                   <li>
                       <a style="color: #fff" href="">Reportes</a>
                       <ul>
                           <li><a href="Controller?action=Reportes" >Ventas por Fecha</a></li>
                           <li><a href="Controller?action=Topproducto">Top de productos</a></li>
                           <li><a href="Controller?action=Topcliente">Top de Clientes</a></li>
                       </ul>
                   </li>
                   </ul>
                    <li class="nav-item fake" style=" background-color: #434342;
                 color:#fff;
                 text-decoration: none;
                 display: block;">
                    <a class="nav-link" style="color: #fff" href="Controllerlogin?cerrar=true">Cerrar sesion</a>
                </li>
                
                </ul>
          </div>  
        </div>
            </nav>
      
            
            <h3 align="center">CATALOGO DE PRODUCTOS</h3>
        <center>
           
            
            
            <form action="index.jsp">
                               <input type="text" name="txtbusca">
            <input class="btn-warning" type="submit" name="btnconsulta" value="Consultar">
             
            </form>
       
            <br>
       
       
    
            <table class="table-bordered" align="center"  >
                <thead class="bg-success">
                    <tr align="center">
                        <th>Codigo</th>
                        <th>Nombre de producto</th>
                        <th>Descripcion</th>
                        <th>Precio</th>
                        <th>Stock disponible</th>
                        <th>Unidad de medida</th>
                        <th>Imagen</th>
                        <th>Accion</th>
                    </tr>
                </thead>
                 <% 
                     try{   
                     ResultSet rs;
                         CallableStatement cs=Conexiondb.getConexion().prepareCall("{Call listaprodamin}");
                        rs=cs.executeQuery();
                         String consulta=request.getParameter("txtbusca");
                         if(request.getParameter("btnconsulta")!=null){
                         if(consulta!=null){
                         CallableStatement cstm=Conexiondb.getConexion().prepareCall("{Call consulprod(?)}");
                         cstm.setString(1, consulta);
                         rs=cstm.executeQuery();
                         }else{
                             request.getRequestDispatcher("index.jsp").forward(request, response);
                             %>
                             <td><h1>No se encontro resultados de la busqueda</h1></td>
                             <%
                             
                         }
                         }
                         while(rs.next()){
                           //imag=ImageIO.read(e.getImagen().getBinaryStream());
                           
                          
                    %>
                <tbody class="bg-light">
                    <tr align="center">
                       <td><%=rs.getString(1)%></td>
        <td><%=rs.getString(2)%></td>
        <td><%=rs.getString(3)%></td>
        <td><%=rs.getDouble(4)%></td>
        <td><%=rs.getInt(5)%></td>
        <td><%=rs.getString(6)%></td>             
                        <td><img src="Controllerimagen?codpro=<%=rs.getString(1)%>"width="250" height="230"</td>
                        
      
                        <td>
                            <a href="Controller?action=editar&codpro=<%=rs.getString(1)%>">Editar</a>
                            /<a href="Controller?action=eliminar&codpro=<%=rs.getString(1)%>">Eliminar</a>
                            
                            
                             </td>
                        </tr>
                         <%}

                         
}catch(Exception e){System.out.println(e);}
                         %>
                      
                         <%
            }else{
             request.getRequestDispatcher("login.jsp").forward(request, response);
}%>
                       
                </tbody>
            </table>
        </div>
    </center>
        
     

</body>
    
</html>
