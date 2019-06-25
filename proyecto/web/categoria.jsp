<%-- 
    Document   : categoria
    Created on : 21/06/2019, 01:12:09 PM
    Author     : TOSHIBA
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="clases.meses"%>
<%@page import="utils.Conexiondb"%>
<%@page import="java.sql.CallableStatement"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="clases.categoria"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DAO.ProductosDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
             String codcli=request.getAttribute("codcli").toString();
             int idcate=Integer.parseInt(request.getAttribute("idcate").toString());
             
             
             %>
         
        <nav class="navbar navbar-expand-md navbar-light bg-dark sticky-top">
       <div class="container-fluid">
           <a class="navbar-brand"><img src="imagen/logo2.png"></a>
           <div class="collapse navbar-collapse" id="navbarResponsive">
               <ul class="navbar-nav ml-auto">
                   <li class="nav-item ">
                       <a class="nav-item" style="color: #fff;margin-right: 150px">Bienvenido al sistema, Administrador: <%=codcli %></a>
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
                               <li><a  href="Controller?action=cate&codcli=<%= codcli %>&id=<%=String.valueOf(c.getIdcate()) %>"><%=c.getNomcate() %></a></li>
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
                       <br>
    <center>
                       <input type="hidden" name="aea1" value="<%= codcli %>">
                        <input type="hidden" name="aea2" value="<%= idcate %>">
                        
       
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
                         CallableStatement cs=Conexiondb.getConexion().prepareCall("{Call buscateadmin(?)}");
                         cs.setInt(1, idcate);
                        rs=cs.executeQuery();
                         String consulta=request.getParameter("txtbusca2");
                         if(request.getParameter("btnconsulta2")!=null){
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

                         
}catch(Exception e){System.out.println("20"+e);}
                         %>
                      
                      
                       
                </tbody>
            </table>
       
    </center>
        
            
    </body>
</html>
