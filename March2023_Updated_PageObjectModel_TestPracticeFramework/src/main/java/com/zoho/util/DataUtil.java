package com.zoho.util;

import java.util.Hashtable;
import constants.Constant;

public class DataUtil {
	
	public static Object[][] getData(String testName,Xls_Reader xls){
		//String testName="LoginTest";    //1
		String sheetName="TestCases";  //2
		//Xls_Reader xls=new Xls_Reader(System.getProperty("user.dir")+"//Data.xlsx");
	    int testStartRowNum=1;  //3
	      while(!xls.getCellData(sheetName, 0, testStartRowNum).equals(testName)){
	    	  testStartRowNum++;
	    }
	     // System.out.println("Row no of the test case start is "+testStartRowNum);
	      int colRowNum=testStartRowNum+1;  //4
	      //System.out.println("column starting row number of test case is "+colRowNum);
	      //fetching data of the test cases
	      int totalColsinTestCase=0;//5
	      while(!xls.getCellData(sheetName, totalColsinTestCase, colRowNum).equals("")) {
	    	  totalColsinTestCase++;
	      }
	      //System.out.println("total columns in this testcase is "+totalColsinTestCase);
	      int dataStartRowNum=colRowNum+1;  //6
	      int totalDataRows=0;   //7
	       while(!xls.getCellData(sheetName, 0, dataStartRowNum+totalDataRows).equals("")) {
	    	   totalDataRows++;
	       }
	      // System.out.println("Total rows in data is "+totalDataRows);
	       Object testData[][]=new Object[totalDataRows][1];
	       //extracting the data of the test case
	       Hashtable<String,String> table=null;
	       int i=0;
	      for(int rNum=dataStartRowNum;rNum<(dataStartRowNum+totalDataRows);rNum++) {
	    	  table=new Hashtable<String,String>();
	    	  for(int cNum=0;cNum<totalColsinTestCase;cNum++) {	  
	    	String data=xls.getCellData(sheetName, cNum, rNum);
	    	//fetching out Key.
	    	String Key=xls.getCellData(sheetName, cNum, colRowNum);
	    		 // System.out.print(data+"    ");
	    		  //System.out.println("*******************************************");
	    		 // System.out.print(Key+"   "+data+"  ");
	    		  table.put(Key, data); // After this our table will be ready..
	    	  }
	    	  //at this point table is ready..
	    	  testData[i][0]=table; // in this way your table data is put in to Object array. 
	    	  i++;
	    	  System.out.println(); 
	      }  
	      return testData;
	}
	
	public static boolean isRunnable(String testName,Xls_Reader xls) {
	    String sheetName="TestStatus";
	    String TCID="TCID";
	    String RunMode="RunMode";  //in xlsx sheet test status tab
		   //String testName="LoginTest";
	      //Xls_Reader xls=new Xls_Reader(System.getProperty("user.dir")+"//Data.xlsx");
	     int totalrows=xls.getRowCount(sheetName);
	     System.out.println("total rows in sheet is "+totalrows);
	   for(int rNum=2;rNum<=totalrows;rNum++) {
	    	 String testcasename=xls.getCellData(sheetName, TCID, rNum);
	   if(testName.equals(testcasename)) {
	    	 String runmode=xls.getCellData(sheetName,RunMode, rNum);
	    	// System.out.println(testcasename+" "+runmode);
             if(runmode.equals("Y"))
            	 return true;
             else
            	 return false; 
	       }
             }
	     return false;
         }
		
	}