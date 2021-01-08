package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage {
	
	WebDriver driver;
	
	@FindBy(css = "[name$=ddlProduct]")
	WebElement product;

	@FindBy(xpath="//input[contains(@id, 'txtQuantity')]")
	WebElement quantity;
	
	@FindBy(xpath="//input[contains(@id, 'txtDiscount')]")
	WebElement discount;

	public OrderPage(WebDriver webDriver) {
		this.driver = webDriver;
		PageFactory.initElements(driver, this);
	}
	
	
	public WebElement getDiscount() {
		return discount;
	}

	public WebElement getProduct() {
		return product;
	}

	public WebElement getQuantity() {
		return quantity;
	}
	
}
