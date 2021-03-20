package com.inetbanking.testcases;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageobjects.Login;

public class TC_LoginTest extends BaseClass 
{	
  @Test
  public void loginTest() throws IOException 
	{
			
	  log.info("URL is opened");
	  
	  Login lp= new Login(driver);
	  
	  lp.setUserName(username); 
	  log.info("Username is entered");
	  
	  lp.setPassword(password);
	  log.info("Password is entered");
	  
	  lp.clickSubmit();
	  
	  if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
	  {
		  Assert.assertTrue(true);
		  log.info("Login test passed");
	  }
	  else
	  {
		  captureScreen(driver,"loginTest");
		  Assert.assertTrue(false);
		  log.info("Login test failed");
		  
	  }
		
		
	}

}
