package com.mycompany.seleniumhq;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mycompany.automation.Configuration;

public class TestClassSampleUsingThreadLocal {
    private static final ThreadLocal<ChromeDriver> drivers = new ThreadLocal<ChromeDriver>();

//    @BeforeMethod
//    public void instantiateBrowser() {
//		System.setProperty("webdriver.chrome.driver", Configuration.projectLocation + "/src/main/resources/drivers/chromedriver.exe");
//
//    	ChromeDriver driver = new ChromeDriver();
//        drivers.set(driver);
//    }
//
//    @Test(dataProvider = "dp")
//    public void testMethod(String url) {
//     //   Reporter.log("Launching the URL [" + url + "] on Thread [" + Thread.currentThread().getId() + "]", true);
//    	System.out.println("Launching the URL [" + url + "] on Thread [" + Thread.currentThread().getId() + "]");
//        driver().get(url);
//   //     Reporter.log("Page Title :" + driver().getTitle(), true);
//    }
//
//    @DataProvider(name = "dp", parallel = true)
//    public Object[][] getData() {
//        return new Object[][]{
//                {"http://www.google.com"}, {"http://www.stackoverflow.com"}, {"http://facebook.com"}
//        };
//    }
//
//    @AfterMethod
//    public void cleanupBrowser() {
//    	ChromeDriver driver = driver();
//        driver.quit();
//    }
//
//    private ChromeDriver driver() {
//    	ChromeDriver driver = drivers.get();
//        if (driver == null) {
//            throw new IllegalStateException("Driver should have not been null.");
//        }
//        return driver;
//    }

}