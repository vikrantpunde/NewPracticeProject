package BankTest.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

	
	public @FindBy(css="ul.menusubnav li a") List<WebElement> options;
	public @FindBy(xpath="//div/h2") WebElement header;
	public @FindBy(xpath="//a[@href='addAccount.php']") WebElement newAccount;
	public @FindBy(name="selaccount") WebElement accountTypeSel;
	
}
