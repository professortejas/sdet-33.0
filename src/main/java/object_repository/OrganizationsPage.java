package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {

//	Declaration
	@FindBy(css = "img[alt='Create Organization...']")
	private WebElement createOrganizationIcon;

//	Initialization
	public OrganizationsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
//	Utilization
	public WebElement getCreateOrganizationIcon() {
		return createOrganizationIcon;
	}
	
	
	
	public void clickOnCreateOrganizationIcon() {
		createOrganizationIcon.click();
	}
}
