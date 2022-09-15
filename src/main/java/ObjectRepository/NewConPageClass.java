package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericLibrary.WebDriverUtility;

public class NewConPageClass {
	
	public WebDriverUtility wUtil=new WebDriverUtility();
	
	@FindBy(name = "salutationtype")
	private WebElement fNameDD;
	
	@FindBy(name = "firstname")
	private WebElement fNameTF;
	
	@FindBy(name = "lastname")
	private WebElement lNameTF; 
	
	@FindBy(xpath = "//img[@src='themes/softed/images/select.gif']")  
	private WebElement addOrgNameButton;  
	
	@FindBy(xpath = "//input[@type='submit']")  
	private WebElement saveButton;
	
	public NewConPageClass(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getfNameDD() {
		return fNameDD;
	}

	public WebElement getfNameTF() {
		return fNameTF;
	}

	public WebElement getlNameTF() {
		return lNameTF;
	}

	public WebElement getAddOrgNameButton() {
		return addOrgNameButton;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	public void firstNameDD(String firstNameType) {
		wUtil.dDisMultiple(fNameDD);
		wUtil.getDDOptions(fNameDD);
		wUtil.selectElementByVisibletext(fNameDD, firstNameType);
	}
	
	public void fALName(String value1, String value2) {
		fNameTF.sendKeys(value1);
		lNameTF.sendKeys(value2);
	}
}
