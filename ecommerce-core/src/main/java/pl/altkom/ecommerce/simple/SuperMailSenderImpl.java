/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.altkom.ecommerce.simple;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Student
 */
@Component
public class SuperMailSenderImpl implements MailSender{

    @Autowired
    private CacheService cacheService;
    
    @Override
    public void sendMail(MailMessage message) {
        System.out.println("super wysyłanie");
        
        System.out.println("cache " + cacheService);
        
    }
    
    @PostConstruct
    public void init() {
        System.out.println("inicjalizacja");
    }

    public CacheService getCacheService() {
        return cacheService;
    }

    public void setCacheService(CacheService cacheService) {
        this.cacheService = cacheService;
    }
    
}
