import helper.ApplicationLogger;

import org.slf4j.Logger;

import play.Application;
import play.GlobalSettings;
 
public class Global extends GlobalSettings {
	private Logger logger = ApplicationLogger.getLogger(Global.class);
	
    public void onStart(Application app){
        logger.info("Application started");
    }
 
    public void  onStop(Application app) {
        logger.info("Application stopped");
    }
}
