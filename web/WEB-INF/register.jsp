<%-- 
    Document   : register
    Created on : Feb 28, 2022, 8:28:43 PM
    Author     : ivanc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <form method="post" action="ShoppingList">
            <label>Username: </label>
            <input type="text" name="username" value="">
            <input type="submit" name="action" value="register"><br>
        </form>
    </body>
</html>
