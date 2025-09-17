<%-- 
    Document   : all_products_output
    Created on : Sep 15, 2025, 2:37:14 PM
    Author     : User
--%>
<%@page import="java.util.List"%>
<%@page import="com.unventory.entities.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All Product Output Page</title>
    </head>
    <body>
        <h1>All Available Products</h1>
        
        <%
            List<Product> allProducts = (List<Product>) request.getAttribute("allProducts");
            if (allProducts == null || allProducts.isEmpty()) {
        %>
        <p>No products are currently available in the database.</p>
        <%
            } else {
                for (Product product : allProducts) {
        %>
        <p>Name: <%= product.getName() != null ? product.getName() : "N/A" %></p>
        <p>Description: <%= product.getDescription() != null ? product.getDescription() : "N/A" %></p>
        <p>Price: R <%= product.getPrice() != null ? product.getPrice() : "N/A" %></p>
        <p>SKU: <%= product.getSku() != null ? product.getSku() : "N/A" %></p>
        <p>Barcode: <%= product.getBarcode() != null ? product.getBarcode() : "N/A" %></p>
        <hr>
        <%
                }
            }
        %>
        <p><a href="index.jsp">Back to Home</a></p>
    </body>
</html>