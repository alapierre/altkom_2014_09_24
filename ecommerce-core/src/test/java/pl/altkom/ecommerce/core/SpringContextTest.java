/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.altkom.ecommerce.core;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;
import pl.altkom.ecommerce.core.Invoice;
import pl.altkom.ecommerce.core.InvoiceType;
import pl.altkom.ecommerce.core.dao.springdata.InvoiceDAO;
import pl.altkom.ecommerce.core.dao.springdata.PersonDAO;


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
    private PersonDAO personDAO;
    
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
    public void testPersonFind() {
        
        personDAO.save(new Person("0", "Artur", "Test"));
        for (int i = 1; i < 1000; i++)
            personDAO.save(new Person(""+i, "Artur"+i, "Test"));
        
        
        Person p = personDAO.findByFirstName("Artur");
        
        System.out.println("Person ID: "+p.getId());
        
        //Invoice i = invoiceDAO.findByClientName("Adrian");
        
        //invoiceDAO.findByQuery(1);
        
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
        
        assert tmp.getId() == 10;
    }
    
    @Test
    public void ttt() {
        
        
        
        System.out.println("111");
        
    }
    
}
