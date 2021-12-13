package stepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import baseactions.WebMethods;

import dataProvider.ConfigFileReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageFactory.Admin_Elements;

public class Admin_Execution {
 static WebDriver driver;
	 
	 ConfigFileReader config = new ConfigFileReader();
	 WebMethods method = new WebMethods();
	 
	 public Admin_Execution() {
		 driver = Hooks.driver;
	 }
	 
	 @When("^Navigate to User Management$")
	 public void navigate_to_User_Management() throws Throwable {
		 Admin_Elements admin = new Admin_Elements(driver);
		 method.clickOn(admin.click_admin_menu());
	 }

	 @Then("^Verify Add user button$")
	 public void verify_Add_user_button() throws Throwable {
		 Admin_Elements admin = new Admin_Elements(driver);
		 method.isDisplayedorNot(admin.click_add_user());
		 System.out.println("Test Passed");
	 }

	 @When("^Navigate to Job title$")
	 public void navigate_to_Job_title() throws Throwable {
		 Actions action = new Actions(driver);
		 Admin_Elements admin = new Admin_Elements(driver);
		 action.moveToElement(admin.click_admin_menu());
		 action.moveToElement(admin.click_job_menu());
		 action.moveToElement(admin.click_jobtitle_menu()).click().perform();
	 }

	 @Then("^Verify job title page$")
	 public void verify_job_title_page() throws Throwable {
		 Admin_Elements admin = new Admin_Elements(driver);
		 method.isDisplayedorNot(admin.get_jobtitle_text());
		 System.out.println("Test Passed");
	 }
}
