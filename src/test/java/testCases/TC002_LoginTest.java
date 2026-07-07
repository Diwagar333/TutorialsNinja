package testCases;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass{
	
	@Test(groups= {"Sanity","Master"})
	public void login() throws InterruptedException {
		try {
		HomePage obj = new HomePage(driver);
		System.out.println(driver);
		logger.info("***** Starting TC002_LoginTest  ****");
		obj.clickMyAccount();
		logger.info("clickMyAccount Success");
		Thread.sleep(5000);
		obj.clickLinkLogin();
		logger.info("clickLinkLogin Success");
		
		LoginPage obj1 = new LoginPage(driver);
		//obj1.setLoginMailAddress(null);
		obj1.setLoginMailAddress(LoginEmail());
		logger.info("setLoginMailAddress Success");
		obj1.setLoginPassword(LoginPassword());
		logger.info("setLoginPassword Success");
		obj1.clickLoginButton();
		logger.info("clickLoginButton Success");
		
		
		MyAccountPage obj2 = new MyAccountPage(driver);
		boolean targetPage = obj2.isMyAccountPageExist();
		Assert.assertEquals(targetPage, true);
				}
		catch(Exception e) {
			Assert.fail();
			
		}
		logger.info("Testing Completed");
		
	}
	
}
