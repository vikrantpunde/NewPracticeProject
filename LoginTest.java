package BankTest.suites;

import org.testng.AssertJUnit;
import org.testng.ITestResult;
import org.testng.Reporter;

import static org.testng.Assert.*;

import java.io.IOException;
import java.sql.Time;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import BankTest.Utility.DriverInstance;
import BankTest.Utility.ReadExcel;
import BankTest.pages.HomePage;
import BankTest.pages.LoginPage;

public class LoginTest{
	
	WebDriver driver;
	LoginPage lpg;
	HomePage hp;
	WebDriverWait wait;
	
	public LoginTest() {
		DriverInstance driverInst= new DriverInstance();
		this.driver=driverInst.getDriver();
		lpg = PageFactory.initElements(this.driver, LoginPage.class);
		hp = PageFactory.initElements(this.driver, HomePage.class);
		wait = new WebDriverWait(this.driver,Duration.ofMillis(10000));
	}
	
	@Test
	public void verifyTitleOfPage() {
		try {
			String txt=driver.getTitle();
			System.out.println(txt);
			Assert.assertEquals(txt, "GTPL Bank Home Page","Page title not matching.");
		}catch(Exception e) {
			throw e;
		}
	}
	
	@Test(priority=2)
	public void printLabels() {
		int len=lpg.labels.size();
		try {
			for(int i=0;i<lpg.labels.size();i++) {
				System.out.println(lpg.labels.get(i).getText());
			}
		}catch(Exception e) {
			throw e;
		}
	}
	
	@Test(dataProvider = "invalidLogin",priority=1)
	public void invalidLoginVerify(String user,String pass) {
		wait.until(ExpectedConditions.visibilityOf(lpg.password));
		lpg.username.sendKeys(user);
		lpg.password.sendKeys(pass);
		lpg.submitBtn.click();
		wait.until(ExpectedConditions.alertIsPresent());
		String txt=driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		Assert.assertEquals(txt, "User is not valid");
	}
	
	@AfterMethod
	public void attachScreenshot(ITestResult result) throws Exception {
		String ssPath= "data:image/png;base64,"+((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
		System.out.println("Screenshot saved at = "+ssPath);
		Reporter.setCurrentTestResult(result);
		Reporter.log("SAMPLE REPORTER LOG");
		Reporter.log("Test: <a href='"+ssPath+"' target='_blank'>View Screenshot</a>");
		Reporter.log("<br><img src='" + ssPath + "' width='300' height='350'/><br>");
	}
	
	@DataProvider(name="invalidLogin")
	public String[][] loginDetails() throws Exception{
		/*
		//HardCodedData
		String[][] inv= new String[2][2];
		inv[0][0]="ABC";
		inv[0][1]="XYZ";
		inv[1][0]="invalid1";
		inv[1][1]="invalid1pass";
		*/
		//Get Data from excel
		ReadExcel excel=new ReadExcel();
		
		String[][] inv= excel.readExcel("LoginTest");
		return inv;
	}
	
}
