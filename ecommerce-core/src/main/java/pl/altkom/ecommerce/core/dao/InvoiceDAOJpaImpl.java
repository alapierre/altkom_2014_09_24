/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.altkom.ecommerce.core.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import pl.altkom.ecommerce.core.Invoice;

/**
 *
 * @author Student
 */
@Repository
public class InvoiceDAOJpaImpl implements InvoiceDAO {
    
    @PersistenceContext
    private EntityManager em;
    
    @Override
    public Invoice load(int id) {
       return  em.find(Invoice.class, id);
    }
    
    @Override
    public void saveOrUpdate(Invoice invoice) {
        em.persist(invoice);
    }
    
    @Override
    public void delete(Invoice invoice) {
        em.remove(invoice);
    }
    
}
