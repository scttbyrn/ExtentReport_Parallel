package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import abstractMethods.ReusableMethods;

public class LandingPage extends ReusableMethods {

	WebDriver driver;
	SignUpPage spage;

	public LandingPage (WebDriver driver) {

		super(driver);
		this.driver = driver;
		
		PageFactory.initElements(driver, this);

	}
	
//	@FindBy(xpath = "//ul [@class = 'mzr-navbar-nav mzr-nav-desktop']/li/a")
//	WebElement prod;
	


	public SignUpPage verifyClickedHeader() {

		List <WebElement> headerfilter = driver.findElements(By.xpath("//ul[@class = 'MarketingNavigation-module__list__tFbMb']/li"));


		Boolean headerverify = headerfilter.stream().anyMatch(headerss -> headerss.getText().equalsIgnoreCase("open source"));

		if (headerverify) {

			WebElement headerclick = headerfilter.stream().filter( headers -> headers.getText().equalsIgnoreCase("open source")).findFirst().orElse(null);
			headerclick.click();

		}
		else {

			System.out.println("no such element");

		}

		spage = new SignUpPage(driver);
		
		return spage;

	}

}
