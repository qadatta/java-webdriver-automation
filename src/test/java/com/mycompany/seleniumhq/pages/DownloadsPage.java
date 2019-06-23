package com.mycompany.seleniumhq.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.mycompany.automation.Locator;
import com.mycompany.automation.LocatorType;
import com.mycompany.automation.Page;
import com.mycompany.automation.PageAssert;

public class DownloadsPage extends Page {


	Locator Selenium_Downloads_link= new Locator(LocatorType.XPATH, "//a[contains(.,'Selenium Downloads')]", "Selenium downloads link");
	
	String[] language = {"Java","C#","Ruby","Python","Javascript (Node)"};

	@Override
	public String getPageName() {
		return "Downloads page";
	}

	public void verifyPageTitle(String title) {

		PageAssert.verifyPageTitleContains(title);
	}

	public void verifylanguageBindingDownloads() {

		for (int i = 0; i < language.length; i++) {
			verifyDonloadLinkForLanguage(language[i]);
		}
		
	}

	public void verifyDonloadLinkForLanguage(String language) {
		
		
		WebElement element = null;
		try{
		 element = testAction().getWebDriver().findElement(By.xpath("//tbody/tr/td[text()='"+language+"']/following::td[3]"));
		Assert.assertTrue(element.isDisplayed(),"Download link for langualge "+language+" is not displayed");

		}catch(org.openqa.selenium.NoSuchElementException exception)
		{
			Assert.assertTrue(false,"Download link for langualge "+language+" is not displayed");
		}
	}


}
