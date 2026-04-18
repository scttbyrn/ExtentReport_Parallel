package abstractMethods;

import org.openqa.selenium.WebDriver;

public class ReusableMethods {
	
	WebDriver driver;
	
	public ReusableMethods(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	public void openWebsite(String url) {
		
		driver.get(url);
		
//		https://github.com
		
	}

}
