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
import pl.altkom.ecommerce.core.Product;

/**
 *
 * @author Student
 */
public interface ProductDAO extends CrudRepository<Product, Integer>{
    
    public Product findByNameAndBarcode(String name, String barcode);
    
  //  public Product findByClientName(String name);
    
    
    @Query("select i from Product i where name=:name")
    public List<Product> findByQuery(@Param("name")String netto);
    
    
}
