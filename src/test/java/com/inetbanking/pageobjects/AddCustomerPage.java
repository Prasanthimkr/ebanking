package com.inetbanking.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	
	WebDriver driver;
	
	public AddCustomerPage(WebDriver ldriver)
	{
		driver=ldriver;
		PageFactory.initElements(ldriver,this);
	}
	
	@FindBy(how=How.XPATH,using="//a[text()='New Customer']")
	@CacheLookup
	WebElement lnkNewCustomer;
	
	@FindBy(how=How.XPATH,using="//input[@name='name']")
	@CacheLookup
	WebElement txtCustName;
	
	@FindBy(how=How.NAME,using="rad1")
	@CacheLookup
	WebElement rdGender;
	
	@FindBy(how=How.ID_OR_NAME,using="dob")
	@CacheLookup
	WebElement dob;
	
	@FindBy(how=How.NAME,using="addr")
	@CacheLookup
	WebElement txtAddress;
	
	@FindBy(how=How.NAME,using="city")
	@CacheLookup
	WebElement txtCity;
	
	@FindBy(how=How.NAME,using="state")
	@CacheLookup
	WebElement txtState;
	
	@FindBy(how=How.NAME,using="pinno")
	@CacheLookup
	WebElement txtPinno;
	
	@FindBy(how=How.NAME,using="telephoneno")
	@CacheLookup
	WebElement txtTelephoneno;
	
	@FindBy(how=How.NAME,using="emailid")
	@CacheLookup
	WebElement txtEmailid;
	
	@FindBy(how=How.NAME,using="password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(how=How.NAME,using="sub")
	@CacheLookup
	WebElement btnSubmit;
	
	public void newCustomer()
	{
		lnkNewCustomer.click();
	}
	
	public void custName(String cname)
	{
		txtCustName.sendKeys(cname);
	}
	
	public void gender(String cgender)
	{
		rdGender.click();
	}
	
	public void dob(String mm,String dd,String yy)
	{
		dob.sendKeys(mm);
		dob.sendKeys(dd);
		dob.sendKeys(yy);
	}
	
	public void caddre(String address)
	{
		txtAddress.sendKeys(address);
	}
	
	public void city(String city)
	{
		txtCity.sendKeys(city);
	}
	
	public void state(String state)
	{
		txtState.sendKeys(state);
	}
	
	public void pinno(String pin)
	{
		txtPinno.sendKeys(String.valueOf(pin));
	}
	
	public void telephno(String phn)
	{
		txtTelephoneno.sendKeys(phn);
	}
	
	public void email(String mailid)
	{
		txtEmailid.sendKeys(mailid);
	}
	
	public void password(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	public void clkSubmit()
	{
		btnSubmit.click();
	}
}
	
	
