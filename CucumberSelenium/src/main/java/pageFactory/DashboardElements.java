package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class DashboardElements {
	public static WebDriver driver;
 	
	 public DashboardElements(WebDriver driver) {
		 PageFactory.initElements(driver, this);
	 }
	 
	 @FindBy(how = How.XPATH, using="//*[@id=\"content\"]/div/div[1]/h1")
	 WebElement text_dashboard;
	 
	 public WebElement getText_dashboard() {
		return text_dashboard;
	 }
}
