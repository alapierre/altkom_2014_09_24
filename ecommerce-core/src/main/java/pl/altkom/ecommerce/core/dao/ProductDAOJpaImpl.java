/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.altkom.ecommerce.core.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pl.altkom.ecommerce.core.Invoice;
import pl.altkom.ecommerce.core.Product;

/**
 *
 * @author Student
 */
public class ProductDAOJpaImpl implements ProductDAO{
       @PersistenceContext
    private EntityManager em;
    
    @Override
    public Product load(int id) {
       return  em.find(Product.class, id);
    }
    
    @Override
    public void saveOrUpdate(Product product) {
        em.persist(product);
    }
    
    @Override
    public void delete(Product product) {
        em.remove(product);
    }
}
