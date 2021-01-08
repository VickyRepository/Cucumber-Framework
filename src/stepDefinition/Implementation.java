package stepDefinition;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.HomePage;
import pages.LoginPage;
import pages.OrderPage;

public class Implementation {

	public static WebDriver webDriver;
	public static Properties objectRepo;
	public LoginPage loginPage;
	public HomePage homePage;
	public OrderPage orderPage;

	@Given("^open the browser$")
	public void open_the_browser() throws FileNotFoundException, IOException {
				
		System.setProperty("webdriver.chrome.driver", "D:\\core java\\Drivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--Start-maximized");
		webDriver = new ChromeDriver(options);
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "//src//configuration//objectRepository.properties");
		objectRepo = new Properties();
		objectRepo.load(fis);
		
		loginPage = new LoginPage(webDriver);
		homePage = new HomePage(webDriver);
		orderPage = new OrderPage(webDriver);

		
	}

	@When("^navigates to the application$")
	public void navigates_to_the_application() {
		webDriver.get("http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx");
	}

	@When("^enter username$")
	public void enter_username() {

		WebElement userName = webDriver.findElement(By.cssSelector(objectRepo.getProperty("username")));
		userName.sendKeys("Tester");

	}

	@When("^enter username and password$")
	public void enter_username_and_password(DataTable data) throws Throwable {
		
		String usernameData = null;
		String passwordData = null;
		
/*		List<List<String>> string = data.raw();

			usernameData = string.get(0).get(0);
		    passwordData  = string.get(0).get(1);*/

		/*List<Map<String,String>> string = data.asMaps(String.class, String.class);
		
		usernameData = string.get(0).get("username");
	    passwordData  = string.get(0).get("password");*/
		
		for(Map<String,String> datas:data.asMaps(String.class, String.class) ) {
		
		usernameData = datas.get("username");
		passwordData = datas.get("password");
		
		/* webDriver.findElement(By.cssSelector(objectRepo.getProperty("username"))).clear();
		 webDriver.findElement(By.cssSelector(objectRepo.getProperty("username"))).sendKeys(usernameData);
	     webDriver.findElement(By.cssSelector(objectRepo.getProperty("password"))).sendKeys(passwordData);
	     webDriver.findElement(By.cssSelector(objectRepo.getProperty("loginButton"))).click();
 	*/
		
		loginPage.getUserName().sendKeys(usernameData);
		loginPage.getPassword().sendKeys(passwordData);
		loginPage.getLoginButton();
		
		}
	}
	
	@When("^enter password$")
	public void enter_password() {

		WebElement password = webDriver.findElement(By.cssSelector(objectRepo.getProperty("password")));
		password.sendKeys("test");
	}

	@When("^click login$")
	public void click_login() {

		WebElement loginButton = webDriver.findElement(By.cssSelector(objectRepo.getProperty("loginButton")));
		loginButton.click();
	}

	@Then("^verify login is successfull$")
	public void verify_login_is_successfull() {
		/*List<WebElement> logoutButton = webDriver.findElements(By.xpath(objectRepo.getProperty("logoutButton")));*/
		
		if (homePage.getLoginButton().size() != 0) {
			System.err.println("Successfully logged into the application");
		} else {
			System.err.println("Not successfully Landed into the application");
			Assert.assertTrue(false);
		}
	}

	@Given("^click on order page$")
	public void click_on_order_page() {
		/*WebElement orderLink = webDriver.findElement(By.xpath("//a[contains(text(), 'Order')]"));
		orderLink.click();*/
		homePage.getOrderLink();
	}

	@When("^select product$")
	public void select_product() {
		/*WebElement dropDownOptions = webDriver.findElement(By.cssSelector("[name$=ddlProduct]"));*/
		Select dropDown = new Select(orderPage.getProduct());
		dropDown.selectByVisibleText("FamilyAlbum");
	}

	@When("^enter the quantity$")
	public void enter_the_quantity() {
		/*WebElement quantityTextBox = webDriver.findElement(By.xpath("//input[contains(@id, 'txtQuantity')]"));
		quantityTextBox.clear();
		quantityTextBox.sendKeys("10");*/
		orderPage.getQuantity().clear();
		orderPage.getQuantity().sendKeys("10");
	}

	@When("^enter the discount$")
	public void enter_the_discount() {
	/*	WebElement discountTextBox = webDriver.findElement(By.xpath("//input[contains(@id, 'txtDiscount')]"));
		discountTextBox.clear();
		discountTextBox.sendKeys("10");*/
		orderPage.getDiscount().clear();
		orderPage.getDiscount().sendKeys("10");
	}

	@When("^navigates to the application \"([^\"]*)\"$")
	public void navigates_to_the_application(String url) {
		webDriver.get(url);
	}

	@When("^enter username \"([^\"]*)\"$")
	public void enter_username(String userNameData) {
		WebElement userName = webDriver.findElement(By.cssSelector(objectRepo.getProperty("username")));
		userName.sendKeys(userNameData);

	}

	@When("^enter password \"([^\"]*)\"$")
	public void enter_password(String passwordData) {
		WebElement password = webDriver.findElement(By.cssSelector(objectRepo.getProperty("password")));
		password.sendKeys(passwordData);

	}

	@After
	public void tearDown() {
		if (webDriver != null) {
			webDriver.close();
		}
	}

	@Given("^print tosca\\.$")
	public void print_tosca() {
		System.out.println("Tosca");
	}

	@Given("^print selenium\\.$")
	public void print_selenium() {
		System.out.println("Selenium");
	}

	@Given("^print perfecto\\.$")
	public void print_perfecto() {
		System.out.println("Perfecto");
	}

}
