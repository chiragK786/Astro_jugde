package Astro_New.Astro_PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class confirm_page extends AbstractComponents {

	WebDriver driver;

	public confirm_page(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//*[contains(text(),'Confirm')]")
	WebElement confirm_button;
	By Confirm_button = By.xpath("//*[contains(text(),'Confirm')]");
	By edit_button = By.xpath("//*[contains(text(),'Edit')]");
	@FindBy(xpath="//*[contains(text(),'Edit')]")
	WebElement edit;

	public void click_confirm() {

		elementToBeAppeared(Confirm_button);
		clickElement(confirm_button);

	}

	public void click_edit() {

		elementToBeAppeared(edit_button);
		clickElement(edit);

	}
}
