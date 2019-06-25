<%-- 
    Document   : editar
    Created on : 01/05/2019, 01:28:19 PM
    Author     : TOSHIBA
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="utils.Conexiondb"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
         <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <h2 align="center">Editar un producto</h2>
        
       
            <%
                response.setHeader("Cache-Control", "no-cache");
           response.setHeader("Cache-Control", "no-store");
           response.setHeader("Pragma", "no-cache");
           response.setDateHeader("Expires", 0);
            String cod=String.valueOf(request.getAttribute("codigo"));
           try{
                PreparedStatement sta=Conexiondb.getConexion().prepareStatement("select codpro, nombrepro, descripcion,precio,stock,imagen from productos where codpro=?");
                sta.setString(1, cod);
               ResultSet rs=sta.executeQuery();
               while(rs.next()){
                   %>
                   <form action="Controller" method="POST" enctype="multipart/form-data">
                            <script>
                    $(window).load(function(){

 $(function() {
  $('#file-input').change(function(e) {
      addImage(e); 
     });

     function addImage(e){
      var file = e.target.files[0],
      imageType = /image.*/;
    
      if (!file.type.match(imageType))
       return;
  
      var reader = new FileReader();
      reader.onload = fileOnload;
      reader.readAsDataURL(file);
     }
  
     function fileOnload(e) {
      var result=e.target.result;
      $('#imgSalida').attr("src",result);
     }
    });
  });
  
                </script>
  
                   
                    <table border="0"  align="center">
                   <tr>
                   <td>Codigo</td>
                   <td><input type="text" name="codpro" value="<%=rs.getString(1) %>" readonly="readonly" ></td>
                   </tr>
                 <tr>
                <td>Nombre</td>
                <td><input type="text" name="nombre" value="<%=rs.getString(2) %>" required pattern="[A-Za-z0-9. ]+" minlength="5" maxlength="20"
                            title="Solo letras y numeros estan permitidas en este campo. Tamaño mínimo: 5. Tamaño máximo: 20"></td>
                </tr>
                <tr>
                <td>Descripcion</td>
                <td><input type="text" name="descripcion" value="<%=rs.getString(3) %>" required pattern="[A-Za-z0-9. ]+" minlength="5" maxlength="40"
                           title="Solo letras y numeros estan permitidas en este campo. Tamaño mínimo: 5. Tamaño máximo: 40"></td>
                </tr>
                <tr>
                <td>Precio</td>
                <td><input type="text" name="precio" value="<%=rs.getDouble(4) %>" required pattern="^[0-9]{1,5}(\.[0-9]{0,2})?$" minlength="1" maxlength="5"
                            title="Solo numeros estan permitidos en este campo. Tamaño mínimo: 5. Tamaño máximo: 5"></td>
                </tr>
                <tr>
                <td>Stock</td>
                <td><input type="text" name="stock" value="<%=rs.getInt(5)%>" required pattern="^[0-9]{1,5}(\.[0-9]{0,2})?$" minlength="1" maxlength="5"
                            title="Solo numeros positivos en este campo. Tamaño mínimo: 5. Tamaño máximo: 4"></td>
                </tr>
                <tr>
                <td>Medida</td>
                <td> <select name = "medida" class="form-control" required="required">
                                         <option value="">Seleccione un opcion..</option>
                                        <c:forEach items = "${lista3}" var = "medida">
                                            <option value = "${medida.getIdmed()}"> ${medida.getNomed()} </option>
                                        </c:forEach>
                                    </select></td>
                </tr>
                 <tr>
                <td>Categoria</td>
                <td> <select name = "categoria" class="form-control">
                                         <option value="">Seleccione un categoria..</option>
                                        <c:forEach items = "${lista4}" var = "categoria">
                                            <option value = "${categoria.getIdcate()}"> ${categoria.getNomcate()} </option>
                                        </c:forEach>
                                    </select></td>
                </tr>
                <tr>
                <td>Imagen</td>
                <td><input id="file-input" type="file" name="filefotoact" value="<%=rs.getBlob(6) %>" required="required"></td>
                <td><img id="imgSalida"  width="250" height="230" src=""></td>
                
                </tr>
                <tr>
                    <td><input class="btn btn-info" type="submit" name="action2" value="Actualizar"></td>
                </tr>
                </table>
                      
         </form>
          <%
                                    }
            }catch(Exception e){System.out.println(e);}
            %> 
               
    </body>
</html>
