package generic_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import object_repository.HomePage;
import object_repository.LoginPage;

public class BaseClass {

	public WebDriver driver;
	public HomePage hp;
	
	@BeforeSuite
	public void openDatabase() throws Throwable {
		PropertiesUtility.initializeProperty(ConstantPath.PROPERTYFILEPATH);
		ExcelUtility.openExcel(ConstantPath.EXCELFILEPATH);
		DatabaseUtility.getMySqlDatabaseConnection(ConstantPath.DBURL, PropertiesUtility.fetchValue("dbUsername"), PropertiesUtility.fetchValue("dbPassword"));
	}
	
	@BeforeClass
	public void launchTheBrowser() {
		String timeout = PropertiesUtility.fetchValue("timeout");
		long timeouts = JavaUtility.convertStringToLong(timeout);
		String browser=PropertiesUtility.fetchValue("browser");
		
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		} else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}else {
			System.out.println("Specify the browser properly");
		}
		
		WebDriverUtility.maximizeWindow(driver);
		WebDriverUtility.waitImplicitly(driver, timeouts);
		WebDriverUtility.navigateToApplication(driver, PropertiesUtility.fetchValue("url"));
	}
	
	@BeforeMethod
	public void loginToTheApplication() {
		LoginPage lp=new LoginPage(driver);
		lp.loginToApplication(PropertiesUtility.fetchValue("username"), PropertiesUtility.fetchValue("password"));
		hp=new HomePage(driver);
	}
	
	@AfterMethod
	public void signout() {
		hp.signout(driver);
	}
	
	@AfterClass
	public void closeTheBrowser() {
		WebDriverUtility.closeTheBrowser(driver);
	}
	
	@AfterSuite
	public void databaseConnection() throws Throwable {
		DatabaseUtility.closeTheDatabase();
		ExcelUtility.closeExcel();
	}
}
