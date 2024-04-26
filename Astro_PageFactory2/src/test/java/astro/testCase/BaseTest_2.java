package astro.testCase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import Astro_New.Astro_PageFactory.Astro_Page;

public class BaseTest_2 {
	public WebDriver driver;
	public Astro_Page homePage;
	

	public WebDriver initializeDriver() throws IOException {
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
			
			
			
			
		}
		
		return driver;
	}
	
	public Astro_Page launchApplication() throws IOException {
		driver = initializeDriver();
		
		homePage = new Astro_Page(driver);
		homePage.GoTo();
		return homePage;
		
	}


}
