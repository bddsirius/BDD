package com.qualitest.pvh.pages;

import static org.assertj.core.api.Assertions.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qualitest.core.element.BaseElement;
import com.qualitest.core.page.BasePage;

import net.serenitybdd.core.annotations.findby.FindBy;

public class StoreLocator extends BasePage {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(StoreLocator.class);
	
	@FindBy(id = "address")
	private BaseElement searchLocation;
	
	@FindBy(xpath = "//*[@class='submitbutton']")
	protected BaseElement searchButton;
	
	@FindBy(xpath = "//*[@class='noresults']/p[1]")
	protected BaseElement noresultMessage;
	
	@FindBy(xpath = "//*[@id='Layer1']")
	protected BaseElement searchResultMap;
	
	/**
	 * Method to retrieve value from search location text field
	 * @return - Value of search location field
	 */
	private String getLocation() {
		LOGGER.info("Retriveing search location");
		return searchLocation.waitUntilVisible().getAttribute("value");
	}
	
	/**
	 * Method to enter search location for store locator
	 * @param location - search location e.g.: Edison, New Jersey
	 */
	protected void setLocation(String location) {
		LOGGER.info("Entering search location: " + location);
		searchLocation.type(location);
	}
	
	/**
	 * Method to verify search location for store locator
	 * @param location - expected default location e.g. Suffern NY 10901
	 */
	public void verifySearchLocation(String location) {
		LOGGER.info("Verifying search location");
		assertThat(getLocation()).as("Search Location").isEqualTo(location);
	}

	/**
	 * Method to search store near provided location
	 * @param location - search location e.g.: Edison, New Jersey
	 */
	public void searchStoreNear(String location) {
		setLocation(location);
		searchButton.click();
	}
	
	/**
	 * Method to verify no search result error message
	 * @param message - Expected No search result error message
	 */
	public void verifyNoResultError(String message) {
		LOGGER.info("Verifying no search result message");
		assertThat(noresultMessage.getText().toUpperCase()).as("No Result Error Message").contains(message.toUpperCase());
	}
		
	/**
	 * Method to verify valid search result map is displayed
	 */
	public void verifyStoreLocatorResult() {
		LOGGER.info("Verifying valid search result is displayed");
		assertThat(searchResultMap.isDisplayed()).as("Search Result Map is displayed").isTrue();
	}
	
}
