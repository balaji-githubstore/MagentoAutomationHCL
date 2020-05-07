package com.hcl.magentotest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hcl.base.WebDriverWrapper;
import com.hcl.magentopages.HomePage;
import com.hcl.magentopages.LoginPage;
import com.hcl.magentopages.MainPage;
import com.hcl.utilities.ExcelUtils;

public class LoginTest extends WebDriverWrapper	 {
	@Test(priority = 1)
	public void validCredentialTest() {
		HomePage home = new HomePage(driver);
		home.clickOnMyAccountIcon();

		LoginPage login=new LoginPage(driver);	
		login.sendEmailAddress("balaji0017@gmail.com");
		login.sendPassword("welcome@123");
		login.clickOnLogin();

		MainPage main=new MainPage(driver);
		main.waitForPresenceOfLogOut();
		
		String expectedTitle = "My Account";
		String actualTitle = main.getCurrentTitle();
		//don't move to pageobjects
		Assert.assertEquals(actualTitle, expectedTitle);
		main.clickLogout();
	}
	
	@DataProvider
	public String[][] invalidCredentialData() throws IOException
	{
		String[][] main = ExcelUtils.getSheetIntoArray("testdata/MagentoData.xlsx", "InvalidCredentialData");
		return main;
	}

	@Test(priority = 2,dataProvider = "invalidCredentialData",enabled = false)
	public void invalidCredentialTest(String username,String password,String expectedValue) {
		HomePage home = new HomePage(driver);
		home.clickOnMyAccountIcon();

		LoginPage login=new LoginPage(driver);	
		login.sendEmailAddress(username);
		login.sendPassword(password);
		login.clickOnLogin();

		String actualText = login.getErrorMessage();
		Assert.assertTrue(actualText.contains(expectedValue), "Assertion on invalidCredentialTest");

	}
}
