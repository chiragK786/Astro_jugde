package Astro_New.Astro_PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class LaunchBrowser {
	

	WebDriver driver;
	public LaunchBrowser(WebDriver driver) {

		
		this.driver = driver;
		
		}
	
	
	public LaunchBrowser() {
		// TODO Auto-generated constructor stub
	}


	public void OpenBrowser(String browser) {
		
		switch(browser.toLowerCase()){
			case"chrome":
				  ChromeOptions options = new ChromeOptions();
			        options.addArguments("--headless");
				  options.addArguments("--incognito");
			        options.addArguments("--window-size=1920,1080");
			        driver = new ChromeDriver(options);
			        break;
			case"firefox":
				 FirefoxOptions option = new FirefoxOptions();
				 option.addArguments("--headless");
			        option.addArguments("--window-size=1920,1080");
			        driver = new FirefoxDriver(option);
			        break;
			        
				 
		}
		
	}

}
