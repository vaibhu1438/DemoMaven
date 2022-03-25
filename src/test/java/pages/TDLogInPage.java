package pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TDLogInPage {
	
	WebDriver driver;
		
	@FindBy(name="psudoUsername")
	public WebElement username;
	
	@FindBy(name="password")
	public WebElement password;
	

	@FindBy(xpath="//button[@type='submit']")
	public WebElement logInButton;
	
	@FindBy(xpath="//span[@class='error-message ng-binding']")
	public WebElement globalErr;
	
	@FindBy(xpath="//div[contains(text(),'Please enter a valid password.')]")
	public WebElement passErr;
	
	@FindBy(xpath="//div[@class='ng-binding ng-scope']")
	public WebElement userErr;
	
	
	//Open Browser
	public void openBrowser() throws IOException {
		
	FileInputStream f = new FileInputStream("D:\\Testing\\tdProperties.properties");
	Properties prop = new Properties();
	prop.load(f);
	
	String browser = prop.getProperty("browser");
		if(browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "D:\\SeleniumJars\\geckodriver.exe");
			driver = new FirefoxDriver();
		}else if(browser.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\SeleniumJars\\chromedriver.exe");
			driver = new ChromeDriver();
		}else {
			System.out.println("Please Enter proper browser property");
		}
		PageFactory.initElements(driver, this); 
	}
	
	//Open TD Bank Login Page
	public void openTDLoginPage() {
		driver.get("https://onlinebanking.tdbank.com/#/authentication/login");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	//Close browser
	public void closeBrowser() {
		driver.close();
	}
	
	//Enter username-password and click
	public void logInWithUsernameAndPassword(String user, String pass) throws IOException, InterruptedException {
		username.sendKeys(user);
		
		password.sendKeys(pass);
		Thread.sleep(4000);	
		logInButton.click();
					
	}
	//globalError
	public String globalError() {
		String actErr = globalErr.getText();
		System.out.println(actErr);
		return actErr;
	}
	//emptyUsernameError
	public String emptyUsernamePage() {
		String emptyUserErr = userErr.getText();
		return emptyUserErr;
		
	}
	//emptyPasswordError 
	public String emptyPasswordPage() {
		String emptyPassErr = passErr.getText();
		return emptyPassErr;
		
	}

}
