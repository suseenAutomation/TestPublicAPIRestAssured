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
	
	@Test(groups = {"smokeTest"}, priority=1)
	public void test_getWeatherByCity() {
		Response response = GetOpenWeatherAPIHelper.getWeatherByCity("London");
		Assert.assertEquals(response.getStatusCode(), 200);
	}

	@Test(groups = {"regressionTest"}, dependsOnGroups = {"smokeTest"}, priority=2)
	public void test_getWeatherByCoordinate() {
		Response response = GetOpenWeatherAPIHelper.getWeatherByCoordinate(35, 139);
		Assert.assertEquals(response.getStatusCode(), 200);
	}

	@Test(groups = {"regressionTest"}, dependsOnGroups = {"smokeTest"}, priority=3)
	public void test_getWeatherByZipCode() {
		Response response = GetOpenWeatherAPIHelper.getWeatherByZipCode(94040);
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	

}
