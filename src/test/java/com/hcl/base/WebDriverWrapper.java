package com.hcl.base;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.hcl.utilities.PropUtils;

public class WebDriverWrapper {
	protected WebDriver driver;

	@BeforeMethod
	@Parameters({ "browser" })
	public void setup(@Optional("ch") String browserName) throws IOException {

		
		if (browserName.equalsIgnoreCase("ff") || browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "driver/geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserName.equals("ie")) {
			System.setProperty("webdriver.ie.driver", "driver/iedriverserver.exe");
			driver = new InternetExplorerDriver();
		} else {
			System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
			driver = new ChromeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		String baseUrl = PropUtils.getValueUsingKey("testdata/data.properties", "url");

		if (baseUrl != null) {
			driver.get(baseUrl);
		} else {
			driver.get("https://magento.com/");
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
