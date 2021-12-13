package dataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
	
	public Properties properties;
	
	public final String propertyFilePath = "E:\\New_Workspace\\CucumberSelenium\\src\\test\\resources\\configuration.properties";
	
	public ConfigFileReader() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			}catch( IOException e) {
				e.printStackTrace();
			}
			
		}catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration property file not found at " +propertyFilePath);
		}
	}
	
	public String getApplicationURL() {
		String url = properties.getProperty("URL");
		if(url != null)	return url;
		else throw new RuntimeException("URL is not found in the spectified property file");		
	}
	
	
	public long getImplicitWait() {
		String implicit = properties.getProperty("implicitwait");
		if(implicit != null)	return Long.parseLong(implicit);
		else throw new RuntimeException("ImplicitWait is not found in the spectified property file");		
	}
	
	
	public String getChromePath() {
		String chrome = properties.getProperty("chromepath");
		if(chrome != null)	return chrome;
		else throw new RuntimeException("Chrome exe file path is not found in the spectified property file");		
	}
	
	public String getFFPath() {
		String firefox = properties.getProperty("chromepath");
		if(firefox != null)	return firefox;
		else throw new RuntimeException("firefox exe file path is not found in the spectified property file");		
	}
	
	public String getExcelpath() {
		String excelpath = properties.getProperty("Excelpath");
		if(excelpath != null)	return excelpath;
		else throw new RuntimeException("Excel file path is not found in the spectified property file");		
	}
	
	
	
}
