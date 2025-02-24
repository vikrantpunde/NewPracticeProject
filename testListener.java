package BankTest.Utility;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class testListener implements ITestListener {

	@Override
	public void onTestSuccess(ITestResult tr) {
		// TODO Auto-generated method stub
		System.out.println("Test case is passed");
	}

	@Override
	public void onTestFailure(ITestResult tr) {
		// TODO Auto-generated method stub
		System.out.println("Test case is Failed");
	}

	@Override
	public void onTestSkipped(ITestResult tr) {
		// TODO Auto-generated method stub
		System.out.println("Test case is skipped");
	}

	@Override
	public void onFinish(ITestContext testContext) {
		// TODO Auto-generated method stub
		System.out.println("Test case is completed");
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
	}
    
}