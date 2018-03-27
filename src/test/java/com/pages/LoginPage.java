package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.locators.WebLocators.loginPageLocators;
import com.setUp.BaseSetup;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage implements loginPageLocators {
	
	AppiumDriver driver;
	
	public LoginPage(AppiumDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@CacheLookup
    @FindBy(id = ADD_CONTACT)
    private MobileElement addContactButton;
	
	public MobileElement getAddContactButton() {
		return addContactButton;
	}

    @CacheLookup
    @FindBy(id = USERNAME)
    private WebElement username;
    
    public WebElement getusername() {
		return username;	
    }

    @CacheLookup
    @FindBy(id = PHONE_NUMBER)
    private WebElement phonenumber;
    
    public WebElement getphonenumber() {
		return phonenumber;	
    }

    @CacheLookup
    @FindBy(id = EmaiiID)
    private WebElement emailid;
    
    public WebElement getemailid() {
		return emailid;  	
    }

    @CacheLookup
    @FindBy(id = SAVE_BUTTON)
    private WebElement savebutton;
    
    public WebElement getsavebutton() {
    	return savebutton;
    }
    
    //Login Page Functionality
    
    public boolean addContact() throws Exception {
		try {
			Thread.sleep(5000);
			//if(getAddContactButton().isDisplayed()){
				getAddContactButton().click();
				BaseSetup.logger.info("Click on Add Contact Button");
			//}
			return true;
		}catch (Exception e)
		{
			throw e;
		}
	}

	public boolean addUsername(String addusername) throws Exception {
		try {
				Thread.sleep(5000);
				getusername().clear();
				getusername().sendKeys(addusername);
				return true;
		} catch (Exception e) {
			throw e;
		}	
	}

	public boolean addPhonenumber(String addPhonenumber) {
		try {
			getphonenumber().clear();
			getphonenumber().sendKeys(addPhonenumber);
			return true;
		} catch (Exception e) {
			throw e;
		}	
	}

	public boolean addEmailID(String addEmailID) {
		try {
			getemailid().clear();
			getemailid().sendKeys(addEmailID);
			return true;
		} catch (Exception e) {
			throw e;
		}	
	}

	public boolean saveData() {
		try {
			getsavebutton().click();
			BaseSetup.logger.info("Click on Save Button");
			return true;
		} catch (Exception e) {
			throw e;
		}	
	}
}
