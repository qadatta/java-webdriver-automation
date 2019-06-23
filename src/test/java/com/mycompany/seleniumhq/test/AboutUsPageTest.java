package com.mycompany.seleniumhq.test;

import org.apache.log4j.Logger;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.mycompany.automation.BaseTest;
import com.mycompany.automation.Page;
import com.mycompany.seleniumhq.pages.AboutPage;
import com.mycompany.seleniumhq.pages.DownloadsPage;
import com.mycompany.seleniumhq.pages.HomePage;

public class AboutUsPageTest extends BaseTest{

	final static Logger logger = Logger.getLogger(AboutUsPageTest.class);

	HomePage homePage;
	AboutPage aboutPage;
	DownloadsPage downloadsPage;
	Page page;
	
	
	@Test
	public void veirfyAboutUsPageTest()
	{
		
		Reporter.log("@@@@@@@@@@@@@@@@veirfyAboutUsPageTest "+getAction().getWebDriver().hashCode());
		homePage =  new HomePage();
		page = new Page();

		page.launchApplication();
		homePage.clickAboutTab()
				.verifyAboutPage();
	}
	
	@Test
	public void veirfyAboutUsPageTitle()
	{
		System.out.println("@@@@@@@@@@@@@@@@ veirfyAboutUsPageTitle"+getAction().getWebDriver().hashCode());
		homePage =  new HomePage();
		page = new Page();

		page.launchApplication();

		homePage.clickAboutTab()
				.verifyPageTitle("About Selenium");
	}
	
	@Test
	public void veirfyAboutUsPageTitleFailingTest()
	{

		homePage =  new HomePage();
		System.out.println("@@@@@@@@@@@@@@@@ veirfyAboutUsPageTitleFailingTest"+getAction().getWebDriver().hashCode());

		page = new Page();
		page.launchApplication();
		homePage.clickAboutTab()
				.verifyPageTitle("Automation tool");
	}

}
