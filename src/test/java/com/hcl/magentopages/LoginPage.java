package com.hcl.magentopages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	@FindBy(id = "email")
	private WebElement emailEle;

	@FindBy(id = "pass")
	private WebElement passEle;

	@FindBy(id = "send2")
	private WebElement loginEle;

	@FindBy(xpath = "//div[contains(text(),'Invalid')]")
	private WebElement errorEle;

	@FindBy(id = "register")
	private WebElement registerEle;

	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void sendEmailAddress(String username) {
		emailEle.sendKeys(username);
	}

	public void sendPassword(String password) {
		passEle.sendKeys(password);
	}

	public void clickOnLogin() {
		loginEle.click();
	}

	public String getErrorMessage() {
		return errorEle.getText();
	}

	public void clickOnRegister() {
		registerEle.click();
	}
}
