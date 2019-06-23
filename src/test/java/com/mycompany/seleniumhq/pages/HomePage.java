package com.mycompany.seleniumhq.pages;

import org.openqa.selenium.By;

import com.mycompany.automation.Locator;
import com.mycompany.automation.LocatorType;
import com.mycompany.automation.Page;
import com.mycompany.automation.SiteFactory;

import io.qameta.allure.Step;

public class HomePage extends Page {


	By project_tab = By.linkText("Projects");
	By downloads_tab = By.linkText("Download");
	By about_tab = By.linkText("About");
	
	public SiteFactory factory = new SiteFactory();

//	public HomePage(SiteFactory siteFactory) {
//		super(siteFactory);
//	}

	@Step("Click on project tab")
	public ProjectsPage clickProjectTab()
	{
		testAction().click(project_tab);
		return new ProjectsPage();
	}
	
	@Step("Click on downloads tab")
	public DownloadsPage clickDownloadTab()
	{
		testAction().click(downloads_tab);	
		return new DownloadsPage();
	}
	
	@Step("Click on About us tab")
	public AboutPage clickAboutTab()
	{
		testAction().click(about_tab);
		return new AboutPage();
	}
}
