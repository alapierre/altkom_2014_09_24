/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.altkom.ecommerce.core;

import java.util.LinkedHashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Student
 */
@Entity
@SuppressWarnings("PersistenceUnitPresent")
public class Invoice extends BaseEntity {
    
    @Enumerated(EnumType.STRING)
    private InvoiceType invoiceType;
    
    private String number;
    
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    
    @OneToMany
    @JoinColumn(name = "invoice_id")
    private Set<InvoiceItem> items = new LinkedHashSet<>();

    private double nettoValue;
    private double grosValue;

    public InvoiceType getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(InvoiceType invoiceType) {
        this.invoiceType = invoiceType;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Set<InvoiceItem> getItems() {
        return items;
    }

    public void setItems(Set<InvoiceItem> items) {
        this.items = items;
    }

    public double getNettoValue() {
        return nettoValue;
    }

    public void setNettoValue(double nettoValue) {
        this.nettoValue = nettoValue;
    }

    public double getGrosValue() {
        return grosValue;
    }

    public void setGrosValue(double grosValue) {
        this.grosValue = grosValue;
    }

    @Override
    public String toString() {
        return "Invoice{" + "invoiceType=" + invoiceType + ", number=" + number + ", client=" + client + ", nettoValue=" + nettoValue + ", grosValue=" + grosValue + '}';
    }

    
    
}
