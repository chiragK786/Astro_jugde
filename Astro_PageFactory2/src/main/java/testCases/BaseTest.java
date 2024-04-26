package testCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import Astro_New.Astro_PageFactory.Astro_Page;

public class BaseTest {
	public WebDriver driver;

	public WebDriver initializeDriver(WebDriver driver) throws IOException {
		this.driver = driver;		
		Properties prop = new Properties();
		FileInputStream  fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//property//Property//Globaldata.properties");
		prop.load(fis);
		String browserName =	prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("chrome")) {
		ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
	options.addArguments("--window-size=1920,1080");
		driver = new ChromeDriver(options);
		}
		
		else if (browserName.equalsIgnoreCase("fireFox")) {
			
			
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--headless");
			options.addArguments("--window-size=1920,1080");
			driver = new FirefoxDriver(options);
			
			
			
			
		}
		
		return driver;
	}
	
	public Astro_Page launchApplication(WebDriver driver) throws IOException {
		driver = initializeDriver(driver);
		
		Astro_Page homePage = new Astro_Page(driver);
		homePage.GoTo();
		return homePage;
		
	}
}
