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
public class SuperMailSenderImpl implements MailSender{

    @Override
    public void sendMail(MailMessage message) {
        System.out.println("super wysyłanie");
    }
    
}
