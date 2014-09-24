/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.altkom.ecommerce.core;

/**
 *
 * @author Student
 */
public class InvoiceItem {
    
    private String name;
    private Product product;
    private int volumne;
    private double price;
    private double totalPrice;
    private int lp;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getVolumne() {
        return volumne;
    }

    public void setVolumne(int volumne) {
        this.volumne = volumne;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getLp() {
        return lp;
    }

    public void setLp(int lp) {
        this.lp = lp;
    }

    @Override
    public String toString() {
        return "InvoiceItem{" + "name=" + name + ", product=" + product + ", volumne=" + volumne + ", price=" + price + ", totalPrice=" + totalPrice + ", lp=" + lp + '}';
    }
    
}
