package com.mycompany.automation.listeners;

import java.util.Set;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

public class TestListener implements ITestListener{

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		Set<ITestResult> failedTests = context.getSkippedTests().getAllResults();
		for (ITestResult temp : failedTests) {
			ITestNGMethod method = temp.getMethod();
			if (context.getFailedTests().getResults(method).size() > 1) {
				System.out.println("++++++++"+temp);
				failedTests.remove(temp);
			} else if (context.getPassedTests().getResults(method).size() > 0) {
				System.out.println("--------"+temp);

				failedTests.remove(temp);
			} else if (context.getSkippedTests().getResults(method).size() > 0) {
				System.out.println(">>>>>>>>"+temp);

				failedTests.remove(temp);
			}
			}
	}
}
