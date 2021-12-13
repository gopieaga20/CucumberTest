package testcases;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import baseactions.BaseClass;
import baseactions.WebMethods;
import dataProvider.ConfigFileReader;
import dataProvider.ReadExcel;
import io.cucumber.datatable.DataTable;
import pageFactory.DashboardElements;
import pageFactory.LoginElements;

public class Login_cases extends BaseClass {
	private static Logger log = Logger.getLogger(Login_cases.class);

	ConfigFileReader config = new ConfigFileReader();
	WebMethods method = new WebMethods();
	ReadExcel ex = new ReadExcel(config.getExcelpath(), 0);
	JSONParser parser = new JSONParser();
	
	public void url_launch() {
		 driver.get(config.getApplicationURL());
		 LoginElements login = new LoginElements(driver);
		 method.isDisplayedorNot(login.username);
		 log.info("Application URl is loaded");
	}
	
	public void pass_credentials_using_excel() throws Exception {
		LoginElements login = new LoginElements(driver);
		Map<String, Map<String,String>>  excelData = ex.getExcelasMap();
		method.enterthevalue(login.enter_username(), excelData.get("1").get("Username"));
		log.info("Passed the value of username");
		method.enterthevalue(login.enter_password(), excelData.get("1").get("Password"));	
		log.info("Passed the value of password");
		Object obj = parser.parse(new FileReader("E:\\New_Workspace\\CucumberSelenium\\src\\test\\resources\\TestData.json"));
	    JSONObject data = (JSONObject)obj;
	    String fname = (String)data.get("fname");
	    String lname = (String)data.get("lname");
	    System.out.println(fname);
	    System.out.println(lname);
		
	}
	
	public void pass_credentials_using_datatable(List<List<String>> value) {
		LoginElements login = new LoginElements(driver);
		method.enterthevalue(login.enter_username(), value.get(0).get(0));
		log.info("Passed the value of username");
		method.enterthevalue(login.enter_password(), value.get(0).get(1));
		log.info("Passed the value of password");
	}
	
	public void pass_credentials_using_outline(String uname, String pwd ) {
		LoginElements login = new LoginElements(driver);
		method.enterthevalue(login.enter_username(), uname);
		log.info("Passed the value of username");
		method.enterthevalue(login.enter_password(), pwd);
		log.info("Passed the value of password");
	}
	
	public void click_login()	{
		LoginElements login = new LoginElements(driver);
		method.clickOn(login.click_login());
		log.info("login button is clicked");
	}
	
	public void validate_login() {
		DashboardElements dash = new DashboardElements(driver);
		if(dash.getText_dashboard().isDisplayed()) {
			String expected = "Dashboard";
			String actual = method.getTextFrom(dash.getText_dashboard());
			Assert.assertEquals(actual, expected);
			System.out.println("Test Passed");
			log.info("User logged in successfully");
		} else {
			System.out.println("Test Failed");
			log.info("Test case failed");
		}
	}
	
}
