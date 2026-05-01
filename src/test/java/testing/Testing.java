package testing;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import AbstractTest.BasePage;
import AbstractTest.Retry;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.LandingPage;
import pageObjects.SignUpPage;

public class Testing extends BasePage {

//CICD

//	@Test (dataProvider = "getData", groups = {"Smoke"}, retryAnalyzer=Retry.class)
//	public void TC2(String uname, String pword) {
//
//		landingpage.openWebsite("https://github.com");
//		
//		SignUpPage spage = landingpage.verifyClickedHeader();
//		spage.signUpUser(uname, pword);
//		landingpage.explicitWait("//input [@id = 'password']");
//		
////		Assert.fail();
//
//
//	}
//	
//
//	@Test (dataProvider = "getData", dependsOnMethods = "TC2")
//	public void TC1(String uname, String pword) {
//
//		landingpage.openWebsite("https://github.com");
//		SignUpPage spage = landingpage.verifyClickedHeader();
//		spage.signUpUser(uname, pword);
//
//
//	}
//	
//	
//	@Test
//	public void actionsTest() {
//		landingpage.openWebsite("https://github.com");
//		landingpage.mouseHover("//div/button[normalize-space() = 'Solutions']");
//		landingpage.inputUpperCase("//span[normalize-space() = 'Search or jump to...']");
//		
//		
//	}
//	
//	@Test
//	public void windowTabTest() {
//		
//		
//		landingpage.openWebsite("https://rahulshettyacademy.com/loginpagePractise/#");
//		landingpage.windowHandle();
//		
//		
//		
//	}
//	
//	@Test
//	public void FrameHandle() {
//		
//		landingpage.openWebsite("https://jqueryui.com");
//		landingpage.frameHandle();
//		
//		
//	}
//	
	@Test (dataProvider = "getCountryData")
	public void testDropDown(String keyword, String wholeCountry) {
		
		landingpage.openWebsite("https://rahulshettyacademy.com/dropdownsPractise/");
		landingpage.staticDropDown();
		landingpage.loopDropdown();
		landingpage.autoSuggestiveDropdown(keyword, wholeCountry);
		
	}
	
	@Test
	public void testCalendar() {
		
		
		landingpage.CalendarUI();
		
	}



	@DataProvider
	public Object[][] getData() {

		return new Object [] [] {

			{"Scott","Password123"},
			{"Byron","@#$%^&&**()"},
			{"Escueta","1234556789"}

		};

	}
	
	@DataProvider
	public Object[][] getCountryData() {
		
		return new Object [][] {
			
			{"ind","india"},
			{"ame","american samoa"},
			{"jap","japan"}
				
		};
		
	}


}
