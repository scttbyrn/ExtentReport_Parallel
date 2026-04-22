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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReusableMethods {

	WebDriver driver;
	Actions action;
	Select dropdown;

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
		System.out.println(windows);
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

	public void frameHandle() {
		action = new Actions(driver);

		action.moveToElement(driver.findElement(By.xpath("//a[normalize-space() = 'Droppable']")))
		.click()
		.build()
		.perform();

		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class = 'demo-frame']"))); //switching to iframe element of the page

		//locate the elements to drag and drop
		WebElement target = driver.findElement(By.xpath("//div [@id = 'draggable']"));
		WebElement source = driver.findElement(By.xpath("//div [@id = 'droppable']"));

		action.dragAndDrop(target, source).build().perform(); //action to perform the drag and drop
		driver.switchTo().defaultContent(); //return to default content of the webpage

	}

	public void staticDropDown() {

		WebElement currency = driver.findElement(By.xpath("//select [@name= 'ctl00$mainContent$DropDownListCurrency']"));
		dropdown = new Select(currency); //set Select class for the element object

		dropdown.selectByValue("USD");

	}

	public void loopDropdown() {

		action = new Actions(driver);

		action.moveToElement(driver.findElement(By.xpath("//div[@id = 'divpaxinfo']")))
		.click()
		.build()
		.perform();

		for(int i=0; i<4; i++) {
			
			driver.findElement(By.xpath("//span[@id = 'hrefIncInf']")).click();
			
		}

		action.moveToElement(driver.findElement(By.xpath("//input[@value = 'Done']")))
		.click()
		.build()
		.perform();


		//		driver.findElement(By.xpath("//div[@id = 'divpaxinfo']")).click();
		//		driver.findElement(By.xpath("//div[@id = 'divInfant']")).click();
		//		driver.findElement(By.xpath("//input[@value = 'Done']")).click();

	}


}
