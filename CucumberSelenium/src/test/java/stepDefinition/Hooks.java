package stepDefinition;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.github.javafaker.Faker;

import baseactions.BaseClass;
import baseactions.WebMethods;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;


public class Hooks extends BaseClass{
	private Logger log = Logger.getLogger(Hooks.class);
	
	@Before
	public void LaunchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		log.info("Launching chrome browser");
		driver.manage().window().maximize();
	}
	
	@SuppressWarnings("unchecked")
	@Before
	public void dataGenerator() {
		Locale locale = new Locale("en-US");
		Faker faker = new Faker(locale);
		String firstname = faker.name().firstName();
		String lastname = faker.name().lastName();
		System.out.println(firstname);
		System.out.println(lastname);
		int number = faker.number().numberBetween(0,9999);
		System.out.println(number);
		String fullname = firstname+" "+lastname;
		System.out.println(fullname);
		
		JSONObject json = new JSONObject();
		json.put("fname", firstname);
		json.put("lname", lastname);
		
		FileWriter file;
		try {
			file = new FileWriter("E:\\New_Workspace\\CucumberSelenium\\src\\test\\resources\\TestData.json");
			file.write(json.toJSONString());
	        file.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}
	
	@After
	public void closeBrowser() {
		WebMethods.close();
		log.info("close the browser");
	}

}
