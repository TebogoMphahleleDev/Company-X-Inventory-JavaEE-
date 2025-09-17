<%-- 
    Document   : edit_product_output
    Created on : Sep 16, 2025, 9:21:59 AM
    Author     : User
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Output Page</title>
    </head>
    <body>
        <h1>Edit Output</h1>
        <%
            Long id = (Long) request.getAttribute("id");
            if (id != null) {
        %>
        <p>Product with ID: <%= id %> has been successfully updated.</p>
        <%
            } else {
        %>
        <p>Error: No product ID was provided.</p>
        <%
            }
        %>
        <p><a href="edit_product.jsp">Edit another product</a></p>
    </body>
</html>