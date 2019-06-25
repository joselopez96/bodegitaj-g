<%-- 
    Document   : nuevocliente
    Created on : 14/05/2019, 05:25:36 AM
    Author     : TOSHIBA
--%>

<%@page import="utils.Conexiondb"%>
<%@page import="java.sql.CallableStatement"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <h1 align="center">Formulario de registro</h1>
        <form action="Controllerlogin" method="post" > 
          
        <table border="0"  align="center" width="200" style="margin-top: 30px">
            
          <tr>
                <td>Nombre y apellidos:   </td>
                <td><input type="text" name="nombreusu" placeholder="requisito obligatorio" required pattern="[A-Za-z ]{5,40}"
         title="Solo letras estan permitidas en este campo. Tamaño mínimo: 5. Tamaño máximo: 40"></td>
                </tr>
                <tr>
                <td>Nombre de usuario:   </td>
                <td><input type="text" name="iduser" placeholder="requisito obligatorio"required pattern="[A-Za-z0-9]{5,40}"
         title="Letras y numeros. Tamaño mínimo: 5. Tamaño máximo: 40"></td>
                </tr>
                <tr>
                <td>Contraseña:   </td>
                <td><input type="password" name="contras" placeholder="requisito obligatorio" required pattern="[A-Za-z0-9]{8,15}"
         title="Letras y numeros. Tamaño mínimo: 8. Tamaño máximo: 15"></td>
                </tr>
                <tr>
                <td>DNI: </td>
                <td><input type="text" name="dni" placeholder="(max 8 caracteres)"required pattern="[0-9]{8,8}"
         title="Solo numeros en este campo. Tamaño mínimo: 8. Tamaño máximo: 8"></td>
                </tr>
                <tr>
                <td>Direccion o domicilio :  </td>
                <td><input type="text" name="domicilio" placeholder="ingrese su domicilio" required pattern="[A-Za-z0-9. ]+{8,15}"
         title="Solo numeros en este campo. Tamaño mínimo: 8. Tamaño máximo: 40"></td>
                </tr>
                <tr>
                <td>Correo electronico :  </td>
                <td><input type="email" name="correo" placeholder="example@gmail.com" ></td>
                </tr>
                
                <td><input class="btn btn-info" type="submit" name="action2" value="Registrarse" style="margin-top: 30px;margin-left: 100px"></td>
                </table>
        </form>
    </body>
</html>
