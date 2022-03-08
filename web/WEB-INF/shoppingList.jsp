<%-- 
    Document   : shoppingList
    Created on : Feb 28, 2022, 8:29:52 PM
    Author     : ivanc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <p>Hello, ${username}</p>
        <a href="ShoppingList?action=logout">Log Out</a>
        <h2>List</h2>
        <form method="post" action="ShoppingList">
            <label>Add item: </label>
            <input type="text" name="item" value="">
            <input type="submit" name="action" value="add"><br>
            <c:forEach items="${itemList}" var="item">
                <input type="radio" name="items" value="${item}">
                <label>${item}</label><br>
            </c:forEach>
            <c:if test="${not isEmpty}">
                <input type="submit" name="action" value="delete">
            </c:if>
        </form>
    </body>
</html>
