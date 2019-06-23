package com.mycompany.seleniumhq.pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.mycompany.automation.Locator;
import com.mycompany.automation.LocatorType;
import com.mycompany.automation.Page;
import com.mycompany.automation.PageAssert;
import com.mycompany.automation.SiteFactory;

public class ProjectsPage extends Page {

	By available_projects = By.cssSelector("h3>a");
	By donateButton = By.cssSelector("input[type='image'][alt='PayPal - The safer, easier way to pay online!x']");

	String projectsPageHeading[] = { "Selenium WebDriver", "Selenium Grid", "Selenium IDE", "Selenium Remote Control" };

	public SiteFactory factory = new SiteFactory();

	public void verifyProjectsPageHeading() {

		Assert.assertTrue(testAction().isElementDisplayed(available_projects),
				" Available projects heading is not visible");

		for (int i = 0; i < projectsPageHeading.length; i++) {
			Assert.assertTrue(isHeadingPresent(projectsPageHeading[i]),
					projectsPageHeading[i] + " heading is not visible on page");

		}

	}

	public void verifyDonateButton() {
		Assert.assertTrue(testAction().isElementDisplayed(donateButton), " Donate button is not visible on page");

	}

	public boolean isHeadingPresent(String heading) {
		List<WebElement> projects = testAction().getWebElements(available_projects);

		// System.out.println("Available projects are -");
		for (Iterator iterator = projects.iterator(); iterator.hasNext();) {
			WebElement webElement = (WebElement) iterator.next();
			if (webElement.getText().contains(heading))
				return true;
		}

		return false;
	}

	public void verifyPageTitle(String title) {

		PageAssert.verifyPageTitleContains(title);

	}

}
