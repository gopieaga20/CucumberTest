package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginElements {
	 	public static WebDriver driver;
	 	
	 public LoginElements(WebDriver driver) {
		 PageFactory.initElements(driver, this);
	 }

	@FindBy(how = How.ID, using="txtUsername") public WebElement username;
	
	public WebElement enter_username() {
		return username;
	}
	
	@FindBy(how = How.ID, using="txtPassword") public WebElement password;
	
	public WebElement enter_password() {
		return password;
		
	}
	
	@FindBy(how= How.NAME, using="Submit") public WebElement submit;
	
	public WebElement click_login() {
		return submit;
		
	}
	
	@FindBy(how= How.XPATH, using="//*[@id=\"spanMessage\"]") WebElement invalid_message;
	
	public WebElement get_invalidmsg() {
		return invalid_message;
		
	}
}
