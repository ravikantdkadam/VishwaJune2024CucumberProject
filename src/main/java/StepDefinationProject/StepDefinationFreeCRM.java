package StepDefinationProject;


import java.util.List;  

import org.junit.Assert; 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import PageClasses.CreatenewContact;
import PageClasses.LoginPageClass;

import Utils.TestBase;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefinationFreeCRM extends TestBase{
	



@Given("Launch the browser and open url")
public void launch_the_browser_and_open_url() {
	
	 
	
     // loginpage class initiation
	
	
	TestBase.initilizations();     // launch the browser and open the url 

System.out.println("Launch the browser");

 lp =new LoginPageClass(driver);
	
    
}

@Then("user is on login page")
public void user_is_on_login_page() throws InterruptedException {
	
	
String Title= driver.getTitle();

Assert.assertEquals("Cogmento CRM", Title);


	Thread.sleep(2000);
		 
	 }


@When("user enter the username {string} and password {string}")
public void user_enter_the_username_and_password(String un, String pass) {
	
	lp.setusername(un);
	lp.setpassword(pass);
    
}

@When("Click on login button")
public void click_on_login_button() {
	
	lp.clickloginbutton();
		
    
}

@Then("user should on the homepage")
public void user_should_on_the_homepage() {
	
	
	WebElement user= driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/div[2]/span[1]"));
	
	boolean b= user.isDisplayed();
	
	Assert.assertTrue(b);
	
	System.out.println("User logged in successfully");
	
	
	
}

// create contact page 



@When("user move and click on the contact tab")
public void user_move_and_click_on_the_contact_tab() {
	
	 addcontact= new CreatenewContact(driver);
	 
	 
	 addcontact.clickonContact();
	 

		System.out.println("user clicked on contact tab");
    
}

@Then("user is on contact page")
public void user_is_on_contact_page() {
	
addcontact.conatctText();

Assert.assertTrue(true);


System.out.println("user is on contact page ");
	
	
    
}

@Then("Click on Create button")
public void click_on_create_button() {
	
	
	addcontact.CreateConatct();
    
}

@Then("Enter the following details and click on save Button")
public void enter_the_following_details_and_click_on_save_button(DataTable contactdata) {

	List<List<String>> contactdetails= contactdata.cells();
	
addcontact.enterConatctDetails(contactdetails.get(0).get(0), contactdetails.get(0).get(1), contactdetails.get(0).get(2), contactdetails.get(0).get(3));
	
addcontact.saveConatct();
	

}
	
	
	
    
}









	

	
	
	
	
	
	
	
	

