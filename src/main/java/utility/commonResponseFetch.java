package utility;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class commonResponseFetch {
	

		
		public static JsonPath jsonPath;
		public static String geConvertedResponseKeyValue(String responseBody, String responsKey) {
			 jsonPath = new JsonPath(responseBody);
			String keyValue =  jsonPath.get(responsKey);
			return keyValue;
		}
		
		public static int getStatusCode(Response response) {
			RestFrameworkLogger.initLogger();
			int statusCode = response.getStatusCode();
			RestFrameworkLogger.info("Request Response Status Code is - " + statusCode);
			return statusCode;
		}
		
		
		public static String getStatusMessage(Response response)
		{	RestFrameworkLogger.initLogger();
			String statusMessage = response.getStatusLine();
			RestFrameworkLogger.info("Request Response Status Message is - " + statusMessage);
			return statusMessage;
		}
		
		public static String getResponseHeader(Response response, String headerKey) {
			RestFrameworkLogger.initLogger();
			String reponseHeader = response.getHeader(headerKey);
			RestFrameworkLogger.info("Request Response Header Key is - " + headerKey + "And Value is -  "+ reponseHeader);
			return reponseHeader;
		}
		
		public static String getResponseContentType(Response response, String headerKey) {
			RestFrameworkLogger.initLogger();
			String reponseContentType = response.getContentType();
			RestFrameworkLogger.info("Request Response Content Type is - " + reponseContentType);
			return reponseContentType;
		}
		
		public static int getExecutionTime(Response response) {
			RestFrameworkLogger.initLogger();
			int reponseExecutionTime = (int) response.getTime();
			RestFrameworkLogger.info("Request Response Execution time is - " + reponseExecutionTime);
			return reponseExecutionTime;
			
		}
}
