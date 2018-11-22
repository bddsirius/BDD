package com.qualitest.core.page;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qualitest.core.element.BaseElement;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.WhenPageOpens;

public class BasePage extends PageObject {

	public static final Logger LOGGER = LoggerFactory.getLogger(BasePage.class);

	public String URL;

	public int defaultTimeout = 90 * 1000;

	public void sleep(long t) {
		try {
			Thread.sleep(t);
		} catch (InterruptedException e) {
			LOGGER.error("Exception occured while waiting!!!" + e);
		}
	}

	public void invoke() {
		super.openUrl(URL);
	}

	public void invoke(String URL) {
		this.URL = URL;
		invoke();
	}

	public BaseElement getItemToExist() {
		return null;
	}

	@WhenPageOpens
	public void waitForMe() {

		if (getItemToExist() == null)
			return;

		try {
			getItemToExist().waitForMe(defaultTimeout);
		}
		catch (Exception e)	{
			throw new AssertionError(String.format("Page '%s' was not loaded. Waited %d ms for object '%s' to appear",  this.toString(), defaultTimeout, getItemToExist())) ;
		}

	}
	
	/**
	 * Method to verify page title contains provided text
	 * @param PageTitle - Page Title Text
	 */
	public void verifyPageTitleContains(String PageTitle) {
		assertTrue(PageTitle + " Page is not displayed",getDriver().getTitle().contains(PageTitle));
	}
	
	/**
	 * Method to select value from bootstrap drop down list items
	 * @param webElementList - List of bootstrap drop down items e.g.: <li>Check</li> 
	 * @param valueToBeSelected - Value that needs to be selected
	 */
	public void bootstrapSelectByValue(List<WebElementFacade> webElementList, String valueToBeSelected) {
		for(WebElementFacade ele: webElementList) {
			LOGGER.info("Current Element Text: " + ele.getText());
			if(ele.getText().equalsIgnoreCase(valueToBeSelected)) {
				ele.click();
				break;
			}
		}
	}
	
	/**
	 * Method to verify provided error message exists on page
	 * @param error - Error message
	 * @return - true if error exist, else false
	 */
	public boolean verifyErrorExists(String error) { 
		String locator = "//div[contains(text(),'"+error+"')]";
		
		LOGGER.debug("Trying to locate error message using xpath: " + locator);
		try
		{
			find(By.xpath(locator));
			return true;
		} catch(Exception e) {
			return false;
		}
	}

	/**
	 * Method to refresh the page
	 */
	public void pageRefresh() {
		LOGGER.info("Refreshing page");
		getDriver().navigate().refresh();
	}
}