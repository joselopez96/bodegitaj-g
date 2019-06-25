<%-- 
    Document   : login
    Created on : 02/05/2019, 01:06:34 AM
    Author     : TOSHIBA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Form login</title>
        <link href="css/estilo.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        
        <div id="contenedor1">
            <h1>Sign in</h1>
            <form action="Controllerlogin" method="post" id="form1">
            
                
                <img src="imagen/user.png" alt=""width="50" height="30"/>
                <input type="text" name="txtuser" placeholder="Username">
                <hr>
                <img src="imagen/user.png" alt="" width="50" height="30"/>
                <input type="password" name="txtcontra" placeholder="Password">
                <hr>
                <input type="submit" value="Sign in" name="btningresar">
           
             </form>

        </div>
        <div id="contenedor2">
            <form id="form2" action="Controllerlogin" method="get">
                <input type="submit" value="Create Account" name="nuevacuenta">
            </form>
            <div id="referencias">
                <a>BodegaJ&G®</a>
                <a href="">Term of Use</a>
                 <a href="">Privacy Policy</a>
            </div>
        </div>
    </body>
</html>
