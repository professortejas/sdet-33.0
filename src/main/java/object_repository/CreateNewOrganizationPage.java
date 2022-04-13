package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewOrganizationPage {

//	Declaration
	@FindBy(name = "accountname")
	private WebElement organizationNameTF;
	
	@FindBy(css = "input[title='Save [Alt+S]']")
	private WebElement saveButton;

//	Initialization
	public CreateNewOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
//	Utilization
	public WebElement getOrganizationNameTF() {
		return organizationNameTF;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	public void createNewOrganization(String orgName) {
		organizationNameTF.sendKeys(orgName);
		saveButton.click();
	}
}
