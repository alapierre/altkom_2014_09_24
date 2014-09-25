/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.altkom.ecommerce.core.dao.springdata;

import org.springframework.data.repository.CrudRepository;
import pl.altkom.ecommerce.core.Person;

/**
 *
 * @author Student
 */
public interface PersonDAO extends CrudRepository<Person, Integer>{
    
    public Person findByFirstName(String firstName);
    public Person findByLastName(String lastName);
    public Person findByPesel(String Pesel);
}
