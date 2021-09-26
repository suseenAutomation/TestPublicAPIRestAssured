package com.API.TestAPIs.tests;

import com.API.TestAPIs.helpers.GetOpenWeatherAPIHelper;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.response.Response;


public class TestGETWeather {

	private GetOpenWeatherAPIHelper GetOpenWeatherAPIHelper;

	@BeforeClass
	public void init(){
		GetOpenWeatherAPIHelper = new GetOpenWeatherAPIHelper();
	}
	
	@Test
	public void test1() {

		Response response = GetOpenWeatherAPIHelper.getWeatherByCity("London");
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	

}
