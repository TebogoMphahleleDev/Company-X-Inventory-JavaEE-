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
    
    public Product findProduct(Long id);
    
    public void editProduct(Long id,Product updatedProducts);
    
    
    
    
    boolean deleteProduct(Long id);
    
}
