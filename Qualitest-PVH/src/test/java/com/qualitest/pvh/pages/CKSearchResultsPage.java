package com.qualitest.pvh.pages;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qualitest.core.element.BaseElement;
import com.qualitest.pvh.departments.CKDepartment;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;

public class CKSearchResultsPage extends SearchResultsPage {
	
	@FindBy(xpath = "//*[@id=\"pvhOverlayContentWrapper\"]/div[2]")
	protected BaseElement popUpClose;

	private static final Logger LOGGER = LoggerFactory.getLogger(CKSearchResultsPage.class);

	/**
	 * Method to verify list of department displayed on left column of Calvin Klein
	 * US search result page
	 */
	protected void verifyDepartmentListOnLeftColumn() {
		LOGGER.info("Verifying department list displayed on search result left column");
		for (int i = 0; i < leftColumnDepartmentList.size(); i++) {
			String text = leftColumnDepartmentList.get(i).getText();
			Boolean first = false;
			if (text.equalsIgnoreCase(CKDepartment.NYC.name) || text.equalsIgnoreCase(CKDepartment.WOMEN.name)
					|| text.equalsIgnoreCase(CKDepartment.MEN.name) || text.equals(CKDepartment.KIDS.name)
					|| text.equalsIgnoreCase(CKDepartment.UNDERWEAR.name)
					|| text.equalsIgnoreCase(CKDepartment.HOME.name) || text.equalsIgnoreCase(CKDepartment.SALE.name)
					|| text.equalsIgnoreCase(CKDepartment.PROJECTS.name)) {
				first = true;
			} else {
				first = false;
			}
			SA.assertThat(first).as(
					"Department displayed on Left Column: " + text + " matches with Clavin Klein US department list")
					.isTrue();
		}
		SA.assertAll();
	}

	/**
	 * Method to verify no search result message for Calvin Klein
	 */
	public void verifyNoSearchResultMessage() {
		boolean first = false;
		if (noSearchResultMessage.getText().contains("WE FOUND NO RESULTS")
				|| noSearchResultMessage.getText().contains("RETURNED 0 RESULTS")) {
			first = true;
		} else {
			first = false;
		}
		assertThat(first).as("Verifying no search results message displayed").isTrue();
	}

	@Override
	/**
	 * Method to verify search result for Calvin Klein
	 */
	public void verifySearchResult(String item) {
		verifySearchTerm(item);
		verifyDepartmentListOnLeftColumn();
		verifyTotalCount();
	}
	
	@Override
	/**
	 * Method to select first product from search result
	 */
	public void selectFirstProduct() {
		if(productList.size() == 0) {
			return;
		}
		WebElement w = productList.get(0);
		LOGGER.info("Clicking first product: " + w.getAttribute("title") + " from search result ");
		sleep(2000);
		w.click();
	}
	
	@Override
	/**
	 * Method to select product from search result
	 */
	public void selectProduct(int num) {
		pageRefresh();
		clickOffPopUp();
		WebElement w = productList.get(num-1);
		LOGGER.info("Clicking product: " + w.getAttribute("title") + " from search result ");
		sleep(1000);
		w.click();
	}
	
	/**
	 * Method to close pop up window
	 */
	public void clickOffPopUp() {
		if (popUpClose.isVisible()) {
			LOGGER.info("Closing pop up window");
			popUpClose.click();
		}
	}
	
	/**
	 * Method to select provided department on search result page
	 * @param department - Department e.g.: Men / Women / Kids / Home / Sale
	 */
	public void selectDepartmentFromLeftNavigationBar(String department) {
		clickOffPopUp();
		for (int i = 0; i < leftColumnDepartmentList.size(); i++) {
			String text = leftColumnDepartmentList.get(i).getText().trim();
			if(text.equalsIgnoreCase(department)) {
				LOGGER.info("Clicking department " + department + " link");
				leftColumnDepartmentList.get(i).click();
				break;
			} else {
				continue;
			}
		}
	}
	
	/**
	 * Method to verify provide option is displayed on search result page
	 * @param option - Option e.g.: filter / sort
	 */
	public void verifyOption(String option) {
		if(option.equalsIgnoreCase("FILTER")) {
			LOGGER.info("Verifying filter options");
			SA.assertThat(collectionFilterOption.isDisplayed()).as("Collection Filter Option").isTrue();
			//SA.assertThat(categoryFilterOption.isDisplayed()).as("Category Filter Option").isTrue();
			SA.assertThat(priceFilterOption.isDisplayed()).as("Price Filter Option").isTrue();
			SA.assertThat(colorFilterOption.isDisplayed()).as("Color Filter Option").isTrue();
			SA.assertThat(sizeFilterOption.isDisplayed()).as("Size Filter Option").isTrue();
		} else if(option.equalsIgnoreCase("SORT")) {
			LOGGER.info("Verifying sort option");
			SA.assertThat(sortOption.isDisplayed()).as("Sort Option").isTrue();
		}
		SA.assertAll();
	}
	
