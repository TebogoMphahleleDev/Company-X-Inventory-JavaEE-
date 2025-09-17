package com.unventory.web;

import com.unventory.ejb.ProductFacadeLocal;
import com.unventory.entities.Product;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditProductServlet extends HttpServlet {

    @EJB
    private ProductFacadeLocal pfl;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String destination = "edit_product.jsp";
        String errorMessage = null;

        if ("Fetch Product".equals(action)) {
            
            String idParam = request.getParameter("original_id");
            Long id = null;

            try {
               
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

                
                if (errorMessage == null) {
                    try {
                        Product product = pfl.findProduct(id);
                        if (product != null) {
                            request.setAttribute("product", product);
                        } else {
                            errorMessage = "Product with ID " + id + " does not exist.";
                        }
                    } catch (Exception e) {
                        errorMessage = "Failed to fetch product due to a server error: " + e.getMessage();
                    }
                }
            } catch (Exception e) {
                errorMessage = "An unexpected error occurred while fetching product: " + e.getMessage();
            }

            
            if (errorMessage != null) {
                request.setAttribute("errorMessage", errorMessage);
            }
            RequestDispatcher rd = request.getRequestDispatcher(destination);
            rd.forward(request, response);
            return;
        }

        
        String idParam = request.getParameter("original_id");
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String priceParam = request.getParameter("price");
        String sku = request.getParameter("sku");
        String barcode = request.getParameter("barcode");
        Long id = null;
        Double price = null;

        try {
           
            if (idParam == null || idParam.trim().isEmpty()) {
                errorMessage = "Original Product ID is required.";
            } else {
                try {
                    id = Long.parseLong(idParam);
                    if (id <= 0) {
                        errorMessage = "Original Product ID must be a positive number.";
                    }
                } catch (NumberFormatException e) {
                    errorMessage = "Invalid Original Product ID format. Please enter a valid number.";
                }
            }

            if (errorMessage == null && (name == null || name.trim().isEmpty())) {
                errorMessage = "Product name is required.";
            }

            if (description != null) {
                description = description.trim();
            }

            if (errorMessage == null) {
                if (priceParam == null || priceParam.trim().isEmpty()) {
                    errorMessage = "Product price is required.";
                } else {
                    try {
                        price = Double.parseDouble(priceParam);
                        if (price <= 0) {
                            errorMessage = "Product price must be a positive number.";
                        }
                    } catch (NumberFormatException e) {
                        errorMessage = "Invalid price format. Please enter a valid number.";
                    }
                }
            }

            if (errorMessage == null && (sku == null || sku.trim().isEmpty())) {
                errorMessage = "Product SKU is required.";
            }

            if (barcode != null) {
                barcode = barcode.trim();
            }

            
            if (errorMessage == null) {
                Product updatedPr = new Product();
                updatedPr.setName(name);
                updatedPr.setDescription(description);
                updatedPr.setPrice(price);
                updatedPr.setSku(sku);
                updatedPr.setBarcode(barcode);

                try {
                    boolean updated = pfl.editProduct(id, updatedPr);
                    if (updated) {
                        request.setAttribute("id", id);
                        destination = "edit_product_output.jsp";
                    } else {
                        errorMessage = "Product with ID " + id + " does not exist.";
                    }
                } catch (Exception e) {
                    errorMessage = "Failed to update product due to a server error: " + e.getMessage();
                }
            }
        } catch (Exception e) {
            errorMessage = "An unexpected error occurred while updating product: " + e.getMessage();
        }

        
        if (errorMessage != null) {
            request.setAttribute("errorMessage", errorMessage);
            destination = "edit_product_error.jsp";
        }

        RequestDispatcher rd = request.getRequestDispatcher(destination);
        rd.forward(request, response);
    }
}