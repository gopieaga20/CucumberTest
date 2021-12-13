package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Admin_Elements {
	public static WebDriver driver;
 	
	 public Admin_Elements(WebDriver driver) {
		 PageFactory.initElements(driver, this);
	 }
	 
	 @FindBy(how = How.ID, using="menu_admin_viewAdminModule")
	 private WebElement admin_menu;
	 
	 public WebElement click_admin_menu() {
		return admin_menu;
		 
	 }
	 
	 @FindBy(how = How.ID, using="btnAdd")
	 private WebElement btn_add;
	 
	 public WebElement click_add_user() {
		return btn_add;
		 
	 }
	 
	 @FindBy(how = How.ID, using="menu_admin_Job")
	 public WebElement job_menu;
	 
	 public WebElement click_job_menu() {
		return job_menu;
		 
	 }
	 
	 @FindBy(how = How.ID, using="menu_admin_viewJobTitleList")
	 private WebElement job_title;
	 
	 public WebElement click_jobtitle_menu() {
		return job_title;
		 
	 }
	 
	 @FindBy(how = How.XPATH, using="//*[@id=\"search-results\"]/div[1]/h1")
	 private WebElement job_title_text;
	 
	 public WebElement get_jobtitle_text() {
		return job_title_text;
		 
	 }
}
