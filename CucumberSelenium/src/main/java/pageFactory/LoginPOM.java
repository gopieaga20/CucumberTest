package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPOM {

	WebDriver driver;
	
	By username = By.id("txtUsername");
	By password = By.id("txtPassword");
	By submit = By.name("Submit");
	
	public LoginPOM(WebDriver driver) {
		this.driver=driver;
	}
	
	public void verifyusername() {
		driver.findElement(username).isDisplayed();
	}
	
	public void enterUsername(String uname)
	{
		driver.findElement(username).sendKeys(uname);
	}
	
	public void enterPassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}
	
	public void clickSubmit() {
		driver.findElement(submit).click();
	}
	
	
}
