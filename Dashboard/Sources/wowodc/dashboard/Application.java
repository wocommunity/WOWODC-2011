// Generated by the WOLips Template engine Plug-in at Jan 10, 2010 12:00:00 PM
package wowodc.dashboard;

import java.util.TimeZone;

import org.apache.log4j.Logger;

import com.webobjects.appserver.WORequestHandler;
import com.webobjects.foundation.NSTimeZone;

import er.extensions.appserver.ERXApplication;
import er.extensions.appserver.navigation.ERXNavigationManager;

public class Application extends ERXApplication {
	private static Logger log = Logger.getLogger(Application.class);
	
    public static void main(String argv[]) {
        ERXApplication.main(argv, Application.class);
    }

	public void finishInitialization() {
		//Set default time zones
        TimeZone.setDefault(TimeZone.getTimeZone("GMT"));
        NSTimeZone.setDefaultTimeZone(NSTimeZone.getGMT());

        //Initialize the navigation manager
        ERXNavigationManager.manager().configureNavigation();
        
        //Set the default request handler to the direct action request handler
        String key = directActionRequestHandlerKey();
        WORequestHandler handler = requestHandlerForKey(key);
        setDefaultRequestHandler(handler);
	}

    public void didFinishLaunching() {
    	/* ** put your post initialization code in here ** */
    	
    	//FIXME Add the preference relationship to the actor entity
    	//ERCoreBusinessLogic.sharedInstance().addPreferenceRelationshipToActorEntity(Person.ENTITY_NAME);
    }

}