package runner;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.xml.Parser;

public class JSONRunner {

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		
		Map<String,String> classMethods=new DataUtil().loadClassMethods();
		
		String path=System.getProperty("user.dir")+"//src//test//resources//json//testconfig.json";
		JSONParser parser=new JSONParser();
		JSONObject json=(JSONObject)parser.parse(new FileReader(new File(path)));
		
		String parallelSuits =(String)json.get("parallelsuits");
		//14-01-2214mo
		TestNGRunner testNG=new TestNGRunner(Integer.parseInt(parallelSuits));
	
		
		JSONArray testSuites=(JSONArray)json.get("testsuites");
		    for(int sId=0;sId<testSuites.size();sId++) {
			JSONObject testSuite=(JSONObject)testSuites.get(sId);
			String runMode=(String)testSuite.get("runmode");
			if(runMode.equals("Y")) {
			String name=(String)testSuite.get("name");
//String testdatajsonfile=System.getProperty("user.dir")+"//src//test//resources//json//"+(String)testSuite.get("testdatajsonfile"); //for JSON DATA
String testdatajsonfile=System.getProperty("user.dir")+"//src//test//resources//json//"+(String)testSuite.get("testdataxlsfile");//for XLS file data 
			String suitefilename=(String)testSuite.get("suitefilename");
			String paralleltests=(String)testSuite.get("paralleltests");
			System.out.println(runMode+"  "+name);
            //12-01-22
			boolean pTests=false;
            if(paralleltests.equals("Y"))
            	pTests=true;
            testNG.createSuite(name,pTests);
            testNG.addListener("listener.MyTestListener");
            //--  15/01/2022
            String pathSuiteJSON=System.getProperty("user.dir")+"//src//test//resources//json//"+suitefilename;
    		JSONParser suiteParser=new JSONParser();
    		JSONObject suiteJSON=(JSONObject)suiteParser.parse(new FileReader(new File(pathSuiteJSON)));
    		
    		//System.out.println(suiteJSON);
    		JSONArray suiteTestCases=(JSONArray)suiteJSON.get("testcases");
    		for(int sTId=0;sTId<suiteTestCases.size();sTId++) {
    			JSONObject suiteTestCase=(JSONObject)suiteTestCases.get(sTId);
    			String tName=(String)suiteTestCase.get("name");
    			JSONArray parameternames=(JSONArray) suiteTestCase.get("parameternames");
    			JSONArray executions=(JSONArray)suiteTestCase.get("executions");
    			for(int eid=0;eid<executions.size();eid++) {
    				JSONObject testcase=(JSONObject)executions.get(eid);
    				
    				String tRunMode=(String)testcase.get("runmode");
        			if(tRunMode !=null && tRunMode.equals("Y") ) {
    				
        		    String executionname=(String)testcase.get("executionname");
    				String dataFlag=(String)testcase.get("dataFlag");
    			//17-01-2022
    //int dataSets=new DataUtil().getTestDataSets(testdatajsonfile, dataFlag); //this is for JSON data
   int dataSets=new XlsFile_Reader().getTestDataSets(testdatajsonfile,dataFlag,name); //this is for xls data
    				for(int dsid=0;dsid<dataSets;dsid++) {
    				   	
    				
    				JSONArray parametervalues=(JSONArray)testcase.get("parametervalues");
    				JSONArray methods=(JSONArray)testcase.get("methods");
    				
    				System.out.println(tName+" -> "+executionname);
    			   //System.out.println(parameternames+"->"+parametervalues);
    				//System.out.println(methods);
    				
    				//adding the test name
    				//testNG.addTest(tName+" "+executionname);
    	testNG.addTest(tName+" "+executionname+" iteration "+(dsid+1));
   for(int pid=0;pid<parameternames.size();pid++) {
  testNG.addTestParameter((String)parameternames.get(pid),(String)parametervalues.get(pid));
    }
    //17-01-2022
    testNG.addTestParameter("datafilpath", testdatajsonfile);
    testNG.addTestParameter("dataFlag", dataFlag);
    testNG.addTestParameter("iteration", String.valueOf(dsid));
    testNG.addTestParameter("suitename", name);//for Xls only
    
    	List<String> includeMethods=new ArrayList<String>();
    	for(int mid=0;mid<methods.size();mid++) {
    		String method=(String)methods.get(mid);
    		String methodClass=classMethods.get(method);
    		//System.out.println(method+" - "+methodClass);
    		if(mid==methods.size()-1 || ((String)classMethods.get((String)methods.get(mid+1))).equals(methodClass)) {
    			includeMethods.add(method);
    			testNG.addTestClass(methodClass,includeMethods );
    			includeMethods=new ArrayList<String>();
    		}
    		else {
    			includeMethods.add(method);
    		}
    		
    	}
    				
    	
    		System.out.println("============================================");
    		}
    		}
    		}
    		}
    		testNG.run();
    		
			}
		 }
	       }
            }
