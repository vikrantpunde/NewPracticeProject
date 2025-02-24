package BankTest.suites;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import BankTest.Utility.DriverInstance;
import BankTest.pages.HomePage;
import BankTest.pages.LoginPage;

public class HomeTest {
	WebDriver driver;
	WebDriverWait wait;
	HomePage hp;
	LoginPage lp;
	HomeTest(){
		DriverInstance driverInst= new DriverInstance();
		this.driver=driverInst.getDriver();
		hp=PageFactory.initElements(this.driver, HomePage.class);
		lp = PageFactory.initElements(this.driver, LoginPage.class);
		wait=new WebDriverWait(driver, Duration.ofMillis(10000));
	}
	
	@BeforeClass
	public void doLogin() {
		lp.doSuccessfulLogin();
	}
	
	@Test
	public void verifyOptions() {
		try {
			int len = hp.options.size();
			for(int i=0;i<len;i++) {
				System.out.println(hp.options.get(i).getText());
			}
		}catch(Exception e) {
			throw e;
		}
	}
	
	@Test
	public void selectAccountType() {
		wait.until(ExpectedConditions.visibilityOf(hp.newAccount));
		JavascriptExecutor js = (JavascriptExecutor) driver;		
		js.executeScript("arguments[0].click();", hp.newAccount);
		//hp.newAccount.click();
		wait.until(ExpectedConditions.visibilityOf(hp.accountTypeSel));
		Select sel = new Select(hp.accountTypeSel);
		sel.selectByVisibleText("current");
	}
	
	@AfterMethod
	public void attachScreenshot(ITestResult result) throws Exception {
		
		String ssPath= "data:image/png;base64,"+((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
		System.out.println("Screenshot saved at = "+ssPath);
		Reporter.setCurrentTestResult(result);
		Reporter.log("<br><img src='" + ssPath + "' width='300' height='350'/><br>");
	}
	
}
