package com.mycompany.automation;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.qameta.allure.Attachment;;



public class BaseTest {

	final static Logger logger = Logger.getLogger(BaseTest.class);

	private static ThreadLocal<TestContext> testContext = new ThreadLocal<TestContext>();
	private static String fileSeperator = System.getProperty("file.separator");

	public TestContext getContext() {

		return getTestContext();
	}
	
	public Action getAction() {
		return getContext().getAction();
	}
	

	
	@BeforeMethod( alwaysRun = true )
	public void setUp(Method method) throws InterruptedException {
		
		 Test test = method.getAnnotation(Test.class);
	        if (test == null) {
	            return;
	        }
	        
	        System.out.println(test.description());
	        System.out.println(test.testName());
	        
		TestContext tc = new TestContext();
		testContext.set(tc);
		logger.info("Setting test context for new test "+ test.testName());
	}	
	
	@AfterMethod( alwaysRun = true )
	public void screenShot(ITestResult result) {

		TestContext tc = getTestContext();
		
		System.out.println("ITestResult.FAILURE==result.getStatus()" + result.getStatus());
		System.out.println("result.isSuccess()" + result.isSuccess());
		Reporter.log("Screenshot");

		if(false==result.isSuccess())
		{

            String testClassName = getTestClassName(result.getInstanceName()).trim();

            String testMethodName = result.getName().toString().trim();
            String screenShotName = testMethodName + "_execution_count_"+result.getMethod().getCurrentInvocationCount() + ".png"; 
            saveFailureScreenShot(tc.getWebDriver());
			//takeScreenShot(tc.getWebDriver(), screenShotName, testClassName);
			Set<String> atrr = result.getAttributeNames();
			for (Iterator iterator = atrr.iterator(); iterator.hasNext();) {
				String string = (String) iterator.next();
				System.out.println(string);
			}
			
		}
		logger.info("Quiting webdriver after test execution finished.");
		tc.getWebDriver().quit();

	}

	public void log( String message ) {
		Reporter.log( Reporter.getCurrentTestResult().getMethod() + message );
	}
	


    private TestContext getTestContext() {
    	TestContext tc = testContext.get();
        if (tc == null) {
            throw new IllegalStateException("Driver should have not been null.");
        }
        return tc;
    }
	
    
	public String takeScreenShot(WebDriver driver, String screenShotName, String testClassName) {
		try {
			
			String screenShotDirectory = "target" + fileSeperator + "Screenshots" + fileSeperator ;
			File file = new File(screenShotDirectory);
			if (!file.exists()) {
				System.out.println("File created " + file);
				file.mkdir();
			}

			File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			File targetFile = new File(screenShotDirectory, screenShotName);
			FileUtils.copyFile(screenshotFile, targetFile);
			Reporter.log("Screenhsot");
			return screenShotName;
			
		} catch (Exception e) {
			System.out.println("An exception occured while taking screenshot " + e.getCause());
			return null;
		}
	}
	public String getTestClassName(String testName) {
		String[] reqTestClassname = testName.split("\\.");
		int i = reqTestClassname.length - 1;
		System.out.println("Required Test Name : " + reqTestClassname[i]);
		return reqTestClassname[i];
	}
	
	@Attachment
	public byte[] saveFailureScreenShot(WebDriver driver) {
		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
	}
	
	@Attachment
	public byte[] saveSuccessScreenShot(WebDriver driver) {
		
		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
	}
}
