/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.altkom.ecommerce.core.dao;

import pl.altkom.ecommerce.core.Product;

/**
 *
 * @author Student
 */
public interface ProductDAO {
     
    
    void delete(Product product);

    Product load(int id);

    void saveOrUpdate(Product product);
}
