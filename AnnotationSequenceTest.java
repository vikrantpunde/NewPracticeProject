package BankTest.suites;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AnnotationSequenceTest {

	@BeforeSuite
	public void befSuit() {
		System.out.println("Before suite execution.");
	}
	
	@BeforeClass
	public void befcls() {
		System.out.println("Before class execution.");
	}
	
	@BeforeTest
	public void beftest() {
		System.out.println("Before test execution.");
	}
	
	@BeforeMethod
	public void befmethod() {
		System.out.println("Before method execution.");
	}
	
	
	@AfterSuite
	public void afSuit() {
		System.out.println("After suite execution.");
	}
	
	@AfterClass
	public void aftcls() {
		System.out.println("After class execution.");
	}
	
	@AfterTest
	public void afttest() {
		System.out.println("After test execution.");
	}
	
	@AfterMethod
	public void aftmethod() {
		System.out.println("After method execution.");
	}
	@Test
	public void verifyTitleOfPage() {
		System.out.println("Test1 execution.");
	}
	
}
