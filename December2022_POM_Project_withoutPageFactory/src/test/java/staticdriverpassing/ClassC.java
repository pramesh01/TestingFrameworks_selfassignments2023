package staticdriverpassing;

import org.testng.annotations.Test;

public class ClassC extends BaseClass {

	@Test
	public void CC() throws InterruptedException {
		System.out.println("starting C");
		//init();
		i=i+175;
		//System.out.println(i);
		Thread.sleep(4000);
		//driver.quit();
		System.out.println("Ending C "+i);
}
}