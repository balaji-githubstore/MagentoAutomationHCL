package com.hcl.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropUtils {

	public static String getValueUsingKey(String fileDetails, String key) throws IOException {
		FileInputStream file = new FileInputStream(fileDetails);
		Properties prop = new Properties();
		prop.load(file);
	
		return prop.getProperty(key);
	}

}
