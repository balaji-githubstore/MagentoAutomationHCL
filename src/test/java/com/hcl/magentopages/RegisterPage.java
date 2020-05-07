package com.hcl.magentopages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage {
	private By firstnameLocator=By.id("firstname");
	private By lastnameLocator=By.id("lastname");
	private By emailAddressLocator=By.id("email_address");
	private By companyTypeLocator=By.xpath("//*[@id='company_type']");
	
	private WebDriver driver;
	
	public RegisterPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void fillRegistrationForm(String firstname,String lastname,String emailAddress,String companyType)
	{
		driver.findElement(firstnameLocator).sendKeys(firstname);
		driver.findElement(lastnameLocator).sendKeys(lastname);
		driver.findElement(emailAddressLocator).sendKeys(emailAddress);
		
		Select selectCompany=new Select(driver.findElement(companyTypeLocator));
		selectCompany.selectByVisibleText(companyType);
	}
}
