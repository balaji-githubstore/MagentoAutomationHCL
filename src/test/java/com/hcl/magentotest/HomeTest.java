package com.hcl.magentotest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hcl.base.WebDriverWrapper;
import com.hcl.magentopages.HomePage;

public class HomeTest extends WebDriverWrapper{
	
	@Test
	public void totalLinkTest()
	{
		HomePage home=new HomePage(driver);
		int totalLink=home.getTotalLinkCount();
		
		//Assert.assertEquals(totalLink, 229);
		Assert.assertTrue(totalLink>200,"Not more than 200 - "+totalLink);
	}

}
