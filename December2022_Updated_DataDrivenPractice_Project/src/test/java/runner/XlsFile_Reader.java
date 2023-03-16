package runner;

import org.json.simple.JSONObject;

public class XlsFile_Reader {
	
	public JSONObject getTestData(String sheetName,String flag,int iterationNumber,String xlsFilePath) {
		Xls_Reader reader=new Xls_Reader(xlsFilePath);
		
		int flagRowNumber=1;
		while(!reader.getCellData(sheetName, 0, flagRowNumber).equals(flag)) {
			 flagRowNumber++;
		}
		System.out.println("Flag Row number is "+flagRowNumber);
		
		int colNameRowNumber= flagRowNumber+1;
		int dataStartRowNumber= flagRowNumber+2;
		int index=1;
		
       while(!reader.getCellData(sheetName, 0, dataStartRowNumber).equals("")){
			        int colIndex=0;
			       if(index==iterationNumber) {
			    	   JSONObject json=new JSONObject();
       while(!reader.getCellData(sheetName, colIndex, dataStartRowNumber).equals("")) {
	    	String data=reader.getCellData(sheetName, colIndex, dataStartRowNumber);
		    String columnName=reader.getCellData(sheetName, colIndex,colNameRowNumber );
		    System.out.println(columnName+"     "+data);
		    json.put(columnName, data);
		    colIndex++;
				
			}
                return json;
			}
			 else
				 index++;
         System.out.println("-----------------------------------------");
                 dataStartRowNumber++;

		 }
       return new JSONObject();
	 }

	
	
	public int getTestDataSets(String xlsFilePath, String dataFlag, String sheetName) {
            Xls_Reader reader=new Xls_Reader(xlsFilePath);
		
		int flagRowNumber=1;
		while(!reader.getCellData(sheetName, 0, flagRowNumber).equals(dataFlag)) {
			 flagRowNumber++;
		}
		System.out.println("Flag Row number is "+flagRowNumber);
		
		//int colNameRowNumber= flagRowNumber+1;
		int dataStartRowNumber= flagRowNumber+2;
		int totalRows=0;
		
       while(!reader.getCellData(sheetName, 0, dataStartRowNumber).equals("")){
			       totalRows++;
                 dataStartRowNumber++;

		 }
       System.out.println("total No of rows are "+totalRows);
       return totalRows;
		
	}

  }
