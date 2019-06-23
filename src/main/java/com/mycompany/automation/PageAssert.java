package com.mycompany.automation;

import org.openqa.selenium.By;
import org.testng.Assert;

public class PageAssert {

	public static Action getAction()
	{
		TestContext tc = new BaseTest().getContext();
		return tc.getAction();
	}
	
	public static void verifyPageTitle(String expectedPageTitle)
	{
		getAction().waitForPageLoad();
		
		Assert.assertEquals(getAction().getPageTitle(), expectedPageTitle, "Page Title is not as expected");
	}

	public static void verifyPageTitleContains(String expectedPageTitle)
	{
		getAction().waitForPageLoad();
		if(false==getAction().getPageTitle().contains(expectedPageTitle))
			Assert.assertTrue(false, "Actual page title: \"" +getAction().getPageTitle() + " \" not contains \"" + expectedPageTitle + "\"");
	}
	public static void verifyElementPresent(By locator) {
		if(false==getAction().isElementDisplayed(locator))
			getAction().waitForElementVisible(locator);
		Assert.assertTrue(getAction().isElementDisplayed(locator),"Element not displayed on page");
		
	}

	public static void verifyTextPresentIn(By locator,String textToVerify) {
		getAction().waitForElementVisible(locator);
		if(false==getAction().getText(locator).contains(textToVerify))
			Assert.fail("'"+textToVerify+"' is not present in Element '");	
			//			Assert.fail("'"+textToVerify+"' is not present in Element '"+locator.getLocatorDoc()+"'" );
	}
	
}
