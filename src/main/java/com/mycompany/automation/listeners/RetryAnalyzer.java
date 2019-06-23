package com.mycompany.automation.listeners;

import org.apache.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.mycompany.automation.BaseTest;

public class RetryAnalyzer implements IRetryAnalyzer{
	public  int retryCount = 0;
    private int maxRetryCount = 1;
	final static Logger logger = Logger.getLogger(BaseTest.class);

	
	
	public boolean retry(ITestResult result) {

		if(retryCount<maxRetryCount)
		{
			 	logger.info("Retrying test " + result.getName() + " with status "
	                    + getResultStatusName(result.getStatus()) + " for the " + (retryCount+1) + " time(s).");
			   retryCount++;
	            return true;
		}
		else
			return false;
	}

	public String getResultStatusName(int status) {
    	String resultName = null;
    	if(status==1)
    		resultName = "SUCCESS";
    	if(status==2)
    		resultName = "FAILURE";
    	if(status==3)
    		resultName = "SKIP";
		return resultName;
    }
	
}
