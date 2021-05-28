package PFMClasses;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class LocatorValues {
	
 WebDriver driver;
 
 public LocatorValues(WebDriver driver) {
	 this.driver=driver;
	 PageFactory.initElements(driver,this);
 }

 
@FindBy(xpath="//*[@id=\"nav-link-accountList\"]")
public WebElement menuOption;


@FindBy(xpath="//*[@id=\"ap_email\"]")
public WebElement Username;

@FindBy(xpath="//*[@id=\"continue\"]")
public WebElement UsernameNext;

@FindBy(xpath="//*[@id=\"ap_password\"]")
public WebElement Password;


@FindBy(xpath="//*[@id=\"signInSubmit\"]")
public WebElement PasswordNext;

@FindBy(xpath="//*[@id=\"twotabsearchtextbox\"]")
public WebElement searchBox;


@FindBy(xpath="//*[@id=\"nav-search-submit-button\"]")
public WebElement searchButton;

@FindBy(xpath="//a//span[contains(text(),'Vandelay Infrared Thermometer')]")
public WebElement selectProduct;

@FindBy(xpath="//*[@id=\"add-to-cart-button\"]")
public WebElement addToCartButton;

@FindBy(xpath="//*[@id=\"nav-item-signout\"]/span")
public WebElement signOut;


@FindBy(xpath="//*[@id=\"nav-hamburger-menu\"]")
public WebElement hamburgMenu;

@FindBy(xpath="//div[@id='hmenu-content']//a[contains(text(),'Your Account')]")
public WebElement accountDetails;

@FindBy(xpath="//*[@id=\"a-page\"]/div[2]/div/div[2]/div[2]/a/div/div/div")
public WebElement loginAndSecurity;




}
