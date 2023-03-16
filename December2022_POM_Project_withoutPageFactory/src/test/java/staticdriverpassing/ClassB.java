package staticdriverpassing;

import org.testng.annotations.Test;

public class ClassB extends BaseClass {

	@Test
	public void BB() throws InterruptedException {
		System.out.println("starting B");
		//init();
	   i=i+300;
		//System.out.println(i);
		Thread.sleep(4000);
		//driver.quit();
		System.out.println("Ending B "+i);
}
}
