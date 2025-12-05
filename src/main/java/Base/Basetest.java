package Base;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
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
	

    public String takeScreenshot(String testName) {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir") + "/screenshots/" + testName + ".png";
        try {
            FileUtils.copyFile(src, new File(path));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return path;
    }

    @AfterMethod
    public void getResult(ITestResult result) {

        if (result.getStatus() == ITestResult.FAILURE) {
            System.out.println("Test Failed! Screenshot Captured!");
            takeScreenshot(result.getName());
        }

        driver.quit();
    }

}
