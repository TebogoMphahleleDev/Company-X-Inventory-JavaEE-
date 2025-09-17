/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unventory.ejb;

import com.unventory.entities.ProductCategory;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author User
 */
@Local
public interface ProductCategoryFacadeLocal {

    void create(ProductCategory productCategory);

    void edit(ProductCategory productCategory);

    void remove(ProductCategory productCategory);

    ProductCategory find(Object id);

    List<ProductCategory> findAll();

    List<ProductCategory> findRange(int[] range);

    int count();
    
}
