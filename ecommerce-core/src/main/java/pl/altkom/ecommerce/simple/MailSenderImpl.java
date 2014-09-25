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
public class MailSenderImpl implements MailSender {
    
    private String smtpHost;
    private String smtpUser;
    private String smtpPass;
    
    @Override
    public void sendMail(MailMessage message) {
        
        System.out.println("sysyłąm wiadomość " + message);
    } 

    public String getSmtpHost() {
        return smtpHost;
    }

    public void setSmtpHost(String smtpHost) {
        this.smtpHost = smtpHost;
    }

    public String getSmtpUser() {
        return smtpUser;
    }

    public void setSmtpUser(String smtpUser) {
        this.smtpUser = smtpUser;
    }

    public String getSmtpPass() {
        return smtpPass;
    }

    public void setSmtpPass(String smtpPass) {
        this.smtpPass = smtpPass;
    }
    
    
    
}
