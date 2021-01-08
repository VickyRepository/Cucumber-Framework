package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	@FindBy(css= "[id$=username]")
	WebElement userName;
	
	@FindBy(css = "[id$=password]")
	WebElement password;

	@FindBy(css = "[id$=button]")
	WebElement loginButton;
	
	public LoginPage(WebDriver WebDriver) {
		this.driver = WebDriver;
		PageFactory.initElements(driver, this);
		
	}	
	
	public WebElement getUserName() {
		return userName;
	}

	public WebElement getPassword() {
		return password;
	}

	public void getLoginButton() {
		 loginButton.click();
	}
}
