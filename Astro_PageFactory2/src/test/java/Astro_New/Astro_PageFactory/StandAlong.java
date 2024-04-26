package Astro_New.Astro_PageFactory;

import java.time.Duration;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;

public class StandAlong {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
	       WebDriverWait    wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	        driver.manage().window().maximize();
		
     driver.get("https://app.astrojudge-uat.squareboat.info/");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'report')]")));
		driver.findElement(By.xpath("//button[contains(text(),'report')]")).click();
		Faker fake = new Faker(new Locale("en-IND"));
		String name = fake.name().fullName();
		String father_name = fake.name().fullName();
		String mother_name = fake.name().fullName();
		String address = fake.address().city();
		Astro_Page landingPage = new Astro_Page(driver);
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name='child-name']")));
		

		driver.findElement(By.xpath("//*[@name='child-name']")).sendKeys(name);
		driver.findElement(By.xpath("//*[@name='mother-name']")).sendKeys(mother_name);
		driver.findElement(By.xpath("//*[@name='father-name']")).sendKeys(father_name);
		WebElement Dropdown = driver.findElement(By.xpath("//*[@id='baby-gender']"));
		Select dropdown = new Select(Dropdown);
		dropdown.selectByIndex(1);
		JavascriptExecutor
		js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollTo(0, 500)");
		driver.findElement(Locators.LOCATION_INPUT).sendKeys(address);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.LOCATION_SUGGESTION)).click();

//		 
		 
		JavascriptExecutor
		js11 = (JavascriptExecutor) driver;
		js11.executeScript("window.scrollTo(0, 760)");
		WebElement day = driver.findElement(By.xpath("//*[@id='baby-dob-day']"));
		WebElement month = driver.findElement(By.xpath("//*[@id='baby-dob-month']"));
		WebElement year = driver.findElement(By.xpath("//*[@id='baby-dob-year']"));
//		
//
		Select Day = new Select(day);
		Day.selectByValue("2");
		Thread.sleep(2000);
		driver.quit();
		Select Month = new Select(month);
		Month.selectByIndex(2);
		Select Year = new Select(year);
		Year.selectByIndex(3);
		Thread.sleep(2000);
//		
//	
		driver.findElement(By.xpath("//*[@id='baby-tob']")).click();
		Thread.sleep(2000);
		WebElement	hour = driver.findElement(By.xpath("//*[@class='hourselect']"));

		Select Hour = new Select(hour);
		Hour.selectByIndex(3);

		driver.findElement(By.xpath("//*[@id='email']")).sendKeys("arushi.bansal@squareboat.com");
		driver.findElement(By.xpath("//*[@id='phone_number']")).sendKeys("9205846748");
		driver.findElement(By.xpath("//button[contains(text(),'payment')]")).click();
//		 
		  Thread.sleep(2000);

		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[3]/div[2]/a[1]")));
		  driver.findElement(By.xpath("/html/body/div[3]/div[3]/div[2]/a[1]")).click();

		  WebElement element = driver.findElement(By.xpath("//*[contains(text(),'Confirm')]"));
		  Actions actions = new Actions(driver);
		  actions.moveToElement(element).click().perform();
//
//	   
	        WebElement iframe = driver.findElement(By.className("razorpay-checkout-frame"));
	        driver.switchTo().frame(iframe);
	      
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='contact']")));
//
		driver.findElement(By.xpath("//*[@id='contact']")).sendKeys("9090909090");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='redesign-v15-cta']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='form-common']/div[1]/div[1]/div/div/div[2]/div/button[1]")));
	 driver.findElement(By.xpath("//*[@id='form-common']/div[1]/div[1]/div/div/div[2]/div/button[1]")).click();
		
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='upi-collect-list']/div/div")));
   driver.findElement(By.xpath("//*[@id='upi-collect-list']/div/div")).click();
//	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='vpa-upi']")));
		driver.findElement(By.xpath("//*[@id='vpa-upi']")).sendKeys("9205846748");
		driver.findElement(By.xpath("//button[contains(text(),'Pay')]")).click();
		driver.switchTo().defaultContent();
     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='order__id']")));
     String Order = driver.findElement(By.xpath("//*[@id='order__id']")).getText();
     System.out.println(Order);
     driver.quit();


	}

}
