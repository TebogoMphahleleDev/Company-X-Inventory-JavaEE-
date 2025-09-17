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
public class EditProductServlet extends HttpServlet {

    @EJB ProductFacadeLocal pfl;
            
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        Long original_id=Long.parseLong(request.getParameter("original_id"));
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        Double price = Double.parseDouble(request.getParameter("price"));
        String sku = request.getParameter("sku");
        String barcode = request.getParameter("barcode");
        
        
        Product updatedPr=new Product();
        
        updatedPr.setBarcode(barcode);
        updatedPr.setDescription(description);
        updatedPr.setPrice(price);
        updatedPr.setSku(sku);
        updatedPr.setName(name);
        
        pfl.editProduct(original_id, updatedPr);
        
        
        RequestDispatcher rd=request.getRequestDispatcher("edit_product_output.jsp");
        rd.forward(request, response);
        
        
    }

    
}
