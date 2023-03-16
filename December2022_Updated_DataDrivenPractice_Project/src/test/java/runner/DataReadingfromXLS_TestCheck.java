package runner;

public class DataReadingfromXLS_TestCheck {

	public static void main(String[] args) {
		String filePath=System.getProperty("user.dir")+"//src//test//resources//XLSX//Data.xlsx";
		Xls_Reader reader=new Xls_Reader(filePath);
		String sheetName="Stock Suite";
		String flag="addFreshStock";
		int iterationNumber=2;
		
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
while(!reader.getCellData(sheetName, colIndex, dataStartRowNumber).equals("")) {
		String data=reader.getCellData(sheetName, colIndex, dataStartRowNumber);
		String columnName=reader.getCellData(sheetName, colIndex,colNameRowNumber );
		System.out.println(columnName+"     "+data);
		colIndex++;
				
			}
break;
			}
			else
				index++;
System.out.println("-----------------------------------------");
             dataStartRowNumber++;

		}
	}

}
