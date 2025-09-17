/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unventory.ejb;

import com.unventory.entities.Product;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author User
 */
@Stateless
public class ProductFacade extends AbstractFacade<Product> implements ProductFacadeLocal {
    @PersistenceContext(unitName = "InventoryEJBModulePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductFacade() {
        super(Product.class);
    }
    
    public List<Product> findAll() {
        try {
            Query query = em.createQuery("SELECT p FROM Product p");
            return query.getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Database error while retrieving all products: " + e.getMessage());
        }
    }
    
    public boolean editProduct(Long id, Product updatedProduct) {
        if (id == null || updatedProduct == null) {
            return false;
        }

        try {
            Product existingProduct = findProduct(id);
            if (existingProduct == null) {
                return false; 
            }

            
            if (updatedProduct.getName() != null && !updatedProduct.getName().trim().isEmpty()) {
                existingProduct.setName(updatedProduct.getName());
            }
            if (updatedProduct.getDescription() != null) {
                existingProduct.setDescription(updatedProduct.getDescription());
            }
            if (updatedProduct.getPrice() != null) {
                existingProduct.setPrice(updatedProduct.getPrice());
            }
            if (updatedProduct.getSku() != null && !updatedProduct.getSku().trim().isEmpty()) {
                existingProduct.setSku(updatedProduct.getSku());
            }
            if (updatedProduct.getBarcode() != null) {
                existingProduct.setBarcode(updatedProduct.getBarcode());
            }

            em.merge(existingProduct);
            return true;
        } catch (Exception e) {
            throw new RuntimeException("Database error while updating product with ID " + id + ": " + e.getMessage());
        }
    }

    @Override
    public Product findProduct(Long id) {
        if (id == null) {
            return null;
        }

        try {
            Query query = em.createQuery("SELECT p FROM Product p WHERE p.id = :id");
            query.setParameter("id", id);
            List<Product> products = query.getResultList();
            if (products.isEmpty()) {
                return null;
            }
            return products.get(0);
        } catch (Exception e) {
            throw new RuntimeException("Database error while finding product with ID " + id + ": " + e.getMessage());
        }
    }
    
    @Override
    public boolean deleteProduct(Long id) {
        if (id == null) {
            return false;
        }

        try {
            
            Query checkQuery = em.createQuery("SELECT p FROM Product p WHERE p.id = :id");
            checkQuery.setParameter("id", id);
            try {
                checkQuery.getSingleResult();
            } catch (NoResultException e) {
                return false; 
            }

            Query deleteQuery = em.createQuery("DELETE FROM Product p WHERE p.id = :id");
            deleteQuery.setParameter("id", id);
            int rowsAffected = deleteQuery.executeUpdate();
            return rowsAffected > 0; 
        } catch (Exception e) {
            throw new RuntimeException("Database error while deleting product with ID " + id + ": " + e.getMessage());
        }
    }
}

