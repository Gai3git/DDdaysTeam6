package com.DollarDays.utilities;

import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementUtils
{
	public static Logger logger =LogManager.getLogger("DollarDays"); 
	WebDriver driver;
	
	//Constructor with driver initialization
	public ElementUtils(WebDriver driver)
	{
		this.driver = driver;
	}

	//To check if a webelement is displayed
	public boolean isElementDisplayed(WebElement wb)
	{	
		boolean displayed=false;
		try {
			wb.isDisplayed();
			displayed=true;
		}
		catch(Exception  e)
		{		
			//logger.warn(e.getMessage());
			System.out.println(e.getClass().getSimpleName() + "  " + wb.toString() +   " This WebElement is not present/displayed!!! "  );
			logger.warn(e.getClass().getSimpleName() + "  " + wb.toString() +   " This WebElement is not present/displayed!!!");
			displayed=false;
		}
		return displayed;		
	}
	

	//To check if the web element is clickable or not
	public boolean isElementClickable(WebElement wb)
	{
		boolean clickable = false;
		if(isElementDisplayed(wb))	
		{
			try 
			{
				if(wb.isEnabled()) 
				{  clickable=true;}
			}
			catch(Exception e)
			{
				System.out.println(e.getClass().getSimpleName() + "  " + wb.toString() +   " This WebElement is not clickable. "      );
				logger.error(e.getClass().getSimpleName() + "  " + wb.toString() +   " This WebElement is not clickable. ");
				clickable=false;
			}
		}
		return clickable;
	}
	
	//To do click on a webelement
	public void performElementClick(WebElement wb)
	{
		if(isElementClickable(wb)) 
		{
			wb.click();
		}
	}
	
	//To do click on a webelement by using sendKeys(Keys.RETURN)
	public void performElementClickReturn(WebElement wb)
	{
		if(isElementClickable(wb))
		{
			wb.sendKeys(Keys.RETURN);
		}
	}

	//To get text of a webelement
	public String getElementText(WebElement wb)
	{
		String text="";
		if(isElementDisplayed(wb))
		{
			text= wb.getText();
		}
		return text;
	}
	
	//To clear a textbox webelement
	public void clearText(WebElement wb)
	{
		if(isElementClickable(wb))
		{
			wb.clear();
		}
	}
	
	//To enter a string to a webelement like textbox after clearing it
	public void enterText(WebElement wb,String strValue)
	{
		if(isElementClickable(wb))
		{
			wb.clear();
			wb.sendKeys(strValue);
		}
	}
 
	
	//To get an attribute of a webelement
	public String getElementAttribute (WebElement wb,String attrName)
	{
		String attr="";
		if(isElementDisplayed(wb))
		{
			attr= wb.getAttribute(attrName);
		}
		return attr;
	}
	
	//To check if a  webelement is selected or not
	public boolean isElementSelected(WebElement wb)
	{
		boolean isSelected=false;
		if(isElementDisplayed(wb)) 
		{
			isSelected=wb.isSelected();
		}
		return isSelected;		
	}
	
	//To fetch the title of a web page driver
	public String getWebPageTitle() {
		String title = "";
		title = driver.getTitle();
		return title;
	}
	
	
	//To fetch the title of a web page driver
	public String getWebPageUrl() {
		String url = "";
		url = driver.getCurrentUrl();
		return url;
	}

	
	
	//To fetch the list of texts from webelement list
    public  List<String> getListofText(List<WebElement> wbList)
    {	   	
    	List<String>  actList = new ArrayList<String>();
		if(!wbList.isEmpty())
		{
		    for( WebElement wb: wbList)
			{
		    	actList.add(wb.getText());
				//System.out.println(wb.getText());
			}
		    return actList;
		}
		else 
		{
			System.out.println( "Web Element List is empty or doesnot exist in this page.So could not fetch the text values " );
			logger.warn("Web Element List is empty or doesnot exist in this page.So could not fetch the text values " );
			return actList;
		}

  }

    //To fetch array of texts from webelement list
    public  String[] getArrayofText(List<WebElement> wbList)
    {    	
		 if(!wbList.isEmpty())
		 {	
				List<String> linksList= getListofText(wbList);
				String arr1[] = linksList.toArray(new String[0]); 
			    return  arr1;
		 }
		 else 
		 {
			System.out.println("WebELement List  is empty or doesnot exist in this page.So could not fetch the text values.");
			logger.warn("Web Element List is empty or doesnot exist in this page.So could not fetch the text values " );
			return null;
		 }    	
    }
}
