package pl.com.softproject;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;


/**
 * Application object for your web application. If you want to run this application without deploying, run the Start
 * class.
 *
 * @see pl.com.softproject.Start#main(String[])
 */
public class WicketApplication extends WebApplication {

    /**
     * @return @see org.apache.wicket.Application#getHomePage()
     */
    @Override
    public Class<? extends WebPage> getHomePage() {
        return HomePage.class;
    }

    /**
     * @see org.apache.wicket.Application#init()
     */
    @Override
    public void init() {
        super.init();

        getRequestCycleSettings().setResponseRequestEncoding("UTF-8"); 
        getMarkupSettings().setDefaultMarkupEncoding("UTF-8"); 
        
        getComponentInstantiationListeners().add(new SpringComponentInjector(this));
        
        //mountPage("/taskAdded", TaskAdded.class);
    }
}
