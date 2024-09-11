package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageClass {
	

	//findout element 
	// intilize element using initElements method 
	// create a method for action perform on element 
	
	
	
	@FindBy(name="email") WebElement username;
	@FindBy(name="password") WebElement password;
	@FindBy(xpath="//div[text()='Login']") WebElement loginbutton;
	@FindBy(linkText="Forgot your password?") WebElement forgotpasswordlink;

	// To initialize the element we use initElements() method of PageFactory class. It takes two arguments
	
	public LoginPageClass(WebDriver driver) {                            
		
		PageFactory.initElements(driver, this);
		
	}
	
	public void setusername(String uname) {
		
		username.sendKeys(uname);
		
	}
		
	
	public void setpassword(String pass) {
		
		password.sendKeys(pass);
		
	}
	
	public void clickloginbutton() {
		loginbutton.click();
		
	}
	
	public void forgotpassword() {
		
		forgotpasswordlink.click();
	}
	
	
	
}
