package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.Basetest;

public class Failtestcase extends Basetest{
	
	  @Test
      public void testFail()
  {
      driver.get("https://googleee.co...");
      Assert.fail("Failing intentionally");


  }
	

}
