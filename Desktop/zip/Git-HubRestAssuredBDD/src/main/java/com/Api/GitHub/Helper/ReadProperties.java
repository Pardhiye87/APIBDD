package com.Api.GitHub.Helper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadProperties {

	private Properties prop;
	private FileInputStream fis;
	private String path = System.getProperty("user.dir") + "\\com.Api.GitHub.Resources\\ApiConfig.properties";

	public String getProperty(String key) {
		prop = new Properties();

		try {
			fis = new FileInputStream(path);
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return prop.getProperty(key);

	}

}
