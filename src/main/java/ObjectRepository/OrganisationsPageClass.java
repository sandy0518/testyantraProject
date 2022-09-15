package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationsPageClass {
	
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement plusButton;
	
	public OrganisationsPageClass(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getPlusButton() {
		return plusButton;
	}
	
	//Bussiness Logic
	public void clickPlusB() {
		plusButton.click();
	}
}
