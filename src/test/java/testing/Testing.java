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
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.LandingPage;
import pageObjects.SignUpPage;

public class Testing extends BasePage {



	@Test (dataProvider = "getData")
	public void TC2(String uname, String pword) {

		landingpage.openWebsite("https://github.com");
		SignUpPage spage = landingpage.verifyClickedHeader();
		spage.signUpUser(uname, pword);
		
//		Assert.fail();


	}

	@Test (dataProvider = "getData", dependsOnMethods = "TC2")
	public void TC1(String uname, String pword) {

		landingpage.openWebsite("https://github.com");
		SignUpPage spage = landingpage.verifyClickedHeader();
		spage.signUpUser(uname, pword);


	}



	@DataProvider
	public Object[][] getData() {

		return new Object [] [] {

			{"Scott","Password123"},
			{"Byron","@#$%^&&**()"},
			{"Escueta","1234556789"}

		};

	}


}
