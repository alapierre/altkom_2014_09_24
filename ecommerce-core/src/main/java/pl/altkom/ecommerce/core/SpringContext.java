/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.altkom.ecommerce.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Student
 */
public class SpringContext {
    
    public static void main(String[] args) {
        
        ApplicationContext ctx = new ClassPathXmlApplicationContext("ecommerce-core.xml");
        
        
        
    }
    
}
