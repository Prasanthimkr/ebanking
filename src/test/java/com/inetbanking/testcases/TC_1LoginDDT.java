package com.inetbanking.testcases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageobjects.Login;
import com.inetbanking.utilities.XLUtils;

public class TC_1LoginDDT extends BaseClass 
{
	//actual test method
	@Test(dataProvider="LoginData")
	public void LoginDDT(String user,String pwd) throws IOException
	{
		Login lp= new Login(driver);
		
		lp.setUserName(user);
		log.info("Username entered ");
		lp.setPassword(pwd);
		log.info("password entered ");
		lp.clickSubmit();
		log.info("submit clicked ");
		
		if(isAlertPresent()==true)
		{
			
			driver.switchTo().alert().accept();//invalid alert
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			log.warn("Login failed with invalid credentials");
			captureScreen(driver,"logintestddt");
			
		}
		else
		{
			Assert.assertTrue(true);
			log.info("Login passed");
			lp.clickLogout();
			log.info("Logout clicked");
			driver.switchTo().alert().accept();//logout alert
			log.info("alert accepted");
			driver.switchTo().defaultContent();
			log.info("return to home");
		}
	}
	
	
	public boolean isAlertPresent()
	{
		try
		{
			driver.switchTo().alert();
			return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
	}
	
	//dataprovider method	
	@DataProvider(name="LoginData")
	String[][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/inetbanking/testdata/LoginData.xlsx";
		int rownum=XLUtils.getRowCount(path,"Sheet1");
		int ccount=XLUtils.getCellCount(path,"Sheet1",1);
		
		String logindata[][]=new String[rownum][ccount];
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<ccount;j++)
			{
				        //i=1-1=0,j=0                               1,0
				logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1",i, j);
				
			}
		}
		return logindata;
	}
	
	

}
