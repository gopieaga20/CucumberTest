package baseactions;

import java.util.List;

import org.openqa.selenium.WebElement;

public class WebMethods extends BaseClass {
	
	public void clickOn(WebElement element){
		element.click();
	}
	
	public static void close() {
		driver.close();
	}
	
	public void closeAll() {
		driver.quit();
	}
	
	public void clear(WebElement element) {
		element.clear();
	}
	
	public void enterthevalue(WebElement element, String textToType) {
		element.sendKeys(textToType);
	}
	
	
	public boolean isDisplayedorNot(WebElement element) {
		return element.isDisplayed();
		
		
	}
	
	public boolean isEnabledorNot(WebElement element) {
		if(element.isEnabled()) {
			return true;
		}else {
			return false;
		}
		
	}
	
	public boolean isSelectedorNot(WebElement element) {
		if(element.isSelected()) {
			return true;
		}else {
			return false;
		}
		
	}
	
	public String getTextFrom(WebElement element) {
		String text = element.getText();
		return text;
		
	}



}
