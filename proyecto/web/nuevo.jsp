<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : nuevo
    Created on : 29/04/2019, 11:12:56 AM
    Author     : TOSHIBA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <h1 align="center" >Nuevo producto</h1>
        <br>
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
        <table border="0"  align="center"  >
            
          <tr>
              <td >Nombre</td>
                <td><input  class="form-control"  type="text" name="nombre" required pattern="[A-Za-z0-9. ]+" minlength="5" maxlength="25"
                            title="Solo letras y numeros estan permitidas en este campo. Tamaño mínimo: 5. Tamaño máximo: 20"></td>
                </tr>
                <tr>
                <td>Descripcion</td>
                <td><input  class="form-control" type="text" name="descripcion" required="required" pattern="[a-zA-Z0-9. ]+" minlength="5" maxlength="40"
                           title="Solo letras y numeros estan permitidas en este campo. Tamaño mínimo: 5. Tamaño máximo: 40"></td>
                </tr>
                <tr>
                <td>Precio</td>
                <td><input class="form-control"  type="text" name="precio" required pattern="^[0-9]{1,5}(\.[0-9]{0,2})?$" minlength="1" maxlength="5"
                            title="Solo numeros estan permitidos en este campo. Tamaño mínimo: 1 Tamaño máximo: 5"></td>
                </tr>
                <tr>
                <td>Stock</td>
                <td><input  class="form-control" type="text" name="stock" required="required" pattern="[0-9]+" minlength="1" maxlength="4"
                            title="Solo numeros positivos en este campo. Tamaño mínimo: 1. Tamaño máximo: 4"></td>
                </tr>
                <tr>
                <td>Medida</td>
                <td> <select name = "medida" class="form-control" required="required">
                                         <option value="">Seleccione un opcion..</option>
                                        <c:forEach items = "${lista1}" var = "medida">
                                            <option value = "${medida.getIdmed()}"> ${medida.getNomed()} </option>
                                        </c:forEach>
                                    </select></td>
                </tr>
                  <tr>
                <td>Categoria</td>
                <td> <select name = "categoria" class="form-control" required="required" >
                                         <option value="">Seleccione un categoria..</option>
                                        <c:forEach items = "${lista2}" var = "categoria">
                                            <option value = "${categoria.getIdcate()}"> ${categoria.getNomcate()} </option>
                                        </c:forEach>
                                    </select></td>
                </tr>
                <tr>
                <td>Imagen</td>
                <td><input class="form-control "  id="file-input" class="btn btn-outline-light" type="file" name="filefoto" required="required" accept="image/*"></td>
                 <td><img id="imgSalida"  width="250" height="230" src=""></td>
                </tr>
                <td><input class="btn btn-info" type="submit" name="action2" value="Guardar"></td>
                </table>
            </form>
        
    </body>
</html>
