package com.API.TestAPIs.helpers;

import com.API.TestAPIs.utils.configurationManager;




public class GetWeatherServiceHelper {
	
	private static final String BASE_URI = configurationManager.getInstance().getString("WeatherURI");
	private static final String API_KEY = configurationManager.getInstance().getString("APIKEY"); 
	

}
