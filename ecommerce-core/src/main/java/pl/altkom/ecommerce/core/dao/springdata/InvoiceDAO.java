/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.altkom.ecommerce.core.dao.springdata;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import pl.altkom.ecommerce.core.Invoice;
import pl.altkom.ecommerce.core.InvoiceType;

/**
 *
 * @author Student
 */
public interface InvoiceDAO extends CrudRepository<Invoice, Integer>{
    
    public Invoice findByNumberAndInvoiceType(String number, InvoiceType type);
    
    public Invoice findByClientName(String name);
    
    
    @Query("select i from Invoice i where nettoValue=:netto")
    public List<Invoice> findByQuery(@Param("netto")double netto);
    
}
