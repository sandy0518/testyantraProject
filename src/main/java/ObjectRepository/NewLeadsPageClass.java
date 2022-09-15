package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import GenericLibrary.WebDriverUtility;

public class NewLeadsPageClass {

	WebDriverUtility wUtil=new WebDriverUtility();

	@FindBy(name = "salutationtype")
	private WebElement fNDD;

	@FindBy(name = "firstname")
	private WebElement fNTF;

	@FindBys({@FindBy(name ="lastname"),@FindBy(xpath = "(//input[@type='text'])[4]")})   
	private WebElement lNTF;

	@FindAll({@FindBy(name = "company"),@FindBy(xpath = "(//input[@type='text'])[6]")})    
	private WebElement companyNTF;

	@FindBy(xpath = "(//input[@type='radio'])[2]")
	private WebElement assToRB;

	@FindBy(xpath = "(//select[@class='small'])[8]")
	private WebElement assToDD;
	
	@FindBy(xpath = "//input[@name='button']")
	private WebElement saveButton;

	public NewLeadsPageClass(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getfNDD() {
		return fNDD;
	}

	public WebElement getfNTF() {
		return fNTF;
	}

	public WebElement getlNTF() {
		return lNTF;
	}

	public WebElement getCompanyNTF() {
		return companyNTF;
	}

	public WebElement getAssToRB() {
		return assToRB;
	}

	public WebElement getAssToDD() {
		return assToDD;
	}

	public void fNameDD(String firstNameType) {
		wUtil.dDisMultiple(fNDD);
		wUtil.getDDOptions(fNDD);
		wUtil.selectElementByVisibletext(fNDD, firstNameType);
	}

	public void sendvaluetoTf(String fNvalue, String sNvalue, String ComNvalue) {
		fNTF.sendKeys(fNvalue);
		lNTF.sendKeys(sNvalue);
		companyNTF.sendKeys(ComNvalue);
	}
	public void assToDDown(String assignToType) {
		wUtil.dDisMultiple(assToDD);
		wUtil.getDDOptions(assToDD);
		wUtil.selectElementByVisibletext(assToDD, assignToType);
	}	
	
	public void saveButon() {
		saveButton.click();
	}
}
