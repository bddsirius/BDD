package com.qualitest.pvh.pages;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qualitest.core.element.BaseElement;

import net.serenitybdd.core.annotations.findby.FindBy;

public class CKStoreLocator extends StoreLocator {

	private static final Logger LOGGER = LoggerFactory.getLogger(CKStoreLocator.class);
	
	@FindBy(xpath = "//*[@name='ip_country']")
	private BaseElement country;
	
	@FindBy(xpath = "//*[@id=\"Layer3\"]/form/table[1]/tbody/tr/td[2]/span[2]")
	private BaseElement searchResultHeader;
	
	/**
	 * Method to switch focus to store locator frame
	 */
	public void switchFocusToStoreLocator() {
		LOGGER.info("Switching focus to Store Locator Frame");
		getDriver().switchTo().frame(3);
	}
	
	/**
	 * Method to verify search location for store locator
	 * @param location - expected default location e.g. Suffern NY 10901
	 */
	public void verifySearchLocation(String location) {
		LOGGER.info("Verifying search location");
		assertThat(searchResultHeader.withTimeoutOf(5, TimeUnit.SECONDS).waitUntilVisible().getText().toUpperCase()).as("Search Location").isEqualTo(location.toUpperCase());
	}
	
	/**
	 * Method to select search location country
	 * @param cntry - Country
	 */
	private void selectCountry(String cntry) {
		LOGGER.info("Selecting search location country: " + cntry);
		Select cuntry = new Select(country);
		cuntry.selectByVisibleText(cntry);
	}
	
	/**
	 * Method to search store near provided location
	 * @param location - search location e.g.: Edison, New Jersey
	 */
	@Override
	public void searchStoreNear(String location) {
		setLocation(location);
		selectCountry("United States");
		searchButton.click();
	}
	
	/**
	 * Method to verify valid search result map is displayed for provided location
	 * @param location - search location e.g.: Edison, New Jersey
	 */
	public void verifyStoreLocatorResult(String location) {
		LOGGER.info("Verifying valid search result is displayed");
		verifySearchLocation(location);
	}
	
}
