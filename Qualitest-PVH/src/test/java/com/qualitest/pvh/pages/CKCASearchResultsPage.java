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

public class CKCASearchResultsPage extends SearchResultsPage {
	
	@FindBy(xpath = "//*[@id=\"pvhOverlayContentWrapper\"]/div[2]")
	protected BaseElement popUpClose;

	private static final Logger LOGGER = LoggerFactory.getLogger(CKCASearchResultsPage.class);

	@Override
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

	@Override
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
		pageRefresh();
		if(productList.size() == 0) {
			return;
		}
		WebElement w = productList.get(0);
		LOGGER.info("Clicking first product: " + w.getAttribute("title") + " from search result ");
		clickOffPopUp();
		try{
		    Thread.sleep(3000);
		}
		catch(InterruptedException ex)
		{
		    Thread.currentThread().interrupt();
		}
		w.click();
	}
	
	@Override
	/**
	 * Method to select product from search result
	 */
	public void selectProduct(int num) {
		pageRefresh();
		WebElement w = productList.get(num-1);
		LOGGER.info("Clicking product: " + w.getAttribute("title") + " from search result ");
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
	 * Method to filter search product list based on provided price range
	 * @param price - Price Range e.g.: $0 - CAD $100 / CAD $200 - CAD $300
	 */
	public void filterSearchResultUsingPriceRange(String price) {
		pageRefresh();
		clickOffPopUp();
		pageRefresh();
		LOGGER.info("Clicking price filter option");
		priceFilterOption.withTimeoutOf(5, TimeUnit.SECONDS).waitUntilClickable().click();
		if(price.equalsIgnoreCase("$0 – CAD $100")) {
			LOGGER.info("Selecting $0 - CAD $100 price range option");
			find(By.xpath("//*[@id='0-cad-100']")).click();
		} else if (price.equalsIgnoreCase("CAD $100 - CAD $200")) {
			LOGGER.info("Selecting CAD $100 - CAD $200 price range option");
			find(By.xpath("//*[@id='cad-100-cad-200']")).click();
		} else if (price.equalsIgnoreCase("CAD $200 - CAD $300")) {
			LOGGER.info("Selecting CAD $200 - CAD $300 price range option");
			find(By.id("//*[@id='cad-200-cad-300']")).click();
		} else if (price.equalsIgnoreCase("CAD $300 - CAD $400")) {
			LOGGER.info("Selecting CAD $300 - CAD $400 price range option");
			find(By.id("//*[@id='cad-300-cad-400']")).waitUntilClickable().click();
		} else {
			LOGGER.info("Provided Price Range: " + price + " option is not available");
		}
	}
	
	/**
	 * Method to verify price of filtered product list is within provided price range
	 * @param priceRange - Price Range e.g.: $0 - CAD $100 / CAD $200 - CAD $300
	 */
	public void verifyFilteredProductPrice(String priceRange) {
		priceRange = priceRange.replace("CAD $", "");
		String[] price = priceRange.trim().split("-");
		int lowerLimit = Integer.parseInt(price[0].replace("$", "").trim());
		int upperLimit = Integer.parseInt(price[1].replace("$", "").trim());
		
		if(displayedPrice.size()>0) {
			for(int i=0; i< displayedPrice.size(); i++) {
				int dprice = Math.round(Float.parseFloat(displayedPrice.get(i).getText().replace("CAD $", "").split("-")[0]));
				LOGGER.info("Verifying displayed price of products: " + dprice + " is between " + lowerLimit + " and " + upperLimit);
				SA.assertThat((lowerLimit <= dprice) && (dprice <= upperLimit)).as("Displayed Price: " + dprice + " is within range: " + priceRange).isTrue();
			}
			SA.assertAll();
		}
	}
	
	/**
	 * Method to filter search product list using provided color
	 * @param color - Color e.g.: black / blue / green / neutral / ivory / red / white
	 */
	public void filterSearchResultUsingColor(String color) {
		
		pageRefresh();
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
	 * Method to filter search product list using provided size
	 * @param size - Size e.g.: s / m / l / xl / xxl / 4xl
	 */
	public void filterSearchResultUsingSize(String size) {
		
		pageRefresh();
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
		
		pageRefresh();
		clickOffPopUp();
		pageRefresh();
		
		LOGGER.info("Clicking collection filter option");
		collectionFilterOption.withTimeoutOf(5, TimeUnit.SECONDS).waitUntilClickable().click();
		
		switch(category){
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
		default:
				LOGGER.info("Provided Collection: " + category + " option is not available");
		}
		
	}
	
	/**
	 * Method to sort searched product list using provide price
	 * @param price - Price e.g.: Price Low to High / Price High to Low
	 */
	public void sortSearchResultUsingPrice(String price) {
		
		pageRefresh();
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
	
	/**
	 * Method to verify product price in search result is sorted based on provided price option
	 * @param priceRange - Price option e.g.: Price Low to High / Price High to Low
	 */
	public void verifyProductListIsSorted(String priceRange) {
		
		pageRefresh();
		
		boolean result = true;
		
		if(displayedPrice.size()>0 && priceRange.equalsIgnoreCase("Price Low to High")) {
			int previous = Math.round(Float.parseFloat(displayedPrice.get(0).getText().replace("CAD $", "").split("-")[0]));
			
			for(int i=1; i< displayedPrice.size(); i++) {
				int dprice = Math.round(Float.parseFloat(displayedPrice.get(i).getText().replace("CAD $", "").split("-")[0]));
				LOGGER.info("Verifying Price: " + previous + " is less than or equal to Price: " + dprice);
				if(previous > dprice) {
					result = false;
					break;
				}
				previous = dprice;
			}
			
			assertThat(result).as("Product List is sorted in ascending order").isTrue();
			
		} else if (displayedPrice.size()>0 && priceRange.equalsIgnoreCase("Price Hight to Low")) {
			int previous = Math.round(Float.parseFloat(displayedPrice.get(0).getText().replace("CAD $", "").split("-")[0]));
			
			for(int i=1; i< displayedPrice.size(); i++) {
				int dprice = Math.round(Float.parseFloat(displayedPrice.get(i).getText().replace("CAD $", "").split("-")[0]));
				LOGGER.info("Verifying Price: " + previous + " is greater than or equal to Price: " + dprice);
				if(previous < dprice) {
					result = false;
					break;
				}
				previous = dprice;
			}
			
			assertThat(result).as("Product List is sorted in descending order").isTrue();
			
		} 
		
	}
	
}
