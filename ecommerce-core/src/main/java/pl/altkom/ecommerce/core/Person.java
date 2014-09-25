/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.altkom.ecommerce.core;

import java.util.Objects;
import javax.persistence.Entity;

/**
 *
 * @author Student
 */
@Entity
@SuppressWarnings("PersistenceUnitPresent")
public class Person extends BaseEntity{
 
    private String pesel;   
    private String firstName;
    private String lastName;

    
    public Person(){};
    
    public Person(String pesel, String firstName, String lastName) {
        this.pesel = pesel;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.pesel);
        hash = 59 * hash + Objects.hashCode(this.lastName);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Person other = (Person) obj;
        if (!Objects.equals(this.pesel, other.pesel)) {
            return false;
        }
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        return true;
    }

    
    
}
