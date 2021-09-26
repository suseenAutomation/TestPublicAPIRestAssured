package com.API.TestAPIs.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.API.TestAPIs.utils.configurationManager;

//import com.publicAPI.TestAPIs.constants.Endpoints;
//import com.publicAPI.TestAPIs.utils.configurationManager;
//
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
//import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestGETWeather {
	
	private static final String BASE_URI = configurationManager.getInstance().getString("WeatherURI");
	private static final String API_KEY = configurationManager.getInstance().getString("APIKEY");
	
	
	
	@Test
	public void test1() {
		
//		RestAssured.baseURI = "https://api.openweathermap.org/data/2.5/weather";
//		RequestSpecification httpRequest = RestAssured.given();
//		httpRequest.queryParams("q", "London","appid","5c28fd167289513c33153096f42f49a3");
//		
//		Response response = httpRequest.log().all().when().get();
//		
//		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	

}
