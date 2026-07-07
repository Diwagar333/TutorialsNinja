package testCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AccountRegisterPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass{
		
	@Test(groups= {"Regression","Master"})
	void Home() {
		logger.info("***** Starting TC001_AccountRegistrationTest  ****");
		logger.debug("This is a debug log message");
try {
		HomePage obj = new HomePage(driver);
		obj.clickMyAccount();
		logger.info("Clicked on MyAccount Link.. ");
		obj.clickRegister();
		logger.info("Clicked on Register Link.. ");
		
		AccountRegisterPage regpage=new AccountRegisterPage(driver);
		logger.info("Providing customer details...");
		regpage.setFirstName(randomeString().toUpperCase());
		regpage.setLastName(randomeString().toUpperCase());
		regpage.setEmail(randomeString()+"@gmail.com");// randomly generated the email
		regpage.setTelephone(randomeNumber());
		String password=randomAlphaNumeric();
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		logger.info("Validating expected message..");
		String confmsg=regpage.getConfirmationMsg();
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		logger.info("Test passed");
		
		
}
catch (Exception e)
{
	logger.error("Test failed: " + e.getMessage());
	Assert.fail("Test failed: " + e.getMessage());
} 
finally 
{
logger.info("***** Finished TC001_AccountRegistrationTest *****");
}

	}
}
