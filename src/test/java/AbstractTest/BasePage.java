package AbstractTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.LandingPage;

public class BasePage {

	public WebDriver driver;
	public LandingPage landingpage;


	public WebDriver initializer() throws IOException {
		
		//Set this area to define what Browser need to run during test
		Properties properties = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "//src//main//java//resources//GlobalData.properties");
		properties.load(fis);
		
		String browserName = System.getProperty("browser") !=null ? System.getProperty("browser") : properties.getProperty("browser"); //set the browser environment in mvn 
		
//		String browserName = properties.getProperty("browser"); //set the browser environment locally
		
		//
		
		if (browserName.equalsIgnoreCase("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
	
		}
		else if (browserName.equalsIgnoreCase("edge")) {
			
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		return driver;
		
		/* To run this in maven environment using cmd:
		 * 
		 * Step 1:
		 * install Apache Maven apache-maven-3.9.15-bin.zip
		 * 
		 * Step 2:
		 * Set it on edit environment and variable on local machine 
		 * With add "New" System variables, MAVEN_HOME, C:\Users\ADMIN\Downloads\apache-maven-3.9.15-bin\apache-maven-3.9.15
		 * And Path %MAVEN_HOME%\bin
		 * 
		 * Step 3:
		 * Create profile in pom.xml
		 * 
		 * Step 4:
		 * Run this command line in cmd with the target Project Folder.
		 * 
		 * mvn test -PRegression -Dbrowser=chrome
		 * 
		 * 
		 * */

	}
	
	@BeforeMethod (alwaysRun = true)
	public LandingPage launchBrowser() throws IOException {
		
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
