package com.mycompany.seleniumhq.pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.mycompany.automation.Locator;
import com.mycompany.automation.LocatorType;
import com.mycompany.automation.Page;
import com.mycompany.automation.PageAssert;

import io.qameta.allure.Step;

public class AboutPage extends Page {

	By about_links = By.cssSelector("h3>a");
	String[] aboutUsLinks = { "News/Blog", "Selenium Events", "Sponsorship", "Who made Selenium", "Ecosystem",
			"Get involved", "Documentation" };

	@Step("Verify about page")
	public void verifyAboutPage() {

		for (int i = 0; i < aboutUsLinks.length; i++) {
			
			Assert.assertTrue(isLinkPresent(aboutUsLinks[i]), aboutUsLinks[i] + " link is not present on page");
		}

	}

	public boolean isLinkPresent(String link) {

		testAction().waitForElementVisible(about_links);

		List<WebElement> projects = testAction().getWebElements(about_links);

		for (Iterator<WebElement> iterator = projects.iterator(); iterator.hasNext();) {
			WebElement webElement = (WebElement) iterator.next();

			if (webElement.getText().contains(link)) {
				return true;
			}
		}

		return false;
	}

	@Step("Verification step: Verifying page title")
	public void verifyPageTitle(String title) {
		PageAssert.verifyPageTitle(title);
	}

}
