package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import data.file.TDDataFile;
import pages.TDLogInPage;

public class TDLogInTest {

	TDLogInPage loginPage = new TDLogInPage();
	TDDataFile dataFile = new TDDataFile();
	
	@BeforeMethod
	public void openTDPage() throws IOException {
		loginPage.openBrowser();
		loginPage.openTDLoginPage();
	}
	
	@AfterMethod
	public void closePage() {
		loginPage.closeBrowser();
	}
	
	@Test(priority=1)
	public void logIn() throws IOException, InterruptedException {
		dataFile.DataFetch();
		loginPage.logInWithUsernameAndPassword(dataFile.getUsername(),dataFile.getPassword());
		System.out.println(dataFile.getUsername() +" ------ "+ dataFile.getPassword());
		Assert.assertEquals(loginPage.globalError(), dataFile.getglobalError());
		
	}
	
	@Test(priority=2)
	public void emptyUserTest() throws IOException, InterruptedException {
		loginPage.logInWithUsernameAndPassword("",dataFile.getUsername());
		Assert.assertEquals(loginPage.emptyUsernamePage(), dataFile.getEmptyUserError());
	}
	
	@Test(priority=3)
	public void emptyPassTest() throws IOException, InterruptedException {
		loginPage.logInWithUsernameAndPassword(dataFile.getUsername(),"");
		Assert.assertEquals(loginPage.emptyPasswordPage(), dataFile.getEmptyPassError());
	}
	
}
