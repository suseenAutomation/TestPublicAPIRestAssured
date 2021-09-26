package com.API.TestAPIs.helpers;

import com.API.TestAPIs.constants.Endpoints;
import com.API.TestAPIs.utils.configurationManager;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetOpenWeatherAPIHelper {

    private static final String BASE_URI = configurationManager.getInstance().getString("WeatherURI");
	private static final String API_KEY = configurationManager.getInstance().getString("APIKey");

    public GetOpenWeatherAPIHelper(){
        RestAssured.baseURI = BASE_URI;
        RestAssured.basePath = Endpoints.GET_WEATHER;
    }

    public Response getWeatherByCity(String city){
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.queryParams("q", city,"appid",API_KEY);
        return httpRequest.when().get();
    }

    public Response getWeatherByCoordinate(int latitude, int longitude){
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.queryParams("lat",latitude,"lon",longitude,"appid",API_KEY);
        return httpRequest.when().get();
    }

    public Response getWeatherByZipCode(int zipCode){
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.queryParams("zip", zipCode,"appid",API_KEY);
        return httpRequest.when().get();
    }

}
