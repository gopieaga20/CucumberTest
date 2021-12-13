package stepDefinition;

import java.util.List;

import org.openqa.selenium.WebDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testcases.Login_cases;

public class Login_Execution {
	static WebDriver driver;
	
	 public Login_Execution() {
		 driver = Hooks.driver;
	 }
	
	@Given("^User launch the URL$")
	public void user_launch_the_URL() throws Throwable {
	  Login_cases login = new Login_cases();
	  login.url_launch();
	  
	}

	@When("^User enter credentials1$")
	public void user_enter_credentials1() throws Exception {
		  Login_cases login = new Login_cases();
		  login.pass_credentials_using_excel();
		}
	
	@When("^User enter credentials$")
	public void user_enter_credentials(DataTable data) throws Throwable {
		Login_cases login = new Login_cases();
	    List<List<String>> value = data.asLists();
	    login.pass_credentials_using_datatable(value);
	}
	
	@When("^User enter credentials \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enter_credentials_and(String uname, String pwd) throws Throwable {
		  Login_cases login = new Login_cases();
		  login.pass_credentials_using_outline(uname, pwd);
	}

	@When("^User login$")
	public void user_login() throws Throwable {
		  Login_cases login = new Login_cases();
		  login.click_login();
	}

	@Then("^Validate the user login$")
	public void validate_the_user_login() throws Throwable {
		  Login_cases login = new Login_cases();
		  login.validate_login();		
	}

}
