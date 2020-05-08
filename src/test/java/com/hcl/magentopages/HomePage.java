package com.hcl.magentopages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	@FindBy(xpath = "//a[@data-adobe-name='Header|GlobalNav|MyAccountClick']")
	private WebElement myAccEle;
	
	@FindBy(tagName = "a")
	private List<WebElement> linksEle;
	
	private WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;	
		PageFactory.initElements(driver, this); //mandatory
	}
	
	public void clickOnMyAccountIcon() {
		myAccEle.click();
	}
	
	
	public int getTotalLinkCount()
	{
		//List<WebElement> linksEle =driver.findElements(By.tagName("a"));
		return linksEle.size();
	}
}
