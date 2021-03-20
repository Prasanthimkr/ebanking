package com.inetbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	
	public ReadConfig() 
	{
		File src = new File("./configuration/config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
			} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Exception is  "+e.getMessage());
		} 
	}
	
	public String getApplicationUrl()
	{
		String url=pro.getProperty("baseurl");
		return url;
	}
	
	public String getuname()
	{
		String uname=pro.getProperty("username");
		return uname;
	}	
	public String  getPassword()
	{
		String pwd=pro.getProperty("password");
		return pwd;		
	}
	public String getChromePath()
	{
		String chrome=pro.getProperty("chromepath");
		return chrome;
	}
	public String getIEPath()
	{
		String iepath=pro.getProperty("iepath");
		return iepath;
	}
	public String getGeckoPath()
	{
		String gecko=pro.getProperty("firefoxpath");
		return gecko;
	}

}
