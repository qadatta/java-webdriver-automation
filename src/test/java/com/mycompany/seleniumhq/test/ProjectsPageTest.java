package com.mycompany.seleniumhq.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.mycompany.automation.BaseTest;
import com.mycompany.automation.Page;
import com.mycompany.seleniumhq.pages.AboutPage;
import com.mycompany.seleniumhq.pages.DownloadsPage;
import com.mycompany.seleniumhq.pages.HomePage;


public class ProjectsPageTest extends BaseTest{
	
	private WebDriver driver ;
//	final static Logger logger = Logger.getLogger(Feature1Test.class);

	HomePage homePage;
	AboutPage aboutPage;
	DownloadsPage downloadsPage;
	Page page;
	
	@Test
	public void projectsPageHeadingTest()
	{
		
		homePage =  new HomePage();
		page = new Page();
		page.launchApplication();

		homePage.clickProjectTab()
				.verifyProjectsPageHeading();
		
	}
	
	@Test
	public void projectsPageTitleTest()
	{
		
		homePage =  new HomePage();
		page = new Page();

		page.launchApplication();


		homePage.clickProjectTab()
				.verifyPageTitle("Selenium Projects");
		
	}
	
	@Test
	public void donateButtonOnProjectsPage()
	{
		
		homePage =  new HomePage();
		page = new Page();

		page.launchApplication();


		homePage.clickProjectTab()
				.verifyDonateButton();		
	}
	

}
