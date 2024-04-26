package Astro_New.Astro_PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Snippet {
	public WebDriver driver;
	  @BeforeMethod
	    public void setUp() {
	        ChromeOptions options = new ChromeOptions();
	        options.addArguments("--headless");
	        options.addArguments("--window-size=1920,1080");
	        driver = new ChromeDriver(options);
	    }
	
	    @Test
	    public void submit_order() {
	        Astro_Page homePage = new Astro_Page(driver);
	        confirm_page confirmPage = new confirm_page(driver);
	        Baby_report_form report_form = new Baby_report_form(driver);
	        Payment_page paymentPage = new Payment_page(driver);
	        orderPage OrderPage = new orderPage(driver);
	        homePage.GoTo();
	        homePage.report_button();
	        report_form.child_name();
	        report_form.mother_name();
	        report_form.father_name();
	        report_form.gender();
	        report_form.location_input();
	        report_form.date_of_birth();
	        report_form.time();
	        report_form.email();
	        report_form.phone();
	        report_form.submit();
	        confirmPage.click_confirm();
	        paymentPage.PaymentPage("netBanking_Success");
	        OrderPage.GetOrderId();
	    }
	
	    @AfterMethod
	    public void tearDown(ITestResult result) {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	}


