package com.publicAPI.TestAPIs.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class configurationManager {
	
	private static configurationManager manager;
	private static final Properties prop = new Properties();
	
	private configurationManager() throws IOException {
		
		InputStream inputStream = configurationManager.class.getResourceAsStream("../resource/config.properties");
		prop.load(inputStream);
	}
	
	public static configurationManager getInstance( ) {
		if(manager == null) {
			synchronized (configurationManager.class) {
				try {
					manager = new configurationManager();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return manager;
	}
	
	public String getString(String key) {
		return System.getProperty(key, prop.getProperty(key));
	}
	
	

}
