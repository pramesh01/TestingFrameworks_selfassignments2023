package runner;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class DataUtil {
	
	public Map<String,String>  loadClassMethods() throws FileNotFoundException, IOException, ParseException {
		Map<String,String> classMethodMap=new HashMap<String,String>();
		String path=System.getProperty("user.dir")+"//src//test//resources//json//classmethods.json";
	    JSONParser parser=new JSONParser();
	    JSONObject json=(JSONObject) parser.parse(new FileReader(new File(path)));
	    //System.out.println(json.toString());
	   // System.out.println("-------------------------------------------");
	    JSONArray classDetails=(JSONArray)json.get("classdetails");
	    //System.out.println(classDetails.toString());
	    //System.out.println("-------------------------------------------");
	     for(int cMid=0;cMid<classDetails.size();cMid++) {
	    	 JSONObject classDetail=(JSONObject)classDetails.get(cMid);
	    	 //System.out.println(classDetail.toString());
	    	 String className=(String)classDetail.get("class");
	    	// System.out.println(className.toString());
	    	 JSONArray MethodsArray=(JSONArray)classDetail.get("methods");
	    	 for(int mId=0;mId<MethodsArray.size();mId++) {
	    		 String method=(String) MethodsArray.get(mId);
	    		 //System.out.println(method);
	    		 classMethodMap.put(method, className);
	    	 }
	    	  // System.out.println("-------------------------------------------"); 
	     }
	          // System.out.println(classMethodMap);
	           return classMethodMap;	
	}
	
	public int getTestDataSets(String pathfile,String dataFlag) throws FileNotFoundException, IOException, ParseException {
		JSONParser parser=new JSONParser();
		JSONObject json=(JSONObject) parser.parse(new FileReader(new File(pathfile)));
		JSONArray testDataSets=(JSONArray)json.get("testdata");
		for(int dsetid=0;dsetid<testDataSets.size();dsetid++) {
			JSONObject testData=(JSONObject)testDataSets.get(dsetid);
			String flag=(String)testData.get("flag");
			if(dataFlag.equals(flag)) {
				JSONArray dataSets=(JSONArray)testData.get("data");
				return dataSets.size();
			}
		}
		return -1;
	}
	
	public JSONObject getTestData(String pathfile,String dataFlag,int iteration) throws FileNotFoundException, IOException, ParseException {
		JSONParser parser=new JSONParser();
		JSONObject json=(JSONObject) parser.parse(new FileReader(new File(pathfile)));
		JSONArray testDataSets=(JSONArray)json.get("testdata");
		for(int dsetid=0;dsetid<testDataSets.size();dsetid++) {
			JSONObject testData=(JSONObject)testDataSets.get(dsetid);
			String flag=(String)testData.get("flag");
			if(dataFlag.equals(flag)) {
				JSONArray dataSets=(JSONArray)testData.get("data");
				JSONObject data=(JSONObject)dataSets.get(iteration);
				return data;
			}
				
			}
		return null;
		
	}

}
