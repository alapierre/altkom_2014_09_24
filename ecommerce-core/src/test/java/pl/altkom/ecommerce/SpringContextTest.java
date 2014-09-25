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
import org.springframework.test.context.transaction.TransactionConfiguration;
import pl.altkom.ecommerce.core.Invoice;
import pl.altkom.ecommerce.core.InvoiceType;
import pl.altkom.ecommerce.core.Product;
import pl.altkom.ecommerce.core.dao.springdata.InvoiceDAO;
import pl.altkom.ecommerce.core.dao.springdata.ProductDAO;


/**
 *
 * @author Student
 */
@ContextConfiguration("/ecommerce-core.xml")
@TransactionConfiguration(defaultRollback = false)
public class SpringContextTest extends AbstractTransactionalJUnit4SpringContextTests {
    
    @Autowired
    private InvoiceDAO invoiceDAO;
    
    @Autowired
    private ProductDAO productDAO;
    
    
    
    @Before
    public void init() {
        System.out.println("inicjalizacja");
    }
    
    @Test
    public void testFind() {
        
        //Invoice i = invoiceDAO.findByNumberAndInvoiceType("1234", InvoiceType.FK);
        
        //Invoice i = invoiceDAO.findByClientName("Adrian");
        
        invoiceDAO.findByQuery(1);
        
        //System.out.println(i);
    }
    
    @Test
    public void testContext() {
        
        Invoice invoice = new Invoice();
        
        invoiceDAO.save(invoice);
        
        System.out.println(invoice.getId());
        
        assert invoice.getId() != 0;
        
        Invoice tmp  = invoiceDAO.findOne(10);
        
        System.out.println(tmp);
        
//        assert tmp.getId() == 10;
    }
    
    
        @Test
    public void testContext2() {
        
        Product product = new Product();
        
        productDAO.save(product);
        
        System.out.println(product.getId());
        
        assert product.getId() != 0;
        
        Product tmp  = productDAO.findByNameAndBarcode("Piwo", "2345678901234");
        
        System.out.println(tmp);
        
       // assert tmp.getId() == 10;
    }
    
    
    
    
    
    
    @Test
    public void ttt() {
        
        
        
        System.out.println("111");
        
    }
    
}
