/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.altkom.ecommerce;

import java.util.function.Consumer;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;
import pl.altkom.ecommerce.core.Invoice;
import pl.altkom.ecommerce.core.InvoiceType;
import pl.altkom.ecommerce.core.dao.springdata.InvoiceDAO;


/**
 *
 * @author Student
 */
@ContextConfiguration("/ecommerce-core.xml")
@TransactionConfiguration(defaultRollback = false)
public class SpringContextTest extends AbstractTransactionalJUnit4SpringContextTests {
    
    @Autowired
    private InvoiceDAO invoiceDAO;
    
    
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
    public void testInsertSomeData() {
        
        for(int i = 0 ; i<100; i++) {
            Invoice invoice = new Invoice();
            invoice.setNettoValue(100);
        
            invoiceDAO.save(invoice);
        }
        
        
        
    }
    
    @Test
    public void pageTest() {
        
        Page<Invoice> res = invoiceDAO.findByAmount(0, new PageRequest(0, 10, Sort.Direction.ASC, "id"));
       
        System.out.println("pages " + res.getTotalPages());
        
        
        res.forEach(new Consumer<Invoice>() {
            @Override
            public void accept(Invoice t) {
                System.out.println(t);
            }
        });
        
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
