package com.unventory.web;

import com.unventory.ejb.ProductFacadeLocal;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteProductServlet extends HttpServlet {

    @EJB
    private ProductFacadeLocal pf1;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idParam = request.getParameter("id");
        String destination = "delete_product_output.jsp";
        String errorMessage = null;
        Long id = null;

        try {
            // Validate input
            if (idParam == null || idParam.trim().isEmpty()) {
                errorMessage = "Product ID is required.";
            } else {
                try {
                    id = Long.parseLong(idParam);
                    if (id <= 0) {
                        errorMessage = "Product ID must be a positive number.";
                    }
                } catch (NumberFormatException e) {
                    errorMessage = "Invalid Product ID format. Please enter a valid number.";
                }
            }

            // Proceed with deletion if no input errors
            if (errorMessage == null) {
                try {
                    boolean deleted = pf1.deleteProduct(id);
                    if (deleted) {
                        request.setAttribute("id", id);
                    } else {
                        errorMessage = "Product with ID " + id + " does not exist.";
                    }
                } catch (Exception e) {
                    errorMessage = "Failed to delete product due to a server error: " + e.getMessage();
                }
            }
        } catch (Exception e) {
            errorMessage = "An unexpected error occurred: " + e.getMessage();
        }

        // Set attributes and forward to JSP
        if (errorMessage != null) {
            request.setAttribute("errorMessage", errorMessage);
            destination = "delete_product_error.jsp"; // Forward to error page
        }

        RequestDispatcher rd = request.getRequestDispatcher(destination);
        rd.forward(request, response);
    }
}