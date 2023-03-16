package util;

import java.util.Properties;

public class ConfigLoader {
	public  final Properties properties;
	public static ConfigLoader configLoader;
	
	public ConfigLoader()  {
		properties=PropertiesUtils.propLoader("src/test/resources/config.properties");
	     }
	public static ConfigLoader getInstance() {
		if(configLoader==null) {
			configLoader=new ConfigLoader();
		     }
		return configLoader;
	      }
	
	public String getClientId() {
		String prop=properties.getProperty("client_id");
		if(prop !=null)
			return prop;
		else 
			throw new RuntimeException("client_id is not there in config.properties file");
	}
	public String getSecret() {
		String prop=properties.getProperty("client_secret");
		if(prop !=null)
			return prop;
		else 
			throw new RuntimeException("client_secret is not there in config.properties file");
	}
	public String getGrantType() {
		String prop=properties.getProperty("grant_type");
		if(prop !=null)
			return prop;
		else 
			throw new RuntimeException("grant_type is not there in config.properties file");
	}
	public String getRefreshToken() {
		String prop=properties.getProperty("refresh_token");
		if(prop !=null)
			return prop;
		else 
			throw new RuntimeException("refresh_token is not there in config.properties file");
	}
	
	public String getuserId() {
		String prop=properties.getProperty("user_id");
		if(prop !=null)
			return prop;
		else 
			throw new RuntimeException("user_id is not there in config.properties file");
	}
            }