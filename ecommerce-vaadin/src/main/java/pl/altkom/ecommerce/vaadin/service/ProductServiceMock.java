/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.altkom.ecommerce.vaadin.service;

import java.util.ArrayList;
import java.util.List;
import pl.altkom.ecommerce.core.Product;

/**
 *
 * @author Student
 */
public class ProductServiceMock {

    static final private ProductServiceMock instance = new ProductServiceMock();
    
    private List<Product> list = new ArrayList<Product>();
    
    private ProductServiceMock() {
    }
    
    public static ProductServiceMock getInstance() {
        return instance;
    }
    
    public void addProduct(Product product) {
        list.add(product);
    }
    
    public List<Product> findAll() {
        return list;
    }
    
}
