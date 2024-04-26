package Astro_New.Astro_PageFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Payment_page extends AbstractComponents {
	WebDriver driver;

	public Payment_page(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(className = "razorpay-checkout-frame")
	WebElement iframe;
	@FindBy(xpath = "//*[@id='contact']")
	WebElement Contact;
	@FindBy(xpath = "//*[@id='redesign-v15-cta']")
	WebElement Proceed;
	@FindBy(xpath = "//*[@method='upi']")
	WebElement SelectUPI;
	@FindBy(xpath = "//*[@id='upi-collect-list']")
	WebElement EnterUPI;
	@FindBy(xpath = "//*[@id='vpa-upi']")
	WebElement Upi;

	@FindBy(xpath = "//*[@method='netbanking']")
	WebElement Net_banking_pay;
	@FindBy(xpath = "//*[@id='bank-select']")
	WebElement Selecting_bank;
	@FindBy(xpath = "//*[contains(@id,'CNRB')]")
	WebElement Seleced_bank;
	@FindBy(xpath = "//button[contains(text(),'Pay')]")
	WebElement bank_pay_btn;
	@FindBy(xpath = "//button[contains(text(),'Success')]")
	WebElement Success;
	@FindBy(xpath = "//h3[contains(text(),'Preferred')]")
	WebElement Preferred;
	@FindBy(xpath = "//button[contains(@class,'instrument')])[1]")
	WebElement PreferredMethod;
	@FindBy(xpath="//*[@class='total-amount svelte-1sop3ts']")
	WebElement total;
	
	By CONTACT = By.xpath("//*[@id='contact']");
	By SELECT_UPI_BY = By.xpath("//*[@method='upi']");
	By Upi1 = By.xpath("//*[@id='vpa-upi']");
	By Enter_UPI = By.xpath("//*[@id='upi-collect-list']");
	By iFrame = By.className("razorpay-checkout-frame");
	By payment_button = By.xpath("//button[contains(text(),'Pay')]");
	By Select_NetBanking = By.xpath("//*[@method='netbanking']");
	By Select_Bank = By.xpath("//*[@id='bank-select']");
	By Selected_Bank = By.xpath("//*[contains(@id,'CNRB')]");
	By Bank_pay_button = By.xpath("//button[contains(text(),'Pay')]");
	By Bank_pay_success = By.xpath("//button[contains(text(),'Success')]");
	By Bank_pay_failure = By.xpath("//button[contains(text(),'Failure')]");
	By confirm_button = By.xpath("//*[contains(text(),'Confirm')]");
//	By total = By.xpath("total-amount svelte-1sop3ts");

	public void PaymentPage() throws IOException, InterruptedException {
	 	  Properties prop = new Properties();
			FileInputStream  fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//property//Property//Globaldata.properties");
				prop.load(fis);	
			String Payment =	prop.getProperty("payment");

		driver.switchTo().frame(iframe);
		System.out.println("IFrame is Switched");
		Thread.sleep(5000);
		System.out.println(isElementPresent(CONTACT));
		
		
		

		
		
		
		if(isElementPresent(CONTACT)) {
//		elementToBeClickable(CONTACT)
			System.out.println("entered in if");
		
		Contact.sendKeys("9024418309");
		Proceed.click();
		System.out.println("Proceed button is clicked");
		}	
		 
  switch(Payment.toLowerCase()) {
  case "upi":

		elementToBeClickable(SELECT_UPI_BY);
		SelectUPI.click();
		elementToBeClickable(Enter_UPI);
		EnterUPI.click();
		elementToBeClickable(Upi1);
		Upi.sendKeys("9024418309");
		Proceed.click();

		System.out.println("UPI is payment successfull");
		
		break;
  case "netbanking_success":

		System.out.println("Net Bank is selected");

		elementToBeClickable(Select_NetBanking);
		clickElement(Net_banking_pay);
		
		elementToBeAppeared(Select_Bank);
		clickElement(Selecting_bank);

		System.out.println("Bank is selecting");
		elementToBeAppeared(Selected_Bank);
		clickElement(Seleced_bank);

		System.out.println("Bank is selected");

		String originalWindow = driver.getWindowHandle();

		bank_pay_btn.click();

		wait.until(ExpectedConditions.numberOfWindowsToBe(2));

		for (String windowHandle : driver.getWindowHandles()) {
			if (!originalWindow.contentEquals(windowHandle)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}

		elementToBeAppeared(Bank_pay_success);

		Success.click();
		driver.switchTo().window(originalWindow);
		System.out.println("Net Banking payment is successful");
		System.out.println("Waiting for OrderID to Generate..");
		break;
  case "netbanking_failure":

		System.out.println("Net Bank is selected");
		clickElement(Net_banking_pay);
		Net_banking_pay.click();
		elementToBeAppeared(Select_Bank);
		clickElement(Selecting_bank);

		System.out.println("Bank is selecting");
		elementToBeAppeared(Selected_Bank);
		clickElement(Seleced_bank);

		System.out.println("Bank is selected");

		String originalWindow1 = driver.getWindowHandle();

		bank_pay_btn.click();

		wait.until(ExpectedConditions.numberOfWindowsToBe(2));

		for (String windowHandle : driver.getWindowHandles()) {
			if (!originalWindow1.contentEquals(windowHandle)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}

		elementToBeAppeared(Bank_pay_failure);

		Success.click();
		driver.switchTo().window(originalWindow1);
		System.out.println("Net Banking payment is failed");
		
	}
  
	}}
	
	


