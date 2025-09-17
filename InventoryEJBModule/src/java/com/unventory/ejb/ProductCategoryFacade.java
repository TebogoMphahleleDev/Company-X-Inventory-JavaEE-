/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unventory.ejb;

import com.unventory.entities.ProductCategory;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author User
 */
@Stateless
public class ProductCategoryFacade extends AbstractFacade<ProductCategory> implements ProductCategoryFacadeLocal {
    @PersistenceContext(unitName = "InventoryEJBModulePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductCategoryFacade() {
        super(ProductCategory.class);
    }
    
}
