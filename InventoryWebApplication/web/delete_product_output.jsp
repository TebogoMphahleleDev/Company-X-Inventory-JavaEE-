<%-- 
    Document   : delete_product_output
    Created on : Sep 16, 2025, 1:57:42 PM
    Author     : User
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete Product Page</title>
    </head>
    <body>
        <h1>Delete Output</h1>
        <%
            Long id = (Long) request.getAttribute("id");
            if (id != null) {
        %>
        <p>Product with ID: <%= id %> has been successfully deleted from the system.</p>
        <%
            } else {
        %>
        <p>Error: No product ID was provided.</p>
        <%
            }
        %>
        <p><a href="delete_product.jsp">Delete another product</a></p>
    </body>
</html>