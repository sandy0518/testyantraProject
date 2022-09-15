package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadsPageClass {
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement newLeadButton;

	public LeadsPageClass(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public WebElement getNewLeadButton() {
		return newLeadButton;
	}
	
	public void clickPlusButton() {
		newLeadButton.click();
	}
}
