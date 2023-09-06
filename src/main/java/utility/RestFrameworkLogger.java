package utility;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class RestFrameworkLogger {
private static Logger log = Logger.getLogger(RestFrameworkLogger.class.getName());


public static void initLogger()
{
	PropertyConfigurator.configure("log4j.properties");
}
	
	public static void startTestCase (String testCaseName) {
		
		
		log.info("*****************************************************");
		log.info("*************** "+testCaseName+ " *******************");
		log.info("*****************************************************");
		
	}
	
	
	
public static void endestCase (String testCaseName) {
		

		log.info(" XXXXXXXXXX "+" END " + testCaseName + " XXXXXXXXXX");
		log.info("------------------------X--------------------------");
		
	}


public static void info(String message) {
	log.info(message);
}



public static void warn(String message) {
	log.warn(message);
}


public static void error(String message) {
	log.error(message);
}


public static void fatal(String message) {
	log.fatal(message);
}


public static void debug(String message) {
	log.debug(message);
}




}
