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
        <h1>All the products available:</h1>
        
        <%
            List<Product> allProducts=(List)request.getAttribute("allProducts");
            
            for(Product products: allProducts )
            {
                %>
                    <p>Name: <%=products.getName()%></p>
                    <p>Description: <%=products.getDescription()%></p>
                    <p>Price:R <%=products.getPrice()%></p>
                    <p>SKU: <%=products.getSku()%></p>
                    <p>Barcode: <%=products.getBarcode()%></p>
                <%
                
            }
        %>
        
        
    </body>
</html>
