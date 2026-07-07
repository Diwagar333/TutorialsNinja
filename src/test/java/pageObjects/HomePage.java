package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	@FindBy(xpath="//span[normalize-space()='My Account']") 
	WebElement lnkMyaccount;
 
	@FindBy(xpath="//a[normalize-space()='Register']") 
	WebElement lnkRegister;
	
	@FindBy(xpath="(//a[text()='Login'])[1]")
	WebElement lnkLogin;
 
 
public void clickMyAccount()
{
	lnkMyaccount.click();
}
 
public void clickRegister()
{
	lnkRegister.click();
}

public void clickLinkLogin() {
	lnkLogin.click();
}
	
/*
 * HomePage(){ WebDriver driver;
 * 
 * }
 * 
 * @FindBy(xpath="//span[text()='My Account']") WebElement MyAccount;
 * 
 * @FindBy(xpath="//a[text()='Register']") WebElement Register;
 * 
 * public void MyAccount() { MyAccount.click(); }
 * 
 * public void Register() { Register.click(); }
 */


}
