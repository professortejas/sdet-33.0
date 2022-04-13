package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInformationPage {

//	Declaration
	@FindBy(xpath = "//span[@id='dtlview_Organization Name']/..")
	private WebElement createdOrganizationTF;

//	Initialization
	public OrganizationInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
//	Utilization
	public WebElement getCreatedOrganizationTF() {
		return createdOrganizationTF;
	}
	
	
}
