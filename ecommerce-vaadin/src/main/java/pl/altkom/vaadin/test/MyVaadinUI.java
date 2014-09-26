package pl.altkom.vaadin.test;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Select;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;
import pl.altkom.ecommerce.vaadin.view.AddProductView;
import pl.altkom.ecommerce.vaadin.view.ProductListView;

@Theme("mytheme")
@SuppressWarnings("serial")
public class MyVaadinUI extends UI
{
    
    private Navigator.ComponentContainerViewDisplay viewDisplay;
    private Navigator navigator;

    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = MyVaadinUI.class, widgetset = "pl.altkom.vaadin.test.AppWidgetSet")
    public static class Servlet extends VaadinServlet {
    }

    @Override
    protected void init(VaadinRequest request) {
        final VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true);
        setContent(layout);
        
        
        
        viewDisplay = new Navigator.ComponentContainerViewDisplay(layout);
        initNavigator();
        
    }

    private void initNavigator() {
        // Create a navigator to control the page
        
        navigator = new Navigator(UI.getCurrent(),viewDisplay);
        
        navigator.addView("", new AddProductView(navigator));
        navigator.addView("productList", new ProductListView());
        
        
        
    }
    
}
