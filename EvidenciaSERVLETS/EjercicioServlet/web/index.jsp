<%-- 
    Document   : index
    Created on : 8/04/2025, 8:54:21 a. m.
    Author     : rpjrojas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head><title>Buscar Usuarios</title></head>
<body>
    <h2>Buscar Usuario</h2>
    <form action="SVUsuarios" method="GET">
        Nombre de usuario: <input type="text" name="username" />
        <input type="submit" value="Buscar" />
    </form>
    <hr>
    <h2>Agregar Nuevo Usuario</h2>
    <form action="SVUsuarios" method="post">
        <p>Nombre de usuario: <input type="text" name="username" required /></p>
        <p>Contraseña: <input type="password" name="password" required /></p>
        <input type="submit" value="Agregar Usuario" />
        <input type="hidden" name="accion" value="insertar" />
    </form>
    <hr>
    <h2>Eliminar Usuario</h2>
    <form action="SVUsuarios" method="post">
        Nombre de usuario: <input type="text" name="username" required />
        <input type="hidden" name="accion" value="eliminar" />
        <input type="submit" value="Eliminar Usuario" />
    </form>
    <hr>
    <h2>Modificar Contraseña de Usuario</h2>
    <form action="SVUsuarios" method="post">
        <p>Nombre de usuario: <input type="text" name="username" required /></p>
        <p>Nueva contraseña: <input type="password" name="password" required /></p>
        <input type="hidden" name="accion" value="modificar" />
        <input type="submit" value="Modificar Contraseña" />
    </form>
</body>
</html>