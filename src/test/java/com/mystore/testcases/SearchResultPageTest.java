/**
 * 
 */
package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.SearchResultPage;

/**
 * 
 */
public class SearchResultPageTest extends BaseClass{
	IndexPage indexPage;
	SearchResultPage searchResultPage;
	HomePage homePage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke", "Sanity", "Regression"})
	public void setup(String browser) {
		launchApp(browser);
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups = "Smoke")
	public void productAvailabilityTest() throws Throwable{
		indexPage = new IndexPage();
		searchResultPage = indexPage.searchProduct("Shirt");
		boolean result = searchResultPage.isProductAvailable();
		Assert.assertTrue(result);
	}
}
