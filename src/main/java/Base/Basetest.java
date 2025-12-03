package Base;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;


import utils.Log;

public class Basetest {
	
	protected WebDriver driver;
	
	@BeforeSuite
    public void cleanAllureReports() {
        File allureResults = new File("allure-results");

        if (allureResults.exists()) {
            for (File file : allureResults.listFiles()) {
                file.delete();
            }
            System.out.println("🧹 Old Allure results cleaned!");
        }
    }
	
	
	
	@BeforeMethod
	public void setUp()
	{
		Log.info("Starting WebDriver ...");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		Log.info("redirect to URL page ...");		
		driver.get("https://admin-demo.nopcommerce.com/login");
		
				
	}
	
	@AfterMethod
	
	public void tearDown()
	{
		if(driver!=null)
		{
			Log.info("closing WebDriver ...");
			driver.quit();
		
	    }
	}

}
