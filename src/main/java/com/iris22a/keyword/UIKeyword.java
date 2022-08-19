package com.iris22a.keyword;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.swing.text.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author sunilingole
 *
 */

public class UIKeyword {

	public static RemoteWebDriver driver;

	public static void openBrowser(String browserName) {
		if (browserName.equalsIgnoreCase("Chrome")) {

			WebDriverManager.chromedriver().setup();

			driver = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("Firefox")) {

			WebDriverManager.firefoxdriver().setup();

			driver = new FirefoxDriver();

		}

		else if (browserName.equalsIgnoreCase("IE")) {

			WebDriverManager.iedriver().setup();

			driver = new InternetExplorerDriver();

		}

		System.out.println(browserName + "browser launch successfully");

	}

	public static void launchurl(String url) {

		driver.get(url);

		System.out.println("Url is launch:" + url);

	}

	public static void closeBrowser() {

		driver.close();

		System.out.println("Browser is closed successfully");

	}

	public static void switchToWindow(String byTitle) {

		String parentWindow = driver.getWindowHandle();

		Set<String> windows = driver.getWindowHandles();

		String title = driver.getTitle();

		for (String window : windows) {

			if (driver.switchTo().window(window).getTitle().equals(byTitle)) {

				System.out.println("Switched on window:" + byTitle);
				break;
			}
		}

	}

	public static void enterText(By element, String text) {

		driver.findElement(element).sendKeys(text);
	}

	public static void hitButton(int keycode) throws AWTException {

		Robot robo = new Robot();

		robo.keyPress(keycode);

	}

	public static List<String> getTexts(By element) {
		List<WebElement> elements = driver.findElements(element);

		List<String> texts = new ArrayList<String>();

		for (WebElement elmnt : elements) {

			texts.add(elmnt.getText());
		}
		return texts;
	}

	public static void mouseMove(By xpath) {

		Actions act = new Actions(driver);

		act.moveToElement(driver.findElement(xpath)).build().perform();

	}

	public static void click(By xpath) {
		driver.findElement(xpath).click();

	}

	public void click(String locatorType, String locatorValue) {

		if (locatorType.equalsIgnoreCase("xpath")) {

			driver.findElement(By.xpath(locatorValue)).clear();  

		}

		else if (locatorType.equalsIgnoreCase("id")) {

			driver.findElement(By.id(locatorValue)).click();
		}

		else if (locatorType.equalsIgnoreCase("css")) {

			driver.findElement(By.cssSelector(locatorValue)).click();
		}

		else if (locatorType.equalsIgnoreCase("linkText")) {

			driver.findElement(By.linkText(locatorValue)).click();
		}

		else if (locatorType.equalsIgnoreCase("partialLinkText")) {

			driver.findElement(By.partialLinkText(locatorValue)).click();
		}

		else if (locatorType.equalsIgnoreCase("class")) {

			driver.findElement(By.className(locatorValue)).click();
		}

		else if (locatorType.equalsIgnoreCase("tagName")) {

			driver.findElement(By.tagName(locatorValue)).click();
		}

		else if (locatorType.equalsIgnoreCase("name")) {

			driver.findElement(By.name(locatorValue)).click();
		}

		else {

			System.err.print("Invalid locator type:" + locatorType);
		}
		
		
		

	}
	
	public void mouseMove(WebElement menMenu) {
		
		Actions action = new Actions(UIKeyword.driver);
		
		action.moveToElement(menMenu).perform();


		
		
		

	}

	public static void enterText(WebElement element, String productName) {
	
		
		element.sendKeys(productName );
		
	}
	
	

}
