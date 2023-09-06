package putMethodCall;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.requestresponse.method.requestMethodBaseClass;
import io.restassured.response.Response;
import utility.RestFrameworkLogger;
import utility.authenticationToken;
import utility.commonUtillFunctions;
import utility.createBaseURL;
import utility.loginB2BUser;
import utility.payLoadGenerator;

public class createOpportunity {
	
	
	Response response;
	String endPointURL = createBaseURL.getBaseURI("/salesforce/opportunity/create");
	String bearerToken = authenticationToken.getOAuth2AccessToken();
	String userName="/test@cegb.co.jp";

	public String cartNo1;

	
	  public void createOpportunity() throws IOException {
	  RestFrameworkLogger.initLogger();
	  
	  RestFrameworkLogger.startTestCase("createOpportunity");
	  RestFrameworkLogger.info("Step 1 : Generating Payload String"); String
	  request_Payload = payLoadGenerator.generatePayload("createOpportunity.json");
	  RestFrameworkLogger.info("Step 2 : Executing Create Opportunity Call");
	  response = requestMethodBaseClass.postRequest(endPointURL, request_Payload,
	  bearerToken); String responseString = response.getBody().asString();
	  RestFrameworkLogger.info("Step 3 : Validating Response Status code");
	  Assert.assertEquals(commonUtillFunctions.getStatusCode(response), 201);
	  RestFrameworkLogger.info(commonUtillFunctions.getStatusMessage(response));
	  RestFrameworkLogger.endestCase("createOpportunity");
	  
	  }
	 

	@Test
	public void configuratorcreateCart() throws IOException, InterruptedException {

		//h4[@class='mb-0']
		loginB2BUser.b2bUserLogin();
		 cartNo1= loginB2BUser.returnCartNo();
		String endPointURLCart = createBaseURL.getBaseURI("/users"+userName+"/carts/"+cartNo1+"/entries/0");
		RestFrameworkLogger.initLogger();

		RestFrameworkLogger.startTestCase("createCart");
		RestFrameworkLogger.info("Step 1 : Generating Payload String");
		String request_Payload = payLoadGenerator.generatePayload("configuratorCartCreate.json");
		RestFrameworkLogger.info("Step 2 : Executing Create Cart Call");
		response = requestMethodBaseClass.postRequest(endPointURLCart, request_Payload, bearerToken);
		String responseString = response.getBody().asString();
		RestFrameworkLogger.info("Step 3 : Validating Response Status code");
		Assert.assertEquals(commonUtillFunctions.getStatusCode(response), 200);
		RestFrameworkLogger.info(commonUtillFunctions.getStatusMessage(response));
		Assert.assertEquals(commonUtillFunctions.geConvertedResponseKeyValue(responseString, "cartNo"),
				commonUtillFunctions.geConvertedResponseKeyValue(request_Payload, "cartNo"));
		
		loginB2BUser.refreshPage();
		RestFrameworkLogger.endestCase("createCart");
		
		

	}
	@Test(dependsOnMethods = "configuratorcreateCart")
	public void plmcreateCart() throws IOException, InterruptedException {

		//h4[@class='mb-0']
		
		String endPointURLCart = createBaseURL.getBaseURI("/users"+userName+"/carts/"+cartNo1+"/entries/1/plm");
		RestFrameworkLogger.initLogger();

		RestFrameworkLogger.startTestCase("createCart");
		RestFrameworkLogger.info("Step 1 : Generating Payload String");
		String request_Payload = payLoadGenerator.generatePayload("plmCartCreate.json");
		RestFrameworkLogger.info("Step 2 : Executing Create Cart Call");
		response = requestMethodBaseClass.postRequest(endPointURLCart, request_Payload, bearerToken);
		String responseString = response.getBody().asString();
		RestFrameworkLogger.info("Step 3 : Validating Response Status code");
		Assert.assertEquals(commonUtillFunctions.getStatusCode(response), 200);
		RestFrameworkLogger.info(commonUtillFunctions.getStatusMessage(response));
		Assert.assertEquals(commonUtillFunctions.geConvertedResponseKeyValue(responseString, "cartNo"),
				commonUtillFunctions.geConvertedResponseKeyValue(request_Payload, "cartNo"));
		
		loginB2BUser.refreshPage();
		RestFrameworkLogger.endestCase("createCart");
		
		

	}
	/*
	 * public static void main (String[] args) { loginB2BUser.b2bUserLogin();
	 * loginB2BUser.cartPage(); }
	 */
}
