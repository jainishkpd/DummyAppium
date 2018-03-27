package com.setUp;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.relevantcodes.extentreports.LogStatus;
import com.extentReporters.ExtentManager;
import com.extentReporters.ExtentTestManager;
import com.testData.TestBaseData;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseSetup {
	
    private DesiredCapabilities capabilities = new DesiredCapabilities();
    protected AppiumDriver driver;
    
    public static Logger logger = Logger.getLogger("MyLog");  
	static FileHandler fh;
    
    @BeforeClass
    public void setup() throws Exception{
        initDriver();
    }

    public AppiumDriver getDriver() {
		return driver;
    }

    public void initDriver() throws Exception {
        System.out.println("Inside initDriver method");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, TestBaseData.platformname);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, TestBaseData.devicename);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, TestBaseData.platformversion);
        capabilities.setCapability(MobileCapabilityType.UDID, TestBaseData.deviceid);
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, TestBaseData.commandtimeout);
        capabilities.setCapability(MobileCapabilityType.APP, TestBaseData.apppath);
        capabilities.setCapability("noReset", TestBaseData.noreset);
        capabilities.setCapability("appPackage", TestBaseData.apppackage);
		capabilities.setCapability("appActivity", TestBaseData.appactivity);		
		driver = new AppiumDriver(new URL(TestBaseData.appiumserverurl), capabilities);
		System.out.println("Driver::::::::::-->>>" + driver);
    }

    @BeforeMethod(alwaysRun = true)
	public void beforeMethod(Method method) throws Exception
	{
		ExtentTestManager.startTest("" + method.getName());
	}
    
    @AfterMethod
    public void takeScreenShot(ITestResult result) throws Exception {
    	
    	if(ITestResult.FAILURE==result.getStatus()) {
    		screenCapture(result);
    		BaseSetup.logger.info("Test Case is Fail ===> " +result.getName());
             ExtentTestManager.getTest().log(LogStatus.FAIL, result.getThrowable());
             ExtentTestManager.getTest().log(LogStatus.FAIL, "Test Failed");
    	}
    	else if(ITestResult.SKIP==result.getStatus()) {
    		screenCapture(result);
    		BaseSetup.logger.info("Test Case is Skip ===> " +result.getThrowable());
    		ExtentTestManager.getTest().log(LogStatus.SKIP, "Test skipped " + result.getThrowable());
    	}
    	else if(ITestResult.SUCCESS==result.getStatus()) {
    		screenCapture(result);
    		BaseSetup.logger.info("Test Case is Pass ===> " +result.getName());
    		ExtentTestManager.getTest().log(LogStatus.PASS, "Test passed");
    	}
    	
    	 ExtentManager.getReporter().endTest(ExtentTestManager.getTest());
         ExtentManager.getReporter().flush();
         ExtentTestManager.getTest().log(LogStatus.INFO, "App Closed");
    }
    
    public void screenCapture(ITestResult result) throws IOException
	{
		Date d = new Date();
		System.out.println(d.toString());		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile,  new File("D:\\RND\\Eclipse_Project\\DummyAppium\\test-output\\ScreenShots\\"+result.getName()+"_"+sdf.format(d)+".png"));
	}
    
    @BeforeSuite
    public void setLogger() throws SecurityException, IOException
	{
		fh = new FileHandler("D:\\RND\\Eclipse_Project\\DummyAppium\\src\\test\\resource\\MyLog.txt");  
		logger.addHandler(fh);
		SimpleFormatter formatter = new SimpleFormatter();  
		fh.setFormatter(formatter);  
    }
    
    @AfterClass
    public void tearDown(){
        driver.quit();
    }

	
}
