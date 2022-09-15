package ObjectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import GenericLibrary.WebDriverUtility;

public class NewOrgPageClass {

	public WebDriverUtility wUtil=new WebDriverUtility();
	
	@FindBy(name = "accountname")
	private WebElement orgName;

	@FindBy(name = "industry")
	private WebElement indDD;

	@FindBy(xpath = "//input[@name='button']")
	private WebElement saveButton;

	public NewOrgPageClass(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrgName() {
		return orgName;
	}

	public WebElement getIndDD() {
		return indDD;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	//Bussiness Logic

	public void enterOrgDetails(String value) {
		orgName.sendKeys(value);   
	}

	public void industryDD(String industryType) {
		wUtil.dDisMultiple(indDD);
//		wUtil.getDDOptions(indDD);
		wUtil.selectElementByVisibletext(indDD, industryType);
	}

	public void saveButon() {
		saveButton.click();
	}
}
