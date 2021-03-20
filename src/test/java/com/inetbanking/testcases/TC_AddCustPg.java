package com.inetbanking.testcases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageobjects.AddCustomerPage;
import com.inetbanking.pageobjects.Login;

public class TC_AddCustPg extends BaseClass {
	
	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		Login lp=new Login(driver);
		lp.setUserName(username);
		log.info("User name is provided");
		lp.setPassword(password);
		log.info("Passsword is provided");
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		AddCustomerPage addcust=new AddCustomerPage(driver);
		
		addcust.newCustomer();
		
		log.info("providing customer details....");
		
		
		addcust.custName("Prasanthi");
		addcust.gender("female");
		addcust.dob("10","23","1986");
		Thread.sleep(5000);
		addcust.caddre("INDIA");
		addcust.city("Hyderabad");
		addcust.state("Telangana");
		addcust.pinno("5000074");
		addcust.telephno("987890091");		
		String email=randomestring()+"@gmail.com";
		addcust.email(email);
		addcust.password("abcdef");
		addcust.clkSubmit();
		
		Thread.sleep(3000);
		
		log.info("validation started....");
		
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			log.info("test case passed....");
			
		}
		else
		{
			Assert.assertTrue(false);
			log.info("test case failed....");
			captureScreen(driver,"addNewCustomer");
			
		}
			
	}

	
}
