package com.mycompany.seleniumhq.test;

import org.testng.annotations.Test;

import com.mycompany.automation.BaseTest;
import com.mycompany.automation.Page;
import com.mycompany.seleniumhq.pages.AboutPage;
import com.mycompany.seleniumhq.pages.DownloadsPage;
import com.mycompany.seleniumhq.pages.HomePage;

public class DownloadsPageTest extends BaseTest{

	
	HomePage homePage;
	AboutPage aboutPage;
	DownloadsPage downloadsPage;
	Page page;

	
	@Test
	public void downloadPageTitleTest()
	{
		
		homePage =  new HomePage();
		page = new Page();
		page.launchApplication();;

		homePage.clickDownloadTab()
				.verifyPageTitle("Downloads");
		
	}
	
	@Test
	public void verifylanguageBindingDownloads()
	{
		
		homePage =  new HomePage();
		page = new Page();
		page.launchApplication();;


		homePage.clickDownloadTab()
				.verifylanguageBindingDownloads();		
	}
	
	@Test
	public void verifylanguageBindingDownloadsForPHP()
	{
		homePage =  new HomePage();
		page = new Page();
		page.launchApplication();;


		homePage.clickDownloadTab()
				.verifyDonloadLinkForLanguage("PHP");		
	}
	
}
