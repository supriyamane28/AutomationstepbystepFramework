package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.Basetest;
import Pages.Loginpage;

public class Logintest extends Basetest{
	
	@Test
	public void testvalidlogin()
	{
		Loginpage loginpageobject=new Loginpage(driver);
		loginpageobject.enterusername("admin@yourstore.com");
		loginpageobject.enterpassword("admin");
		loginpageobject.clickonlogin();
		
		System.out.println(driver.getTitle());
		
		
		
	Assert.assertEquals(driver.getTitle(),"Just a moment...");
		
		
				
	}

}
