<%-- 
    Document   : categoria2
    Created on : 25/06/2019, 02:20:54 AM
    Author     : TOSHIBA
--%>

<%@page import="clases.categoria"%>
<%@page import="DAO.ProductosDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="clases.Productos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
         ProductosDAO dao=new ProductosDAO();
          response.setHeader("Cache-Control", "no-cache");
           response.setHeader("Cache-Control", "no-store");
           response.setHeader("Pragma", "no-cache");
           response.setDateHeader("Expires", 0);%>
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
             String codcli=request.getAttribute("codcli2").toString();
             int idcate=Integer.parseInt(request.getAttribute("idcate2").toString());
             
             
             %>
              <nav class="navbar navbar-expand-md navbar-light bg-dark sticky-top">
       <div class="container-fluid">
           <a class="navbar-brand"><img src="imagen/logo2.png"></a>
           <div class="collapse navbar-collapse" id="navbarResponsive">
               <ul class="navbar-nav ml-auto">
                   <li class="nav-item ">
                       <a class="nav-item" style="color: #fff;margin-right: 150px">Bienvenido al sistema, cliente: <%=codcli %></a>
                </li>
                <ul class="nav">
                   <li >
                       <a style="color: #fff" href="">Categorias</a>
                       <ul>
                           <% 
                        
                                       
                               ArrayList<categoria> lista=dao.categoria();
                               for(categoria c:lista){
                               %>
                               <li><a href="Controller?action=cate2&codcli2=<%= codcli %>&id2=<%=String.valueOf(c.getIdcate()) %>"><%=c.getNomcate() %></a></li>
                           <%} %>
                       </ul>
                       </ul>
                   <li class="nav-item active fake" style=" background-color: #434342;
                 color:#fff;
                 text-decoration: none;
                 display: block;">
                       <a class="nav-link"style="color: #fff" href="Contollercarrito?action=carrito&codcli=<%=codcli %>">Ir al carrito</a>
                   </li>
                    <li class="nav-item active fake" style=" background-color: #434342;
                 color:#fff;
                 text-decoration: none;
                 display: block;">
                    <a class="nav-link" style="color: #fff" href="Controllerlogin?cerrar=true">Cerrar sesion</a>
                </li>
                
                </ul>
          </div>  
        </div>
            </nav>
                   <h2 align="center">Catalogo de productos</h2>
             <table border="0" width="1000" align="center" id="tutio2">
                 <div class="container-fluid padding">
                    <div class="row padding">
                    <div class="col-md-4">
                    <div class="card">
             <% 
                      
                     
                        ArrayList<Productos> list=new ArrayList<>();
                        list=dao.clientecate(idcate);
                        int salto=0;
                        for(Productos e: list){
                            
                    %>
                    
                    <th >
                        <img class="card-img-top" src="Controllerimagen?codpro=<%=e.getCodpro()%>"width="250" height="230"><p>
                        <div class="card-body">
                            <center>
                            <h4><%=e.getNombre()%><h4><br>
                                <%=e.getDescripcion()%><br>
                               S/. <%=e.getPrecio()%></p>
                                
                            <a href="Contollercarrito?action=comprar&codpro=<%=e.getCodpro()%>&codcli=<%=codcli%>" class="btn btn-outline-secondary" >Comprar</a>   
                   </center>
                                </th>
                                                      </div>
                           
                    <%
                        salto++;
                        if(salto==3){
                            
                        salto=0;    
                        %>
                        <tr>
                    
                    <% }
}

                    
                    %>
                 
                                      </div>
                                    </div>
                            </div>
                    </div>
                    </table>
         
    </body>
</html>