	/**
	 * Method to filter search product list based on provided price range
	 * @param price - Price Range e.g.: $0 - $25
	 */
	public void filterSearchResultUsingPriceRange(String price) {
		clickOffPopUp();
		pageRefresh();
		LOGGER.info("Clicking price filter option");
		priceFilterOption.withTimeoutOf(5, TimeUnit.SECONDS).waitUntilClickable().click();
		switch(price){
		case "$0 - $25":
			LOGGER.info("Selecting $0 - $25 price range option");
			find(By.id("0-25")).click();
			break;
		case "$25 - $50":
			LOGGER.info("Selecting $25 - $50 price range option");
			find(By.id("25-50")).click();
			break;
		case "$50 - $100":
			LOGGER.info("Selecting $50 - $100 price range option");
			find(By.id("50-100")).click();
			break;
		case "$100 - $150":
			LOGGER.info("Selecting $100 - $150 price range option");
			find(By.id("100-150")).click();
			break;
		case "$150 - $300":
			LOGGER.info("Selecting $150 - $300 price range option");
			find(By.id("150-300")).click();
			break;
		case "$300+":
			LOGGER.info("Selecting $300+ price range option");
			find(By.id("300-plus")).click();
			break;
		default:
				LOGGER.info("Provided Price Range: " + price + " option is not available");
		}
	}

	/**
	 * Method to filter search product list using provided color
	 * @param color - Color e.g.: black / blue / green / neutral / ivory / red / white
	 */
	public void filterSearchResultUsingColor(String color) {
		
		clickOffPopUp();
		pageRefresh();
		
		LOGGER.info("Clicking color filter option");
		colorFilterOption.withTimeoutOf(5, TimeUnit.SECONDS).waitUntilClickable().click();
		
		try {
			LOGGER.info("Selecting " + color + " color option");
			find(By.id(color)).click();
		} catch (Exception e) {
			LOGGER.info("Provided Color: " + color + " option is not available");
		}
		
	}
	
	/**
	 * Method to verify search product list is filtered using provided option
	 * @param option - Option e.g.: black / blue / 
	 */
	public void verifyProductListIsFilteredUsing(String option) {
		clickOffPopUp();
		pageRefresh();
		String filteredOption = "//div[@class='filterName filterListItem']/span[text()='" + option.toUpperCase() + "']";
		LOGGER.info(filteredOption);
		assertThat(find(By.xpath(filteredOption)).isVisible()).as("Product List is filtered using " + option + " option").isTrue();
	}

	/**
	 * Method to filter search product list using provided size
	 * @param size - Size e.g.: s / m / l / xl / xxl / 4xl
	 */
	public void filterSearchResultUsingSize(String size) {
		
		clickOffPopUp();
		pageRefresh();
		
		LOGGER.info("Clicking size filter option");
		sizeFilterOption.withTimeoutOf(5, TimeUnit.SECONDS).waitUntilClickable().click();
		
		try {
			LOGGER.info("Selecting " + size + " size option");
			find(By.id(size)).click();
		} catch (Exception e) {
			LOGGER.info("Provided Size: " + size + " option is not available");
		}
		
	}
	
	/**
	 * Method to filter search product list using provided category
	 * @param category - Collection e.g.: BIG + TALL / BODY / BODY MODAL / MODERN MODAL / CALVIN KLEIN ID
	 */
	public void filterSearchResultUsingCategory(String category) {
		
		clickOffPopUp();
		pageRefresh();
		
		LOGGER.info("Clicking collection filter option");
		collectionFilterOption.withTimeoutOf(5, TimeUnit.SECONDS).waitUntilClickable().click();
		
		switch(category){
		case "BIG + TALL":
			LOGGER.info("Selecting BIG + TALL price range option");
			find(By.id("big-plus-tall")).click();
			break;
		case "BODY":
			LOGGER.info("Selecting BODY price range option");
			find(By.id("body")).click();
			break;
		case "BODY MODAL":
			LOGGER.info("Selecting BODY MODAL price range option");
			find(By.id("body-modal")).click();
			break;
		case "CALVIN KLEIN ID":
			LOGGER.info("Selecting CALVIN KLEIN ID price range option");
			find(By.id("calvin-klein-id")).click();
			break;
		case "COTTON STRETCH":
			LOGGER.info("Selecting COTTON STRECTH price range option");
			find(By.id("cotton-stretch")).click();
			break;
		case "MODERN COTTON":
			LOGGER.info("Selecting MODERN COTTON price range option");
			find(By.id("modern-cotton")).click();
			break;
		default:
				LOGGER.info("Provided Collection: " + category + " option is not available");
		}
		
	}
	
	/**
	 * Method to sort searched product list using provide price
	 * @param price - Price e.g.: Price Low to High / Price High to Low
	 */
	public void sortSearchResultUsingPrice(String price) {
		
		clickOffPopUp();
		pageRefresh();
		
		LOGGER.info("Clicking sort option");
		sortOption.withTimeoutOf(5, TimeUnit.SECONDS).waitUntilClickable().click();
		
		try {
			LOGGER.info("Selecting " + price + " sort option");
			String sortOption = "//a[text()='" + price + "']";
			find(By.xpath(sortOption)).click();
		} catch (Exception e) {
			LOGGER.info("Provided Sort option: " + price + " is not available");
		}
		
	}

}
