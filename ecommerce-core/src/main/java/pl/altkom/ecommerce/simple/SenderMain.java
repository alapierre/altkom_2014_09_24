/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.altkom.ecommerce.simple;

import java.util.Arrays;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Student
 */
public class SenderMain {
    
    private static ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("simple.xml");
    
    public static void main(String[] args) {
        
        MessageService mailSender =  ctx.getBean(MessageService.class);
        mailSender.sendMessage("treść", "temat", "adrian@soft-project.pl");
        
        for(String tmp : ctx.getBeanDefinitionNames()) {
            System.out.println(tmp);
        }
        
        
        
//        SuperMailSenderImpl bean = new SuperMailSenderImpl();
//        
//        //ctx.getBeanFactory().initializeBean(bean, "sender-new");
//        
//        ctx.getBeanFactory().registerSingleton("sender-new", bean);
//        ctx.getBeanFactory().autowireBean(bean);
//        
//        MailSender tmp = ctx.getBean("sender-new", MailSender.class);
//        
//        tmp.sendMail(null);
        
        
    }
    
    public static ApplicationContext getSpringContext() {
        return ctx;
    }
    
}
