package Astro_New.Astro_PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Astro_Page extends AbstractComponents {
	
	WebDriver driver;
	

	public void GoTo() {
		driver.get(config.HOME_PAGE_URL);
		 driver.manage().window().maximize();
	}
	
	public void ycap() {
		driver.get(config.Ycap_url);
		 driver.manage().window().maximize();
	}
	
	
	public Astro_Page(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(xpath="//button[contains(text(),'report')]")
	WebElement Report_button;
	
	@FindBy(xpath="//*[@id='hero']/div/div[1]/div/div[3]/a/button")
	WebElement ycap_report;



By report_button = By.xpath("//button[contains(text(),'report')]");
By ycap_button = By.xpath("//*[@id='hero']/div/div[1]/div/div[3]/a/button");





	public void report_button() {
		elementToBeAppeared(report_button);
		Report_button.click();
		System.out.println("Baby Report Button is clicked");
		
		
	}
	
	public void ycap_report() {
		
		elementToBeAppeared(ycap_button);
		ycap_report.click();
		
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@id='menu-item-0'])[2]")));
        String originalWindow = driver.getWindowHandle();
        driver.findElement(By.xpath("(//*[@id='menu-item-0'])[2]")).click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

      //Loop through until we find a new window handle
      for (String windowHandle : driver.getWindowHandles()) {
          if(!originalWindow.contentEquals(windowHandle)) {
              driver.switchTo().window(windowHandle);
              break;
          }
      
		System.out.println("Baby Report Button is clicked");
		
		
      }
	}
}