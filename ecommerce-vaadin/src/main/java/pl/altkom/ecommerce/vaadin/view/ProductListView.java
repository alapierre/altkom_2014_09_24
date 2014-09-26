/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.altkom.ecommerce.vaadin.view;

import com.vaadin.data.Container.Filter;
import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.event.FieldEvents.TextChangeEvent;
import com.vaadin.event.FieldEvents.TextChangeListener;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.AbstractTextField.TextChangeEventMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Field.ValueChangeEvent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import java.math.BigDecimal;
import java.util.List;
import pl.altkom.ecommerce.core.Product;
import pl.altkom.ecommerce.vaadin.service.ProductServiceMock;

/**
 *
 * @author Student
 */
public class ProductListView extends VerticalLayout implements View {

    private Table contactList = new Table();
    private TextField searchField = new TextField();
    private Button addNewContactButton = new Button("New");
    private Button removeContactButton = new Button("Remove this contact");
    private FormLayout editorLayout = new FormLayout();
    private FieldGroup editorFields = new FieldGroup();

    IndexedContainer contactContainer = new IndexedContainer();

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        loadData(contactContainer);
        initLayout();
        initContactList();
        initEditor();
        initSearch();
        initAddRemoveButtons();
    }


    private void initLayout() {
        HorizontalSplitPanel splitPanel = new HorizontalSplitPanel();
        addComponent(splitPanel);

        VerticalLayout leftLayout = new VerticalLayout();
        splitPanel.addComponent(leftLayout);
        splitPanel.addComponent(editorLayout);
        leftLayout.addComponent(contactList);
        HorizontalLayout bottomLeftLayout = new HorizontalLayout();
        leftLayout.addComponent(bottomLeftLayout);
        bottomLeftLayout.addComponent(searchField);
        bottomLeftLayout.addComponent(addNewContactButton);
        leftLayout.setSizeFull();
        leftLayout.setExpandRatio(contactList, 1);
        contactList.setSizeFull();
        bottomLeftLayout.setWidth("100%");
        searchField.setWidth("100%");
        bottomLeftLayout.setExpandRatio(searchField, 1);
        editorLayout.setMargin(true);
        editorLayout.setVisible(false);

    }

    private void initEditor() {

        TextField field = new TextField("Nazwa");
        editorLayout.addComponent(field);
        field.setWidth("100%");
        editorFields.bind(field, "name");

        editorLayout.addComponent(removeContactButton);

        editorFields.setBuffered(false);
    }

    private void initSearch() {
        searchField.setInputPrompt("Search contacts");

        searchField.setTextChangeEventMode(TextChangeEventMode.LAZY);

        searchField.addTextChangeListener(new TextChangeListener() {
            public void textChange(final TextChangeEvent event) {

                contactContainer.removeAllContainerFilters();
                contactContainer.addContainerFilter(new ContactFilter(event
                        .getText()));
            }
        });
    }
    
    private IndexedContainer initDatasource() {
        IndexedContainer ic = new IndexedContainer();
        return ic;
    }

    private void loadData(IndexedContainer ic) {

        System.out.println("createDatasource");
        
        ic.addContainerProperty("name", String.class, "");
        ic.addContainerProperty("barcode", String.class, "");
        ic.addContainerProperty("price", BigDecimal.class, new BigDecimal(0));

        List<Product> list = ProductServiceMock.getInstance().findAll();

        System.out.println("list = " + list);
        
        for (Product product : list) {
            Object item = ic.addItem();
            ic.getContainerProperty(item, "name").setValue(product.getName());
            ic.getContainerProperty(item, "barcode").setValue(product.getBarcode());
            ic.getContainerProperty(item, "price").setValue(product.getPrice());
        }

    }

    private class ContactFilter implements Filter {

        private String needle;

        public ContactFilter(String needle) {
            this.needle = needle.toLowerCase();
        }

        public boolean passesFilter(Object itemId, Item item) {
            return true;
        }

        public boolean appliesToProperty(Object id) {
            return true;
        }

    }

    private void initAddRemoveButtons() {
        addNewContactButton.addClickListener(new ClickListener() {
            public void buttonClick(ClickEvent event) {

                contactContainer.removeAllContainerFilters();
                Object contactId = contactContainer.addItemAt(0);

                contactList.getContainerProperty(contactId, "name").setValue(
                        "");
                contactList.getContainerProperty(contactId, "barcode").setValue(
                        "");
                contactList.getContainerProperty(contactId, "price").setValue(
                        new BigDecimal(0));

                contactList.select(contactId);
            }
        });

        removeContactButton.addClickListener(new ClickListener() {
            public void buttonClick(ClickEvent event) {
                Object contactId = contactList.getValue();
                contactList.removeItem(contactId);
            }
        });
    }

    private void initContactList() {
        contactList.setContainerDataSource(contactContainer);
        contactList.setVisibleColumns(new String[]{"name", "barcode", "price"});
        contactList.setSelectable(true);
        contactList.setImmediate(true);

        contactList.addValueChangeListener(new Property.ValueChangeListener() {
            public void valueChange(Property.ValueChangeEvent event) {
                Object contactId = contactList.getValue();
                if (contactId != null) {
                    editorFields.setItemDataSource(contactList
                            .getItem(contactId));
                }

                editorLayout.setVisible(contactId != null);
            }
        });
    }
}
