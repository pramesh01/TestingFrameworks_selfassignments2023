package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Properties;

public class PropertiesUtils {
	
	public static Properties propLoader(String filePath) {
		Properties properties=new Properties();
		try {
			BufferedReader reader=new BufferedReader(new FileReader(filePath));
			properties.load(reader);
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return properties;
		
		
	}

}
