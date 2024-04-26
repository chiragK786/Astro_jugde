package Astro_New.Astro_PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import testCases.BaseTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public abstract class AbstractComponents extends BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;

    public AbstractComponents(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        this.actions = new Actions(driver);
    }

    public void elementToBeAppeared(By findBy) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
    }

    public void elementToBeClickable(By findBy) {
        wait.until(ExpectedConditions.elementToBeClickable(findBy));
    }

    public void scrollScreen(int x, int y) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(" + x + ", " + y + ")");
    }



    public void clickElement(WebElement element) {
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("arguments[0].scrollIntoView(true);", element);
    	js.executeScript("arguments[0].click();", element);
    }
    public boolean isElementPresent(By by) {
    	 boolean isPresent = true;
    	 try {
    	 driver.findElement(by);
    	 } catch (NoSuchElementException e) {
    	  isPresent = false;
    	 }
    	return isPresent;
    	}
    
}
