package com.requestresponse.method;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utility.RestFrameworkLogger;

public class requestMethodBaseClass {
	public static Response getRequest(String endPointURL) {
		RestFrameworkLogger.initLogger();
	    RestFrameworkLogger.info("Get Request URI is - " + endPointURL);
		RequestSpecification requestSpecification = RestAssured.given().contentType(ContentType.JSON);
		Response response = requestSpecification.get(endPointURL);
		RestFrameworkLogger.info("Get Request Response is - " + response.getBody().asString());
		return response;
	}

	public static Response postRequest(String endPointURL) {
		RestFrameworkLogger.initLogger();
	    RestFrameworkLogger.info("Post Request URI is - " + endPointURL);
		RequestSpecification requestSpecification = RestAssured.given().contentType(ContentType.JSON);
		Response response = requestSpecification.post(endPointURL);
		RestFrameworkLogger.info("Post Request Response is - " + response.getBody().asString());
		return response;
	}
	
	public static Response postRequest(String endPointURL,String payLoad, String bearerToken) {
		RestFrameworkLogger.initLogger();
	    RestFrameworkLogger.info("Post Request URI is - " + endPointURL);
	    RestFrameworkLogger.info("Post Request Payload is - " + payLoad);
		RequestSpecification requestSpecification = RestAssured.given().body(payLoad).contentType(ContentType.JSON);
		requestSpecification.header("Authorization", "Bearer " + bearerToken);
		Response response = requestSpecification.post(endPointURL);
		RestFrameworkLogger.info("Post Request Response is - " + response.getBody().asString());
		return response;
	}
}
