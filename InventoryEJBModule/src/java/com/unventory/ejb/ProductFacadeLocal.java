/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unventory.ejb;

import com.unventory.entities.Product;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author User
 */
@Local
public interface ProductFacadeLocal {

    void create(Product product);

    void edit(Product product);

    void remove(Product product);

    Product find(Object id);

    List<Product> findAll();

    List<Product> findRange(int[] range);

    int count();
    
    boolean editProduct(Long id, Product updatedProduct);
    
    Product findProduct(Long id);
    
    boolean deleteProduct(Long id);
    
    
}
