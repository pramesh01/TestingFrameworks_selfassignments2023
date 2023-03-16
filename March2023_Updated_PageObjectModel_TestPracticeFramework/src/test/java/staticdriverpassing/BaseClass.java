package staticdriverpassing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class BaseClass {
	public static WebDriver driver;
	public  int i=100;
    public void init() {
	   driver=new ChromeDriver();
	   driver.get("https://www.yahoo.com");

}
}