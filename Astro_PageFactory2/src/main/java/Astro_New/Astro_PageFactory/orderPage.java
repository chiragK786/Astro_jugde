package Astro_New.Astro_PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class orderPage extends AbstractComponents {
	WebDriver driver;
	public orderPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath="//*[@id='order__id']")
	WebElement Order_id;
	By Order_id1 = By.xpath("//*[@id='order__id']");
	public void GetOrderId() {
		driver.switchTo().defaultContent();
		elementToBeAppeared(Order_id1);
		String OrderID = Order_id.getText();
		System.out.println(OrderID);
		
	}

}
