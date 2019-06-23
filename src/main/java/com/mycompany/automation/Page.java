package com.mycompany.automation;

import io.qameta.allure.Step;

public class Page {

	SiteFactory siteFactory;
	
	public Action testAction()
	{
		TestContext tc = new BaseTest().getContext();
		return tc.getAction();
	}

//	public Page(SiteFactory siteFactory) {
//		this.siteFactory = siteFactory;
//	}

	public void verifyPageTitleContains(String pageTitle)
	{
		PageAssert.verifyPageTitleContains(pageTitle);
	}
	
	public String getPageName()
	{
		return "Page";
	}
	
	/**
	 * Application will be launched on url given in property file.
	 * @return
	 */
	public FrameworkAction launchApplication() {
		openUrl(Configuration.APP_URL);
		return new FrameworkAction(siteFactory);
	}
	

	/**
	 * Open given url in current browser
	 * @param APP_URL Url as a string that need to be open
	 * @return
	 */
	@Step("launch applicatio on {Configuration.APP_URL}")
	public FrameworkAction openUrl(String APP_URL) {
		testAction().getWebDriver().get(APP_URL);
		return new FrameworkAction(siteFactory);
	}
}
