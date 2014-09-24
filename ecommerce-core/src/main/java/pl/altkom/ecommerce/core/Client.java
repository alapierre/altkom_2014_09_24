/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.altkom.ecommerce.core;

import javax.persistence.Entity;

/**
 *
 * @author Student
 */
@Entity
@SuppressWarnings("PersistenceUnitPresent")
public class Client extends BaseEntity {
    
    private String name;
    private String nip;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }
    
    
    
}
