package Astro_New.Astro_PageFactory;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Ycap_reporttest {
	
	
	WebDriver driver;
	
	  @BeforeMethod
	    public void setUp() throws IOException {
	

		  LaunchBrowser launch = new LaunchBrowser();
		  launch.OpenBrowser("Chrome");
		  WebDriver driver = launch.driver;
		  this.driver = driver;
	    }

	  
	  @Test
	  
	  public void ycap_order_multiple_times() throws IOException, InterruptedException {
	        for (int i = 1; i <= 2; i++) {
	            System.out.println("Running test iteration: " + i);
	            ycap_order();
	            System.out.println("Test iteration " + i + " completed.");
	        }
	    }
	    public void ycap_order() throws IOException, InterruptedException {
		  
		  Astro_Page homePage = new Astro_Page(driver);
	        confirm_page confirmPage = new confirm_page(driver);
	        Baby_report_form report_form = new Baby_report_form(driver);
	        Payment_page paymentPage = new Payment_page(driver);
	        orderPage OrderPage = new orderPage(driver);
	        homePage.ycap();
	        homePage.report_button();
	        report_form.child_name();
	   

	        report_form.gender();
	        report_form.location_input();
	        report_form.ycap_year();
	        report_form.time();
	        report_form.email();
	        report_form.phone();
	        report_form.submit();
	        confirmPage.click_confirm();
	        paymentPage.PaymentPage();
	        OrderPage.GetOrderId();
		  
	  }
	    @AfterMethod
	    public void tearDown(ITestResult result) {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	  
}
