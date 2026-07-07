package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegisterPage extends BasePage {
	
	public AccountRegisterPage(WebDriver driver)
	{
		super(driver);
	}

 
@FindBy(xpath="//input[@id='input-firstname']") 
WebElement txtFirstname;
 
@FindBy(xpath="//input[@id='input-lastname']") 
WebElement txtLasttname;
 
@FindBy(xpath="//input[@id='input-email']") 
WebElement txtEmail;
 
@FindBy(xpath="//input[@id='input-telephone']") 
WebElement txtTelephone;
 
@FindBy(xpath="//input[@id='input-password']") 
WebElement txtPassword;
 
@FindBy(xpath="//input[@id='input-confirm']") 
WebElement txtConfirmPassword;
 
@FindBy(xpath="//input[@name='agree']") 
WebElement chkdPolicy;
 
@FindBy(xpath="//input[@value='Continue']") 
WebElement btnContinue;
 
@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
WebElement msgConfirmation;
 
 
public void setFirstName(String fname) {
	txtFirstname.sendKeys(fname);
 
}
 
public void setLastName(String lname) {
	txtLasttname.sendKeys(lname);
 
}
 
public void setEmail(String email) {
	txtEmail.sendKeys(email);
 
}
 
public void setTelephone(String tel) {
	txtTelephone.sendKeys(tel);
 
}
 
public void setPassword(String pwd) {
	txtPassword.sendKeys(pwd);
 
}
 
public void setConfirmPassword(String pwd) {
	txtConfirmPassword.sendKeys(pwd);
 
}
 
public void setPrivacyPolicy() {
	chkdPolicy.click();
 
}

public void clickContinue() {
	btnContinue.click();
}
public String getConfirmationMsg() {
	try {
		return (msgConfirmation.getText());
	} catch (Exception e) {
		return (e.getMessage());
 
	}
	
}
}
	
	
/*
 * AccountRegisterPage(){
 * 
 * }
 * 
 * @FindBy(xpath="//input[@id='input-firstname']") WebElement FirstName;
 * 
 * @FindBy(xpath="//input[@id='input-lastname']") WebElement LastName;
 * 
 * @FindBy(xpath="//input[@id='input-email']") WebElement Email;
 * 
 * @FindBy(xpath="//input[@id='input-telephone']") WebElement Telephone;
 * 
 * @FindBy(xpath="//input[@id='input-password']") WebElement Password;
 * 
 * @FindBy(xpath="//input[@id='input-confirm']") WebElement ConfirmPassword;
 * 
 * public void FirstName(String FName) { FirstName.sendKeys(); } public void
 * LastName(String LName) { LastName.sendKeys(); } public void Email(String
 * Mail) { Email.sendKeys(); } public void Telephone(int Phone) {
 * 
 * } public void Password(String Pwd) {
 * 
 * } public void ConfirmPassword(String ConfirmPwd) {
 * 
 * }
 */	
