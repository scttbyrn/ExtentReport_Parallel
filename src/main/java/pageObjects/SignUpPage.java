package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import abstractMethods.ReusableMethods;

public class SignUpPage extends ReusableMethods {
	
	WebDriver driver;
	
	public SignUpPage(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
		
		
	}
	
//	@FindBy(xpath = "//ul [@class = 'mzr-navbar-nav mzr-nav-desktop']/li/a")
//	WebElement prod;
	
	public void signUpUser(String uname, String pword) {
		
		driver.findElement(By.xpath("//a[normalize-space() = 'Sign up']")).click();
		driver.findElement(By.xpath("//input [@id = 'email']")).sendKeys(uname);
		driver.findElement(By.xpath("//input [@id = 'password']")).sendKeys(pword);
	}

}
