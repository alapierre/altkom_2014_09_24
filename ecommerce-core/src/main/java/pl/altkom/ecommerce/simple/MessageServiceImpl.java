/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.altkom.ecommerce.simple;

/**
 *
 * @author Student
 */
public class MessageServiceImpl implements MessageService {
    
    private MailSender sender;
    
    @Override
    public void sendMessage(String content, String title, String mail) {
        
        MailMessage mm = new MailMessage();
        mm.setAddress(mail);
        mm.setContent(content);
        mm.setSubject(title);
        
        sender.sendMail(mm);
        
    }

    public MailSender getSender() {
        return sender;
    }

    public void setSender(MailSender sender) {
        this.sender = sender;
    }

    
    
}
