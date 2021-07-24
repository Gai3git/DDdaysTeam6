package com.DollarDays.testCases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.DollarDays.pageObjects.HomePage;
import com.DollarDays.utilities.BaseClass;
import com.DollarDays.utilities.ConstantsUtils;
import com.DollarDays.utilities.XLUtils;



public class HomePageTest extends BaseClass
{
	public WebDriver driver;
	public static Logger logger =LogManager.getLogger("DollarDays"); 
	HomePage hp;
	
	@BeforeClass
	public void initialize() throws IOException
	{
		driver =initializeDriver();
		hp= new HomePage(driver);
	}
	@AfterClass
	public void teardown()
	{
			driver.close();
			logger.info("WebPage is closed.");
			System.out.println("WebPage is closed.");
	}
	
	@Test(priority=0, description="This testcase verifies the HomePage Title is correct.")
	public void TC_VerifyHomePageTitle()
	{   
		String actualTitle  = hp.getHomePageTitle();
		Assert.assertEquals(actualTitle, ConstantsUtils.HOMEPAGETITLE,"HomePage Title Verification failed.");
		logger.info("Verified HomePage Title successfully.");
	}
	
	@Test(priority=1, description="This testcase verifies the Sign in Dropdown list displays expected values.")
	public void TC_verifySignInDropDownList() throws IOException
	{
	    //HomePage hp = new HomePage(driver);
	 	logger.debug("Clicking  SigninIcon to view and fetch the DropDown List. ");
		hp.clickIconSignin(); 
		List<String> actList= hp.getSignInUserDropDownList();			
//		logger.debug("Clicking  SigninIcon to hide the DropDown List. ");
//	    hp.clickIconSignin();		
		
	    //Option1-Fetching expected value of Sign in DropDown List from Excel
	    logger.debug("Fetching Expected Values for Signin dropdown list from Excel File.");
	    String xlFileName="Data.xlsx";
	    String strDataXlsArr[]=XLUtils.getColumnData(xlFileName, "Sheet1", 0);
	    //Converting array to Arraylist using addAll method in Collections
	    List <String> expList = new ArrayList<String>();
		Collections.addAll(expList, strDataXlsArr);

	    
		//Option2 -Fetching Expected values for Signin DropDown list from Properties  file
//		logger.info("Fetching Expected Values for Signin dropdown list from Properties File");
//	    ReadProperties readProp= new ReadProperties();
//	    String  strDataSignInDDList1 = readProp.getPropValue("SignInDDList");
//		System.out.println(strDataSignInDDList1);
	   
		//Option3 -Fetching Expected values for Signin DropDown list from Constants  file
//		logger.info("Fetching Expected Values for Signin dropdown list from ConstantsUtils File");
//	    String  strDataSignInDDList = ConstantsUtils.SIGNINDDLIST;
//	    System.out.println(strDataSignInDDList);
		
		//Convert comma separated String to Array and then to a List
//	    List<String> explist=Arrays.asList(strDataSignInDDList.split(","));
		
		Assert.assertEquals(actList, expList,"Verification of  Sign in DropDown List failed. ");
	    logger.info("Verified Signin Dropdown List successfully.");
	}
	 	
 	
	@Test(dataProvider="getSigninlinks" , priority=2, description="This testcase verifies the the navigation of links displayed in Sign in Dropdown list .")
	public void TC_verifySigninDropDownUrl(String linkText) throws InterruptedException
	{ 	
		navigateToHomePage();	
		//HomePage hp = new HomePage(driver);
		driver.manage().deleteAllCookies();
        String actualUrl=null;
        logger.debug("clicking  SigninIcon in  the home page to view the DropDown List. ");
        hp.clickIconSignin();	

    	switch(linkText)
    	{ 
	      case "Sign In":  		
	    	  logger.debug("Clicking SignIn optionfrom the DropDown List in the HomePage.");
	    	  hp.clickSignInLink();	
	    	  actualUrl=getPageUrl();
	    	  Assert.assertEquals(actualUrl, ConstantsUtils.SIGNINURL,"Sign In link url verification failed.");
	    	  logger.info("Sign In link url verified successfully.");
	      break;
	    		
	      case "Create account":
	    	   logger.debug("Clicking Create account option from the DropDown List in the HomePage.");
	    	   hp.clickCreateAccLink();	
			   actualUrl=getPageUrl();
		       Assert.assertEquals(actualUrl, ConstantsUtils.CREATEACCOUNTURL,"Create account link url verification failed.");
		       logger.info("Create account link url verified successfully.");
	      break;
	    	  
	      case "Help":
	    	     logger.debug("Clicking Help option from the DropDown List in the HomePage.");
	    	     hp.clickHelpLink();	
		    	 actualUrl=getPageUrl();
		    	 Assert.assertEquals(actualUrl, ConstantsUtils.HELPURL,"Help link url verification failed.");
		    	 logger.info("Help link url verified successfully.");
			break;
			
	        case "":
				 Assert.assertTrue(false,"SigninDropDownList Values were not fetched correctly.");
			break;			
    	}

    }    	
	
	@DataProvider(name="getSigninlinks")
	public String[] getSigninlinks() 
	{	
		logger.debug("In the dataprovider to fetch list of Sign in dropdown links. ");
		navigateToHomePage();
		//HomePage hp = new HomePage(driver);
		driver.manage().deleteAllCookies();
		logger.debug("clicking  SigninIcon to view the DropDown List and fetching the list of links. ");
		hp.clickIconSignin();
		String arr[] = hp.getSignInUserDropDownLinksArray();
		logger.debug("clicking  SigninIcon to hide the DropDown List. ");
		hp.clickIconSignin();
		return arr;
	}
	
}

