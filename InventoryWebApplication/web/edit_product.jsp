<%-- 
    Document   : edit_product
    Created on : Sep 15, 2025, 3:45:18 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Product Page</title>
    </head>
    <body>
        <h1>Edit Product details</h1>
        
        <form action="EditProductServlet" method="POST">
            <table>
                <tr>
                    <td>Enter Original ID: </td>
                    <td><input type="text" name="original_id" ></td>
                </tr>
                <tr>
                    <td>Name: </td>
                    <td><input type="text" name="name" ></td>
                </tr>
                <tr>
                    <td>Description: </td>
                    <td><input type="text" name="description" ></td>
                </tr>
                <tr>
                    <td>Price: </td>
                    <td><input type="text" name="price" ></td>
                </tr>
                <tr>
                    <td>SKU: </td>
                    <td><input type="text" name="sku" ></td>
                </tr>
                <tr>
                    <td>Barcode: </td>
                    <td><input type="text" name="barcode" ></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Edit Product"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
