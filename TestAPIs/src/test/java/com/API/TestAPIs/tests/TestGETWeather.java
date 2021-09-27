package com.API.TestAPIs.tests;

import com.API.TestAPIs.helpers.GetOpenWeatherAPIHelper;
import com.API.TestAPIs.utils.csvReaderUtils;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import static java.lang.Float.parseFloat;
import static org.testng.Assert.assertEquals;


public class TestGETWeather {

	private GetOpenWeatherAPIHelper GetOpenWeatherAPIHelper;

	@BeforeClass
	public void init(){
		GetOpenWeatherAPIHelper = new GetOpenWeatherAPIHelper();
	}

	@DataProvider
	public Iterator<Object[]> getWeatherApiData() throws IOException {
		csvReaderUtils.getInstance("testDataByCity.csv");
		ArrayList<Object[]> testData = csvReaderUtils.parseCSV();
		return testData.iterator();
	}
	
	@Test(groups = {"smokeTest"}, priority=1, dataProvider = "getWeatherApiData")
	public void test_getWeatherByCity(String Country, String city,String lon, String lat) {
		Response response = GetOpenWeatherAPIHelper.getWeatherByCity(city);
		assertEquals(response.getStatusCode(), 200);

		JsonPath jsonPathEval = response.jsonPath();

		String PayloadCity = jsonPathEval.get("name");
		Assert.assertTrue(PayloadCity.equalsIgnoreCase(city));

		String PayloadCountry = jsonPathEval.get("sys.country");
		Assert.assertTrue(PayloadCountry.equalsIgnoreCase(Country));

		Float PayloadLat = jsonPathEval.get("coord.lat");
		Assert.assertTrue(PayloadLat-parseFloat(lat)<=Math.abs(1));

		Float PayloadLon = jsonPathEval.get("coord.lon");
		Assert.assertTrue(PayloadLon-parseFloat(lon)<=Math.abs(1));
	}

	@Test(groups = {"regressionTest"}, dependsOnGroups = {"smokeTest"}, priority=2)
	public void test_getWeatherByCoordinate() {
		Response response = GetOpenWeatherAPIHelper.getWeatherByCoordinate(35, 139);
		assertEquals(response.getStatusCode(), 200);
	}

	@Test(groups = {"regressionTest"}, dependsOnGroups = {"smokeTest"}, priority=3)
	public void test_getWeatherByZipCode() {
		Response response = GetOpenWeatherAPIHelper.getWeatherByZipCode(94040);
		assertEquals(response.getStatusCode(), 200);
	}
	

}
