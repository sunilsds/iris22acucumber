package com.iriss22autil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropUtil {

	public String getValue(String filepath, String key) {
		
		FileInputStream fis= null;
		try {
			 fis =  new FileInputStream(filepath);
		} catch (FileNotFoundException e) {
			System.err.println("file not found:"+ filepath);
		}
		
		
		Properties prop = new Properties();
		
		try {
			prop.load(fis);
		} catch (IOException e) {
			System.err.println("unalbleto read properties file:"+ filepath);
		}
		
		return prop.getProperty(key);
		
		
	}
	
	/**
	 * This method can be used on OR.properties file only.
	 * @param key for which we want the loacator
	 * @return ther locator value in the form of {@code String}
	 */
	public String  getLocator(String key) {
		
		String baseDir = System.getProperty("user.dir");
		
		return getValue(baseDir + "/src/main/resources/OR.properties", key);
		
		

	}
	

}
