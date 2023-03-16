package com.zoho.dataprovider;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

import com.zoho.util.DataUtil;
import com.zoho.util.Xls_Reader;

public class TestDataProvider {
	
	static Xls_Reader xls=new Xls_Reader(System.getProperty("user.dir")+"//Data.xlsx");
	static Xls_Reader xls1=new Xls_Reader(System.getProperty("user.dir")+"//Data1.xlsx");
	static Xls_Reader xls2=new Xls_Reader(System.getProperty("user.dir")+"//Data2.xlsx");
	
	@DataProvider
	public static Object[][] getData(Method m){
		//Object[][] data=null;
		//data=new Object[2][3];
		//System.out.println("test case name inside data provider is "+m.getName());
		return DataUtil.getData(m.getName(), xls);
	}
	@DataProvider
	public static Object[][] getData2(Method m){
		//Object[][] data=null;
		//data=new Object[2][3];
		//System.out.println("test case name inside data provider is "+m.getName());
		return DataUtil.getData(m.getName(), xls2);
	}
}
