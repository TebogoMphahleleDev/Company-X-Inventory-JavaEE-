<%-- 
    Document   : edit_product
    Created on : Sep 15, 2025, 3:45:18 PM
    Author     : User
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.unventory.entities.Product"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Product Page</title>
    </head>
    <body>
        <h1>Edit Product</h1>
        
        <%
            String errorMessage = (String) request.getAttribute("errorMessage");
            Product product = (Product) request.getAttribute("product");
            if (product == null) {
        %>
        <h2>Enter Product ID to Edit</h2>
        <form action="EditProductServlet" method="POST">
            <table>
                <tr>
                    <td>Original ID: </td>
                    <td><input type="text" name="original_id" required=""></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" name="action" value="Fetch Product"></td>
                </tr>
            </table>
        </form>
        <%
            } else {
        %>
        <h2>Edit Product Details for ID: <%= product.getId() %></h2>
        <form action="EditProductServlet" method="POST">
            <input type="hidden" name="original_id" value="<%= product.getId() %>">
            <table>
                <tr>
                    <td>Name: </td>
                    <td><input type="text" name="name" value="<%= product.getName() != null ? product.getName() : "" %>" required=""></td>
                </tr>
                <tr>
                    <td>Description: </td>
                    <td><input type="text" name="description" value="<%= product.getDescription() != null ? product.getDescription() : "" %>"></td>
                </tr>
                <tr>
                    <td>Price: </td>
                    <td><input type="text" name="price" value="<%= product.getPrice() != null ? product.getPrice() : "" %>" required=""></td>
                </tr>
                <tr>
                    <td>SKU: </td>
                    <td><input type="text" name="sku" value="<%= product.getSku() != null ? product.getSku() : "" %>" required=""></td>
                </tr>
                <tr>
                    <td>Barcode: </td>
                    <td><input type="text" name="barcode" value="<%= product.getBarcode() != null ? product.getBarcode() : "" %>"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" name="action" value="Update Product"></td>
                </tr>
            </table>
        </form>
        <%
            }
            if (errorMessage != null) {
        %>
        <p style="color: red;">Error: <%= errorMessage %></p>
        <%
            }
        %>
        <p><a href="edit_product.jsp">Back to ID Entry</a></p>
    </body>
</html>