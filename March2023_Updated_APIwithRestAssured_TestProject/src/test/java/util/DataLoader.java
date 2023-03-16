package util;

import java.util.Properties;

public class DataLoader {
	
	public  final Properties properties;
	public static DataLoader dataLoader;
	
	public DataLoader()  {
		properties=PropertiesUtils.propLoader("src/test/resources/data.properties");
	     }
	public static DataLoader getInstance() {
		if(dataLoader==null) {
			dataLoader=new DataLoader();
		     }
		return dataLoader;
	      }
	
	public String getplaylistId() {
		String prop=properties.getProperty("getPlaylist_ID");
		if(prop !=null)
			return prop;
		else 
			throw new RuntimeException("client_id is not there in config.properties file");
	}
	
	public String updateplaylistID() {
		String prop=properties.getProperty("updatePlaylist_ID");
		if(prop !=null)
			return prop;
		else 
			throw new RuntimeException("client_secret is not there in config.properties file");
	      }
        }