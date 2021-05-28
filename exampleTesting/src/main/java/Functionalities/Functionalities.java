package Functionalities;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import PFMClasses.LocatorValues;



public class Functionalities {
	
	
	WebDriver driver = new ChromeDriver();
	LocatorValues locator=new LocatorValues(driver);
	
	
	
	

	public void Initialize() {
		System.out.println("Launching the Chrome Browser");
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		System.out.println("Navigating to Amazon website");
		String baseUrl = "http://www.amazon.in/";
		driver.navigate().to(baseUrl);
		 driver.manage().window().maximize();
	}
	
	public void login() {
		Keywords excelFile=new Keywords();
		 excelFile.setInputFile("E:/KeywordDrivenCheck.xls");
	     try {
			excelFile.loginCredentials();
		} catch (IOException e) {
			System.out.println(e);
		}
	     locator.menuOption.click();
		if(locator.Username.isDisplayed()) {
		locator.Username.sendKeys(excelFile.id);
		locator.UsernameNext.click();
		}
		else {
		System.out.println("Not displayed username");
		}
		if (locator.Password.isDisplayed()) {
			System.out.println("Pasword field is displayed");
			locator.Password.sendKeys(excelFile.pwd);
			locator.PasswordNext.click();
		} else {
			System.out.println("Password field is not displayed");
		}
	}
	
	public void searchMobile() {
		Keywords excelFile=new Keywords();
		 excelFile.setInputFile("E:/KeywordDrivenCheck.xls");
	     try {
			excelFile.testData();
		} catch (IOException e) {
			System.out.println(e);
		}
	     
	     locator.searchBox.sendKeys(excelFile.phone);
	     locator.searchButton.click();
	    
        
	}
	
	public void buy(){
		String parentWindow = driver.getWindowHandle();
		locator.selectProduct.click();
		for(String childWindow:driver.getWindowHandles())
		if(!childWindow.equals(parentWindow))
		    driver.switchTo().window(childWindow);
		locator.addToCartButton.click();
		
	}
	
	public void logout() {
		Actions actions = new Actions(driver);
		 actions.moveToElement(locator.menuOption);
		 actions.moveToElement(locator.signOut);
		 actions.click().build().perform();
	}
	
	public void selectHamburgerMenu() {
		locator.hamburgMenu.click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		locator.accountDetails.click();
	}
	
	public void navigateToLoginAndSecurity() {
		locator.loginAndSecurity.click();
	}
	
	

	public static void main(String[] args) {
		Functionalities f = new Functionalities();
		//f.Initialize();
	}
}
