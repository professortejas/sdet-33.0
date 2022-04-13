package generic_repository;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverUtility {

	static WebDriver driver=null;
	public static WebDriver launchBrowser(WebDriver driver, String browser) {
		
		if (browser.equalsIgnoreCase("chrome")) {
			ChromeOptions options=new ChromeOptions();
			options.addArguments("--disable-notifications");
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver(options);
		} else if(browser.equalsIgnoreCase("firefox")){
			WebDriverManager.chromedriver().setup();
			driver=new FirefoxDriver();
		}else {
			WebDriverManager.chromedriver().setup();
			driver=new EdgeDriver();
		}
		return driver;
	}
	
	public static void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	public static void waitImplicitly(WebDriver driver,long timeouts) {
		driver.manage().timeouts().implicitlyWait(timeouts, TimeUnit.SECONDS);
	}
	
	public static void waitUntilUrlContains(WebDriver driver, long timeouts, String urlFraction){
		WebDriverWait wait=new WebDriverWait(driver, timeouts);
		wait.until(ExpectedConditions.urlContains(urlFraction));
	}
	
	public static void waitUntilElementIsVisible(WebDriver driver, long timeouts, WebElement ele){
		WebDriverWait wait=new WebDriverWait(driver, timeouts);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public static void navigateToApplication(WebDriver driver, String url) {
		driver.get(url);
	}
	
	public static void switchToTargetWindow(WebDriver driver) {
		Set<String> allWindowIds = driver.getWindowHandles();
		for (String wid : allWindowIds) {
			driver.switchTo().window(wid);
		}
	}
	
	public static void switchToWindow(WebDriver driver, String wid) {
		driver.switchTo().window(null);
	}
	
	public static void selectOptionByVisibleText(WebElement ele, String text) {
		Select select=new Select(ele);
		select.selectByVisibleText(text);
	}
	
	public static String getWindowId(WebDriver driver) {
		String wid=driver.getWindowHandle();
		return wid;
	}
	
	public static void moveToElement(WebDriver driver, WebElement ele) {
		Actions actions=new Actions(driver);
		actions.moveToElement(ele).perform();;
	}
	
	public static void closeTheBrowser(WebDriver driver) {
		driver.close();
	}
}
