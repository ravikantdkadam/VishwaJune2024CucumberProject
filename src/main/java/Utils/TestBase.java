package Utils;

import java.io.File; 
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import PageClasses.CreatenewContact;
import PageClasses.LoginPageClass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	public static Properties prop;
	public static WebDriver driver;
	public static LoginPageClass lp;
	public static 	CreatenewContact addcontact;
	
	 
		public TestBase()    {          // constructor of Base Class for reading the property file

			try {
				 	prop =new Properties();		// create empty property 	
				 
				 FileInputStream fis = new FileInputStream("D:\\New Workspace\\VishwaJune2024CucumberProject\\src\\main\\java\\Config\\Configuartion.properties");
				
				prop.load(fis);
				
			} 
			
			catch (IOException e) {
				e.getMessage();
			
			}
			
		}
			
			public static void initilizations() {
				
				String browsername=prop.getProperty("browser");// read browser property from properties file 
				
			
			
				if (browsername.equals("Chrome")) {
					
					WebDriverManager.chromedriver().setup();
					 driver = new ChromeDriver(); 
	 
				   
				}    
			     
			     else if (browsername.equals("FF")) {
			    	 
			    	 WebDriverManager.firefoxdriver().setup();

						 driver = new FirefoxDriver(); 
			 
			     }
			     else if (browsername.equals("MicrosoftEdge")) {
			    	 
			    	 WebDriverManager.edgedriver().setup();
			    	 driver= new EdgeDriver();
			    	 
			    	 
			     }
				

			    driver.manage().window().maximize();
				driver.manage().deleteAllCookies();

			   driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
			   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			   
			   driver.get(prop.getProperty("url"));
			   
				
				 
			     }
			
			
			public static void Takescreenshot() throws IOException {
				TakesScreenshot  ts= (TakesScreenshot) driver;
				File src = ts.getScreenshotAs(OutputType.FILE);
				File dest = new File ("D:\\C drive Data 26_06_23\\eclipse-workspace\\VishwaMarch24CucumberProject\\target\\Fail.png");
				FileUtils.copyFile(src, dest);
			
			}
			
			
		  
				
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
