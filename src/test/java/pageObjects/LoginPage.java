package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtMailAddress;
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtPassword;
	@FindBy(xpath="//input[@class='btn btn-primary']")
	WebElement btnLogin;
	
	public void setLoginMailAddress(String LMailID) {
		txtMailAddress.sendKeys(LMailID);
	}
	public void setLoginPassword(String LPassword) {
		txtPassword.sendKeys(LPassword);
	}
	public void clickLoginButton() {
		btnLogin.click();
	}
	
}
