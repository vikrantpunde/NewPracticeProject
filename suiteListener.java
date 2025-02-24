package BankTest.Utility;

import org.testng.ISuite;
import org.testng.ISuiteListener;

public class suiteListener implements ISuiteListener{

	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		ISuiteListener.super.onStart(suite);
		System.out.println("Suite Execution started");
	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		ISuiteListener.super.onFinish(suite);
		System.out.println("Suite Execution completed");
	}
	

}
