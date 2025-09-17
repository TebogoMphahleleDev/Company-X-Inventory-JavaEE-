<%-- 
    Document   : delete_product
    Created on : Sep 16, 2025, 11:58:04 AM
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
        <h1>Please enter the ID of the product you want to delete:</h1>
        <form action="DeleteProductServlet" method="POST">
            <table>
                <tr>
                    <td>ID: </td>
                    <td><input type="text" name="id" required=""></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Delete Product"></td>
                </tr>
            </table>
        </form>
    </body>
</html>