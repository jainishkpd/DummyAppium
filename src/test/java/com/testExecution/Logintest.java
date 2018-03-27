package com.testExecution;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.extentReporters.ExtentTestManager;
import com.pages.LoginPage;
import com.relevantcodes.extentreports.LogStatus;
import com.setUp.BaseSetup;
import com.testData.TestLoginData;

@Listeners(com.customeListners.TestNGListeners.class)
public class Logintest extends BaseSetup {
	
	LoginPage login; 
	
	@Test
	public void addContactTest() throws Exception {
		ExtentTestManager.getTest().getTest().setName("TestCaseID_0001 : Click on Add Contact Button");
		ExtentTestManager.getTest().assignCategory("Add Contact");
		System.out.println("Inside Test Method::::::-"); 
		login = new LoginPage(driver);
		Assert.assertEquals(login.addContact(), true, "Click on Add Contact Button Succesfully.");
		ExtentTestManager.getTest().log(LogStatus.PASS, "Click on Add Contact Button Succesfully.");
	}
	
	@Test
	public void addUsernameTest() throws Exception {
		ExtentTestManager.getTest().getTest().setName("TestCaseID_0002 : Enter Username");
		ExtentTestManager.getTest().assignCategory("Add Username");
		login = new LoginPage(driver);
		Assert.assertEquals(login.addUsername(TestLoginData.username), true, "Entered Username Successfully");
		BaseSetup.logger.info("Entered Username ==> " +TestLoginData.username);
		ExtentTestManager.getTest().log(LogStatus.PASS, "Entered Username Successfully");
	}
	
	@Test
	public void addPhoneNumberTest() {
		ExtentTestManager.getTest().getTest().setName("TestCaseID_0003 : Enter Phonenumber");
		ExtentTestManager.getTest().assignCategory("Add PhoneNumber");
		login = new LoginPage(driver);
		Assert.assertEquals(login.addPhonenumber(TestLoginData.phonenumber), true, "Entered Phonenumber Successfully");
		BaseSetup.logger.info("Entered Phonenumber => " +TestLoginData.phonenumber);
		ExtentTestManager.getTest().log(LogStatus.PASS, "Entered Phonenumber Successfully");
	}
	
	@Test
	public void addEmailIDTest() {
		ExtentTestManager.getTest().getTest().setName("TestCaseID_0004 : Enter EmailID");
		ExtentTestManager.getTest().assignCategory("Add Email ID");
		login = new LoginPage(driver);
		Assert.assertEquals(login.addEmailID(TestLoginData.emailid), true, "Entered EmailID Successfully");
		BaseSetup.logger.info("Entered emailid => " +TestLoginData.emailid);
		ExtentTestManager.getTest().log(LogStatus.PASS, "Entered EmailID Successfully");
	}
	
	@Test
	public void saveDataTest() {
		ExtentTestManager.getTest().getTest().setName("TestCaseID_0005 : Click on Save Button");
		ExtentTestManager.getTest().assignCategory("Save Data");
		login = new LoginPage(driver);
		Assert.assertEquals(login.saveData(), true, "Click on Save Button Succesfully.");
		ExtentTestManager.getTest().log(LogStatus.PASS, "Click on Save Button Succesfully.");
	}

}
