package com.API.TestAPIs.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

//import com.publicAPI.TestAPIs.constants.Endpoints;
//import com.publicAPI.TestAPIs.utils.configurationManager;
//
import io.restassured.RestAssured;
import io.restassured.http.Method;
//import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestGETWeather {
	
//	private static final String BASE_URI = configurationManager.getInstance().getString("WeatherURI");
//	private static final String API_KEY = configurationManager.getInstance().getString("APIKEY");
	
//	static RequestSpecification getCommonSpec() {
//		RequestSpecBuilder builder = new RequestSpecBuilder();	
//		builder.setBaseUri("api.openweathermap.org");
//		builder.setBasePath("/data/2.5/weather");
//		
//		RequestSpecification requestSpec = builder.build();
//		
//		return requestSpec;
//	}
//	
	@Test
	public void test1() {
		
//		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
//		
//		RequestSpecification httpRequest = RestAssured.given();
//		
//		Response response = httpRequest.request(Method.GET, "/Hyderabad");
//		
//		System.out.println(response.statusCode());
		
		Response response = RestAssured.given()
				.when()
				.get("api.openweathermap.org/data/2.5/weather?q=London&appid=5c28fd167289513c33153096f42f49a3");

		
		System.out.println(1);
		
		
		
//		Response response = RestAssured
//				.given()
//				.spec(getCommonSpec())
//				.queryParam("q", "London")
//				.queryParam("appid", "5c28fd167289513c33153096f42f49a3")
//				.when()
//				.get();
//		
//		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	

}
