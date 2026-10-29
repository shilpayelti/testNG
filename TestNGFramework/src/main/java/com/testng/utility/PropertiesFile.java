package com.testng.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFile {
	
	FileInputStream fileinput;
	String value=null;
	
	public String getProperty(String key) {
		
		//1. file path
		String filepath  = "properties/application.properties";
		
		//2. Create a fileinput Stream 
		 try {
			fileinput = new FileInputStream(filepath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 
		//3. Properties file Object 
		 Properties prop = new Properties();
		 
		 try {
			prop.load(fileinput);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 //read the value by passing the key
		value=(String) prop.get(key);
		return value;
		
	}
}