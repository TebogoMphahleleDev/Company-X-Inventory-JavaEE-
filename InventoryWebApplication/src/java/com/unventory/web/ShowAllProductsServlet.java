/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unventory.web;

import com.unventory.ejb.ProductFacadeLocal;
import com.unventory.entities.Product;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author User
 */
public class ShowAllProductsServlet extends HttpServlet {

    @EJB
    private ProductFacadeLocal pfl;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String destination = "all_products_output.jsp";
        String errorMessage = null;

        try {
            List<Product> allProducts = pfl.findAll();
            if (allProducts == null || allProducts.isEmpty()) {
                errorMessage = "No products found in the database.";
            } else {
                request.setAttribute("allProducts", allProducts);
            }
        } catch (Exception e) {
            errorMessage = "Failed to retrieve products due to a server error: " + e.getMessage();
        }

        if (errorMessage != null) {
            request.setAttribute("errorMessage", errorMessage);
            destination = "all_products_error.jsp";
        }

        RequestDispatcher rd = request.getRequestDispatcher(destination);
        rd.forward(request, response);
    }
}