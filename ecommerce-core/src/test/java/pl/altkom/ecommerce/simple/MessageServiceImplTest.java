/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.altkom.ecommerce.simple;

import org.junit.Test;
import static org.junit.Assert.*;

import static org.mockito.Mockito.*;

/**
 *
 * @author Student
 */
public class MessageServiceImplTest {
    
   

    /**
     * Test of sendMessage method, of class MessageServiceImpl.
     */
    @Test
    public void testSendMessage() {
    
        MailSender sender = mock(MailSender.class);
    
        MessageServiceImpl instance = new MessageServiceImpl();
        
        instance.setSender(sender);
        
        instance.sendMessage("content", "title", "mail");
        
        MailMessage mm = new MailMessage();
        mm.setAddress("mail");
        mm.setContent("content");
        mm.setSubject("title1");
        
        verify(sender).sendMail(mm);
        
        
    }

    
    
}
