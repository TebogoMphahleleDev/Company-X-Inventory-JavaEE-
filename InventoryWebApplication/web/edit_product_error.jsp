<%-- 
    Document   : edit_product_error
    Created on : Sep 17, 2025
    Author     : User
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error Editing Product</title>
    </head>
    <body>
        <h1>Error Editing Product</h1>
        <%
            String errorMessage = (String) request.getAttribute("errorMessage");
            if (errorMessage != null) {
        %>
        <p>Error: <%= errorMessage %></p>
        <%
            } else {
        %>
        <p>An unknown error occurred while attempting to edit the product.</p>
        <%
            }
        %>
        <p><a href="edit_product.jsp">Try again</a></p>
    </body>
</html>