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
    
    public void editProduct(Long id,Product updatedProducts)
    {
        Product existingProducts= findProduct(id);
        
        existingProducts.setName(updatedProducts.getName());
        existingProducts.setDescription(updatedProducts.getDescription());
        existingProducts.setBarcode(updatedProducts.getBarcode());
        existingProducts.setPrice(updatedProducts.getPrice());
        existingProducts.setSku(updatedProducts.getSku());
        
        
        em.merge(existingProducts);
    }
    
    
    public Product findProduct(Long id)
    {
        Query query=em.createQuery("SELECT p From Product p where p.id =:id");
        query.setParameter("id", id);
        List<Product> products = query.getResultList();
    
        if (products.isEmpty()) 
        {
            return null; 
        }
        return products.get(0);
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

