package utility;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.webtestclient.RestAssuredWebTestClient;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class authenticationToken {

	String clientId = "occ_Azure";
	String clientSecret = "ap*61Y1pE*wr";
	boolean getToken = true;
	
	 public static String getOAuth2AccessToken() {
		 RequestSpecification requestSpecification = RestAssured.given();
		 requestSpecification.auth().basic("occ_Azure", "ap*61Y1pE*wr").queryParam("grant_type", "client_credentials")
		 	.queryParam("client_id", "occ_Azure").queryParam("client_secret", "ap*61Y1pE*wr");
		 requestSpecification.contentType(ContentType.URLENC);
		 Response response = requestSpecification.post("https://api.c9z0em8xjj-kawasakih2-s1-public.model-t.cc.commerce.ondemand.com/authorizationserver/oauth/token");
		return response.getBody().jsonPath().getString("access_token");
	 }
	
}
