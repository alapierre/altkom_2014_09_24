/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.altkom.ecommerce.vaadin.view;

import com.vaadin.data.Validator;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.Form;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import pl.altkom.ecommerce.core.Product;
import pl.altkom.ecommerce.vaadin.service.ProductServiceMock;

/**
 *
 * @author Student
 */
public class AddProductView extends VerticalLayout implements View {

    Navigator navigator;
    
    public AddProductView(Navigator navigator) {
        this.navigator = navigator;
    }
    
    private final Form form = new Form(new VerticalLayout());

    final BeanFieldGroup<Product> binder = new BeanFieldGroup<Product>(Product.class);

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

        final Product product = new Product();
        
        binder.setItemDataSource(product);
        binder.setBuffered(true);
        
        System.out.println("enter");

        form.setCaption("Dodawanie produktu");
        form.addStyleName("bordered");
        form.setBuffered(true);

        TextField nameField = binder.buildAndBind("Nazwa produktu", "name", TextField.class);
        nameField.setRequired(true);
        nameField.setNullRepresentation("");
        form.addField("name", nameField);

        TextField codeField = binder.buildAndBind("Barkod", "barcode", TextField.class);
        codeField.setRequired(true);
        form.addField("barcode", codeField);
        codeField.setNullRepresentation("");

        TextField priceField = binder.buildAndBind("Cena", "price", TextField.class);
        form.addField("price", priceField);
        priceField.setNullRepresentation("");
        
        Button subbmit = new Button("Zapisz", new Button.ClickListener() {

            @Override
            public void buttonClick(Button.ClickEvent event) {

                try {
                    form.commit();
                    boolean formValid = form.isValid();
                    System.out.println("formularz is valid " + formValid);

                    if (!formValid) {
                        
                        System.out.println(formValid);
                        
                        Notification.show("Dane nieprawidłowe", Notification.Type.WARNING_MESSAGE);
                        
                    } else {
                        Notification.show("Dane OK", Notification.Type.HUMANIZED_MESSAGE);
                        
                        System.out.println("produkt " + product);
                        
                        System.out.println("produkt " + product.getPrice());
                        
                        ProductServiceMock.getInstance().addProduct(product);
                    }
                } catch (Validator.InvalidValueException ex) {
                    Notification.show("Dane nieprawidłowe", Notification.Type.ERROR_MESSAGE);
                }

            }
        });
        
        Button listButton = new Button("Lista", new Button.ClickListener() {

            @Override
            public void buttonClick(Button.ClickEvent event) {
                navigator.navigateTo("productList");
            }
        });
        
        addComponent(form);
        addComponent(subbmit);
        addComponent(listButton);
    }

}
