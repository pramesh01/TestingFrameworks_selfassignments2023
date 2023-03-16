package testcases.rediff;

import org.json.simple.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import testbase.BaseTest;

public class StockManagement extends BaseTest{

	@Test
	public void addFreshStock(ITestContext context) {
		
		JSONObject data=(JSONObject)context.getAttribute("data");
		
		String stockname=(String)data.get("stockname");
		String date=(String)data.get("date");
		String quantity=(String)data.get("quantity");
		String price=(String)data.get("price");
		
		String portfolioName =(String)data.get("portfolioname");
		
		test.log(Status.INFO,"adding the fresh stock.");
		
		app.log("creating new stock");
		app.selectByVisibleText("portFolioDropDown_id",portfolioName);
		app.waitForPageToLoad();
		app.Wait(5);
		app.click("addStockButton_xpath");
		app.type("enterStockNameBox_id", stockname);
		app.Wait(5);
		app.pressEnterButton("enterStockNameBox_id");
		app.click("calendarWidget_id");
		app.selectDateFromCalendar(date);
		app.type("enterStockQuantity_id", quantity);
		app.type("enterStockPrice_id", price);
		app.click("addStockSubmitButton_id");
		//app.waitForPageToLoad();
		app.Wait(10);
		
	}
	@Parameters({"action"})
	@Test
	public void modifyStock(String action,ITestContext context) {
	
		JSONObject data=(JSONObject)context.getAttribute("data");
		String stockname=(String)data.get("stockname");
		String date=(String)data.get("date");
		String quantity=(String)data.get("quantity");
		String price=(String)data.get("price");
	
		String portfolioName=(String)data.get("portfolioname");
		
	    app.log("selecting portfolio name from the dropdown list ");
	    app.selectByVisibleText("portFolioDropDown_id",portfolioName);
	    app.waitForPageToLoad();
	    app.Wait(5);
		test.log(Status.INFO,"modifying the stock");	
	    app.goToBuySell(stockname);
	  if(action.equals("sellStock"))
		  app.selectByVisibleText("actionSell_id","Sell");
	  else if(action.equals("buyStock"))
		  app.selectByVisibleText("actionBuy_id", "Buy");
	
	   app.click("BuySellCalendar_id");
	   app.selectDateFromCalendar(date);
	   app.type("Quantity_id", quantity);
	   app.type("BuySellPrice_id", price);
	   app.click("BuySellStockButton_id");
	   //app.waitForPageToLoad();
	   app.Wait(5);
	   app.log("stock has been modified successfully.");
	  }
	
	@Test
	public void verifyStockInList(ITestContext context) {
		JSONObject data=(JSONObject)context.getAttribute("data");
		String companyName=(String)data.get("stockname");
		test.log(Status.INFO,"verifying the stock in the list.");
		//String portfolioName="Pramesh_005";
		app.log("verifying the stock in the Stock List");
		//app.selectByVisibleText("portFolioDropDown_id",portfolioName);
		//app.waitForPageToLoad();
		//String companyName="Tech Mahindra";
		int row = app.getRowNumWithCellData("applicationTable_css", companyName);
		if(row==-1) {
			app.reportFailure("stock is not present in the Stock list hence failed",true);
		}
		else
			System.out.println("stock is "+companyName+" present in the list.");
			app.log("Stock name "+companyName+"  is present.");
	    }
	
	
	@Test
	public void deleteStock() {
	    test.log(Status.INFO,"deleting the stock from the list");	
   		
	      }
       }
