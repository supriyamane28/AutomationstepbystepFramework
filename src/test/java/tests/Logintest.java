package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.Basetest;
import Pages.Loginpage;

import utils.Log;

public class Logintest extends Basetest{
	
	@Test
	public void testvalidlogin()
	{
		
		Log.info("starting login test....");
		
		Loginpage loginpageobject=new Loginpage(driver);
		
		Log.info("adding creditials ...");
		
		loginpageobject.enterusername("admin@yourstore.com");
		loginpageobject.enterpassword("admin");
	
		loginpageobject.clickonlogin();
		
		System.out.println(driver.getTitle());
		
		
		Log.info("verifying page title ...");
		
	Assert.assertEquals(driver.getTitle(),"Just a moment...");
		
	
	
		
				
	}

}
