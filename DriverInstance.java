package BankTest.Utility;


import java.io.File;
import java.io.IOException;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

import com.google.common.io.Files;


public class DriverInstance {
	WebDriver driver;
	public WebDriver getExistingDriver() {
		return this.driver;
	}

	public WebDriver getDriver() {
		try {
			System.setProperty("webdriver.chrome.driver", "C:\\Temp\\chromedriver\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get("https://demo.guru99.com/V1/");
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			driver.manage().window().maximize();
			this.driver=driver;
			return driver;
		}catch(Exception e) {
			throw e;
		}
	}
	
	
}
