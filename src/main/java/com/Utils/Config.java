package com.Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Config {
	
	public String configure(String prop) throws IOException
	{
        FileInputStream fis = new FileInputStream("./src/test/resources/Config/config.properties");
		
		Properties properties = new Properties();
		
		properties.load(fis);
		
		String propAttribute = properties.getProperty(prop);
		
		return propAttribute;
	}

}
