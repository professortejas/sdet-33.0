package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_repository.WebDriverUtility;

public class HomePage {

//	Declaration
	@FindBy(linkText = "Contacts")
	private WebElement contactsLink;
	
	@FindBy(linkText = "Organizations")
	private WebElement organizationsLink;
	
	@FindBy(css = "img[src='themes/softed/images/user.PNG']")
	private WebElement userIcon;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signOutLink;
	
//	Initialization
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
//	Utilization
	
	public void clickOnOrganizationsLink() {
		organizationsLink.click();
	}
	
	public void signout(WebDriver driver) {
		WebDriverUtility.moveToElement(driver, userIcon);
		signOutLink.click();
	}
}
