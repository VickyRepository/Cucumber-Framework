package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;
	
	@FindBy(xpath = "//a[contains(text(), 'Logout')]")
	List<WebElement> loginButton;
	
	@FindBy(xpath = "//a[contains(text(), 'View all orders')]")
	WebElement orderLink;
	
	public List<WebElement> getLoginButton() {
		return loginButton;
	}

	public void getOrderLink() {
		orderLink.click();
	}

	
	public HomePage(WebDriver webDriver) {
		this.driver = webDriver;
		PageFactory.initElements(driver, this);
	}
}
