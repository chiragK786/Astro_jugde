package Astro_New.Astro_PageFactory;

import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.github.javafaker.Faker;

public class Baby_report_form extends AbstractComponents {

	WebDriver driver;

	Faker fake = new Faker(new Locale("en-IND"));

	public Baby_report_form(WebDriver driver) {
		super(driver);

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//*[@name='child-name']")
	WebElement CHILD_NAME;

	@FindBy(xpath = "//*[@name='mother-name']")
	WebElement MOTHER_NAME;

	@FindBy(xpath = "//*[@name='father-name']")
	WebElement FATHER_NAME;

	@FindBy(xpath = "//*[@id='baby-gender']")
	WebElement BABY_GENDER_DROPDOWN;

	@FindBy(xpath = "//*[@id='location-input']")
	WebElement LOCATION_INPUT;

	@FindBy(xpath = "//*[@id='location-suggestions']/li[1]")
	WebElement LOCATION_SUGGESTION;

	@FindBy(xpath = "//*[@id='baby-dob-day']")
	WebElement BABY_DOB_DAY;

	@FindBy(xpath = "//*[@id='baby-dob-month']")
	WebElement BABY_DOB_MONTH;

	@FindBy(xpath = "//*[@id='baby-dob-year']")
	WebElement BABY_DOB_YEAR;

	@FindBy(xpath = "//*[@id='baby-tob']")
	WebElement BABY_TOB;

	@FindBy(xpath = "//*[@class='hourselect']")
	WebElement HOUR_SELECT;
	@FindBy(xpath = "//*[@class='minuteselect']")
	WebElement MINUTE_SELECT;
	@FindBy(xpath = "//*[@class='ampmselect']")
	WebElement AM_SELECT;

	@FindBy(xpath = "//*[@id='email']")
	WebElement EMAIL;

	@FindBy(xpath = "//*[@id='phone_number']")
	WebElement PHONE_NUMBER;

	@FindBy(xpath = "//button[contains(text(),'payment')]")
	WebElement payment;
	@FindBy(xpath= "//*[@id='location-suggestions']/li[1]")

	By CHILD = By.xpath("//*[@name='child-name']");

	By LOCATION_SUGGESTION1 = By.xpath("//*[@id='location-suggestions']/li[1]");
	By BABY_DOB_DAY1 = By.xpath("//*[@id='baby-dob-day']");

	By BABY_TOB1 = By.xpath("//*[@id='baby-tob']");

	By payment1 = By.xpath("//button[contains(text(),'payment')]");

	String name = fake.name().fullName();
	String father_name = fake.name().fullName();
	String mother_name = fake.name().fullName();
	String address = fake.address().city();
	int date = fake.number().numberBetween(1, 27);
	int ran_month = fake.number().numberBetween(0, 11);
	int ran_year = fake.number().numberBetween(1, 8);
	int y_year = fake.number().numberBetween(18, 20);
	int gender = fake.number().numberBetween(0, 1);
	String email = fake.internet().emailAddress();

	public void child_name() {
		elementToBeAppeared(CHILD);
		CHILD_NAME.sendKeys(name);
		System.out.println("name is filled");

	}

	public void father_name() {
//		element_to_be_appeared(Locators.FATHER_NAME);
		FATHER_NAME.sendKeys(father_name);
		System.out.println("father name is filled");

	}

	public void mother_name() {
//		element_to_be_appeared(Locators.MOTHER_NAME);
		MOTHER_NAME.sendKeys(mother_name);
		System.out.println("mother name is filled");

	}

	public void location_input() {

//		scrollScreen(0, 600);
		LOCATION_INPUT.sendKeys(address);
	

		elementToBeAppeared(LOCATION_SUGGESTION1);
		clickElement(LOCATION_SUGGESTION);
		


//		try {
//			LOCATION_SUGGESTION.click();
//		} catch (StaleElementReferenceException e) {
//			element_to_be_appeared(LOCATION_SUGGESTION1);
//			LOCATION_SUGGESTION.click();
//		}
		System.out.println("Address is filled");
	}

	public void gender() {

		Select dropdown = new Select(BABY_GENDER_DROPDOWN);
		dropdown.selectByIndex(gender);
		System.out.println("Gender is selected");

	}

	public void date_of_birth() {
		elementToBeAppeared(BABY_DOB_DAY1);

		Select Day = new Select(BABY_DOB_DAY);
		String random = String.valueOf(date);
		Day.selectByValue(random);
		Select Month = new Select(BABY_DOB_MONTH);
		Month.selectByIndex(ran_month);
		Select Year = new Select(BABY_DOB_YEAR);
		Year.selectByIndex(ran_year);
		System.out.println("Date of Birth is filled");

	}

	public void time() {
		
		clickElement(BABY_TOB);
		Select Hour = new Select(HOUR_SELECT);
		Hour.selectByIndex(ran_month);
		Select min = new Select(MINUTE_SELECT);
		min.selectByIndex(ran_month);
		Select am = new Select(AM_SELECT);
		am.selectByIndex(gender);
		System.out.println("Birth time is filled");

	}

	public void email() {
		EMAIL.sendKeys(email);
		System.out.println("email is filled");
	}
	


    // Generate a phone number starting from 3, 4, or 5
    String phoneNumber = generatePhoneNumber(fake);



public static String generatePhoneNumber(Faker faker) {
    String[] startDigits = {"3", "4", "5"};
    String startDigit = startDigits[faker.random().nextInt(startDigits.length)];

    // Generate the remaining 9 digits randomly
    StringBuilder numberBuilder = new StringBuilder();
    numberBuilder.append(startDigit);
    for (int i = 0; i < 9; i++) {
        int digit = faker.number().numberBetween(0, 10); // Generate a random digit between 0 and 9
        numberBuilder.append(digit);
    }

    return numberBuilder.toString();
}

	public void phone() {
		PHONE_NUMBER.sendKeys(phoneNumber);
		System.out.println("Phone Number is filled");
	}

	public void submit() {

		elementToBeClickable(payment1);
		clickElement(payment);
//		payment.click();

		System.out.println("payment button is clicked");

	}
	
	public void ycap_year() {
		elementToBeAppeared(BABY_DOB_DAY1);

		Select Day = new Select(BABY_DOB_DAY);
		String random = String.valueOf(date);
		Day.selectByValue(random);
		Select Month = new Select(BABY_DOB_MONTH);
		Month.selectByIndex(ran_month);
		Select Year = new Select(BABY_DOB_YEAR);
		Year.selectByIndex(y_year);
		System.out.println("Date of Birth is filled");

		
	}
}
