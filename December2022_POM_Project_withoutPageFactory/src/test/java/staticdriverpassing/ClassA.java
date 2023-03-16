package staticdriverpassing;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class ClassA extends BaseClass{
	
	@Test
	public void AA(ITestContext con) throws InterruptedException {
		System.out.println("starting A");
		//init();
		i=i+500;
		//System.out.println(i);
		//driver.quit();
		Thread.sleep(4000);
		int salary=56090;
		con.setAttribute("id", salary);
		System.out.println("Ending A "+i);
	}
	@Test
	public void init2(ITestContext con) {
		System.out.println("inside method init2 "+con.getAttribute("id"));
		
	}
	

}
