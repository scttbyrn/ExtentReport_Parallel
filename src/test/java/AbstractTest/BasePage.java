package AbstractTest;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.LandingPage;

public class BasePage {

	public WebDriver driver;
	public LandingPage landingpage;

	public WebDriver initializer() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		return driver;

	}
	
	@BeforeMethod (alwaysRun = true)
	public LandingPage launchBrowser() {
		
		driver = initializer();
		
		landingpage = new LandingPage(driver);
		
		return landingpage;
		
	}
	
	
//	@AfterMethod (alwaysRun = true)
//	public void tearDown() {
//		
//		driver.quit();
//	}
	
	
	//Screenshots
	public String getScreenShot(String testCaseName, WebDriver driver) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports" +testCaseName+ ".png");
		FileUtils.copyFile(source, file);
		
		return System.getProperty("user.dir") + "//reports" +testCaseName+ ".png";
		
		
	}

}
