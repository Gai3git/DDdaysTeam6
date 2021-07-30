package com.DollarDays.pageObjects;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.DollarDays.utilities.ElementUtils;

public class HomePage 																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																														
{

	public WebDriver driver;
	ElementUtils elementUtils ;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);  //(argument driver,this)
		elementUtils = new ElementUtils(driver);
		
	}			
		
	//Signin Icon
	@FindBy(xpath="//span[text()='Sign in']")
	private WebElement wbIconSignin;	
	
	//List of links in UserAccountName/Signin Dropdown 
	@FindBy(xpath="//ul[@class='dropdown-menu logMenu']/li") 
	private List <WebElement> wbSigninUserDDlist;
	
	//List of Signin Dropdown links
	@FindBy(xpath="//ul[@class='dropdown-menu logMenu']/li/a") 
	private List <WebElement> wbSigninUserDDlinks;
	
	//SignIn Link in Signin Dropdown
	@FindBy(linkText="Sign In")
	private WebElement wbSignInLink;
	
	//CreateAccount Link in Signin Dropdown
	@FindBy(linkText="Create account")
	private WebElement wbCreateAccLink;
	
	//Help Link in Signin Dropdown
	@FindBy(linkText="Help")
	private WebElement wbHelpLink;
	
	//UserAccountName
	@FindBy(xpath="//*[@id='aspnetForm']/header/div[2]/div/div/div[3]/div/ul/li[1]/a/span")
	private WebElement wbAccountNameIcon;	
	
	//Accounts Link in UserAccountName Dropdown
	@FindBy(linkText="Accounts")
	private WebElement wbAccountsLink;
	
	//Order History Link in UserAccountName Dropdown
	@FindBy(linkText="Order History")
	WebElement wbOrderHistoryLink;
	
	//My Wishlist Link in UserAccountName Dropdown
	@FindBy(linkText="My Wishlist")
	private WebElement wbWishlistLink;
	
	//Favorites Link in UserAccountName Dropdown
	@FindBy(linkText="Favorites")
	private WebElement wbFavoritesLink;
	
	//Update Profile Link in UserAccountName Dropdown
	@FindBy(linkText="Update Profile")
	private WebElement wbUpdateProfileLink;
	
	//Address Book Link in UserAccountName Dropdown
	@FindBy(linkText="Address Book")
	private WebElement wbAddressBookLink;
	
	//Wallet Link in UserAccountName Dropdown
	@FindBy(linkText="Wallet")
	private WebElement wbWalletLink;
	
	//Tax Exempt Link in UserAccountName Dropdown
	@FindBy(linkText="Tax Exempt")
	private WebElement wbTaxExemptLink;
	
	//Request a Quote Link in UserAccountName Dropdown
	@FindBy(linkText="Request a Quote")
	private WebElement wbRequestQuoteLink;
	
	//Contact Us Link in UserAccountName Dropdown
	@FindBy(linkText="Contact Us")
	private WebElement wbContactUsLink;
		
	//Sign Out Link in UserAccountName Dropdown
	@FindBy(linkText="Sign Out")
	private WebElement wbSignOutLink;
	
	//Get the title of page
	public String getHomePageTitle()
	{
		return elementUtils.getWebPageTitle();
	}	
	
	//Get the current url of page
	public String getHomePageUrl()
	{
		return elementUtils.getWebPageUrl();
	}	

	//Get text of Signin Icon
	public String getTextIconSignin()
	{
		return elementUtils.getElementText(wbIconSignin);    //return wbIconSignin.getText()
	}	
	
	//click Sign in icon
	public void clickIconSignin()
	{
     	elementUtils.performElementClick(wbIconSignin);     //wbIconSignin.click();
	}		
	
	//click SignIn link option
	public void clickSignInLink()
	{
     	elementUtils.performElementClick(wbSignInLink);
	}		
	
	//click create account link option
	public void clickCreateAccLink()
	{
     	elementUtils.performElementClick(wbCreateAccLink);
	}	
	
	//click Help link option
	public void clickHelpLink()
	{
     	elementUtils.performElementClick(wbHelpLink);
	}	
	
	//Get text of user name icon 
	public String getTextAccountNameIcon()
	{
		return elementUtils.getElementText(wbAccountNameIcon); //return wbAccountNameIcon.getText()
	}	
	
	//click username Icon
	public void clickAccountNameIcon()
	{
     	elementUtils.performElementClick(wbAccountNameIcon);
	}	
	
	//click Accounts link option from userdropdown list
	public void clickAccountsLink()
	{
     	elementUtils.performElementClick(wbAccountsLink);
	}	
	
	//click Order History link option from userdropdown list
	public void clickOrderHistoryLink()
	{
     	elementUtils.performElementClick(wbOrderHistoryLink);
	}	
	
	//click WishList link option from userdropdown list
	public void clickWishlistLink()
	{
     	elementUtils.performElementClick(wbWishlistLink);
	}	
	
	//click Favorites link option from userdropdown list
	public void clickFavoritesLink()
	{
     	elementUtils.performElementClick(wbFavoritesLink);
	}	
	
	//click Update Profile link option from userdropdown list
	public void clickUpdateProfileLink()
	{
     	elementUtils.performElementClick(wbUpdateProfileLink);
	}	
	
	//click AddressBook link option from userdropdown list
	public void clickAddressBookLink()
	{
     	elementUtils.performElementClick(wbAddressBookLink);
	}	
	
	//click Wallet link option from userdropdown list
	public void clickWalletLink()
	{
     	elementUtils.performElementClick(wbWalletLink);
	}	
	
	//click Tax Exempt link option from userdropdown list
	public void clickTaxExemptLink()
	{
     	elementUtils.performElementClick(wbTaxExemptLink);
	}	
	
	//click Request a Quote link option from userdropdown list
	public void clickRequestQuoteLink()
	{
     	elementUtils.performElementClick(wbRequestQuoteLink);
	}	
	
	//click Contact us  link option from userdropdown list
	public void clickContactUsLink()
	{
     	elementUtils.performElementClick(wbContactUsLink);
	}	
	
	//click Sign Out link option from userdropdown list
	public void clickSignOutLink()
	{
     	elementUtils.performElementClick(wbSignOutLink);
	}	
	
	//Get list of values from the Sign in  or the User Dropdown list based on the user being logged in or not
	public List<String> getSignInUserDropDownList()
	{

		return elementUtils.getListofText(wbSigninUserDDlist);
	}
	
	//Get the list of links displayed in the Sign in  or the User Dropdown list based on the user being logged in or not
	public List<String> getSignInUserDropDownLinksList()
	{
		return elementUtils.getListofText(wbSigninUserDDlinks);
		
	}	
	
	//Get in String Array format ,the list of links  displayed in the Sign in  or the User Dropdown list based on the user being logged in or not
	public String[] getSignInUserDropDownLinksArray()
	{
		return elementUtils.getArrayofText(wbSigninUserDDlinks);
	}
	
	
	//Selecting the SignOut option from user dropdown list to log out of Web application
	public void signOutOfDD()
	{
		clickAccountNameIcon();
		clickSignOutLink();
		
	}		
	
	//Selecting Sign in option in Signin dropdown list to navigate to login page
	public void goToLoginPage()
	{
		clickAccountNameIcon();
		clickSignInLink();
	}	
	
	
//	//CloseBarPopup
//	@FindBy(xpath="//*[@id='aspnetForm']/header/div[1]/h5")
//	private WebElement wbCloseBarPopup;
	
	//Action on Webelements	
//	public void clickCloseBarPopup()
//	{
//		elementUtils.performElementClick(wbCloseBarPopup);  
//	}	
	
	
}
