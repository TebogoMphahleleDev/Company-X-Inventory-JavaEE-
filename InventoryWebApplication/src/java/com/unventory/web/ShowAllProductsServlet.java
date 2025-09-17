/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unventory.web;

import com.unventory.ejb.ProductFacadeLocal;
import com.unventory.entities.Product;
import java.io.IOException;
import java.io.PrintWriter;
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

    @EJB ProductFacadeLocal pfl;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        List<Product> allProducts=pfl.findAll();
        
        
        request.setAttribute("allProducts", allProducts);
        
        RequestDispatcher rd=request.getRequestDispatcher("all_products_output.jsp");
        rd.forward(request, response);
    }

    

}
