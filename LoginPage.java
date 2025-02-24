package BankTest.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.*;

public class LoginPage {
	WebDriver driver;
	WebDriverWait wait;
	HomePage hp;
public @FindBy(name="uid") WebElement username;
public @FindBy(name="password") WebElement password;
public @FindBy(xpath="//input[@type='submit']") WebElement submitBtn;
public @FindBy(xpath="//input[@type='reset']") WebElement resetBtn;
public @FindBy(xpath="//tr/td[1]") List<WebElement> labels;



public LoginPage(WebDriver driver){
	this.driver=driver;
	PageFactory.initElements(driver, this);
	this.wait = new WebDriverWait(driver, Duration.ofMillis(10000));
	hp=PageFactory.initElements(this.driver, HomePage.class);
}

public void doSuccessfulLogin() {
	try {
		wait.until(ExpectedConditions.visibilityOf(password));
		this.username.sendKeys("mngr610496");
		this.password.sendKeys("tUtenUh");
		this.submitBtn.click();
		System.out.println(hp.header.getText());
		wait.until(ExpectedConditions.textToBePresentInElement(hp.header, "Gtpl Bank"));
	}catch(Exception e){
		throw e;
	}
}

}
