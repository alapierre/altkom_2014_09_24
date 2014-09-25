/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.altkom.ecommerce;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import pl.altkom.ecommerce.core.Invoice;
import pl.altkom.ecommerce.core.dao.InvoiceDAO;


/**
 *
 * @author Student
 */
@ContextConfiguration("/ecommerce-core.xml")
public class SpringContextTest extends AbstractTransactionalJUnit4SpringContextTests {
    
    @Autowired
    private InvoiceDAO invoiceDAO;
    
    
    @Before
    public void init() {
        System.out.println("inicjalizacja");
    }
    
    @Test
    public void testContext() {
        
        Invoice invoice = new Invoice();
        
        invoiceDAO.saveOrUpdate(invoice);
        
        System.out.println(invoice.getId());
        
        assert invoice.getId() != 0;
    }
    
    @Test
    public void ttt() {
        
        
        
        System.out.println("111");
        
    }
    
}
