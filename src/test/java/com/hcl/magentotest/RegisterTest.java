package com.hcl.magentotest;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hcl.base.WebDriverWrapper;
import com.hcl.magentopages.HomePage;
import com.hcl.magentopages.LoginPage;
import com.hcl.magentopages.RegisterPage;
import com.hcl.utilities.ExcelUtils;

public class RegisterTest extends WebDriverWrapper {	

	@DataProvider
	public String[][] registrationData() throws IOException
	{
		String[][] main = ExcelUtils.getSheetIntoArray("testdata/MagentoData.xlsx", "RegistrationData");
		return main;
	}
	
	@Test(dataProvider = "registrationData")
	public void registrationTest(String firstname,String lastname	,String emailAddress,String companyType)
	{
		HomePage home=new HomePage(driver);
		home.clickOnMyAccountIcon();
		
		LoginPage login=new LoginPage(driver);
		login.clickOnRegister();
		
		RegisterPage register=new  RegisterPage(driver);
		register.fillRegistrationForm(firstname, lastname, emailAddress, companyType);
		
		//assertion
	}
	
	

}
