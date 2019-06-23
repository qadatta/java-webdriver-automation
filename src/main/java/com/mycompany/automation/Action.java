package com.mycompany.automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Action {

	private WebDriver driver;
	
	/**
	 * Initialize webdriver instance
	 * @param driver
	 */
	public Action(WebDriver driver)
	{
		this.driver = driver;
	}
	
	/**
	 * return webDriver instance for testing
	 * @return
	 */
	public WebDriver getWebDriver()
	{
		return this.driver;
	}
	
	/**
	 * return first WebElement from Locator on page
	 * @param locator
	 * @return
	 */
	public WebElement getWebElement(By locator)
	{
		return driver.findElement(locator);
	}
	/**
	 * return WebElements from Locator on page
	 * @param locator
	 * @return
	 */
	public List<WebElement> getWebElements(By locator)
	{
		return driver.findElements(locator);
	}
	
	/**
	 * Tread Wait for milliseconds
	 * @param miliSeconds time in milliseconds so that Test will wait for given time
	 */
	public void waitFor(long milliseconds)
	{
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
		}
	}
	
	/**
	 * Click on element 
	 * @param locator
	 */
	public void click(By locator)
	{
		getWebElement(locator).click();
	}

	/**
	 * Enter String values in matching locator
	 * @param locator
	 * @param value
	 */
	public void type(By locator,String value)
	{
		getWebElement(locator).sendKeys(value);
	}
	
	/**
	 * Clear input box and enter value in locator
	 * @param locator
	 * @param value
	 */
	public void clearAndType(By locator,String value)
	{
		getWebElement(locator).clear();
		getWebElement(locator).sendKeys(value);
	}
	
	
	
	/**
	 * Get page title
	 * @return
	 */
	public String getPageTitle()
	{
		return driver.getTitle();
	}
	
	/**
	 * Close and Quit browser
	 */
	public void quit()
	{
		driver.quit();
	}

	/**
	 * Close browser
	 */
	public void close()
	{
		driver.close();
	}

	/**
	 * launch application on default application url which is passed in framework.properties
	 */
	public void launchApplication() {
		driver.get(Configuration.APP_URL);
		driver.manage().window().maximize();
		
	}
	/**
	 * launch application using input url and maximize browser
	 * @param appUrl
	 */
	public void launchApplication(String appUrl) {
		driver.get(appUrl);
		driver.manage().window().maximize();
		
	}
	
	/**
	 * Click on link text
	 * @param linkText 
	 */
	public void clickOnLink(String linkText) {
		waitForElementVisible(By.linkText(linkText));
		click(By.linkText(linkText));
	}
	
	/**
	 * Check whether element is displayed or not
	 * @param locator
	 * @return true/false
	 */
	public boolean isElementDisplayed(By locator) {
		
		return getWebElement(locator).isDisplayed();
	}

	/**
	 * Wait for element to be visible. 30 seconds is time to wait for visibility
	 * @param locator
	 */
	public void waitForElementVisible(By locator) {
		
		new WebDriverWait(getWebDriver(), 30).until(
		        ExpectedConditions.visibilityOf(getWebElement(locator)));
	}

	/**
	 * Wait for page to load. Wait until document readysatte is complete
	 */
	public void waitForPageLoad() {
	    ExpectedCondition<Boolean> pageLoadCondition = new
	        ExpectedCondition<Boolean>() {
	            public Boolean apply(WebDriver driver) {
	                return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
	            }
	        };
	    WebDriverWait wait = new WebDriverWait(getWebDriver(), 60);
	    wait.until(pageLoadCondition);
	}

	/**
	 * Get text of given locator
	 * @param locator
	 * @return
	 */
	public String getText(By locator) {

		return getWebElement(locator).getText();
	}
	

}
