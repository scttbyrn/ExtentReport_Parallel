package abstractMethods;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReusableMethods {

	WebDriver driver;
	Actions action;

	public ReusableMethods(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	//	@FindBy(xpath = "//ul [@class = 'mzr-navbar-nav mzr-nav-desktop']/li/a")
	//	WebElement prod;

	public void openWebsite(String url) {

		driver.get(url);

		//		https://github.com

	}

	public void explicitWait(String ele) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ele)));


	}

	public void mouseHover (String ele) {

		action = new Actions(driver);

		action.moveToElement(driver.findElement(By.xpath(ele))).build().perform();

	}

	public void inputUpperCase(String ele) {

		action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath(ele)))
		.click()
		.keyDown(Keys.SHIFT)
		.sendKeys("hello")
		.doubleClick()
		.contextClick()
		.build()
		.perform();
		
		
		//span[normalize-space() = 'Search or jump to...']

	}
	
	public void windowHandle () {
		
		action = new Actions(driver);
		
		action.moveToElement(driver.findElement(By.xpath("//a[normalize-space()= 'Free Access to InterviewQues/ResumeAssistance/Material']")))
		.click()
		.build()
		.perform();
		
		 
		Set<String> windows = driver.getWindowHandles(); // to create handle windows
		Iterator<String> iterate = windows.iterator(); // to handle windows [parentID, childID]
		
		String parentID = iterate.next();
		String childID = iterate.next();
		
		driver.switchTo().window(childID); //execute switch to child tab
		
		
		String email = driver.findElement(By.xpath("//p[@class = 'im-para red']")).getText(); //get the content of email
		System.out.println(email);
		
		String extractEmail = email.split("at")[1].trim().split(" ")[0]; //extract the target email
		System.out.println(extractEmail);
		driver.close();
		
		driver.switchTo().window(parentID); // switch back to parent tab
		action.moveToElement(driver.findElement(By.xpath("//input[@name = 'username']"))) //input extract email on parent tab
		.click()
		.sendKeys(extractEmail)
		.build()
		.perform();
		
//		action.moveToElement(driver.findElement(By.xpath("//a[normalize-space() = 'JOIN NOW']")))
//		.click()
//		.build()
//		.perform();
			
	}
	
	

}
