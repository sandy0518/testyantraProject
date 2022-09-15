package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageClass {
	@FindBy(name="user_name")
	private WebElement usNameTF;
	
	@FindBy(name="user_password")
	private WebElement pwdTF;
	
	@FindBy(id="submitButton")
	private WebElement loginButton;

	public LoginPageClass(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getUserName() {
		return usNameTF;
	}

	public WebElement getPassword() {
		return pwdTF;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	
//	Rule-5 Create business logic method
	/** 
	 * @author saisandeep
	 * @param name
	 * @param Password
	 */
	public void login(String username, String password) {
		usNameTF.sendKeys(username);
		pwdTF.sendKeys(password);
		loginButton.click();
		
	}
}
