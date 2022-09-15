package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageClass {
	
	@FindBy(linkText = "Organizations")
	private WebElement orgLink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement admImg;
	
	@FindBy(linkText = "Contacts")
	private WebElement conLink;
	
	@FindBy(linkText = "Leads")
	private WebElement leadLink;
	
	@FindBy(linkText = "Sign Out")
	private WebElement lOut;
	
	public HomePageClass(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrgLink() {
		return orgLink;
	}

	public WebElement getAdmImg() {
		return admImg;
	}

	public WebElement getConLink() {
		return conLink;
	}

	public WebElement getLeadLink() {
		return leadLink;
	}

	public WebElement getLogOut() {
		return lOut;
	}
	
	//Business Logic
	public void clickOrg() {
		orgLink.click();
	}
	
	public void logOut(WebDriver driver) {
		Actions action =new Actions(driver);
		action.moveToElement(admImg).perform();
		lOut.click();
	}
	
	public void clickContact() {
		conLink.click();
	}
}
