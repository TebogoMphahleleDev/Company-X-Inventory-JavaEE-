<%-- 
    Document   : add_product
    Created on : Sep 15, 2025, 1:36:38 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Adding Page</title>
    </head>
    <body>
        <h1>Add a Product below</h1>
        
        <form action="addProductServlet" method="POST">
            <table>
                <tr>
                    <td>Name: </td>
                    <td><input type="text" name="name" required=""></td>
                </tr>
                <tr>
                    <td>Description: </td>
                    <td><input type="text" name="description" required=""></td>
                </tr>
                <tr>
                    <td>Price: </td>
                    <td><input type="text" name="price" required=""></td>
                </tr>
                <tr>
                    <td>SKU: </td>
                    <td><input type="text" name="sku" required=""></td>
                </tr>
                <tr>
                    <td>Barcode: </td>
                    <td><input type="text" name="barcode" required=""></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Add Product"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
