package datacreation;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;

import org.json.simple.JSONObject;

import com.github.javafaker.Faker;

public class DataGenerator {
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
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
		
		FileWriter file = new FileWriter("E:\\New_Workspace\\CucumberSelenium\\src\\test\\resources\\TestData.json");
        file.write(json.toJSONString());
        file.close();
		
		
	}

}
