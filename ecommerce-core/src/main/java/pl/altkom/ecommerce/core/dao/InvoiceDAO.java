/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.altkom.ecommerce.core.dao;

import pl.altkom.ecommerce.core.Invoice;

/**
 *
 * @author Student
 */
public interface InvoiceDAO {

    void delete(Invoice invoice);

    Invoice load(int id);

    void saveOrUpdate(Invoice invoice);
    
}
