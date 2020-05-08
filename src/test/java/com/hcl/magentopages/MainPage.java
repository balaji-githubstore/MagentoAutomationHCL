package com.hcl.magentopages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
	private By logoutLocator = By.partialLinkText("Out");
	
	@FindBy(partialLinkText = "Out")
	private WebElement logoutEle;
	

	private WebDriver driver;

	public MainPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void waitForPresenceOfLogOut() {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.presenceOfElementLocated(logoutLocator));
	}

	public String getCurrentTitle() {
		return driver.getTitle();
	}

	public void clickLogout() {
		logoutEle.click();
	}

}
