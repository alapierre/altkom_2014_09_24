/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.altkom.ecommerce.simple;

import java.util.Arrays;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Student
 */
public class SenderMain {
    
    private static ApplicationContext ctx = new ClassPathXmlApplicationContext("simple.xml");
    
    public static void main(String[] args) {
        
        MessageService mailSender =  (MessageService) ctx.getBean("messageService");
        mailSender.sendMessage("treść", "temat", "adrian@soft-project.pl");
        
        AutowireCapableBeanFactory bf = ctx.getAutowireCapableBeanFactory();
        
        //SuperMailSenderImpl bean = new SuperMailSenderImpl();
        SuperMailSenderImpl bean = bf.createBean(SuperMailSenderImpl.class);
        bf.initializeBean(bean, "sender-new");
        
        System.out.println(Arrays.asList(ctx.getBeanDefinitionNames()));
        
        
        
        //System.out.println(ctx.getBean("sender-new"));
        
        
    }
    
    public static ApplicationContext getSpringContext() {
        return ctx;
    }
    
}
